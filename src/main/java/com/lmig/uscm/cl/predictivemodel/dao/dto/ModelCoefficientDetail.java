/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author SamirKeco
 *
 */
public class ModelCoefficientDetail extends PredictiveModelBaseDTO implements Serializable
{
    private static final long serialVersionUID = 8870096350708900666L;
    private Integer id;
    private Integer modelId;
    private String coefficientKey;
    private String modelType;
    private BigDecimal modelValue;
    
    
    /**
     * @return the id
     */
    public Integer getId()
    {
        return id;
    }
    /**
     * Sets id.
     * 
     * @param     id the id to set
     */
    public void setId(Integer id)
    {
        this.id = id;
    }
    /**
     * @return the modelId
     */
    public Integer getModelId()
    {
        return modelId;
    }
    /**
     * Sets modelId.
     * 
     * @param     modelId the modelId to set
     */
    public void setModelId(Integer modelId)
    {
        this.modelId = modelId;
    }
    /**
     * @return the coefficientKey
     */
    public String getCoefficientKey()
    {
        return coefficientKey;
    }
    /**
     * Sets coefficientKey.
     * 
     * @param     coefficientKey the coefficientKey to set
     */
    public void setCoefficientKey(String coefficientKey)
    {
        this.coefficientKey = coefficientKey;
    }
    /**
     * @return the modelType
     */
    public String getModelType()
    {
        return modelType;
    }
    /**
     * Sets modelType.
     * 
     * @param     modelType the modelType to set
     */
    public void setModelType(String modelType)
    {
        this.modelType = modelType;
    }
    /**
     * @return the modelValue
     */
    public BigDecimal getModelValue()
    {
        return modelValue;
    }
    /**
     * Sets modelValue.
     * 
     * @param     modelValue the modelValue to set
     */
    public void setModelValue(BigDecimal modelValue)
    {
        this.modelValue = modelValue;
    }
    
}
