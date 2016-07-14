package com.ywq.daojia.demos.api.param;

/**
 * @author yanwenqiang
 * @Date 15-9-11
 * @description 登录接口参数
 */
public class LoginParam extends QLParam {
    private String account;
    private String pwd;

    public LoginParam(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
