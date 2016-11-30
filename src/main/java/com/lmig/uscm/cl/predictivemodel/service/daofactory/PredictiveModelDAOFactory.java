/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.service.daofactory;

import com.lmig.uscm.cl.predictivemodel.dao.impl.PredictiveModelDAO;

/**
 * @author SamirKeco
 *
 */
public interface PredictiveModelDAOFactory
{
    /**
     *  Static instance of the DAO Service
     */
    PredictiveModelDAOFactory INSTANCE = new PredictiveModelDAOFactoryImpl();
    
    /**
     * Gets the predictive model DAO.
     * 
     * @return predictive model DAO
     */
    PredictiveModelDAO getPredictiveModelDAO();
}
