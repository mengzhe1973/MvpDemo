package com.kiros.mvpdemo.weather;

import com.kiros.mvpdemo.api.OnResultListener;
import com.kiros.mvpdemo.base.BaseModel;
import com.kiros.mvpdemo.base.BasePresenter;
import com.kiros.mvpdemo.base.BaseView;

/**
 * Created by kiros on 2019/7/4.
 */

public class WeatherPresenter extends BasePresenter<BaseView> {

    private WeatherModel weatherModel;

    public WeatherPresenter() {
        this.weatherModel = new WeatherModel();
    }

    public void getWeather(String v1, String cityid, String city) {
        getView().showLoading();
        weatherModel.getWeather(v1, cityid, city, new OnResultListener() {
            @Override
            public void onSuccess(String result) {
                getView().getData(result);
                getView().hindLoading();
            }

            @Override
            public void onError(String error) {
                getView().showError(error);
            }
        });
    }
}
