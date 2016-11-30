/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;

import com.lmig.uscm.cl.predictivemodel.impl.CoeffMetadata;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffModel;
import com.lmig.uscm.cl.predictivemodel.intf.IModelComposite;
/**
 * 
 * @author Chris Daub
 *
 */
public class APDSubroModelComposite implements IModelComposite
{
    private CoeffMetadata coeffMetadata;
    private CoeffModel coeffModel;
    
    /**
     * 
     * @param prepareCoeffMetadata
     */
    public void setCoeffMetadata(CoeffMetadata prepareCoeffMetadata)
    {
        this.coeffMetadata = prepareCoeffMetadata;
    }
    /**
     * 
     * @see com.lmig.uscm.cl.predictivemodel.intf.IModelComposite#getCoeffMetadata()
     */
    public CoeffMetadata getCoeffMetadata()
    {
        return this.coeffMetadata;
    }
    /**
     * 
     * @param coeffModel
     */
    public void setCoeffModel(CoeffModel coeffModel)
    {
        this.coeffModel = coeffModel;
    }
    /**
     * 
     * @see com.lmig.uscm.cl.predictivemodel.intf.IModelComposite#getCoeffModel()
     */
    public CoeffModel getCoeffModel()
    {
        return this.coeffModel;
    }

}
