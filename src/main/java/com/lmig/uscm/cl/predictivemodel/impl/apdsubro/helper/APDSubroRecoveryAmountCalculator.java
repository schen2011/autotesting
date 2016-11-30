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
public class APDSubroRecoveryAmountCalculator implements IAPDSubroCalculator
{
    /***
     * 
     */
    public APDSubroRecoveryAmountCalculator() 
    {   }
    
    /**
     * 
     */
    @Override
    public double calculate(BigDecimal coeffTotal)
    {
        //System.out.println("CoeffTotal for Recovery:" + coeffTotal);
        return Math.exp(coeffTotal.doubleValue()); 
    }

}
