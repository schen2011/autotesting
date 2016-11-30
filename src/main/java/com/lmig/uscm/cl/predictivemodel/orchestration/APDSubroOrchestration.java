/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.orchestration;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.lmig.uscm.cl.predictivemodel.enums.DataSource;
import com.lmig.uscm.cl.predictivemodel.enums.EngineType;
import com.lmig.uscm.cl.predictivemodel.enums.LossType;
import com.lmig.uscm.cl.predictivemodel.enums.PredictiveModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroConsumer;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroDTO;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroEngine;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroInput;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroModelComposite;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroNavigatorDTO;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroOutput;
import com.lmig.uscm.cl.predictivemodel.intf.IPredictiveModelConsumer;
import com.lmig.uscm.cl.predictivemodel.utils.JSONUtil;

/**
 * @author BoChen
 *
 */
public final class APDSubroOrchestration
{
    private static final String ALL = "ALL";
    //private static APDSubroOrchestration instance;

    /**
     * private DataSource variable 
     */
    private DataSource ds = DataSource.DB;
    
    /**
     * private constructor 
     */
    private APDSubroOrchestration()
    { }
    
    /***
     * 
     * @author BoChen
     *
     */
    //CHECKSTYLE:OFF
    private static class ADPSubroHolder
    {
    //CHECKSTYLE:ON
        public static final APDSubroOrchestration APD_SUBRO_ORCHESTRATION = 
            new APDSubroOrchestration();    
        /**
         * Private constructor for static class
         */
        private ADPSubroHolder()
        { }
    }  
    
    /**
     * @return
     */
    public static APDSubroOrchestration getInstance()
    {
        return ADPSubroHolder.APD_SUBRO_ORCHESTRATION;
    }

    /**
     * @return the ds
     */
    public DataSource getDs()
    {   return ds;  }    
    /**
     * Sets ds.
     * 
     * @param     ds the ds to set
     */
    public void setDs(DataSource ds)
    {   this.ds = ds;   }

    
    /****
     * 
     */
    public Boolean runPredictiveModel(IPredictiveModelConsumer consumerInput)
    {
        PredictiveModel preModelA = PredictiveModel.APD_SUBRO_PRED_MDL_A;
        PredictiveModel preModelB = PredictiveModel.APD_SUBRO_PRED_MDL_B;
        Queue<PredictiveModel> modelQueue = new LinkedList<PredictiveModel>();
        modelQueue.offer(preModelA); 
        modelQueue.offer(preModelB);
        boolean decision = false;
        while (!modelQueue.isEmpty())
        {
            boolean modelRes = runPredictiveModel(consumerInput, modelQueue.poll());
            if (decision || modelRes)
            {
                decision = true;
            }
        }
        return decision;
    }
    
    public APDSubroOutput runPredictiveModel(IPredictiveModelConsumer consumerInput
    		, boolean batchtest)
    {
        PredictiveModel preModelA = PredictiveModel.APD_SUBRO_PRED_MDL_A;
        PredictiveModel preModelB = PredictiveModel.APD_SUBRO_PRED_MDL_B;
        Queue<PredictiveModel> modelQueue = new LinkedList<PredictiveModel>();
        modelQueue.offer(preModelA); 
        modelQueue.offer(preModelB);
        boolean decision = false;
        APDSubroOutput output = new APDSubroOutput();
        while (!modelQueue.isEmpty())
        {
        	output = runPredictiveModel(consumerInput, modelQueue.poll(), batchtest);
        }
        return output;
    }

