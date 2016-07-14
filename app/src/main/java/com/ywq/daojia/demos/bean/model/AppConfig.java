package com.ywq.daojia.demos.bean.model;

/**
 * @author yanwenqiang
 * @Date 15-9-11
 * @description 待描述
 */
public class AppConfig {
    private String backBg;
    private String tag;

    public AppConfig(String backBg, String tag) {
        this.backBg = backBg;
        this.tag = tag;
    }

    public String getBackBg() {
        return backBg;
    }

    public void setBackBg(String backBg) {
        this.backBg = backBg;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
