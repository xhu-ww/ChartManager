package com.nsx.cnwinchart.dashboardview;

import android.view.animation.Interpolator;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class SpringInterpolator implements Interpolator {
    private final float mTension;
    public SpringInterpolator() {
        mTension = 0.4f;

    }
    public SpringInterpolator(float tension) {
        mTension = tension;
    }

    @Override
    public float getInterpolation(float input) {
        float result = (float) (Math.pow(2,-10 * input) *
                Math.sin((input - mTension / 4) * (2 * Math.PI)/mTension) + 1);
        return result;
    }
}
