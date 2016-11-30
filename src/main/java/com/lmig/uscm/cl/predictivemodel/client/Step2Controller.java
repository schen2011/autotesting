package com.lmig.uscm.cl.predictivemodel.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lmig.uscm.cl.predictivemodel.client.navigator.OrchestrationClient;
import com.lmig.uscm.cl.predictivemodel.client.setup.APDSubroMockSetup;
import com.lmig.uscm.cl.predictivemodel.client.storage.StorageService;
import com.lmig.uscm.cl.predictivemodel.enums.CoeffKey;
import com.lmig.uscm.cl.predictivemodel.enums.DataSource;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroDTO;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroNavigatorDTO;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroOutput;
import com.lmig.uscm.cl.predictivemodel.orchestration.APDSubroOrchestration;

@Controller
public class Step2Controller {
	
	private String coeffName;
	private APDSubroNavigatorDTO navDTO;
    private APDSubroDTO engnDto;
    private Map<CoeffKey, String> dtoMap;
    private int totaltest;
    List<TestCase> testcasesList = new ArrayList<TestCase>();
    @Autowired
    private TestCaseRepository repository;
    
	@Autowired
    private final StorageService storageService;
	
    @Autowired
    public Step2Controller(StorageService storageService) {
        this.storageService = storageService;
    }
    
	@GetMapping("/step2")
    public String step2(@RequestParam(value="name", required=true) String filename) {
		this.coeffName = filename;
        return "step2";
    }
	
    @PostMapping("/step2")
    public String step2(@RequestParam("file") MultipartFile file,
    		Model model) 
    		throws IOException 
    {
        storageService.store(file);
        String filepath = storageService.getFileLoc() + "/" + file.getOriginalFilename();
        FileInputStream fileIn = 
        		new FileInputStream(new File(filepath));
        XSSFWorkbook book = new XSSFWorkbook(fileIn);      
        Map<String, Map<String, String>> diffMap =
				loadCoefficients(book);	
        Map<CoeffRes, LinkedHashMap<String, String>> resultMap =
				loadCoefficientsResults(book);	
        //CoeffRes cRes = new CoeffRes("1.0", "Prob");
        //LinkedHashMap<String, String> map = resultMap.get(cRes);

		Set<String> sets = diffMap.keySet();
        for (String key : sets) 
        {
        	if (key == null || key.equals("")) {
        		continue;
        	}
        	new APDSubroMockSetup();
			navDTO = APDSubroMockSetup.setupDto();
        	loadNavDto(diffMap, key);
            this.engnDto = new APDSubroDTO(navDTO);
            dtoMap = engnDto.loadCoeffKeyDtoValueMap();
            OrchestrationClient orch = new OrchestrationClient();
            APDSubroOrchestration.getInstance().setDs(DataSource.JSON);
            APDSubroOutput output = orch.executeAPDSubroOrchestration(navDTO, true);
            if (!output.getProbabilityScore().equals(diffMap.get(key).get("Probability")) 
            		|| 
        		!output.getRecoveryamountScore().equals(diffMap.get(key).get("CondRecovery")))
            {
            	//System.out.println("Not Match");
            	findDifferentCoeffs(output, diffMap, resultMap, key);
            
            }
        }
        model.addAttribute("filename", this.coeffName);
        model.addAttribute("totaltest", this.totaltest);
        List<TestCase> testcases = repository.findTestCasesByFileName(this.coeffName);
        model.addAttribute("failedtest", testcases.size());
        model.addAttribute("testcases", testcases);
        return "step3";
    }


    class CoeffRes {
    	private String testcase;
    	private String modeltype;
    	public CoeffRes()
    	{
    	}
    	public CoeffRes(String test, String model)
    	{
    		this.testcase = test;
    		this.modeltype = model;
    	}
		public String getTestcase() {
			return testcase;
		}
		public void setTestcase(String testcase) {
			this.testcase = testcase;
		}
		public String getModeltype() {
			return modeltype;
		}
		public void setModeltype(String modeltype) {
			this.modeltype = modeltype;
		}
		
