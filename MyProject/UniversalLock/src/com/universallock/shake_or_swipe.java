package com.universallock;

import adapter.ListViewAdapter;
import adapter.SwitchInterface;
import adapter.color_adapter;
import adapter.display_item_adapter;
import adapter.display_item_interface;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.Vibrator;
import android.printservice.PrintService;
import android.provider.LiveFolders;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.FocusFinder;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.impl.conn.tsccm.WaitingThreadAborter;


import com.squareup.picasso.Picasso;

public class shake_or_swipe extends Activity implements SensorListener, View.OnTouchListener, SensorEventListener, OnClickListener{

	private WindowManager mWM;
	private static final int[] a = { R.drawable.bt0, R.drawable.bt1, R.drawable.bt2, R.drawable.bt3, R.drawable.bt4, R.drawable.bt5, R.drawable.bt6, R.drawable.bt7, R.drawable.bt8, R.drawable.bt9};
	  private static final int[] b = { R.drawable.pin_light,R.drawable.pin_light,R.drawable.pin_light,R.drawable.pin_light};
	  Button b0, b1, b2, b3, b4, b5,b6, b7, b8, b9;
	  private boolean bool = false;
	  Button btncnl, btncntn, btnok, btndelete;
	  private StringBuffer sb1 = new StringBuffer();
	  private StringBuffer sb2 = new StringBuffer();
	  int count = 4;
	  KeyguardManager.KeyguardLock k1;
	  private ArrayList h = new ArrayList();
	  private int lb = b.length,n = 0,i;
	  TextView title;	  
	  private int f1,f2,f3,f4,f5,f6,f7,f8,f9;
	  private ArrayList <File> Fil = new ArrayList<>(); 
		private ArrayList <File> Fil1 = new ArrayList<>();
		private ArrayList <File> Fil2 = new ArrayList<>();
		private ArrayList <File> Fil3 = new ArrayList<>();
		private ArrayList <File> Fil4 = new ArrayList<>();
		private ArrayList <File> Fil5 = new ArrayList<>();
		private ArrayList <File> Fil6 = new ArrayList<>();
		private ArrayList <File> Fil7 = new ArrayList<>();
		private ArrayList <File> Fil8 = new ArrayList<>();
		private static final int DIALOG_ALERT = 10;
		private int e1,e2,e3,e4,e5,e6,e7,e8,e9;
		ViewPager viewPager,viewPager1,viewPager2,viewPager4,viewPager5,viewPager6,viewPager7,
		viewPager8,viewPager9;
MyPagerAdapter myPagerAdapter;
MyPagerAdapter2 myPagerAdapter2;
MyPagerAdapter3 myPagerAdapter3;	
MyPagerAdapter4 myPagerAdapter4;
MyPagerAdapter5 myPagerAdapter5;
MyPagerAdapter6 myPagerAdapter6;
MyPagerAdapter7 myPagerAdapter7;
MyPagerAdapter8 myPagerAdapter8;
MyPagerAdapter9 myPagerAdapter9;

//StringBuffer c1,c2,c3;
String if1,if2,if3,if4,if5,if6,if7,if8,if9;
private int d1,d2,d3,d4,d5,d6,d7,d8,d9,animp;
Button sbtnok,sbtncnl,btnchoose,btncnt,bs1,bs2,bs3,bs4,bs5,bs6,bs7,bs8,bs9,btnconfirm;
public MotionEvent event;
float downX; 
float upX;
private static int currentPage;
//ArrayList<String> a,b,c = new ArrayList<String>();
ArrayList<Bitmap> bitmapArray = new ArrayList<Bitmap>();
ArrayList<Bitmap> bitarray = new ArrayList<Bitmap>();
Bitmap[] bt ;
public String[] al;
private ViewGroup hp;	
File imgFile,imgFile1,imgFile2,imgFile3,imgFile4,imgFile5,imgFile6,imgFile7,imgFile8,imgFile9,iff;
private StringBuilder imagepathb = new StringBuilder();
private StringBuilder imagepathb2 = new StringBuilder();
private StringBuilder imagepathb3 = new StringBuilder();
private StringBuilder imagepathb4 = new StringBuilder();
private StringBuilder imagepathb5 = new StringBuilder();
private StringBuilder imagepathb6 = new StringBuilder();
private StringBuilder imagepathb7 = new StringBuilder();
private StringBuilder imagepathb8 = new StringBuilder();
private StringBuilder imagepathb9 = new StringBuilder();

public static String ab9,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8;
private int z1,z2,z3,z4,z5,z6,z7,z8,z9;
public static int x1,x2,x3,x4,x5,x6,x7,x8,x9;
String[] ar;
 private String[] arr;
 private Bitmap myBitmap,myBitmap1;
 private ArrayList<View> views = new ArrayList<View>();
 BitmapFactory.Options options = new BitmapFactory.Options();
 int l,l1;
 private String[] arey2,arey;
 ByteArrayOutputStream stream = new ByteArrayOutputStream();
private Dialog dialog;
private int id;
private  String MyPREFERENCESS = "MyUserChoices";
private  SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES1 = "displayitem";
	private ImageView battery_img , signal_img,camera_icon;
	private TextView time_id,time_ampm,date_id;
  TextView btl;
  private static final int SWIPE_MIN_DISTANCE = 120;
  private static final int SWIPE_MAX_OFF_PATH = 200;
  private static final int SWIPE_THRESHOLD_VELOCITY = 200;
  private GestureDetector gestureDetector;
  View.OnTouchListener gestureListener;
  long lastTime;
  private Sensor mAccelerometer;
  private SensorManager mSensorManager;
  private shakedetector mShakeDetector;
  PackageManager pm;
  ScrollView scrl;   
  SensorManager sm;  
  String batterperc;
  boolean isFullScreen = false;
  private int wallb;
  public static final String MyPREFERENCES = "MyUserChoicesss";
  private SharedPreferences sharedPreferences;
  private int a1,a2,a3,a4,a5,a6,a7,a8;
  private int c1,c2,c3,c4,c5,c6,c7,c8;
  private int size1,size2,size3,date_format,lsb;
  private String unlock_text,str2,rt;
  private Typeface t1,t2,t3,t4;
  private ContextWrapper context;
  private Notification notification;
  private Uri ring;
  private int status_key,cc7;
  private NotificationManager nManager;
  private Context context1;
  private MediaPlayer mediaPlayer;
  private Configuration config;
  private Window window;
  private int width,height,tts,dts,sts;
  private FrameLayout frm;  
  private View status_bar_view;
  private WindowManager manager,manager1;
  private WindowManager.LayoutParams localLayoutParams,localLayoutParams1; 
  private customViewGroup view;
  private Vibrator vibrator;
  private long pattern[];
  private LayoutParams layoutparams;
  private int x,y,dpos,v,size,camera_val;
  Animation bottomUp;
   int home_x,home_y;
   int windowwidth;
   int windowheight;   
   int[] droidpos;
   private RelativeLayout rl;
   private RelativeLayout rl2;
   private RelativeLayout rrl;
   private FrameLayout shk_frm,add_v1;
   private LinearLayout add_v2;
   private ImageView i1,i2,i3,i4;
   setvalue app;
   private String getstr;
   private Animation leftin,leftout,rightin,rightout,topin,topout,bottomin,bottomout;
	private KeyguardManager km;
  	private static KeyguardManager.KeyguardLock k;
  	private LayoutParams imageParams;
	private boolean bl;
	@Override
	public void onAttachedToWindow(){
		super.onAttachedToWindow();
	}
   @Override
  protected void onNewIntent(Intent intent) {
	   //getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);	    
      super.onNewIntent(intent);
      setIntent(intent);
      
   }
	

public void onCreate(Bundle savedInstanceState)
{
	  bool =  true;
    super.onCreate(savedInstanceState);
    
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_FULLSCREEN);
    
