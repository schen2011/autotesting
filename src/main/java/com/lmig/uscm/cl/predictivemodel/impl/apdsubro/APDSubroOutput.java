/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.lmig.uscm.cl.predictivemodel.impl.apdsubro;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.lmig.uscm.cl.predictivemodel.enums.EngineType;
import com.lmig.uscm.cl.predictivemodel.enums.LossType;
import com.lmig.uscm.cl.predictivemodel.enums.PredictiveModel;
import com.lmig.uscm.cl.predictivemodel.intf.IPredictiveModelOutput;


/**
 * @author BoChen
 *
 */
public class APDSubroOutput implements IPredictiveModelOutput
{
    @SerializedName("APDSubroModelTypeUsed")
    private PredictiveModel predictiveModel;
    
    @SerializedName("Probability")
    private BigDecimal probabilityScore;
    
    @SerializedName("ConditionalRecoveryAmount")
    private BigDecimal recoveryamountScore;
    
    @SerializedName("ExpectedRecoveryAmount")
    private BigDecimal expectedRecoveryAmount;

    @SerializedName("MeetsOnOffCriteria")
    //engine output
    private boolean meetsOnOffCriteria;
    
    @SerializedName("MeetsPilotCriteria")
    private boolean meetsPilotCriteria;

    @SerializedName("RecommendationToNav")
    //final output
    private boolean recommendationToNav;

    private transient BigDecimal threshold;
    
    @SerializedName("SubroPotentialDetermined")
    private boolean decision;
    
    private transient Integer executedModelId;
    private boolean chosenModelIndicator;
    private EngineType engineType;
    private LossType lossType;
    @SerializedName("ProbabilityCoefficientUsed")
    private Map<String, BigDecimal> coefficientUsedProb;
    @SerializedName("RecoveryCoefficientUsed")
    private Map<String, BigDecimal> coefficientUsedReco;
    
    /**
     * @return the predictiveModel
     */
    public PredictiveModel getPredictiveModel()
    {
        return predictiveModel;
    }

    /**
     * @param predictiveModel the predictiveModel to set
     */
    public void setPredictiveModel(PredictiveModel predictiveModel)
    {
        this.predictiveModel = predictiveModel;
    }
    
    /**
     * @return the meetsOnOffCriteria
     */
    public boolean isMeetsOnOffCriteria()
    {
        return meetsOnOffCriteria;
    }

    /**
     * @param meetsOnOffCriteria the meetsOnOffCriteria to set
     */
    public void setMeetsOnOffCriteria(boolean meetsOnOffCriteria)
    {
        this.meetsOnOffCriteria = meetsOnOffCriteria;
    }

    /**
     * @return the meetsPilotCriteria
     */
    public boolean isMeetsPilotCriteria()
    {
        return meetsPilotCriteria;
    }

    /**
     * @param meetsPilotCriteria the meetsPilotCriteria to set
     */
    public void setMeetsPilotCriteria(boolean meetsPilotCriteria)
    {
        this.meetsPilotCriteria = meetsPilotCriteria;
    }

    /**
     * @return the recommendationToNav
     */
    public boolean isRecommendationToNav()
    {
        return recommendationToNav;
    }

    /**
     * @param recommendationToNav the recommendationToNav to set
     */
    public void setRecommendationToNav(boolean recommendationToNav)
    {
        this.recommendationToNav = recommendationToNav;
    }


    /**
     * @param recoveryamountScore the recoveryamountScore to set
     */
    public void setRecoveryamountScore(BigDecimal recoveryamountScore)
    {
        this.recoveryamountScore = recoveryamountScore;
    }

    /***
     * 
     * @param recoveryamountScore
     */
    public void setRecoveryamountScore(double recoveryamountScore)
    {
        this.recoveryamountScore = new BigDecimal(recoveryamountScore);
    }
    
    /**
     * @param probabilityScore the probabilityScore to set
     */
    public void setProbabilityScore(BigDecimal probabilityScore)
    {
        this.probabilityScore = probabilityScore;
    }

