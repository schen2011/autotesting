/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.dao.dto;

/**
 * @author SamirKeco
 *
 */
public class PredictiveModelRequest extends PredictiveModelBaseDTO
{
    private String modelName;
    private String modelExecutionMode;
    
    /**
     * @return the modelName
     */
    public String getModelName()
    {
        return modelName;
    }
    /**
     * Sets modelName.
     * 
     * @param     modelName the modelName to set
     */
    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }
    /**
     * @return the modelExecutionMode
     */
    public String getModelExecutionMode()
    {
        return modelExecutionMode;
    }
    /**
     * Sets modelExecutionMode.
     * 
     * @param     modelExecutionMode the modelExecutionMode to set
     */
    public void setModelExecutionMode(String modelExecutionMode)
    {
        this.modelExecutionMode = modelExecutionMode;
    }
    
}
