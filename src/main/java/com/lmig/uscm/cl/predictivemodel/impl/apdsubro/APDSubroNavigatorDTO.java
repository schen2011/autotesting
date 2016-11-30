/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;
import java.math.BigDecimal;

import com.lmig.uscm.cl.predictivemodel.intf.INavigatorDTO;
/**
 * 
 * @author Bhanu
 *
 */
public class APDSubroNavigatorDTO implements INavigatorDTO
{
    private transient APDSubroID idInfo;
    private String severityTypeDesc;
    private Integer vehicleRentalInd;
    private Boolean totalLossInd;
    private String initialPointOfImpactDesc;
    private String lossCauseTypeDesc;
    private Integer multiCarInd;
    private Integer primaryDriverAge;
    private String vehicleMake;
    private Integer vehicleYear;
    private Boolean deductibleWaiverInd;
    private BigDecimal deductibleAmountPaid;
    private BigDecimal coverageDeductible;
    private String jurisdictionGroup;
    private BigDecimal grossLoss; 
    private String claimTierDesc;
    private BigDecimal insuredLiability;
    private String userNNumber;
    private Boolean hitAndRunInd;


   /**
    * 
    * @return idInfo
    */
    public APDSubroID getIdInfo()
    {
        return idInfo;
    }
    /**
     * 
     * @Sets the idInfo
     */
    public void setIdInfo(APDSubroID idInfo)
    {
        this.idInfo = idInfo;
    }
    
