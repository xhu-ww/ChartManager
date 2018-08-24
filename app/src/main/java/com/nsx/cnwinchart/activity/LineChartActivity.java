package com.nsx.cnwinchart.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.nsx.cnwinchart.R;
import com.nsx.cnwinchart.data.CompositeIndexBean;
import com.nsx.cnwinchart.data.IncomeBean;
import com.nsx.cnwinchart.data.LineChartBean;
import com.nsx.cnwinchart.manager.LineChartManager;
import com.nsx.cnwinchart.utils.LocalJsonAnalyzeUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class LineChartActivity extends AppCompatActivity {

    private LineChartBean lineChartBean;
    private List<IncomeBean> incomeBeanList;//个人收益
    private List<CompositeIndexBean> shanghai;//沪市指数
    private List<CompositeIndexBean> shenzheng;//深市指数
    private List<CompositeIndexBean> GEM;//创业板指数

    private LineChart lineChart1;

    private ConstraintLayout cl_shanghai;
    private View view_shanghai;
    private ConstraintLayout cl_shenzhen;
    private View view_shenzhen;
    private ConstraintLayout cl_gem;
    private View view_gem;

    private LineChartManager lineChartManager1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        initData();
        initView();
    }

    private void initData() {
        //获取数据
        lineChartBean = LocalJsonAnalyzeUtil.JsonToObject(this, "line_chart.json", LineChartBean.class);
        incomeBeanList = lineChartBean.getGRID0().getResult().getClientAccumulativeRate();

        shanghai = lineChartBean.getGRID0().getResult().getCompositeIndexShanghai();
        shenzheng = lineChartBean.getGRID0().getResult().getCompositeIndexShenzhen();
        GEM = lineChartBean.getGRID0().getResult().getCompositeIndexGEM();
    }

    private void initView() {
        lineChart1 = findViewById(R.id.lineChart);
        lineChartManager1 = new LineChartManager(lineChart1);

        cl_shanghai = findViewById(R.id.cl_shanghai);
        view_shanghai = findViewById(R.id.view_shanghai);
        cl_shanghai.setOnClickListener(listener);

        cl_shenzhen = findViewById(R.id.cl_shenzhen);
        view_shenzhen = findViewById(R.id.view_shenzhen);
        cl_shenzhen.setOnClickListener(listener);

        cl_gem = findViewById(R.id.cl_gem);
        view_gem = findViewById(R.id.view_gem);
        cl_gem.setOnClickListener(listener);

        //展示图表
        lineChartManager1.showLineChart(incomeBeanList, "我的收益", getResources().getColor(R.color.blue));
        lineChartManager1.addLine(shanghai, "上证指数", getResources().getColor(R.color.orange));

        //设置曲线填充色 以及 MarkerView
        Drawable drawable = getResources().getDrawable(R.drawable.fade_blue);
        lineChartManager1.setChartFillDrawable(drawable);
        lineChartManager1.setMarkerView(this);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.cl_shanghai:
                    view_shanghai.setBackground(getResources().getDrawable(R.drawable.shape_round_orange));

                    view_gem.setBackground(getResources().getDrawable(R.drawable.shape_round_gray));
                    view_shenzhen.setBackground(getResources().getDrawable(R.drawable.shape_round_gray));

                    lineChartManager1.resetLine(1, shanghai, "上证指数", getResources().getColor(R.color.orange));
                    break;
                case R.id.cl_shenzhen:
                    view_shenzhen.setBackground(getResources().getDrawable(R.drawable.shape_round_orange));

                    view_gem.setBackground(getResources().getDrawable(R.drawable.shape_round_gray));
                    view_shanghai.setBackground(getResources().getDrawable(R.drawable.shape_round_gray));

                    lineChartManager1.resetLine(1, shenzheng, "深证指数", getResources().getColor(R.color.orange));
                    break;
                case R.id.cl_gem:
                    view_gem.setBackground(getResources().getDrawable(R.drawable.shape_round_orange));
                    view_shanghai.setBackground(getResources().getDrawable(R.drawable.shape_round_gray));
                    view_shenzhen.setBackground(getResources().getDrawable(R.drawable.shape_round_gray));

                    lineChartManager1.resetLine(1, GEM, "创业指数", getResources().getColor(R.color.orange));
                    break;
            }
        }
    };
}
