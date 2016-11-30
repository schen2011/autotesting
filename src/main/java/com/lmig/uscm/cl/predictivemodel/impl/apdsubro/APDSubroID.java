/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Bhanu
 *
 */
public class APDSubroID
{
    private String claimNumber;
    private String claimID;
    private String claimPublicID;
    private String claimCreateTime;
    private String incidentID;
    private String exposureID;
    private String exposureNumber;
    
    //if false run model
    private Boolean referredToSub;  

    private Date modelExecTime;
    private Integer closeSubroActivity;
    private BigDecimal subroAmount;
    private String faultRatingDesc;
    
    /**
     * 
     * @return the claimNumber
     */
    public String getClaimNumber()
    {
        return claimNumber;
    }
    /**
     * 
     * @Sets the claimNumber
     */
    public void setClaimNumber(String claimNumber)
    {
        this.claimNumber = claimNumber;
    }
    /**
     * 
     * @return claimId
     */
    public String getClaimID()
    {
        return claimID;
    }
    /**
     * 
     * @Sets the claimID
     */
    public void setClaimID(String claimID)
    {
        this.claimID = claimID;
    }
    /**
     * 
     * @return claimPublicID
     */
    public String getClaimPublicID()
    {
        return claimPublicID;
    }
    /**
     * 
     * @Sets the claimPublicID
     */
    public void setClaimPublicID(String claimPublicID)
    {
        this.claimPublicID = claimPublicID;
    }
    /**
     * 
     * @return claimCreateTime
     */
    public String getClaimCreateTime()
    {
        return claimCreateTime;
    }
    /**
     * 
     * @Sets the claimCreateTime
     */
    public void setClaimCreateTime(String claimCreateTime)
    {
        this.claimCreateTime = claimCreateTime;
    }
    /**
     * 
     * @return incidentID
     */
    public String getIncidentID()
    {
        return incidentID;
    }
    /**
     * 
     * @Sets the incidentID
     */
    public void setIncidentID(String incidentID)
    {
        this.incidentID = incidentID;
    }
    /**
     * 
     * @return exposureID
     */
    public String getExposureID()
    {
        return exposureID;
    }
    /**
     * 
     * @Sets the exposureID
     */
    public void setExposureID(String exposureID)
    {
        this.exposureID = exposureID;
    }
    /**
     * 
     * @return exposureNumber
     */
    public String getExposureNumber()
    {
        return exposureNumber;
    }
    /**
     * 
     * @Sets the exposureNumber
     */
    public void setExposureNumber(String exposureNumber)
    {
        this.exposureNumber = exposureNumber;
    }
   /**
    * 
    * @return openSubChkLstNum
    */
  
    /**
     * 
     * @return modelExecTime
     */
    public Date getModelExecTime()
    {
        return modelExecTime;
    }
    /**
     * 
     * Sets the modelExecTime
     */
    public void setModelExecTime(Date modelExecTime)
    {
        this.modelExecTime = modelExecTime;
    }
    /**
     * @return the subroAmount
     */
    public BigDecimal getSubroAmount()
    {
        return subroAmount;
    }
    /**
     * Sets subroAmount.
     * 
     * @param     subroAmount the subroAmount to set
     */
    public void setSubroAmount(BigDecimal subroAmount)
    {
        this.subroAmount = subroAmount;
    }
    /**
     * @return the closeSubroActivity
     */
    public Integer getCloseSubroActivity()
    {
        return closeSubroActivity;
    }
    /**
     * Sets closeSubroActivity.
     * 
     * @param     closeSubroActivity the closeSubroActivity to set
     */
    public void setCloseSubroActivity(Integer closeSubroActivity)
    {
        this.closeSubroActivity = closeSubroActivity;
    }
    /**
     * @return the referredToSub
     */
    public Boolean getReferredToSub()
    {
        return referredToSub;
    }
    /**
     * Sets referredToSub.
     * 
     * @param     referredToSub the referredToSub to set
     */
    public void setReferredToSub(Boolean referredToSub)
    {
        this.referredToSub = referredToSub;
    }
    /**
     * @return the faultRatingDesc
     */
    public String getFaultRatingDesc()
    {
        return faultRatingDesc;
    }
    /**
     * Sets faultRatingDesc.
     * 
     * @param     faultRatingDesc the faultRatingDesc to set
     */
    public void setFaultRatingDesc(String faultRatingDesc)
    {
        this.faultRatingDesc = faultRatingDesc;
    }
}
