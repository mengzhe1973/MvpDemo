package com.kiros.mvpdemo.entity;

/**
 * Created by kiros on 2019/7/17.
 */

public class MaintenanBossItem {
    private String time;
    private String reason;
    private String address;
    private String situation;
    private String maintenancer;

    public String getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public String getAddress() {
        return address;
    }

    public String getSituation() {
        return situation;
    }

    public String getMaintenancer() {
        return maintenancer;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public void setMaintenancer(String maintenancer) {
        this.maintenancer = maintenancer;
    }
}
