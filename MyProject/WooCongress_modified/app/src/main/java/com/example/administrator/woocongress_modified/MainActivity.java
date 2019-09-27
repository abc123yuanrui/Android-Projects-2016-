package com.example.administrator.woocongress_modified;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.woocongress_modified.adapter.ImagerPaperAdapter;
import com.example.administrator.woocongress_modified.adapter.JustwordsAdapter;
import com.example.administrator.woocongress_modified.adapter.ListViewAdapter;
import com.example.administrator.woocongress_modified.listelement;
import com.example.administrator.woocongress_modified.MyListView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import android.support.design.widget.TabLayout;
import android.support.design.widget.NavigationView;



public class MainActivity extends AppCompatActivity {
    private String meeting []={"上海联通2016年第二次企务公开暨党务公开发布会","上海联通2017年度工作会议暨二届三次职工代表大会","上海联通党委召开2016年度党建工作会议","2017年上海联通团员青年大会","2017年度信息安全工作会议"};
    private String time [] ={"时间：2016-03-09  9:00-11:00","时间：2017-01-10  9:00-11:01","时间：2016-02-24  9:00-11:02","时间：2017-02-28  9:00-11:03","时间：2017-02-23  9:00-11:00"};
    private String address []={"地点  南宁1002室","地点  浦东1203室","地点  浦东1204室","地点  浦东1015室","地点  南宁1016室"};
    private String sam [] ={"2016-2017年度总结大会圆满失败","上海联通2017年度工作会议暨二届三次职工代表大会","2014-2015年度总结大会圆满失败","2013-2014年度总结大会圆满失败","2012-2013年度总结大会圆满失败"};
    private String theme[]={"上海联通2016年第二次企务公开暨党务公开发布会","上海联通2017年度工作会议暨二届三次职工代表大会","上海联通党委召开2016年度党建工作会议","2017年上海联通团员青年大会","2017年度信息安全工作会议"};
    private String details_d[]={"3月9日，上海联通2016年第二次企务公开暨党务公开发布会在南宁胜利召开。国资委党建局党建处调研员乐鲁斌同志到会指导。会上，深入查摆问题和不足，深刻分析原因，提出了富有针对性和操作性的措施。针对每个述职人进行的述职，与会人员现场进行了提问。",
            "上海联通于1月10日至11日在青浦景苑会议中心召开了2017年度工作会议暨二届三次职工代表大会。大会贯彻落实了集团公司2017年度工作会议精神，全面回顾了2016年各项工作成果，对新一年的目标和任务进行了安排和部署，组织和动员全体干部及员工进一步坚定信心、团结一致，为推动上海联通稳步健康发展续写新的篇章。公司领导班子全体、二级副以上中层干部和广大的职工代表共计200余人参加了会议。",
            "为进一步理清思路、明确下阶段党建工作中的重点、提升全体党员和干部对“抓好党建是最大的政绩”的深刻认识，2月24日，公司党委在上海联通党校召开了2016年度党建工作会议。公司党委领导班子成员，各党支部（总支）书记、各单位负责人、专（兼）职党务专员参加会议。",
            "2月28日，2017年上海联通团员青年大会顺利召开。公司党委书记、总经理沈洪波，党委委员、 副总经理、团委书记沈可，以及各团委委员、团委干事、团支部委员和团员青年代表近80余人参加活动。会议回顾了本届团委成立一年以来取得的各项成绩，并对2017年团委重点工作进行了部署。",
            "为全面回顾总结2016年上海联通信息安全工作情况，并对新的一年信息安全工作要求进行宣贯和部署，2月23日，2017年信息安全工作会议在长宁2502会议室召开。沈可副总经理及有关部门、各区县分公司主要负责人、信息安全联络员等共65人参加本次会议。"};
    private String details[] = {"","","","",""};
    private List<listelement> listforuse;

    private ImageView popcodebutton;
    private ImageView popsignbutton;
    private int type=0;
    private ListViewAdapter listadapter;

    private MyListView listView;
    private TextView textview_sam;
    private TextView more;
    private LayoutInflater inflater;
    private int selection=-1;
    private int[] signednumber = {0,0,0,0,0};

