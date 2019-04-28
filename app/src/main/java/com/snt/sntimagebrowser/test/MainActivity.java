package com.snt.sntimagebrowser.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.snt.lib.snt_image_browser.ImageBrowserActivity;
import com.snt.lib.snt_image_browser.ImageItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button showBrowserBtn = findViewById(R.id.btn_show_browser);
        showBrowserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<ImageItem> imageItems = new ArrayList<>();
                imageItems.add(new ImageItem("https://snt-yunzao.oss-cn-hangzhou.aliyuncs.com/2019/4/27/8cd1f3e7-aa3f-4af2-9625-9e5dc38c88c0"));
                imageItems.add(new ImageItem("https://snt-yunzao.oss-cn-hangzhou.aliyuncs.com/2019/4/27/5364faf3-da67-410e-b30c-7f21342a55a8"));
                imageItems.add(new ImageItem("https://snt-yunzao.oss-cn-hangzhou.aliyuncs.com/2019/4/27/b912bb86-5d66-45a5-b17c-b7ecf17eab89"));
                imageItems.add(new ImageItem("https://snt-yunzao.oss-cn-hangzhou.aliyuncs.com/2019/4/27/d338d8a6-034a-4498-92ad-43e49ce99ee5"));

                Intent intent = new Intent(MainActivity.this, ImageBrowserActivity.class);
                intent.putParcelableArrayListExtra("data", imageItems);

                startActivity(intent);
            }
        });
    }
}