    /***
     * 
     * @param consumer
     * @param model
     * @return
     */
    public Boolean runPredictiveModel(IPredictiveModelConsumer consumerInput, PredictiveModel model)
    {
        boolean resultToNav = false;
        try
        {
            APDSubroConsumer consumer = (APDSubroConsumer) consumerInput;
            EngineType engineType = EngineType.APD_SUBRO_JAVA_IMPL; 
            APDSubroEngine engine = new APDSubroEngine();
            APDSubroModel apdSubroModel = engine.getPredictiveModel(model, engineType, ds);
            APDSubroInput input = createAPDSubroInputObject(consumer);
            boolean meetsOnOffCriteria = 
                meetsOnOffCriteria((APDSubroModelComposite) apdSubroModel.getModel());
            boolean meetsPilotCriteria = meetsPilotCriteria(
                apdSubroModel.getModel().getCoeffMetadata().getPilotValue(), input);
            boolean referred = consumer.getAPDSubroID().getReferredToSub();
            if (consumer.getNavigatorDtoJsonString() == null)
            {
                consumer.setNavigatorDtoJsonString(JSONUtil
                    .objectToJson(consumer.getNavigatorDto()));
            }
            APDSubroOutput output = engine.execute(apdSubroModel, consumer, input);
            output.setPredictiveModel(model);
            output.setEngineType(EngineType.APD_SUBRO_JAVA_IMPL);
            output.setLossType(LossType.AUTO);
            output.setExecutedModelId(apdSubroModel.getModel().getCoeffMetadata().getModelId());
            output.setChosenModelIndicator(referred);
            output.setMeetsOnOffCriteria(meetsOnOffCriteria);
            output.setMeetsPilotCriteria(meetsPilotCriteria);
            if (output.runModel() && meetsOnOffCriteria && meetsPilotCriteria && !referred)
            {   
                resultToNav = true;
                output.setRecommendationToNav(resultToNav);
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        return resultToNav;
    }
    

    public APDSubroOutput runPredictiveModel(IPredictiveModelConsumer consumerInput, PredictiveModel model, 
    		boolean batchTest)
    {
        boolean resultToNav = false;
        APDSubroOutput output;
        try
        {
            APDSubroConsumer consumer = (APDSubroConsumer) consumerInput;
            EngineType engineType = EngineType.APD_SUBRO_JAVA_IMPL; 
            APDSubroEngine engine = new APDSubroEngine();
            APDSubroModel apdSubroModel = engine.getPredictiveModel(model, engineType, ds);
            APDSubroInput input = createAPDSubroInputObject(consumer);
            boolean meetsOnOffCriteria = 
                meetsOnOffCriteria((APDSubroModelComposite) apdSubroModel.getModel());
            boolean meetsPilotCriteria = meetsPilotCriteria(
                apdSubroModel.getModel().getCoeffMetadata().getPilotValue(), input);
            boolean referred = consumer.getAPDSubroID().getReferredToSub();
            if (consumer.getNavigatorDtoJsonString() == null)
            {
                consumer.setNavigatorDtoJsonString(JSONUtil
                    .objectToJson(consumer.getNavigatorDto()));
            }
            output = engine.execute(apdSubroModel, consumer, input);
            output.setPredictiveModel(model);
            output.setEngineType(EngineType.APD_SUBRO_JAVA_IMPL);
            output.setLossType(LossType.AUTO);
            output.setExecutedModelId(apdSubroModel.getModel().getCoeffMetadata().getModelId());
            output.setChosenModelIndicator(referred);
            output.setMeetsOnOffCriteria(meetsOnOffCriteria);
            output.setMeetsPilotCriteria(meetsPilotCriteria);
            if (output.runModel() && meetsOnOffCriteria && meetsPilotCriteria && !referred)
            {   
                resultToNav = true;
                output.setRecommendationToNav(resultToNav);
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        return output;
    }
    
    /**
     * @param pilotCriteriaMap
     * @param input
     * @return
     */
    public boolean meetsPilotCriteria(Map<String, String> map, APDSubroInput input)
    {
        Map<String, String> pilotCriteriaMap = 
            new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        boolean meetsPilotCriteria = false;
        if (map != null)
        {
            pilotCriteriaMap.putAll(map);
        }
        if (map == null || pilotCriteriaMap.isEmpty()
            || input.getDto().getNavDto()
            .getUserNNumber() == null)
        {
            return meetsPilotCriteria;
        }
        
        if (pilotCriteriaMap.containsKey(ALL)
            || pilotCriteriaMap.containsKey(input.getDto()
                .getNavDto().getUserNNumber()))
        {
            meetsPilotCriteria = true;
        }
        return meetsPilotCriteria;
    }


    /**
     * @param consumer
     * @return
     */
    private APDSubroInput createAPDSubroInputObject(APDSubroConsumer consumer)
    {
        APDSubroInput input = new APDSubroInput();
        APDSubroNavigatorDTO navigatorDto = consumer.getNavigatorDto();
        APDSubroDTO adpSubroDTO = new APDSubroDTO(navigatorDto);
        input.setDto(adpSubroDTO);
        adpSubroDTO.loadCoeffKeyDtoValueMap();
        return input;
    }

    /**
     * @param propChnlModelComposite
     * @return
     */
    private boolean meetsOnOffCriteria(APDSubroModelComposite apsSubroModelComposite)
    {
        return apsSubroModelComposite.getCoeffMetadata().isActiveIndicator();
    }
}
