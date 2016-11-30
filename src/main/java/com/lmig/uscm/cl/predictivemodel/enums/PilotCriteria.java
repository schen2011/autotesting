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
public enum PilotCriteria
{
    LOSS_STATE("Loss State"),
    N_NUMBERS("N Numbers");

    private String desc;
    /**
     * 
     * @param desc
     */
    private PilotCriteria(String desc)
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
