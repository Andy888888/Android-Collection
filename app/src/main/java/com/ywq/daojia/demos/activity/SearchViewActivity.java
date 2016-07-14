package com.ywq.daojia.demos.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.ywq.daojia.R;
import com.ywq.ylib.base.BaseActivity;

import java.lang.reflect.Field;

/**
 * @author yanwenqiang
 * @Date 15-9-8
 * @description 待描述
 */
public class SearchViewActivity extends BaseActivity {

    private SearchView sv_searchview;

    @Override
    protected int setLayoutId() {
        return R.layout.demo_activity_searchview;
    }

    @Override
    protected void initView() {
        sv_searchview = (SearchView) findViewById(R.id.sv_searchview);

//        int search_mag_icon_id = sv_searchview.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null);
//        ImageView mSearchViewIcon = (ImageView) sv_searchview.findViewById(search_mag_icon_id);// 获取搜索图标
//        mSearchViewIcon.setImageResource(R.drawable.mm1);
//        sv_searchview.setIconifiedByDefault(false);//(设置搜索图标在编辑框外，ture时在框内)。

        try {


            //指定某个私有属性
            Class argClass = sv_searchview.getClass();
            Field mSearchHintIconField = argClass.getDeclaredField("mSearchHintIcon");
            mSearchHintIconField.setAccessible(true);
            ImageView mSearchHintIcon = (ImageView) mSearchHintIconField.get(sv_searchview);
//            mSearchHintIcon.setVisibility(View.GONE);
            mSearchHintIcon.setImageResource(R.drawable.mm0);

//            sv_searchview.setQueryRefinementEnabled(true);
            sv_searchview.setQuery(" ",true);

//            //注意mSearchPlate的背景是stateListDrawable(不同状态不同的图片)  所以不能用BitmapDrawable
//            Field ownField = argClass.getDeclaredField("mSearchPlate");
//            //setAccessible 它是用来设置是否有权限访问反射类中的私有属性的，只有设置为true时才可以访问，默认为false
//            ownField.setAccessible(true);
//            View mView = (View) ownField.get(sv_searchview);
//            mView.setBackground(getResources().getDrawable(R.drawable.mm2));


            //==============================================================================


            //修改关闭图标
            Field mCloseButton = argClass.getDeclaredField("mCloseButton");
            mCloseButton.setAccessible(true);
            ImageView backView = (ImageView) mCloseButton.get(sv_searchview);
            backView.setImageResource(R.drawable.aa);
            backView.setVisibility(View.VISIBLE);

//            //修改为展开时的搜索图标
//            Field mSearchButton = argClass.getDeclaredField("mSearchButton");
//            mSearchButton.setAccessible(true);
//            ImageView search = (ImageView) mSearchButton.get(sv_searchview);
//            search.setImageResource(R.drawable.mm1);
//            search.setVisibility(View.VISIBLE);

//            //修改光标
//            //指定某个私有属性
//            Field mQueryTextView = argClass.getDeclaredField("mQueryTextView");
//            mQueryTextView.setAccessible(true);
//            Class<?> mTextViewClass = mQueryTextView.get(sv_searchview).getClass().getSuperclass().getSuperclass().getSuperclass();
//            //mCursorDrawableRes光标图片Id的属性 这个属性是TextView的属性，所以要用mQueryTextView（SearchAutoComplete）
//            //的父类（AutoCompleteTextView）的父  类( EditText）的父类(TextView)
//            Field mCursorDrawableRes = mTextViewClass.getDeclaredField("mCursorDrawableRes");
//            //setAccessible 它是用来设置是否有权限访问反射类中的私有属性的，只有设置为true时才可以访问，默认为false
//            mCursorDrawableRes.setAccessible(true);
//            //注意第一个参数持有这个属性(mQueryTextView)的对象(mSearchView) 光标必须是一张图片不能是颜色，因为光标有两张图片，
//            //一张是第一次获得焦点的时候的闪烁的图片，一张是后边有内容时候的图片，如果用颜色填充的话，就会失去闪烁的那张图片，
//            //颜色填充的会缩短文字和光标的距离（某些字母会背光标覆盖一部分）。
//            mCursorDrawableRes.set(mQueryTextView.get(sv_searchview), R.drawable.mm1);

        }catch (Exception ex)
        {

        }
    }

    @Override
    protected void appendEvents() {
        sv_searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                toast("搜索");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}
