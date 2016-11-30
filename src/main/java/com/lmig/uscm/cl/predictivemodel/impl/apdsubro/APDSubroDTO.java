/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;

import java.util.HashMap;
import java.util.Map;

import com.lmig.uscm.cl.predictivemodel.enums.CoeffKey;
import com.lmig.uscm.cl.predictivemodel.intf.IPredictiveModelDTO;

/**
 * 
 * @author Chris Daub
 *
 */
public class APDSubroDTO implements IPredictiveModelDTO
{
    
    private transient DTOHelperMethods helper = new DTOHelperMethods();
    private Map<CoeffKey, String> coeffKeyDtoValueMap = null;
    private transient APDSubroID idInfo = null;
    private transient APDSubroNavigatorDTO navDto = null;
    
    /**
     * Constructor
     * @param navDto
     */
    public APDSubroDTO(APDSubroNavigatorDTO navDto)
    {
        this.idInfo = navDto.getIdInfo();
        this.navDto = navDto;
    }
    
   /**
    * 
    * @return
    */
    public Map<CoeffKey, String> loadCoeffKeyDtoValueMap()
    {
        coeffKeyDtoValueMap = new HashMap<CoeffKey, String>();
        
        //Initialize Severity
        String severity = helper.nullCheck(navDto.getSeverityTypeDesc());
        coeffKeyDtoValueMap.put(CoeffKey.SEVERITY1, severity);
        coeffKeyDtoValueMap.put(CoeffKey.SEVERITY2, severity);
        coeffKeyDtoValueMap.put(CoeffKey.SEVERITY3, severity);
        coeffKeyDtoValueMap.put(CoeffKey.SEVERITY4, severity);
        
        //Initialize Rental Indicator
        String rental = helper.rental(navDto.getVehicleRentalInd());
        coeffKeyDtoValueMap.put(CoeffKey.RENTALIND1, rental);
        coeffKeyDtoValueMap.put(CoeffKey.RENTALIND2, rental);
        coeffKeyDtoValueMap.put(CoeffKey.RENTALIND3, rental);
        
        //Initialize Total Loss Indicator
        String totalLoss = helper.trueFalse(navDto.getTotalLossInd());
        coeffKeyDtoValueMap.put(CoeffKey.TOTALLOSSIND1, totalLoss);
        coeffKeyDtoValueMap.put(CoeffKey.TOTALLOSSIND2, totalLoss);
        coeffKeyDtoValueMap.put(CoeffKey.TOTALLOSSIND3, totalLoss);
        
        //Initialize Initial Point of Impact
        String initImpact = helper.nullCheck(navDto.getInitialPointOfImpactDesc());
        for (int i = 1; i < 15; i++)
        {
            CoeffKey key = CoeffKey.valueOf("INITIALPOINTIMPACT" + i);
            coeffKeyDtoValueMap.put(key, initImpact);   
        }
        
        //Initialize Loss Cause Type
        String lossType = helper.lossCause(navDto.getLossCauseTypeDesc());
        for (int i = 1; i < 17; i++)
        {
            CoeffKey key = CoeffKey.valueOf("LOSSCAUSETYPE" + i);
            coeffKeyDtoValueMap.put(key, lossType);   
        }
        
        //Initialize Multiple Car Indicator
        String multiCarInd = helper.multiCar(navDto.getMultiCarInd());
        coeffKeyDtoValueMap.put(CoeffKey.MULTICARIND1, multiCarInd);
        coeffKeyDtoValueMap.put(CoeffKey.MULTICARIND2, multiCarInd);
        coeffKeyDtoValueMap.put(CoeffKey.MULTICARIND3, multiCarInd);
        
        //Initialize Vehicle Make
        String vehicleMake = helper.vehicleMake(navDto.getVehicleMake());
        for (int i = 1; i < 21; i++)
        {
            CoeffKey key = CoeffKey.valueOf("VEHICLEMAKE" + i);
            coeffKeyDtoValueMap.put(key, vehicleMake);
        }
        
        //Initialize Vehicle Year
        String vehicleYear = helper.vehicleYear(navDto.getVehicleYear());
        coeffKeyDtoValueMap.put(CoeffKey.VEHICLEYEAR1, vehicleYear);
        
        //Initialize Deductible Waiver Indicator
        String deductibleWaived = helper.trueFalse(navDto.getDeductibleWaiverInd());
        coeffKeyDtoValueMap.put(CoeffKey.DEDUCTIBLEWAIVED1, deductibleWaived);
        coeffKeyDtoValueMap.put(CoeffKey.DEDUCTIBLEWAIVED2, deductibleWaived);
        coeffKeyDtoValueMap.put(CoeffKey.DEDUCTIBLEWAIVED3, deductibleWaived);
        
        //Initialize Jurisdiction 
        String jurisdiction = helper.jurisdiction(navDto.getJurisdictionGroup());
        for (int i = 1; i < 6; i++)
        {
            CoeffKey key = CoeffKey.valueOf("JURISDICTION" + i);
            coeffKeyDtoValueMap.put(key, jurisdiction);
        }
        
        //Initialize Deductible to Date
        String deductibleToDate = navDto.getDeductibleAmountPaid().toPlainString();
        coeffKeyDtoValueMap.put(CoeffKey.DEDUCTIBLETODATE1, deductibleToDate);
        coeffKeyDtoValueMap.put(CoeffKey.DEDUCTIBLETODATE2, deductibleToDate);
        
        //Initialize Coverage Deductible
        String coverageDecductible = navDto.getCoverageDeductible().toPlainString();
        coeffKeyDtoValueMap.put(CoeffKey.COVERAGEDEDUCTIBLE1, coverageDecductible);
        coeffKeyDtoValueMap.put(CoeffKey.COVERAGEDEDUCTIBLE2, coverageDecductible);
        
        //Initialize Gross Loss
        String grossLoss = navDto.getGrossLoss().toPlainString();
        coeffKeyDtoValueMap.put(CoeffKey.GROSSLOSS1, grossLoss);
        coeffKeyDtoValueMap.put(CoeffKey.GROSSLOSS2, grossLoss);
        
        //Initialize Driver Age
        String driverAge = helper.age(navDto.getPrimaryDriverAge());
        for (int i = 0; i < 5; i++)
        {
            CoeffKey key = CoeffKey.valueOf("DRIVERAGEA" + i);
            coeffKeyDtoValueMap.put(key, driverAge);
        }
        
        //Initialize Claim Tier
        String claimTier = helper.nullCheck(navDto.getClaimTierDesc());
        coeffKeyDtoValueMap.put(CoeffKey.CLAIMTIER1, claimTier);
        coeffKeyDtoValueMap.put(CoeffKey.CLAIMTIER2, claimTier);
        coeffKeyDtoValueMap.put(CoeffKey.CLAIMTIER3, claimTier);
        
        //Initialize Hit and Run
        String hitNRun = helper.trueFalse(navDto.getHitAndRunInd());
        coeffKeyDtoValueMap.put(CoeffKey.HITANDRUN1, hitNRun);
        coeffKeyDtoValueMap.put(CoeffKey.HITANDRUN2, hitNRun);
        coeffKeyDtoValueMap.put(CoeffKey.HITANDRUN3, hitNRun);
        
        return coeffKeyDtoValueMap;
    }
    /**
     * 
     * @return
     */
    public Map<CoeffKey, String> getCoeffKeyDtoValueMap()
    {
        return this.coeffKeyDtoValueMap;
    }
    /**
     * 
     * @param map
     */
    public void setCoeffKeyDtoValueMap(Map<CoeffKey, String> map)
    {
        this.coeffKeyDtoValueMap = map;
    }
    /**
     * @return the idInfo
     */
    public APDSubroID getIdInfo()
    {
        return idInfo;
    }

    /**
     * Sets idInfo.
     * 
     * @param     idInfo the idInfo to set
     */
    public void setIdInfo(APDSubroID idInfo)
    {
        this.idInfo = idInfo;
    }
    /**
     * 
     * @return
     */
    public APDSubroNavigatorDTO getNavDto()
    {
        return this.navDto;
    }

}
