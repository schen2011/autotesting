/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.impl.apdsubro.helper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.lmig.uscm.cl.predictivemodel.enums.CoeffKey;
import com.lmig.uscm.cl.predictivemodel.enums.ModelType;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroOutput;
import com.lmig.uscm.cl.predictivemodel.intf.IAPDSubroCalculator;
import com.lmig.uscm.cl.predictivemodel.utils.CalculationUtil;

/**
 * @author BoChen
 *
 */
public class APDSubroHelper
{
    private static final String ZERO_DEC = "0.0";
    private static final String ZERO_INT = "0";
    private static final String ONE = "1.0";
    private APDSubroModel model;
    private BigDecimal coefficientTotal = BigDecimal.ZERO;
    private IAPDSubroCalculator calculator;
    private Map<String, BigDecimal> coeffUsed;
    private APDSubroOutput adpSubroOutput;

    /***
     * 
     * @param model
     */
    public APDSubroHelper(APDSubroModel model) 
    {
        this.model = model;
    }
    
    /***
     * 
     * @param modelType
     * @param coeffKeyDtoValueMap
     * @return
     */
    public APDSubroOutput runCalculations(
        ModelType modelType,
        Map<CoeffKey, String> coeffKeyDtoValueMap,
        APDSubroOutput adpsubroOutputOrig)
    {
        this.adpSubroOutput = adpsubroOutputOrig;
        try 
        {
            CoeffModel coeffModel = model.getModel().getCoeffModel();
            this.coeffUsed = new HashMap<String, BigDecimal>();
            this.coefficientTotal = getTotalScore(coeffModel, modelType, coeffKeyDtoValueMap);        
            double predScore = calculatePredictiveScore(modelType, coeffModel);

            if (isProbability(modelType))
            {
                adpSubroOutput.setProbabilityScore(predScore);
                adpSubroOutput.setCoefficientUsedProb(coeffUsed);
            }
            else if (isRecoveryAmount(modelType))
            {
                adpSubroOutput.setRecoveryamountScore(predScore);
                adpSubroOutput.setCoefficientUsedReco(coeffUsed);
            }
        }
        catch (Exception ex) 
        {
            throw ex;
        }
        return adpSubroOutput;
    }

    /**
     * 
     * @param modelType
     * @param coeffModel
     * @return
     */
    public double calculatePredictiveScore(
        ModelType modelType,
        CoeffModel coeffModel) 
    {
        return getCalculator(modelType, coeffModel)
            .calculate(coefficientTotal);
    }
    
    /***
     * 
     * @param modelType
     * @param coeffModel
     * @return
     */
    protected IAPDSubroCalculator getCalculator(
        ModelType modelType,
        CoeffModel coeffModel) 
    {
        try
        {
            if (isProbability(modelType)) 
            {
                coefficientTotal = coefficientTotal.add(
                    coeffModel.getCoeffKeyModelValueMap()
                        .get(CoeffKey.INTERCEPT)
                        .get(ModelType.PROBABILITY).getModelValue());
//                System.out.println("Intercept for Probabilty:" + coeffModel.getCoeffKeyModelValueMap()
//                    .get(CoeffKey.INTERCEPT)
//                    .get(ModelType.PROBABILITY).getModelValue());
                coeffUsed.put(CoeffKey.INTERCEPT.toString(), coeffModel.getCoeffKeyModelValueMap()
                    .get(CoeffKey.INTERCEPT)
                    .get(ModelType.PROBABILITY).getModelValue());
                calculator = new APDSubroProbabilityCalculator();
            } 
            else if (isRecoveryAmount(modelType)) 
            {
                coefficientTotal = coefficientTotal.add(
                    coeffModel.getCoeffKeyModelValueMap()
                        .get(CoeffKey.INTERCEPT)
                        .get(ModelType.RECOVERYAMOUNT).getModelValue());
//                System.out.println("Intercept for Recovery:" + coeffModel.getCoeffKeyModelValueMap()
//                    .get(CoeffKey.INTERCEPT)
//                    .get(ModelType.PROBABILITY).getModelValue());
                coeffUsed.put(CoeffKey.INTERCEPT.toString(), coeffModel.getCoeffKeyModelValueMap()
                    .get(CoeffKey.INTERCEPT)
                    .get(ModelType.RECOVERYAMOUNT).getModelValue());
                calculator = new APDSubroRecoveryAmountCalculator();
            }
        }
        catch (Exception ex)
        {
        	throw ex;
        }
        return calculator;
    }

