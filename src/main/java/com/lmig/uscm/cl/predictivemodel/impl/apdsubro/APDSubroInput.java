/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;
import java.util.List;

import com.lmig.uscm.cl.predictivemodel.intf.IPredictiveModelInput;

/****
 * 
 * @author BoChen
 *
 */
public class APDSubroInput implements IPredictiveModelInput<APDSubroDTO> 
{
    private APDSubroDTO dto;

    /**
     * @return the dto
     */
    public APDSubroDTO getDto()
    {
        return dto;
    }

    /**
     * Sets dto.
     * 
     * @param     dto the dto to set
     */
    public void setDto(APDSubroDTO dto)
    {
        this.dto = dto;
    }
}
