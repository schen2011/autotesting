/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.lmig.uscm.cl.predictivemodel.dao.dto.ModelCoefficientDetail;
import com.lmig.uscm.cl.predictivemodel.dao.dto.ModelMetadata;
import com.lmig.uscm.cl.predictivemodel.enums.PilotCriteria;
import com.lmig.uscm.cl.predictivemodel.service.model.Metadata;
import com.lmig.uscm.cl.predictivemodel.service.model.Pilot;

/**
 * @author SamirKeco
 *
 */
public final class DaoToServiceMappingUtil
{
    /**
     * Empty constructor.
     */
    private DaoToServiceMappingUtil()
    {
    }
    
    /**
     * Maps the dao object ModelMetadata to Metadata object.
     * @param input - dao object
     * @return Service Object
     */
    public static Metadata mapModelMetatdataToMetadata(
        ModelMetadata input)
    {
        Metadata result = null;
        if (input != null)
        {
            result = new Metadata();
            
            result.setId(input.getId());
            result.setModelName(input.getModelName());
            result.setModelExecutionMode(input.getModelExecutionMode());
            result.setModelVersion(input.getModelVersion());
            result.setModelActiveIndicator(input.getModelActiveIndicator());
            result.setWeightage(input.getWeightage());
            result.setCreateDatetime(input.getCreateDatetime());
            result.setCreateUser(input.getCreateUser());
            result.setUpdateDatetime(input.getUpdateDatetime());
            result.setUpdateUser(input.getUpdateUser());
            if (input.getPilotCriteria() != null && 
                input.getPilotCriteria().getCriteriaName() != null && 
                input.getPilotCriteria().getCriteriaName().trim()
                .equalsIgnoreCase(PilotCriteria.LOSS_STATE.getDesc()) && 
                input.getPilotCriteria().getCriteriaValue() != null)
            {
                mapPilotStates(input, result);
            }
            else if (input.getPilotCriteria() != null && 
                input.getPilotCriteria().getCriteriaName() != null && 
                input.getPilotCriteria().getCriteriaName().trim()
                .equalsIgnoreCase(PilotCriteria.N_NUMBERS.getDesc()) && 
                input.getPilotCriteria().getCriteriaValue() != null)
            {
                mapNNumbers(input, result);
            }
            mapCoefficients(input, result);
        }
        return result;
    }
    /**
     * 
     * @param input
     * @param result
     */
    private static void mapNNumbers(ModelMetadata input, Metadata result)
    {
        Map<String, String> nNumbers = new HashMap<String, String>();
        String value = input.getPilotCriteria().getCriteriaValue();
        if (value != null)
        {
            String[] listOfNumbers = value.split(",");
            String trimNum = null;
            for (String nNumber : listOfNumbers)
            {
                trimNum = nNumber.trim();
                if (!trimNum.isEmpty())
                {
                    nNumbers.put(trimNum, trimNum);
                }
            }
        }
        
        Pilot pilot = new Pilot();
        pilot.setPilotCriteria(value);
        pilot.setPilotValue(nNumbers);
        
        result.setPilot(pilot);
    }

    /**
     * Takes string and splits it up by commas. The split strings are then added
     * to a list.
     * 
     * @param input - contains the string which will be split up
     * @param result - adds the split up string to the loss states on the Pilot
     *                  object
     */
    private static void mapPilotStates(ModelMetadata input, Metadata result)
    {
        Map<String, String> lossStates = new HashMap<String, String>();
        String value = input.getPilotCriteria().getCriteriaValue();
        if (value != null)
        {
            String[] listOfStates = value.split(",");
            String trimState = null;
            for (String state : listOfStates)
            {
                trimState = state.trim();
                if (!trimState.isEmpty())
                {
                    lossStates.put(trimState, trimState);
                }
            }
        }

        Pilot pilot = new Pilot();
        pilot.setPilotCriteria(value);
        pilot.setPilotValue(lossStates);
        
        result.setPilot(pilot);
    }
    
    /**
     * Maps the ModelMetadata to Metadata. 
     * 
     * @param input - object returned by the dao
     * @param result - object to be populated
     */
    private static void mapCoefficients(ModelMetadata input, Metadata result)
    {
        Map<String, Map<String, BigDecimal>> coefficients = 
            new HashMap<String, Map<String, BigDecimal>>();

        Map<String, BigDecimal> coefficientsValues = null;

        String coefficientKey = null;
        String modelType = null;
        BigDecimal modelValue = null;

        if (input.getCoeffList() != null &&
            !input.getCoeffList().isEmpty())
        {
            for (ModelCoefficientDetail coeffDtl : input.getCoeffList())
            {
                if (coeffDtl != null &&
                    coeffDtl.getCoefficientKey() != null)
                {
                    coefficientKey = coeffDtl.getCoefficientKey();
                    modelType = coeffDtl.getModelType();
                    modelValue = coeffDtl.getModelValue();
                    if (coefficients.containsKey(coefficientKey))
                    {
                        coefficientsValues = coefficients.get(coefficientKey);
                    }
                    else 
                    {
                        coefficientsValues = new HashMap<String, BigDecimal>();
                    }
                    coefficientsValues.put(modelType, modelValue);
                    coefficients.put(coefficientKey, coefficientsValues);   
                }
            }
        }
        if (!coefficients.isEmpty())
        {
            result.setCoefficients(coefficients);
        }
    }
}