    /**
     * @return the engineType
     */
    public EngineType getEngineType()
    {
        return engineType;
    }

    /**
     * @param engineType the engineType to set
     */
    public void setEngineType(EngineType engineType)
    {
        this.engineType = engineType;
    }

    /**
     * @return the lossType
     */
    public LossType getLossType()
    {
        return lossType;
    }

    /**
     * @param lossType the lossType to set
     */
    public void setLossType(LossType lossType)
    {
        this.lossType = lossType;
    }

    /**
     * @return the coefficientUsed_Prob
     */
    public Map<String, BigDecimal> getCoefficientUsedProb()
    {
        return coefficientUsedProb;
    }

    /***
     * 
     * @param coefficientUsedProb
     */
    public void setCoefficientUsedProb(Map<String, BigDecimal> coefficientUsedProb)
    {
        this.coefficientUsedProb = coefficientUsedProb;
    }

    /**
     * @return the coefficientUsed_Reco
     */
    public Map<String, BigDecimal> getCoefficientUsedReco()
    {
        return coefficientUsedReco;
    }

    /****
     * 
     * @param coefficientUsedReco
     */
    public void setCoefficientUsedReco(Map<String, BigDecimal> coefficientUsedReco)
    {
        this.coefficientUsedReco = coefficientUsedReco;
    }

    /**
     * @return the chosenModelIndicator
     */
    public boolean getChosenModelIndicator()
    {
        return chosenModelIndicator;
    }

    /**
     * @return the decision
     */
    public boolean getDecision()
    {
        this.decision = getExpectedRecoveryAmount()
            .compareTo(threshold) > 0;
        return decision;
    }
    
    /**
     * @return the threshold
     */
    public BigDecimal getThreshold()
    {
        return threshold;
    }
    /**
     * @param threshold the threshold to set
     */
    public void setThreshold(BigDecimal threshold)
    {
        this.threshold = threshold;
    }
    /**
     * @return the recoveryamountScore
     */
    public BigDecimal getRecoveryamountScore()
    {
        return recoveryamountScore;
    }

    /***
     * 
     */
    public void setDecision()
    {
        this.decision = getExpectedRecoveryAmount()
            .compareTo(threshold) > 0;
    }

    /***
     * 
     * @param expectedRecoveryAmount
     */
    public void setExpectedRecoveryAmount(BigDecimal expectedRecoveryAmount)
    {     
        this.expectedRecoveryAmount = expectedRecoveryAmount;
    }
    
    /**
     * @return the probailityScore
     */
    public BigDecimal getProbabilityScore()
    {
        return probabilityScore;
    }
    /**
     * @param probailityScore the probailityScore to set
     */
    public void setProbabilityScore(double probailityScore)
    {
        this.probabilityScore = new BigDecimal(probailityScore);
    }

    /***
     * 
     * @return
     */
    public boolean hasProbabilityScore()
    {
        return this.probabilityScore != null;
    }
    /***
     * 
     * @return
     */
    public boolean hasRecoveryamountScore()
    {
        return this.recoveryamountScore != null;
    }
    
    /**
     * @param chosenModelIndicator the chosenModelIndicator to set
     */
    public void setChosenModelIndicator(boolean chosenModelIndicator)
    {
        this.chosenModelIndicator = chosenModelIndicator;
    }

    /***
     * 
     * @return
     */
    public boolean hasThreshold()
    {
        return this.threshold != null;
    }
    
    /***
     * 
     * @return
     */
    public boolean runModel()
    {
        this.decision = getExpectedRecoveryAmount()
            .compareTo(threshold) > 0;
        return decision;
    }


    /**
     * @return the expectedRecoveryAmount
     */
    public BigDecimal getExpectedRecoveryAmount()
    {
        return expectedRecoveryAmount;
    }

    /**
     * @return
     */
    public Integer getExecutedModelId()
    {
        return executedModelId;
    }
    
    /**
     * @param executedModelId the executedModelId to set
     */
    public void setExecutedModelId(Integer executedModelId)
    {
        this.executedModelId = executedModelId;
    }
    
}
