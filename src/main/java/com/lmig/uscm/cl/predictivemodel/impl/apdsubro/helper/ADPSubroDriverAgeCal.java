/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.impl.apdsubro.helper;

import java.math.BigDecimal;

import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.intf.IADPSubroDriverAgeCal;

/***
 * 
 * @author BoChen
 *
 */
public class ADPSubroDriverAgeCal implements IADPSubroDriverAgeCal
{
    private static final int DRIVERAGENO = 3; 
    private static final int TOTALAGENUM = 5;
    private static double[][][] driverAgeCoeffAll = 
                        new double[TOTALAGENUM][DRIVERAGENO][DRIVERAGENO];
    private BigDecimal[] driverAgeRes = new BigDecimal[TOTALAGENUM];
    private final int age;
    //private int ageNum;
    //private double[][] driverAgeCoeff = new double[DRIVERAGENO][DRIVERAGENO];

    
    static 
    {
        driverAgeCoeffAll[0][0][0] = 0.00133848899464604;
        driverAgeCoeffAll[0][0][1] = -0.121356335514575;
        driverAgeCoeffAll[0][0][2] = 2.75074360499702;
        
        driverAgeCoeffAll[1][0][0] = -0.00200773349196907;
        driverAgeCoeffAll[1][0][1] = 0.145449137418203;
        driverAgeCoeffAll[1][0][2] = -1.96757882212968;
        
        driverAgeCoeffAll[1][1][0] = 0.000669244497323023;
        driverAgeCoeffAll[1][1][1] = -0.0972635336109459;
        driverAgeCoeffAll[1][1][2] = 3.53390838786437;
        
        driverAgeCoeffAll[2][0][0] = 0.000669244497323022;
        driverAgeCoeffAll[2][0][1] = -0.0240928019036288;
        driverAgeCoeffAll[2][0][2] = 0.21683521713266;
        
        driverAgeCoeffAll[2][1][0] = -0.00133848899464605;
        driverAgeCoeffAll[2][1][1] = 0.157941701368234;
        driverAgeCoeffAll[2][1][2] = -3.90928019036289;
        
        driverAgeCoeffAll[2][2][0] = 0.000669244497323021;
        driverAgeCoeffAll[2][2][1] = -0.133848899464604;
        driverAgeCoeffAll[2][2][2] = 6.69244497323021;
        
        driverAgeCoeffAll[3][1][0] = 0.000669244497323023;
        driverAgeCoeffAll[3][1][1] = -0.0606781677572875;
        driverAgeCoeffAll[3][1][2] = 1.37537180249852;
        
        driverAgeCoeffAll[3][2][0] = -0.00200773349196906;
        driverAgeCoeffAll[3][2][1] = 0.328375966686496;
        driverAgeCoeffAll[3][2][2] = -12.7602617489589;
        
        driverAgeCoeffAll[4][2][0] = 0.00133848899464604;
        driverAgeCoeffAll[4][2][1] = -0.194527067221891;
        driverAgeCoeffAll[4][2][2] = 7.06781677572872;
    }
    
    /***
     * 
     */
    public ADPSubroDriverAgeCal(int age)
    {
        this.age = age;
    }
    

    
    /***
     * 
     * @param age
     * @return
     */
    public BigDecimal getCoefficientByAge(int index) 
    {
        int rank = rank();
        double result = 0;
        for (int i = 0; i < DRIVERAGENO; i++) 
        {
            if (i == 0) 
            { 
                result += driverAgeCoeffAll[index][rank][i] * age * age; 
            }
            else if (i == 1) 
            { 
                result += driverAgeCoeffAll[index][rank][i] * age; 
            }
            else 
            { 
                result += driverAgeCoeffAll[index][rank][i]; 
            }
        }
        return new BigDecimal(result);
    }

    
    /***
     * 
     */
    private void getCoefficients()
    {
        for (int i = 0; i < TOTALAGENUM; i++)
        {
            driverAgeRes[i] = getCoefficientByAge(i);
        }
    }
   
    /**
     * @param age
     * @return
     */
    private int rank()
    {
        int i = 0;
        if (age <= 45) 
        {
            i = 0;
        }
        else if (age >= 46 && age <= 72)
        {
            i = 1;
        }
        else
        {
            i = 2;
        }
        return i;
    }

    /***
     * 
     * @param a
     * @return
     */
    public BigDecimal getCoefficientByA(String a)
    { 
        this.getCoefficients();
        BigDecimal result = BigDecimal.ZERO;
        if (a.equals("A0"))
        {
            result =  driverAgeRes[0];
        }
        else if (a.equals("A1"))
        {
            result = driverAgeRes[1];
        }
        else if (a.equals("A2"))
        {
            result = driverAgeRes[2];
        }
        else if (a.equals("A3"))
        {
            result = driverAgeRes[3];
        }
        else 
        {
            result = driverAgeRes[4];
        }
        return result;
    }
}
