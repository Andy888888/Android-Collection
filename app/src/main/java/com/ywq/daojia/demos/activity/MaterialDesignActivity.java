package com.ywq.daojia.demos.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.ywq.daojia.R;
import com.ywq.ylib.base.BaseActivity;

/**
 * @author yanwenqiang
 * @Date 15-9-18
 * @description Material Design Demo
 */
public class MaterialDesignActivity extends BaseActivity implements View.OnClickListener {

    private FloatingActionButton fab_chat;

    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_material_design;
    }

    @Override
    protected void initView() {
        fab_chat = (FloatingActionButton) findViewById(R.id.fab_chat);
        fab_chat.setOnClickListener(this);
    }

    @Override
    protected void appendEvents() {

    }

    @Override
    public void onClick(View v) {
        Snackbar.make(fab_chat, "这是Snackbar的效果", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}
