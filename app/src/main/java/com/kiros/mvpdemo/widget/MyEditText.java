package com.kiros.mvpdemo.widget;

/**
 * Created by kiros on 2019/8/12.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatEditText ;

/**
 * 自定义EditText控件，添加白色下划线
 */
public class MyEditText extends AppCompatEditText {

    private Paint mPaint;

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        // 你可以根据自己的具体需要在此处对画笔做更多个性化设置
        mPaint.setColor(Color.BLACK);

    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画底线
        canvas.drawLine(0, this.getHeight() - 1, this.getWidth() - 1, this.getHeight() - 1, mPaint);
    }

}

