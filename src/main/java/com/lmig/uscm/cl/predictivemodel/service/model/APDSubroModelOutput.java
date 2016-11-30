/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.service.model;

import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroOutput;

/**
 * @author BoChen
 *
 */
public class APDSubroModelOutput
{

    private APDSubroOutput modelOutput;

    
    
    /**
     * @param modelOutput
     */
    public APDSubroModelOutput(APDSubroOutput modelOutput)
    {
        super();
        this.modelOutput = modelOutput;
    }

    /**
     * @return the modelOutput
     */
    public APDSubroOutput getModelOutput()
    {
        return modelOutput;
    }

    /**
     * @param modelOutput the modelOutput to set
     */
    public void setModelOutput(APDSubroOutput modelOutput)
    {
        this.modelOutput = modelOutput;
    }
    
    
}
