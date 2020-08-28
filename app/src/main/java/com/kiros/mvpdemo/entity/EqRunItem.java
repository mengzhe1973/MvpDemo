package com.kiros.mvpdemo.entity;

/**
 * Created by kiros on 2019/7/17.
 */

public class EqRunItem {
    private String EqName;
    private String EqNum;
    private String EqUsage;
    private String runTime;
    private String defender;
    private String runSpeed;
    private String eqAddress;
    private String eqTemperature;
    private String utilizationRate;
    private String repairNum;

    public void setEqName(String eqName) {
        EqName = eqName;
    }

    public void setEqNum(String eqNum) {
        EqNum = eqNum;
    }

    public void setEqUsage(String eqUsage) {
        EqUsage = eqUsage;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public void setDefender(String defender) {
        this.defender = defender;
    }

    public void setRunSpeed(String runSpeed) {
        this.runSpeed = runSpeed;
    }

    public void setEqAddress(String eqAddress) {
        this.eqAddress = eqAddress;
    }

    public void setEqTemperature(String eqTemperature) {
        this.eqTemperature = eqTemperature;
    }

    public void setUtilizationRate(String utilizationRate) {
        this.utilizationRate = utilizationRate;
    }

    public void setRepairNum(String repairNum) {
        this.repairNum = repairNum;
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

    public String getRunTime() {
        return runTime;
    }

    public String getDefender() {
        return defender;
    }

    public String getRunSpeed() {
        return runSpeed;
    }

    public String getEqAddress() {
        return eqAddress;
    }

    public String getEqTemperature() {
        return eqTemperature;
    }

    public String getUtilizationRate() {
        return utilizationRate;
    }

    public String getRepairNum() {
        return repairNum;
    }
}
