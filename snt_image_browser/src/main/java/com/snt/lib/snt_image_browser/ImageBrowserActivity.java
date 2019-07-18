package com.snt.lib.snt_image_browser;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.indicator.progresspie.ProgressPieIndicator;
import com.github.piasy.biv.loader.ImageLoader;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.github.piasy.biv.view.BigImageView;
import com.github.piasy.biv.view.GlideImageViewFactory;

import java.io.File;


public class ImageBrowserActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BigImageViewer.initialize(GlideImageLoader.with(this));
        setContentView(R.layout.activity_image_browser);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        String imageUrl = getIntent().getStringExtra("url");


        final BigImageView itemImage = findViewById(R.id.itemImage);
        itemImage.setProgressIndicator(new ProgressPieIndicator());
        itemImage.setTapToRetry(true);
        itemImage.setImageViewFactory(new GlideImageViewFactory());
        itemImage.showImage(imageUrl.startsWith("http") ? Uri.parse(imageUrl) : Uri.fromFile(new File(imageUrl)));
        itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        itemImage.setImageLoaderCallback(new ImageLoader.Callback() {
            @Override
            public void onCacheHit(int imageType, File image) {

            }

            @Override
            public void onCacheMiss(int imageType, File image) {

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onProgress(int progress) {

            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onSuccess(File image) {
//                itemImage.getSSIV().setMaxScale(10);
            }

            @Override
            public void onFail(Exception error) {

            }
        });


    }


}
