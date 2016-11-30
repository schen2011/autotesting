/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.model.loader.json;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lmig.uscm.cl.predictivemodel.enums.CoeffInput;
import com.lmig.uscm.cl.predictivemodel.enums.CoeffKey;
import com.lmig.uscm.cl.predictivemodel.enums.ModelType;
import com.lmig.uscm.cl.predictivemodel.enums.PredictiveModel;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffMetadata;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffModel;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffModelValue;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffValue;
import com.lmig.uscm.cl.predictivemodel.utils.TransformUtils;

/**
 * @author Abhi Verma
 *
 */
public final class JsonToModelTransformer
{
    /**
     * private constructor
     */
    private JsonToModelTransformer()
    {
    }

    /**
     * @author AbhiVerma
     * SingletonHolder class
     */
    //CHECKSTYLE:OFF
    private static class SingletonHolder
    //CHECKSTYLE:ON
    {
        public static final JsonToModelTransformer TRANSFORMER_INSTANCE = 
            new JsonToModelTransformer();
    }
    /**
     * @return
     */
    public static JsonToModelTransformer getInstance()
    {
        return SingletonHolder.TRANSFORMER_INSTANCE;
    }
    
    /**
     * 
     * @param pm
     * @return
     */
    public CoeffMetadata prepareCoeffMetadata(PredictiveModel pm)
    {
        CoeffMetadata metaData;
        switch (pm)
        {
            case APD_SUBRO_PRED_MDL_A:
            case APD_SUBRO_PRED_MDL_B:
                metaData = this.prepareAPDSubroCoeffMetadata();
                break;
            default:
                metaData = new CoeffMetadata();
                break;
        }
        return metaData;
    }
    
    /**
     * 
     * @param pm
     * @return
     */
    public CoeffModel prepareCoeffModel(PredictiveModel pm) 
    {
        CoeffModel coeffs; 
        switch (pm)
        {
            case APD_SUBRO_PRED_MDL_A:
            case APD_SUBRO_PRED_MDL_B:
                coeffs = this.prepareAPDSubroCoeffModel();
                break;
            default:
                coeffs = new CoeffModel();
                break;
        }
        return coeffs;
    }
    

    /**
     * @return
     */
    public Map<CoeffKey, CoeffValue> prepareCoeffKeyValueMap(PredictiveModel pm)
    {
        Map<CoeffKey, CoeffValue> out;
        switch (pm)
        {
            case APD_SUBRO_PRED_MDL_A:
            case APD_SUBRO_PRED_MDL_B:
                List<APDSubroModelInputs> apdModelInputs = JsonLoader.createAPDSubroModelInputs();
                out = createAPDSubroCoeffKeyValueMap(apdModelInputs);
                break;
            default:
                out = new HashMap<CoeffKey, CoeffValue>();
        }
        return out;
    }
    
    /**
     * @return
     */
    private CoeffMetadata prepareAPDSubroCoeffMetadata()
    {
        CoeffMetadata coeffMetadata = new CoeffMetadata();
        List<APDSubroModelMetadata> apdModelMetadataList = 
            JsonLoader.createAPDSubroModelMetadata();
        for (APDSubroModelMetadata apdModelMetadata : apdModelMetadataList)
        {
            coeffMetadata.setModelId(
                TransformUtils.convertStringToInteger(
                    apdModelMetadata.getModelId()));
            coeffMetadata.setModelName(apdModelMetadata.getModelName());
            coeffMetadata.setModelExecutionMode(
                apdModelMetadata.getModelExecutionMode());
            coeffMetadata.setModelVersion(
                TransformUtils.convertStringToDouble(
                    apdModelMetadata.getModelVersion()));
            coeffMetadata.setActiveIndicator(
                TransformUtils.convertStringToBoolean(
                    apdModelMetadata.getModelActiveIndicator()));
            coeffMetadata.setModelWeightage(
                TransformUtils.convertStringToInteger(
                    apdModelMetadata.getModelWeightage()));
            coeffMetadata.setCreateDateTime(
                TransformUtils.convertStringToDate(
                    apdModelMetadata.getCreateDateTime()));
            coeffMetadata.setCreateUser(apdModelMetadata.getCreateUser());
            coeffMetadata.setUpdateDateTime(
                TransformUtils.convertStringToDate(
                    apdModelMetadata.getUpdateDateTime()));
            coeffMetadata.setUpdateUser(apdModelMetadata.getUpdateUser());
            coeffMetadata.setPilotCriteria(apdModelMetadata.getPilotCriteria());
            coeffMetadata.setPilotValue(
                TransformUtils.createPilotCriteriaMap(
                    apdModelMetadata.getPilotValue()));
        }
        return coeffMetadata;
    }

