package com.kiros.mvpdemo.entity;

/**
 * Created by kiros on 2019/7/16.
 */

public class EvaluateItem {
    private String feedbackTime;
    private String evaluateName;
    private String evaluateTime;
    private String evaluateAddress;
    private String evaluateReason;

    public String getFeedbackTime() {
        return feedbackTime;
    }

    public String getEvaluateName() {
        return evaluateName;
    }

    public String getEvaluateTime() {
        return evaluateTime;
    }

    public String getEvaluateAddress() {
        return evaluateAddress;
    }

    public String getEvaluateReason() {
        return evaluateReason;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public void setEvaluateName(String evaluateName) {
        this.evaluateName = evaluateName;
    }

    public void setEvaluateTime(String evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public void setEvaluateAddress(String evaluateAddress) {
        this.evaluateAddress = evaluateAddress;
    }

    public void setEvaluateReason(String evaluateReason) {
        this.evaluateReason = evaluateReason;
    }
}
