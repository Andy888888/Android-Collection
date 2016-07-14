package com.ywq.daojia.demos.activity;

import android.support.v7.widget.AppCompatTextView;

import com.ywq.daojia.R;
import com.ywq.ylib.base.BaseActivity;
import com.ywq.ywidgets.common.BadgeView;

/**
 * @author yanwenqiang
 * @Date 15-9-6
 * @description 数字提醒
 */
public class BadgeViewActivity extends BaseActivity {

    private AppCompatTextView atv_demo_badgeView;
    private BadgeView badgeView;


    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_badgeview;
    }

    @Override
    protected void initView() {
        atv_demo_badgeView = (AppCompatTextView) findViewById(R.id.atv_demo_badgeView);

        badgeView = new BadgeView(this);
        badgeView.setBadgeMargin(0, 10, 10, 0);

    }

    @Override
    protected void appendEvents() {
        badgeView.setTargetView(atv_demo_badgeView);
        badgeView.setBadgeCount(5);
    }
}
