# SNTImageBrowser
图片浏览器
# Usage

```gradle
dependencies {
    implementation 'com.snt.lib:snt_image_browser:1.0.5'
}
```
## 单图
```Java
ImageBrowser.with(MainActivity.this)
        .transitionView(photoDraweeView)
        .url("http://jypxpt.83soft.cn/pic//3587ef66-56b6-410e-98f0-b1ab208dfe43.jpg")
        .show();
```
## 多图
```Java
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
```
