package com.kiros.mvpdemo.base;

import com.kiros.mvpdemo.api.Api;
import com.kiros.mvpdemo.api.RetrofitManager;

/**
 * Created by kiros on 2019/7/2.
 */

public abstract class BaseModel {
    public Api api = RetrofitManager.getInstance().getRetrofit().create(Api.class);
}
