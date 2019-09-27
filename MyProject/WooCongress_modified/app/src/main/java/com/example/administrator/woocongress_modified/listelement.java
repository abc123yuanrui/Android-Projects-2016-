package com.example.administrator.woocongress_modified;

/**
 * Created by Administrator on 2017/2/13 0013.
 */

public class listelement {
    private String meeting;
    private String time;
    private String address;
    private String theme;
    private String details;

    public int getSignornot() {
        return signornot;
    }

    public void setSignornot(int signornot) {
        this.signornot = signornot;
    }

    private int signornot;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
