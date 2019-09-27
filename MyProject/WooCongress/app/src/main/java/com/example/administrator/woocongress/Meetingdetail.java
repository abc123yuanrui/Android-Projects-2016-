package com.example.administrator.woocongress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Meetingdetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetingdetail);
        getIntent();
    }
}
