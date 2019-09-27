package com.universallock;

import java.io.File;
import java.security.KeyRep.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.squareup.picasso.Picasso;
import adapter.ListViewAdapter;
import adapter.color_adapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.media.RingtoneManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.Typeface;

public class swipe_image_lock_screen extends Activity  implements OnTouchListener{
	
	private int d1,d2,d3,d4,d5,d6,d7,d8,d9;
	private int e1,e2,e3,e4,e5,e6,e7,e8,e9;
	private int f1,f2,f3,f4,f5,f6,f7,f8,f9,status_key,lsb;	
	private int cc1,cc2,cc3,cc4,cc5,cc6,cc7,cc8;
	private String l1,l2,l3,l4,l5,l6,l7,l8,l9;
	private ArrayList <File> Fil = new ArrayList<>(); 
	private ArrayList <File> Fil1 = new ArrayList<>();
	private ArrayList <File> Fil2 = new ArrayList<>();
	private ArrayList <File> Fil3 = new ArrayList<>();
	private ArrayList <File> Fil4 = new ArrayList<>();
	private ArrayList <File> Fil5 = new ArrayList<>();
	private ArrayList <File> Fil6 = new ArrayList<>();
	private ArrayList <File> Fil7 = new ArrayList<>();
	private ArrayList <File> Fil8 = new ArrayList<>();
	public static String MyPREFERENCESS = "MyUserChoices";
	private SharedPreferences sharedpreferences;
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
	private String ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8,ab9;
	StringBuffer c1,c2,c3;
	View view;
	Button btnok,btncnl;
	public MotionEvent event;
	float downX; 
	float upX;
	private static int currentPage;
	private int a1,a2,a3,a4,a5,a6,a7,a8;
	private Typeface t1,t2,t3,t4;
	ArrayList<String> a = new ArrayList<String>();
	ArrayList<String> b = new ArrayList<String>();
	ArrayList<Bitmap> bitmapArray = new ArrayList<Bitmap>();	
	ArrayList<Bitmap> bitarray = new ArrayList<Bitmap>();
	Bitmap[] bt ;
	public String[] al;
	File imgFile,imgFile1,imgFile2,imgFile3,imgFile4,imgFile5,imgFile6,imgFile7,imgFile8,imgFile9;
	private StringBuilder imagepathb = new StringBuilder();
	String ab;
	 private String[] arr;
	 private Bitmap myBitmap1;
	 private TextView btl;
	 private String batterperc;
	 private ImageView battery_img , signal_img;
	 private String s1,s2,s3,s4,s5,s6,s7,s8,s9,data,str2,stri;
	 private String[] sa1,sa2,sa3,sa4,sa5,sa6,sa7,sa8,sa9;
	 private BitmapFactory.Options options = new BitmapFactory.Options();
	 private View v1;
	 private String MyPREFERENCES = "MyUserChoicesss";
	 private  SharedPreferences sharedPreferences = null;
	 private int walls,size1,size2,size3,size4,date_format,size;
	 private int[] imgl;	
	 private WindowManager manager;
	 private WindowManager.LayoutParams localLayoutParams;
	 setvalue app;
	 private LayoutParams imageParams;
	 
	  @Override
	  protected void onNewIntent(Intent intent) {
	      super.onNewIntent(intent);
	      setIntent(intent);
	      options.inPreferredConfig = Bitmap.Config.ARGB_8888;
	  }  
	  
 @Override
 protected void onCreate(Bundle savedInstanceState) {	 
	
  super.onCreate(savedInstanceState);
  this.requestWindowFeature(Window.FEATURE_NO_TITLE);
  hideNavBar();
  
  manager = ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE));

  localLayoutParams = new WindowManager.LayoutParams();
  localLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
  localLayoutParams.gravity = Gravity.TOP;    
  
  localLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|

//  		WindowManager.LayoutParams.FLAG_LAYOUT_ATTACHED_IN_DECOR |
  		WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN |
  		
         // this is to enable the notification to recieve touch events
         //WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN |
  		WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
         // Draws over status bar
 WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

  
 //localLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
 localLayoutParams.height = (int) (50 * getResources().getDisplayMetrics().scaledDensity);
 localLayoutParams.format = PixelFormat.TRANSPARENT;

 	view = new customViewGroup(this);
 
 	manager.addView(view, localLayoutParams);

  setContentView(R.layout.swipe_image_screen_lock);
  
  app = (setvalue) getApplicationContext();
  
  size = getResources().getDimensionPixelSize(R.dimen.viewpager_img_size);
  Toast.makeText(getApplicationContext(), "value of stri is : "+stri, Toast.LENGTH_SHORT).show();
  sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
  
  //imgl = new int[] {R.drawable.abc22,R.drawable.abc,R.drawable.abc23,R.drawable.abc,R.drawable.bird1,R.drawable.myp,