    hideNavBar();
    manager = ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE));

    localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
   localLayoutParams.gravity = Gravity.TOP;    
    
    localLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|

    		WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN |
    		WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
           // Draws over status bar
   WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

   localLayoutParams.height = (int) (50 * getResources().getDisplayMetrics().scaledDensity);
    //localLayoutParams.height = -1;
    //localLayoutParams.width = -1;
   localLayoutParams.format = PixelFormat.TRANSPARENT;

   view = new customViewGroup(this);
   
   manager.addView(view, localLayoutParams);
  
    setContentView(R.layout.homescreen);
      

    //service(new Intent(this,MyService.class));
   // k1 = ((KeyguardManager)getSystemService("keyguard")).newKeyguardLock("lock_home");
	//  c();
	  sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	    
    v = getIntent().getIntExtra("val",0);
    if(v != -1){
    	sharedPreferences.edit().putInt("posv", v).commit();    	
    }
    
    v = sharedPreferences.getInt("posv", 0);
    size = getResources().getDimensionPixelSize(R.dimen.viewpager_img_size);
    gestureDetector = new GestureDetector(this,new SwipeGestureDetector());
    gestureListener = new View.OnTouchListener() {
        @SuppressLint("ClickableViewAccessibility")
		public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }
    };
    app = (setvalue) getApplicationContext();
    	
    	pattern = new long[] {0,200,100,300,400};
        //Start the vibration
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        //start vibration with repeated count, use -1 if you don't want to repeat the vibration

      //View c = getLayoutInflater().inflate(R.layout., root)   
        
        //View itemInfo2 = getLayoutInflater().inflate(R.layout.pin_keypad, rrl, true);
        //View itemInfo3 = getLayoutInflater().inflate(R.layout.galary_view, rrl, true);
	 rl = (RelativeLayout)findViewById(R.id.swipe_pin_rl);
	 rl.setVisibility(View.GONE);     

    	 rl2 = (RelativeLayout)findViewById(R.id.swipe_image_rl);
    	 rl2.setVisibility(View.GONE);     

    	 if(app.getrington() != null){
     		rt = app.getrington();
     		rt();     		
     	 }getdat();
    	 
     	btncnl = (Button) findViewById(R.id.btncancle_shw);    
        btndelete = (Button)findViewById(R.id.btndelete_shw);

        title = (TextView)findViewById(R.id.pin_desc_text);
        camera_icon = (ImageView) findViewById(R.id.camera_icon);	 
    if(color_adapter.p7 != 0){sharedPreferences.edit().putInt("c7", color_adapter.p7).commit();}
    else{sharedPreferences.edit().putInt("c7", -16711684).commit();}
    cc7 = sharedPreferences.getInt("c7", 0);
    
    
    if(app.getimagevalue1() != null){sharedPreferences.edit().putString("sw1", app.getimagevalue1()).commit();}
    if(app.getimagevalue2() != null){sharedPreferences.edit().putString("sw2", app.getimagevalue2()).commit();}
    if(app.getimagevalue3() != null){sharedPreferences.edit().putString("sw3", app.getimagevalue3()).commit();}
    if(app.getimagevalue4() != null){sharedPreferences.edit().putString("sw4", app.getimagevalue4()).commit();}
    if(app.getimagevalue5() != null){sharedPreferences.edit().putString("sw5", app.getimagevalue5()).commit();}
    if(app.getimagevalue6() != null){sharedPreferences.edit().putString("sw6", app.getimagevalue6()).commit();}
    if(app.getimagevalue7() != null){sharedPreferences.edit().putString("sw7", app.getimagevalue7()).commit();}
    if(app.getimagevalue8() != null){sharedPreferences.edit().putString("sw8", app.getimagevalue8()).commit();}
    if(app.getimagevalue9() != null){sharedPreferences.edit().putString("sw9", app.getimagevalue9()).commit();}
    
      ab9 = sharedPreferences.getString("sw1", "");ab1 = sharedPreferences.getString("sw2", "");
 	  ab2 = sharedPreferences.getString("sw3", "");ab3 = sharedPreferences.getString("sw4", "");
 	  ab4 = sharedPreferences.getString("sw5", "");ab5 = sharedPreferences.getString("sw6", "");
 	  ab6 = sharedPreferences.getString("sw7", "");ab7 = sharedPreferences.getString("sw8", "");
 	  ab8 = sharedPreferences.getString("sw9", "");
 	  
 	 if(app.getimageposition1() != 0 || app.getimageposition2() != 0 ||app.getimageposition3() != 0 ||app.getimageposition4() != 0 ||
 			 app.getimageposition5() != 0 ||app.getimageposition6() != 0 ||app.getimageposition7() != 0 ||app.getimageposition8() != 0 ||
 			 app.getimageposition9() != 0)
 	 {
 		 sharedPreferences.edit().putInt("m11", app.getimageposition1()).commit();
 		 sharedPreferences.edit().putInt("m12", app.getimageposition2()).commit();
 		 sharedPreferences.edit().putInt("m13", app.getimageposition3()).commit();
 		 sharedPreferences.edit().putInt("m14", app.getimageposition4()).commit();
 		 sharedPreferences.edit().putInt("m15", app.getimageposition5()).commit();
 		 sharedPreferences.edit().putInt("m16", app.getimageposition6()).commit();
 		 sharedPreferences.edit().putInt("m17", app.getimageposition7()).commit();
 		 sharedPreferences.edit().putInt("m18", app.getimageposition8()).commit();
 		 sharedPreferences.edit().putInt("m19", app.getimageposition9()).commit();
 	 }
 	 f1 = sharedPreferences.getInt("m11", 0);f2 = sharedPreferences.getInt("m12", 0);f3 = sharedPreferences.getInt("m13", 0);
 	  f4 = sharedPreferences.getInt("m14", 0);f5 = sharedPreferences.getInt("m15", 0);f6 = sharedPreferences.getInt("m16", 0);
 	  f7 = sharedPreferences.getInt("m17", 0);f8 = sharedPreferences.getInt("m18", 0);f9 = sharedPreferences.getInt("m19", 0);
 	  
    if(app.getpinvalue() != null){
    	sharedPreferences.edit().putString("get_str", app.getpinvalue()).commit();
    }

    leftout = AnimationUtils.loadAnimation(this,R.anim.left_out);
    leftin = AnimationUtils.loadAnimation(this,R.anim.left_in);
	rightin = AnimationUtils.loadAnimation(this,R.anim.right_in);
	rightout = AnimationUtils.loadAnimation(this,R.anim.right_out);
	topin = AnimationUtils.loadAnimation(this,R.anim.top_in);
	topout = AnimationUtils.loadAnimation(this,R.anim.top_out);
	bottomin = AnimationUtils.loadAnimation(this,R.anim.bottom_in);
	bottomout = AnimationUtils.loadAnimation(this,R.anim.bottom_out);
	
    //getstr = sharedPreferences.getString("get_str", "");
    
	    	
    
    //title.setTextColor(cc8); title.setTextSize(size4); title.setTypeface(t4);
    //getstr = getIntent().getStringExtra("pin_password");
    
    if(app.getpinvalue() != null){
    	sharedPreferences.edit().putString("pin_lock", app.getpinvalue()).commit();    	
    }    
    getstr = sharedPreferences.getString("pin_lock", "");    	
	lb = getstr.length();
    //final Animation leftout = AnimationUtils.loadAnimation(this,R.anim.left_out);


   //Toast.makeText(getApplicationContext(), "This is getstr - "+getstr, Toast.LENGTH_SHORT).show();

    btndelete.setOnClickListener(new OnClickListener() {
       	
       	@Override
       	public void onClick(View v) {
       		// TODO Auto-generated method stub
       		c1string();
       	}
       });
    
    btncnl.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	});
    /*
    	btncnl.setOnClickListener(new View.OnClickListener()
   		 		{
    				@Override
   		 			public void onClick(View view)
   		 			{
   		 				sb1.delete(0, 3);
   		 				sb1.setLength(0);
   		 			if(animp == 1){
   						
   		 			rl.startAnimation(rightin);
   		 			rl.setVisibility(View.GONE);			
   		 			rrl.startAnimation(rightout);
   		 			rrl.setVisibility(View.VISIBLE);	
   		 			}
   		 			else if(animp == 2){
   		 				
   		 				rl.startAnimation(leftout);
   		 				rl.setVisibility(View.GONE);			
   		 				rrl.startAnimation(leftin);
   		 				rrl.setVisibility(View.VISIBLE);	
   		 			}else if(animp == 3){
   		 				
   		 				rl.startAnimation(bottomin);
   		 				rl.setVisibility(View.GONE);			
   		 				rrl.startAnimation(bottomout);
   		 				rrl.setVisibility(View.VISIBLE);	
   		 			}
   		 			else if(animp == 4){
   		 				
   		 				rl.startAnimation(topout);
   		 				rl.setVisibility(View.GONE);			
   		 				rrl.startAnimation(topin);
   		 				rrl.setVisibility(View.VISIBLE);	
   		 			}

   		 			}
   		 	   });
      */          
      

      camera_icon.setOnTouchListener(new OnTouchListener() {
  		
  		@Override
  		public boolean onTouch(View v, MotionEvent event) {
  			// TODO Auto-generated method stub
  			onUpSwipe();
  			camera_val = 1;
  			return true;
  		}
  	});
      
      sbtncnl = (Button) findViewById(R.id.swipe_image_lock_set_btncnl_cnf);
      sbtnok = (Button) findViewById(R.id.swipe_image_lock_set_btnok_cnf);
      
      sbtncnl.setOnClickListener(new OnClickListener() {
		
		private boolean bl;

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			if(animp == 1){
				
			rl2.startAnimation(rightin);
			rl2.setVisibility(View.GONE);			
			rrl.startAnimation(rightout);
			rrl.setVisibility(View.VISIBLE);	
			}
			else if(animp == 2){
				
				rl2.startAnimation(leftout);
				rl2.setVisibility(View.GONE);			
				rrl.startAnimation(leftin);
				rrl.setVisibility(View.VISIBLE);	
			}else if(animp == 3){
				
				rl2.startAnimation(bottomin);
				rl2.setVisibility(View.GONE);			
				rrl.startAnimation(bottomout);
				rrl.setVisibility(View.VISIBLE);	
			}
			else if(animp == 4){
				
				rl2.startAnimation(topout);
				rl2.setVisibility(View.GONE);			
				rrl.startAnimation(topin);
				rrl.setVisibility(View.VISIBLE);	
			}

			rl2.setOnTouchListener(gestureListener);
		}
	});
      sbtnok.setOnClickListener( new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    		
    			if(d1 == f1 && d2 == f2 && d3 == f3 && d4 == f4 && d5== f5 && d6 == f6 && d7 == f7 && d8 == f8 && d9 == f9){
    							
    			  switch(unlock_animation.ua_pos){

    			  	case 0:
    			  		finish();
    			  		break;
    			  	case 1:
    			  		finish();
    			  		overridePendingTransition(0, R.anim.rotate);
    			  		break;
    			  	case 2:
    			  		finish();
    			  		overridePendingTransition(0, R.anim.fade_out);
    			  		break;
    			  	case 3:
    			  		finish();
    			  		overridePendingTransition(0, R.anim.zoom_in);
    			  		break;
    			  	case 4:
    			  		finish();
    			  		overridePendingTransition(0, R.anim.bounce);
    			  		break;
    			  	case 5:
    			  		finish();
    			  		overridePendingTransition(0, R.anim.blink);
    			  		break;	  	
    			  		
    			  }
    			  if(camera_val == 1){
    					Intent i = new Intent("android.media.action.STILL_IMAGE_CAMERA");
    					startActivity(i);
    				}
    			  if(rt != null ){
    				  if(rt.length() >0){
    					  mediaPlayer.start();
    					  vibrator.vibrate(pattern, -1);
    				  }
    			  }
    			}else{
    				Toast.makeText(getApplicationContext(), "Choices not mached", Toast.LENGTH_LONG).show();
    			}
    		}
    	});
      //b0 = (Button) findViewById(R.id.btn0); b0.setOnClickListener(this); 
    b0 = (Button) findViewById(R.id.btn0); b0.setOnClickListener(this);
    b1 = (Button) findViewById(R.id.btn1); b1.setOnClickListener(this);
    b2 = (Button) findViewById(R.id.btn2); b2.setOnClickListener(this);
    b3 = (Button) findViewById(R.id.btn3); b3.setOnClickListener(this);
    b4 = (Button) findViewById(R.id.btn4); b4.setOnClickListener(this);
    b5 = (Button) findViewById(R.id.btn5); b5.setOnClickListener(this); 
    b6 = (Button) findViewById(R.id.btn6); b6.setOnClickListener(this); 
    b7 = (Button) findViewById(R.id.btn7); b7.setOnClickListener(this); 
    b8 = (Button) findViewById(R.id.btn8); b8.setOnClickListener(this);
    b9 = (Button) findViewById(R.id.btn9); b9.setOnClickListener(this);

    
    try{b0.setTextColor(cc7);}catch(Exception e ){}
    try{b1.setTextColor(cc7);}catch(Exception e ){}
    try{b2.setTextColor(cc7);}catch(Exception e ){}
    try{b3.setTextColor(cc7);}catch(Exception e ){}
    try{b4.setTextColor(cc7);}catch(Exception e ){}
    try{b5.setTextColor(cc7);}catch(Exception e ){}
    try{b6.setTextColor(cc7);}catch(Exception e ){}
    try{b7.setTextColor(cc7);}catch(Exception e ){}
    try{b8.setTextColor(cc7);}catch(Exception e ){}
    try{b9.setTextColor(cc7);}catch(Exception e ){}

    frm = (FrameLayout)findViewById(R.id.pin_frm);
                        i1 = ((ImageView)findViewById(R.id.img_1));
                        i2 = ((ImageView)findViewById(R.id.img_2));
                        i3 = ((ImageView)findViewById(R.id.img_3));
                        i4 = ((ImageView)findViewById(R.id.img_4));
                        h.add(i1);
                        h.add(i2);
                        h.add(i3);
                        h.add(i4);


                        btnok = (Button)findViewById(R.id.swipe_image_lock_set_btnok_cnf);
                        btncnl = (Button)findViewById(R.id.swipe_image_lock_set_btncnl_cnf);
                        viewPager = (ViewPager)findViewById(R.id.myviewpager_set_cnf);
                        viewPager1 = (ViewPager)findViewById(R.id.myviewpager_2_set_cnf);
                        viewPager2 = (ViewPager)findViewById(R.id.myviewpager_3_set_cnf);
                        viewPager4 = (ViewPager)findViewById(R.id.myviewpager_set_2_cnf);
                        viewPager5 = (ViewPager)findViewById(R.id.myviewpager_2_set_2_cnf);
                        viewPager6 = (ViewPager)findViewById(R.id.myviewpager_3_set_2_cnf);
                        viewPager7 = (ViewPager)findViewById(R.id.myviewpager_set_3_cnf);
                        viewPager8 = (ViewPager)findViewById(R.id.myviewpager_2_set_3_cnf);
                        viewPager9 = (ViewPager)findViewById(R.id.myviewpager_3_set_3_cnf);
                        
                        
                        myPagerAdapter = new MyPagerAdapter();
                        myPagerAdapter2 = new MyPagerAdapter2();
                        myPagerAdapter3 = new MyPagerAdapter3();
                        
                        myPagerAdapter4 = new MyPagerAdapter4();
                        myPagerAdapter5 = new MyPagerAdapter5();
                        myPagerAdapter6 = new MyPagerAdapter6();
                        myPagerAdapter7 = new MyPagerAdapter7();
                        myPagerAdapter8 = new MyPagerAdapter8();
                        myPagerAdapter9 = new MyPagerAdapter9();
                        
                        
                        viewPager.setAdapter(myPagerAdapter);
                        viewPager1.setAdapter(myPagerAdapter2);
                        viewPager2.setAdapter(myPagerAdapter3);
                        viewPager4.setAdapter(myPagerAdapter4);
                        viewPager5.setAdapter(myPagerAdapter5);
                        viewPager6.setAdapter(myPagerAdapter6);
                        viewPager7.setAdapter(myPagerAdapter7);
                        viewPager8.setAdapter(myPagerAdapter8);
                        viewPager9.setAdapter(myPagerAdapter9);

     	 	if(MainActivity.height != 0) width = MainActivity.width;
     	 	if(MainActivity.width != 0) height = MainActivity.height;
     	 	
    Toast.makeText(getApplicationContext(), "width : "+width + "height +"+height, Toast.LENGTH_SHORT).show(); 	 	
     	 	//window.setLayout(width,height);
	 //window.setLayout(metrics.widthPixels, metrics.heightPixels);
	
	 Log.i("width : height", width+" / "+height);
    
    if(bool == true){    	
    		//layoutparams.flags = 0x40000000 | layoutparams.flags; //Flag_layout_attached_in_decor
    }
	status_key = MainActivity.status_key;
	
    status_bar_view = findViewById(R.id.status_bar_view);
	
    if(status_key == 0){
    	status_bar_view.setVisibility(View.VISIBLE);
    	
    	//this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    	 this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	 manager.removeView(view);

    	
    }else{

    	status_bar_view.setVisibility(View.GONE);
   	 
   	//this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
   	//this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

    	}
    
    

    battery_img = ((ImageView) findViewById(R.id.battery_img));      
    signal_img = ((ImageView)findViewById(R.id.signal_img));
    
    	btl = ((TextView)findViewById(R.id.battery_tv));    

    	setdivalue();
    
    if(color_adapter.p1 != 0){sharedPreferences.edit().putInt("c1", color_adapter.p1).commit();}
    else{sharedPreferences.edit().putInt("c1", -16711684).commit();}
    if(color_adapter.p2 != 0){sharedPreferences.edit().putInt("c2", color_adapter.p2).commit();}
    else{sharedPreferences.edit().putInt("c2", -16711684).commit();}
    if(color_adapter.p3 != 0){sharedPreferences.edit().putInt("c3", color_adapter.p3).commit();}
    else{sharedPreferences.edit().putInt("c3", -16711684).commit();}
    if(color_adapter.p4 != 0){sharedPreferences.edit().putInt("c4", color_adapter.p4).commit();}
    else{sharedPreferences.edit().putInt("c4", -16711684).commit();}
    if(color_adapter.p5 != 0){sharedPreferences.edit().putInt("c5", color_adapter.p5).commit();}
    else{sharedPreferences.edit().putInt("c5", -16711684).commit();}
    if(color_adapter.p6 != 0){sharedPreferences.edit().putInt("c6", color_adapter.p6).commit();}
    else{sharedPreferences.edit().putInt("c6", -16711684).commit();}
    if(color_adapter.p7 != 0){sharedPreferences.edit().putInt("c7", color_adapter.p7).commit();}
    else{sharedPreferences.edit().putInt("c7", -16711684).commit();}
    if(color_adapter.p8 != 0){sharedPreferences.edit().putInt("c8", color_adapter.p8).commit();}
    else{sharedPreferences.edit().putInt("c8", -16711684).commit();}
    
    tts = getResources().getDimensionPixelSize(R.dimen.time_text_size);
    dts = getResources().getDimensionPixelSize(R.dimen.date_text_size);
    sts = getResources().getDimensionPixelSize(R.dimen.swipe_text_size);
    if(Text_size_dialog.p1 != 0){sharedPreferences.edit().putInt("pp1", Text_size_dialog.p1).commit();}
    else{sharedPreferences.edit().putInt("pp1", tts).commit();}
    if(Text_size_dialog.p2 != 0){sharedPreferences.edit().putInt("pp2", Text_size_dialog.p2).commit();}
    else{sharedPreferences.edit().putInt("pp2", dts).commit();}
    if(Text_size_dialog.p3 != 0){sharedPreferences.edit().putInt("pp3", Text_size_dialog.p3).commit();}
    else{sharedPreferences.edit().putInt("pp3", sts).commit();}
    
    c1 = sharedPreferences.getInt("c1", 0); c2 = sharedPreferences.getInt("c2", 0);
    c3 = sharedPreferences.getInt("c3", 0); c4 = sharedPreferences.getInt("c4", 0);
    c5 = sharedPreferences.getInt("c5", 0); c6 = sharedPreferences.getInt("c6", 0);
    c7 = sharedPreferences.getInt("c7", 0); c8 = sharedPreferences.getInt("c8", 0);
    Toast.makeText(getApplicationContext(), "c1 : "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6+" / "+c7+" / "+c8, Toast.LENGTH_SHORT).show();
    
    size1 = sharedPreferences.getInt("pp1", 0);size2 = sharedPreferences.getInt("pp2", 0);
    size3 = sharedPreferences.getInt("pp3", 0);
    Toast.makeText(getApplicationContext(), "size : "+size1+" / "+size2+" / "+size3, Toast.LENGTH_SHORT).show();
    if(settings.unlock_Text != null){
    	sharedPreferences.edit().putString("swipe_txt", settings.unlock_Text).commit();
    }else{
    	sharedPreferences.edit().putString("swipe_txt", "Swipe to unlock").commit();
    }
    	unlock_text = sharedPreferences.getString("swipe_txt", "");
    	//  font face
    if(font_typeface_chooser.p1 != null){sharedPreferences.edit().putString("t1", font_typeface_chooser.p1).commit();}
    else{sharedPreferences.edit().putString("t1", "fonts/f4.ttf").commit();}
    if(font_typeface_chooser.p2 != null){sharedPreferences.edit().putString("t2", font_typeface_chooser.p2).commit();}
    else{sharedPreferences.edit().putString("t2", "fonts/f4.ttf").commit();}
    if(font_typeface_chooser.p3 != null){sharedPreferences.edit().putString("t3", font_typeface_chooser.p3).commit();}
    else{sharedPreferences.edit().putString("t3", "fonts/f4.ttf").commit();}
    
    	 t1=Typeface.createFromAsset(this.getAssets(),sharedPreferences.getString("t1", ""));
    	 t2=Typeface.createFromAsset(this.getAssets(),sharedPreferences.getString("t2", ""));
    	 t3=Typeface.createFromAsset(this.getAssets(),sharedPreferences.getString("t3", ""));
    	
    	TextView tv = (TextView)findViewById(R.id.swipe_text);
    	tv.setText("swipe another");
    	tv.setTypeface(t3);    	
    	tv.setTextColor(c6); 
    	tv.setTextSize(size3);
    	
    	if(unlock_text != null){tv.setText(unlock_text);}else{tv.setText("Swipe to unlock");}
    	
    if(settings.date_format != 0){
    	sharedPreferences.edit().putInt("date_form", settings.date_format).commit();
    }else{
    	sharedPreferences.edit().putInt("date_form", 1).commit();
    }
    date_format = sharedPreferences.getInt("date_form", 0);
    
   
    

    a1 = sharedPreferences.getInt("iv1", 0);a2 = sharedPreferences.getInt("iv2", 0);
    a3 = sharedPreferences.getInt("iv3", 0);a4 = sharedPreferences.getInt("iv4", 0);
    a5 = sharedPreferences.getInt("iv5", 0);a6 = sharedPreferences.getInt("iv6", 0);
    a7 = sharedPreferences.getInt("iv7", 0);a8 = sharedPreferences.getInt("iv8", 0);

    Toast.makeText(getApplicationContext(), "posi : "+a1+" / "+a2+" / "+a3+" / "+a4+" / "
    +" / "+a5+" / "+a6+" / "+a7+" / "+a8, Toast.LENGTH_SHORT).show();
    
    if(a5 == 1){battery_img.setVisibility(View.VISIBLE);}else{battery_img.setVisibility(View.GONE);}
    if(a7 == 1){signal_img.setVisibility(View.VISIBLE);}else{signal_img.setVisibility(View.GONE);}
    if(a8 == 0){tv.setVisibility(View.VISIBLE);}else{tv.setVisibility(View.GONE);}

    
    	//getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

  //  detector = new SimpleGestureFilter(this,this);
    sm = (SensorManager) getSystemService(SENSOR_SERVICE);
	lastTime = System.currentTimeMillis();  
    mSensorManager = ((SensorManager)getSystemService("sensor"));
    mAccelerometer = mSensorManager.getDefaultSensor(1);
    mShakeDetector = new shakedetector();
    mShakeDetector.setOnShakeListener(new shakedetector.OnShakeListener()
    {
  
	public void onShake(int paramAnonymousInt)
      {
        finish();
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
      }
    });
    
    try
    {

    	time_id = (TextView) findViewById(R.id.time_id);
        time_ampm = (TextView) findViewById(R.id.time_AMPM);
        date_id = (TextView) findViewById(R.id.date_id);
        registerBatteryLevelReceiver();
        
      Date today = new Date();
      
      if (Calendar.getInstance().get(9) == 0) {}
      for (String str1 = "PM";; str1 = "AM")
      {
    	  SimpleDateFormat time1 = null;
        //SimpleDateFormat time1 = new SimpleDateFormat("HH:mm ");
        SimpleDateFormat date1 = new SimpleDateFormat("E, MMM  dd");
        Calendar clnd = Calendar.getInstance();
        
        if((date_format == 1)){ time1 = new SimpleDateFormat("hh:mm "); str2 = time1.format(today); 
    	Toast.makeText(getApplicationContext(), "time format : "+date_format, Toast.LENGTH_SHORT).show();
    	}
        else{time1 = new SimpleDateFormat("HH:mm "); str2 = time1.format(clnd.getTime());}        
        String str3 = date1.format(clnd.getTime());
        time_id.setText(str2); time_id.setTextColor(c3); time_id.setTextSize(size1); time_id.setTypeface(t1);
        //if(a1 == 1){time_id.setVisibility(View.VISIBLE); time_ampm.setVisibility(View.VISIBLE);}else{time_id.setVisibility(View.GONE); time_ampm.setVisibility(View.GONE);};
        time_ampm.setText(str1); time_ampm.setTextSize(16); time_ampm.setTextColor(c3); time_ampm.setTypeface(t3);

        date_id.setText(str3); date_id.setTextColor(c4); date_id.setTextSize(size2); date_id.setTypeface(t2);
        //if(a2 == 1){date_id.setVisibility(View.VISIBLE);}else{date_id.setVisibility(View.GONE); };
        
        displayTelephonyInfo();
        sm.registerListener(mShakeDetector, mAccelerometer, 0);        
       // return;
      }
      
    }
    catch (Exception localException) {}


    if(ab1 != null && ab1.length() > 0){
		  arr = ab1.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil1.add(imgFile);	 			
		  		}
		  }
	}else{
		ab1 = null;
	}
	if(ab2 != null && ab2.length() > 0){
		  arr = ab2.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil2.add(imgFile);	 			
		  		}
		  }
	}else{
		ab2 = null;
	}
	if(ab3 != null && ab3.length() > 0){
		  arr = ab3.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil3.add(imgFile);	 			
		  		}
		  }
	}else{
		ab3 = null;
	}
	if(ab4 != null && ab4.length() > 0){
		  arr = ab4.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil4.add(imgFile);	 			
		  		}
		  }
	}else{
		ab4 = null;
	}
	if(ab5 != null && ab5.length() > 0){
		  arr = ab5.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				  //Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil5.add(imgFile);	 			
		  		}
		  }
	}else{
		ab6 = null;
	}
	if(ab6 != null && ab6.length() > 0){
		  arr = ab6.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil6.add(imgFile);
		 			
		  		}
		  }
	}else{
		ab7 = null;
	}
	if(ab7 != null && ab7.length() > 0){
		  arr = ab7.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil7.add(imgFile);	 			
		  		}
		  }
	}else{
		ab7 = null;
	}
	if(ab8 != null && ab8.length() > 0){
		  arr = ab8.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil8.add(imgFile);	 			
		  		}
		  }
	}else{
		ab8 = null;
	}
	if(ab9 != null && ab9.length() > 0){
		  arr = ab9.split(",");  

		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil.add(imgFile);	 			
		  		}
		  }
	}else{
		ab9 = null;
	}
	 //notification = RingtoneManager.getRingtone(getApplicationContext(), ring);
	 //Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
	 //Toast.makeText(getApplicationContext(), "r is : "+notification, Toast.LENGTH_SHORT).show();
	 
