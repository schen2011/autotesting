/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.impl;

import java.util.Date;
import java.util.Map;

/**
 * @author Abhi Verma
 *
 */
public class CoeffMetadata
{
    private Integer modelId;
    private String modelName;
    private String modelExecutionMode;
    private Double modelVersion;
    private boolean activeIndicator;
    private Integer modelWeightage;
    private Date createDateTime;
    private String createUser;
    private Date updateDateTime;
    private String updateUser;
    private String pilotCriteria;
    private Map<String, String> pilotValue;

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
    /**
     * @return the modelVersion
     */
    public Double getModelVersion()
    {
        return modelVersion;
    }
    /**
     * Sets modelVersion.
     * 
     * @param     modelVersion the modelVersion to set
     */
    public void setModelVersion(Double modelVersion)
    {
        this.modelVersion = modelVersion;
    }
    /**
     * @return the activeIndicator
     */
    public boolean isActiveIndicator()
    {
        return activeIndicator;
    }
    /**
     * Sets activeIndicator.
     * 
     * @param     activeIndicator the activeIndicator to set
     */
    public void setActiveIndicator(boolean activeIndicator)
    {
        this.activeIndicator = activeIndicator;
    }
    /**
     * @return the modelWeightage
     */
    public Integer getModelWeightage()
    {
        return modelWeightage;
    }
    /**
     * Sets modelWeightage.
     * 
     * @param     modelWeightage the modelWeightage to set
     */
    public void setModelWeightage(Integer modelWeightage)
    {
        this.modelWeightage = modelWeightage;
    }
    /**
     * @return the createDateTime
     */
    public Date getCreateDateTime()
    {
        return createDateTime;
    }
    /**
     * Sets createDateTime.
     * 
     * @param     createDateTime the createDateTime to set
     */
    public void setCreateDateTime(Date createDateTime)
    {
        this.createDateTime = createDateTime;
    }
    /**
     * @return the createUser
     */
    public String getCreateUser()
    {
        return createUser;
    }
    /**
     * Sets createUser.
     * 
     * @param     createUser the createUser to set
     */
    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }
    /**
     * @return the updateDateTime
     */
    public Date getUpdateDateTime()
    {
        return updateDateTime;
    }
    /**
     * Sets updateDateTime.
     * 
     * @param     updateDateTime the updateDateTime to set
     */
    public void setUpdateDateTime(Date updateDateTime)
    {
        this.updateDateTime = updateDateTime;
    }
    /**
     * @return the updateUser
     */
    public String getUpdateUser()
    {
        return updateUser;
    }
    /**
     * Sets updateUser.
     * 
     * @param     updateUser the updateUser to set
     */
    public void setUpdateUser(String updateUser)
    {
        this.updateUser = updateUser;
    }
    /**
     * @return the pilotCriteria
     */
    public String getPilotCriteria()
    {
        return pilotCriteria;
    }
    /**
     * Sets pilotCriteria.
     * 
     * @param     pilotCriteria the pilotCriteria to set
     */
    public void setPilotCriteria(String pilotCriteria)
    {
        this.pilotCriteria = pilotCriteria;
    }
    /**
     * @return the pilotValue
     */
    public Map<String, String> getPilotValue()
    {
        return pilotValue;
    }
    /**
     * Sets pilotValue.
     * 
     * @param     pilotValue the pilotValue to set
     */
    public void setPilotValue(Map<String, String> pilotValue)
    {
        this.pilotValue = pilotValue;
    }
}