package com.snt.lib.snt_image_browser;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.loader.glide.GlideImageLoader;

public class ImagesBrowserActivity extends AppCompatActivity implements ImageFragmentCallback {

    private TextView indicatorTV;
    private String[] urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BigImageViewer.initialize(GlideImageLoader.with(this));

        setContentView(R.layout.activity_images_browser);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        indicatorTV = findViewById(R.id.tv_indicator);
        ViewPager viewPager = findViewById(R.id.view_pager);
        urls = getIntent().getStringArrayExtra("urls");
        int position = getIntent().getIntExtra("index", 0);
        ImageBrowserTabAdapter tabAdapter = new ImageBrowserTabAdapter(getSupportFragmentManager(), this, urls, this);
        viewPager.setAdapter(tabAdapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setCurrentItem(position);
        if (urls.length > 1){

            indicatorTV.setText((position+1)+"/"+urls.length);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (urls.length > 1){

                    indicatorTV.setText((i+1)+"/"+urls.length);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @Override
    public void imageItemClick() {
        onBackPressed();
    }
}
