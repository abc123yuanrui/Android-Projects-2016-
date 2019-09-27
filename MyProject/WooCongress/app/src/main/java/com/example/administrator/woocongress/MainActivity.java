package com.example.administrator.woocongress;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.woocongress.adapter.ListViewAdapter;
import com.example.administrator.woocongress.adapter.JustwordsAdapter;
import com.example.administrator.woocongress.adapter.ImagerPaperAdapter;
import com.example.administrator.woocongress.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private String meeting []={"研究2017年度党建工作会议","研究2016年度党建工作会议","研究2015年度党建工作会议","研究2014年度党建工作会议","研究2013年度党建工作会议"};
    private String time [] ={"时间：2017-02-05  9:00-11:00","时间：2017-02-05  9:00-11:01","时间：2017-02-05  9:00-11:02","时间：2017-02-05  9:00-11:03","时间：2017-02-05  9:00-11:00"};
    private String address []={"地点  102室","地点  103室","地点  104室","地点  105室","地点  106室"};
    private String sam [] ={"2016-2017年度总结大会圆满失败","2015-2016年度总结大会圆满失败","2014-2015年度总结大会圆满失败","2013-2014年度总结大会圆满失败","2012-2013年度总结大会圆满失败"};
    private ImageView popcodebutton;
    private ImageView popsignbutton;
    private ArrayList<Object> list_meeting= new ArrayList<Object>();
    private ArrayList<Object> list_time= new ArrayList<Object>();
    private ArrayList<Object> list_address= new ArrayList<Object>();
    private ArrayList<Object> list_sam = new ArrayList<Object>();
    private ListViewAdapter listadapter;
    private JustwordsAdapter Justadapter;
    private ListView listView;
    private TextView textview_sam;
    private TextView more;
    private LayoutInflater inflater;
    private int samcount =0;
    AnimationSet animationSet = new AnimationSet(true);
    Dialog dia;

    private ViewPager mviewPager;
    /**用于小圆点图片*/
    private List<ImageView> dotViewList;
    /**用于存放轮播效果图片*/
    private List<ImageView> list;

    LinearLayout dotLayout;

    ListViewAutoScrollHelper autoscroller;

    private int currentItem  = 0;//当前页面

    boolean isAutoPlay = true;//是否自动轮播

    private ScheduledExecutorService scheduledExecutorService;

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
                textview_sam.startAnimation(animationSet);

//                textview_sam.setText(sam[index_sam]);
            }
            super.handleMessage(msg_sam);
        }
    };

//    private void forceScroll() {
//        MotionEvent event = MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), MotionEvent.ACTION_MOVE, listView_sam.getWidth()/2, -1, 0);
//        autoscroller.onTouch(listView_sam, event);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Context context = MainActivity.this;
        dia = new Dialog(context,R.style.OverlayDialog);
        dia.setContentView(R.layout.popout);
        ImageView imageView = (ImageView) dia.findViewById(R.id.popoutimage);
        popcodebutton = (ImageView)findViewById(R.id.codebutton) ;//二维码按键叫popcodebutton
        popsignbutton = (ImageView)findViewById(R.id.signbutton);
        more = (TextView)findViewById(R.id.moreinfo);

        ScaleAnimation scaleAnimation = new ScaleAnimation(1,1,1,0,animationSet.RELATIVE_TO_SELF,0.5f,animationSet.RELATIVE_TO_SELF,2);
//                more.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("点击更多", "打开网页 " );
//            }
//        });
        animationSet.setDuration(500);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                    textview_sam.setText(sam[samcount]);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.setBackgroundResource(R.drawable.popcode);
        inflater = LayoutInflater.from(MainActivity.this);


//        dotLayout.removeAllViews();


        if(isAutoPlay){
            startPlay();
        }
        for(int i=0;i<meeting.length;i++){
            list_meeting.add(meeting[i]);
            list_time.add(time[i]);
            list_address.add(address[i]);
        }
        for (int j=0;j<sam.length;j++){
            list_sam.add(sam[j]);
        }

        listadapter = new ListViewAdapter(MainActivity.this,list_meeting,list_time,list_address);
        listadapter.notifyDataSetChanged();
        listView = (ListView) findViewById(R.id.listview);
       listView.addHeaderView(LayoutInflater.from(this).inflate(R.layout.listview_header,null));
        listView.setAdapter(listadapter);

        dotLayout = (LinearLayout) findViewById(R.id.dotLayout_go);
        mviewPager = (ViewPager) findViewById(R.id.myviewPager);

        textview_sam = (TextView) findViewById(R.id.sample);
        textrun.start();

//        listView_sam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,"点击了ListView",Toast.LENGTH_SHORT).show();
//            }
//        });
//        Justadapter = new JustwordsAdapter(MainActivity.this,list_sam);
//
//        listView_sam.setAdapter(Justadapter);
//        Utility utility = new Utility();
//        utility.setListViewHeightBasedOnChildren(listView_sam);
//        Justadapter.notifyDataSetChanged();
//        autoscroller = new ListViewAutoScrollHelper(listView_sam){
//
//                @Override
//                public void scrollTargetBy(int deltaX, int deltaY) {
//                    Log.e("begin", "scrollTargetBy: ," );
//                listView_sam.smoothScrollBy(2, 0);
//            }
//            };

        initView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id){
                listadapter.selectitem(position);
                listadapter.notifyDataSetChanged();
                Intent intent_meet = new Intent();
                intent_meet.setClass(MainActivity.this,Meetingdetail.class);
                intent_meet.putExtra("position",position);
                startActivity(intent_meet);
//                        popcodebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dia.show();
//                dia.setCanceledOnTouchOutside(true);
//                Window w = dia.getWindow();
//                WindowManager.LayoutParams lp = w.getAttributes();
//                lp.x = 0;
//                lp.y = 40;
//                dia.onWindowAttributesChanged(lp);
//            }
//        });
            }

        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                forceScroll();
//            }
//        });
//        popcodebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dia.show();
//                dia.setCanceledOnTouchOutside(true);
//                Window w = dia.getWindow();
//                WindowManager.LayoutParams lp = w.getAttributes();
//                lp.x = 0;
//                lp.y = 40;
//                dia.onWindowAttributesChanged(lp);
//            }
//        });
    }
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

    public void initView(){
        dotViewList = new ArrayList<ImageView>();
        list = new ArrayList<ImageView>();


        for (int i = 0; i < 4; i++) {
            ImageView dotView = new ImageView(MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));

            params.leftMargin = 15;//设置小圆点的外边距
            params.rightMargin = 15;

            params.height = 20;//设置小圆点的大小
            params.width = 20;

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
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {

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
