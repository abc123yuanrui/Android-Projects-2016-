package com.universallock;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class lockscreen extends Activity{

	String pageData[];	//Stores the text to swipe.
	LayoutInflater inflater;	//Used to create individual pages
	ViewPager vp;	//Reference to class to swipe views
	
	@Override
	 public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		//this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG|WindowManager.LayoutParams.FLAG_FULLSCREEN);

         super.onAttachedToWindow();
	 }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
 	   getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_FULLSCREEN);
 	   
		setContentView(R.layout.lockscreen);
		//Get the data to be swiped through
		//pageData=getResources().getStringArray(R.array.desserts);
		//get an inflater to be used to create single pages
		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//Reference ViewPager defined in activity
		vp=(ViewPager)findViewById(R.id.myviewpager1);
		//set the adapter that will create the individual pages
		vp.setAdapter(new MyPagesAdapter());
	}
	//Implement PagerAdapter Class to handle individual page creation
	class MyPagesAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			//Return total pages, here one for each data item
			return 1;
		}
		//Create the given page (indicated by position)
		@Override
	    public Object instantiateItem(ViewGroup container, int position) {
	        View page = inflater.inflate(R.layout.password_main, null);
	        //((TextView)page.findViewById(R.id.textMessage)).setText(pageData[position]);
	        //Add the page to the front of the queue
			((ViewPager) container).addView(page, 0);
			return page;
		}
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			//See if object from instantiateItem is related to the given view
			//required by API
			return arg0==(View)arg1;
		}
		@Override
	    public void destroyItem(ViewGroup container, int position, Object object) {
	      ((ViewPager) container).removeView((View) object);
	      object=null;
	    }
		
	}
	
}