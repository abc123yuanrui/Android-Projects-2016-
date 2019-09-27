package com.universallock;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import com.squareup.picasso.Picasso;

import adapter.sharedpreference_interface;
import android.R.layout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;

public class swipe_image_lock_set extends Activity {
		
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
	private static int d1,i;
	private boolean bool,remove= true;
	private int d2;
	private int d3;
	private int d4;
	private int d5;
	private int d6; 
	private int d7;
	private int d8;
	private int d9;
	private int e1,e2,e3,e4,e5,e6,e7,e8,e9;
	private int f1,f2,f3,f4,f5,f6,f7,f8,f9;	
	private String s1,s2,s3,s4,s5,s6,s7,s8,s9;
	private  String MyPREFERENCESS = "MyUserChoices";
	private  SharedPreferences sharedpreferences;
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
	String if1,if2,if3,if4,if5,if6,if7,if8,if9;
	View view;
	Button btnok,btncnl,btnchoose,btncnt,b1,b2,b3,b4,b5,b6,b7,b8,b9,btnconfirm;
	public MotionEvent event;
	float downX; 
	float upX;
	private static int currentPage;
	ArrayList<String> a,b,c = new ArrayList<String>();
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
	
	public static String ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8;
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
	setvalue app;
	private LayoutParams imageParams;
	private int size;
	//private PageListener PageListener;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
  
	 super.onCreate(savedInstanceState);
     this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	 setContentView(R.layout.slide_image_lock_set);
	 sharedpreferences = getSharedPreferences(MyPREFERENCESS,MODE_PRIVATE);
	 app = (setvalue) getApplicationContext();	
	 size = getResources().getDimensionPixelSize(R.dimen.viewpager_img_size);
	 	sharedpreferences.edit().remove("e1").commit();sharedpreferences.edit().remove("e2").commit();
	 	sharedpreferences.edit().remove("e3").commit();sharedpreferences.edit().remove("e4").commit();
	 	sharedpreferences.edit().remove("e5").commit();sharedpreferences.edit().remove("e6").commit();
	 	sharedpreferences.edit().remove("e7").commit();sharedpreferences.edit().remove("e8").commit();
	 	sharedpreferences.edit().remove("e9").commit();
	 hp =  (ViewGroup)findViewById(R.id.hiden_panel);
	hp.setVisibility(View.INVISIBLE);
	bool = false;
	
	
	
