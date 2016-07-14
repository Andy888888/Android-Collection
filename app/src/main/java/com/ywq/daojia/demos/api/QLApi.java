package com.ywq.daojia.demos.api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.custom.ResponseListener;
import com.ywq.daojia.demos.constant.QLUrl;
import com.ywq.ylib.request.BaseApi;

import java.util.Map;

/**
 * @author yanwenqiang
 * @Date 15-9-11
 * @description QL应用程序接口基类
 */
public abstract class QLApi extends BaseApi {
    public QLApi(Context context, ResponseListener responseListener) {
        super(context, responseListener);
    }

    @Override
    public String getBaseUrl() {
        return QLUrl.mainUrl;
    }


    @Override
    public Map<String, String> getHeaders() {
        return null;
    }

    @Override
    public int getMethod() {
        return Request.Method.POST;
    }
}
