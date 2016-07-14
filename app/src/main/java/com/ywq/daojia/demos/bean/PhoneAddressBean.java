package com.ywq.daojia.demos.bean;

import com.ywq.daojia.demos.bean.model.PhoneInfo;

/**
 * @author yanwenqiang
 * @Date 15-11-12
 * @description 待描述
 */
public class PhoneAddressBean {
    private Integer errNum;
    private String retMsg;
    private PhoneInfo retData;

    public Integer getErrNum() {
        return errNum;
    }

    public void setErrNum(Integer errNum) {
        this.errNum = errNum;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public PhoneInfo getRetData() {
        return retData;
    }

    public void setRetData(PhoneInfo retData) {
        this.retData = retData;
    }
}
