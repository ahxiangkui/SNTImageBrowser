package com.snt.lib.snt_image_browser;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;


public class ImageBrowserActivity extends AppCompatActivity implements RequestListener<Drawable> {

    public static Drawable defaultDrawable;
    private PhotoView photoView;
    private ImageView placeholderIV;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_browser);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        photoView = findViewById(R.id.photo_view);

        photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        progressBar = findViewById(R.id.progress_bar);
        placeholderIV = findViewById(R.id.iv_placeholder);

        if (!getIntent().getBooleanExtra("fromBuilder", false)){
            defaultDrawable = null;
        }

        String imageUrl = getIntent().getStringExtra("url");

        if (defaultDrawable != null){
            placeholderIV.setImageDrawable(defaultDrawable);
        }

        Glide.with(this)
                .load(imageUrl)
                .listener(this)
                .fitCenter()
                .into(photoView);

        postponeEnterTransition();
        photoView.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        photoView.getViewTreeObserver().removeOnPreDrawListener(this);
                        startPostponedEnterTransition();
                        return true;
                    }
                }
        );

        photoView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {
                onBackPressed();
            }
        });

    }

    @Override
    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "图片加载失败", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
        progressBar.setVisibility(View.GONE);
        placeholderIV.setVisibility(View.GONE);
        return false;
    }


}
