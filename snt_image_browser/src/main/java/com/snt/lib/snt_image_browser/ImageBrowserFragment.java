package com.snt.lib.snt_image_browser;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ImageBrowserFragment extends Fragment {

    private ImageItem imageItem;
    private ImageFragmentCallback callback;

    public void setImageItem(ImageItem imageItem) {
        this.imageItem = imageItem;
    }

    public void setCallback(ImageFragmentCallback callback) {
        this.callback = callback;
    }

    public static ImageBrowserFragment newInstance(ImageItem imageItem, ImageFragmentCallback callback) {
        ImageBrowserFragment fragment = new ImageBrowserFragment();
        fragment.setImageItem(imageItem);
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

        View fragmentV = inflater.inflate(R.layout.fragment_image_browser, container, false);

//        PhotoDraweeView photoDraweeView = fragmentV.findViewById(R.id.photo_drawee_view);
//        if (imageItem != null && !TextUtils.isEmpty(imageItem.getUrl())){
//            photoDraweeView.setPhotoUri(Uri.parse(imageItem.getUrl()));
//        }
//        photoDraweeView.setOnViewTapListener(new OnViewTapListener() {
//            @Override
//            public void onViewTap(View view, float x, float y) {
//                if (callback != null){
//                    callback.imageItemClick();
//                }
//            }
//        });
        return fragmentV;
    }

}
