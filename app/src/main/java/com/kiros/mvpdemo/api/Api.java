package com.kiros.mvpdemo.api;

import com.google.gson.JsonObject;
import com.kiros.mvpdemo.weather.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kiros on 2019/6/12.
 */

public interface Api {
    String BASE_URL = "https://tianqiapi.com";

    @GET("api/")
    Call<JsonObject> getWeather(@Query("version") String v1, @Query("cityid") String cityid, @Query("city") String city,
                                @Query("appid") String appid, @Query("appsecret") String appsecret);

    @GET("api/")
    Call<Weather> getWeatherBean(@Query("version") String v1, @Query("cityid") String cityid, @Query("city") String city,
                             @Query("appid") String appid, @Query("appsecret") String appsecret);
}
