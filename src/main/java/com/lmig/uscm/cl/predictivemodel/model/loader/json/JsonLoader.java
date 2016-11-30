/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.model.loader.json;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Abhi Verma
 *
 */
public final class JsonLoader
{
    //Property Channeling File Paths
    static final String PC_MODEL_METADATA_FILEPATH = "Property_Channeling_Model_Metadata.json";
    static final String PC_MODEL_COEFFICIENTS_FILEPATH = "Property_Channeling_Model_Coefficients.json";
    static final String PC_MODEL_INPUTS_FILEPATH = "Property_Channeling_Model_Inputs.json";
    
    //APD Subro File Paths
    static final String APD_SUBRO_MODEL_METADATA_FILEPATH = "/json/APD_Subro_Model_Metadata.json";
    static final String APD_SUBRO_MODEL_COEFFICIENTS_FILEPATH = "/json/APD_Subro_Model_Coefficients.json";
    static final String APD_SUBRO_MODEL_INPUTS_FILEPATH = "/json/APD_Subro_Model_Inputs.json";
    
    
    /**
     * Empty constructor
     */
    private JsonLoader()
    {
        
    }


    /**
     * Reads a file which content is in json and converts it to a List 
     * APDSubroModelMetaddata
     * 
     * @return List of APDSubroModelMetadata
     */
    public static List<APDSubroModelMetadata> createAPDSubroModelMetadata() 
    {
        
        Gson gson = new GsonBuilder().create();
        List<APDSubroModelMetadata> apdSubroModelMetadataList = null;
        
        try
        {
            BufferedReader apdSubroModelMetadataReader = 
                new BufferedReader(
                    new InputStreamReader(
                        JsonLoader.class.getResourceAsStream(
                            APD_SUBRO_MODEL_METADATA_FILEPATH)
                        )
                    );
            
            apdSubroModelMetadataList = 
                gson.fromJson(
                    apdSubroModelMetadataReader, 
                    (new TypeToken<List<APDSubroModelMetadata>>() { } 
                        .getType()));
        }
        catch (Exception e)
        {
        }
        
        return apdSubroModelMetadataList;
    }
    

    /**
     * Reads a file which content is in json and converts it to a List 
     * APDSubroModelCoefficients.
     * 
     * @return List of APDSubroModelCoefficients
     */
    public static List<APDSubroModelCoefficients> createAPDSubroModelCoefficients() 
    {
        Gson gson = new GsonBuilder().create();
        List<APDSubroModelCoefficients> apdSubroModelCoeffsList = null;
        
        try
        {
//            BufferedReader apdSubroModelCoeffsReader = 
//                new BufferedReader(
//                    new InputStreamReader(
//                        JsonLoader.class.getResourceAsStream(
//                            //APD_SUBRO_MODEL_COEFFICIENTS_FILEPATH
//                        	"/json/APD_Subro_Model_Coefficients.json"
//                		)));
        	String test = "json/APD_Subro_Model_Coefficients.json";

            BufferedReader apdSubroModelCoeffsReader = 
            		new BufferedReader(new FileReader(test));
            apdSubroModelCoeffsList = 
                gson.fromJson(
                    apdSubroModelCoeffsReader, 
                    new TypeToken<List<APDSubroModelCoefficients>>() { }
                        .getType());
        }
        catch (Exception e)
        {
        }
        
        return apdSubroModelCoeffsList;
    }
    

    /**
     * Reads a file which content is in json and converts it to a List 
     * APDSubroModelInputs.
     * 
     * @return List of APDSubroModelInputs
     */
    public static List<APDSubroModelInputs> createAPDSubroModelInputs() 
    {
        Gson gson = new GsonBuilder().create();
        List<APDSubroModelInputs> apdSubroModelInputsList = null;
        try
        {
            BufferedReader apdSubroModelInputsReader = 
                new BufferedReader(
                    new InputStreamReader(
                        JsonLoader.class.getResourceAsStream(
                            APD_SUBRO_MODEL_INPUTS_FILEPATH)));
            
            apdSubroModelInputsList = 
                gson.fromJson(
                    apdSubroModelInputsReader, 
                    new TypeToken<List<APDSubroModelInputs>>() { } 
                        .getType());
        }
        catch (Exception e)
        {
        }
        
        return apdSubroModelInputsList;
    }
}