package com.ywq.daojia.demos.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bumptech.glide.DrawableRequestBuilder;
import com.ywq.daojia.R;
import com.ywq.ylib.base.BaseActivity;
import com.ywq.ylib.utils.GlideProvider;

import java.util.Calendar;

/**
 * @author yanwenqiang
 * @Date 16-1-4
 * @description 待描述
 */
public class GlideActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageView;
    private Button dateBtn;
    private Button timeBtn;
    private TextView textView;


    int mHour = 0;
    int mMinute = 0;

    int mYear = 0;
    int mMonth = 0;
    int mDay = 0;


    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_glide;
    }

    @Override
    protected void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
        dateBtn = (Button) findViewById(R.id.dateBtn);
        timeBtn = (Button) findViewById(R.id.timeBtn);
        textView = ((TextView) findViewById(R.id.textView));
    }

    @Override
    protected void appendEvents() {

        //http://a.hiphotos.baidu.com/zhidao/pic/item/c2fdfc039245d68814cb8a58a5c27d1ed31b2404.jpg
        //http://img4.imgtn.bdimg.com/it/u=3906236678,3730476902&fm=21&gp=0.jpg
        //http://img4.duitang.com/uploads/blog/201405/01/20140501142243_QNC53.thumb.600_0.gif
        DrawableRequestBuilder<String> drawableRequestBuilder = GlideProvider.init(this);
        drawableRequestBuilder.fitCenter()
                .load("http://img4.duitang.com/uploads/blog/201405/01/20140501142243_QNC53.thumb.600_0.gif")
                .into(imageView);

        dateBtn.setOnClickListener(this);
        timeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Calendar calendar = Calendar.getInstance();

        int viewId = v.getId();
        switch(viewId){
            case R.id.dateBtn:

                new DatePickerDialog(GlideActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        // TODO Auto-generated method stub
                        mYear = year;
                        mMonth = month;
                        mDay = day;
                        //更新EditText控件日期 小于10加0
                        textView.setText(new StringBuilder().append(mYear).append("-")
                                .append((mMonth + 1) < 10 ? 0 + (mMonth + 1) : (mMonth + 1))
                                .append("-")
                                .append((mDay < 10) ? 0 + mDay : mDay));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH) ).show();

                break;
            case R.id.timeBtn:
                new TimePickerDialog(GlideActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hour, int minute) {
                                mHour = hour;
                                mMinute = minute;
                                //更新EditText控件时间 小于10加0
                                textView.setText(new StringBuilder()
                                        .append(mHour < 10 ? 0 + mHour : mHour).append(":")
                                        .append(mMinute < 10 ? 0 + mMinute : mMinute).append(":00"));
                            }
                        }, calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE), true).show();
                break;
        }


    }
}
