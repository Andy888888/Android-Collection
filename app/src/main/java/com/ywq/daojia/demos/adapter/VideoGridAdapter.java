package com.ywq.daojia.demos.adapter;

import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.ywq.daojia.R;
import com.ywq.daojia.demos.bean.model.GridItem;
import com.ywq.ylib.utils.GlideProvider;
import com.ywq.ylib.utils.ViewHolder;

import java.util.List;

/**
 * @author yanwenqiang
 * @Date 15-10-24
 * @description 待描述
 */
public class VideoGridAdapter extends BaseAdapter {

    private List<GridItem> source;
    //glide图片加载
    private DrawableRequestBuilder<String> drawableRequestBuilder;

    public VideoGridAdapter(List<GridItem> source, DrawableRequestBuilder<String> drawableRequestBuilder) {
        this.source = source;
        this.drawableRequestBuilder = drawableRequestBuilder;
    }

    public List<GridItem> getSource() {
        return source;
    }

    @Override
    public int getCount() {
        if(source!=null){
            return source.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(source!=null){
            return source.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_grid, null);
        }

//        FrameLayout fl_video = ViewHolder.get(convertView,R.id.fl_video);
        ImageView img_video = ViewHolder.get(convertView, R.id.img_video);
        AppCompatButton btn_video = ViewHolder.get(convertView, R.id.btn_video);


        GridItem item = source.get(position);

        GlideProvider.loadWithWifi(drawableRequestBuilder, img_video,
                item.getPicUrl(), R.drawable.loadfail, R.drawable.loadfail);

        if(source.get(position).isVideo()){
            btn_video.setVisibility(View.VISIBLE);
        }else {
            btn_video.setVisibility(View.GONE);
        }




        return convertView;
    }
}
