package com.universallock;

import adapter.slidelockadapter;
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
import android.text.StaticLayout;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
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

public class selectlocktype extends Activity
{
  public static final String MyPREFERENCES = "MyUserChoice";
private static final String PREFS_NAME = null;
private static final Context c = null;
private static final String key = null;
private static String pin1 = null;
  Button clearAll;
  Button getChoice;
  ListView myList;
  ListAdapter adapter;
  ArrayList<String> selectedItems = new ArrayList();
  SharedPreferences sharedpreferences;  
  private static String value;
  private static String pin;
  private String sgv;
  private String pin_verify_ok;
  private String shake_or_swipe;
  private String pos,p1;
  private int pos2;
  private int b1,b2,b3,b4,b5,b6,b7,b8,b9;
  private int[] aray;
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.slidelock);
    
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
    int data = dta.getInt("pos",0);
    
    	//int data1 = getIntent().getIntExtra("pin_verify_ok",0);
    	
    	//p1 = ""+data;
    //Toast.makeText(getApplicationContext(),"this is pin :"+ pin + "this is Data : " + data, Toast.LENGTH_SHORT).show();
    
    Toast.makeText(getApplicationContext(), "THis is Data "+ data, Toast.LENGTH_SHORT).show();
    
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
	Editor editor = sharedPreferences.edit();
    editor.putInt("pos1", data);
    //editor.putInt("pos1", data1);
    editor.commit();
    
    
    myList = ((ListView)findViewById(R.id.sdl_lv));
    
    //pin = getPreference(c, key);
            
    
    String [] name = new String[] {"None" ,"Pin Lock","Small galary lock"}; 
    
    int [] aimg = new int[] {R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow}; 
   // ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.slide_type),getResources().getIntArray(R.drawable.right_arrow));
    
    int [] cbi = new int[] {R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check};
    myList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);    
    adapter = new slidelockadapter(this, name, aimg, cbi);
    myList.setAdapter(adapter);

  
     if(shake_or_swipe != null){
    	
    	sharedpreferences.edit().remove(pin).commit();
    	sharedpreferences.edit().remove(pin1).commit();
    	savePreferences("lock_name", shake_or_swipe);
    	
    	
    }else if(pin != null){
    	
    	sharedpreferences.edit().remove(shake_or_swipe).commit();
    	savePreferences("lock_name", pin);
    	
    } 
    
    myList.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			
			// TODO Auto-generated method stub
			//int i = (int) myList.getItemAtPosition(position);
			if(position == 0 ){
				
				//sharedPreferences.edit().remove("pin_password").commit();
				//sharedPreferences.edit().remove("pin_verify_ok").commit();
				//savePreferences("shake_or_swipe", "111");
				Intent i = new Intent();
				//String s = "111";
				i.putExtra("value_of_p", 1);
				setResult(RESULT_OK, i);				
				finish();
				overridePendingTransition(R.anim.right_out,R.anim.right_in);
				
			}
			if(position == 1){
				
				Intent i = new Intent(selectlocktype.this, pin.class);
				startActivityForResult(i, 1);
				selectlocktype.this.overridePendingTransition(R.anim.left_in,R.anim.left_out);
				
				String str = "second";
				Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
			}
			if(position == 2){
			try{
				Intent i  = new Intent(selectlocktype.this, swipe_image_lock_set.class);
				startActivityForResult(i,2);
				selectlocktype.this.overridePendingTransition(R.anim.left_in,R.anim.left_out);
			}catch(Exception e){
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), "erroe  is "+e, Toast.LENGTH_SHORT).show();
			}
			}
			
		}
	});
  }
      
  @Override
protected void  onActivityResult(int requestCode, int resultCode, Intent data) {

	    if (requestCode == 1) {
	         if(resultCode == RESULT_OK){
	         	
	        	 sgv=data.getStringExtra("pin_password");
	         // pin = sgv;
	          //Toast.makeText(getApplicationContext()," selecttype pin lock :"+ pin, Toast.LENGTH_SHORT).show();
	          //savePreferences("pin_password", pin);
	          if(sgv != null){
	        	  Intent i = new Intent();
					i.putExtra("value_of_p", 2);
					setResult(RESULT_OK, i);				
					finish();
					overridePendingTransition(R.anim.right_out,R.anim.right_in);	        	  
	          }
	         }
	}
	    
	    if(requestCode == 2){
		 if(resultCode == RESULT_OK){		
			 Bundle a = data.getExtras();
			int d = a.getInt("ab_Data");
			
			if(d != 0){
					Intent i = new Intent();
					i.putExtra("value_of_p",3);					
					setResult(RESULT_OK, i);				
					finish();
					overridePendingTransition(R.anim.right_out,R.anim.right_in);
			}		
			 
		 }
	 } 
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