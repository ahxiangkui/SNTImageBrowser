package com.snt.lib.snt_image_browser;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangkui on 16/4/5.
 */
public class ImageBrowserTabAdapter extends FragmentStatePagerAdapter {

    private Context context;

    private List<View> tabViews = new ArrayList<>();
    private String[] imgs;
    private ImageFragmentCallback callback;

    public ImageBrowserTabAdapter(FragmentManager fm, Context context, String[] imgs, ImageFragmentCallback callback) {
        super(fm);
        this.context = context;
        this.imgs = imgs;
        this.callback = callback;
    }

    public List<View> getTabViews() {
        return tabViews;
    }

    @Override
    public Fragment getItem(int position) {

        return ImageBrowserFragment.newInstance(imgs[position], callback);

    }


    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return "";
    }

}
