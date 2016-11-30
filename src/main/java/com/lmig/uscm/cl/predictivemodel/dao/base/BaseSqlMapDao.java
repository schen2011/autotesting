/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.dao.base;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * Base DAO class that replaces iBatis' deprecated DAO framework.  Most of the
 * methods are pass-through delegates to wrap some error-handling around
 * the ibatis sql map client calls.
 * 
 * Because this class exposes legacy untyped lists and maps, it is acceptable
 * for clients to suppress "unchecked" warnings.
 * 
 * Took a copy of the class from CL_DataAccessCommon_java.
 * 
 * @author Samir Keco - n0171597
 */
public abstract class BaseSqlMapDao
{
   
        
    /**
     * Constructor
     */
    public BaseSqlMapDao()
    {
    }   
    
  
}

