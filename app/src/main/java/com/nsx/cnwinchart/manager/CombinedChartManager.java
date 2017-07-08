package com.nsx.cnwinchart.manager;

import android.graphics.Color;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu_ww on 2017/6/27.
 */

public class CombinedChartManager {

    private CombinedChart mCombinedChart;
    private YAxis leftAxis;
    private YAxis rightAxis;
    private XAxis xAxis;

    public CombinedChartManager(CombinedChart combinedChart) {
        this.mCombinedChart = combinedChart;
        leftAxis = mCombinedChart.getAxisLeft();
        rightAxis = mCombinedChart.getAxisRight();
        xAxis = mCombinedChart.getXAxis();
    }

    /**
     * 初始化Chart
     */
    private void initChart() {
        //不显示描述内容
        mCombinedChart.getDescription().setEnabled(false);

        mCombinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR,
                CombinedChart.DrawOrder.LINE
        });

        mCombinedChart.setBackgroundColor(Color.WHITE);
        mCombinedChart.setDrawGridBackground(false);
        mCombinedChart.setDrawBarShadow(false);
        mCombinedChart.setHighlightFullBarEnabled(false);
        //显示边界
        mCombinedChart.setDrawBorders(true);
        //图例说明
        Legend legend = mCombinedChart.getLegend();
        legend.setWordWrapEnabled(true);

        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        //Y轴设置
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f);

        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f);

        mCombinedChart.animateX(2000); // 立即执行的动画,x轴
    }

    /**
     * 设置X轴坐标值
     *
     * @param xAxisValues x轴坐标集合
     */
    public void setXAxis(final List<String> xAxisValues) {

        //设置X轴在底部
        XAxis xAxis = mCombinedChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);

        xAxis.setLabelCount(xAxisValues.size() - 1,false);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xAxisValues.get((int) value % xAxisValues.size());
            }
        });
        mCombinedChart.invalidate();
    }

    /**
     * 得到折线图(一条)
     *
     * @param lineChartY 折线Y轴值
     * @param lineName   折线图名字
     * @param lineColor  折线颜色
     * @return
     */
    private LineData getLineData(List<Float> lineChartY, String lineName, int lineColor) {
        LineData lineData = new LineData();

        ArrayList<Entry> yValue = new ArrayList<>();
        for (int i = 0; i < lineChartY.size(); i++) {
            yValue.add(new Entry(i, lineChartY.get(i)));
        }
        LineDataSet dataSet = new LineDataSet(yValue, lineName);

        dataSet.setColor(lineColor);
        dataSet.setCircleColor(lineColor);
        dataSet.setValueTextColor(lineColor);

        dataSet.setCircleSize(1);
        //显示值
        dataSet.setDrawValues(true);
        dataSet.setValueTextSize(10f);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineData.addDataSet(dataSet);
        return lineData;
    }

    /**
     * 得到折线图(多条)
     *
     * @param lineChartYs 折线Y轴值
     * @param lineNames   折线图名字
     * @param lineColors  折线颜色
     * @return
     */
    private LineData getLineData(List<List<Float>> lineChartYs, List<String> lineNames, List<Integer> lineColors) {
        LineData lineData = new LineData();

        for (int i = 0; i < lineChartYs.size(); i++) {
            ArrayList<Entry> yValues = new ArrayList<>();
            for (int j = 0; j < lineChartYs.get(i).size(); j++) {
                yValues.add(new Entry(j, lineChartYs.get(i).get(j)));
            }
            LineDataSet dataSet = new LineDataSet(yValues, lineNames.get(i));
            dataSet.setColor(lineColors.get(i));
            dataSet.setCircleColor(lineColors.get(i));
            dataSet.setValueTextColor(lineColors.get(i));

            dataSet.setCircleSize(1);
            dataSet.setDrawValues(true);
            dataSet.setValueTextSize(10f);
            dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineData.addDataSet(dataSet);
        }
        return lineData;
    }

    /**
     * 得到柱状图
     *
     * @param barChartY Y轴值
     * @param barName   柱状图名字
     * @param barColor  柱状图颜色
     * @return
     */

    private BarData getBarData(List<Float> barChartY, String barName, int barColor) {
        BarData barData = new BarData();
        ArrayList<BarEntry> yValues = new ArrayList<>();
        for (int i = 0; i < barChartY.size(); i++) {
            yValues.add(new BarEntry(i, barChartY.get(i)));
        }

        BarDataSet barDataSet = new BarDataSet(yValues, barName);
        barDataSet.setColor(barColor);
        barDataSet.setValueTextSize(10f);
        barDataSet.setValueTextColor(barColor);
        barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        barData.addDataSet(barDataSet);

        //以下是为了解决 柱状图 左右两边只显示了一半的问题 根据实际情况 而定
        xAxis.setAxisMinimum(-0.5f);
        xAxis.setAxisMaximum((float) (barChartY.size()- 0.5));
        return barData;
    }

    /**
     * 得到柱状图(多条)
     *
     * @param barChartYs Y轴值
     * @param barNames   柱状图名字
     * @param barColors  柱状图颜色
     * @return
     */

    private BarData getBarData(List<List<Float>> barChartYs, List<String> barNames, List<Integer> barColors) {
        List<IBarDataSet> lists = new ArrayList<>();
        for (int i = 0; i < barChartYs.size(); i++) {
            ArrayList<BarEntry> entries = new ArrayList<>();

            for (int j = 0; j < barChartYs.get(i).size(); j++) {
                entries.add(new BarEntry(j, barChartYs.get(i).get(j)));
            }
            BarDataSet barDataSet = new BarDataSet(entries, barNames.get(i));

            barDataSet.setColor(barColors.get(i));
            barDataSet.setValueTextColor(barColors.get(i));
            barDataSet.setValueTextSize(10f);
            barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            lists.add(barDataSet);
        }
        BarData barData = new BarData(lists);

        int amount = barChartYs.size(); //需要显示柱状图的类别 数量
        float groupSpace = 0.12f; //柱状图组之间的间距
        float barSpace = (float) ((1 - 0.12) / amount / 10); // x4 DataSet
        float barWidth = (float) ((1 - 0.12) / amount / 10 * 9); // x4 DataSet

        // (0.2 + 0.02) * 4 + 0.12 = 1.00 即100% 按照百分百布局
        //柱状图宽度
        barData.setBarWidth(barWidth);
        //(起始点、柱状图组间距、柱状图之间间距)
        barData.groupBars(0, groupSpace, barSpace);
        return barData;
    }

    /**
     * 显示混合图(柱状图+折线图)
     *
     * @param xAxisValues X轴坐标
     * @param barChartY   柱状图Y轴值
     * @param lineChartY  折线图Y轴值
     * @param barName     柱状图名字
     * @param lineName    折线图名字
     * @param barColor    柱状图颜色
     * @param lineColor   折线图颜色
     */

    public void showCombinedChart(
            List<String> xAxisValues, List<Float> barChartY, List<Float> lineChartY
            , String barName, String lineName, int barColor, int lineColor) {
        initChart();
        setXAxis(xAxisValues);

        CombinedData combinedData = new CombinedData();

        combinedData.setData(getBarData(barChartY, barName, barColor));
        combinedData.setData(getLineData(lineChartY, lineName, lineColor));
        mCombinedChart.setData(combinedData);
        mCombinedChart.invalidate();
    }

    /**
     * 显示混合图(柱状图+折线图)
     *
     * @param xAxisValues X轴坐标
     * @param barChartYs  柱状图Y轴值
     * @param lineChartYs 折线图Y轴值
     * @param barNames    柱状图名字
     * @param lineNames   折线图名字
     * @param barColors   柱状图颜色
     * @param lineColors  折线图颜色
     */

    public void showCombinedChart(
            List<String> xAxisValues, List<List<Float>> barChartYs, List<List<Float>> lineChartYs,
            List<String> barNames, List<String> lineNames, List<Integer> barColors, List<Integer> lineColors) {
        initChart();
        setXAxis(xAxisValues);

        CombinedData combinedData = new CombinedData();

        combinedData.setData(getBarData(barChartYs, barNames, barColors));
        combinedData.setData(getLineData(lineChartYs, lineNames, lineColors));

        mCombinedChart.setData(combinedData);
        mCombinedChart.invalidate();
    }
}
