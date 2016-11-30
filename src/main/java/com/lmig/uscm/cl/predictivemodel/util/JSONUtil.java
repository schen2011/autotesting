/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.util;

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
        super();
    }
    /***
     * 
     * @param obj
     * @return
     */
    public static String objectToJson(Object obj)
    {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(obj);
    }
   
}
