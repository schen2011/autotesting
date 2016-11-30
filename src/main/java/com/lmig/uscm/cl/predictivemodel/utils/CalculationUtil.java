/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author BoChen
 *
 */
public final class CalculationUtil
{
    /***
     * 
     */
    private CalculationUtil()
    {
        
    }
    
    /***
     * 
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal multiply(String a, String b) 
    {
        BigDecimal result = BigDecimal.ZERO;
        if (a == null || b == null)
        {
            return result;
        }
        result = new BigDecimal(Double.parseDouble(a) 
            * Double.parseDouble(b));
        return result;
    }
    
    /***
     * 
     * @param base
     * @param x
     * @return
     */
    public static BigDecimal log(double base, BigDecimal x) 
    {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal input = new BigDecimal(x.toString());
        int decimalPlaces = 100;
        int scale = input.precision() + decimalPlaces;
        int maxite = 10000;
        int ite = 0;
        BigDecimal maxErrorBigDecimal = new BigDecimal(BigInteger.ONE, decimalPlaces + 1);
        RoundingMode roundingMode = RoundingMode.UP;
        BigDecimal twoBigDecimal = new BigDecimal("2");
        BigDecimal baseBigDecimal = new BigDecimal(base);
        while (input.compareTo(baseBigDecimal) == 1) 
        {
            result = result.add(BigDecimal.ONE);
            input = input.divide(baseBigDecimal, scale, roundingMode);
        }
        BigDecimal fraction = new BigDecimal("0.5");
        input = input.multiply(input);
        BigDecimal resultplusfraction = result.add(fraction);
        while (((resultplusfraction).compareTo(result) == 1)
                && (input.compareTo(BigDecimal.ONE) == 1)) 
        {
            if (input.compareTo(baseBigDecimal) == 1) 
            {
                input = input.divide(baseBigDecimal, scale, roundingMode);
                result = result.add(fraction);
            }
            input = input.multiply(input);
            fraction = fraction.divide(twoBigDecimal, scale, roundingMode);
            resultplusfraction = result.add(fraction);
            if (fraction.abs().compareTo(maxErrorBigDecimal) == -1)
            {
                break;
            }
            if (maxite == ite)
            {
                break;
            }
            ite++;
        }
        MathContext mathContext = 
            new MathContext(((decimalPlaces - 1) 
                + (result.precision() - result.scale())), RoundingMode.HALF_UP);
        BigDecimal roundedResult = result.round(mathContext);
        BigDecimal strippedRoundedResult = roundedResult.stripTrailingZeros();
        return strippedRoundedResult;
    }
}
