/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;

import com.lmig.uscm.cl.predictivemodel.enums.LossType;
import com.lmig.uscm.cl.predictivemodel.intf.IModelComposite;
import com.lmig.uscm.cl.predictivemodel.intf.IPredictiveModel;

/**
 * 
 * @author Chris Daub
 *
 */
public class APDSubroModel implements IPredictiveModel
{
    private LossType lossType;
    private IModelComposite apdSubroCompositeModel;
    /**
     * 
     * @param loadCompositeModelFromDB
     */
    public APDSubroModel(IModelComposite compositeModel)
    {
        this.lossType = LossType.AUTO;
        this.apdSubroCompositeModel = compositeModel;
    }

    /**
     * 
     * @see com.lmig.uscm.cl.predictivemodel.intf.IPredictiveModel#getLossType()
     */
    @Override
    public LossType getLossType()
    {
        return this.lossType;
    }
    /**
     * 
     * @see com.lmig.uscm.cl.predictivemodel.intf.IPredictiveModel#getModel()
     */
    @Override
    public IModelComposite getModel()
    {
        return this.apdSubroCompositeModel;
    }
}
