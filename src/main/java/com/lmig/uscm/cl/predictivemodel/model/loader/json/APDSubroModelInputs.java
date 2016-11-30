/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.model.loader.json;


import com.google.gson.annotations.SerializedName;

/**
 * @author Chris Daub
 *
 */

public class APDSubroModelInputs
{
    @SerializedName("Coefficient Key")
    private String coefficientKey;

    @SerializedName("Model Type 1")
    private String modelType1;

    @SerializedName("Model Value 1")
    private String modelValue1;

    @SerializedName("Model Type 2")
    private String modelType2;

    @SerializedName("Model Value 2")
    private String modelValue2;

    @SerializedName("Input 1")
    private String input1;

    @SerializedName("Input 1 Value 1")
    private String input1Value1;

    /**
     * @return the coefficientKey
     */
    public String getCoefficientKey()
    {
        return coefficientKey;
    }

    /**
     * Sets coefficientKey.
     * 
     * @param     coefficientKey the coefficientKey to set
     */
    public void setCoefficientKey(String coefficientKey)
    {
        this.coefficientKey = coefficientKey;
    }

    /**
     * @return the modelType1
     */
    public String getModelType1()
    {
        return modelType1;
    }

    /**
     * Sets modelType1.
     * 
     * @param     modelType1 the modelType1 to set
     */
    public void setModelType1(String modelType1)
    {
        this.modelType1 = modelType1;
    }

    /**
     * @return the modelValue1
     */
    public String getModelValue1()
    {
        return modelValue1;
    }

    /**
     * Sets modelValue1.
     * 
     * @param     modelValue1 the modelValue1 to set
     */
    public void setModelValue1(String modelValue1)
    {
        this.modelValue1 = modelValue1;
    }

    /**
     * @return the modelType2
     */
    public String getModelType2()
    {
        return modelType2;
    }

    /**
     * Sets modelType2.
     * 
     * @param     modelType2 the modelType2 to set
     */
    public void setModelType2(String modelType2)
    {
        this.modelType2 = modelType2;
    }

    /**
     * @return the modelValue2
     */
    public String getModelValue2()
    {
        return modelValue2;
    }

    /**
     * Sets modelValue2.
     * 
     * @param     modelValue2 the modelValue2 to set
     */
    public void setModelValue2(String modelValue2)
    {
        this.modelValue2 = modelValue2;
    }

    /**
     * @return the input1
     */
    public String getInput1()
    {
        return input1;
    }

    /**
     * Sets input1.
     * 
     * @param     input1 the input1 to set
     */
    public void setInput1(String input1)
    {
        this.input1 = input1;
    }

    /**
     * @return the input1Value1
     */
    public String getInput1Value1()
    {
        return input1Value1;
    }

    /**
     * Sets input1Value1.
     * 
     * @param     input1Value1 the input1Value1 to set
     */
    public void setInput1Value1(String input1Value1)
    {
        this.input1Value1 = input1Value1;
    }
}
