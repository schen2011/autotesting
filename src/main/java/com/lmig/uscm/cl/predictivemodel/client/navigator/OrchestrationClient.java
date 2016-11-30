/*
http://10.45.80.80:32768/about/http://10.45.80.80:32768/about/* Copyright (c) 2016, Liberty Mutual
* Proprietary and Confidential
* All Rights Reserved
*/
package com.lmig.uscm.cl.predictivemodel.client.navigator;

import com.lmig.uscm.cl.predictivemodel.enums.ConsumerType;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroConsumer;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroNavigatorDTO;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroOutput;
import com.lmig.uscm.cl.predictivemodel.orchestration.PredictiveModelingOrchestration;
/**
* @author ArvindNarayanan
*
*/
public class OrchestrationClient 
{

    /***
     * 
     * @param adpSubroNavDto
     * @return
     */
    public Boolean executeAPDSubroOrchestration(APDSubroNavigatorDTO adpSubroNavDto)
    {
        APDSubroConsumer consumer = new APDSubroConsumer();
        consumer.setAPDSubroID(adpSubroNavDto.getIdInfo());
        consumer.setNavigatorDto(adpSubroNavDto);
        consumer.setConsumerType(ConsumerType.CLAIMS_CENTER);
        PredictiveModelingOrchestration pmOrchestration = new PredictiveModelingOrchestration(); 
        return pmOrchestration.executeAPDSubroModel(consumer);
    }
    
    public APDSubroOutput executeAPDSubroOrchestration(APDSubroNavigatorDTO adpSubroNavDto, boolean batchtest)
    {
        APDSubroConsumer consumer = new APDSubroConsumer();
        consumer.setAPDSubroID(adpSubroNavDto.getIdInfo());
        consumer.setNavigatorDto(adpSubroNavDto);
        consumer.setConsumerType(ConsumerType.CLAIMS_CENTER);
        PredictiveModelingOrchestration pmOrchestration = new PredictiveModelingOrchestration(); 
        return pmOrchestration.executeAPDSubroModel(consumer, batchtest);
    }
}