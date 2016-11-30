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
public enum PredictiveModel
{
    PROP_CHNL_PRED_MDL("Property Channeling Predictive Model"),
    BODILY_INJURY_PRED_IMPL("Bodily Injury Predictive Model"),
    REPAIR_TIME_PRED_MDL("Repair Time Predictive Model"),
    APD_SUBRO_PRED_MDL_A("APD Subrogation Predictive Model A"),
    APD_SUBRO_PRED_MDL_B("APD Subrogation Predictive Model B");
    

    private String desc;
    /**
     * 
     * @param desc
     */
    private PredictiveModel(String desc)
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