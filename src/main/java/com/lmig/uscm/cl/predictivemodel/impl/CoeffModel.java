/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.impl;

import java.util.Map;
import java.util.Set;

import com.lmig.uscm.cl.predictivemodel.enums.CoeffKey;
import com.lmig.uscm.cl.predictivemodel.enums.ModelType;

/**
 * @author Abhi Verma
 *
 */
public class CoeffModel
{
    private Map<CoeffKey, Map<ModelType, CoeffModelValue>> coeffKeyModelValueMap;
    private Map<CoeffKey, CoeffValue> coeffKeyValueMap;
    private Set<CoeffKey> coeffKeySet;
    /**
     * @return the coeffKeyModelValueMap
     */
    public Map<CoeffKey, Map<ModelType, CoeffModelValue>> getCoeffKeyModelValueMap()
    {
        return coeffKeyModelValueMap;
    }
    /**
     * Sets coeffKeyModelValueMap.
     * 
     * @param     coeffKeyModelValueMap the coeffKeyModelValueMap to set
     */
    public void setCoeffKeyModelValueMap(Map<CoeffKey, Map<ModelType, CoeffModelValue>> coeffKeyModelValueMap)
    {
        this.coeffKeyModelValueMap = coeffKeyModelValueMap;
    }
    /**
     * @return the coeffKeyValueMap
     */
    public Map<CoeffKey, CoeffValue> getCoeffKeyValueMap()
    {
        return coeffKeyValueMap;
    }
    /**
     * Sets coeffKeyValueMap.
     * 
     * @param     coeffKeyValueMap the coeffKeyValueMap to set
     */
    public void setCoeffKeyValueMap(Map<CoeffKey, CoeffValue> coeffKeyValueMap)
    {
        this.coeffKeyValueMap = coeffKeyValueMap;
    }
    /**
     * @return the coeffKeySet
     */
    public Set<CoeffKey> getCoeffKeySet()
    {
        return coeffKeySet;
    }
    /**
     * Sets coeffKeySet.
     * 
     * @param     coeffKeySet the coeffKeySet to set
     */
    public void setCoeffKeySet(Set<CoeffKey> coeffKeySet)
    {
        this.coeffKeySet = coeffKeySet;
    }

}