	ImageView icon_fb = (ImageView) findViewById(R.id.icon_fb);
    ImageView icon_tw = (ImageView) findViewById(R.id.icon_tw);
    ImageView icon_gp = (ImageView) findViewById(R.id.icon_gp);
    icon_fb.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		Uri link = Uri.parse("https://www.facebook.com/UniversalLockApp?ref=bookmarks");
		Intent i = new Intent(Intent.ACTION_VIEW,link);
		startActivity(i);
		}
	});
    icon_tw.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Uri link = Uri.parse("https://twitter.com/Universal_Lock");
			Intent i = new Intent(Intent.ACTION_VIEW,link);
			startActivity(i);
		}
	});
    icon_gp.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Uri link = Uri.parse("https://plus.google.com/116983587903359769433");
			Intent i = new Intent(Intent.ACTION_VIEW,link);
			startActivity(i);
		}
	});
	b1 = (Button)findViewById(R.id.box1);b2 = (Button)findViewById(R.id.box2);b3 = (Button)findViewById(R.id.box3);
	b4 = (Button)findViewById(R.id.box4);b5 = (Button)findViewById(R.id.box5);b6 = (Button)findViewById(R.id.box6);
	b7 = (Button)findViewById(R.id.box7);b8 = (Button)findViewById(R.id.box8);b9 = (Button)findViewById(R.id.box9);
	
	options.inPreferredConfig = Bitmap.Config.ARGB_8888;	
	
    ab  = sharedpreferences.getString("imgpath", ""); ab1 = sharedpreferences.getString("imgpath2", "");
    ab2 = sharedpreferences.getString("imgpath3", "");ab3 = sharedpreferences.getString("imgpath4", "");
    ab4 = sharedpreferences.getString("imgpath5", "");ab5 = sharedpreferences.getString("imgpath6", "");
    ab6 = sharedpreferences.getString("imgpath7", "");ab7 = sharedpreferences.getString("imgpath8", "");
    ab8 = sharedpreferences.getString("imgpath9", "");
    app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
    runab();
    System.out.println("ab : "+ab);
	  Toast.makeText(getApplicationContext(), "This is ab" +" : "+ ab, Toast.LENGTH_LONG).show();
	l = sharedpreferences.getInt("l_l1", 0);
	Toast.makeText(getApplicationContext(), "main :l : " +l, Toast.LENGTH_LONG).show();

		
	
	if(ab1 != null){
		  arr = ab1.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil1.add(imgFile);	 			
		  		}
		  }
	}
	if(ab2 != null){
		  arr = ab2.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil2.add(imgFile);	 			
		  		}
		  }
	}
	if(ab3 != null){
		  arr = ab3.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil3.add(imgFile);	 			
		  		}
		  }
	}
	if(ab4 != null){
		  arr = ab4.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil4.add(imgFile);	 			
		  		}
		  }
	}
	if(ab5 != null){
		  arr = ab5.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				  //Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil5.add(imgFile);	 			
		  		}
		  }
	}
	if(ab6 != null){
		  arr = ab6.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil6.add(imgFile);
		 			
		  		}
		  }
	}
	if(ab7 != null){
		  arr = ab7.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil7.add(imgFile);	 			
		  		}
		  }
	}
	if(ab8 != null){
		  arr = ab8.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil8.add(imgFile);	 			
		  		}
		  }
	}
				
  btnconfirm = (Button)findViewById(R.id.swipe_image_lock_set_btnconfirm);
  btnconfirm.setVisibility(View.GONE);
  btnok = (Button)findViewById(R.id.swipe_image_lock_set_btnok);
  btncnl = (Button)findViewById(R.id.swipe_image_lock_set_btcnl);
  
  btnchoose = (Button)findViewById(R.id.swipe_image_lock_set_choose_image);
  viewPager = (ViewPager)findViewById(R.id.myviewpager_set); 	
  viewPager1 = (ViewPager)findViewById(R.id.myviewpager_2_set);
  viewPager2 = (ViewPager)findViewById(R.id.myviewpager_3_set);
  viewPager4 = (ViewPager)findViewById(R.id.myviewpager_set_2);
  viewPager5 = (ViewPager)findViewById(R.id.myviewpager_2_set_2);
  viewPager6 = (ViewPager)findViewById(R.id.myviewpager_3_set_2);
  viewPager7 = (ViewPager)findViewById(R.id.myviewpager_set_3);  
  viewPager8 = (ViewPager)findViewById(R.id.myviewpager_2_set_3);
  viewPager9 = (ViewPager)findViewById(R.id.myviewpager_3_set_3);
  
  //PageListener = new PageListener();
  //viewPager.setOnPageChangeListener(PageListener);
  
    
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
  
  //
  
  btncnl.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		f1 = 0;f2 = 0;f3 = 0;f4 = 0;f5 = 0;f6 = 0;f7 = 0;f8 = 0;f9 = 0;
		overridePendingTransition(R.anim.right_out,R.anim.right_in);
		finish();
	}
});

  btnok.setOnClickListener( new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(z1 == 0 && z2 == 0 && z3 == 0 && z4 == 0 && z5 == 0 && z6 == 0 && z7 == 0 && z8 == 0 && z9 == 0){
			Toast.makeText(getApplicationContext(), "Please set at least one image", Toast.LENGTH_SHORT).show();
		}else{		
			e1 = z1;e2 = z2;e3 = z3;e4 = z4;e5 = z5;e6 = z6;e7 = z7;e8 = z8;e9 = z9;
			Toast.makeText(getApplicationContext(), "Choices - "+ e1+e2+e3+e4+e5+e6+e7+e8+e9, Toast.LENGTH_SHORT).show();
			updateData();
			
			//Toast.makeText(getApplicationContext(), "Confirm your choices", Toast.LENGTH_SHORT).show();		
			btnok.setVisibility(View.GONE);
			btnconfirm.setVisibility(View.VISIBLE);
		}
	}
});
  btnconfirm.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if((e1 == z1)&& (e2 == z2) && (e3 == z3) && (e4 == z4) && (e5 == z5)
				&& (e6 == z6) && (e7 == z7) && (e8 == z8) && (e9 == z9)){
			
			app.setimageposition(z1,z2,z3,z4,z5,z6,z7,z8,z9);
				Intent i = new Intent();
				i.putExtra("ab_Data", 3);
				setResult(RESULT_OK,i);
				finish();
		}else{
			Toast.makeText(getApplicationContext(), "Chocieses not matched", Toast.LENGTH_SHORT).show();
			updateData();
		}
	}
});
  btnchoose.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		bool = true;		
		slideUpDown(view);
	}
});
 b1.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(swipe_image_lock_set.this, swipe_image_lock_set_choose_image.class);
		startActivityForResult(i, 1);
	}
});
 b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(swipe_image_lock_set.this, swipe_image_lock_set_choose_image.class);
			startActivityForResult(i, 2);
		}
	});
 b3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(swipe_image_lock_set.this, swipe_image_lock_set_choose_image.class);
			startActivityForResult(i, 3);
		}
	});
 b4.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(swipe_image_lock_set.this, swipe_image_lock_set_choose_image.class);
			startActivityForResult(i, 4);
		}
	});
 b5.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(swipe_image_lock_set.this, swipe_image_lock_set_choose_image.class);
			startActivityForResult(i, 5);
		}
	});
 b6.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(swipe_image_lock_set.this, swipe_image_lock_set_choose_image.class);
			startActivityForResult(i, 6);
		}
	});
 b7.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(swipe_image_lock_set.this, swipe_image_lock_set_choose_image.class);
			startActivityForResult(i, 7);
		}
	});
 b8.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(swipe_image_lock_set.this, swipe_image_lock_set_choose_image.class);
			startActivityForResult(i, 8);
		}
	});
 b9.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(swipe_image_lock_set.this, swipe_image_lock_set_choose_image.class);
			startActivityForResult(i, 9);
		}
	});

 }

 
