package com.universallock;

import adapter.screen_time_out_adapter;
import receiver.lockScreenReeiver;
import adapter.slidelockadapter;
import adapter.unlock_animation_interface;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.hardware.camera2.CaptureResult.Key;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.StaticLayout;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
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
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class screen_time_out extends Activity implements unlock_animation_interface
{
	public static SharedPreferences sharedPreferences = null;
	public static final String MyPREFERENCES = "screen_time_out";
	public static final String MyPREFERENCESS = "screen_time_out_choice";
	private static final String PREFS_NAME = null;
	private static final Context c = null;
	private static final String key = null;
	private static String pin1 = null;
  Button clearAll;
  Button getChoice;
  ListView myList;
  screen_time_out_adapter adapter;
  ArrayList<String> selectedItems = new ArrayList();
  private SharedPreferences sharedpreferences;  
  private static String value;
  private static String pin;
  private String sgv;
  private String pin_verify_ok;
  private String shake_or_swipe;
  private String pos,p1;
  private int pos2;
  public static int pt;
  private int b1,b2,b3,b4,b5,b6,b7,b8,b9;
  private int[] aray;
  public static int milliseconds,time;
	long timeInMilliseconds = 0L;
	long timeSwapBuff = 0L;
	long updatedTime = 0L;
	private long startTime = 0L;
	private Handler customHandler = new Handler();
	private Context context;
	private AlarmManager alarm;	
	private Calendar calendar;
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.slidelock);
    //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    
   //Toast.makeText(getApplicationContext(), "THis is Data "+ data, Toast.LENGTH_SHORT).show();
    
    myList = ((ListView)findViewById(R.id.sdl_lv));
    
    //pin = getPreference(c, key);
            
    
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
    String [] name = new String[] {"Default","0s" ,"3s","5s","15s","30s","1m"}; 
    
    int [] aimg = new int[] {R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow,
    						R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow}; 
   // ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.slide_type),getResources().getIntArray(R.drawable.right_arrow));
    
    int [] cbi = new int[] {R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check
    		,R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check};
    myList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);    
    adapter = new screen_time_out_adapter(this, name, aimg, cbi,this);
    myList.setAdapter(adapter);

    myList.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			
			switch(position){
			case 0:
				//position++;
				time = 30000;
				android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);				
				pt = position;
				Intent b = new Intent("my.action.string2");
				b.putExtra("stimeo", time);
				sendBroadcast(b);
				savePreferences("scree_time_out", pt);
				Intent i = new Intent();
				i.putExtra("pt", pt);
				i.putExtra("time", time);
				setResult(RESULT_OK, i);
				finish();
				
			case 1:
				//position++;
				time = 0000;
				android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);
				pt = position;
				savePreferences("scree_time_out", pt);
				Intent b1 = new Intent("my.action.string2");
				b1.putExtra("stimeo", time);
				sendBroadcast(b1);
				Intent i1 = new Intent();
				i1.putExtra("pt", pt);
				i1.putExtra("time", time);
				setResult(RESULT_OK, i1);
				finish();
				if(android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time)){
					
				}
				break;
			case 2:
				//position++;
				time = 3000;
				android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);				
				pt = position;
				savePreferences("scree_time_out", pt);
				Intent b2 = new Intent("my.action.string2");
				b2.putExtra("stimeo", time);
				sendBroadcast(b2);
				Intent i2 = new Intent();
				i2.putExtra("pt", pt);
				i2.putExtra("time", time);
				setResult(RESULT_OK, i2);
				finish();
				break;
			case 3:
				//position++;
				time = 5000;
				android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);
				pt = position;
				savePreferences("scree_time_out", pt);
				Intent b3 = new Intent("my.action.string2");
				b3.putExtra("stimeo", time);
				sendBroadcast(b3);
				Intent i3 = new Intent();
				i3.putExtra("pt", pt);
				i3.putExtra("time", time);
				setResult(RESULT_OK, i3);
				finish();
				break;
			case 4:
				//position++;
				time = 15000;
				android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);
				pt = position;
				savePreferences("scree_time_out", pt);
				Intent b4 = new Intent("my.action.string2");
				b4.putExtra("stimeo", time);
				sendBroadcast(b4);
				Intent i4 = new Intent();
				i4.putExtra("pt", pt);
				i4.putExtra("time", time);
				setResult(RESULT_OK, i4);
				finish();
				break;
			case 5:
				//position++;
				time = 30000;
				android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);
				pt = position;
				savePreferences("scree_time_out", pt);
				Intent b5 = new Intent("my.action.string2");
				b5.putExtra("stimeo", time);
				sendBroadcast(b5);
				Intent i5 = new Intent();
				i5.putExtra("pt", pt);
				i5.putExtra("time", time);
				setResult(RESULT_OK, i5);
				finish();
				break;
			case 6:
				//position++;
				time = 60000;
				android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);
				pt = position;
				savePreferences("scree_time_out", pt);
				Intent b6 = new Intent("my.action.string2");
				b6.putExtra("stimeo", time);
				sendBroadcast(b6);
				Intent i6 = new Intent();
				i6.putExtra("pt", pt);
				i6.putExtra("time", time);
				setResult(RESULT_OK, i6);
				finish();
				break;
			
			default:				
				time = 60000;
				android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);
			}
									
		}
	});
  }
      
  
  private void savePreferences(String key, String value) {
		
		sharedPreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
		Editor e = sharedPreferences.edit();
		e.putString(key, value);
		e.commit();
		
		
	}
	private void savePreferences(String key, int value) {

		sharedPreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
		Editor e = sharedPreferences.edit();
		e.putInt(key, value);
		e.commit();
		
	}
	

public void onBackPressed()
  {
    finish();
    overridePendingTransition(R.anim.right_out,R.anim.right_in);
  }
  
@Override
public void onDestroy(){
	//android.provider.Settings.System.putInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT, time);
	super.onDestroy();
}


@Override
public void setuapos(int pos) {
	// TODO Auto-generated method stub
}

@Override
public void setstopos(int pos2) {
	// TODO Auto-generated method stub
	
		savePreferences("screen_time_out_interface", pos2);
	
}
}