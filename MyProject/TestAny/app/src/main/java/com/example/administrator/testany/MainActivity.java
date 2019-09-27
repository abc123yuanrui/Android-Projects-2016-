package com.example.administrator.testany;
import com.example.administrator.testany.camera.CameraManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.ListActivity;

import android.os.Bundle;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.view.Window;
import android.view.WindowManager;

import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.app.Dialog;
import android.widget.TextView;

import com.example.administrator.testany.adapter.ImagerPaperAdapter;
import com.example.administrator.testany.adapter.ListViewAdapter;

public class MainActivity extends Activity {
    private String meeting []={"研究2017年度党建工作会议","研究2016年度党建工作会议","研究2015年度党建工作会议","研究2014年度党建工作会议","研究2013年度党建工作会议"};
    private String time [] ={"2017-02-05  9:00-11:00","2017-02-05  9:00-11:01","2017-02-05  9:00-11:02","2017-02-05  9:00-11:03","2017-02-05  9:00-11:00"};
    private String address []={"地点  102室","地点  103室","地点  104室","地点  105室","地点  106室"};

    private String sam [] ={"2016-2017年度总结大会圆满失败","2015-2016年度总结大会圆满失败","2014-2015年度总结大会圆满失败","2013-2014年度总结大会圆满失败","2012-2013年度总结大会圆满失败"};
    private LayoutInflater inflater;
    private ArrayList<Object> list_meeting= new ArrayList<Object>();
    private ArrayList<Object> list_time= new ArrayList<Object>();
    private ArrayList<Object> list_address= new ArrayList<Object>();
    private ListViewAdapter listadapter;
    private ListView listView;
    private TextView textview_sam;
    int samcount=0;
    Dialog dia;
    private ViewPager mviewPager;
    /**用于小圆点图片*/
    private List<ImageView> dotViewList;
    /**用于存放轮播效果图片*/
    private List<ImageView> list;

    LinearLayout dotLayout;

    private int currentItem  = 0;//当前页面

    boolean isAutoPlay = true;//是否自动轮播

    private ScheduledExecutorService scheduledExecutorService;
    private ListViewAutoScrollHelper mScrollHelper;

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if(msg.what == 100){
                mviewPager.setCurrentItem(currentItem);
            }

        }

    };
    private Handler handler_sam = new Handler(){
        @Override
        public void handleMessage(Message msg_sam){
            int index_sam=0;
            if (msg_sam.what== 0){
                index_sam=msg_sam.arg1;
                textview_sam.setText(sam[index_sam]);
            }
            super.handleMessage(msg_sam);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<meeting.length;i++){
            list_meeting.add(meeting[i]);
            list_time.add(time[i]);
            list_address.add(address[i]);
        }

        listadapter = new ListViewAdapter(MainActivity.this,list_meeting,list_time,list_address);
        listadapter.notifyDataSetChanged();
        listView = (ListView) findViewById(R.id.listview);
        LayoutInflater lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View headerView = lif.inflate(R.layout.list_header, null);
        listView.addHeaderView(headerView);
        listView.setAdapter(listadapter);
        Log.d("123", "onCreate: ");

        textview_sam = (TextView)findViewById(R.id.sample) ;
        textrun.start();
////
//        mScrollHelper = new ListViewAutoScrollHelper (listView_sam) {
//            @Override
//            public void scrollTargetBy(int deltaX, int deltaY) {
//                listView_sam.smoothScrollBy(2, 0);
//            }
//        };


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.ctype,android.R.layout.simple_list_item_checked);

        textview_sam.setText(sam[0]);
        Context context = MainActivity.this;
//        dia = new Dialog(context,R.style.OverlayDialog);
//        dia.setContentView(R.layout.popout);
//        ImageView imageView = (ImageView) dia.findViewById(R.id.popimage);
//        imageView.setBackgroundResource(R.drawable.popcode);
//        dia.show();
//        dia.setCanceledOnTouchOutside(true);
//        Window w = dia.getWindow();
//        WindowManager.LayoutParams lp = w.getAttributes();
//        lp.x = 0;
//        lp.y = 40;
//        dia.onWindowAttributesChanged(lp);

        inflater = LayoutInflater.from(MainActivity.this);

        mviewPager = (ViewPager) findViewById(R.id.myviewPager);
        dotLayout = (LinearLayout)findViewById(R.id.dotLayout);
        dotLayout.removeAllViews();

        initView();

        if(isAutoPlay){
            startPlay();
        }

    }
