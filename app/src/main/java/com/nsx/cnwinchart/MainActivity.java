package com.nsx.cnwinchart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nsx.cnwinchart.activity.BarChartActivity;
import com.nsx.cnwinchart.activity.CombinedChartActivity;
import com.nsx.cnwinchart.activity.LineChartActivity;
import com.nsx.cnwinchart.activity.MeterActivity;
import com.nsx.cnwinchart.activity.PieChartActivity;
import com.nsx.cnwinchart.activity.RadarChartActivity;
import com.nsx.cnwinchart.activity.DynamicLineChartActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button line_chart;
    Button line_chart_date;
    Button bar_chart;
    Button pie_chart;
    Button btn_meter;
    Button btn_radar;
    Button btn_combined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        line_chart = (Button) findViewById(R.id.btn_line_chart);
        line_chart_date = (Button) findViewById(R.id.btn_line_chart_date);
        bar_chart = (Button) findViewById(R.id.btn_bar_chart);
        pie_chart = (Button) findViewById(R.id.btn_pie_chart);
        btn_meter = (Button) findViewById(R.id.btn_meter);
        btn_radar = (Button) findViewById(R.id.btn_radar);
        btn_combined = (Button) findViewById(R.id.btn_combined);

        line_chart.setOnClickListener(this);
        line_chart_date.setOnClickListener(this);
        bar_chart.setOnClickListener(this);
        pie_chart.setOnClickListener(this);
        btn_meter.setOnClickListener(this);
        btn_radar.setOnClickListener(this);
        btn_combined.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_line_chart:
                startActivity(new Intent(this, LineChartActivity.class));
                break;
            case R.id.btn_line_chart_date:
                startActivity(new Intent(this, DynamicLineChartActivity.class));
                break;
            case R.id.btn_bar_chart:
                startActivity(new Intent(this, BarChartActivity.class));
                break;
            case R.id.btn_pie_chart:
                startActivity(new Intent(this, PieChartActivity.class));
                break;
            case R.id.btn_meter:
                startActivity(new Intent(this, MeterActivity.class));
                break;
            case R.id.btn_radar:
                startActivity(new Intent(this, RadarChartActivity.class));
                break;
            case R.id.btn_combined:
                startActivity(new Intent(this, CombinedChartActivity.class));
                break;
        }
    }
}