    Dialog dia;
    private TabLayout mtablayout;
    private ViewPager mviewPager;
    /**用于小圆点图片*/
    private List<ImageView> dotViewList;
    /**用于存放轮播效果图片*/
    private List<ImageView> list;
    private Toolbar toolbar;

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
    public static String ToSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }

//    private void forceScroll() {
//        MotionEvent event = MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), MotionEvent.ACTION_MOVE, listView_sam.getWidth()/2, -1, 0);
//        autoscroller.onTouch(listView_sam, event);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0;i<details_d.length;i++){
            details[i] =ToSBC(details_d[i]);
        }
        toolbar = (Toolbar)findViewById(R.id.toolbar) ;
        toolbar.setTitle("沃会议");
        getIntent();

        listforuse = new ArrayList<listelement>();
        Context context = MainActivity.this;
        dia = new Dialog(context,R.style.OverlayDialog);
        dia.setContentView(R.layout.popout);
        ImageView imageView = (ImageView) dia.findViewById(R.id.popoutimage);
        popcodebutton = (ImageView)findViewById(R.id.codebutton) ;//二维码按键叫popcodebutton
        popsignbutton = (ImageView)findViewById(R.id.signbutton);


        imageView.setBackgroundResource(R.drawable.popcode);
        inflater = LayoutInflater.from(MainActivity.this);


//        dotLayout.removeAllViews();


        if(isAutoPlay){
            startPlay();
        }

//        for(int i = 0; i<meeting.length; i++){
//            listelement listelement=new listelement();
//            listelement.setAddress(address[i]);
//            listelement.setDetails(details[i]);
//            listelement.setTheme(theme[i]);
//            listelement.setTime(time[i]);
//            listelement.setMeeting(meeting[i]);
//            listforuse.add(listelement);
//
//        }
//        for (int j=0;j<sam.length;j++){
//           list_sam.add(sam[j]);
//        }
        Setlist();
        listadapter = new ListViewAdapter(MainActivity.this,type,listforuse);
        listadapter.notifyDataSetChanged();
        listView = (MyListView) findViewById(R.id.listview);
//       listView.addHeaderView(LayoutInflater.from(this).inflate(R.layout.listview_header,null));
        listView.setAdapter(listadapter);

        dotLayout = (LinearLayout) findViewById(R.id.dotLayout_go);
        mviewPager = (ViewPager) findViewById(R.id.myviewPager);
        mtablayout = (TabLayout) findViewById(R.id.tabs);
        mtablayout.addTab(mtablayout.newTab().setText("日程"));
        mtablayout.addTab(mtablayout.newTab().setText("简介"));

        mtablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                type=tab.getPosition();
                listforuse.clear();
                Setlist();
                listadapter = new ListViewAdapter(MainActivity.this, type, listforuse);

                listadapter.notifyDataSetChanged();
                listView.setAdapter(listadapter);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


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
                startActivityForResult(intent_meet,2);
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
    private void Setlist(){
        for(int i = 0; i<meeting.length; i++){
            listelement listelement=new listelement();
            listelement.setAddress(address[i]);
            listelement.setDetails(details[i]);
            listelement.setTheme(theme[i]);
            listelement.setTime(time[i]);
            listelement.setMeeting(meeting[i]);
            listelement.setSignornot(signednumber[i]);
            listforuse.add(listelement);

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
        {
//            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode==RESULT_OK && requestCode==1){
                selection = data.getIntExtra("meetingnumber",selection);
                signednumber[selection]=1;
                Log.d("selection", signednumber+" ");
                listforuse.clear();
                Setlist();


            }
        }
    protected void onResume() {
        super.onResume();
        listadapter.notifyDataSetChanged();
        Log.e("onresume", selection+"---");
    }
    public void initView(){
        dotViewList = new ArrayList<ImageView>();
        list = new ArrayList<ImageView>();


        for (int i = 0; i < 4; i++) {
            ImageView dotView = new ImageView(MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));

            params.leftMargin = 15;//设置小圆点的外边距
            params.rightMargin = 15;

            params.height = 10;//设置小圆点的大小
            params.width = 10;

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
