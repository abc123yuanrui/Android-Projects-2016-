package com.example.administrator.coordinatortest;

import android.app.ActionBar;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.coordinatortest.adapter.ImagerPaperAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private TabLayout mtablayout;
    private ViewPager mViewPager;
    private ViewPager mViewPager_2;
    private String[] mTitle = new String[4];
    private String[] mData = new String[4];
    private LayoutInflater inflater;

    private List<ImageView> dotViewList;
    /**
     * 用于存放轮播效果图片
     */
    private List<ImageView> list;
    private Toolbar toolbar;

    LinearLayout dotLayout;

    private int currentItem = 0;//当前页面

    boolean isAutoPlay = true;//是否自动轮播

    private ScheduledExecutorService scheduledExecutorService;

    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtablayout = (TabLayout)findViewById(R.id.tabs);
        toolbar = (Toolbar)findViewById(R.id.toolbar) ;
        toolbar.setTitle("沃会议");
        mtablayout.addTab(mtablayout.newTab().setText("123"));
        mtablayout.addTab(mtablayout.newTab().setText("456"));
        mtablayout.addTab(mtablayout.newTab().setText("888"));


    }
}