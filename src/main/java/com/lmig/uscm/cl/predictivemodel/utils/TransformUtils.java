/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import com.lmig.uscm.cl.predictivemodel.enums.CoeffInput;
import com.lmig.uscm.cl.predictivemodel.enums.CoeffKey;
import com.lmig.uscm.cl.predictivemodel.enums.ModelType;

/**
 * @author AbhiVerma
 *
 */
public final class TransformUtils
{
    /**
     * private constructor
     */
    private TransformUtils()
    {
        
    }
    /**
     * @param str
     * @return
     */
    public static boolean convertStringToBoolean(String str)
    {
        boolean returnBoolean = true;
        if (str == null || str.equalsIgnoreCase("1"))
        {
            returnBoolean = false;
        }
        else if (str.equalsIgnoreCase("0"))
        {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    /**
     * @param pilotCriteria
     * @return
     */
    public static Map<String, String> createPilotCriteriaMap(String pilotCriteria)
    {
        String nextTokenInTokenizedString = null;
        Map<String, String> pilotCriteriaMap = new HashMap<String, String>();
        StringTokenizer st = new StringTokenizer(pilotCriteria, ",");
        while (st.hasMoreTokens())
        {
            nextTokenInTokenizedString = st.nextToken();
            pilotCriteriaMap.put(nextTokenInTokenizedString, nextTokenInTokenizedString);
        }
        return pilotCriteriaMap;
    }

    /**
     * @param pilotCriteria
     * @return
     */
    public static String createPilotCriteriaValue(Map<String, String> pilotCriteria)
    {
        StringBuffer pilotCriteriaBuffer = new StringBuffer();
        String pilotCriteriaString = "";
        for (String key : pilotCriteria.keySet())
        {
            pilotCriteriaBuffer.append(key).append(",");
        }
        if (pilotCriteriaBuffer.length() > 0)
        {
            pilotCriteriaString = pilotCriteriaBuffer.toString();
            if (pilotCriteriaString.lastIndexOf(',') != 0)
            {
                pilotCriteriaString = pilotCriteriaString.substring(0, pilotCriteriaString.lastIndexOf(','));
            }
        }
        return pilotCriteriaString;
    }

    /**
     * @param flag
     * @return
     */
    public static String convertBooleanToString(boolean flag)
    {
        return !flag ? "1" : "0";
    }

    /**
     * @param str
     * @return
     */
    public static Date convertStringToDate(String str)
    {
        Date returnDate = null;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try
        {
            if (str != null)
            {
                returnDate = df.parse(str);
            }
        }
        catch (ParseException pe)
        {
            returnDate = new Date();
        }
        return returnDate;
    }

    /**
     * @param str
     * @return
     */
    public static Integer convertStringToInteger(String str)
    {
        Integer intValue = 0;
        if (str != null)
        {
            intValue = Integer.parseInt(str);
        }
        return intValue;
    }

    /**
     * @param str
     * @return
     */
    public static Double convertStringToDouble(String str)
    {
        Double doubleValue = 1.0d;
        if (str != null)
        {
            doubleValue = Double.parseDouble(str);
        }
        return doubleValue;
    }

    /**
     * @param coefficientKey
     * @return
     */
    public static CoeffKey getCoefficientKey(String coefficientKey)
    {
        CoeffKey cKey = null;
        if (coefficientKey != null)
        {
            cKey = CoeffKey.valueOf(coefficientKey);
        }
        return cKey;
    }

    /**
     * @param strValue
     * @return
     */
    public static BigDecimal convertStringToBigDecimal(String strValue)
    {
        BigDecimal bgValue = new BigDecimal(strValue);
        return bgValue;
    }
    
    /**
     * @param modelType
     * @return
     */
    public static ModelType getModelType(String modelType)
    {
        ModelType mType = null;
        if (modelType != null)
        {
            mType = ModelType.valueOf(modelType.toUpperCase());
        }
        return mType;
    }
    
    /**
     * @param coefficientInput
     * @return
     */
    public static CoeffInput getCoefficientInput(String coefficientInput)
    {
        CoeffInput cInput = null;
        if (coefficientInput != null && !coefficientInput.trim().equalsIgnoreCase(""))
        {
            cInput = CoeffInput.valueOf(coefficientInput.trim().toUpperCase());
        }
        return cInput;
    }
    
    /**
     * @param input1Value1
     * @param input1Value2
     * @param input2Value1
     * @param input2Value2
     * @return
     */
    public static String getCoefficientValue(
        String input1Value1, String input1Value2, String input2Value1, String input2Value2)
    {
        String inputValue1Value2 = "";
        if (input1Value1 != null && !input1Value1.trim().equalsIgnoreCase(""))
        {
            inputValue1Value2 = inputValue1Value2 + input1Value1.trim();
        }
        if (input1Value2 != null && !input1Value2.trim().equalsIgnoreCase(""))
        {
            inputValue1Value2 = inputValue1Value2 + "_" + input1Value2;
        }
        if (input2Value1 != null && !input2Value1.trim().equalsIgnoreCase(""))
        {
            inputValue1Value2 = inputValue1Value2 + "_" + input2Value1;
        }
        if (input2Value2 != null && !input2Value2.trim().equalsIgnoreCase(""))
        {
            inputValue1Value2 = inputValue1Value2 + "_" + input2Value2;
        }
        return inputValue1Value2;
    }
    
    /***
     * 
     * @param map
     * @return
     */
    @SuppressWarnings
    (
        {
            "unchecked", "rawtypes"
        } 
    )
    public static Map<String, BigDecimal> sortByValues(Map<String, BigDecimal> map)
    {
        List sortedByValueList = new LinkedList(map.entrySet());
        Collections.sort(sortedByValueList, new Comparator<Map.Entry<String, BigDecimal>>()
        {
            public int compare(Entry<String, BigDecimal> o1
                , Entry<String, BigDecimal> o2)
            {
                return ((Comparable) (o2).getValue())
                    .compareTo((o1).getValue());
            }
        });
        Map<String, BigDecimal> sortedHashMap = new LinkedHashMap<String, BigDecimal>();
        for (Iterator it = sortedByValueList.iterator(); it.hasNext();)
        {
            Map.Entry<String, BigDecimal> entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
