package com.kiros.mvpdemo.api;

/**
 * Created by kiros on 2019/7/23.
 */

public class HttpApi {
    //基本url
    public static String BASE_URL = "http://jhjj.sebon.com.cn/api/";

    //登录url
    public static String LOGIN_URL = BASE_URL + "user/login";
    //签到url 和 重置密码url
    public static String SIGNIN_URL = BASE_URL + "user/sign";
    //设备列表url
    public static String DEVICE_URL = BASE_URL + "device/deviceList";
    //设备维修列表url
    public static String REPAIR_URL = BASE_URL + "user/repair";
    //评价url
    public static String ACCESS_URL = BASE_URL + "user/access";
    //评价url
    public static String USRE_URL = BASE_URL + "user/ticket";
}
