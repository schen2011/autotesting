/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

import com.lmig.uscm.cl.predictivemodel.enums.DataSource;
import com.lmig.uscm.cl.predictivemodel.enums.EngineType;
import com.lmig.uscm.cl.predictivemodel.enums.ModelType;
import com.lmig.uscm.cl.predictivemodel.enums.PredictiveModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.helper.APDSubroHelper;
import com.lmig.uscm.cl.predictivemodel.intf.IPredictiveModelingEngine;
import com.lmig.uscm.cl.predictivemodel.model.loader.APDSubroModelFactory;

/**
 * @author BoChen
 *
 */
public class APDSubroEngine
    implements
    IPredictiveModelingEngine<APDSubroModel, APDSubroConsumer, APDSubroInput, APDSubroOutput>
{

    /**
     * @return
     */
    public APDSubroModel getPredictiveModel(PredictiveModel predModel, EngineType engineType, DataSource ds) 
    {
        return (APDSubroModel) APDSubroModelFactory.getAPDSubroModel(predModel, engineType, ds);
    }

    /***
     * 
     */
    @Override
    public APDSubroOutput execute(APDSubroModel model, APDSubroConsumer consumer,
        APDSubroInput input)
    {
        APDSubroOutput output = new APDSubroOutput();
        APDSubroHelper helper = new APDSubroHelper(model);
        Queue<ModelType> modelqueue = new LinkedList<ModelType>();
        modelqueue.add(ModelType.PROBABILITY);
        modelqueue.add(ModelType.RECOVERYAMOUNT);
        while (!modelqueue.isEmpty())
        {
            helper.runCalculations(modelqueue.poll(), input.getDto()
                .getCoeffKeyDtoValueMap(), output);
            //System.out.println("***************************************");
        }
        if (output.hasProbabilityScore() && output.hasRecoveryamountScore()
            && output.hasThreshold())
        {
            BigDecimal probScore = output.getProbabilityScore();
            BigDecimal recoScore = output.getRecoveryamountScore();
            output.setExpectedRecoveryAmount(probScore.multiply(recoScore));
            output.setDecision();
        }
        return output;
    }
}
