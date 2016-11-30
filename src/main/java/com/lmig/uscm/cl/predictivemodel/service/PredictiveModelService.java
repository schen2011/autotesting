/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.service;

import com.lmig.uscm.cl.predictivemodel.enums.DataSource;
import com.lmig.uscm.cl.predictivemodel.service.model.Metadata;
import com.lmig.uscm.cl.predictivemodel.service.model.OutputResult;

/**
 * @author SamirKeco
 *
 */
public interface PredictiveModelService
{
    /**
     * This method retrieves the predictive model for the parameters passed.
     * 
     * @param modelName - type of predictive model
     * @param modelExecutionMode - type of execution
     */
    Metadata getPredictiveModel(String modelName, String modelExecutionMode);
    
    /**
     * This method retrieves the Id of the most recent record from metadata
     * 
     * @param modelName - type of predictive model
     * @param modelExecutionMode - type of execution
     * @param dataSource - data source
     */
    Integer getMetadata(String modelName, String modelExecutionMode, DataSource dataSource);
    
    /**
     * Insert record into Predictive Model Output table.
     * 
     * @param ds - type of Data Source
     * @param inputObject - object to be inserted
     */
    void insertPredictiveModelResult(DataSource ds, OutputResult inputObject);
    
}