//    notification(context1);
  }

public void notification(Context context){
	nManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);    
	   NotificationCompat.Builder notifBuilder = 
	           new NotificationCompat.Builder(context);
	   notifBuilder.setSound(ring);
	   notification = notifBuilder.build();
}
  
  private BroadcastReceiver battery_receiver = new BroadcastReceiver()
  {
    public void onReceive(Context context, Intent intent)
    {
    	boolean isPresent = intent.getBooleanExtra("present", false);
      int scale = intent.getIntExtra("scale", -1);
      int status = intent.getIntExtra("status", 0);
      int rawlevel= intent.getIntExtra("level", -1);
      Log.i("BatteryLevel", intent.getExtras().toString());
      int level = 0;
		Bundle bundle = intent.getExtras();
		Log.i("BatteryLevel", bundle.toString());
		if (isPresent) {
			if (rawlevel >= 0 && scale > 0) {
				level = (rawlevel * 100) / scale;
				 batterperc = "" + level + "%";
				 setBatteryLevelText(batterperc);
				 
			}
     }
      while (rawlevel < 10 || rawlevel == 9 )
      {
        battery_img.setImageResource(R.drawable.btr10);
        return;
      //setBatteryLevelText("Battery not present!!!");
        
      }
      if (rawlevel < 20 || rawlevel == 19)
      {
        battery_img.setImageResource(R.drawable.btr20);
        return;
      }
      if (rawlevel < 30 || rawlevel == 29)
      {
        battery_img.setImageResource(R.drawable.btr30);
        return;
      }
      if (rawlevel < 40 || rawlevel == 39)
      {
        battery_img.setImageResource(R.drawable.btr40);
        return;
      }
      if (rawlevel < 50 || rawlevel == 49)
      {
        battery_img.setImageResource(R.drawable.btr50);
        return;
      }
      if (rawlevel < 60 || rawlevel == 59)
      {
        battery_img.setImageResource(R.drawable.btr60);
        return;
      }
      if (rawlevel < 70 || rawlevel == 69)
      {
        battery_img.setImageResource(R.drawable.btr70);
        return;
      }
      if (rawlevel < 80 || rawlevel == 79)
      {
        battery_img.setImageResource(R.drawable.btr80);
        return;
      }
      if (rawlevel < 90 || rawlevel == 89)
      {
        battery_img.setImageResource(R.drawable.btr90);
        return;
      }
      battery_img.setImageResource(R.drawable.btrfull);
    }
  };
  
  
  private void displayTelephonyInfo()
  {
    TelephonyManager tm = (TelephonyManager)getSystemService("phone");
    String str = tm.getNetworkOperatorName();
    ((TextView)findViewById(R.id.operator_tv)).setText(str);
    ((TextView)findViewById(R.id.operator_tv)).setTextColor(c1);
    if(a6 == 1){((TextView)findViewById(R.id.operator_tv)).setVisibility(View.VISIBLE);}
    else{((TextView)findViewById(R.id.operator_tv)).setVisibility(View.GONE);}
  }
  
  private String getSignalLevelString(int level)
  {
    if (level > 80)
    {
      signal_img.setImageResource(R.drawable.signalfull);
      
    }
    if (level > 60)
    {
      signal_img.setImageResource(R.drawable.signal80);
      
    }
    if (level > 40)
    {
      signal_img.setImageResource(R.drawable.signal60);      
    }
    if (level > 25)
    {
      signal_img.setImageResource(R.drawable.signal40);    
    }
    
    if (level < 10)
    {
      signal_img.setImageResource(R.drawable.signal25);    
    }
	return null;
    
  }
  
  private String getStatusString(int status)
  {
		String statusString = "Unknown";
		switch (status) {
		case BatteryManager.BATTERY_STATUS_CHARGING:
			statusString = "Charging";
			break;
		case BatteryManager.BATTERY_STATUS_DISCHARGING:
			statusString = "Discharging";
			break;
		case BatteryManager.BATTERY_STATUS_FULL:
			statusString = "Full";
			break;
		case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
			statusString = "Not Charging";
			break;
		}

		return statusString;
  }
  
  
  private void setBatteryLevelText(String str)
  {
	  	btl.setText(str);btl.setTextColor(c2);
	  	
  }
  
  private void setSignalLevel(int id, int infoid, int level)
  {
	  int progress = (int) ((((float)level)/31.0) * 100);
      
      String signalLevelString = getSignalLevelString(progress);      
      //set the status 
      ((ProgressBar)findViewById(id)).setProgress(progress);      
      //set the status string
      ((TextView)findViewById(infoid)).setText(signalLevelString);      
      
      Log.i("signalLevel ","" + progress);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
	  if (!super.dispatchKeyEvent(paramKeyEvent))
	    {
	      if (paramKeyEvent.getAction() == 0) {}
	      boolean bool;
	      switch (paramKeyEvent.getKeyCode())
	      {
	      default: 
	        bool = false;
	      }    
	      
	    }
	return bool;
	    
  }
