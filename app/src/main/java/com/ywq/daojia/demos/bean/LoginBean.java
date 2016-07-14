package com.ywq.daojia.demos.bean;

import com.ywq.daojia.demos.bean.model.AccountInfo;
import com.ywq.daojia.demos.bean.model.AppConfig;

/**
 * @author yanwenqiang
 * @Date 15-9-11
 * @description 待描述
 */
public class LoginBean extends QLBean {

    private AppConfig appConfig;
    private AccountInfo accountInfo;

    public LoginBean(AppConfig appConfig, AccountInfo accountInfo) {
        this.appConfig = appConfig;
        this.accountInfo = accountInfo;
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }

    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }
}
