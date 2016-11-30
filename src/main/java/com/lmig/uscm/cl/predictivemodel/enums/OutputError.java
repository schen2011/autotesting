/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.enums;

/**
 * @author Abhi Verma
 *
 */
public enum OutputError
{
    FUNCTION_CALL_NOT_SUPPORTED("Error: Function Call Not Supported"),
    SEVERITY_CALCULATION_FAILED("Error: Unable to execute Severity Engine Calculation"),
    COMPLEXITY_CALCULATION_FAILED("Error: Unable to execute Complexity Engine Calculation");

    private String desc;
    /**
     * 
     * @param desc
     */
    private OutputError(String desc)
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
