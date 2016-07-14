package com.ywq.daojia.demos.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;

import com.ywq.daojia.R;
import com.ywq.daojia.demos.services.RefreshService;
import com.ywq.ylib.base.BaseActivity;
import com.ywq.ylib.widget.MeListView;

/**
 * @author yanwenqiang
 * @Date 15-9-16
 * @description 待描述
 */
public class RefreshActivity extends BaseActivity implements MeListView.OnRefreshCallBack {

    private MeListView meListView;

    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_refresh;
    }

    @Override
    protected void initView() {
        setToolbar(R.id.toolbar);
        setToolbar("下拉刷新", true);

        meListView = (MeListView) findViewById(R.id.mlv_demo_refresh);
        meListView.setOnRefreshCallBack(this);

    }

    @Override
    protected void appendEvents() {

    }

    @Override
    public void downRefresh() {

        startService(new Intent(RefreshService.ACTION_REFRESH).setClass(this, RefreshService.class)
                .putExtra(RefreshService.EXTRA_PERM, new Messenger(refreshHanlder)));
    }

    private Handler refreshHanlder = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            meListView.setRefresh(false);
            toast("刷新完成了");
        }
    };

    @Override
    public void upRefresh() {

    }
}