    /**
     * @param coeffModel
     * @param modelType
     * @param coeffKeyDtoValueMap
     */
    public BigDecimal getTotalScore(CoeffModel coeffModel, ModelType modelType
            , Map<CoeffKey, String> coeffKeyDtoValueMap)
    {
        BigDecimal coeffTotal = BigDecimal.ZERO;
        try
        {
            for (CoeffKey cKey : coeffModel.getCoeffKeySet())
            {
                if (cKey.toString().equals("INTERCEPT"))
                { continue; }
                if (cKey.toString().equals("THRESHOLD"))
                {
                    if (!adpSubroOutput.hasThreshold())
                    {
                        BigDecimal modelCoeff = coeffModel.getCoeffKeyModelValueMap()
                            .get(cKey).get(modelType).getModelValue();
                        adpSubroOutput.setThreshold(modelCoeff);
                        continue;
                    }
                    else 
                    { continue; }
                }
                String dtoValue = coeffKeyDtoValueMap.get(cKey);
                String modelValue = coeffModel.getCoeffKeyValueMap().get(cKey)
                    .getInput1Value1();
                
                if (modelValue == null || dtoValue == null)
                { continue; }
                else if (modelValue.startsWith("DRIVERAGE"))
                {
                    ADPSubroDriverAgeCal driverageCal = 
                        new ADPSubroDriverAgeCal(Integer.parseInt(dtoValue));
                    String[] driverAgeArr = modelValue.split("_");
                    BigDecimal driverageCoeff = 
                        driverageCal.getCoefficientByA(driverAgeArr[driverAgeArr.length - 1]);
                    BigDecimal modelCoeff = coeffModel.getCoeffKeyModelValueMap()
                        .get(cKey).get(modelType).getModelValue();
                    modelCoeff = CalculationUtil.multiply(modelCoeff.toString()
                        , driverageCoeff.toString()); 
                    coeffUsed.put(modelValue.toString(), modelCoeff);
                    coeffTotal = coeffTotal.add(modelCoeff);  
                }
                else if (modelValue.endsWith("_ACTUAL"))
                {
                    BigDecimal modelCoeff = coeffModel.getCoeffKeyModelValueMap()
                        .get(cKey).get(modelType).getModelValue();
                    modelCoeff = CalculationUtil
                        .multiply(modelCoeff.toString(), dtoValue); 
                    coeffUsed.put(modelValue.toString(), modelCoeff);
                    coeffTotal = coeffTotal.add(modelCoeff);  
                }
                else if (modelValue.endsWith("_LOG"))
                {
                    BigDecimal modelCoeff = coeffModel.getCoeffKeyModelValueMap()
                        .get(cKey).get(modelType).getModelValue();
                    if (dtoValue.equals(ZERO_DEC) || dtoValue.equals(ZERO_INT)) 
                    {  dtoValue = ONE; }
                    BigDecimal grossLossCoeff = 
                        new BigDecimal(Math.log(Double.parseDouble(dtoValue))); 
                    modelCoeff = CalculationUtil.multiply(modelCoeff.toString(), grossLossCoeff.toString()); 
                    coeffUsed.put(modelValue.toString(), modelCoeff);
                    coeffTotal = coeffTotal.add(modelCoeff);  
                }
                else if (dtoValue.equalsIgnoreCase(modelValue))
                {
                    BigDecimal modelCoeff = coeffModel.getCoeffKeyModelValueMap()
                            .get(cKey).get(modelType).getModelValue();
                    coeffUsed.put(cKey.toString(), modelCoeff);
                    coeffTotal = coeffTotal.add(modelCoeff);  
                }
                else 
                { continue; }
            }
            return coeffTotal;   
        }
        catch (NumberFormatException nex)
        { throw nex; }
        catch (Exception ex)
        { throw ex; }
    }
    
    /***
     *  
     * @param modelType
     * @return
     */
    private boolean isProbability(ModelType modelType)
    {
        return modelType == ModelType.PROBABILITY;
    }
    /***
     * 
     * @param modelType
     * @return
     */
    private boolean isRecoveryAmount(ModelType modelType) 
    {
        return modelType == ModelType.RECOVERYAMOUNT;
    }
    
}
