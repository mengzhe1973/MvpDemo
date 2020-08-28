package com.kiros.mvpdemo.weather;

import com.google.gson.JsonObject;
import com.kiros.mvpdemo.api.Api;
import com.kiros.mvpdemo.api.OnResultListener;
import com.kiros.mvpdemo.api.RetrofitManager;
import com.kiros.mvpdemo.base.BaseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kiros on 2019/7/4.
 */

public class WeatherModel extends BaseModel {
    public void getWeather(String v1, String cityid, String city, final OnResultListener resultListener) {
        Call<JsonObject> call = api.getWeather(v1, cityid, city, "25769574", "CXbGf4p1");
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                resultListener.onSuccess(response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                resultListener.onError(t.getMessage());
            }
        });
    }
}
