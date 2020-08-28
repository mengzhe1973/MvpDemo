package com.kiros.mvpdemo.entity;

/**
 * Created by kiros on 2019/7/17.
 */

public class GuaranteeItem {
    private String guaranteeTime;
    private String guaranteeAddress;
    private String guaranteeReason;

    public String getGuaranteeTime() {
        return guaranteeTime;
    }

    public String getGuaranteeAddress() {
        return guaranteeAddress;
    }

    public String getGuaranteeReason() {
        return guaranteeReason;
    }

    public void setGuaranteeTime(String guaranteeTime) {
        this.guaranteeTime = guaranteeTime;
    }

    public void setGuaranteeAddress(String guaranteeAddress) {
        this.guaranteeAddress = guaranteeAddress;
    }

    public void setGuaranteeReason(String guaranteeReason) {
        this.guaranteeReason = guaranteeReason;
    }
}
