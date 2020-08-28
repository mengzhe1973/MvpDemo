package com.kiros.mvpdemo.weather;

/**
 * Created by kiros on 2020/8/28.
 */

public class Weather {

    /**
     * cityid : 101180101
     * date : 2020-08-28
     * week : 星期五
     * update_time : 2020-08-28 16:14:02
     * city : 郑州
     * cityEn : zhengzhou
     * country : 中国
     * countryEn : China
     * wea : null
     * wea_img : qing
     * tem :
     * tem1 : 32
     * tem2 : 21
     * win : null
     * win_speed : null
     * win_meter :
     * humidity : null
     * visibility : null
     * pressure : null
     * air : 63
     * air_pm25 : 63
     * air_level : 良
     * air_tips : 空气好，可以外出活动，除极少数对污染物特别敏感的人群以外，对公众没有危害！
     * alarm : {"alarm_type":"","alarm_level":"","alarm_content":""}
     */

    private String cityid;
    private String date;
    private String week;
    private String update_time;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    private Object wea;
    private String wea_img;
    private String tem;
    private String tem1;
    private String tem2;
    private Object win;
    private Object win_speed;
    private String win_meter;
    private Object humidity;
    private Object visibility;
    private Object pressure;
    private String air;
    private String air_pm25;
    private String air_level;
    private String air_tips;
    private AlarmBean alarm;

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public Object getWea() {
        return wea;
    }

    public void setWea(Object wea) {
        this.wea = wea;
    }

    public String getWea_img() {
        return wea_img;
    }

    public void setWea_img(String wea_img) {
        this.wea_img = wea_img;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getTem1() {
        return tem1;
    }

    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    public String getTem2() {
        return tem2;
    }

    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }

    public Object getWin() {
        return win;
    }

    public void setWin(Object win) {
        this.win = win;
    }

    public Object getWin_speed() {
        return win_speed;
    }

    public void setWin_speed(Object win_speed) {
        this.win_speed = win_speed;
    }

    public String getWin_meter() {
        return win_meter;
    }

    public void setWin_meter(String win_meter) {
        this.win_meter = win_meter;
    }

    public Object getHumidity() {
        return humidity;
    }

    public void setHumidity(Object humidity) {
        this.humidity = humidity;
    }

    public Object getVisibility() {
        return visibility;
    }

    public void setVisibility(Object visibility) {
        this.visibility = visibility;
    }

    public Object getPressure() {
        return pressure;
    }

    public void setPressure(Object pressure) {
        this.pressure = pressure;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getAir_pm25() {
        return air_pm25;
    }

    public void setAir_pm25(String air_pm25) {
        this.air_pm25 = air_pm25;
    }

    public String getAir_level() {
        return air_level;
    }

    public void setAir_level(String air_level) {
        this.air_level = air_level;
    }

    public String getAir_tips() {
        return air_tips;
    }

    public void setAir_tips(String air_tips) {
        this.air_tips = air_tips;
    }

    public AlarmBean getAlarm() {
        return alarm;
    }

    public void setAlarm(AlarmBean alarm) {
        this.alarm = alarm;
    }

    public static class AlarmBean {
        /**
         * alarm_type :
         * alarm_level :
         * alarm_content :
         */

        private String alarm_type;
        private String alarm_level;
        private String alarm_content;

        public String getAlarm_type() {
            return alarm_type;
        }

        public void setAlarm_type(String alarm_type) {
            this.alarm_type = alarm_type;
        }

        public String getAlarm_level() {
            return alarm_level;
        }

        public void setAlarm_level(String alarm_level) {
            this.alarm_level = alarm_level;
        }

        public String getAlarm_content() {
            return alarm_content;
        }

        public void setAlarm_content(String alarm_content) {
            this.alarm_content = alarm_content;
        }
    }
}
