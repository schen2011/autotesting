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
public enum SegmentationOutput
{
    LARGE_LOSS("prop_lla_"),
    FAST_PATH("prop_fastpath_"),
    FIELD("prop_field_"),
    PPS("prop_pps_"),
    PROP_GRN_HAIL("prop_grn_hail"),
    PROP_PPS_WIND("prop_pps_wind"),
    PROP_PPS_FIRE("prop_pps_fire"),
    PROP_PPS_OTHER("prop_pps_other"),
    PROP_PPS_WATER("prop_pps_water"),
    PROP_PPS_HAIL("prop_pps_hail"),
    PROP_PPS_THEFT("prop_pps_theft"),
    PROP_FASTPATH_FIRE("prop_fastpath_fire"),
    PROP_FASTPATH_HAIL("prop_fastpath_hail"),
    PROP_FASTPATH_OTHER("prop_fastpath_other"),
    PROP_FASTPATH_THEFT("prop_fastpath_theft"),
    PROP_FASTPATH_WATER("prop_fastpath_water"),
    PROP_FASTPATH_WIND("prop_fastpath_wind"),
    PROP_FIELD_FIRE("prop_field_fire"),
    PROP_FIELD_HAIL("prop_field_hail"),
    PROP_FIELD_OTHER("prop_field_other"),
    PROP_FIELD_THEFT("prop_field_theft"),
    PROP_FIELD_WATER("prop_field_water"),
    PROP_FIELD_WIND("prop_field_wind"),
    PROP_LLA_FIRE("prop_lla_fire"),
    PROP_LLA_HAIL("prop_lla_hail"),
    PROP_LLA_OTHER("prop_lla_other"),
    PROP_LLA_THEFT("prop_lla_theft"),
    PROP_LLA_WATER("prop_lla_water"),
    PROP_LLA_WIND("prop_lla_wind");

    private String desc;

    /**
     * 
     * @param desc
     */
    private SegmentationOutput(String desc)
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