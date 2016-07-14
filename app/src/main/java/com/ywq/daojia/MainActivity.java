package com.ywq.daojia;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ywq.daojia.demos.DemoMainActivity;
import com.ywq.ylib.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setToolbar(R.id.toolbar);
        setToolbar("首页", false);

    }

    @Override
    protected void appendEvents() {

    }


    public void click(View v) {
        Intent intent = new Intent(this, DemoMainActivity.class);
        this.startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            toast("开发中...");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
