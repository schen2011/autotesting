/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.utils;

import com.lmig.uscm.cl.predictivemodel.dao.dto.PredictiveModelResult;
import com.lmig.uscm.cl.predictivemodel.service.model.OutputResult;


/**
 * @author SamirKeco
 *
 */
public final class ServiceToDaoMappingUtil
{
    public static final String METHODS_NEED_TO_BE_DEFINED = "";
    
    
    /**
     * Empty constructor
     */
    private ServiceToDaoMappingUtil()
    {
    }
    
    /**
     * Maps outputResult object to predictive model result.
     * 
     * @param inputObject - object to be mapped/converted
     * @return mapped PredictiveModelResult 
     */
    public static PredictiveModelResult mapOutputResultToPredictiveModelResult(
        OutputResult inputObject)
    {
        PredictiveModelResult result = null;
        
        if (inputObject != null)
        {
            result = new PredictiveModelResult();
            result.setClaimNumber(inputObject.getClaimNumber());
            result.setEntityID(inputObject.getEntityID());
            result.setEntityName(inputObject.getEntityName());
            result.setExposureID(inputObject.getExposureID());
            result.setIncidentID(inputObject.getIncidentID());
            result.setModelID(inputObject.getModelID());
            result.setModelInputOutput(inputObject.getModelInputOutputAsJSON());
            result.setModelType(inputObject.getModelType());
            result.setVehcileID(inputObject.getVehcileID());
        }
        
        return result;
        
    }
}