    /**
     * 
     * @return severityTypeDesc
     */
    public String getSeverityTypeDesc()
    {
        return severityTypeDesc;
    }
    /**
     * 
     * Sets severityTypeDesc
     */
    public void setSeverityTypeDesc(String severityTypeDesc)
    {
        this.severityTypeDesc = severityTypeDesc;
    }
    /**
     * 
     * @return vehicleRentalInd
     */
    public Integer getVehicleRentalInd()
    {
        return vehicleRentalInd;
    }
    /**
     * 
     * @Sets vehicleRentalInd
     */
    public void setVehicleRentalInd(Integer vehicleRentalInd)
    {
        this.vehicleRentalInd = vehicleRentalInd;
    }
    /**
     * 
     * @return totalLossInd
     */
    public Boolean getTotalLossInd()
    {
        return totalLossInd;
    }
    /**
     * 
     * @Sets totalLossInd
     */
    public void setTotalLossInd(Boolean totalLossInd)
    {
        this.totalLossInd = totalLossInd;
    }
    /**
     * 
     * @return initialPointOfImpactDesc
     */
    public String getInitialPointOfImpactDesc()
    {
        return initialPointOfImpactDesc;
    }
    /**
     * 
     * Sets initialPointOfImpactDesc
     */
    public void setInitialPointOfImpactDesc(String initialPointOfImpactDesc)
    {
        this.initialPointOfImpactDesc = initialPointOfImpactDesc;
    }
    /**
     * 
     * @return lossCauseTypeDesc
     */
    public String getLossCauseTypeDesc()
    {
        return lossCauseTypeDesc;
    }
    /**
     * 
     * @Sets lossCauseTypeDesc
     */
    public void setLossCauseTypeDesc(String lossCauseTypeDesc)
    {
        this.lossCauseTypeDesc = lossCauseTypeDesc;
    }
    /**
     * 
     * @return multiCarInd
     */
    public Integer getMultiCarInd()
    {
        return multiCarInd;
    }
    /**
     * 
     * Sets multiCarInd
     */
    public void setMultiCarInd(Integer multiCarInd)
    {
        this.multiCarInd = multiCarInd;
    }
    /**
     * 
     * @return primaryDriverAge
     */
    public Integer getPrimaryDriverAge()
    {
        return primaryDriverAge;
    }
    /**
     * 
     * Sets primaryDriverAge
     */
    public void setPrimaryDriverAge(Integer primaryDriverAge)
    {
        this.primaryDriverAge = primaryDriverAge;
    }
    /**
     * 
     * @return vehicleMake
     */
    public String getVehicleMake()
    {
        return vehicleMake;
    }
    /**
     * 
     * Sets vehicleMake
     */
    public void setVehicleMake(String vehicleMake)
    {
        this.vehicleMake = vehicleMake;
    }
    /**
     * 
     * @return vehicleYear
     */
    public Integer getVehicleYear()
    {
        return vehicleYear;
    }
    /**
     * 
     * Sets vehicleYear
     */
    public void setVehicleYear(Integer vehicleYear)
    {
        this.vehicleYear = vehicleYear;
    }
    /**
     * 
     * @return deductibleWaiverInd
     */
    public Boolean getDeductibleWaiverInd()
    {
        return deductibleWaiverInd;
    }
    /**
     * 
     * Sets deductibleWaiverInd
     */
    public void setDeductibleWaiverInd(Boolean deductibleWaiverInd)
    {
        this.deductibleWaiverInd = deductibleWaiverInd;
    }
    /**
     * 
     * @return deductibleAmountPaid
     */
    public BigDecimal getDeductibleAmountPaid()
    {
        return deductibleAmountPaid;
    }
    /**
     * 
     * Sets deductibleAmountPaid
     */
    public void setDeductibleAmountPaid(BigDecimal deductibleAmountPaid)
    {
        this.deductibleAmountPaid = deductibleAmountPaid;
    }
    /**
     * 
     * @return coverageDeductible
     */
    public BigDecimal getCoverageDeductible()
    {
        return coverageDeductible;
    }
    /**
     * 
     * Sets coverageDeductible
     */
    public void setCoverageDeductible(BigDecimal coverageDeductible)
    {
        this.coverageDeductible = coverageDeductible;
    }
    /**
     * 
     * @return jurisdictionGroup
     */
    public String getJurisdictionGroup()
    {
        return jurisdictionGroup;
    }
    /**
     * 
     * Sets jurisdictionGroup
     */
    public void setJurisdictionGroup(String jurisdictionGroup)
    {
        this.jurisdictionGroup = jurisdictionGroup;
    }
    /**
     * 
     * @return grossLoss
     */
    public BigDecimal getGrossLoss()
    {
        return grossLoss;
    }
    /**
     * 
     * Sets grossLoss
     */
    public void setGrossLoss(BigDecimal val)
    {
        this.grossLoss = val;
    }
    /**
     * 
     * @return claimTierDesc
     */
    public String getClaimTierDesc()
    {
        return claimTierDesc;
    }
    /**
     * 
     * Sets claimTierDesc
     */
    public void setClaimTierDesc(String claimTierDesc)
    {
        this.claimTierDesc = claimTierDesc;
    }
    /**
     * 
     * @return typicalValue
     */
    /**
     * @return the insuredLiability
     */
    public BigDecimal getInsuredLiability()
    {
        return insuredLiability;
    }
    /**
     * Sets insuredLiability.
     * 
     * @param     insuredLiability the insuredLiability to set
     */
    public void setInsuredLiability(BigDecimal insuredLiability)
    {
        this.insuredLiability = insuredLiability;
    }
    /**
     * @return the userNNumber
     */
    public String getUserNNumber()
    {
        return userNNumber;
    }
    /**
     * Sets userNNumber.
     * 
     * @param     userNNumber the userNNumber to set
     */
    public void setUserNNumber(String userNNumber)
    {
        this.userNNumber = userNNumber;
    }
    /**
     * @return the hitAndRunInd
     */
    public Boolean getHitAndRunInd()
    {
        return hitAndRunInd;
    }
    /**
     * Sets hitAndRunInd.
     * 
     * @param     hitAndRunInd the hitAndRunInd to set
     */
    public void setHitAndRunInd(Boolean hitAndRunInd)
    {
        this.hitAndRunInd = hitAndRunInd;
    }
}
