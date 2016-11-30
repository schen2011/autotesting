/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.dao.impl;

import com.lmig.uscm.cl.predictivemodel.dao.base.BaseSqlMapDao;
import com.lmig.uscm.cl.predictivemodel.dao.dto.ModelMetadata;
import com.lmig.uscm.cl.predictivemodel.dao.dto.PredictiveModelRequest;
import com.lmig.uscm.cl.predictivemodel.dao.dto.PredictiveModelResult;

/**
 * @author SamirKeco
 *
 */
public class PredictiveModelDAOImpl extends BaseSqlMapDao 
    implements PredictiveModelDAO
{
    private static final String DATABASE_NAME = "propchnl";
    private static final String JNDI_SQL_MAP_CONFIG = 
        "properties/ibatis/config/predictive-model-jndi-sql-map-config.xml";
    private static final String JDBC_SQL_MAP_CONFIG = 
        "properties/ibatis/config/predictive-model-jdbc-sql-map-config.xml";   

    /**
     * This is the method to get to retrieve a predictive model from the 
     * database.
     * 
     * @param request - which predictive model are you requesting to retrieve
     * @return predictive model matching the request
     */
    public ModelMetadata getPredictiveModel(PredictiveModelRequest request)
    {
    	return null;
    }
    
    /**
     * This is the method to get to retrieve a predictive model from the 
     * database.
     * 
     * @param request - which predictive model are you requesting to retrieve
     * @return predictive model matching the request
     */
    public Integer getMetadata(PredictiveModelRequest request)
    {
    	return null;
    }
    
    /**
     * Insert record into Predictive_Model_Output
     * 
     * @param databaseInput - record to be saved to the database
     * @result return true if the record was saved in the database
     */
    public void insertPredictiveModelOutput(PredictiveModelResult databaseInput)
    {
    }   
    
  
}
