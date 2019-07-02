package com.snt.lib.snt_image_browser;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.indicator.progresspie.ProgressPieIndicator;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.github.piasy.biv.view.BigImageView;
import com.github.piasy.biv.view.GlideImageViewFactory;


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

        BigImageView itemImage = findViewById(R.id.itemImage);
        itemImage.setProgressIndicator(new ProgressPieIndicator());
        itemImage.setTapToRetry(true);
        itemImage.setImageViewFactory(new GlideImageViewFactory());
        itemImage.showImage(Uri.parse(imageUrl));
        itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }


}
