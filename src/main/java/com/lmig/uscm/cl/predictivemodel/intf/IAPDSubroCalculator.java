/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.intf;

import java.math.BigDecimal;

/**
 * @author BoChen
 *
 */
public interface IAPDSubroCalculator
{
    /***
     * 
     * @param coeffTotal
     * @return
     */
    double calculate(BigDecimal coeffTotal);
}
