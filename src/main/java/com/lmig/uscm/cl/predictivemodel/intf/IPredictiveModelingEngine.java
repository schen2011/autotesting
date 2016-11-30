/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.intf;


/**
 * 
 * @author BoChen
 *
 * @param <IPredictiveModel>
 * @param <IPredictiveModelConsumer>
 * @param <IPredictiveModelInput>
 * @param <IPredictiveModelOutput>
 */
@SuppressWarnings("hiding")
public interface IPredictiveModelingEngine<IPredictiveModel, IPredictiveModelConsumer, IPredictiveModelInput
    , IPredictiveModelOutput>
{
    /**
     * 
     * @param consumer
     * @param input
     * @return
     */
    IPredictiveModelOutput execute(IPredictiveModel model, 
        IPredictiveModelConsumer consumer, IPredictiveModelInput input);
}
