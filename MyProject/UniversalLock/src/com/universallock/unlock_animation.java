package com.universallock;

import adapter.screen_lock_delay_adapter;
import adapter.screen_time_out_adapter;
import adapter.slidelockadapter;
import adapter.unlock_animation_adapter;
import adapter.unlock_animation_interface;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.hardware.camera2.CaptureResult.Key;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.StaticLayout;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class unlock_animation extends Activity implements unlock_animation_interface
{
	public int uaiai;	
	public static int ua_pos;
  public static final String MyPREFERENCES = "ua_animation";
private static final String PREFS_NAME = null;
private static final Context c = null;
private static final String key = null;
private static String pin1 = null;
  Button clearAll;
  Button getChoice;
  ListView myList;
  unlock_animation_adapter adapter;
  ArrayList<String> selectedItems = new ArrayList();
public static  SharedPreferences sharedpreferences;  
  private static String value;
  private static String pin;
  private String sgv;
  private String pin_verify_ok;
  private String shake_or_swipe;
  private String pos,p1;
  private int pos2,pt,time;
  private int b1,b2,b3,b4,b5,b6,b7,b8,b9;
  public static int b;
  private int[] aray;
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.slidelock);
    //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    
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
    Bundle dta = getIntent().getExtras();
    
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);	

    b = sharedpreferences.getInt("ua_pos", 0);
    
    Toast.makeText(getApplicationContext(), "ua_pos"+b, Toast.LENGTH_SHORT).show();
    myList = ((ListView)findViewById(R.id.sdl_lv));
    
    //pin = getPreference(c, key);
            
    
    String [] name = new String[] {"none","Rotate","Fade","Zoom","Bounce","Blink"}; 
    
    int [] aimg = new int[] {R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow,
    						R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow}; 
   // ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.slide_type),getResources().getIntArray(R.drawable.right_arrow));
    
    int [] cbi = new int[] {R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check
    		,R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check};
    myList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);    
    
    adapter = new unlock_animation_adapter(this, name, aimg, cbi,this);
    myList.setAdapter(adapter);

  
    
         
    myList.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			
			
			switch(position){
			case 0:
				//position++;
				ua_pos = position;				
				sharedpreferences.edit().putInt("ua_pos", ua_pos).commit();
				b = sharedpreferences.getInt("ua_pos", 0);
				Intent i = new Intent();
				i.putExtra("uai", position);
				setResult(RESULT_OK,i);
				finish();
				
			case 1:
				//position++;
				ua_pos = position;
				
				sharedpreferences.edit().putInt("ua_pos", ua_pos).commit();
				b = sharedpreferences.getInt("ua_pos", 0);
				Intent i1 = new Intent();
				i1.putExtra("uai", position);
				setResult(RESULT_OK,i1);
				finish();
				
				break;
			case 2:
				//position++;
				ua_pos = position;
				
				sharedpreferences.edit().putInt("ua_pos", ua_pos).commit();
				b = sharedpreferences.getInt("ua_pos", 0);
				Intent i2 = new Intent();
				i2.putExtra("uai", position);
				setResult(RESULT_OK,i2);
				finish();
				break;
			case 3:
				//position++;
				ua_pos = position;
				
				sharedpreferences.edit().putInt("ua_pos", ua_pos).commit();
				b = sharedpreferences.getInt("ua_pos", 0);
				Intent i3 = new Intent();
				i3.putExtra("uai", position);
				setResult(RESULT_OK,i3);
				finish();
				break;
			case 4:
				//position++;
				ua_pos = position;				
				sharedpreferences.edit().putInt("ua_pos", ua_pos).commit();
				b = sharedpreferences.getInt("ua_pos", 0);
				Intent i4 = new Intent();
				i4.putExtra("uai", position);
				setResult(RESULT_OK,i4);
				finish();
				break;
			case 5:
				//position++;
				ua_pos = position;				
				sharedpreferences.edit().putInt("ua_pos", ua_pos).commit();
				b = sharedpreferences.getInt("ua_pos", 0);
				Intent i5 = new Intent();
				i5.putExtra("uai", position);
				setResult(RESULT_OK,i5);
				finish();
				break;
			
			default:				
			
			}
			//android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);
						
		}
	});
  }
      
  
  

	private void savePreferences(String key, String value) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.putString(key, value);
		editor.putString(key, value);
		editor.commit();
	}
	private void savePreferences(String key, int value) {
		SharedPreferences sharedPreferencesint = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferencesint.edit();
		editor.putInt(key, value);
		editor.putInt(key, value);
		editor.putInt(key, value);
		editor.commit();
	}
	
public void checklockype(){
	if(pin != null){
		
	}
}
public void onBackPressed()
  {
    finish();
    overridePendingTransition(R.anim.right_out,R.anim.right_in);
  }




@Override
public void setuapos(int pos) {
	// TODO Auto-generated method stub
		uaiai = pos;	
}
@Override
public void setstopos(int pos) {
	// TODO Auto-generated method stub
	
}
  

}