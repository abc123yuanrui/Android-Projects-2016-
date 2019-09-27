package com.universallock;

import adapter.screen_lock_delay_adapter;
import adapter.screen_time_out_adapter;
import adapter.slidelockadapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.hardware.camera2.CaptureResult.Key;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.StaticLayout;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class screen_lock_delay extends Activity
{
  public static final String MyPREFERENCES = "screen_lock_delay";
private static final String PREFS_NAME = null;
private static final Context c = null;
private static final String key = null;
private static String pin1 = null;
  Button clearAll;
  Button getChoice;
  ListView myList;
  screen_lock_delay_adapter adapter;
  ArrayList<String> selectedItems = new ArrayList();
  SharedPreferences sharedpreferences;  
  private static String value;
  private static String pin;
  private String sgv;
  private String pin_verify_ok;
  private String shake_or_swipe;
  private String pos,p1;
  private int pos2,pt,time;
  private int b1,b2,b3,b4,b5,b6,b7,b8,b9;
  private int[] aray;
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.slidelock);
    //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    
    Bundle dta = getIntent().getExtras();
    
    int data = dta.getInt("screenlockdelay",0);
    
    
   Toast.makeText(getApplicationContext(), "THis is Data "+ data, Toast.LENGTH_SHORT).show();
    
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);	
	Editor editor = sharedpreferences.edit();
    editor.putInt("pta", data);
    editor.commit();
    
    
    myList = ((ListView)findViewById(R.id.sdl_lv));
    
    //pin = getPreference(c, key);
            
    
    String [] name = new String[] {"Default","0s" ,"3s","5s","15s","30s","1m"}; 
    
    int [] aimg = new int[] {R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow,
    						R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow}; 
   // ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.slide_type),getResources().getIntArray(R.drawable.right_arrow));
    
    int [] cbi = new int[] {R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check
    		,R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check};
    myList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);    
    
    adapter = new screen_lock_delay_adapter(this, name, aimg, cbi);
    myList.setAdapter(adapter);

  
    
         
    myList.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			
			
			switch(position){
			case 0:
				time = -1;
				Intent i = new Intent();
				pt = position;
				i.putExtra("pt", pt);
				i.putExtra("screen_to", time);
				setResult(RESULT_OK, i);
				finish();
				
			case 1:
				time = 000;
				Intent i1 = new Intent();
				pt = position;
				i1.putExtra("pt", pt);
				i1.putExtra("screen_to", time);
				setResult(RESULT_OK, i1);
				finish();
				
				break;
			case 2:
				time = 3000;
				Intent i2 = new Intent();
				pt = position;
				i2.putExtra("pt", pt);
				i2.putExtra("screen_to", time);
				setResult(RESULT_OK, i2);
				finish();
				break;
			case 3:
				time = 5000;
				Intent i3 = new Intent();
				pt = position;
				i3.putExtra("pt", pt);
				i3.putExtra("screen_to", time);
				setResult(RESULT_OK, i3);
				finish();
				break;
			case 4:
				time = 10000;
				Intent i7 = new Intent();
				pt = position;
				i7.putExtra("pt", pt);
				i7.putExtra("screen_to", time);
				setResult(RESULT_OK, i7);
				finish();
				break;
			case 5:
				time = 15000;				
				Intent i4 = new Intent();
				pt = position;
				i4.putExtra("pt", pt);
				i4.putExtra("screen_to", time);
				setResult(RESULT_OK, i4);
				finish();
				break;
			case 6:
				time = 30000;
				Intent i5 = new Intent();
				pt = position;
				i5.putExtra("pt", pt);
				i5.putExtra("screen_to", time);
				setResult(RESULT_OK, i5);
				finish();
				break;
			case 7:
				time = 60000;
				Intent i6 = new Intent();
				pt = position;
				i6.putExtra("pt", pt);
				i6.putExtra("screen_to", time);
				setResult(RESULT_OK, i6);
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
  

}