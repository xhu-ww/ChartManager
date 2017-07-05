package com.nsx.cnwinchart.dashboardview.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class PxUtils {
    /**
     * 单位转换
     */
    public static int dpToPx(int dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int spToPx(int sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
}