private class MyPagerAdapter extends PagerAdapter{
	 
	 
  int NumberOfPages = 9;
  
  int[] res = {
	R.drawable.wallpaper_1,
	R.drawable.abc,
   R.drawable.abc22,
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
	
	
      ImageView imageView = new ImageView(swipe_image_lock_set.this);
      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
      //imageView.setImageResource(res[position]);
	 	
	        
	 	if(ab != null && ab.length() >0){
    	  
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
      LinearLayout layout = new LinearLayout(swipe_image_lock_set.this);
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
        z1 = position;
        //
           //d1 = currentPage;        
          sharedpreferences.edit().putInt("rr1", currentPage).commit();
                     
}
}
  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
   container.removeView((LinearLayout)object);
  }

  
 }

 
 private class MyPagerAdapter2 extends PagerAdapter{
	  
	  int NumberOfPagess = 9;
	  
	  int[] ress = { 
			  R.drawable.abc22,
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
	      ImageView imageView = new ImageView(swipe_image_lock_set.this);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      int j = 0;
	      
	      if(ab1 != null && ab1.length() >0){
	    	  
	    	  for(int i = 0; i < Fil1.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil1.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	      }else{
	 		 imageView.setImageResource(ress[position]);
	 		 
	 	 }
	      
	      imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set.this);
	      layout.setOrientation(LinearLayout.HORIZONTAL);
	      LayoutParams layoutParams = new LayoutParams(
	        LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolors[position]);
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
		           
		           z2 = position;      
		           
		                     
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

	  
	  
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager2.setOnPageChangeListener(pageListener);

	      ImageView imageView = new ImageView(swipe_image_lock_set.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    int j = 0;
	    if(ab2 != null && ab2.length() >0){
	    	  
	    	  for(int i = 0; i < Fil2.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil2.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);		 
	 } 

	    imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set.this);
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
		           
		           z3 = position;
		           sharedpreferences.edit().putInt("rr3", currentPage).commit();		           
		           
		                     
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

	  
	  
	public Object instantiateItem(ViewGroup container2, int position) {
	   
	  
		  PageListener pageListener = new PageListener();
		  viewPager4.setOnPageChangeListener(pageListener);

	      ImageView imageView = new ImageView(swipe_image_lock_set.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    int j = 0;
	    if(ab3 != null && ab3.length() >0){
	    	  
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
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set.this);
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
		           
		           z4 = position;
		           sharedpreferences.edit().putInt("rr4", currentPage).commit();		           

		                     
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

		  ImageView imageView = new ImageView(swipe_image_lock_set.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    int j = 0;
	    if(ab4 != null && ab4.length() >0){
	    	  
	    	  for(int i = 0; i < Fil4.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil4.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
		 
	 } 

	    imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set.this);
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
		           
		           z5 = position;
		           sharedpreferences.edit().putInt("rr5", currentPage).commit();

		                     
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

	      ImageView imageView = new ImageView(swipe_image_lock_set.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    int j = 0;
	 
	    if(ab5 != null && ab5.length() >0){
	    	  
	    	  for(int i = 0; i < Fil5.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil5.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
		 
	 } 

	    imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set.this);
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
		           
		           z6 = position;
		           sharedpreferences.edit().putInt("rr6", currentPage).commit();
		           
		           
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

	      ImageView imageView = new ImageView(swipe_image_lock_set.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    int j = 0;
	    
	    if(ab6 != null && ab6.length() >0){
	    	  
	    	  for(int i = 0; i < Fil6.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil6.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
	 } 

	    imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set.this);
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
		           
		           z7 = position;
		           sharedpreferences.edit().putInt("rr7", currentPage).commit();

		                     
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

	      ImageView imageView = new ImageView(swipe_image_lock_set.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    int j = 0;
	    if(ab7 != null && ab7.length() >0){
	    	  
	    	  for(int i = 0; i < Fil7.size();i++){
	    		  if(i == position){
	    			  Picasso.with(getBaseContext()).load(Fil7.get(i)).resize(size,size).into(imageView);
	    		  }
	    		 }
	    	  }else{
		 imageView.setImageResource(resa[position]);
	 } 

	    imageParams = new LayoutParams(size,size);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set.this);
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
		           
		           z8 = position;
		           sharedpreferences.edit().putInt("rr8", currentPage).commit();
		           
		                     
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

		  ImageView imageView = new ImageView(swipe_image_lock_set.this);
	      //imageView.setImageResource(resa[position]);
	      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	      //String a = null ;
	    int j = 0;
	    if(ab8 != null && ab8.length() >0){
	    	  
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
	      LinearLayout layout = new LinearLayout(swipe_image_lock_set.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(layoutParams);
	      layout.addView(imageView);
	      final int page = position;	     
	      container2.addView(layout);
	      return layout;
	  }

	  private class PageListener extends SimpleOnPageChangeListener{
		    private final String TAG = null;

			public void onPageSelected(int position) {
		        Log.i(TAG, "page selected " + position);
		           
		           z9 = position;
		           sharedpreferences.edit().putInt("rr9", currentPage).commit();
		           
		                     
		}
		}
	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) 
  {
	
    
    if(requestCode == 1){
    	
    	if(resultCode == RESULT_OK){
    		
    		Bundle extras = data.getExtras();
    		//String[] sa = extras.getStringArray("array");
    		b = extras.getStringArrayList("array");
    		//ab = sharedpreferences.getString("b1","");
    		
    		Toast.makeText(getApplicationContext(), "this is b1 : "+b, Toast.LENGTH_SHORT).show();
    	
    		al = new String[b.size()];
    		al = b.toArray(al);
    	  for(int i = 0; i < al.length; i++){
    		  imagepathb.append(al[i]).append(",");
    	  }
    	  sharedpreferences.edit().putString("imgpath", imagepathb.toString()).commit();   
    	  ab  = sharedpreferences.getString("imgpath", "");
    	  Toast.makeText(getApplicationContext(), "this is ab1 : "+ab, Toast.LENGTH_SHORT).show();
    	  app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
    	 // runab();		
    		
    		    		
       	}
    }
   if(requestCode == 2){
    	
    	if(resultCode == RESULT_OK){
    		
    		Bundle extras = data.getExtras();
    		//String[] sa = extras.getStringArray("array");
    		b = extras.getStringArrayList("array");
    		al = new String[b.size()];
    		al = b.toArray(al);
    	  for(int i = 0; i < al.length; i++){
    		  imagepathb2.append(al[i]).append(",");
    	  }
    	  sharedpreferences.edit().putString("imgpath2", imagepathb2.toString()).commit();   
    	  ab1  = sharedpreferences.getString("imgpath2", "");
    	  app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
       	  if(b != null){
       		  showDialog(DIALOG_ALERT);
       	  }
       	}
    }
   if(requestCode == 3){
   	
   	if(resultCode == RESULT_OK){
   		
   		Bundle extras = data.getExtras();
   		//String[] sa = extras.getStringArray("array");
   		b = extras.getStringArrayList("array");
   		al = new String[b.size()];
   		al = b.toArray(al);
   	  for(int i = 0; i < al.length; i++){
   		  imagepathb3.append(al[i]).append(",");
   	  }
   	  sharedpreferences.edit().putString("imgpath3", imagepathb3.toString()).commit();   
   	  ab2  = sharedpreferences.getString("imgpath3", "");
   	app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
      	  if(b != null){
      		  showDialog(DIALOG_ALERT);
      	  }
      	}
   }
   if(requestCode == 4){
   	
   	if(resultCode == RESULT_OK){
   		
   		Bundle extras = data.getExtras();
   		//String[] sa = extras.getStringArray("array");
   		b = extras.getStringArrayList("array");
   		al = new String[b.size()];
   		al = b.toArray(al);
   	  for(int i = 0; i < al.length; i++){
   		  imagepathb4.append(al[i]).append(",");
   	  }
   	  sharedpreferences.edit().putString("imgpath4", imagepathb4.toString()).commit();   
   	  ab3  = sharedpreferences.getString("imgpath4", "");
   	app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
      	  if(b != null){
      		  showDialog(DIALOG_ALERT);
      	  }
      	}
   }
   if(requestCode == 5){
   	
   	if(resultCode == RESULT_OK){
   		
   		Bundle extras = data.getExtras();
   		//String[] sa = extras.getStringArray("array");
   		b = extras.getStringArrayList("array");
   		al = new String[b.size()];
   		al = b.toArray(al);
   	  for(int i = 0; i < al.length; i++){
   		  imagepathb5.append(al[i]).append(",");
   	  }
   	  sharedpreferences.edit().putString("imgpath5", imagepathb5.toString()).commit();   
   	  ab4  = sharedpreferences.getString("imgpath5", "");
   	app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
      	  if(b != null){
      		  showDialog(DIALOG_ALERT);
      	  }
      	}
   }
      if(requestCode == 6){
   	
   	if(resultCode == RESULT_OK){
   		
   		Bundle extras = data.getExtras();
   		//String[] sa = extras.getStringArray("array");
   		
   		b = extras.getStringArrayList("array");
   		al = new String[b.size()];
   		al = b.toArray(al);
   	  for(int i = 0; i < al.length; i++){
   		  imagepathb6.append(al[i]).append(",");
   	  }
   	  sharedpreferences.edit().putString("imgpath6", imagepathb6.toString()).commit();
   	  ab5  = sharedpreferences.getString("imgpath6", "");
   	app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
      	  if(b != null){
      		  showDialog(DIALOG_ALERT);
      	  }
      	}
   }
   if(requestCode == 7){
   	
   	if(resultCode == RESULT_OK){
   		
   		Bundle extras = data.getExtras();
   		//String[] sa = extras.getStringArray("array");
   		b = extras.getStringArrayList("array");
   		al = new String[b.size()];
   		al = b.toArray(al);
   	  for(int i = 0; i < al.length; i++){
   		  imagepathb7.append(al[i]).append(",");
   	  }
   	  sharedpreferences.edit().putString("imgpath7", imagepathb7.toString()).commit();   
   	  ab6  = sharedpreferences.getString("imgpath7", "");
   	app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
      	  if(b != null){
      		  showDialog(DIALOG_ALERT);
      	  }
      	}
   }
   if(requestCode == 8){
   	
   	if(resultCode == RESULT_OK){
   		
   		Bundle extras = data.getExtras();
   		//String[] sa = extras.getStringArray("array");
   		b = extras.getStringArrayList("array");
   		al = new String[b.size()];
   		al = b.toArray(al);
   	  for(int i = 0; i < al.length; i++){
   		  imagepathb8.append(al[i]).append(",");
   	  }
   	  sharedpreferences.edit().putString("imgpath8", imagepathb8.toString()).commit();   
   	  ab7  = sharedpreferences.getString("imgpath8", "");
   	app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
      	  if(b != null){
      		  showDialog(DIALOG_ALERT);
      	  }
      	}
   }
   if(requestCode == 9){
   	
   	if(resultCode == RESULT_OK){
   		
   		Bundle extras = data.getExtras();
   		//String[] sa = extras.getStringArray("array");
   		b = extras.getStringArrayList("array");
   		al = new String[b.size()];
   		al = b.toArray(al);
   	  for(int i = 0; i < al.length; i++){
   		  imagepathb9.append(al[i]).append(",");
   	  }
   	  
   	  sharedpreferences.edit().putString("imgpath9", imagepathb9.toString()).commit();   
   	ab8 = sharedpreferences.getString("imgpath9", "");
   	app.setimagevalue(ab,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8);
	
      	  if(b != null){
      		  showDialog(DIALOG_ALERT);
      	  }
      	}
   }
    
    }

public void onClick(View view) {
	  showDialog(DIALOG_ALERT);
	}

	public Dialog onCreateDialog(int id) {
	  switch (id) {
	    case DIALOG_ALERT:	 
	    	AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
	      //Builder builder = new AlertDialog.Builder(this);
	      builder.setMessage("Do you want to change small galary lock selection");
	      builder.setCancelable(true);	      
	      builder.setPositiveButton("Yes, yes", new OkOnClickListener());
	      builder.setNegativeButton("No, no", new CancelOnClickListener());
	      dialog = builder.create();	      
	      dialog.show(); 
	  }
	  return super.onCreateDialog(id);
	}

	private final class CancelOnClickListener implements
	    DialogInterface.OnClickListener {
	  public void onClick(DialogInterface dialog, int which) {
	    Toast.makeText(getApplicationContext(), "",Toast.LENGTH_LONG).show();
	    Intent i = new Intent();
		i.putExtra("ab_Data", 3);
	    setResult(RESULT_OK, i);		
	    finish();
	  }
	}

	private final class OkOnClickListener implements
	    DialogInterface.OnClickListener {
	  public void onClick(DialogInterface dialog, int which) {
	    dialog.dismiss();
	  }
	}
	public void slideUpDown(View view) {
	    if(bool) {
	        // Show the panel
	        Animation bottomUp = AnimationUtils.loadAnimation(this,R.anim.bottum_up);

	        view = findViewById(R.id.hiden_panel);
	        view.startAnimation(bottomUp);
	        view.setVisibility(View.VISIBLE);
	        bool = false;
	        
	    }
	    else {
	        // Hide the Panel
	        Animation bottomDown = AnimationUtils.loadAnimation(this,
	                R.anim.left_out);

	        view.startAnimation(bottomDown);
	        view.setVisibility(View.INVISIBLE);
	        bool = true;
	    }
	}
@Override
public void onBackPressed(){
	finish();
}
@Override
public void onDestroy(){
	
	super.onDestroy();
}

private void updateData() {
	 
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
        		
        		//((MyPagerAdapter)myPagerAdapter).notifyDataSetChanged();
        		//((MyPagerAdapter)myPagerAdapter).instantiateItem(0, 0);
        		viewPager.setAdapter(myPagerAdapter);viewPager1.setAdapter(myPagerAdapter2);
        		viewPager2.setAdapter(myPagerAdapter3);viewPager4.setAdapter(myPagerAdapter4);
        		viewPager5.setAdapter(myPagerAdapter5);viewPager6.setAdapter(myPagerAdapter6);
        		viewPager7.setAdapter(myPagerAdapter7);viewPager8.setAdapter(myPagerAdapter8);
        		viewPager9.setAdapter(myPagerAdapter9);
        		
        }
    });
}


public void r1(){

//	  if(b != null){
//		  showDialog(DIALOG_ALERT);
//	  }
}
public void runab(){
	if(ab != null ){
		  arr = ab.split(",");  
		  
		  for(int i = 0; i <arr.length; i++){    				  
				//  Toast.makeText(getApplicationContext(), "done: "+ arr[i], Toast.LENGTH_LONG).show();
		  		
		  		imgFile = new  File(arr[i]);
		  		if(imgFile.exists()){
		 			Fil.add(imgFile);	 			
		 			Toast.makeText(getApplicationContext(), "file "+arr[i], Toast.LENGTH_SHORT).show();
		  		}
		  }
	}else{
		ab = "";
		Toast.makeText(getApplicationContext(), "file is null ", Toast.LENGTH_SHORT).show();
	}
}
}