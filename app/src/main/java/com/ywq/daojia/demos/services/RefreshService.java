package com.ywq.daojia.demos.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.ywq.daojia.R;

/**
 * @author yanwenqiang
 * @Date 15-9-17
 * @description 待描述
 */
public class RefreshService extends IntentService {

    public RefreshService(){
        super("RefreshService");
    }

    public final static String ACTION_REFRESH = "com.ywq.daojia.demos.refresh";
    public final static String ACTION_MORE = "com.ywq.daojia.demos.more";
    public static final String EXTRA_PERM = "com.ywq.daojia.demos.extra.EXTRA_PERM";

    private Messenger messenger;


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null || intent.getAction() == null)
            return;
        final String action = intent.getAction();
        if (ACTION_REFRESH.equals(action)) {

            Bundle bundle = intent.getExtras();
            messenger = (Messenger) bundle.get(EXTRA_PERM);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (ACTION_MORE.equals(action)) {

        } else {

        }

        sendMsg(true);

    }

    private void sendMsg(boolean status) {
        if (messenger != null) {
            Message msg = Message.obtain();
            msg.what = status ? R.id.config_success : R.id.config_error;
            try {
                messenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
