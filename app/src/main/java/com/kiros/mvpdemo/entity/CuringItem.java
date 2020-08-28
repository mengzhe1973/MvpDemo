package com.kiros.mvpdemo.entity;

/**
 * Created by kiros on 2019/7/17.
 */

public class CuringItem {
    private String EqName;
    private String EqNum;
    private String EqUsage;

    public void setEqName(String eqName) {
        EqName = eqName;
    }

    public void setEqNum(String eqNum) {
        EqNum = eqNum;
    }

    public void setEqUsage(String eqUsage) {
        EqUsage = eqUsage;
    }

    public String getEqName() {

        return EqName;
    }

    public String getEqNum() {
        return EqNum;
    }

    public String getEqUsage() {
        return EqUsage;
    }
}
