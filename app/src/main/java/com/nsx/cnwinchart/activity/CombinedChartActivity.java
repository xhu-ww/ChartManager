
package com.nsx.cnwinchart.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.CombinedChart;
import com.nsx.cnwinchart.R;
import com.nsx.cnwinchart.manager.CombinedChartManager;

import java.util.ArrayList;
import java.util.List;

public class CombinedChartActivity extends AppCompatActivity {

    private CombinedChart mCombinedChart1;
    private CombinedChart mCombinedChart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinedchart);

        mCombinedChart1 = (CombinedChart) findViewById(R.id.chart1);
        mCombinedChart2 = (CombinedChart) findViewById(R.id.chart2);

        //x轴数据
        List<String> xData = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            xData.add(String.valueOf(i));
        }
        //y轴数据集合
        List<List<Float>> yBarDatas = new ArrayList<>();
        //4种直方图
        for (int i = 0; i < 4; i++) {
            //y轴数
            List<Float> yData = new ArrayList<>();
            for (int j = 0; j <= 20; j++) {
                yData.add((float) (Math.random() * 100));
            }
            yBarDatas.add(yData);
        }
        //y轴数据集合
        List<List<Float>> yLineDatas = new ArrayList<>();
        //4种直方图
        for (int i = 0; i < 4; i++) {
            //y轴数
            List<Float> yData = new ArrayList<>();
            for (int j = 0; j <= 20; j++) {
                yData.add((float) (Math.random() * 100));
            }
            yLineDatas.add(yData);
        }
        //名字集合
        List<String> barNames = new ArrayList<>();
        barNames.add("直方图一");
        barNames.add("直方图二");
        barNames.add("直方图三");
        barNames.add("直方图四");
        //颜色集合
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.CYAN);
        //竖状图管理类

        List<String> lineNames = new ArrayList<>();
        lineNames.add("折线图一");
        lineNames.add("折线图二");
        lineNames.add("折线图三");
        lineNames.add("折线图四");


        //管理类
        CombinedChartManager combineChartManager1 = new CombinedChartManager(mCombinedChart1);
        combineChartManager1.showCombinedChart(xData, yBarDatas.get(0), yLineDatas.get(0),
                "直方图", "线性图", colors.get(0), colors.get(1));

        CombinedChartManager combineChartManager2 = new CombinedChartManager(mCombinedChart2);
        combineChartManager2.showCombinedChart(xData, yBarDatas, yLineDatas, barNames, lineNames,
                colors, colors);

    }

}
