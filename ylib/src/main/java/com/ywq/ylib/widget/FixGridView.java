package com.ywq.ylib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @author yanwenqiang
 * @Date 15-10-24
 * @description 固定高度GridView
 */
public class FixGridView extends GridView {

    public FixGridView(Context context) {
        super(context);
    }

    public FixGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
