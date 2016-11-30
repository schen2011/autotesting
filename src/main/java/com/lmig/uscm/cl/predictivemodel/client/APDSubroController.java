package com.lmig.uscm.cl.predictivemodel.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.annotations.SerializedName;
import com.lmig.uscm.cl.predictivemodel.client.navigator.OrchestrationClient;
import com.lmig.uscm.cl.predictivemodel.client.setup.APDSubroMockSetup;
import com.lmig.uscm.cl.predictivemodel.enums.CoeffKey;
import com.lmig.uscm.cl.predictivemodel.enums.DataSource;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroDTO;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroNavigatorDTO;
import com.lmig.uscm.cl.predictivemodel.orchestration.APDSubroOrchestration;

@Controller
public class APDSubroController {

	@Autowired
	private CoefficientRepository coefficientRepository;

    APDSubroNavigatorDTO navDto;
    APDSubroDTO engnDto;
    Map<CoeffKey, String> dtoMap;
    
    @RequestMapping("/apd")
    public @ResponseBody String greeting() {
        navDto = new APDSubroMockSetup().setupDto();
        engnDto = new APDSubroDTO(navDto);
        dtoMap = engnDto.loadCoeffKeyDtoValueMap();
        
        OrchestrationClient orch = new OrchestrationClient();
        APDSubroOrchestration.getInstance().setDs(DataSource.JSON);
        boolean res = orch.executeAPDSubroOrchestration(navDto);
        
        return "Hello World";
    }
    
    
    
//
//    @RequestMapping("/greeting")
//    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
    
    @RequestMapping("/step2")
    public String step1(Model model) {
//    	List<String> list = new ArrayList<String>();
//    	list.add("Tom"); list.add("Jerry"); list.add("Billy");
//    	List<Person> pList = new ArrayList<>();
//    	Person p1 = new Person("X", "Y");
//    	Person p2 = new Person("A", "B");
//    	Person p3 = new Person("C", "J");
//    	pList.add(p1); pList.add(p2); pList.add(p3);
//    	model.addAttribute("namelist", list);
//    	model.addAttribute("message", "StepX");
//    	model.addAttribute("plist", pList);
//      return "step1";
    	List<Coefficient> list = coefficientRepository.findAll();
    	model.addAttribute("clist", list);
    	model.addAttribute("message", "Step");
    	return "step2";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam(value="name", required=true) String name) {
    	System.out.println("Name is been deleted" + name);
    	coefficientRepository.deleteByName(name);
    	return "redirect:/step1";
    }
    
    
    @RequestMapping("/readexcel")
    public String readexcel() throws IOException {
    	 String discrepFilePath = "/Users/stephenchen/Documents/workspace-sts-3.7.3.RELEASE/apdsubro-autotesting/test-data/ChanReviewDiscrep.xlsx";
    	 FileInputStream fileIn = new FileInputStream(
                 new File(discrepFilePath));
    	 XSSFWorkbook book = new XSSFWorkbook(fileIn);
         
    	 XSSFSheet sheet = book.getSheetAt(0);
         Iterator<Row> rowIterator = sheet.iterator();
         List<String> list = new ArrayList<String>();
         while(rowIterator.hasNext())
         {
             Row row = rowIterator.next();
             Iterator<Cell> cellIterator = row.cellIterator();
             StringBuilder sb = new StringBuilder();
             while(cellIterator.hasNext()) {
                 Cell cell = cellIterator.next();
                 sb.append(",");
                 String content = cell.toString();
                 sb.append(content);
             }
             list.add(sb.toString());
         }
         //System.out.println(sb.toString());
    	 return "index";
    }
    
    
    @RequestMapping("/people")
    @ResponseBody
    public Person people() {
    	Person p = new Person("May", "Key");
    	return p;
    }
    
    
    
    class Person 
    {
    	@SerializedName("First Name")
    	private String fname;
    	@SerializedName("Last Name")
    	private String lname;
    	public Person(String firstname, String lastname) {
    		this.fname = firstname;
    		this.lname = lastname;
    	}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		@Override
		public String toString() {
			return "Person [fname=" + fname + ", lname=" + lname + "]";
		}
		
    	
    }
}
