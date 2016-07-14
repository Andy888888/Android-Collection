package com.ywq.daojia.demos.api;

import android.content.Context;

import com.android.volley.custom.ResponseListener;
import com.ywq.daojia.demos.api.param.LoginParam;
import com.ywq.daojia.demos.bean.LoginBean;

/**
 * @author yanwenqiang
 * @Date 15-9-11
 * @description 登录
 */
public class LoginApi extends QLApi {

    private LoginParam param;

    public LoginApi(Context context, ResponseListener responseListener) {
        super(context, responseListener);
    }

    public LoginParam getParam() {
        return param;
    }

    public void setParam(LoginParam param) {
        this.param = param;
    }

    @Override
    public String getPath() {
        return "login";
    }

    @Override
    public Object getParams() {
        return param;
    }

    @Override
    public Class<?> getBean() {
        return LoginBean.class;
    }
}
