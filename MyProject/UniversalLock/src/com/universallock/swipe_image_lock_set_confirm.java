package com.universallock;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.squareup.picasso.Picasso;

import adapter.sharedpreference_interface;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class swipe_image_lock_set_confirm extends Activity{
	
	private int d1,d2,d3,d4,d5,d6,d7,d8,d9;
	private int e1,e2,e3,e4,e5,e6,e7,e8,e9;
	private int f1,f2,f3,f4,f5,f6,f7,f8,f9,size;	
	private ArrayList <File> Fil = new ArrayList<>(); 
	private ArrayList <File> Fil1 = new ArrayList<>();
	private ArrayList <File> Fil2 = new ArrayList<>();
	private ArrayList <File> Fil3 = new ArrayList<>();
	private ArrayList <File> Fil4 = new ArrayList<>();
	private ArrayList <File> Fil5 = new ArrayList<>();
	private ArrayList <File> Fil6 = new ArrayList<>();
	private ArrayList <File> Fil7 = new ArrayList<>();
	private ArrayList <File> Fil8 = new ArrayList<>();
	private  String MyPREFERENCES = "MyUserChoices";
	public static SharedPreferences sharedPreferences = null;
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
	
	StringBuffer c1,c2,c3;
	View view;
	Button btnok,btncnl;
	public MotionEvent event;
	float downX; 
	float upX;
	private static int currentPage;
	ArrayList<String> a = new ArrayList<String>();
	ArrayList<String> b = new ArrayList<String>();
	ArrayList<Bitmap> bitmapArray = new ArrayList<Bitmap>();
	ArrayList<Bitmap> bitarray = new ArrayList<Bitmap>();
	Bitmap[] bt ;
	public String[] al;
	private String ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8,ab9;
	File imgFile;
	private StringBuilder imagepathb = new StringBuilder();
	private StringBuilder imagepathb2 = new StringBuilder();
	private StringBuilder imagepathb3 = new StringBuilder();
	private StringBuilder imagepathb4 = new StringBuilder();
	private StringBuilder imagepathb5 = new StringBuilder();
	private StringBuilder imagepathb6 = new StringBuilder();
	private StringBuilder imagepathb7 = new StringBuilder();
	private StringBuilder imagepathb8 = new StringBuilder();
	private StringBuilder imagepathb9 = new StringBuilder();
	String ab,ad1,ad2,ad3,ad4,ad5,ad6,ad7,ad8,ad9;
	 private String[] arr;
	 private Bitmap myBitmap1;
	 private TextView btl;
	 private String batterperc,sid,sid_check;
	 private ImageView battery_img , signal_img;
	 BitmapFactory.Options options = new BitmapFactory.Options();
	private Context Context;
	private LayoutParams imageParams;
	setvalue app;
	 @Override
	  protected void onNewIntent(Intent intent) {
	      super.onNewIntent(intent);
	      // getIntent() should always return the most recent
	      setIntent(intent);
	      getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
	  }  
	  
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  
  setContentView(R.layout.swipe_image_lock_set_confirm);
  //getWindow().getDecorView().setSystemUiVisibility(View.GONE);
  app = (setvalue) getApplicationContext();
  
  sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
  Bundle dataa = getIntent().getExtras();
  
  String ii = getIntent().getExtras().getString("swd1");

  size = getResources().getDimensionPixelSize(R.dimen.viewpager_img_size);
  
  if((swipe_image_lock_set.x1 != f1) || (swipe_image_lock_set.x2 != f2) || (swipe_image_lock_set.x3 != f3) || (swipe_image_lock_set.x4 != f4) || 
  	  (swipe_image_lock_set.x5 != f5) || (swipe_image_lock_set.x6 != f6) ||  (swipe_image_lock_set.x7 != f7) || (swipe_image_lock_set.x8 != f8) || 
  	  (swipe_image_lock_set.x9 != f9)){
	  sharedPreferences.edit().remove("m11").commit();sharedPreferences.edit().remove("m12").commit();
	  sharedPreferences.edit().remove("m13").commit();sharedPreferences.edit().remove("m14").commit();
	  sharedPreferences.edit().remove("m15").commit();sharedPreferences.edit().remove("m16").commit();
	  sharedPreferences.edit().remove("m17").commit();sharedPreferences.edit().remove("m18").commit();
	  sharedPreferences.edit().remove("m19").commit();  
  }
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
		ab9 = "";
	}
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
		ab1 = "";
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
		ab2 = "";
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
		ab3 = "";
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
		ab4 = "";
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
		ab5 = "";
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
		ab6 = "";
	}
	if(ab6 != null && ab6.length() > 0 && ab6.length() > 0 && ab7.length() > 0){
		  arr = ab7.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil7.add(imgFile);	 			
		  		}
		  }
	}else{
		ab7 = "";
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
		ab8 = "";
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
		Toast.makeText(getApplicationContext(), "Ok Prefect", Toast.LENGTH_SHORT).show();
		Intent i = new Intent(swipe_image_lock_set_confirm.this,selectlocktype.class);
		i.putExtra("data", 3);
		setResult(RESULT_OK, i);
		finish();
		
		}else{
			Toast.makeText(getApplicationContext(), "Wrong Image", Toast.LENGTH_LONG).show();
		}
		
	}
});
 }
 
 
 @SuppressLint("ClickableViewAccessibility")
private class MyPagerAdapter extends PagerAdapter{
	 
	 
  int NumberOfPages = 9;
  
