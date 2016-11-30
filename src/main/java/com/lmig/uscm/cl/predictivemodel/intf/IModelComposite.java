/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.intf;

import com.lmig.uscm.cl.predictivemodel.impl.CoeffMetadata;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffModel;

/**
 * @author Abhi Verma
 *
 */
public interface IModelComposite
{
    /**
     * 
     * @return
     */
    CoeffMetadata getCoeffMetadata(); 
    
    /**
     * 
     * @param coeffMetadata
     */
    void setCoeffMetadata(CoeffMetadata coeffMetadata); 
    
    /**
     * 
     * @return
     */
    CoeffModel getCoeffModel(); 
    
    /**
     * 
     * @param coeffModel
     */
    void setCoeffModel(CoeffModel coeffModel);
}