@Override
public void onClick(View view)
{
  
view.getId();
if (n < lb)
{
		title.setText("enter your pin number");
		
		sb1.append(((Button)view).getText());
		((ImageView)h.get(i)).setBackgroundResource(R.drawable.pin_image_round);    		
		//s1 = new String(sb1.toString());
		i = (1 + i);
}        
n = (1 + n);
if(sb1.toString().length() > 0 ){
	btndelete.setVisibility(View.VISIBLE);
}
if(sb1.toString().length() == lb){
	btndelete.setVisibility(View.GONE);

if(getstr.toString().equals(sb1.toString())){

  finish();
  if(rt != null ){
	  if(rt.length() >0){
	  
		  mediaPlayer.start();
		  vibrator.vibrate(pattern, -1);
	  }
  }
  switch(unlock_animation.ua_pos){

  	case 0:
  		finish();
  		break;
  	case 1:
  		finish();
  		overridePendingTransition(0, R.anim.rotate);
        vibrator.vibrate(pattern, -1);
         
  		break;
  	case 2:
  		finish();
  		overridePendingTransition(0, R.anim.fade_out);
  		vibrator.vibrate(pattern, -1);
  		break;
  	case 3:
  		finish();
  		overridePendingTransition(0, R.anim.zoom_in);
  		vibrator.vibrate(pattern, -1);
  		break;
  	case 4:
  		finish();
  		overridePendingTransition(0, R.anim.bounce);
  		vibrator.vibrate(pattern, -1);
  		break;
  	case 5:
  		finish();
  		overridePendingTransition(0, R.anim.blink);
  		vibrator.vibrate(pattern, -1);
  		break;	  	
  		
  }
	
  if(camera_val == 1){
		Intent i = new Intent("android.media.action.STILL_IMAGE_CAMERA");
		startActivity(i);
	}	
  
}else{
  title.setText("Pin not matched");
  sb1.setLength(0);
	sb1.delete(0, n);
	
	n = 0;
	do{
			((ImageView)h.get(-1 + i)).setBackgroundResource(R.drawable.pin_light);
			
			i = (i - 1);
	}while(i != 0);
}

}

}


