/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.service.model;

import java.util.Map;

/**
 * @author SamirKeco
 *
 */
public class Pilot extends BaseModel
{
    private String pilotCriteria;
    private Map<String, String> pilotValue;

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
