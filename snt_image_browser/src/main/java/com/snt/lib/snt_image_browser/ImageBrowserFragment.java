package com.snt.lib.snt_image_browser;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.relex.photodraweeview.PhotoDraweeView;


public class ImageBrowserFragment extends Fragment {

    private ImageItem imageItem;

    public void setImageItem(ImageItem imageItem) {
        this.imageItem = imageItem;
    }

    public static ImageBrowserFragment newInstance(ImageItem imageItem) {
        ImageBrowserFragment fragment = new ImageBrowserFragment();
        fragment.setImageItem(imageItem);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentV = inflater.inflate(R.layout.fragment_image_browser, container, false);

        PhotoDraweeView photoDraweeView = fragmentV.findViewById(R.id.photo_drawee_view);
        if (imageItem != null && !TextUtils.isEmpty(imageItem.getUrl())){
            photoDraweeView.setPhotoUri(Uri.parse(imageItem.getUrl()));
        }

        return fragmentV;
    }

}
