package com.snt.sntimagebrowser.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.snt.lib.snt_image_browser.ImageBrowser;

public class MainActivity extends AppCompatActivity {

    private ImageView photoDraweeView;
    private Button showBrowserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        showBrowserBtn = findViewById(R.id.btn_show_browser);
        showBrowserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageBrowser.with(MainActivity.this)
                        .transitionView(showBrowserBtn)
                        .url("https://snt-yunzao.oss-cn-hangzhou.aliyuncs.com/2019/4/27/8cd1f3e7-aa3f-4af2-9625-9e5dc38c88c0")
                        .show();

            }
        });



        photoDraweeView = findViewById(R.id.image_view);
        Glide.with(this).load("https://snt-yunzao.oss-cn-hangzhou.aliyuncs.com/2019/4/27/8cd1f3e7-aa3f-4af2-9625-9e5dc38c88c0").into(photoDraweeView);
        photoDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageBrowser.with(MainActivity.this)
                        .transitionView(photoDraweeView)
                        .defaultDraw(photoDraweeView.getDrawable())
                        .url("https://snt-yunzao.oss-cn-hangzhou.aliyuncs.com/2019/4/27/8cd1f3e7-aa3f-4af2-9625-9e5dc38c88c0")
                        .show();
            }
        });


    }
}
