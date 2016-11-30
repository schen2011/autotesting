package com.lmig.uscm.cl.predictivemodel.client.setup;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.lmig.uscm.cl.predictivemodel.enums.CoeffKey;
import com.lmig.uscm.cl.predictivemodel.enums.ConsumerType;
import com.lmig.uscm.cl.predictivemodel.enums.DataSource;
import com.lmig.uscm.cl.predictivemodel.enums.EngineType;
import com.lmig.uscm.cl.predictivemodel.enums.LossType;
import com.lmig.uscm.cl.predictivemodel.enums.ModelType;
import com.lmig.uscm.cl.predictivemodel.enums.PredictiveModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroConsumer;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroDTO;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroEngine;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroID;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroInput;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroModel;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroNavigatorDTO;
import com.lmig.uscm.cl.predictivemodel.impl.apdsubro.APDSubroOutput;
import com.lmig.uscm.cl.predictivemodel.utils.JSONUtil;

public class APDSubroMockSetup
{
    //sets up a single example for testing various pieces of the code
    public static APDSubroNavigatorDTO setupDto()
    {
        APDSubroNavigatorDTO dto = new APDSubroNavigatorDTO();
        dto.setSeverityTypeDesc("severe-gen");
        dto.setVehicleRentalInd(1);
        dto.setTotalLossInd(true);
        dto.setInitialPointOfImpactDesc("10");  //should be 9
        dto.setClaimTierDesc("medium");
        dto.setLossCauseTypeDesc("insdhitinrear");
        dto.setMultiCarInd(2);
        dto.setVehicleMake("HOND");
        dto.setVehicleYear(2013);
        dto.setDeductibleWaiverInd(false);
        dto.setJurisdictionGroup("CT");
        dto.setDeductibleAmountPaid(new BigDecimal(500));
        dto.setCoverageDeductible(new BigDecimal(1000));
        dto.setIdInfo(setupID());
        dto.setGrossLoss(new BigDecimal(30000));
        dto.setPrimaryDriverAge(21);
        dto.setHitAndRunInd(false);
        dto.setUserNNumber("N03425660");
        return dto;
    }
    public static APDSubroID setupID()
    {
        APDSubroID id = new APDSubroID();
        id.setClaimCreateTime("time");
        id.setClaimID("ID");
        id.setClaimNumber("234");
        id.setClaimPublicID("456");
        id.setCloseSubroActivity(3);
        id.setExposureID("789");
        id.setExposureNumber("912");
        id.setFaultRatingDesc("Bad");
        id.setIncidentID("34");
        id.setModelExecTime(new Date(3));
        id.setReferredToSub(false);
        id.setSubroAmount(new BigDecimal(100));
        return id;
    }
    public static APDSubroConsumer setupConsumer()
    {
        APDSubroConsumer consumer = new APDSubroConsumer();
        consumer.setConsumerType(ConsumerType.CLAIMS_CENTER);
        consumer.setModelType(ModelType.PROBABILITY);
        consumer.setAPDSubroID(setupID());
        consumer.setNavigatorDto(setupDto());
        consumer.setNavigatorDtoJsonString(JSONUtil.objectToJson(setupDto()));
        return consumer;
    }
    public static APDSubroOutput setupOutput()
    {
        APDSubroOutput apdSubroOutput = new APDSubroOutput();
        apdSubroOutput.setChosenModelIndicator(true);
        apdSubroOutput.setCoefficientUsedReco(setupCoeffUsedMap());
        apdSubroOutput.setEngineType(EngineType.APD_SUBRO_JAVA_IMPL);
        apdSubroOutput.setExecutedModelId(new Integer(81));
        apdSubroOutput.setExpectedRecoveryAmount(new BigDecimal(150));
        apdSubroOutput.setLossType(LossType.AUTO);
        apdSubroOutput.setPredictiveModel(PredictiveModel.APD_SUBRO_PRED_MDL_A);
        apdSubroOutput.setProbabilityScore(new BigDecimal(0.75));
        apdSubroOutput.setRecoveryamountScore(new BigDecimal(200));
        apdSubroOutput.setThreshold(new BigDecimal(100));
        return apdSubroOutput;
    }
    public static Map<String, BigDecimal> setupCoeffUsedMap()
    {
        Map<String, BigDecimal> coeffUsedMap = new HashMap<String, BigDecimal>();
        coeffUsedMap.put(CoeffKey.SEVERITY1.toString(), new BigDecimal(0.262946725357889));
        coeffUsedMap.put(CoeffKey.RENTALIND1.toString(), new BigDecimal(0.15159474572281));
        return coeffUsedMap;
    }
    public static APDSubroEngine setupEngine()
    {
        APDSubroEngine engine = new APDSubroEngine();
        return engine;
    }
    public static APDSubroInput setupInput()
    {
        APDSubroInput input = new APDSubroInput();
        APDSubroDTO dto = new APDSubroDTO(setupDto());
        dto.loadCoeffKeyDtoValueMap();
        input.setDto(dto);
        return input;
    }
    public static APDSubroModel setupJsonModelA(APDSubroEngine engine)
    {
        return engine.getPredictiveModel(PredictiveModel.APD_SUBRO_PRED_MDL_A, EngineType.APD_SUBRO_JAVA_IMPL, DataSource.JSON);
    }
    public static APDSubroModel setupJsonModelB(APDSubroEngine engine)
    {
        return engine.getPredictiveModel(PredictiveModel.APD_SUBRO_PRED_MDL_B, EngineType.APD_SUBRO_JAVA_IMPL, DataSource.JSON);
    }
    public static APDSubroModel setupDbModelA(APDSubroEngine engine)
    {
        return engine.getPredictiveModel(PredictiveModel.APD_SUBRO_PRED_MDL_A, EngineType.APD_SUBRO_JAVA_IMPL, DataSource.DB);
    }
    public static APDSubroModel setupDbModelB(APDSubroEngine engine)
    {
        return engine.getPredictiveModel(PredictiveModel.APD_SUBRO_PRED_MDL_B, EngineType.APD_SUBRO_JAVA_IMPL, DataSource.DB);
    }
}