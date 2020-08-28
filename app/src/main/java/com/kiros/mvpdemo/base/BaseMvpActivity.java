package com.kiros.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kiros on 2019/6/27.
 */

public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity {

    private P presenter;
    private V view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());

        if (presenter == null) {
            presenter = createPresenter();
        }
        if (view == null) {
            view = createView();
        }
        if (presenter != null && view != null) {
            presenter.attachView(view);
        }

        initView();
    }

    protected abstract int getLayoutID();

    protected abstract P createPresenter();

    protected abstract V createView();

    protected abstract void initView();

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null && view != null) {
            presenter.detachView();
        }
    }
}
