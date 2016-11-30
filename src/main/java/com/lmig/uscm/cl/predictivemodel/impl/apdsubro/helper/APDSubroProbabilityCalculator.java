/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.impl.apdsubro.helper;

import java.math.BigDecimal;

import com.lmig.uscm.cl.predictivemodel.intf.IAPDSubroCalculator;

/**
 * @author BoChen
 *
 */
public class APDSubroProbabilityCalculator implements IAPDSubroCalculator
{
    /***
     * 
     */
    public APDSubroProbabilityCalculator() 
    {   }
    
    /**
     * 
     */
    public double calculate(BigDecimal coeffTotal)
    {
        //System.out.println("CoeffTotal for Probability:" + coeffTotal);
        return 1 / (1 + Math.exp(coeffTotal.doubleValue() * -1));
    }


}
