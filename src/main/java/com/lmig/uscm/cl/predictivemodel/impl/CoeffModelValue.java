/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.impl;

import java.math.BigDecimal;

/**
 * @author Abhi Verma
 *
 */
public class CoeffModelValue
{
    private BigDecimal modelValue;

    /**
     * @return the modelValue
     */
    public BigDecimal getModelValue()
    {
        return modelValue;
    }

    /**
     * Sets modelValue.
     * 
     * @param     modelValue the modelValue to set
     */
    public void setModelValue(BigDecimal modelValue)
    {
        this.modelValue = modelValue;
    }
    
}
