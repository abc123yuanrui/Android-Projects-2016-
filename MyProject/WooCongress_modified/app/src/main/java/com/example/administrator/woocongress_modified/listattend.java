package com.example.administrator.woocongress_modified;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/2/13 0013.
 */

public class listattend {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String name;
    private int imageid;
    private String state;
    private String time;
}
