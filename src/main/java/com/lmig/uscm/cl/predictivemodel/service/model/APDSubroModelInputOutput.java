/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.service.model;

import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroID;

/**
 * @author BoChen
 *
 */
public class APDSubroModelInputOutput
{
    private APDSubroID referenceId;
    private APDSubroModelInput modelInputs;
    private APDSubroModelOutput modelOutputs;
    /**
     * @return the referenceId
     */
    public APDSubroID getReferenceId()
    {
        return referenceId;
    }
    /**
     * @param referenceId the referenceId to set
     */
    public void setReferenceId(APDSubroID referenceId)
    {
        this.referenceId = referenceId;
    }
    /**
     * @return the modelInputs
     */
    public APDSubroModelInput getModelInputs()
    {
        return modelInputs;
    }
    /**
     * @param modelInputs the modelInputs to set
     */
    public void setModelInputs(APDSubroModelInput modelInputs)
    {
        this.modelInputs = modelInputs;
    }
    /**
     * @return the modelOutputs
     */
    public APDSubroModelOutput getModelOutputs()
    {
        return modelOutputs;
    }
    /**
     * @param modelOutputs the modelOutputs to set
     */
    public void setModelOutputs(APDSubroModelOutput modelOutputs)
    {
        this.modelOutputs = modelOutputs;
    }
}
