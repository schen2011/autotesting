/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.dao.dto;

/**
 * @author KelvinMcClean
 *
 */
public class PredictiveModelResult extends PredictiveModelBaseDTO
{
    private String claimNumber;
    private String incidentID;
    private String exposureID;
    private String vehcileID;
    private String modelType;
    private String entityID;
    private String entityName;
    private String modelInputOutput;
    private Integer modelID;
    
    
    /**
     * @return the claimNumber
     */
    public String getClaimNumber()
    {
        return claimNumber;
    }
    /**
     * Sets claimNumber.
     * 
     * @param     claimNumber the claimNumber to set
     */
    public void setClaimNumber(String claimNumber)
    {
        this.claimNumber = claimNumber;
    }
    /**
     * @return the incidentID
     */
    public String getIncidentID()
    {
        return incidentID;
    }
    /**
     * Sets incidentID.
     * 
     * @param     incidentID the incidentID to set
     */
    public void setIncidentID(String incidentID)
    {
        this.incidentID = incidentID;
    }
    /**
     * @return the exposureID
     */
    public String getExposureID()
    {
        return exposureID;
    }
    /**
     * Sets exposureID.
     * 
     * @param     exposureID the exposureID to set
     */
    public void setExposureID(String exposureID)
    {
        this.exposureID = exposureID;
    }
    /**
     * @return the vehcileID
     */
    public String getVehcileID()
    {
        return vehcileID;
    }
    /**
     * Sets vehcileID.
     * 
     * @param     vehcileID the vehcileID to set
     */
    public void setVehcileID(String vehcileID)
    {
        this.vehcileID = vehcileID;
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
     * @return the entityID
     */
    public String getEntityID()
    {
        return entityID;
    }
    /**
     * Sets entityID.
     * 
     * @param     entityID the entityID to set
     */
    public void setEntityID(String entityID)
    {
        this.entityID = entityID;
    }
    /**
     * @return the entityName
     */
    public String getEntityName()
    {
        return entityName;
    }
    /**
     * Sets entityName.
     * 
     * @param     entityName the entityName to set
     */
    public void setEntityName(String entityName)
    {
        this.entityName = entityName;
    }
    /**
     * @return the modelInputOutput
     */
    public String getModelInputOutput()
    {
        return modelInputOutput;
    }
    /**
     * Sets modelInputOutput.
     * 
     * @param     modelInputOutput the modelInputOutput to set
     */
    public void setModelInputOutput(String modelInputOutput)
    {
        this.modelInputOutput = modelInputOutput;
    }
    /**
     * @return the modelID
     */
    public Integer getModelID()
    {
        return modelID;
    }
    /**
     * Sets modelID.
     * 
     * @param     modelID the modelID to set
     */
    public void setModelID(Integer modelID)
    {
        this.modelID = modelID;
    }
    
}
