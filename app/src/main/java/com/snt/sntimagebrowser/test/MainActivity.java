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

                String[] urls = new String[]{"http://jypxpt.83soft.cn/pic/3587ef66-56b6-410e-98f0-b1ab208dfe43.jpg"
                        ,"http://jypxpt.83soft.cn//pic/6d99bab1-1b92-408b-926e-707d26b5a603.jpg"
                        ,"http://jypxpt.83soft.cn//pic/0f36febe-2bb9-4c50-b2bc-6dbb6ec3b6c8.jpg"
                        ,"http://jypxpt.83soft.cn//pic/3359683d-8523-4a54-ba75-e549db328bf1.jpg"
                        ,"http://jypxpt.83soft.cn//pic/69a4cf17-e3d2-40cc-836f-c84c54692a68.jpg"
                        ,"http://jypxpt.83soft.cn//pic/daa3e439-fce8-4897-b587-58143b0984f6.jpg"};
                ImageBrowser.with(MainActivity.this)
                        .transitionView(showBrowserBtn)
                        .urls(urls)
                        .position(3)
                        .show();


            }
        });



        photoDraweeView = findViewById(R.id.image_view);
        Glide.with(this).load("http://jypxpt.83soft.cn/pic//3587ef66-56b6-410e-98f0-b1ab208dfe43.jpg").into(photoDraweeView);
        photoDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageBrowser.with(MainActivity.this)
                        .transitionView(photoDraweeView)
                        .url("http://jypxpt.83soft.cn/pic//3587ef66-56b6-410e-98f0-b1ab208dfe43.jpg")
                        .show();

            }
        });


    }
}