	    public boolean match(CoeffRes obj) {
	    	if (obj.getModeltype().equals(this.modeltype)
	    			&& obj.getTestcase().equals(this.testcase))
	    	{
	    		return true;
	    	}
	    	else{
	    		return false;
	    	}
	    }
    }

    
	private void findDifferentCoeffs(APDSubroOutput output, Map<String, Map<String, String>> diffMap,
			Map<CoeffRes, LinkedHashMap<String, String>> resultMap, String key) 
	{
		TestCase testcase = new TestCase();
		if (resultMap.containsKey(""))
			resultMap.remove("");
		this.totaltest = resultMap.size();
		for(CoeffRes ckey: resultMap.keySet()) 
		{
			String tcase = ckey.testcase;
			testcase.setTestcase(tcase);
			testcase.setFilename(this.coeffName);
        	if (ckey == null || ckey.equals("") || tcase.equals("")) {
        		continue;
        	}
			LinkedHashMap<String, String> map;
			if (!output.getProbabilityScore().equals(diffMap.get(key).get("Probability")))
			{
				CoeffRes coeff = new CoeffRes(key, "Prob");
				if (coeff.match(ckey)) 
				{
					CoefficientRaw coeffDiff = new CoefficientRaw();
					map = resultMap.get(ckey);
					Map<String, BigDecimal> usedMap = output.getCoefficientUsedProb();
					coeffDiff = checkDiff(usedMap, map);
					testcase.setCoeff(coeffDiff);	
					testcase.setModelType("Probability");
					testcase.setTestdate(new Date());
					repository.save(testcase);
				}
			}
			
			if (!output.getProbabilityScore().equals(diffMap.get(key).get("CondRecovery")))
			{
				CoeffRes coeff = new CoeffRes(key, "Reco");
				if (coeff.match(ckey)) 
				{
					CoefficientRaw coeffDiff = new CoefficientRaw();
					map = resultMap.get(ckey);
					Map<String, BigDecimal> usedMap = output.getCoefficientUsedProb();
					coeffDiff = checkDiff(usedMap, map);
					testcase.setCoeff(coeffDiff);
					testcase.setModelType("Recovery");
					testcase.setTestdate(new Date());
					repository.save(testcase);
				}
			}
		}	
	}
    
    
	private CoefficientRaw checkDiff(Map<String, BigDecimal> usedMap, LinkedHashMap<String, String> map) {
		CoefficientRaw coeffDiff = new CoefficientRaw();
		for (String s : usedMap.keySet())
		{
			String val = "";
			if (s.contains("SEVERITY"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("Intercept");
				if (!mapVal.equals(val))
				{
					coeffDiff.setServerityType(val);
				}
			}
			else if (s.contains("RENTALIND"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("vehicleRentalInd");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("TOTALLOSSIND"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("totalLossInd");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("INITIALPOINTIMPACT"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("initialPointOfImpactDesc");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("LOSSCAUSETYPE"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("lossCauseTypeDesc");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("MULTICARIND"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("multiCarInd");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("DRIVERAGE_SPLINE_A0"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("A0");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("DRIVERAGE_SPLINE_A1"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("A1");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("DRIVERAGE_SPLINE_A2"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("A2");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("DRIVERAGE_SPLINE_A3"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("A3");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("DRIVERAGE_SPLINE_A4"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("A4");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("VEHICLEMAKE"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("vehicleMake");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("VEHICLEYEAR"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("vehicleYear");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("DEDUCTIBLEWAIVED"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("deductibleWaiverInd");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("DEDUCTIBLETODATE"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("deductibleAmountPaid");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("COVERAGEDEDUCTIBLE"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("coverageDeductible");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("JURISDICTION"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("jurisdictionGroup");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("GROSSLOSS"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("grossLoss");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("CLAIMTIER"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("claimTierDesc");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
			else if (s.contains("HITANDRUN"))
			{
				val = usedMap.get(s).toPlainString();
				String mapVal = map.get("hitAndRunInd");
				if (!mapVal.equals(val))
				{
					coeffDiff.setVehicleRentalInd(val);
				}
			}
		}
		return coeffDiff;
	}

	private Map<CoeffRes, LinkedHashMap<String, String>> loadCoefficientsResults(XSSFWorkbook book) {
        Map<CoeffRes, LinkedHashMap<String, String>> resMap = 
        		new HashMap<CoeffRes, LinkedHashMap<String, String>>();		
        
        XSSFSheet sheet = book.getSheet("BatchTestCalc");
        Iterator<Row> rowIterator = sheet.iterator();
        List<String> keys = new LinkedList<>();
        Row toprow = rowIterator.next();
        Iterator<Cell> topCells = toprow.cellIterator();
        while (topCells.hasNext()) {
            keys.add(topCells.next().toString());
        }
        boolean isProb = true;
        //CoeffRes coeffRes = new CoeffRes();
        while(rowIterator.hasNext())
        {
            CoeffRes coeffRes = new CoeffRes();
        	Row row = rowIterator.next();
        	Iterator<Cell> cellIterator = row.cellIterator();
        	String testcase = "";
        	Cell cellfirst = cellIterator.next();
            if (cellfirst.getCellType() == Cell.CELL_TYPE_FORMULA)
            	testcase = String.valueOf(cellfirst.getNumericCellValue());
            else
            	testcase = cellfirst.toString();
            
            if (testcase == "")
            {
            	continue;
            }
            
        	int index = 0;
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
        	while(cellIterator.hasNext()) {
        		Cell cell = cellIterator.next();
        		String cellVal = "";
        		if(cell.getCellType() == Cell.CELL_TYPE_FORMULA) 
        		{
        			switch(cell.getCachedFormulaResultType()) {
    	             	case Cell.CELL_TYPE_NUMERIC:
    	             		cellVal = String.valueOf(cell.getNumericCellValue());
    	             		break;
    	             	case Cell.CELL_TYPE_STRING:
    	             		cellVal = cell.getRichStringCellValue().toString();
    	             		break;
	    	         }
        		} 
        		else
        		{
        			cellVal = cell.toString();
        		}
                map.put(keys.get(++index), cellVal);
        	}
        	coeffRes.setTestcase(testcase);
        	if (isProb){
        		coeffRes.setModeltype("Prob");
        	}
        	else {
        		coeffRes.setModeltype("Reco");
        	}
        	isProb = !isProb;
        	resMap.put(coeffRes, map);
        }
        return resMap;
	}

	private void loadNavDto(Map<String
    		, Map<String, String>> diffMap, String key) 
	{
		//APDSubroNavigatorDTO navDTO = new APDSubroNavigatorDTO();
    	Map<String, String> map = diffMap.get(key);
    	for (Entry<String, String> set : map.entrySet())
    	{
    		if (set.getKey().equals("severityTypeDesc"))
    		{
    	        navDTO.setSeverityTypeDesc(severityTypeHelper(set.getValue()));
    		}
    		else if (set.getKey().equals("vehicleRentalInd"))
    		{
    			navDTO.setVehicleRentalInd(rentalHelper(set.getValue()));
    		}
    		else if (set.getKey().equals("totalLossInd"))
    		{
    			 navDTO.setTotalLossInd(boolHelper(set.getValue()));
    		}
    		else if (set.getKey().equals("initialPointOfImpactDesc"))
    		{
    	        navDTO.setInitialPointOfImpactDesc(impactHelper(set.getValue()));
    		}
    		else if (set.getKey().equals("lossCauseTypeDesc"))
    		{
    	        navDTO.setLossCauseTypeDesc(lossCauseTypeHelper(set.getValue()));
    		}
    		else if (set.getKey().equals("multiCarInd"))
    		{
    	        navDTO.setMultiCarInd(multiCarHelper(set.getValue()));
    		}
    		else if (set.getKey().equals("primaryDriverAge"))
    		{
    	        navDTO.setPrimaryDriverAge(Double.valueOf(set.getValue()).intValue());
    		}
    		else if (set.getKey().equals("vehicleMake"))
    		{
    	        navDTO.setVehicleMake(vehicleMakerHelper(set.getValue()));
    		}
    		else if (set.getKey().equals("vehicleYear"))
    		{
    	        navDTO.setVehicleYear(Double.valueOf(set.getValue()).intValue());
    		}
    		else if (set.getKey().equals("deductibleWaiverInd"))
    		{
    	        navDTO.setDeductibleWaiverInd(boolHelper(set.getValue()));
    		}
    		else if (set.getKey().equals("deductibleAmountPaid"))
    		{
    	        navDTO.setDeductibleAmountPaid(new BigDecimal(set.getValue()));
    		}
    		else if (set.getKey().equals("coverageDeductible"))
    		{
    	        navDTO.setCoverageDeductible(new BigDecimal(set.getValue()));
    		}
    		else if (set.getKey().equals("jurisdictionGroup"))
    		{
    	        navDTO.setJurisdictionGroup(set.getValue());
    		}
    		else if (set.getKey().equals("grossLoss"))
    		{
    	        navDTO.setGrossLoss(new BigDecimal(set.getValue()));       
    		}
    		else if (set.getKey().equals("claimTierDesc"))
    		{
    	        navDTO.setClaimTierDesc(claimTierHelper(set.getValue()));
    		}
    		else if (set.getKey().equals("hitAndRunInd"))
    		{
    			navDTO.setHitAndRunInd(boolHelper(set.getValue()));
    		}
    	}
        //return navDTO;
	}

    
    private Map<String, Map<String, String>> loadCoefficients(XSSFWorkbook book) 
	{
        Map<String, Map<String, String>> diffMap =				
        		new HashMap<>();
        XSSFSheet sheet = book.getSheet("BatchTest");
        Iterator<Row> rowIterator = sheet.iterator();
        
        List<String> keys = new LinkedList<>();

        Row toprow = rowIterator.next();
        Iterator<Cell> topCells = toprow.cellIterator();
        while (topCells.hasNext()) {
            keys.add(topCells.next().toString());
        }
        
        while(rowIterator.hasNext())
        {
        	Row row = rowIterator.next();
        	Iterator<Cell> cellIterator = row.cellIterator();
            String testcase = cellIterator.next().toString();
            int index = 0;
            Map<String, String> map = new LinkedHashMap<>();
        	while(cellIterator.hasNext()) {
        		Cell cell = cellIterator.next();
        		String cellVal = "";
        		if(cell.getCellType() == Cell.CELL_TYPE_FORMULA) 
        		{
        			//System.out.println("Formula is " + cell.getCellFormula());
        			switch(cell.getCachedFormulaResultType()) {
    	             	case Cell.CELL_TYPE_NUMERIC:
    	             		//System.out.println("Last evaluated as: " + cell.getNumericCellValue());
    	             		cellVal = String.valueOf(cell.getNumericCellValue());
    	             		break;
    	             	case Cell.CELL_TYPE_STRING:
    	             		//System.out.println("Last evaluated as \"" + cell.getRichStringCellValue() + "\"");
    	             		cellVal = cell.getRichStringCellValue().toString();
    	             		break;
	    	         }
        		} 
        		else
        		{
        			cellVal = cell.toString();
        		}
                map.put(keys.get(++index), cellVal);
        	}
        	diffMap.put(testcase, map);
        }
        return diffMap;
	}

    private String claimTierHelper(String val)
    {
    	String res = "";
    	if (res.equals("Low Severity"))
    	{
    		res = "low";
    	}
    	else if (res.equals("Medium Severity"))
    	{
    		res = "medium";
    	}
    	else 
    	{
    		res = "Default";
    	}
    	return res;
    }
    
    private String vehicleMakerHelper(String val)
    {
    	String res = "";
    	if (val.equals("Honda"))
    	{
    		res = "HOND";
    	}
    	
    	return res;
    }
    
    private String severityTypeHelper(String val)
    {
    	String res;
    	if (val.equals("Severe"))
    	{
    		res = "severe-gen";
    	}
    	else if (val.equals("Medium"))
    	{
    		res = "moderate-gen";
    	}
    	else if (val.equals("Unknow"))
    	{
    		res = "unknown";
    	}
    	else
    		res = "Default";
    	
    	return res;
    }
    
    private String impactHelper(String val)
    {
    	String res = val.split("-")[0].trim();
    	char[] arr = res.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	if (arr[0] != '0') 
    	{
    		sb.append(arr[0]);
    	}
    	sb.append(arr[1]);
    	return sb.toString();
    }
    
    private String lossCauseTypeHelper(String val) 
    {
    	String res = "";
    	if (val.equals("Another Vehicle Hit Parked Insured"))
    	{
    		res = "insdparkedHit";
    	}
    	else if (val.equals("Another Vehicle Rear-Ended Insured"))
    	{
    		res = "insdhitinrear";
    	}
    	return res;
    }
    
    private Integer multiCarHelper(String val)
    {
        Integer out = null;
        if(val == null)
        {
        }
        else if(val.equalsIgnoreCase("y"))
        {
            out = 2;
        }
        else
        {
            out = 1;
        }
        return out;
    }
    private Boolean boolHelper(String val)
    {
        Boolean out = null;
        if (val.equalsIgnoreCase("y"))
        {
            out = true;
        }
        else
        {
            out = false;
        }
        return out;
    }
    private Integer rentalHelper(String val)
	{
		Integer out = null;
		if(val == null)
		{
		}
		else if(val.equalsIgnoreCase("y"))
		{
		    out = 1;
		}
		else
		{
		    out = 0;
		}
		return out;
	}
}
