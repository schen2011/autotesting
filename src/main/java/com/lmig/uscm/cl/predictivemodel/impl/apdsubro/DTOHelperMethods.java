/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;



/**
 * 
 * @author Chris Daub
 *
 */
public class DTOHelperMethods
{

    private static final String CONTRIBUTORY = "AL|DC|MD|NC|VA";
    
    private static final String PURE = "AK|AZ|CA|FL|KY|LA|MS|MO|NM|NY|RI|WA";
    
    private static final String MODIFIED50 = "AR|CO|GA|ID|KS|ME|ND|NE|SD|TN|UT|WV";
    
    private static final String MODIFIED51 = "CT|DE|HI|IL|IN|IA|MA|MI|MN|MT|NV|NH|NJ|OH|OK|OR|PA|SC|TX|VT|WI|WY";
        
    private static final String VEHICLEGROUPED = "ALFA|AMER|ASTO|BENT|DAEW|EAGL|FERA|GMC|LANC|LOTS|MG|" +
        "ROL|STCO|TRIU|MASE|MASS";
    
    private static final String LOSSCAUSEGROUPED = "totaltheft|pedcyclistotherWalk|" +
        "othercomp|fellonoffvehicle|fallobject|struckbyagainstobject|windauto|" +
        "upsetoverturn|fireauto|floodrisingwater|compglass|hailauto|hitanimal|" +
        "hurricanetropicalauto|partialtheft|towingandlabor|mischieforvandalism|" +
        "waterdamageauto";
    
    private static final Integer DEFAULTYEAR = 1900;
    
    private static final Integer DEFAULTAGE_MIN = 18;
    private static final Integer DEFAULTAGE_MAX = 100;
    
   
    /**
     * 
     * @param arg
     * @return
     */
    public String nullCheck(String arg)
    {
        String out = null;
        if (arg == null)
        {
            out = "Default";
        }
        else 
        {
            out = arg;
        }
        return out; 
    }
    /**
     * 
     * @param arg
     * @return
     */
    public String trueFalse(Boolean arg)
    {
        String out = null;
        if (arg == null)
        {
            out = "Default";
        }
        else
        {
            out = arg.toString();
        }
        return out;
    }
    /**
     * 
     * @param vehicleYear
     * @return
     */
    public String vehicleYear(Integer vehicleYear)
    {
        if (vehicleYear == null)
        {
            vehicleYear = DEFAULTYEAR;
        }
        return vehicleYear.toString();
    }
    /**
     * 
     * @param jurisdictionGroup
     * @return
     */
    public String jurisdiction(String jurisdictionGroup)
    {
        String out = null;
        if (jurisdictionGroup == null)
        {
            out = "Default";
        }
        else
        {
            String temp = jurisdictionGroup.toUpperCase();
            if (CONTRIBUTORY.contains(temp))
            {
                out = "contributory";
            }
            else if (PURE.contains(temp))
            {
                out = "pure";
            }
            else if (MODIFIED50.contains(temp))
            {
                out = "modified50";
            }
            else if (MODIFIED51.contains(temp))
            {
                out = "modified51";
            }
            else
            {
                out = "Default";
            }
        }
        return out;
    }
    /**
     * 
     * @param vehicleMake
     * @return
     */
    public String vehicleMake(String vehicleMake)
    {
        String out = null;
        if (vehicleMake == null)
        {
            out = "Default";
        }
        else if (VEHICLEGROUPED.contains(vehicleMake.toUpperCase()))
        {
            out = "Grouped";
        }
        else
        {
            out = vehicleMake;
        }
        return out;
    }
    /**
     * 
     * @param age
     * @return
     */
    public String age(Integer age)
    {
        String out = null;
        if (age == null)
        {
            out = "Default";
        }
        else if (age < DEFAULTAGE_MIN)
        {
            out = String.valueOf(DEFAULTAGE_MIN);
        }
        else if (age > DEFAULTAGE_MAX)
        {
            out = String.valueOf(DEFAULTAGE_MAX);
        }
        else 
        {
            out = age.toString();
        }
        return out;
    }
    /**
     * 
     * @param lossCauseTypeDesc
     * @return
     */
    public String lossCause(String lossCauseTypeDesc)
    {
        String out = null;
        if (lossCauseTypeDesc == null)
        {
            out = "Default";
        }
        else if (LOSSCAUSEGROUPED.contains(lossCauseTypeDesc))
        {
            out = "Grouped";
        }
        else
        {
            out = lossCauseTypeDesc;
        }
        return out;
    }
    /**
     * 
     * @param multiCarInd
     * @return
     */
    public String multiCar(Integer multiCarInd)
    {
        String out = null;
        if (multiCarInd == null)
        {
            out = "Default";
        }
        else if (multiCarInd > 1)
        {
            out = "true";
        }
        else
        {
            out = "false";
        }
        return out;
    }
    /**
     * 
     * @param rentalNum
     * @return
     */
    public String rental(Integer rentalNum)
    {
        String out = null;
        if (rentalNum == null)
        {
            out = "Default";
        }
        else if (rentalNum > 0)
        {
            out = "true";
        }
        else
        {
            out = "false";
        }
        return out;
    }
}
