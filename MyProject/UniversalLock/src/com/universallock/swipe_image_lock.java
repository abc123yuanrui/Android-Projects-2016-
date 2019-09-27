package com.universallock;

import java.io.File;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

public class swipe_image_lock extends Activity {

 ViewPager viewPager,viewPager1,ViewPager2;
 //MyPagerAdapter myPagerAdapter;
// MyPagerAdapter3 myPagerAdapter3;
//MyPagerAdapter2 myPagerAdapter2;
 View view;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  
  setContentView(R.layout.slide_image_lock);
  
  viewPager = (ViewPager)findViewById(R.id.myviewpager);
  viewPager1 = (ViewPager)findViewById(R.id.myviewpager_2);
  ViewPager2 = (ViewPager)findViewById(R.id.myviewpager_3);
  //myPagerAdapter = new MyPagerAdapter();
  //myPagerAdapter2 = new MyPagerAdapter2();
  //myPagerAdapter3 = new MyPagerAdapter3();
  
  //viewPager.setAdapter(myPagerAdapter);
  //viewPager1.setAdapter(myPagerAdapter2);
//  ViewPager2.setAdapter(myPagerAdapter3);
  
  
}


  
  //viewPager.setRotation(-90f);
  
  
//  viewPager.setOnPageChangeListener(OnPageChangeListener listener);
	
  //ViewPager.setOnPageChangeListener(OnPageChangeListener listener)
 
/*

 public class MyPagerAdapter extends PagerAdapter{
  
  int NumberOfPages = 5;
  
  int[] res = { 
   R.drawable.myp,
   R.drawable.myp2,   
   R.drawable.myp3,
   R.drawable.bird1,
   R.drawable.flow1,
   };
  int[] backgroundcolor = { 
   0xFF101010,
   0xFF202020,
   0xFF303030,
   0xFF404040,
   0xFF505050};

  @Override
  public int getCount() {
   return NumberOfPages;
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
   return view == object;
   
  }

  
  public Object instantiateItem(ViewGroup container, int position) {
   
      
      TextView textView = new TextView(swipe_image_lock.this);
      textView.setTextColor(Color.WHITE);
      textView.setTextSize(30);
      textView.setTypeface(Typeface.DEFAULT_BOLD);
      textView.setText(String.valueOf(position));
      
//container.setRotation(-90f);
      ImageView imageView = new ImageView(swipe_image_lock.this);
      imageView.setImageResource(res[position]);
      LayoutParams imageParams = new LayoutParams(150,150);
      imageView.setLayoutParams(imageParams);
      
      LinearLayout layout = new LinearLayout(swipe_image_lock.this);
      layout.setOrientation(LinearLayout.VERTICAL);
      LayoutParams layoutParams = new LayoutParams(150,150);
      layout.setBackgroundColor(backgroundcolor[position]);
      layout.setLayoutParams(layoutParams);
      //layout.addView(textView);
      layout.addView(imageView);
      String s = "abc";
      s = s.substring(s.length() - 1);
      Toast.makeText(getApplicationContext(),"this is s : " + s, Toast.LENGTH_SHORT).show();
      final int page = position;
      layout.setOnTouchListener(new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			Toast.makeText(swipe_image_lock.this, 
				      "Page " + page + " clicked", 
				      Toast.LENGTH_LONG).show();
			return false; 
		}
	});
      /* layout.setOnClickListener(new OnClickListener(){

    @Override
    public void onClick(View v) {
     Toast.makeText(swipe_image_lock.this, 
      "Page " + page + " clicked", 
      Toast.LENGTH_LONG).show();
    }});
      
      
      container.addView(layout);
      return layout;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
   container.removeView((LinearLayout)object);
  }

 }

 private class MyPagerAdapter2 extends PagerAdapter{
	  
	  int NumberOfPagess = 5;
	  
	  int[] ress = { 
			  R.drawable.myp,
			  R.drawable.myp2,
			  R.drawable.myp3,
			   R.drawable.bird1,
			   R.drawable.flow1,
			   
	   android.R.drawable.bottom_bar};
	  int[] backgroundcolors = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050};

	  @Override
	  public int getCount() {
	   return NumberOfPagess;
	  }

	  @Override
	  public boolean isViewFromObject(View view2, Object object) {
	   return view2 == object;
	   
	  }

	  
	  public Object instantiateItem(ViewGroup container1, int position) {
	   
	      
	      TextView textView = new TextView(swipe_image_lock.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position));
	      
	//container.setRotation(-90f);
	      ImageView imageView = new ImageView(swipe_image_lock.this);
	      imageView.setImageResource(ress[position]);
	      LayoutParams imageParams = new LayoutParams(150,150);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock.this);
	      layout.setOrientation(LinearLayout.HORIZONTAL);
	      LayoutParams layoutParams = new LayoutParams(150,150);
	      layout.setBackgroundColor(backgroundcolors[position]);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);
	      String s = "abc";
	      s = s.substring(s.length() - 1);
	      Toast.makeText(getApplicationContext(),"this is s : " + s, Toast.LENGTH_SHORT).show();
	      final int page = position;
	      layout.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Toast.makeText(swipe_image_lock.this, 
					      "Page " + page + " clicked", 
					      Toast.LENGTH_LONG).show();
				return false; 
			}
		});
	      /* layout.setOnClickListener(new OnClickListener(){

	    @Override
	    public void onClick(View v) {
	     Toast.makeText(swipe_image_lock.this, 
	      "Page " + page + " clicked", 
	      Toast.LENGTH_LONG).show();
	    }});
	      */
	   /*   
	      container1.addView(layout);
	      return layout;
	  }

	  @Override
	  public void destroyItem(ViewGroup container1, int position, Object object) {
	   container1.removeView((LinearLayout)object);
	  }

	 }

 private class MyPagerAdapter3 extends PagerAdapter{
	  
	  int NumberOfPagesa = 5;
	  
	  int[] resa = { 
			  R.drawable.myp,
			  R.drawable.myp2,
			  R.drawable.myp3,
			   R.drawable.bird1,
			   R.drawable.flow1,
			   
			   
	   
	   android.R.drawable.btn_star_big_on};
	  int[] backgroundcolora = { 
	   0xFF101010,
	   0xFF202020,
	   0xFF303030,
	   0xFF404040,
	   0xFF505050};

	  @Override
	  public int getCount() {
	   return NumberOfPagesa;
	  }

	  @Override
	  public boolean isViewFromObject(View view3, Object object) {
	   return view3 == object;
	   
	  }

	  
	  public Object instantiateItem(ViewGroup container2, int position) {
	   
	      /*
	      TextView textView = new TextView(swipe_image_lock.this);
	      textView.setTextColor(Color.WHITE);
	      textView.setTextSize(30);
	      textView.setTypeface(Typeface.DEFAULT_BOLD);
	      textView.setText(String.valueOf(position));
	      */
	//container.setRotation(-90f);
