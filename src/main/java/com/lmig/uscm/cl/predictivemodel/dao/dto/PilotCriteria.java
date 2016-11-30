/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.dao.dto;

import java.io.Serializable;

/**
 * @author SamirKeco
 *
 */
public class PilotCriteria extends PredictiveModelBaseDTO implements Serializable
{
    private static final long serialVersionUID = -8373496420476876461L;
    private Integer id;
    private Integer modelId;
    private String criteriaName;
    private String criteriaValue;
    
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
     * @return the criteriaName
     */
    public String getCriteriaName()
    {
        return criteriaName;
    }
    /**
     * Sets criteriaName.
     * 
     * @param     criteriaName the criteriaName to set
     */
    public void setCriteriaName(String criteriaName)
    {
        this.criteriaName = criteriaName;
    }
    /**
     * @return the criteriaValue
     */
    public String getCriteriaValue()
    {
        return criteriaValue;
    }
    /**
     * Sets criteriaValue.
     * 
     * @param     criteriaValue the criteriaValue to set
     */
    public void setCriteriaValue(String criteriaValue)
    {
        this.criteriaValue = criteriaValue;
    }
}