public void c1string(){
	
  if(sb1.toString().length() > 0){
		
		sb1.setLength(sb1.length() - 1);
		sb1.delete(n - 1, n );
		btndelete.setVisibility(View.VISIBLE);
		
	}else{
		String ss = " 0 string";
		//Toast.makeText(getApplicationContext(), ss, Toast.LENGTH_SHORT).show();
	}
	if(i > 0){
	
	((ImageView)h.get(-1 + i)).setBackgroundResource(R.drawable.pin_light);
	
		i = (-1 + i);				
		n = (-1 + n);
	
	}
	if(sb1.toString().length() != lb){			
		
		 b0.setEnabled(true); b1.setEnabled(true); b2.setEnabled(true);b3.setEnabled(true);
            b4.setEnabled(true);b5.setEnabled(true);b6.setEnabled(true);b7.setEnabled(true);b8.setEnabled(true);
            b9.setEnabled(true); 
	}
	if(sb1.toString().length() == 0 || sb1.toString().length() == lb){
		btndelete.setVisibility(View.GONE);
	}
	
  
}

  @Override
  public void onBackPressed() {}
  

  public void onDestroy()
  {
	  //view = new customViewGroup(this);
	  if(status_key == 0){
		  
	  }else{
		  manager.removeView(view);  
	  }
	  //r();
	  //stopService(new Intent(this,MyService.class));
    unregisterReceiver(battery_receiver);   
    super.onDestroy();
    
  }
  
  public boolean onHomePressed() {
	
	  return true;
  }
  
  
  
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {

  if (keyCode == KeyEvent.KEYCODE_BACK) {
  //Do Code Here
  // If want to block just return false
  return false;
  }
  if (keyCode == KeyEvent.KEYCODE_MENU) {
  //Do Code Here
  // If want to block just return false
  return false;
  }
  if (keyCode == KeyEvent.KEYCODE_HOME) {
  //Do Code Here
  // If want to block just return false
  return false;
  }
  if (keyCode == KeyEvent.KEYCODE_SEARCH) {
  //Do Code Here
  // If want to block just return false
  return false;
  }
  if (keyCode == KeyEvent.KEYCODE_SETTINGS) {
  //Do Code Here
  // If want to block just return false
  return false;
  }

  return super.onKeyDown(keyCode, event);
  }
  
    
  private void registerBatteryLevelReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    registerReceiver(battery_receiver, localIntentFilter);
  }

@Override
public boolean onTouchEvent(MotionEvent event) {
  if (gestureDetector.onTouchEvent(event)) {
	//  getWindow().getDecorView().setSystemUiVisibility(8);
    return gestureDetector.onTouchEvent(event);
    
  }
  return super.onTouchEvent(event);
}



//Animation leftin = AnimationUtils.loadAnimation(this,R.anim.left_in);
//Animation leftin = AnimationUtils.loadAnimation(this,R.anim.left_in);
	
private void onLeftSwipe() {
	animp = 1;
	if(v == 2){
		rrl.startAnimation(leftout);
		rrl.setVisibility(View.GONE);	
		rl.startAnimation(leftin);
		rl.setVisibility(View.VISIBLE);
		rl.setOnTouchListener(gestureListener);
	}else
	if(v == 3){
		rrl.startAnimation(leftout);
		rrl.setVisibility(View.GONE);	
		rl2.startAnimation(leftin);
		rl2.setVisibility(View.VISIBLE);
		rl2.setOnTouchListener(gestureListener);
	}else{
		
		finish();
		  
		//overridePendingTransition(R.anim.left_in, R.anim.left_out);
		  switch(unlock_animation.ua_pos){

		  	case 0:
		  		finish();
		  		break;
		  	case 1:
		  		finish();
		  		overridePendingTransition(0, R.anim.rotate);
		        vibrator.vibrate(pattern, -1);
		         
		  		break;
		  	case 2:
		  		finish();
		  		overridePendingTransition(0, R.anim.fade_out);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 3:
		  		finish();
		  		overridePendingTransition(0, R.anim.zoom_in);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 4:
		  		finish();
		  		overridePendingTransition(0, R.anim.bounce);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 5:
		  		finish();
		  		overridePendingTransition(0, R.anim.blink);
		  		vibrator.vibrate(pattern, -1);
		  		break;	  	
		  		
		  }
		  if(camera_val == 1){
				Intent i = new Intent("android.media.action.CAMERA");
				startActivity(i);
			}
	}
}

