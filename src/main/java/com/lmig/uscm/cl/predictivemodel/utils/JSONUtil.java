/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author BoChen
 *
 */
public final class JSONUtil
{
    /***
     * 
     */
    private JSONUtil()
    {
    }
    
    /***
     * Converts the object to JSON if its not null
     * 
     * @param obj - object to be converted to json
     * @return string in json format
     */
    public static String objectToJson(Object obj)
    {
        String result = null;
        
        if (obj != null)
        {
            Gson gson = new GsonBuilder().disableHtmlEscaping().disableInnerClassSerialization().create();
            result = gson.toJson(obj);
        }
        
        return result;
    }
   
}
