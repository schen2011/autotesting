/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;

import com.lmig.uscm.cl.predictivemodel.enums.ConsumerType;
import com.lmig.uscm.cl.predictivemodel.enums.ModelType;
import com.lmig.uscm.cl.predictivemodel.intf.IPredictiveModelConsumer;

/**
 * @author BoChen
 *
 */
public class APDSubroConsumer implements IPredictiveModelConsumer
{
    private ConsumerType consumerType;
    private ModelType modelType;
    private APDSubroID apdSubroID;
    private APDSubroNavigatorDTO navigatorDto;
    private String navigatorDtoJsonString;
    /**
     * @return the consumerType
     */
    public ConsumerType getConsumerType()
    {
        return consumerType;
    }
    /**
     * @param consumerType the consumerType to set
     */
    public void setConsumerType(ConsumerType consumerType)
    {
        this.consumerType = consumerType;
    }
    /**
     * @return the modelType
     */
    public ModelType getModelType()
    {
        return modelType;
    }
    /**
     * @param modelType the modelType to set
     */
    public void setModelType(ModelType modelType)
    {
        this.modelType = modelType;
    }
    /***
     * 
     * @return
     */
    public APDSubroID getAPDSubroID()
    {
        return apdSubroID;
    }
    /***
     * 
     * @param apdSubroID
     */
    public void setAPDSubroID(APDSubroID apdsubroID)
    {
        this.apdSubroID = apdsubroID;
    }
    
    /**
     * @return the navigatorDto
     */
    public APDSubroNavigatorDTO getNavigatorDto()
    {
        return navigatorDto;
    }
    /**
     * @param navigatorDto the navigatorDto to set
     */
    public void setNavigatorDto(APDSubroNavigatorDTO navigatorDto)
    {
        this.navigatorDto = navigatorDto;
    }
    /**
     * @return the navigatorDtoJsonString
     */
    public String getNavigatorDtoJsonString()
    {
        return navigatorDtoJsonString;
    }
    /**
     * @param navigatorDtoJsonString the navigatorDtoJsonString to set
     */
    public void setNavigatorDtoJsonString(String navigatorDtoJsonString)
    {
        this.navigatorDtoJsonString = navigatorDtoJsonString;
    }
}
