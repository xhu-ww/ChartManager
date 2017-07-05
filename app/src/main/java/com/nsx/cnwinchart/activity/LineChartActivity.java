package com.nsx.cnwinchart.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.nsx.cnwinchart.R;
import com.nsx.cnwinchart.manager.LineChartManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class LineChartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        LineChart lineChart1 = (LineChart) findViewById(R.id.line_chart1);
        LineChart lineChart2 = (LineChart) findViewById(R.id.line_chart2);

        LineChartManager lineChartManager1 = new LineChartManager(lineChart1);
        LineChartManager lineChartManager2 = new LineChartManager(lineChart2);

        //设置x轴的数据
        ArrayList<Float> xValues = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            xValues.add((float) i);
        }

        //设置y轴的数据()
        List<List<Float>> yValues = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Float> yValue = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                yValue.add((float) (Math.random() * 80));
            }
            yValues.add(yValue);
        }

        //颜色集合
        List<Integer> colours = new ArrayList<>();
        colours.add(Color.GREEN);
        colours.add(Color.BLUE);
        colours.add(Color.RED);
        colours.add(Color.CYAN);

        //线的名字集合
        List<String> names = new ArrayList<>();
        names.add("折线一");
        names.add("折线二");
        names.add("折线三");
        names.add("折线四");

        //创建多条折线的图表
        lineChartManager1.showLineChart(xValues, yValues.get(0), names.get(1), colours.get(3));
        lineChartManager1.setDescription("温度");
        lineChartManager1.setYAxis(100, 0, 11);
        lineChartManager1.setHightLimitLine(70,"高温报警",Color.RED);

        lineChartManager2.showLineChart(xValues, yValues, names, colours);
        lineChartManager2.setYAxis(100, 0, 11);
        lineChartManager2.setDescription("温度");
    }
}
