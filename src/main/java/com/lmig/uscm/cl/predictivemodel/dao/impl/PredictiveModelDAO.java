/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.dao.impl;

import com.lmig.uscm.cl.predictivemodel.dao.dto.ModelMetadata;
import com.lmig.uscm.cl.predictivemodel.dao.dto.PredictiveModelRequest;
import com.lmig.uscm.cl.predictivemodel.dao.dto.PredictiveModelResult;

/**
 * @author SamirKeco n0171597
 *
 */
public interface PredictiveModelDAO
{
    /**
     * This is the method to get to retrieve a predictive model from the 
     * database.
     * 
     * @param request - which predictive model are you requesting to retrieve
     * @return predictive model matching the request
     */
    ModelMetadata getPredictiveModel(PredictiveModelRequest request);
    
    /**
     * This is the method to get to retrieve the latest change from metadata.
     * 
     * @param request - which predictive model are you requesting to retrieve
     * @return predictive model matching the request
     */
    Integer getMetadata(PredictiveModelRequest request);
    
    /***
     * Insert into PI_CL_ONLINE.PREDICTIVE_MODEL_RESULT. 
     * 
     * @param databaseInput - object to be added to the database
     */
    void insertPredictiveModelOutput(PredictiveModelResult databaseInput);
}
