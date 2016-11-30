/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.model.loader.json;


import com.google.gson.annotations.SerializedName;
/**
 * 
 * @author Chris Daub
 *
 */
public class APDSubroModelMetadata
{
    @SerializedName("Model ID")
    private String modelId;

    @SerializedName("Model Name")
    private String modelName;

    @SerializedName("Model Execution Mode")
    private String modelExecutionMode;

    @SerializedName("Model Version")
    private String modelVersion;

    @SerializedName("Model Active Indicator")
    private String modelActiveIndicator;

    @SerializedName("Model Weightage")
    private String modelWeightage;

    @SerializedName("Create Date Time")
    private String createDateTime;

    @SerializedName("Create User")
    private String createUser;

    @SerializedName("Update Date Time")
    private String updateDateTime;
    
    @SerializedName("Update User")
    private String updateUser;

    @SerializedName("Pilot Criteria Name")
    private String pilotCriteria;

    @SerializedName("Pilot Criteria Value")
    private String pilotValue;


    /**
     * @return the modelId
     */
    public String getModelId()
    {
        return modelId;
    }

    /**
     * Sets modelId.
     * 
     * @param     modelId the modelId to set
     */
    public void setModelId(String modelId)
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
    public String getModelVersion()
    {
        return modelVersion;
    }

    /**
     * Sets modelVersion.
     * 
     * @param     modelVersion the modelVersion to set
     */
    public void setModelVersion(String modelVersion)
    {
        this.modelVersion = modelVersion;
    }

    /**
     * @return the modelActiveIndicator
     */
    public String getModelActiveIndicator()
    {
        return modelActiveIndicator;
    }

    /**
     * Sets modelActiveIndicator.
     * 
     * @param     modelActiveIndicator the modelActiveIndicator to set
     */
    public void setModelActiveIndicator(String modelActiveIndicator)
    {
        this.modelActiveIndicator = modelActiveIndicator;
    }

    /**
     * @return the modelWeightage
     */
    public String getModelWeightage()
    {
        return modelWeightage;
    }

    /**
     * Sets modelWeightage.
     * 
     * @param     modelWeightage the modelWeightage to set
     */
    public void setModelWeightage(String modelWeightage)
    {
        this.modelWeightage = modelWeightage;
    }

    /**
     * @return the createDateTime
     */
    public String getCreateDateTime()
    {
        return createDateTime;
    }

    /**
     * Sets createDateTime.
     * 
     * @param     createDateTime the createDateTime to set
     */
    public void setCreateDateTime(String createDateTime)
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
    public String getUpdateDateTime()
    {
        return updateDateTime;
    }

    /**
     * Sets updateDateTime.
     * 
     * @param     updateDateTime the updateDateTime to set
     */
    public void setUpdateDateTime(String updateDateTime)
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
    public String getPilotValue()
    {
        return pilotValue;
    }

    /**
     * Sets pilotValue.
     * 
     * @param     pilotValue the pilotValue to set
     */
    public void setPilotValue(String pilotValue)
    {
        this.pilotValue = pilotValue;
    }

}