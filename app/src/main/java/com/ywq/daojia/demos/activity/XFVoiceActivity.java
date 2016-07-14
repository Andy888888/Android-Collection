package com.ywq.daojia.demos.activity;

import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.ui.RecognizerDialogListener;
import com.ywq.daojia.R;
import com.ywq.xfvoice.SpeechUtil;
import com.ywq.ylib.base.BaseActivity;

/**
 * @author yanwenqiang
 * @Date 15-9-6
 * @description 待描述
 */
public class XFVoiceActivity extends BaseActivity implements RecognizerDialogListener {

    private AppCompatEditText aedt_xfvoice_result;

    private SpeechUtil speechUtil;

    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_xfvoice;
    }

    @Override
    protected void initView() {
        setToolbar(R.id.toolbar);
        setToolbar("讯飞语音识别", true);

        aedt_xfvoice_result = (AppCompatEditText) findViewById(R.id.aedt_xfvoice_result);

        speechUtil = new SpeechUtil(this, this);
    }

    @Override
    protected void appendEvents() {

    }

    @Override
    protected void onDestroy() {
        speechUtil.destory();
        super.onDestroy();
    }

    public void click(View v) {
        speechUtil.startListen();
    }

    @Override
    public void onResult(RecognizerResult recognizerResult, boolean b) {
        String result = speechUtil.paseResult(recognizerResult);
        aedt_xfvoice_result.setText(result);
    }

    @Override
    public void onError(SpeechError speechError) {

    }
}
