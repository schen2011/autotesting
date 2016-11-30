/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.enums;

/**
 * @author BoChen
 *
 */
public enum LossType
{
    PROPERTY("PropertyIncident"),
    AUTO("VehicleIncident");

    private String desc;
    /**
     * 
     * @param desc
     */
    private LossType(String desc)
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