private void onRightSwipe() {
	animp = 2;
	if(v == 2){
		rrl.startAnimation(rightin);
		rrl.setVisibility(View.GONE);	
		rl.startAnimation(rightout);
		rl.setVisibility(View.VISIBLE);
		rl.setOnTouchListener(gestureListener);
	}else
	if(v == 3){
		rrl.startAnimation(rightin);
		rrl.setVisibility(View.GONE);	
		rl2.startAnimation(rightout);
		rl2.setVisibility(View.VISIBLE);
		rl2.setOnTouchListener(gestureListener);
	}else{
		finish();
		//overridePendingTransition(R.anim.right_out, R.anim.right_in);
		  switch(unlock_animation.ua_pos){

		  	case 0:
		  		finish();
		  		break;
		  	case 1:
		  		finish();
		  		overridePendingTransition(0, R.anim.rotate);
		        vibrator.vibrate(pattern, -1);
		         
		  		break;
		  	case 2:
		  		finish();
		  		overridePendingTransition(0, R.anim.fade_out);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 3:
		  		finish();
		  		overridePendingTransition(0, R.anim.zoom_in);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 4:
		  		finish();
		  		overridePendingTransition(0, R.anim.bounce);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 5:
		  		finish();
		  		overridePendingTransition(0, R.anim.blink);
		  		vibrator.vibrate(pattern, -1);
		  		break;	  	
		  		
		  }
		  if(camera_val == 1){
				Intent i = new Intent("android.media.action.STILL_IMAGE_CAMERA");
				startActivity(i);
			}
	}

}
private void onUpSwipe() {
	animp = 3;
	if(v == 2){
		rrl.startAnimation(topout);
		rrl.setVisibility(View.GONE);	
		rl.startAnimation(topin);
		rl.setVisibility(View.VISIBLE);
		rl.setOnTouchListener(gestureListener);
	}else
	if(v == 3){
		rrl.startAnimation(topout);
		rrl.setVisibility(View.GONE);	
		rl2.startAnimation(topin);
		rl2.setVisibility(View.VISIBLE);
		rl2.setOnTouchListener(gestureListener);
	}else{
		finish();
		//overridePendingTransition(R.anim.top_in, R.anim.top_out);
		  switch(unlock_animation.ua_pos){

		  	case 0:
		  		finish();
		  		break;
		  	case 1:
		  		finish();
		  		overridePendingTransition(0, R.anim.rotate);
		        vibrator.vibrate(pattern, -1);
		         
		  		break;
		  	case 2:
		  		finish();
		  		overridePendingTransition(0, R.anim.fade_out);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 3:
		  		finish();
		  		overridePendingTransition(0, R.anim.zoom_in);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 4:
		  		finish();
		  		overridePendingTransition(0, R.anim.bounce);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 5:
		  		finish();
		  		overridePendingTransition(0, R.anim.blink);
		  		vibrator.vibrate(pattern, -1);
		  		break;	  	
		  		
		  }			
		  if(camera_val == 1){
				Intent i = new Intent("android.media.action.STILL_IMAGE_CAMERA");
				i.setFlags(270532608);
				startActivity(i);
			}
	}
}
private void onDownSwipe() {
	animp = 4;
	if(v == 2){
		rrl.startAnimation(bottomin);
		rrl.setVisibility(View.GONE);	
		rl.startAnimation(bottomout);
		rl.setVisibility(View.VISIBLE);
		rl.setOnTouchListener(gestureListener);
	}else
	if(v == 3){
		rrl.startAnimation(bottomin);
		rrl.setVisibility(View.GONE);	
		rl2.startAnimation(bottomout);
		rl2.setVisibility(View.VISIBLE);
		rl2.setOnTouchListener(gestureListener);
	}else{
		finish();
		//overridePendingTransition(R.anim.bottom_out, R.anim.bottom_in);
		  switch(unlock_animation.ua_pos){

		  	case 0:
		  		finish();
		  		break;
		  	case 1:
		  		finish();
		  		overridePendingTransition(0, R.anim.rotate);
		        vibrator.vibrate(pattern, -1);
		         
		  		break;
		  	case 2:
		  		finish();
		  		overridePendingTransition(0, R.anim.fade_out);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 3:
		  		finish();
		  		overridePendingTransition(0, R.anim.zoom_in);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 4:
		  		finish();
		  		overridePendingTransition(0, R.anim.bounce);
		  		vibrator.vibrate(pattern, -1);
		  		break;
		  	case 5:
		  		finish();
		  		overridePendingTransition(0, R.anim.blink);
		  		vibrator.vibrate(pattern, -1);
		  		break;	  	
		  		
		  }
		  if(camera_val == 1){
				Intent i = new Intent("android.media.action.STILL_IMAGE_CAMERA");
				startActivity(i);
			}
	}
	    		
}
// Private class for gestures
private class SwipeGestureDetector extends SimpleOnGestureListener {
  // Swipe properties, you can change it to make the swipe 
  // longer or shorter and speed
	
  @Override
  public boolean onFling(MotionEvent e1, MotionEvent e2,
                       float velocityX, float velocityY) {
    try {
      float diffAbs = Math.abs(e1.getY() - e2.getY());
      float diff = e1.getX() - e2.getX();
      float diffy = e1.getY() - e2.getY();
      
      //if (diffAbs > SWIPE_MAX_OFF_PATH)
      // return false;

      if(diffy > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY){
    	  
    	  onUpSwipe();
      }else if(-diffy > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY){
    	  onDownSwipe();
      }
      // Left swipe
      else if (diff > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
         onLeftSwipe();
         

      // Right swipe
      } else if (-diff > SWIPE_MIN_DISTANCE
      && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
        onRightSwipe();
        
      }
    } catch (Exception e) {
      Log.e("YourActivity", "Error on gestures");
    }
    return true;
  }
  public boolean onDown(){
	  return true;
  }
  
}

@Override
protected void onPause()
{
	//getWindow().getDecorView().setSystemUiVisibility(8);
  super.onPause();
  sm.unregisterListener(mShakeDetector, mAccelerometer);
  //Log.d("overheardword", "onResume Invoked");
  
}

@Override
public void onStart(){
	
	super.onStart();
}
@Override
protected void onResume()
{
	hideNavBar();
	super.onResume();
  Log.d("overheardword", "onResume Invoked");
  sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
  gestureDetector = new GestureDetector(this,new SwipeGestureDetector()); 
}
@Override
public boolean onTouch(View v, android.view.MotionEvent event) {
	// TODO Auto-generated method stub
	
	return gestureDetector.onTouchEvent(event); 
	
}

@SuppressLint("ClickableViewAccessibility")
private class MyPagerAdapter extends PagerAdapter{
	 
	 
  int NumberOfPages = 9;
  
  int[] res = {
	R.drawable.wallpaper_1,
	R.drawable.abc,
   //android.R.drawable.ic_dialog_alert,
   //android.R.drawable.ic_menu_camera,
   android.R.drawable.ic_menu_compass,
   android.R.drawable.ic_menu_directions,
   android.R.drawable.ic_menu_gallery,android.R.drawable.ic_menu_gallery,android.R.drawable.ic_menu_gallery,
   android.R.drawable.ic_menu_gallery,android.R.drawable.ic_menu_gallery};
  int[] backgroundcolor = { 
   0xFF101010,
   0xFF202020,
   0xFF303030,
   0xFF404040,
   0xFF505050,0xFF505050,0xFF505050,0xFF505050,0xFF505050};
  

  //private PageListener pageListener;

