package com.snt.lib.snt_image_browser;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.piasy.biv.indicator.progresspie.ProgressPieIndicator;
import com.github.piasy.biv.view.BigImageView;
import com.github.piasy.biv.view.GlideImageViewFactory;

import java.io.File;


public class ImageBrowserFragment extends Fragment {

    private String picUrl;
    private ImageFragmentCallback callback;
    private View fragmentV;

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setCallback(ImageFragmentCallback callback) {
        this.callback = callback;
    }

    public static ImageBrowserFragment newInstance(String picUrl, ImageFragmentCallback callback) {
        ImageBrowserFragment fragment = new ImageBrowserFragment();
        fragment.setPicUrl(picUrl);
        fragment.setCallback(callback);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (fragmentV == null){

            fragmentV = inflater.inflate(R.layout.fragment_image_browser, container, false);

            BigImageView itemImage = fragmentV.findViewById(R.id.itemImage);
            itemImage.setProgressIndicator(new ProgressPieIndicator());
            itemImage.setTapToRetry(true);
            itemImage.setImageViewFactory(new GlideImageViewFactory());
            itemImage.showImage(picUrl.startsWith("http") ? Uri.parse(picUrl) : Uri.fromFile(new File(picUrl)));
            itemImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null){
                        callback.imageItemClick();
                    }
                }
            });
        }

        return fragmentV;
    }


}