/*
	      ImageView imageView = new ImageView(swipe_image_lock.this);
	      imageView.setImageResource(resa[position]);
	      LayoutParams imageParams = new LayoutParams(150,150);
	      imageView.setLayoutParams(imageParams);
	      
	      LinearLayout layout = new LinearLayout(swipe_image_lock.this);
	      layout.setOrientation(LinearLayout.VERTICAL);
	      LayoutParams layoutParams = new LayoutParams(150,150);
	      layout.setBackgroundColor(backgroundcolora[position]);
	      layout.setLayoutParams(layoutParams);
	      //layout.addView(textView);
	      layout.addView(imageView);
	      String s = "abc";
	      s = s.substring(s.length() - 1);
	      Toast.makeText(getApplicationContext(),"this is s : " + s, Toast.LENGTH_SHORT).show();
	      final int page = position;
	      layout.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Toast.makeText(swipe_image_lock.this, 
					      "Page " + page + " clicked", 
					      Toast.LENGTH_LONG).show();
				return false; 
			}
		});
	      /* layout.setOnClickListener(new OnClickListener(){

	    @Override
	    public void onClick(View v) {
	     Toast.makeText(swipe_image_lock.this, 
	      "Page " + page + " clicked", 
	      Toast.LENGTH_LONG).show();
	    }});
	      */
	      
	/*      container2.addView(layout);
	      return layout;
	  }

	  @Override
	  public void destroyItem(ViewGroup container2, int position, Object object) {
	   container2.removeView((LinearLayout)object);
	  }

	 }
 Picasso.with(this)
 .load(imgFile.getAbsoluteFile())
 .error(R.drawable.abc22)
 .into(imageView, new EmptyCallback() 
 {
	 Picasso.with(this)
 .load(currentUrl)
 .into(target);
 
 }*/
}
