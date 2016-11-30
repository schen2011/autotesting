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
public class PredictiveModelServiceImpl implements PredictiveModelService
{

    /**
     * Empty constructor
     */
    public PredictiveModelServiceImpl()
    {
    }

    /**
     * This method retrieves the predictive model for the parameters passed.
     * 
     * @param modelName - type of predictive model
     * @param modelExecutionMode - type of execution
     */
    public Metadata getPredictiveModel(
        String modelName, String modelExecutionMode)
    {
    	return null;
    }
    
    /**
     * This method retrieves the predictive model for the parameters passed.
     * 
     * @param modelName - type of predictive model
     * @param modelExecutionMode - type of execution
     * @param dataSource - data source
     */
    public Integer getMetadata(
        String modelName, 
        String modelExecutionMode,
        DataSource dataSource)
    {
        
        Integer result = null;
        
        
        return result;
    }
    
    /**
     * Insert record into Predictive Model Output table.
     * 
     * @param ds - type of Data Source
     * @param inputObject - object to be inserted
     */
    public void insertPredictiveModelResult(
        DataSource ds, OutputResult inputObject)
    {
        
    }
}
