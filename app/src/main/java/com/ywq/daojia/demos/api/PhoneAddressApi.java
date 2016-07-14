package com.ywq.daojia.demos.api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.custom.ResponseListener;
import com.ywq.daojia.demos.bean.PhoneAddressBean;
import com.ywq.ylib.request.BaseApi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanwenqiang
 * @Date 15-11-12
 * @description 待描述
 */
public class PhoneAddressApi extends BaseApi {
    public PhoneAddressApi(Context context, ResponseListener responseListener, String phone) {
        super(context, responseListener);
        this.phone = phone;
    }

    private String phone;

    @Override
    public String getBaseUrl() {
        return "http://apis.baidu.com/apistore/mobilenumber/";
    }

    @Override
    public String getPath() {
        return "mobilenumber";
    }

    @Override
    public Map<String, String> getHeaders() {
        HashMap<String,String> map = new HashMap<>();
        map.put("apikey"," d053e2ab47b3345269a1c4c5147f0e27");

        return map;
    }

    @Override
    public Object getParams() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("phone",phone);
        return map;
    }

    @Override
    public int getMethod() {
        return Request.Method.GET;
    }

    @Override
    public Class<?> getBean() {
        return PhoneAddressBean.class;
    }
}