  @Override
  public int getCount() {
   return NumberOfPages;
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
   return view == object;
   
  }

  
  
public Object instantiateItem(ViewGroup container, int position) {
   
	PageListener pageListener = new PageListener();
	viewPager.setOnPageChangeListener(pageListener);
	
	  //Toast.makeText(getApplicationContext(),"this is p : " + p, Toast.LENGTH_SHORT).show();	 
      /*TextView textView = new TextView(swipe_image_lock_set.this);
      textView.setTextColor(Color.WHITE);
      textView.setTextSize(30);
      textView.setTypeface(Typeface.DEFAULT_BOLD);
      textView.setText(String.valueOf(position));
      */
//container.setRotation(-90f);
      ImageView imageView = new ImageView(shake_or_swipe.this);
      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
      //imageView.setImageResource(res[position]);

      if(ab9 != null && ab9.length() > 0 ){
    	  
    	  for(int i = 0; i < Fil.size();i++){
    		  if(i == position){
    			  Picasso.with(getBaseContext()).load(Fil.get(i)).resize(size,size).into(imageView);
    		  		}
    		 	}
    	  }else{
    		  imageView.setImageResource(res[position]);
    	  }
 
      
      imageParams = new LayoutParams(size,size);
      imageView.setLayoutParams(imageParams);
      
      LinearLayout layout = new LinearLayout(shake_or_swipe.this);
      layout.setOrientation(LinearLayout.VERTICAL);
      LayoutParams layoutParams = new LayoutParams(
        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
      layout.setBackgroundColor(backgroundcolor[position]);
      layout.setLayoutParams(layoutParams);
      //layout.addView(textView);
      layout.addView(imageView);

      final int page = position;
    
      container.addView(layout);
      return layout;
  }
private class PageListener extends SimpleOnPageChangeListener{
    private final String TAG = null;

	public void onPageSelected(int position) {
		
        Log.i(TAG, "page selected " + position);
           currentPage = position;
           d1 = currentPage; 
           //Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
}
}
  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
   container.removeView((LinearLayout)object);
  }

  
 }
 @SuppressLint("ClickableViewAccessibility")
 private class MyPagerAdapter2 extends PagerAdapter{
	  
	  int NumberOfPagess = 9;
	  
	  int[] ress = { 
	   android.R.drawable.alert_dark_frame,
	   android.R.drawable.alert_light_frame,
	   android.R.drawable.arrow_down_float,
	   android.R.drawable.arrow_up_float,
	   android.R.drawable.bottom_bar,android.R.drawable.bottom_bar,android.R.drawable.bottom_bar,
	   android.R.drawable.bottom_bar,android.R.drawable.bottom_bar};
	  int[] backgroundcolors = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050,0xFF505050,0xFF505050,0xFF505050,0xFF505050};
	  private PageListener pageListener;
	  @Override
	  public int getCount() {
	   return NumberOfPagess;
	  }

	  @Override
	  public boolean isViewFromObject(View view2, Object object) {
	   return view2 == object;
	   
	  }

	  
	  public Object instantiateItem(ViewGroup container, int position) {
	   
		  PageListener pageListener = new PageListener();
		  viewPager1.setOnPageChangeListener(pageListener);
			
/*	      TextView textView = new TextView(swipe_image_lock_set.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position)); */
	      
	//container.setRotation(-90f);
	      ImageView imageView = new ImageView(shake_or_swipe.this);
	  //    imageView.setImageResource(ress[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      
	      int j;
	      if(ab1 != null && ab1.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil1.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil1.get(i)).resize(size,size).into(imageView);
	    		  		}
	    		 	}
	    	  }else{
	    		  imageView.setImageResource(ress[position]);
	    	  }
	      
	      LayoutParams imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(shake_or_swipe.this);
	      layout.setOrientation(LinearLayout.HORIZONTAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolors[position]);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);
	    //  String s = "abc";
	     // s = s.substring(s.length() - 1);
	      //Toast.makeText(getApplicationContext(),"this is s : " + s, Toast.LENGTH_SHORT).show();
	      final int page = position;
	    
	      
	      container.addView(layout);
	      return layout;
	  }
	  private class PageListener extends SimpleOnPageChangeListener{
		    private final String TAG = null;

			public void onPageSelected(int position) {
		        Log.i(TAG, "page selected " + position);
		           currentPage = position;
		           d2 = currentPage;
		           
		     //      Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
		}
		}
	  @Override
	  public void destroyItem(ViewGroup container, int position, Object object) {
	   container.removeView((LinearLayout)object);
	  }

	 }

 private class MyPagerAdapter3 extends PagerAdapter{
	  
	  int NumberOfPagesa = 9;
	  
	  
	  int[] resa = { 
	   android.R.drawable.toast_frame,
	   android.R.drawable.sym_call_incoming,
	   android.R.drawable.btn_dialog,
	   android.R.drawable.sym_call_outgoing,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on};
	  
	  int[] backgroundcolora = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050,0xFF505050,0xFF505050,0xFF505050,0xFF505050};
	  private PageListener pageListener;
	  
	  
	  
	  @Override
	  public int getCount() {
	   return NumberOfPagesa;
	  }

	  @Override
	  public boolean isViewFromObject(View view3, Object object) {
	   return view3 == object;
	   
	  }

	  
	 
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager2.setOnPageChangeListener(pageListener);
/*		  
	      TextView textView = new TextView(swipe_image_lock_set.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position));
	      */
	      
	//container.setRotation(-90f);
	      ImageView imageView = new ImageView(shake_or_swipe.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    
	      if(ab2 != null && ab2.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil2.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil2.get(i)).resize(size,size).into(imageView);
	    		  		}
	    		 	}
	    	  }else{
	    		  imageView.setImageResource(resa[position]);
	    	  }

	      
	 	LayoutParams imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(shake_or_swipe.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);

	      
	      	      
	      final int page = position;
	     
	      
	      container2.addView(layout);
	      return layout;
	  }

	  private class PageListener extends SimpleOnPageChangeListener{
		    private final String TAG = null;

			public void onPageSelected(int position) {
		        Log.i(TAG, "page selected " + position);
		           currentPage = position;
		           d3 = currentPage;
		           //Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
		}
		}
	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }

 private class MyPagerAdapter4 extends PagerAdapter{
	  
	  int NumberOfPagesa = 9;
	  
	  
	  int[] resa = { 
	   android.R.drawable.toast_frame,
	   android.R.drawable.sym_call_incoming,
	   android.R.drawable.btn_dialog,
	   android.R.drawable.sym_call_outgoing,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on};
	  
	  int[] backgroundcolora = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050,0xFF505050,0xFF505050,0xFF505050,0xFF505050};
	  private PageListener pageListener;
	  
	  
	  
	  @Override
	  public int getCount() {
	   return NumberOfPagesa;
	  }

	  @Override
	  public boolean isViewFromObject(View view3, Object object) {
	   return view3 == object;
	   
	  }

	  
	 
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager4.setOnPageChangeListener(pageListener);
/*		  
	      TextView textView = new TextView(swipe_image_lock_set.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position));
	      */
	      
	//container.setRotation(-90f);
	      ImageView imageView = new ImageView(shake_or_swipe.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    
	      if(ab3 != null && ab3.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil3.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil3.get(i)).resize(size,size).into(imageView);
	    		  		}
	    		 	}
	    	  }else{
	    		  imageView.setImageResource(resa[position]);
	    	  }

	 LayoutParams imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(shake_or_swipe.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);

	      
	      	      
	      final int page = position;
	     
	      
	      container2.addView(layout);
	      return layout;
	  }

	  private class PageListener extends SimpleOnPageChangeListener{
		    private final String TAG = null;

			public void onPageSelected(int position) {
		        Log.i(TAG, "page selected " + position);
		           currentPage = position;
		           d4 = currentPage;
		           //Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
		}
		}
	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }

 private class MyPagerAdapter5 extends PagerAdapter{
	  
	  int NumberOfPagesa = 9;
	  
	  
	  int[] resa = { 
	   android.R.drawable.toast_frame,
	   android.R.drawable.sym_call_incoming,
	   android.R.drawable.btn_dialog,
	   android.R.drawable.sym_call_outgoing,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on};
	  
	  int[] backgroundcolora = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050,0xFF505050,0xFF505050,0xFF505050,0xFF505050};
	  private PageListener pageListener;
	  
	  
	  
	  @Override
	  public int getCount() {
	   return NumberOfPagesa;
	  }

	  @Override
	  public boolean isViewFromObject(View view3, Object object) {
	   return view3 == object;
	   
	  }

	  
	 
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager5.setOnPageChangeListener(pageListener);
/*		  
	      TextView textView = new TextView(swipe_image_lock_set.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position));
	      */
	      
	//container.setRotation(-90f);
	      ImageView imageView = new ImageView(shake_or_swipe.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    
	      if(ab4 != null && ab4.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil4.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil4.get(i)).resize(size,size).into(imageView);
	    		  		}
	    		 	}
	    	  }else{
	    		  imageView.setImageResource(resa[position]);
	    	  }

	 LayoutParams imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(shake_or_swipe.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);

	      
	      	      
	      final int page = position;
	     
	      
	      container2.addView(layout);
	      return layout;
	  }

	  private class PageListener extends SimpleOnPageChangeListener{
		    private final String TAG = null;

			public void onPageSelected(int position) {
		        Log.i(TAG, "page selected " + position);
		           currentPage = position;
		           d5 = currentPage;
		           //Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
		}
		}
	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }

 private class MyPagerAdapter6 extends PagerAdapter{
	  
	  int NumberOfPagesa = 9;
	  
	  
	  int[] resa = { 
	   android.R.drawable.toast_frame,
	   android.R.drawable.sym_call_incoming,
	   android.R.drawable.btn_dialog,
	   android.R.drawable.sym_call_outgoing,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on};
	  
	  int[] backgroundcolora = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050,0xFF505050,0xFF505050,0xFF505050,0xFF505050};
	  private PageListener pageListener;
	  
	  
	  
	  @Override
	  public int getCount() {
	   return NumberOfPagesa;
	  }

	  @Override
	  public boolean isViewFromObject(View view3, Object object) {
	   return view3 == object;
	   
	  }

	  
	 
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager6.setOnPageChangeListener(pageListener);

	      ImageView imageView = new ImageView(shake_or_swipe.this);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	    
	      if(ab5 != null && ab5.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil5.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil5.get(i)).resize(size,size).into(imageView);
	    		  		}
	    		 	}
	    	  }else{
	    		  imageView.setImageResource(resa[position]);
	    	  }

	 LayoutParams imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(shake_or_swipe.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);

	      
	      	      
	      final int page = position;
	     
	      
	      container2.addView(layout);
	      return layout;
	  }

	  private class PageListener extends SimpleOnPageChangeListener{
		    private final String TAG = null;

			public void onPageSelected(int position) {
		        Log.i(TAG, "page selected " + position);
		           currentPage = position;
		           d6 = currentPage;
		           //Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();
		}
		}
	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }

 private class MyPagerAdapter7 extends PagerAdapter{
	  
	  int NumberOfPagesa = 9;
	  
	  
	  int[] resa = { 
	   android.R.drawable.toast_frame,
	   android.R.drawable.sym_call_incoming,
	   android.R.drawable.btn_dialog,
	   android.R.drawable.sym_call_outgoing,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on};
	  
	  int[] backgroundcolora = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050,0xFF505050,0xFF505050,0xFF505050,0xFF505050};
	  private PageListener pageListener;
	  
	  
	  
	  @Override
	  public int getCount() {
	   return NumberOfPagesa;
	  }

	  @Override
	  public boolean isViewFromObject(View view3, Object object) {
	   return view3 == object;
	   
	  }
	 
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager7.setOnPageChangeListener(pageListener);

	      ImageView imageView = new ImageView(shake_or_swipe.this);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	    
	      if(ab6 != null && ab6.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil6.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil6.get(i)).resize(size,size).into(imageView);
	    		  		}
	    		 	}
	    	  }else{
	    		  imageView.setImageResource(resa[position]);
	    	  }

	 		LayoutParams layoutParams  = new LayoutParams(size,size);	      
	      
	      LinearLayout layout = new LinearLayout(shake_or_swipe.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams imageParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      imageView.setLayoutParams(imageParams);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);

	      
	      	      
	      final int page = position;
	     
	      
	      container2.addView(layout);
	      return layout;
	  }

	  private class PageListener extends SimpleOnPageChangeListener{
		    private final String TAG = null;

			public void onPageSelected(int position) {
		        Log.i(TAG, "page selected " + position);
		           currentPage = position;
		           d7 = currentPage;
		           //Toast.makeText(getApplicationContext(),"current page "+currentPage +"length : "+ab6.length()+"size : "+Fil6.size(),Toast.LENGTH_LONG).show();          
		}
		}
	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }


 private class MyPagerAdapter8 extends PagerAdapter{
	  
	  int NumberOfPagesa = 9;
	  
	  
	  int[] resa = { 
	   android.R.drawable.toast_frame,
	   android.R.drawable.sym_call_incoming,
	   android.R.drawable.btn_dialog,
	   android.R.drawable.sym_call_outgoing,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on};
	  
	  int[] backgroundcolora = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050,0xFF505050,0xFF505050,0xFF505050,0xFF505050};
	  private PageListener pageListener;
	  
	  
	  
	  @Override
	  public int getCount() {
	   return NumberOfPagesa;
	  }

	  @Override
	  public boolean isViewFromObject(View view3, Object object) {
	   return view3 == object;
	   
	  }

	  
	 
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager8.setOnPageChangeListener(pageListener);
/*		  
	      TextView textView = new TextView(swipe_image_lock_set.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position));
	      */
	      
	//container.setRotation(-90f);
	      ImageView imageView = new ImageView(shake_or_swipe.this);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //imageView.setImageResource(resa[position]);
	      //String a = null ;
	    
	      if(ab7 != null && ab7.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil7.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil7.get(i)).resize(size,size).into(imageView);
	    		  		}
	    		 	}
	    	  }else{
	    		  imageView.setImageResource(resa[position]);
	    	  }

	 		LayoutParams layoutParams  = new LayoutParams(size,size);	      
	      
	      LinearLayout layout = new LinearLayout(shake_or_swipe.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams imageParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      imageView.setLayoutParams(imageParams);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);

	      
	      	      
	      final int page = position;
	     
	      
	      container2.addView(layout);
	      return layout;
	  }

	  private class PageListener extends SimpleOnPageChangeListener{
		    private final String TAG = null;

			public void onPageSelected(int position) {
		        Log.i(TAG, "page selected " + position);
		           currentPage = position;
		           d8 = currentPage;
		           //Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
		}
		}
	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }

 
 private class MyPagerAdapter9 extends PagerAdapter{
	  
	  int NumberOfPagesa = 9;
	  
	  
	  int[] resa = { 
	   android.R.drawable.toast_frame,
	   android.R.drawable.sym_call_incoming,
	   android.R.drawable.btn_dialog,
	   android.R.drawable.sym_call_outgoing,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on};
	  
	  int[] backgroundcolora = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050,0xFF505050,0xFF505050,0xFF505050,0xFF505050};
	  private PageListener pageListener;
	  
	  
	  
	  @Override
	  public int getCount() {
	   return NumberOfPagesa;
	  }

	  @Override
	  public boolean isViewFromObject(View view3, Object object) {
	   return view3 == object;
	   
	  }

	  
	 
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager9.setOnPageChangeListener(pageListener);
/*		  
	      TextView textView = new TextView(swipe_image_lock_set.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position));
	      */
	      
	//container.setRotation(-90f);
	      ImageView imageView = new ImageView(shake_or_swipe.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    
	      if(ab8 != null && ab8.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil8.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil8.get(i)).resize(size,size).into(imageView);
	    		  		}
	    		 	}
	    	  }else{
	    		  imageView.setImageResource(resa[position]);
	    	  }

	      imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(shake_or_swipe.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);

	      
	      	      
	      final int page = position;
	     
	      
	      container2.addView(layout);
	      return layout;
	  }

	  private class PageListener extends SimpleOnPageChangeListener{
		    private final String TAG = null;

			public void onPageSelected(int position) {
		        Log.i(TAG, "page selected " + position);
		           currentPage = position;
		           d9 = currentPage;
		           //Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
		}
		}
	  
	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }
