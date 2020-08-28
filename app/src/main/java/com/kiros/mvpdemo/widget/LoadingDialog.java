package com.kiros.mvpdemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.kiros.mvpdemo.R;

/**
 * Created by kiros on 2019/7/24.
 */

public class LoadingDialog extends Dialog {
    String message = null;
    private Dialog dialog;
    private Context context;

    public LoadingDialog(Context context) {
        super(context);
        this.context = context;
    }

    public LoadingDialog(Context context, String message) {
        super(context);
        this.context = context;
        this.message = message;

    }

    public void show() {
        dialog = new Dialog(context, R.style.Loading);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_loading, null, false);
        dialog.setContentView(view);
        WindowManager.LayoutParams lp = dialog.getWindow()
                .getAttributes();
        lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
        if (dialog != null) {
            dialog.show();
        }
    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
