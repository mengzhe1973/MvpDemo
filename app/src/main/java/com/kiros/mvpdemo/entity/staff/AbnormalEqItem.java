package com.kiros.mvpdemo.entity.staff;

/**
 * Created by kiros on 2019/7/17.
 */

public class AbnormalEqItem {
    private String itemTime;
    private String EqName;
    private String EqNum;
    private String EqAbnormal;
    private String HappenTime;
    private String EqAddress;

    public String getItemTime() {
        return itemTime;
    }

    public String getEqName() {
        return EqName;
    }

    public String getEqNum() {
        return EqNum;
    }

    public String getEqAbnormal() {
        return EqAbnormal;
    }

    public String getHappenTime() {
        return HappenTime;
    }

    public String getEqAddress() {
        return EqAddress;
    }

    public void setItemTime(String itemTime) {
        this.itemTime = itemTime;
    }

    public void setEqName(String eqName) {
        EqName = eqName;
    }

    public void setEqNum(String eqNum) {
        EqNum = eqNum;
    }

    public void setEqAbnormal(String eqAbnormal) {
        EqAbnormal = eqAbnormal;
    }

    public void setHappenTime(String happenTime) {
        HappenTime = happenTime;
    }

    public void setEqAddress(String eqAddress) {
        EqAddress = eqAddress;
    }

}
