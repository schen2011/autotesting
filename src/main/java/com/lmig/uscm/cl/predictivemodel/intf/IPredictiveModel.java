/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.intf;

import com.lmig.uscm.cl.predictivemodel.enums.LossType;

/**
 * @author Abhi Verma
 *
 */
public interface IPredictiveModel
{
    /**
     * 
     * @return
     */
    LossType getLossType();
    
    /**
     * 
     * @return
     */
    IModelComposite getModel();
}
