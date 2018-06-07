package com.nsx.cnwinchart.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.nsx.cnwinchart.R;
import com.nsx.cnwinchart.manager.RadarChartManager;

import java.util.ArrayList;
import java.util.List;

import static com.github.mikephil.charting.animation.Easing.EasingOption.EaseInCubic;

/**
 * Created by xhu_ww on 2017/6/26.
 */

public class RadarChartActivity extends AppCompatActivity {
    private RadarChart mRadarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raderchart);
        mRadarChart = (RadarChart) findViewById(R.id.radar_chart);

        List<String> xData = new ArrayList<>();
        xData.add("Pizza");
        xData.add("Burger");
        xData.add("Steak");
        xData.add("Salad");
        xData.add("Pasta");

        List<List<Float>> yData = new ArrayList<>();

        ArrayList<Float> yVals1 = new ArrayList<>();
        ArrayList<Float> yVals2 = new ArrayList<>();
        ArrayList<Float> yVals3 = new ArrayList<>();
        ArrayList<Float> yVals4 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            yVals1.add((float) ((Math.random() * 200) + 50));
            yVals2.add((float) (Math.random() * 200) + 40);
            yVals3.add((float) (Math.random() * 200) + 30);
            yVals4.add((float) (Math.random() * 200) + 60);
        }
        yData.add(yVals1);
        yData.add(yVals2);
        yData.add(yVals3);
        yData.add(yVals4);

        List<String> names = new ArrayList<>();
        names.add("蜘蛛一");
        names.add("蜘蛛二");
        names.add("蜘蛛三");
        names.add("蜘蛛四");
        names.add("蜘蛛五");

        List<Integer> colors = new ArrayList<>();

        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);

        RadarChartManager radarChartManager = new RadarChartManager(this, mRadarChart);
        radarChartManager.setYscale(240f, 0f, 6);
        radarChartManager.showRadarChart(xData, yData, names, colors);

    }

    public void closeX(View view) {
        mRadarChart.getXAxis().setEnabled(!mRadarChart.getXAxis().isEnabled());
        mRadarChart.notifyDataSetChanged();
        mRadarChart.invalidate();
    }

    public void closeY(View view) {
        mRadarChart.getYAxis().setEnabled(!mRadarChart.getYAxis().isEnabled());
        mRadarChart.invalidate();
    }

    public void rotation(View view) {
        mRadarChart.spin(2000, mRadarChart.getRotationAngle(), mRadarChart.getRotationAngle() + 360,
                Easing.getEasingFunctionFromOption(EaseInCubic));
    }

    public void isShowY(View view) {
        for (IRadarDataSet set : mRadarChart.getData().getDataSets())
            set.setDrawValues(!set.isDrawValuesEnabled());
        mRadarChart.invalidate();
    }

    public void isRotation(View view) {
        if (mRadarChart.isRotationEnabled())
            mRadarChart.setRotationEnabled(false);
        else
            mRadarChart.setRotationEnabled(true);
        mRadarChart.invalidate();
    }
}
