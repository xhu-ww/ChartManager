package com.nsx.cnwinchart.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.nsx.cnwinchart.R;
import com.nsx.cnwinchart.dashboardview.view.DashboardView;


public class MeterActivity extends AppCompatActivity implements View.OnClickListener {
    DashboardView dashboardView;

    Button btn_temp;
    Button btn_pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter);

        dashboardView = (DashboardView) findViewById(R.id.dashboardView);
        btn_temp = (Button) findViewById(R.id.btn_temp);
        btn_pressure = (Button) findViewById(R.id.btn_pressure);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);

        btn_temp.setOnClickListener(this);
        btn_pressure.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                dashboardView.setPercent(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_temp:
                dashboardView.setTikeStrArray(new String[]{"0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100"});
                dashboardView.setText("当前温度");
                dashboardView.setUnit("0℃");
                dashboardView.setMaxNum(100);
                break;
            case R.id.btn_pressure:
                dashboardView.setTikeStrArray(new String[]{"0k", "10k", "20k", "30k", "40k", "50k", "60k", "70k", "80k", "90k", "100k"});
                dashboardView.setText("当前压强");
                dashboardView.setUnit("kPa");
                dashboardView.setMaxNum(100);
                break;
        }
    }
}
