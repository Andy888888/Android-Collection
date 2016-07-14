package com.ywq.daojia.demos.activity;

import android.view.View;
import android.widget.AdapterView;

import com.ywq.daojia.R;
import com.ywq.daojia.demos.adapter.VideoGridAdapter;
import com.ywq.daojia.demos.bean.model.GridItem;
import com.ywq.ylib.base.BaseActivity;
import com.ywq.ylib.utils.GlideProvider;
import com.ywq.ylib.widget.FixGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanwenqiang
 * @Date 15-10-24
 * @description 待描述
 */
public class VideosActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private FixGridView gv_video;
    private VideoGridAdapter adapter;

    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_videos;
    }

    @Override
    protected void initView() {
        setToolbar(R.id.toolbar);
        setToolbar("视频", true);

        gv_video = (FixGridView) findViewById(R.id.gv_video);
    }

    @Override
    protected void appendEvents() {
        List<GridItem> source = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            GridItem item = new GridItem();
            if(i%2 == 1) {
                item.setIsVideo(true);
            }else {
                item.setIsVideo(false);
            }
            item.setPicUrl("http://cdn.duitang.com/uploads/item/201405/31/20140531174649_PLhF4.thumb.600_0.jpeg");
//            item.setPicUrl("http://h.hiphotos.baidu.com/image/pic/item/9d82d158ccbf6c81972197aeb93eb13533fa4065.jpg");
            item.setVideoUrl("http://funpicimg.loveinhere.com/1003/85/422064.jpg");

            source.add(item);
        }

        adapter = new VideoGridAdapter(source, GlideProvider.init(this));
        gv_video.setAdapter(adapter);

        gv_video.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        GridItem item = adapter.getSource().get(position);
        String url = item.getVideoUrl();
        toast(url);
    }
}
