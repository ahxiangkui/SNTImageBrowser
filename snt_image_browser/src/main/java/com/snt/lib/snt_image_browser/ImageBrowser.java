package com.snt.lib.snt_image_browser;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

public class ImageBrowser {

    private Activity mActivity;
    private Drawable drawable;
    private String imgUrl;
    private View transitionV;

    public ImageBrowser(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public static ImageBrowser with(Activity mActivity){
        return new ImageBrowser(mActivity);
    }

    public ImageBrowser defaultDraw(Drawable drawable) {
        this.drawable = drawable;
        return this;
    }

    public ImageBrowser url(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public ImageBrowser transitionView(View transitionV) {
        this.transitionV = transitionV;
        return this;
    }

    public void show(){

        ImageBrowserActivity.defaultDrawable = drawable;
        ActivityOptions options = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP && transitionV != null) {
            options = ActivityOptions.makeSceneTransitionAnimation(mActivity, transitionV, "image");

        }
        Intent intent = new Intent(mActivity, ImageBrowserActivity.class);
        if (!TextUtils.isEmpty(imgUrl)){
            intent.putExtra("url", imgUrl);
        }
        intent.putExtra("fromBuilder", true);
        if (options != null){

            mActivity.startActivity(intent, options.toBundle());
        }else {

            mActivity.startActivity(intent);
        }
    }

}
