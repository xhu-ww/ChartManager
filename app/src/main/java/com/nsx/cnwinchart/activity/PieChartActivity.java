package com.nsx.cnwinchart.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.nsx.cnwinchart.R;
import com.nsx.cnwinchart.manager.PieChartManager;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class PieChartActivity extends AppCompatActivity {

    private PieChart mPieChart1;
    private PieChart mPieChart2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        mPieChart1 = (PieChart) findViewById(R.id.pie_chart1);
        mPieChart1.setCenterText("饼状图");//饼状图中间的文字  

        mPieChart2 = (PieChart) findViewById(R.id.pie_chart2);
        mPieChart2.setCenterText("饼状图");//饼状图中间的文字  

        List<String> names = new ArrayList<>(); //每个模块的内容描述
        names.add("模块一");
        names.add("模块二");
        names.add("模块三");
        names.add("模块四");
        List<Float> date = new ArrayList<>(); //每个模块的值（占比率）
        date.add(10.3f);
        date.add(20.2f);
        date.add(30.4f);
        date.add(39.1f);
        List<Integer> colors = new ArrayList<>(); //每个模块的颜色
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.DKGRAY);
        //饼状图管理类
        PieChartManager pieChartManager1 = new PieChartManager(mPieChart1);
        pieChartManager1.setPieChart(names, date, colors);


        PieChartManager pieChartManager2 = new PieChartManager(mPieChart2);
        pieChartManager2.setSolidPieChart(names, date, colors);
    }
}