//    需要hander刷新
    Thread textrun=new Thread(new Runnable(){
        public void run(){
                while (!Thread.currentThread().isInterrupted()){
                   Message m_sam = handler_sam.obtainMessage();
                    if (samcount==sam.length-1){
                        samcount=-1;
                    }
                    samcount++;
                    m_sam.arg1=samcount;
                    m_sam.what=0;
                    handler_sam.sendMessage(m_sam);

                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
        }

    });

//    ______________________................................................................,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
//    private void startAutoScroll() {
//        getListView().post(new Runnable() {
//            @Override
//            public void run() {
//                forceScroll();
//            }
//        });
//    }
//
//
//    private void forceScroll() {
//        MotionEvent event = MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), MotionEvent.ACTION_MOVE, listView_sam.getWidth()/2, -1, 0);
//        mScrollHelper.onTouch(listView_sam, event);
//    }


    public void initView(){
        dotViewList = new ArrayList<ImageView>();
        list = new ArrayList<ImageView>();


        for (int i = 0; i < 4; i++) {
            ImageView dotView = new ImageView(MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new LayoutParams(
                    LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));

            params.leftMargin = 15;//设置小圆点的外边距
            params.rightMargin = 15;

            params.height = 40;//设置小圆点的大小
            params.width = 40;

            if(i == 0){
                dotView.setBackgroundResource(R.drawable.point_pressed);
            }else{

                dotView.setBackgroundResource(R.drawable.point_unpressed);
            }
            dotLayout.addView(dotView, params);

            dotViewList.add(dotView);
            //上面是动态添加了四个小圆点
        }


        ImageView img1 = (ImageView) inflater.inflate(R.layout.scroll_vew_item, null);
        ImageView img2 = (ImageView) inflater.inflate(R.layout.scroll_vew_item, null);
        ImageView img3 = (ImageView) inflater.inflate(R.layout.scroll_vew_item, null);
        ImageView img4 = (ImageView) inflater.inflate(R.layout.scroll_vew_item, null);

        img1.setBackgroundResource(R.drawable.main_img1);
        img2.setBackgroundResource(R.drawable.main_img2);
        img3.setBackgroundResource(R.drawable.main_img3);
        img4.setBackgroundResource(R.drawable.main_img4);

        list.add(img1);
        list.add(img2);
        list.add(img3);
        list.add(img4);

        ImagerPaperAdapter adapter = new ImagerPaperAdapter((ArrayList)list);

        mviewPager.setAdapter(adapter);
        mviewPager.setCurrentItem(0);
        mviewPager.setOnPageChangeListener(new MyPageChangeListener());

    }

    /**
     * 开始轮播图切换
     */
    private void startPlay(){
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new SlideShowTask(), 1, 4, TimeUnit.SECONDS);
        //根据他的参数说明，第一个参数是执行的任务，第二个参数是第一次执行的间隔，第三个参数是执行任务的周期；
    }

    /**
     *执行轮播图切换任务
     *
     */
    private class SlideShowTask implements Runnable{

        @Override
        public void run() {
            // TODO Auto-generated method stub
            synchronized (mviewPager) {
                currentItem = (currentItem+1)%list.size();
                handler.sendEmptyMessage(100);
            }
        }
    }

    /**
     * ViewPager的监听器
     * 当ViewPager中页面的状态发生改变时调用
     *
     */
    private class MyPageChangeListener implements OnPageChangeListener{

        boolean isAutoPlay = false;
        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub
            switch (arg0) {
                case 1:// 手势滑动，空闲中
                    isAutoPlay = false;
                    System.out.println(" 手势滑动，空闲中");
                    break;
                case 2:// 界面切换中
                    isAutoPlay = true;
                    System.out.println(" 界面切换中");
                    break;
                case 0:// 滑动结束，即切换完毕或者加载完毕
                    // 当前为最后一张，此时从右向左滑，则切换到第一张
                    if (mviewPager.getCurrentItem() == mviewPager.getAdapter().getCount() - 1 && !isAutoPlay) {
                        mviewPager.setCurrentItem(0);
                        System.out.println(" 滑动到最后一张");
                    }
                    // 当前为第一张，此时从左向右滑，则切换到最后一张
                    else if (mviewPager.getCurrentItem() == 0 && !isAutoPlay) {
                        mviewPager.setCurrentItem(mviewPager.getAdapter().getCount() - 1);
                        System.out.println(" 滑动到第一张");
                    }
                    break;
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onPageSelected(int pos) {
            // TODO Auto-generated method stub
            //这里面动态改变小圆点的被背景，来实现效果
            currentItem = pos;
            for(int i=0;i < dotViewList.size();i++){
                if(i == pos){
                    ((View)dotViewList.get(pos)).setBackgroundResource(R.drawable.point_pressed);
                }else {
                    ((View)dotViewList.get(i)).setBackgroundResource(R.drawable.point_unpressed);
                }
            }
        }

    }

}