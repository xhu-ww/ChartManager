package com.nsx.cnwinchart.manager;

import android.content.Context;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.nsx.cnwinchart.R;
import com.nsx.cnwinchart.view.RadarMarkerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu_ww on 2017/6/26.
 */

public class RadarChartManager {
    private RadarChart mRadarChart;
    private Context mContext;
    private YAxis yAxis;
    private XAxis xAxis;

    public RadarChartManager(Context context, RadarChart radarChart) {
        this.mContext = context;
        this.mRadarChart = radarChart;
        yAxis = mRadarChart.getYAxis();
        xAxis = mRadarChart.getXAxis();
    }

    private void initRadarChart() {
        // 绘制线条宽度，圆形向外辐射的线条  
        mRadarChart.setWebLineWidth(1.5f);
        // 内部线条宽度，外面的环状线条  
        mRadarChart.setWebLineWidthInner(1.0f);
        // 所有线条WebLine透明度  
        mRadarChart.setWebAlpha(100);
        //点击点弹出的标签
        RadarMarkerView mv = new RadarMarkerView(mContext, R.layout.radar_markerview);
        mRadarChart.setMarkerView(mv);

        XAxis xAxis = mRadarChart.getXAxis();
        // X坐标值字体大小  
        xAxis.setTextSize(12f);
        // Y坐标值字体样式  
        // Y坐标值标签个数  
        yAxis.setLabelCount(6, false);
        // Y坐标值字体大小  
        yAxis.setTextSize(15f);
        // Y坐标值是否从0开始  
        yAxis.setStartAtZero(true);
        yAxis.setEnabled(false);
        Legend l = mRadarChart.getLegend();
        // 图例位置  
        l.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
        // 图例X间距  
        l.setXEntrySpace(2f);
        // 图例Y间距  
        l.setYEntrySpace(1f);
    }

    public void showRadarChart(final List<String> xData, List<List<Float>> yDatas, List<String> names, List<Integer> colors) {
        initRadarChart();
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xData.get((int) value % xData.size());
            }
        });

        List<IRadarDataSet> sets = new ArrayList<>();
        for (int i = 0; i < yDatas.size(); i++) {
            ArrayList<RadarEntry> yValues = new ArrayList<>();
            for (int j = 0; j < yDatas.get(i).size(); j++) {
                yValues.add(new RadarEntry(yDatas.get(i).get(j), j));
            }
            RadarDataSet radarDataSet = new RadarDataSet(yValues, names.get(i));
            radarDataSet.setColor(colors.get(i));
            radarDataSet.setDrawFilled(true);
            // 数据线条宽度 
            radarDataSet.setLineWidth(2f);
            sets.add(radarDataSet);
        }

        RadarData data = new RadarData(sets);
        // 数据字体大小  
        data.setValueTextSize(8f);
        // 是否绘制Y值到图表  
        data.setDrawValues(true);
        mRadarChart.setData(data);
        mRadarChart.invalidate();
    }

    /**
     * 设置描述信息
     *
     * @param str
     */
    public void setDescription(String str) {
        Description description = new Description();
        description.setText(str);
        mRadarChart.setDescription(description);
        mRadarChart.invalidate();
    }

    public void setYscale(float max, float min, int labelCount) {
        yAxis.setLabelCount(labelCount, false);
        yAxis.setAxisMinimum(min);
        yAxis.setAxisMaximum(max);
        mRadarChart.invalidate();
    }
}
