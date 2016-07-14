package com.ywq.daojia.demos.activity;

import android.os.Handler;
import android.view.View;

import com.ywq.daojia.R;
import com.ywq.ylib.base.BaseActivity;
import com.ywq.ywidgets.common.RoundProgressBar;

/**
 * @author yanwenqiang
 * @Date 15-9-6
 * @description 待描述
 */
public class RoundProgressActivity extends BaseActivity {

    private RoundProgressBar roundProgressBar1;

    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_roundprogressbar;
    }

    @Override
    protected void initView() {
        roundProgressBar1 = (RoundProgressBar) findViewById(R.id.roundProgressBar1);
    }

    @Override
    protected void appendEvents() {
    }

    public void click(View v){
        startProgressBar();
    }

    private void startProgressBar() {


        final Handler handler = new Handler();

        new Thread(new Runnable() {


            @Override
            public void run() {

                int num = 0;

                while (num < 100) {

                    num += 1;
                    if (num >= 100) {
                        num = 100;
                    }

                    roundProgressBar1.setProgress(num);
                    final int finalNum = num;

                    if (num == 100) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                toast("Done ! ");
                            }
                        });
                    }

                    try {
                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        }).start();


    }
}