//		  R.drawable.myp2,R.drawable.myp3,R.drawable.wallpaper_1};
  if(wallpaper_chooser.wall != 0){
  	sharedPreferences.edit().putInt("wallpaper_choose", wallpaper_chooser.wall).commit();
  }
  walls = sharedPreferences.getInt("wallpaper_choose", 0); 
  
  FrameLayout frm = (FrameLayout)findViewById(R.id.swipe_image_lock_screen_frm);
  
  if(ListViewAdapter.i8 != -1){
  	sharedPreferences.edit().putInt("lsb_key", ListViewAdapter.i8).commit();
  	lsb = sharedPreferences.getInt("lsb_key", 0);
  }else{
  	sharedPreferences.edit().putInt("lsb_key", 1).commit();
  	lsb = sharedPreferences.getInt("lsb_key", 0);
  }
  
  if(lsb == 1 ){frm.setBackgroundResource(walls);}
  else{ frm.removeView(frm);}
  
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
  
  if(Text_size_dialog.p1 != 0){sharedPreferences.edit().putInt("pp1", Text_size_dialog.p1).commit();}
  else{sharedPreferences.edit().putInt("pp1", 36).commit();}
  if(Text_size_dialog.p2 != 0){sharedPreferences.edit().putInt("pp2", Text_size_dialog.p2).commit();}
  else{sharedPreferences.edit().putInt("pp2", 25).commit();}
  if(Text_size_dialog.p3 != 0){sharedPreferences.edit().putInt("pp3", Text_size_dialog.p3).commit();}
  else{sharedPreferences.edit().putInt("pp3", 25).commit();}
  if(Text_size_dialog.p4 != 0)sharedPreferences.edit().putInt("size", Text_size_dialog.p4).commit();
  else{sharedPreferences.edit().putInt("size", 25).commit();}
  size1 = sharedPreferences.getInt("pp1", 0);size2 = sharedPreferences.getInt("pp2", 0);
  size3 = sharedPreferences.getInt("pp3", 0);size4 = sharedPreferences.getInt("size", 0);
  
  
  cc1 = sharedPreferences.getInt("c1", 0); cc2 = sharedPreferences.getInt("c2", 0);
  cc3 = sharedPreferences.getInt("c3", 0); cc4 = sharedPreferences.getInt("c4", 0);
  cc5 = sharedPreferences.getInt("c5", 0); cc6 = sharedPreferences.getInt("c6", 0);
  cc7 = sharedPreferences.getInt("c7", 0); cc8 = sharedPreferences.getInt("c8", 0);
  
  if(font_typeface_chooser.p1 != null){sharedPreferences.edit().putString("t1", font_typeface_chooser.p1).commit();}
  else{sharedPreferences.edit().putString("t1", "fonts/f4.ttf").commit();}
  if(font_typeface_chooser.p2 != null){sharedPreferences.edit().putString("t2", font_typeface_chooser.p2).commit();}
  else{sharedPreferences.edit().putString("t2", "fonts/f4.ttf").commit();}    
  if(font_typeface_chooser.p4 != null){sharedPreferences.edit().putString("t4", font_typeface_chooser.p4).commit();}
  else{sharedPreferences.edit().putString("t4", "fonts/f4.ttf").commit();}
  
  	 t1 = Typeface.createFromAsset(getAssets(),sharedPreferences.getString("t1", ""));
  	 t2 = Typeface.createFromAsset(getAssets(),sharedPreferences.getString("t2", ""));
  	 t4 = Typeface.createFromAsset(getAssets(),sharedPreferences.getString("t4", ""));
  if(settings.date_format != 0){
  	sharedPreferences.edit().putInt("date_form", settings.date_format).commit();
  }
  date_format = sharedPreferences.getInt("date_form", 0);
  
  if(display_item_settings.p1 != -1){ sharedPreferences.edit().putInt("iv1", display_item_settings.p1).commit();}
  else{sharedPreferences.edit().putInt("iv1", 1).commit();}
  if(display_item_settings.p2 != -1){ sharedPreferences.edit().putInt("iv2", display_item_settings.p2).commit();}
  else{sharedPreferences.edit().putInt("iv2", 1).commit();}
  if(display_item_settings.p3 != -1){ sharedPreferences.edit().putInt("iv3", display_item_settings.p3).commit();}
  else{sharedPreferences.edit().putInt("iv3", 1).commit();}
  if(display_item_settings.p4 != -1){ sharedPreferences.edit().putInt("iv4", display_item_settings.p4).commit();}
  else{sharedPreferences.edit().putInt("iv4", 1).commit();}
  if(display_item_settings.p5 != -1){ sharedPreferences.edit().putInt("iv5", display_item_settings.p5).commit();}
  else{sharedPreferences.edit().putInt("iv5", 1).commit();}
  if(display_item_settings.p6 != -1){ sharedPreferences.edit().putInt("iv6", display_item_settings.p6).commit();}
  else{sharedPreferences.edit().putInt("iv6", 1).commit();}
  if(display_item_settings.p7 != -1){ sharedPreferences.edit().putInt("iv7", display_item_settings.p7).commit();}
  else{sharedPreferences.edit().putInt("iv7", 1).commit();}
  if(display_item_settings.p8 != -1){ sharedPreferences.edit().putInt("iv8", display_item_settings.p8).commit();}
  else{sharedPreferences.edit().putInt("iv8", 1).commit();}
  
  
  a1 = sharedPreferences.getInt("iv1", 0);a2 = sharedPreferences.getInt("iv2", 0);
  a3 = sharedPreferences.getInt("iv3", 0);a4 = sharedPreferences.getInt("iv4", 0);
  a5 = sharedPreferences.getInt("iv5", 0);a6 = sharedPreferences.getInt("iv6", 0);
  a7 = sharedPreferences.getInt("iv7", 0);a8 = sharedPreferences.getInt("iv8", 0);
  
  View status = findViewById(R.id.galary_stusbar);
  status_key = MainActivity.status_key;
  if(status_key == 0){
  	status.setVisibility(View.GONE);
  }else{
  	status.setVisibility(View.VISIBLE);
  }
  //getWindow().getDecorView().setSystemUiVisibility(View.GONE);
  //Bundle dataa = getIntent().getExtras(); 
	//  Toast.makeText(getApplicationContext(), "This is d1 : "+ d1, Toast.LENGTH_LONG).show();
	
   try
   {
     btl = ((TextView)findViewById(R.id.battery_tv));
     
     TextView time_id = (TextView)findViewById(R.id.time_id);
     
     TextView time_apmp = (TextView)findViewById(R.id.time_AMPM);
     
     TextView date_id = (TextView)findViewById(R.id.date_id);
     
     //Typeface type = Typeface.createFromFile(path)
     if (Calendar.getInstance().get(9) == 0) {}
     for (String str1 = "PM";; str1 = "AM")
     {
       SimpleDateFormat time1 = new SimpleDateFormat("HH:mm ");
       SimpleDateFormat date1 = new SimpleDateFormat("E, MMM  dd, yyyy");
       Calendar clnd = Calendar.getInstance();
       Date today = new Date();
       if((date_format != 0) && (date_format != 2)){str2 = time1.format(today);}
       else{str2 = time1.format(clnd.getTime());}
       String str3 = date1.format(clnd.getTime());
       time_id.setText(str2);	time_id.setTextColor(cc3); time_id.setTextSize(size2); time_id.setTypeface(t1);       
       time_apmp.setText(str1);
       if(a1 == 1){time_id.setVisibility(View.VISIBLE); time_apmp.setVisibility(View.VISIBLE);}
       else{time_id.setVisibility(View.GONE); time_apmp.setVisibility(View.GONE);}
       date_id.setText(str3); date_id.setTextColor(cc4); date_id.setTextSize(size1); date_id.setTypeface(t2);
       if(a2 == 1){date_id.setVisibility(View.VISIBLE);}else{date_id.setVisibility(View.GONE);}
       battery_img = ((ImageView)findViewById(R.id.battery_img));
       if(a5 == 1){battery_img.setVisibility(View.VISIBLE);}else{battery_img.setVisibility(View.GONE);}
       signal_img = ((ImageView)findViewById(R.id.signal_img));
       if(a7 == 1){signal_img.setVisibility(View.VISIBLE);}else{signal_img.setVisibility(View.GONE);}
       registerBatteryLevelReceiver();
       displayTelephonyInfo();
       
       //startService(new Intent(this, MyService.class).setAction("android.intent.action.SCREEN_OFF"));
       return;
     }
     
   }
   catch (Exception localException) {}
   /*l1 =0 com.example.mylockapp.MainActivity.sid1;
   if(l1 != null){
	   sharedPreferences.edit().putString("l1", l1).commit();
	   ab1 = sharedPreferences.getString("l1", "");
   }*/
   
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
   /*
   if((swipe_image_lock_set.x1 != f1) || (swipe_image_lock_set.x2 != f2) || (swipe_image_lock_set.x3 != f3) || (swipe_image_lock_set.x4 != f4) || 
		  	  (swipe_image_lock_set.x5 != f5) || (swipe_image_lock_set.x6 != f6) ||  (swipe_image_lock_set.x7 != f7) || (swipe_image_lock_set.x8 != f8) || 
		  	  (swipe_image_lock_set.x9 != f9)){
			  sharedPreferences.edit().remove("m11").commit();sharedPreferences.edit().remove("m12").commit();
			  sharedPreferences.edit().remove("m13").commit();sharedPreferences.edit().remove("m14").commit();
			  sharedPreferences.edit().remove("m15").commit();sharedPreferences.edit().remove("m16").commit();
			  sharedPreferences.edit().remove("m17").commit();sharedPreferences.edit().remove("m18").commit();
			  sharedPreferences.edit().remove("m19").commit();  
		  }
		  
		  if(swipe_image_lock_set.ab  != null && swipe_image_lock_set.ab.length() > 0){ sharedPreferences.edit().putString("sw1", MainActivity.s1).commit();}
		  if(swipe_image_lock_set.ab1 != null && swipe_image_lock_set.ab1.length() > 0){ sharedPreferences.edit().putString("sw2", MainActivity.s2).commit();}
		  if(swipe_image_lock_set.ab2 != null && swipe_image_lock_set.ab2.length() > 0){ sharedPreferences.edit().putString("sw3", MainActivity.s3).commit();}
		  if(swipe_image_lock_set.ab3 != null && swipe_image_lock_set.ab3.length() > 0){ sharedPreferences.edit().putString("sw4", MainActivity.s4).commit();}
		  if(swipe_image_lock_set.ab4 != null && swipe_image_lock_set.ab4.length() > 0){ sharedPreferences.edit().putString("sw5", MainActivity.s5).commit();}
		  if(swipe_image_lock_set.ab5 != null && swipe_image_lock_set.ab5.length() > 0){ sharedPreferences.edit().putString("sw6", MainActivity.s6).commit();}
		  if(swipe_image_lock_set.ab6 != null && swipe_image_lock_set.ab6.length() > 0){ sharedPreferences.edit().putString("sw7", MainActivity.s7).commit();}
		  if(swipe_image_lock_set.ab7 != null && swipe_image_lock_set.ab7.length() > 0){ sharedPreferences.edit().putString("sw8", MainActivity.s8).commit();}
		  if(swipe_image_lock_set.ab8 != null && swipe_image_lock_set.ab8.length() > 0){ sharedPreferences.edit().putString("sw9", MainActivity.s9).commit();}
		  
		  ab9 = sharedPreferences.getString("sw1", "");ab1 = sharedPreferences.getString("sw2", "");
		  ab2 = sharedPreferences.getString("sw3", "");ab3 = sharedPreferences.getString("sw4", "");
		  ab4 = sharedPreferences.getString("sw5", "");ab5 = sharedPreferences.getString("sw6", "");
		  ab6 = sharedPreferences.getString("sw7", "");ab7 = sharedPreferences.getString("sw8", "");
		  ab8 = sharedPreferences.getString("sw9", "");
		  
		  if(swipe_image_lock_set.x1 != -1){ sharedPreferences.edit().putInt("m11", swipe_image_lock_set.x1).commit();}
		  if(swipe_image_lock_set.x2 != -1){ sharedPreferences.edit().putInt("m12", swipe_image_lock_set.x2).commit();}
		  if(swipe_image_lock_set.x3 != -1){ sharedPreferences.edit().putInt("m13", swipe_image_lock_set.x3).commit();}
		  if(swipe_image_lock_set.x4 != -1){ sharedPreferences.edit().putInt("m14", swipe_image_lock_set.x4).commit();}
		  if(swipe_image_lock_set.x5 != -1){ sharedPreferences.edit().putInt("m15", swipe_image_lock_set.x5).commit();}
		  if(swipe_image_lock_set.x6 != -1){ sharedPreferences.edit().putInt("m16", swipe_image_lock_set.x6).commit();}
		  if(swipe_image_lock_set.x7 != -1){ sharedPreferences.edit().putInt("m17", swipe_image_lock_set.x7).commit();}
		  if(swipe_image_lock_set.x8 != -1){ sharedPreferences.edit().putInt("m18", swipe_image_lock_set.x8).commit();}
		  if(swipe_image_lock_set.x9 != -1){ sharedPreferences.edit().putInt("m19", swipe_image_lock_set.x9).commit();}
		  
		  f1 = sharedPreferences.getInt("m11", 0);f2 = sharedPreferences.getInt("m12", 0);f3 = sharedPreferences.getInt("m13", 0);
		  f4 = sharedPreferences.getInt("m14", 0);f5 = sharedPreferences.getInt("m15", 0);f6 = sharedPreferences.getInt("m16", 0);
		  f7 = sharedPreferences.getInt("m17", 0);f8 = sharedPreferences.getInt("m18", 0);f9 = sharedPreferences.getInt("m19", 0);
    */  
   Toast.makeText(getApplicationContext(), "This is code : "+f1+f2+f3+f4+" / "+f5+f6+f7+f8+f9, Toast.LENGTH_SHORT).show();

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

  
  
  //Toast.makeText(getApplicationContext(), "This is oncreate : "+ ab, Toast.LENGTH_LONG).show();
  
  
  btncnl.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}
});
  
  btnok.setOnClickListener( new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		if(d1 == f1 && d2 == f2 && d3 == f3 && d4 == f4 && d5== f5 && d6 == f6 && d7 == f7 && d8 == f8 && d9 == f9){
						
		finish();
		}else{
			Toast.makeText(getApplicationContext(), "Wrong Image", Toast.LENGTH_LONG).show();
		}
	}
});
 }

 private void registerBatteryLevelReceiver()
 {
   IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
   registerReceiver(this.battery_receiver, localIntentFilter);
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
      ImageView imageView = new ImageView(swipe_image_lock_screen.this);
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
      
      imageParams = new LayoutParams(size, size);
      imageView.setLayoutParams(imageParams);
      
      LinearLayout layout = new LinearLayout(swipe_image_lock_screen.this);
      layout.setOrientation(LinearLayout.VERTICAL);
      LayoutParams layoutParams = new LayoutParams(
        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
      layout.setBackgroundColor(backgroundcolor[position]);
      layout.setLayoutParams(imageParams);
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
	      ImageView imageView = new ImageView(swipe_image_lock_screen.this);
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
	      
	      imageParams = new LayoutParams(size, size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_screen.this);
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
	      ImageView imageView = new ImageView(swipe_image_lock_screen.this);
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

	      
	      imageParams = new LayoutParams(size, size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_screen.this);
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
	      ImageView imageView = new ImageView(swipe_image_lock_screen.this);
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

	      imageParams = new LayoutParams(size, size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_screen.this);
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
	      ImageView imageView = new ImageView(swipe_image_lock_screen.this);
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

	      imageParams = new LayoutParams(size, size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_screen.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(imageParams);
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

	      ImageView imageView = new ImageView(swipe_image_lock_screen.this);
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

	      imageParams = new LayoutParams(size, size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_screen.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(imageParams);
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

	      ImageView imageView = new ImageView(swipe_image_lock_screen.this);
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

	 		imageParams  = new LayoutParams(size, size);	      
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_screen.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams imageParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      imageView.setLayoutParams(imageParams);
	      
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
	      ImageView imageView = new ImageView(swipe_image_lock_screen.this);
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

	 		imageParams  = new LayoutParams(size, size);	      
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_screen.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams imageParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      imageView.setLayoutParams(imageParams);	      
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
	      ImageView imageView = new ImageView(swipe_image_lock_screen.this);
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

	      imageParams = new LayoutParams(size, size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_screen.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(imageParams);
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
   ((TextView)findViewById(R.id.operator_tv)).setTextColor(cc1);
   if(a6 == 1){((TextView)findViewById(R.id.operator_tv)).setVisibility(View.VISIBLE);} else{((TextView)findViewById(R.id.operator_tv)).setVisibility(View.GONE);}
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
 	  	btl.setText(str); btl.setTextColor(cc2);
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
 @Override
public void onDestroy()
{
  unregisterReceiver(this.battery_receiver); 
	manager.removeView(view);  
  super.onDestroy();
}
 

@Override
protected void onResume(){
	//getWindow().getDecorView().setSystemUiVisibility(View.GONE);

	executeDelayed();	
	super.onResume();
}

@Override
public boolean onTouch(View v, MotionEvent event) {
	// TODO Auto-generated method stub	
	return false;
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
                                
		//getWindow().getDecorView().setSystemUiVisibility(View.GONE);
    }else{
//    	getWindow().getDecorView().setSystemUiVisibility(View.GONE);	
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
    	
    }
}
}
}
