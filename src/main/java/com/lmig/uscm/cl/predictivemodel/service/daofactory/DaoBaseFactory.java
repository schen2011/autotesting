/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.service.daofactory;

import org.apache.commons.discovery.tools.DiscoverSingleton;


/**
 * @author SamirKeco
 *
 */
public abstract class DaoBaseFactory
{
    /**
     * Generic helper class to get a service based on class and implementation
     * name. Useful if we decide to bail on the discover singleton framework
     * 
     * @param clazz
     * @param defaultImpl
     * @return
     */
    protected Object getService(Class< ? > clazz, String defaultImpl)
    {
        return DiscoverSingleton.find(clazz, defaultImpl);
    }
    
    
    /***
     * 
     * @param clazz
     * @return
     */
    protected Object getService(Class< ? > clazz)
    {
        return DiscoverSingleton.find(clazz);
    }
}
