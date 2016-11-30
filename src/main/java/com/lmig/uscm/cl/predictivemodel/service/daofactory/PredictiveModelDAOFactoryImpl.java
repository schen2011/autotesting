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
public class PredictiveModelDAOFactoryImpl extends DaoBaseFactory 
    implements PredictiveModelDAOFactory
{
    
    /**
     * Get the PredictiveModel
     *
     */
    public PredictiveModelDAO getPredictiveModelDAO()
    {
        return (PredictiveModelDAO) getService(PredictiveModelDAO.class,
            "com.lmig.uscm.cl.predictivemodel.dao.impl.PredictiveModelDAOImpl");
    }

}
