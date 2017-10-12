package com.fastaccount.view.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;

/**
 * Created by xus on 2016/7/18.
 */
public abstract class ChartView extends RelativeLayout {
    protected View rootView;
    protected Context context;

    public ChartView(Context context) {
        super(context);
        this.context = context;
        initView();
        addView(rootView);

    }

    public ChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
        addView(rootView);

    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
        addView(rootView);
    }

    public abstract void showLeftAxis(YAxis Axis);

    public abstract void initView();

    public abstract void showRightAxis(YAxis Axis);

    public abstract void showTopAxis(XAxis Axis);

    public abstract void showBottomAxis(XAxis Axis);


    public abstract void setDescription(String description);
}
