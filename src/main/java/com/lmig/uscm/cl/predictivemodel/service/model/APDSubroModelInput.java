/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.service.model;

import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroConsumer;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroDTO;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroNavigatorDTO;

/**
 * @author BoChen
 *
 */
public class APDSubroModelInput
{
    private APDSubroNavigatorDTO rawInput;
    private APDSubroDTO transformedInput;
    
    /***
     * 
     * @param propchnlConsumer
     * @param propchnlDTO
     */
    public APDSubroModelInput(APDSubroConsumer apdSubroConsumer, APDSubroDTO apdSubroDTO)
    {
        this.rawInput = apdSubroConsumer.getNavigatorDto();
        this.transformedInput = apdSubroDTO;
    }
    
    /**
     * @return the rawInput
     */
    public APDSubroNavigatorDTO getRawInput()
    {
        return rawInput;
    }

    /**
     * @return the transformedInput
     */
    public APDSubroDTO getTransformedInput()
    {
        return transformedInput;
    }


}
