package com.ywq.daojia.demos.activity;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.ywq.daojia.R;
import com.ywq.daojia.demos.api.PhoneAddressApi;
import com.ywq.daojia.demos.bean.PhoneAddressBean;
import com.ywq.ylib.base.NetWorkActivity;

/**
 * @author yanwenqiang
 * @Date 15-11-12
 * @description 待描述
 */
public class GetPhoneAdrressActivity extends NetWorkActivity implements View.OnClickListener {

    private AppCompatButton abtn_get_address;
    private AppCompatEditText aet_phone_number;
    private AppCompatTextView atv_result;

    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_getphoneaddrees;
    }

    @Override
    protected void initView() {

        setToolbar(R.id.toolbar);
        setToolbar("手机号码归属地",true);

        abtn_get_address = (AppCompatButton) findViewById(R.id.abtn_get_address);
        aet_phone_number = (AppCompatEditText) findViewById(R.id.aet_phone_number);
        atv_result = (AppCompatTextView) findViewById(R.id.atv_result);

    }

    @Override
    protected void appendEvents() {
        abtn_get_address.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.abtn_get_address:
                loadingDialog("正在查询...");
                request();
                break;
        }
    }

    private void request() {
        String phoneNumber = aet_phone_number.getText().toString().trim();
        PhoneAddressApi phoneAddressApi = new PhoneAddressApi(this, this, phoneNumber);
        request(phoneAddressApi);
    }

    @Override
    public void response(Object obj) {
        cancelLoadingDiloag();
        super.response(obj);
        if (obj instanceof PhoneAddressBean) {
            PhoneAddressBean phoneAddressBean = (PhoneAddressBean) obj;
            setInfo(phoneAddressBean);
        }
    }

    private void setInfo(PhoneAddressBean phoneAddressBean) {
        atv_result.setText("运营商：" + phoneAddressBean.getRetData().getSupplier() + "\n" +
                "省份：" + phoneAddressBean.getRetData().getProvince() + "\n" +
                "城市：" + phoneAddressBean.getRetData().getCity());
    }
}
