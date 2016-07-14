package com.ywq.daojia.demos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ywq.daojia.R;
import com.ywq.daojia.demos.activity.BadgeViewActivity;
import com.ywq.daojia.demos.activity.FaceActivity;
import com.ywq.daojia.demos.activity.GetPhoneAdrressActivity;
import com.ywq.daojia.demos.activity.GlideActivity;
import com.ywq.daojia.demos.activity.LoggerActivity;
import com.ywq.daojia.demos.activity.MaterialDesignActivity;
import com.ywq.daojia.demos.activity.QLLoginActivity;
import com.ywq.daojia.demos.activity.RefreshActivity;
import com.ywq.daojia.demos.activity.RoundProgressActivity;
import com.ywq.daojia.demos.activity.SearchViewActivity;
import com.ywq.daojia.demos.activity.VideosActivity;
import com.ywq.daojia.demos.activity.XFVoiceActivity;
import com.ywq.ylib.base.BaseActivity;

/**
 * @author yanwenqiang
 * @Date 15-9-6
 * @description 待描述
 */
public class DemoMainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView lv_demo_main;
    private FloatingActionButton fab_chat;
    private String[] demosTitle;

    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_main;
    }

    @Override
    protected void initView() {
        setToolbar(R.id.toolbar);
        setToolbar("测试首页", true);

        lv_demo_main = (ListView) findViewById(R.id.lv_demo_main);
        lv_demo_main.setOnItemClickListener(this);

        fab_chat = (FloatingActionButton) findViewById(R.id.fab_chat);


    }

    @Override
    protected void appendEvents() {
        demosTitle = new String[]{"讯飞语音", "数字提醒", "圆形进度条", "搜索框", "登录",
                "下拉ListView", "logger", "视频", "手机号码归属地","人脸识别","gif加载"};
        lv_demo_main.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, demosTitle));
        fab_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoMainActivity.this, MaterialDesignActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String title = demosTitle[position];
        Intent intent;
        switch (title) {
            case "讯飞语音":
                intent = new Intent(this, XFVoiceActivity.class);
                this.startActivity(intent);
                break;
            case "数字提醒":
                intent = new Intent(this, BadgeViewActivity.class);
                this.startActivity(intent);
                break;
            case "圆形进度条":
                intent = new Intent(this, RoundProgressActivity.class);
                this.startActivity(intent);
                break;
            case "搜索框":
                intent = new Intent(this, SearchViewActivity.class);
                this.startActivity(intent);
                break;
            case "登录":
                intent = new Intent(this, QLLoginActivity.class);
                this.startActivity(intent);
                break;
            case "下拉ListView":
                intent = new Intent(this, RefreshActivity.class);
                this.startActivity(intent);
                break;
            case "logger":
                intent = new Intent(this, LoggerActivity.class);
                this.startActivity(intent);
                break;
            case "视频":
                intent = new Intent(this, VideosActivity.class);
                this.startActivity(intent);
                break;
            case "手机号码归属地":
                intent = new Intent(this, GetPhoneAdrressActivity.class);
                this.startActivity(intent);
                break;
            case "人脸识别":
                intent = new Intent(this, FaceActivity.class);
                this.startActivity(intent);
                break;
            case "gif加载":
                intent = new Intent(this, GlideActivity.class);
                this.startActivity(intent);
                break;

        }
    }


}