    /**
     * 
     * @return
     */
    private CoeffModel prepareAPDSubroCoeffModel()
    {
        CoeffModel coeffModel = new CoeffModel();
        List<APDSubroModelCoefficients> apdModelCoefficients = 
            JsonLoader.createAPDSubroModelCoefficients();
        List<APDSubroModelInputs> apdModelInputs = 
            JsonLoader.createAPDSubroModelInputs();
        coeffModel.setCoeffKeyModelValueMap(
            createAPDSubroCoeffKeyModelValueMap(apdModelCoefficients));
        coeffModel.setCoeffKeyValueMap(createAPDSubroCoeffKeyValueMap(apdModelInputs));
        coeffModel.setCoeffKeySet(createAPDSubroCoeffKeySet(apdModelCoefficients));
        return coeffModel;
    }

    /**
     * 
     * @param apdModelCoefficients
     * @return
     */
    private Set<CoeffKey> createAPDSubroCoeffKeySet(
        List<APDSubroModelCoefficients> apdModelCoefficients)
    {
        Set<CoeffKey> coeffKeySet = new HashSet<CoeffKey>();
        CoeffKey cKey = null;
        for (APDSubroModelCoefficients modelCoeff : apdModelCoefficients)
        {
            cKey = TransformUtils.getCoefficientKey(
                modelCoeff.getCoefficientKey());
            coeffKeySet.add(cKey);
        }
        return coeffKeySet;
    }
    
    /**
     * 
     * @param apdModelInputs
     * @return
     */
    private Map<CoeffKey, CoeffValue> createAPDSubroCoeffKeyValueMap(
        List<APDSubroModelInputs> apdModelInputs)
    {
        Map<CoeffKey, CoeffValue> coeffKeyInputValueMap = 
            new HashMap<CoeffKey, CoeffValue>();
        CoeffKey cKey = null;
        CoeffValue cValue = null;

        CoeffInput cInput1;
        String input1Value1;
        for (APDSubroModelInputs modelInputs : apdModelInputs)
        {
            cValue = new CoeffValue();
            cKey = TransformUtils.getCoefficientKey(
                modelInputs.getCoefficientKey());
            cInput1 = TransformUtils.getCoefficientInput(
                modelInputs.getInput1());
            input1Value1 = modelInputs.getInput1Value1();
            cValue.setInput1(cInput1);
            cValue.setInput1Value1(input1Value1);
            cValue.setInputValue1Value2(
                TransformUtils.getCoefficientValue(
                    input1Value1, null, null, null));
            coeffKeyInputValueMap.put(cKey, cValue);
        }
        return coeffKeyInputValueMap;
    }

    /**
     * 
     * @param apdModelCoefficients
     * @return
     */
    private Map<CoeffKey, Map<ModelType, CoeffModelValue>> 
    createAPDSubroCoeffKeyModelValueMap(
        List<APDSubroModelCoefficients> apdModelCoefficients)
    {
        Map<CoeffKey, Map<ModelType, CoeffModelValue>> coeffKeyModelValueMap = 
            new HashMap<CoeffKey, Map<ModelType, CoeffModelValue>>();
        Map<ModelType, CoeffModelValue> coeffModelTypeValueMap = null;

        CoeffKey cKey = null;

        ModelType modelType1 = null;
        ModelType modelType2 = null;

        CoeffModelValue complexModelValue = null;
        CoeffModelValue severeModelValue = null;

        for (APDSubroModelCoefficients modelCoeff : apdModelCoefficients)
        {
            coeffModelTypeValueMap = new HashMap<ModelType, CoeffModelValue>();
            cKey = TransformUtils.getCoefficientKey(
                modelCoeff.getCoefficientKey());
            modelType1 = TransformUtils.getModelType(
                modelCoeff.getModelType1());
            modelType2 = TransformUtils.getModelType(
                modelCoeff.getModelType2());
            complexModelValue = new CoeffModelValue();
            complexModelValue.setModelValue(
                TransformUtils.convertStringToBigDecimal(
                    modelCoeff.getModelValue1()));
            severeModelValue = new CoeffModelValue();
            severeModelValue.setModelValue(
                TransformUtils.convertStringToBigDecimal(
                    modelCoeff.getModelValue2()));
            coeffModelTypeValueMap.put(modelType1, complexModelValue);
            coeffModelTypeValueMap.put(modelType2, severeModelValue);
            coeffKeyModelValueMap.put(cKey, coeffModelTypeValueMap);
        }
        return coeffKeyModelValueMap;
    }
}