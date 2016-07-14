package com.ywq.daojia.application;

import android.app.Application;

import com.iflytek.cloud.SpeechUtility;
import com.ywq.ylib.request.MyVolley;
import com.ywq.ylib.utils.YLog;

/**
 * @author yanwenqiang
 * @Date 15-9-6
 * @description 待描述
 */
public class DJApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        YLog.setDebug(true);
        MyVolley.init(getApplicationContext());

        //讯飞语音识别
        SpeechUtility.createUtility(getApplicationContext(), "appid=55cb33e6");
    }


}