  int[] res = {
	R.drawable.wallpaper_1,
	R.drawable.abc,
   android.R.drawable.ic_dialog_alert,
   android.R.drawable.ic_menu_camera,
   android.R.drawable.ic_menu_compass,
   android.R.drawable.ic_menu_directions,
   android.R.drawable.ic_menu_gallery,android.R.drawable.ic_menu_gallery,android.R.drawable.ic_menu_gallery};
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
	
      ImageView imageView = new ImageView(swipe_image_lock_set_confirm.this);
      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
      if(ab9 != null && ab9.length() > 0){
    	  
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
      
      LinearLayout layout = new LinearLayout(swipe_image_lock_set_confirm.this);
      layout.setOrientation(LinearLayout.VERTICAL);
      LayoutParams layoutParams = new LayoutParams(
        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
      layout.setBackgroundColor(backgroundcolor[position]);
      layout.setLayoutParams(layoutParams);
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
	   android.R.drawable.bottom_bar,android.R.drawable.ic_menu_gallery,android.R.drawable.ic_menu_gallery,
	   android.R.drawable.ic_menu_gallery,android.R.drawable.ic_menu_gallery};
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
			
	      ImageView imageView = new ImageView(swipe_image_lock_set_confirm.this);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set_confirm.this);
	      layout.setOrientation(LinearLayout.HORIZONTAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolors[position]);
	      layout.setLayoutParams(layoutParams);
	      
	      //layout.addView(textView);
	      layout.addView(imageView);
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
		          // Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
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
	   android.R.drawable.btn_star_big_on,android.R.drawable.arrow_up_float,android.R.drawable.arrow_up_float,
	   android.R.drawable.arrow_up_float,android.R.drawable.arrow_up_float};
	  
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

	  
	  @SuppressWarnings("unused")
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager2.setOnPageChangeListener(pageListener);
	      ImageView imageView = new ImageView(swipe_image_lock_set_confirm.this);
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
		 
		 
		 //sharedPreferences.edit().remove("imgpath1").commit();
	 } 
	 //

	      
	      
	    	
	    		      //imageView.setImageResource();
	 LayoutParams imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set_confirm.this);
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
	   android.R.drawable.btn_star_big_on,
	   android.R.drawable.btn_star_big_on,android.R.drawable.btn_star_big_on,
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

	  
	  @SuppressWarnings("unused")
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager4.setOnPageChangeListener(pageListener);

		  ImageView imageView = new ImageView(swipe_image_lock_set_confirm.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    
	      int j;
	    	  
	      if(ab3 != null && ab3.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil3.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil3.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
		 
		 
	 } 

	      imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set_confirm.this);
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
		         //  Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
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

	  
	  @SuppressWarnings("unused")
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
	      ImageView imageView = new ImageView(swipe_image_lock_set_confirm.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    
	      int j;
	  		 
	      if(ab4 != null && ab4.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil4.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil4.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
		 
		 
		 //sharedPreferences.edit().remove("imgpath1").commit();
	 } 
	 //

	      
	      
	    	
	    		      //imageView.setImageResource();
	      imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set_confirm.this);
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
		          // Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
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

	  
	  @SuppressWarnings("unused")
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager6.setOnPageChangeListener(pageListener);
/*		  
	      TextView textView = new TextView(swipe_image_lock_set.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position));
	      */
	      
	//container.setRotation(-90f);
	      ImageView imageView = new ImageView(swipe_image_lock_set_confirm.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    
	      int j;
	      if(ab5 != null && ab5.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil5.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil5.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
		 
		 
		 //sharedPreferences.edit().remove("imgpath1").commit();
	 } 
	 //
	    	
	    		      //imageView.setImageResource();
	      imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set_confirm.this);
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

	  
	  @SuppressWarnings("unused")
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager7.setOnPageChangeListener(pageListener);
/*		  
	      TextView textView = new TextView(swipe_image_lock_set.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position));
	      */
	      
	//container.setRotation(-90f);
	      ImageView imageView = new ImageView(swipe_image_lock_set_confirm.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    
	      int j;
	      if(ab6 != null && ab6.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil6.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil6.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
		 
		 
		 //sharedPreferences.edit().remove("imgpath1").commit();
	 } 
	 //

	      
	      
	    	
	    		      //imageView.setImageResource();
	      imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set_confirm.this);
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
		           d7 = currentPage;
		         //  Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
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

	  
	  @SuppressWarnings("unused")
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
	      ImageView imageView = new ImageView(swipe_image_lock_set_confirm.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    
	      int j;
	      if(ab7 != null && ab7.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil7.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil7.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
		 
		 
		 //sharedPreferences.edit().remove("imgpath1").commit();
	 } 
	 //

	      
	      
	    	
	    		      //imageView.setImageResource();
	      imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set_confirm.this);
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
		           d8 = currentPage;
		         //  Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
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

	  
	  @SuppressWarnings("unused")
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
	      ImageView imageView = new ImageView(swipe_image_lock_set_confirm.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	      int j;
	      if(ab8 != null && ab8.length() > 0){
	    	  
	    	  for(int i = 0; i < Fil8.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil8.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
		 
		 
		 //sharedPreferences.edit().remove("imgpath1").commit();
	 } 
	 //

	      
	      
	    	
	    		      //imageView.setImageResource();
	      imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set_confirm.this);
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
		         //  Toast.makeText(getApplicationContext(),"current page "+currentPage,Toast.LENGTH_LONG).show();          
		}
		}
	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }


public void onDestroy()
{
  super.onDestroy();
}
@Override
public void onBackPressed(){
	
	super.onBackPressed();
	finish();
	overridePendingTransition(R.anim.right_out,R.anim.right_in);
	
}


}
