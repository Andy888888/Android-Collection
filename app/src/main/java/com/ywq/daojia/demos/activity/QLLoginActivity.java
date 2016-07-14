package com.ywq.daojia.demos.activity;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;

import com.ywq.daojia.R;
import com.ywq.daojia.demos.api.LoginApi;
import com.ywq.daojia.demos.api.param.LoginParam;
import com.ywq.daojia.demos.bean.LoginBean;
import com.ywq.ylib.base.NetWorkActivity;

/**
 * @author yanwenqiang
 * @Date 15-9-11
 * @description 待描述
 */
public class QLLoginActivity extends NetWorkActivity {

    private AppCompatEditText atv_demo_account;
    private AppCompatEditText atv_demo_pwd;
    private AppCompatButton abtn_demo_login;

    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_qllogin;
    }

    @Override
    protected void initView() {
        setToolbar(R.id.toolbar);
        setToolbar("强力组合", true);

        atv_demo_account = (AppCompatEditText) findViewById(R.id.atv_demo_account);
        atv_demo_pwd = (AppCompatEditText) findViewById(R.id.atv_demo_pwd);
        abtn_demo_login = (AppCompatButton) findViewById(R.id.abtn_demo_login);
    }

    @Override
    protected void appendEvents() {
        abtn_demo_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        abtn_demo_login.setText("<h1>这是标题</h1>");
    }

    private void login() {
        String account = atv_demo_account.getText().toString().trim();
        String pwd = atv_demo_pwd.getText().toString().trim();

        if (TextUtils.isEmpty(account)) {
            toast("请输入账号！");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            toast("请输入密码！");
            return;
        }

        LoginApi api = new LoginApi(this, this);
        api.setParam(new LoginParam(account, pwd));

        request(api);
    }

    @Override
    public void response(Object obj) {
        super.response(obj);

        if (obj instanceof LoginBean) {
            LoginBean bean = (LoginBean) obj;
            toast(bean.getAccountInfo().getNickName());
        }
    }
}
