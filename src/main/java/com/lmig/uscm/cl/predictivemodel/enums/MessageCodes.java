/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.enums;

/**
 * @author AbhiVerma
 *
 */
public enum MessageCodes
{
    EMS_INPUT_ERROR("EMS Value not passed in correctly"), 
    INCIDENTLIMIT_TRANSFER_ERROR("Incident Limit missing or passed incorrectly"),
    DEDUCTIBLE_TRANSFER_ERROR("Deductible missing or passed incorrectly"),
    BITVALUE_TRANSFER_ERROR("Invalid bit value"),
    ENGINE_CALCULATOR_ERROR("Engine Calculator Error - will use a value of 0 for this coefficient"),
    PREDICTIVE_MODEL_OUTPUT_CHOSEN("Predictive Model Output Chosen"),
    DROOLS_MODEL_OUTPUT_CHOSEN("Drools Model Output Chosen"), 
    NULL_STATE_ERROR("State missing or passed incorrectly"), 
    POLICY_PRGM_SQUIGGLE("Policy Program Squiggle Passed"), 
    POLICY_PRGM_NULL("Policy Program null or passed incorrectly");

    private String desc;
    /**
     * 
     * @param desc
     */
    private MessageCodes(String desc)
    {
        this.desc = desc;
    }
    /**
     * @return the desc
     */
    public String getDesc()
    {
        return desc;
    }
    /**
     * Sets desc.
     * 
     * @param     desc the desc to set
     */
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    
}
