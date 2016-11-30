/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.enums;
/**
 * @author BoChen
 * values are PROPERTY_CHANNELING_JAVA_IMPL, PROPERTY_CHANNELING_DROOLS_IMPL, BODILY_INJURY_JAVA_IMPL
 *
 */
public enum EngineType 
{
    PROPERTY_CHANNELING_JAVA_IMPL("Property Channeling Java Impl"),
    PROPERTY_CHANNELING_DROOLS_IMPL("Property Channeling Drools Impl"),
    BODILY_INJURY_JAVA_IMPL("Bodliy Injury Java Impl"),
    REPAIR_TIME_DROOLS_IMPL("Repair Time Drools Impl"),
    APD_SUBRO_JAVA_IMPL("APD Subrogation Java Impl");
    

    private String desc;
    /**
     * 
     * @param desc
     */
    private EngineType(String desc)
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