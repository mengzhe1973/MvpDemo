package com.kiros.mvpdemo.entity.staff;

/**
 * Created by kiros on 2019/7/17.
 */

public class OverdueMaintenanItem {
    private String time;
    private String address;
    private String summary;
    private String maintenanceTime;
    private String remarks;

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public String getSummary() {
        return summary;
    }

    public String getMaintenanceTime() {
        return maintenanceTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setMaintenanceTime(String maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
