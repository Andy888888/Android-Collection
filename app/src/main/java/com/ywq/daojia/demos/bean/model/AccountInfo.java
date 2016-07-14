package com.ywq.daojia.demos.bean.model;

/**
 * @author yanwenqiang
 * @Date 15-9-11
 * @description 待描述
 */
public class AccountInfo {
    private String nickName;
    private String city;

    public AccountInfo(String nickName, String city) {
        this.nickName = nickName;
        this.city = city;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
