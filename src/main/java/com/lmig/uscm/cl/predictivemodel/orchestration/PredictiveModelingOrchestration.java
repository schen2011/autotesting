/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.orchestration;

/**
 * @author Abhi Verma
 * Orchestration class for Predictive Modeling Development
 */

import com.lmig.uscm.cl.predictivemodel.enums.ConsumerType;
import com.lmig.uscm.cl.predictivemodel.enums.PredictiveModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroConsumer;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroOutput;

/**
 * 
 * @author Abhi Verma
 *
 */
public class PredictiveModelingOrchestration
{

    /***
     * 
     * @param consumer
     * @return
     */
    //return boolean
    public boolean executeAPDSubroModel(APDSubroConsumer consumer)
    {
        boolean runSub = false;
        if (ConsumerType.CLAIMS_CENTER.equals(consumer.getConsumerType()))
        {
            runSub = APDSubroOrchestration.getInstance().runPredictiveModel(consumer);
        }
        return runSub;
    }
    
    /***
     * 
     * @param consumer
     * @param model
     * @return
     */
    public boolean executeAPDSubroModel(APDSubroConsumer consumer, PredictiveModel model)
    {
        boolean runSub = false;
        if (ConsumerType.CLAIMS_CENTER.equals(consumer.getConsumerType()))
        {
            runSub = APDSubroOrchestration.getInstance().runPredictiveModel(consumer, model);
        }
        return runSub;
    }

	public APDSubroOutput executeAPDSubroModel(APDSubroConsumer consumer
			, boolean batchtest)
	{
		APDSubroOutput output = new APDSubroOutput();
        if (ConsumerType.CLAIMS_CENTER.equals(consumer.getConsumerType()))
        {
        	output = APDSubroOrchestration.getInstance().runPredictiveModel(consumer, batchtest);
        }
        return output;
	}

}
