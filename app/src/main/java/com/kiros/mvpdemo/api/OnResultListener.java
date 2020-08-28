package com.kiros.mvpdemo.api;


/**
 * Created by kiros on 2019/6/11.
 */

public interface OnResultListener {
    void onSuccess(String result);
    void onError(String error);
}
