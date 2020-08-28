package com.kiros.mvpdemo.base;

/**
 * Created by kiros on 2019/6/27.
 */

public interface BaseView {
    void showLoading();
    void hindLoading();
    void getData(String data);
    void showError(String error);
}
