package com.example.myapplication.bean;


import android.os.Parcel;
import android.os.Parcelable;

public class HealthInfoDataItem implements Parcelable {
    private int count;
    private String description;
    private int id;
    private String img;
    private String keywords;
    private int loreclass;
    private int rcount;
    private long time;
    private String title;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLoreclass() {
        return loreclass;
    }

    public void setLoreclass(int loreclass) {
        this.loreclass = loreclass;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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
        dest.writeInt(this.count);
        dest.writeString(this.description);
        dest.writeInt(this.id);
        dest.writeString(this.img);
        dest.writeString(this.keywords);
        dest.writeInt(this.loreclass);
        dest.writeInt(this.rcount);
        dest.writeLong(this.time);
        dest.writeString(this.title);
    }

    public HealthInfoDataItem() {
    }

    protected HealthInfoDataItem(Parcel in) {
        this.count = in.readInt();
        this.description = in.readString();
        this.id = in.readInt();
        this.img = in.readString();
        this.keywords = in.readString();
        this.loreclass = in.readInt();
        this.rcount = in.readInt();
        this.time = in.readLong();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<HealthInfoDataItem> CREATOR = new Parcelable.Creator<HealthInfoDataItem>() {
        @Override
        public HealthInfoDataItem createFromParcel(Parcel source) {
            return new HealthInfoDataItem(source);
        }

        @Override
        public HealthInfoDataItem[] newArray(int size) {
            return new HealthInfoDataItem[size];
        }
    };
}