/* public void onSensorChanged(SensorEvent event) {
	// TODO Auto-generated method stub
	
	if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
		
		getAccelerometer(event);
	}
}
*/

@Override
public void onAccuracyChanged(Sensor sensor, int accuracy) {
	// TODO Auto-generated method stub
	
}

@Override
public void onSensorChanged(SensorEvent event) {
	// TODO Auto-generated method stub
	if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
		
		getAccelerometer(event);
	}
}
	private void getAccelerometer(SensorEvent event) {
		
		float[] value = event.values;
		
		float x = value[0];
		float y = value[1];
		float z = value[2];
		
		float accelationSquareRoot = (x*x + y*y + z*z) 
				/ (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
		
		long actualTime = System.currentTimeMillis();
		
		if(accelationSquareRoot >= 2) {
			
			if(actualTime-lastTime < 200) {
				
				return;
			}
			
			lastTime = actualTime;
			
			// Perform your Action Here..
						
			finish();			
		}
	}
	@Override
	public void onAccuracyChanged(int sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(int sensor, float[] values) {
		// TODO Auto-generated method stub
		
	}	
	public void setdivalue() {
		// TODO Auto-generated method stub

	    if(display_item_adapter.p1 != -1){ sharedPreferences.edit().putInt("iv1", display_item_adapter.p1).commit();}
	    else{sharedPreferences.edit().putInt("iv1", 1).commit();}
	    if(display_item_adapter.p2 != -1){ sharedPreferences.edit().putInt("iv2", display_item_adapter.p2).commit();}
	    else{sharedPreferences.edit().putInt("iv2", 1).commit();
	    a2 = sharedPreferences.getInt("iv2", 0);
	    Toast.makeText(getApplicationContext(), "method : "+a1+" / "+a2, Toast.LENGTH_SHORT).show();	    }
	    if(display_item_adapter.p3 != -1){ sharedPreferences.edit().putInt("iv3", display_item_adapter.p3).commit();}
	    else{sharedPreferences.edit().putInt("iv3", 1).commit();}
	    if(display_item_adapter.p4 != -1){ sharedPreferences.edit().putInt("iv4", display_item_adapter.p4).commit();}
	    else{sharedPreferences.edit().putInt("iv4", 1).commit();}
	    if(display_item_adapter.p5 != -1){ sharedPreferences.edit().putInt("iv5", display_item_adapter.p5).commit();}
	    else{sharedPreferences.edit().putInt("iv5", 1).commit();}
	    if(display_item_adapter.p6 != -1){ sharedPreferences.edit().putInt("iv6", display_item_adapter.p6).commit();}
	    else{sharedPreferences.edit().putInt("iv6", 1).commit();}
	    if(display_item_adapter.p7 != -1){ sharedPreferences.edit().putInt("iv7", display_item_adapter.p7).commit();}
	    else{sharedPreferences.edit().putInt("iv7", 1).commit();}
	    if(display_item_adapter.p8 != -1){ sharedPreferences.edit().putInt("iv8", display_item_adapter.p8).commit();}
	    else{sharedPreferences.edit().putInt("iv8", 1).commit();}
		
	    a1 = sharedPreferences.getInt("iv1", 0);a2 = sharedPreferences.getInt("iv2", 0);
	    a3 = sharedPreferences.getInt("iv3", 0);a4 = sharedPreferences.getInt("iv4", 0);
	    a5 = sharedPreferences.getInt("iv5", 0);a6 = sharedPreferences.getInt("iv6", 0);
	    a7 = sharedPreferences.getInt("iv7", 0);a8 = sharedPreferences.getInt("iv8", 0);
	    
	    Toast.makeText(getApplicationContext(), "method : "+a1+" / "+a2+" / "+a3+" / "+a4+" / "
	    	    +" / "+a5+" / "+a6+" / "+a7+" / "+a8, Toast.LENGTH_SHORT).show();	    
	}
@Override
public void onWindowFocusChanged(boolean hasFocus) {

	super.onWindowFocusChanged(hasFocus);
	hideNavBar();
    
}

public class customViewGroup extends ViewGroup {
		 
		public customViewGroup(Context context) {
			super(context);
		}
 
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
		}
 
		@Override
		public boolean onInterceptTouchEvent(MotionEvent ev) {
			Log.v("customViewGroup", "**********Intercepted");
			return true;
		}
	}

private void executeDelayed() {
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            // execute after 500ms
            hideNavBar();
        }
    }, 500);
}


private void hideNavBar() {
	
    DisplayMetrics metrics1 = getResources().getDisplayMetrics();
    
    int densityDpi = (int)(metrics1.density * 160f);
    
    int screenSize = getResources().getConfiguration().screenLayout &
            Configuration.SCREENLAYOUT_SIZE_MASK;

if((screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE) ||(screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE))
{
	
	if (Build.VERSION.SDK_INT > 18) {
        View v = getWindow().getDecorView();
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                                
		getWindow().getDecorView().setSystemUiVisibility(View.GONE);
    }else{
    	//getWindow().getDecorView().setSystemUiVisibility(View.GONE);	
    }
    
}else{
	if (Build.VERSION.SDK_INT > 18) {
        View v = getWindow().getDecorView();
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }else{
    	int mUIFlag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    getWindow().getDecorView().setSystemUiVisibility(mUIFlag);
    }
}
}
public void getdat(){
    
    if(MainActivity.lsb_key == 1){
    	
    	sharedPreferences.edit().putInt("sbw_key", MainActivity.lsb_key).commit();
    	Toast.makeText(getApplicationContext(), "lsb key : "+lsb, Toast.LENGTH_SHORT).show();
    }else{
    	
    	sharedPreferences.edit().putInt("sbw_key", 0).commit();
    	Toast.makeText(getApplicationContext(), "lsb key : "+lsb, Toast.LENGTH_SHORT).show();
    }
	lsb = sharedPreferences.getInt("sbw_key", 0);
    
if(wallpaper_chooser.wall != 00000000){
	sharedPreferences.edit().putInt("wallpaper_choose", wallpaper_chooser.wall).commit();    	
}else{
	sharedPreferences.edit().putInt("wallpaper_choose", R.drawable.background3).commit();
}
rrl = (RelativeLayout)findViewById(R.id.rrl);
wallb = sharedPreferences.getInt("wallpaper_choose", 0); 	
	shk_frm = (FrameLayout)findViewById(R.id.shakeorswipe_frm);
	shk_frm.setOnTouchListener(gestureListener);

if(lsb == 1 ){
	shk_frm.setBackgroundResource(wallb);
}
else{ 
	shk_frm.removeView(rl); 
	}
}

public void rt(){
if( rt != null && rt.length() > 0){
	sharedPreferences.edit().putString("rington", MainActivity.ring).commit();
}
 rt =  sharedPreferences.getString("rington", "");
ring = Uri.parse(rt);    
 if(rt.length() > 0){
AudioManager audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
int volume = audioManager.getStreamVolume(AudioManager.STREAM_NOTIFICATION);
 mediaPlayer = new MediaPlayer();
try {
    mediaPlayer.setDataSource(getApplicationContext(), ring);
} catch (Exception e1) {
    e1.printStackTrace();
    mediaPlayer.release();
    return;
}
mediaPlayer.setAudioStreamType(AudioManager.STREAM_NOTIFICATION);
mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
    }
});
try {
    mediaPlayer.prepare();
} catch (Exception e1) {
    e1.printStackTrace();
    mediaPlayer.release();
    return;
}
mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {

    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        // TODO Auto-generated method stub
        mediaPlayer.stop();
        mediaPlayer.start();
    }
});
mediaPlayer.setVolume(volume, volume);
 }	
}
/*public void r(){
		k1.reenableKeyguard();
}

public void c(){
	
	km = (KeyguardManager)getSystemService("keyguard");
	  if(g()){
		  if(km.inKeyguardRestrictedInputMode()){
		    	k1.disableKeyguard();
		    }while(!km.inKeyguardRestrictedInputMode()){
		    	return;
		    }	  
	  }
	  r();
}
public boolean g(){
	if(MainActivity.posit == 1){
		//Toast.makeText(getApplicationContext(), "posit value : "+MainActivity.posit, Toast.LENGTH_SHORT).show();
		return true;
	}else{
		return false;
	}	  
}
  */  
}