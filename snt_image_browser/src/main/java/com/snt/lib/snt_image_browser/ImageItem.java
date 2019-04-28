package com.snt.lib.snt_image_browser;


import android.os.Parcel;
import android.os.Parcelable;

public class ImageItem implements Parcelable {


    private String url;
    private String title;

    public ImageItem() {
    }

    public ImageItem(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public ImageItem(String url) {
        this.url = url;
    }

    public static final Parcelable.Creator<ImageItem> CREATOR = new Creator<ImageItem>() {
        @Override
        public ImageItem createFromParcel(Parcel source) {
            return new ImageItem(source.readString(), source.readString());
        }

        @Override
        public ImageItem[] newArray(int size) {
            return new ImageItem[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.url);
        dest.writeString(this.title);
    }
}
