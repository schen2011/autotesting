/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.model.loader;

import com.lmig.uscm.cl.predictivemodel.enums.DataSource;
import com.lmig.uscm.cl.predictivemodel.enums.EngineType;
import com.lmig.uscm.cl.predictivemodel.enums.PredictiveModel;
import com.lmig.uscm.cl.predictivemodel.impl.CoeffModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroModelComposite;
import com.lmig.uscm.cl.predictivemodel.model.loader.db.DaoToModelTransformer;
import com.lmig.uscm.cl.predictivemodel.model.loader.json.JsonToModelTransformer;
import com.lmig.uscm.cl.predictivemodel.service.model.Metadata;

/**
 * @author Chris Daub
 *
 */
public final class APDSubroModelFactory
{
    
    /**
     * private constructor
     */
    private APDSubroModelFactory()
    {
    }

    /**
     * 
     * @return
     */
    public static APDSubroModel getAPDSubroModel(
        PredictiveModel predModel, 
        EngineType engineType,
        DataSource ds)
    {
        APDSubroModel apdSubroModel = null;
        if (DataSource.DB.equals(ds))
        {
            apdSubroModel =  new APDSubroModel(
                loadCompositeModelFromDB(predModel, engineType));
        }
        else 
        {
            apdSubroModel = new APDSubroModel(
                loadCompositeModelFromJSON(predModel, engineType));
        }
        return apdSubroModel;
    }
    /**
     * 
     * @return
     */
    private static APDSubroModelComposite loadCompositeModelFromDB(
        PredictiveModel predModel, 
        EngineType engineType) 
    {
        APDSubroModelComposite apdSubroModelComposite = new APDSubroModelComposite();
        Metadata result = DaoToModelTransformer.getInstance().getMetadataFromDB(predModel, engineType);
        apdSubroModelComposite.setCoeffMetadata(
            DaoToModelTransformer.getInstance().prepareCoeffMetadata(result, predModel));
        CoeffModel coeffModel = new CoeffModel();
        if (result.getCoefficients() != null && result.getCoefficients().size() > 0)
        {
            coeffModel.setCoeffKeyModelValueMap(
                DaoToModelTransformer.getInstance().prepareCoeffKeyModelValueMap(result));
            coeffModel.setCoeffKeySet(DaoToModelTransformer.getInstance().createCoeffKeySet(result));
            coeffModel.setCoeffKeyValueMap(
                JsonToModelTransformer.getInstance().prepareCoeffKeyValueMap(predModel));
        }
        apdSubroModelComposite.setCoeffModel(coeffModel);
        return apdSubroModelComposite;
    }

    /**
     * @return
     */
    private static APDSubroModelComposite loadCompositeModelFromJSON(PredictiveModel predModel, EngineType engineType) 
    {
        APDSubroModelComposite apdSubroModelComposite = new APDSubroModelComposite();
        apdSubroModelComposite.setCoeffMetadata(
            JsonToModelTransformer.getInstance().prepareCoeffMetadata(predModel));
        apdSubroModelComposite.setCoeffModel(
            JsonToModelTransformer.getInstance().prepareCoeffModel(predModel));
        return apdSubroModelComposite;
    }
}