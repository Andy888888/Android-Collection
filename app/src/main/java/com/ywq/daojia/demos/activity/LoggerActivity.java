package com.ywq.daojia.demos.activity;

import android.util.Log;

import com.ywq.daojia.MainActivity;
import com.ywq.daojia.R;
import com.ywq.ylib.base.BaseActivity;
import com.ywq.ylib.logger.Logger;

/**
 * @author yanwenqiang
 * @Date 15-9-18
 * @description 待描述
 */
public class LoggerActivity extends BaseActivity {
    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_logger;
    }

    @Override
    protected void initView() {

        //All logs 打印全部日志（堆栈／具体位置）
        Logger.init().setMethodCount(1);
        //Log based
        Logger.t(1).d("hello");

//        Logger.init("daojia").hideThreadInfo().setMethodCount(3).setMethodOffset(2);

        printNormalLog();
        printPretty();
    }

    @Override
    protected void appendEvents() {

    }


    private static final String TAG = MainActivity.class.getSimpleName();


    void printNormalLog() {
        Log.v(TAG, "hey i am a log which you don't see easily");
        Log.v(TAG, "i = 0 + 1");
        Log.v(TAG, Dummy.JSON_WITH_NO_LINE_BREAK);
        Log.v("test", Dummy.JSON_WITH_LINE_BREAK);
    }

    void printPretty() {
        test2();

        try {
            Class clazz = Class.forName("asdfasd");
        } catch (ClassNotFoundException e) {
            Logger.e(e, "something happened");
        }

        String test = "[" + Dummy.JSON_WITH_NO_LINE_BREAK + "," + Dummy.JSON_WITH_NO_LINE_BREAK + "]";

        Logger.json(Dummy.SMALL_SON_WITH_NO_LINE_BREAK);

        Logger.d("test");

        Logger.t("TEST", 3).d("飞机地方");
    }

    void test2() {
        Logger.v("test2");
        Logger.v("test3");
        Logger.v("MYTAG");
        Logger.wtf("test3");
        Logger.d("logger with tag");
        Logger.t("tag").d("logger with tag");
        Logger.t("tag", 3).d("logger with 3 method count");
    }


    class Dummy {

        static final String JSON_WITH_LINE_BREAK = "{\"widget\": {\n" +
                "    \"debug\": \"on\",\n" +
                "    \"window\": {\n" +
                "        \"title\": \"Sample Konfabulator Widget\",\n" +
                "        \"name\": \"main_window\",\n" +
                "        \"width\": 500,\n" +
                "        \"height\": 500\n" +
                "    },\n" +
                "    \"image\": { \n" +
                "        \"src\": \"Images/Sun.png\",\n" +
                "        \"name\": \"sun1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 250,\n" +
                "        \"alignment\": \"center\"\n" +
                "    },\n" +
                "    \"text\": {\n" +
                "        \"data\": \"Click Here\",\n" +
                "        \"size\": 36,\n" +
                "        \"style\": \"bold\",\n" +
                "        \"name\": \"text1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 100,\n" +
                "        \"alignment\": \"center\",\n" +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
                "    }\n" +
                "}} ";

        static final String JSON_WITH_NO_LINE_BREAK = "{\"widget\": {" +
                "    \"debug\": \"on\"," +
                "    \"window\": {" +
                "        \"title\": \"Sample Konfabulator Widget\"," +
                "        \"name\": \"main_window\"," +
                "        \"width\": 500," +
                "        \"height\": 500" +
                "    },\n" +
                "    \"image\": { " +
                "        \"src\": \"Images/Sun.png\"," +
                "        \"name\": \"sun1\"," +
                "        \"hOffset\": 250," +
                "        \"vOffset\": 250," +
                "        \"alignment\": \"center\"" +
                "    },\n" +
                "    \"text\": {" +
                "        \"data\": \"Click Here\"," +
                "        \"size\": 36," +
                "        \"style\": \"bold\"," +
                "        \"name\": \"text1\"," +
                "        \"hOffset\": 250," +
                "        \"vOffset\": 100," +
                "        \"alignment\": \"center\"," +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"" +
                "    }" +
                "}}    ";

        static final String SMALL_SON_WITH_NO_LINE_BREAK = "{\"widget\": {" +
                "    \"debug\": \"on\"," +
                "    \"window\": {" +
                "        \"title\": \"Sample Konfabulator Widget\"," +
                "        \"name\": \"main_window\"," +
                "        \"width\": 500," +
                "        \"height\": 500" +
                "    }" +
                "}}    ";
    }
}
