/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.service.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author SamirKeco
 *
 */
public class Metadata extends BaseModel
{
    private Integer id;
    private String modelName;
    private String modelExecutionMode;
    private Double modelVersion;
    private String modelActiveIndicator;
    private Integer weightage;
    private Date createDatetime;
    private String createUser;
    private Date updateDatetime;
    private String updateUser;
    private Map<String, Map<String, BigDecimal>> coefficients;
    private Pilot pilot;
    
    
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
     * @return the weightage
     */
    public Integer getWeightage()
    {
        return weightage;
    }
    /**
     * Sets weightage.
     * 
     * @param     weightage the weightage to set
     */
    public void setWeightage(Integer weightage)
    {
        this.weightage = weightage;
    }
    /**
     * @return the createDatetime
     */
    public Date getCreateDatetime()
    {
        return createDatetime;
    }
    /**
     * Sets createDatetime.
     * 
     * @param     createDatetime the createDatetime to set
     */
    public void setCreateDatetime(Date createDatetime)
    {
        this.createDatetime = createDatetime;
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
     * @return the updateDatetime
     */
    public Date getUpdateDatetime()
    {
        return updateDatetime;
    }
    /**
     * Sets updateDatetime.
     * 
     * @param     updateDatetime the updateDatetime to set
     */
    public void setUpdateDatetime(Date updateDatetime)
    {
        this.updateDatetime = updateDatetime;
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
     * @return the coefficients
     */
    public Map<String, Map<String, BigDecimal>> getCoefficients()
    {
        return coefficients;
    }
    /**
     * Sets coefficients.
     * 
     * @param     coefficients the coefficients to set
     */
    public void setCoefficients(Map<String, Map<String, BigDecimal>> coefficients)
    {
        this.coefficients = coefficients;
    }
    /**
     * @return the pilot
     */
    public Pilot getPilot()
    {
        return pilot;
    }
    /**
     * Sets pilot.
     * 
     * @param     pilot the pilot to set
     */
    public void setPilot(Pilot pilot)
    {
        this.pilot = pilot;
    }
}
