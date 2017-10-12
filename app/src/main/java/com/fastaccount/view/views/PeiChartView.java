package com.fastaccount.view.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.fastaccount.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

/**
 * Created by xus on 2016/7/19.
 */
public class PeiChartView extends ChartView {
    private PieChart pie_chart;

    public PeiChartView(Context context) {
        super(context);
    }

    public PeiChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PeiChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void initView() {
        rootView = LayoutInflater.from(context).inflate(R.layout.other_charts_piechart_view, this, false);
        pie_chart = (PieChart) rootView.findViewById(R.id.pie_chart);
        pie_chart.setDescription("");
        pie_chart.setUsePercentValues(true);
        pie_chart.setDescription("");
        pie_chart.setExtraOffsets(5, 10, 5, 5);
        pie_chart.setDragDecelerationFrictionCoef(0.95f);
        pie_chart.setCenterText("");
        pie_chart.setExtraOffsets(20.f, 0.f, 20.f, 0.f);
        pie_chart.setDrawHoleEnabled(true);
        pie_chart.setHoleColor(Color.WHITE);
        pie_chart.setTransparentCircleColor(Color.WHITE);
        pie_chart.setTransparentCircleAlpha(110);
        pie_chart.setHoleRadius(58f);
        pie_chart.setTransparentCircleRadius(61f);
        pie_chart.setDrawCenterText(true);
        pie_chart.setRotationAngle(0);
        pie_chart.setRotationEnabled(true);
        pie_chart.setHighlightPerTapEnabled(true);
    }

    @Override
    @Deprecated
    public void showLeftAxis(YAxis Axis) {

    }

    @Override
    @Deprecated
    public void showRightAxis(YAxis Axis) {

    }

    @Override
    @Deprecated
    public void showTopAxis(XAxis Axis) {

    }

    @Override
    @Deprecated
    public void showBottomAxis(XAxis Axis) {

    }

    public void setData(PeiChartDataAdapter peiChartDataAdapter ){

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int i = 0; i < peiChartDataAdapter.getSize(); i++) {
            entries.add(new PieEntry((float) peiChartDataAdapter.getItemNum(i)/peiChartDataAdapter.getAllNum(),  peiChartDataAdapter.getItemName(i)));
            colors.add(peiChartDataAdapter.getViewItemColor(i));
        }
        PieDataSet dataSet = new PieDataSet(entries, "data");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
        pie_chart.setData(data);
        pie_chart.highlightValues(null);
        pie_chart.invalidate();
    }

    @Override
    public void setDescription(String description) {
        pie_chart.setCenterText(description);


    }
}
