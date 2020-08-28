package com.kiros.mvpdemo.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kiros on 2019/6/12.
 */

public class RetrofitManager {
    private static RetrofitManager mInstance;
    private static final long DEFAULT_TIMEOUT = 60L;
    private Retrofit retrofit = null;

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (RetrofitManager.class) {
                if (retrofit == null) {
                    OkHttpClient mClient = new OkHttpClient.Builder()
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .build();
                    retrofit = new Retrofit.Builder()
                            .baseUrl(Api.BASE_URL)//基础URL 建议以 / 结尾
                            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava 适配器
                            .client(mClient)
                            .build();
                }
            }
        }
        return retrofit;
    }
}
