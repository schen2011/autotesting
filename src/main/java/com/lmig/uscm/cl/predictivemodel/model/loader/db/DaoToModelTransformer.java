/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.model.loader.db;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lmig.uscm.cl.predictivemodel.enums.CoeffKey;
import com.lmig.uscm.cl.predictivemodel.enums.EngineType;
import com.lmig.uscm.cl.predictivemodel.enums.ModelType;
import com.lmig.uscm.cl.predictivemodel.enums.PredictiveModel;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffMetadata;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffModelValue;
import com.lmig.uscm.cl.predictivemodel.service.PredictiveModelService;
import com.lmig.uscm.cl.predictivemodel.service.PredictiveModelServiceImpl;
import com.lmig.uscm.cl.predictivemodel.service.model.Metadata;
import com.lmig.uscm.cl.predictivemodel.service.model.Pilot;
import com.lmig.uscm.cl.predictivemodel.utils.TransformUtils;

/**
 * @author AbhiVerma
 *
 */
public final class DaoToModelTransformer
{
    /**
     * private constructor
     */
    private DaoToModelTransformer()
    {   }

    /**
     * @author AbhiVerma
     * SingletonHolder class
     */
    //CHECKSTYLE:OFF
    private static class SingletonHolder
    //CHECKSTYLE:ON
    {
        public static final DaoToModelTransformer TRANSFORMER_INSTANCE = new DaoToModelTransformer();
    }
    /**
     * @return
     */
    public static DaoToModelTransformer getInstance()
    {
        return SingletonHolder.TRANSFORMER_INSTANCE;
    }

    /**
     * @param predModel
     * @param engineType
     * @return
     */
    public Metadata getMetadataFromDB(PredictiveModel predModel, EngineType engineType)
    {
        PredictiveModelService service = new PredictiveModelServiceImpl();
        Metadata result = service.getPredictiveModel(predModel.getDesc(), engineType.getDesc());
        return result;
    }

    /**
     * @param result
     * @return
     */
    public CoeffMetadata prepareCoeffMetadata(Metadata result, PredictiveModel pm)
    {
        CoeffMetadata coeffMetadata = new CoeffMetadata();
        coeffMetadata.setModelId(result.getId());
        coeffMetadata.setModelName(result.getModelName());
        coeffMetadata.setModelExecutionMode(result.getModelExecutionMode());
        coeffMetadata.setModelVersion(result.getModelVersion());
        coeffMetadata.setActiveIndicator(TransformUtils.convertStringToBoolean(result.getModelActiveIndicator()));
        coeffMetadata.setModelWeightage(result.getWeightage());
        coeffMetadata.setCreateDateTime(result.getCreateDatetime());
        coeffMetadata.setCreateUser(result.getCreateUser());
        coeffMetadata.setUpdateDateTime(result.getUpdateDatetime());
        coeffMetadata.setUpdateUser(result.getUpdateUser());
        if (result.getPilot() != null)
        {
            coeffMetadata.setPilotCriteria(result.getPilot().getPilotCriteria());
            coeffMetadata.setPilotValue(result.getPilot().getPilotValue());
        }
        else
        {
            Pilot pil = new Pilot();
            coeffMetadata.setPilotCriteria(pil.getPilotCriteria());
            coeffMetadata.setPilotValue(pil.getPilotValue());
        }

        return coeffMetadata;
    }

    /**
     * @param result
     * @return
     */
    public Map<CoeffKey, Map<ModelType, CoeffModelValue>> prepareCoeffKeyModelValueMap(Metadata result)
    {
        Map<CoeffKey, Map<ModelType, CoeffModelValue>> coeffKeyModelValueMap = 
            new HashMap<CoeffKey, Map<ModelType, CoeffModelValue>>();
        Map<ModelType, CoeffModelValue> coeffModelTypeValueMap = null;
        CoeffKey cKey = null;
        ModelType modelType = null;
        CoeffModelValue modelValue = null;
        try
        {
            for (String resultKey : result.getCoefficients().keySet())
            {
                coeffModelTypeValueMap = new HashMap<ModelType, CoeffModelValue>();
                cKey = TransformUtils.getCoefficientKey(resultKey);
                Map<String, BigDecimal> resultValues = result.getCoefficients().get(resultKey);
                for (String resultValuesKey : resultValues.keySet())
                {
                    modelType = TransformUtils.getModelType(resultValuesKey);
                    modelValue = new CoeffModelValue();
                    modelValue.setModelValue(resultValues.get(resultValuesKey));
                    coeffModelTypeValueMap.put(modelType, modelValue);
                }
                coeffKeyModelValueMap.put(cKey, coeffModelTypeValueMap);
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }

        return coeffKeyModelValueMap;
    }

    /**
     * @param result
     * @return
     */
    public Set<CoeffKey> createCoeffKeySet(Metadata result)
    {
        Set<CoeffKey> coeffKeySet = new HashSet<CoeffKey>();
        CoeffKey cKey = null;
        for (String resultKey : result.getCoefficients().keySet())
        {
            cKey = TransformUtils.getCoefficientKey(resultKey);
            coeffKeySet.add(cKey);
        }
        return coeffKeySet;
    }
}
