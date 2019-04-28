package com.snt.lib.snt_image_browser;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;


public class ImageBrowserActivity extends AppCompatActivity {

    private ImageView backIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_browser);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        Fresco.initialize(this);

        backIV = findViewById(R.id.iv_back);
        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ViewPager viewPager = findViewById(R.id.view_pager);

        ArrayList<ImageItem> imageItems = getIntent().getParcelableArrayListExtra("data");
        if (imageItems == null){
            imageItems = new ArrayList<>();
        }

        ImageBrowserTabAdapter tabAdapter = new ImageBrowserTabAdapter(getSupportFragmentManager(), this, imageItems);
        viewPager.setAdapter(tabAdapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backIV.setVisibility(View.GONE);
            }
        });

    }
}
