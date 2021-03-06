package com.lee.toollibrary.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * Created by nicklxz on 2017/11/21.
 *  * 进度条image view  一般用于上传展示进度
 */

@SuppressLint("AppCompatCustomView")
public class ProcessImageView extends ImageView {

    private Paint mPaint;// 画笔
    private Paint mTextPaint;// 画笔
    int width = 0;
    int height = 0;
    Context context = null;
    int progress = 0;
    Rect rectText = new Rect();
    public ProcessImageView(Context context) {
        super(context);

    }

    public ProcessImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProcessImageView(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        mPaint = new Paint();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(30);
        mTextPaint.setColor(Color.parseColor("#FFFFFF"));
        mTextPaint.setStrokeWidth(2);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true); // 消除锯齿
        mPaint.setStyle(Paint.Style.FILL);


        mPaint.setColor(Color.parseColor("#70000000"));// 半透明
        canvas.drawRect(0, 0, getWidth(), getHeight()- getHeight() * progress
                / 100, mPaint);
        mPaint.setColor(Color.parseColor("#00000000"));// 全透明
        canvas.drawRect(0, getHeight() - getHeight() * progress / 100,
                getWidth(), getHeight(), mPaint);



        mPaint.getTextBounds("100%", 0, "100%".length(), rectText);// 确定文字的宽度
        //根据进度画百分百
        if (progress==100){
        }else {
            canvas.drawText(progress + "%", getWidth() / 2 - rectText.width() / 2,
                    getHeight() / 2, mTextPaint);
        }

    }

    /**
     * 设置进度
     * @param progress  进度值
     */
    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();
    }

}
