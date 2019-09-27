package com.universallock;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import adapter.ListViewAdapter;
import adapter.SwitchInterface;
import adapter.swipe_image_select_adapter;
import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class swipe_image_select extends Activity {
	
  public static final String MyPREFERENCESS = "UserChoice";
  public static String Name = "None";
  public static final String Position = "position";
  private static SharedPreferences sharedPreferences = null;
  public static int lockname;
  private ListAdapter adapter;
  private int[] aimg;
  private String[] cat;
  private ListView list;
  private ComponentName mComponentName;
  private DevicePolicyManager mDevicePolicyManager;
  ListAdapter myadapter;
  ListView mylist;  
  private int posi;
  private SharedPreferences sharedpreferences;
  private int clickedRow;
  private Switch sw1;
  private String shake_or_swipe,pin_pass;
  private String pin_verify_ok;
  private int a1,a2,a3,a4,a5,a6,a7,a8,a9,s1,s2,s3,s4,s5,s6,s7,s8,s9;
  private String swipe_data,swipe_image_data;
  private Uri picUri1,picUri2,picUri3,picUri4,picUri5,picUri6,picUri7,picUri8,picUri9;
  private String imgDecodableString;
  private int CROP_PIC = 0,CROP_PIC1 = 11,CROP_PIC2 = 12,CROP_PIC3 = 13,CROP_PIC4 = 14,CROP_PIC5 = 15,
		  CROP_PIC6 = 16,CROP_PIC7 = 17,CROP_PIC8 = 18,CROP_PIC9 = 19;
  private String p1,p2,p3,p4,p5,p6,p7,p8,p9;
  private Bitmap b1,b2,b3,b4,b5,b6,b7,b8,b9;
  private int a,count;
  String filename;
  String ss1,ss2,ss3,ss4,ss5,ss6,ss7,ss8,ss9;
  File file;
  File[] listFile;
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.swipe_image_select);
    sharedpreferences = getSharedPreferences(MyPREFERENCESS, MODE_PRIVATE);
//
a = sharedpreferences.getInt("pass_adapter", 0);
filename = sharedpreferences.getString("passs_adapter", "");

    
    
    cat = new String[] { "select first image","select second image","select third image","select fourth image","select fifth image",
    		"select sixth image","select seventh image","select eight image","select nineth image"};
    aimg = new int[] { R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, 
    		R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, 
    		R.drawable.right_arrow};
	 
	 sharedPreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
	
	 //ArrayList<String> f = new ArrayList<String>();   // list of available files in  path
	

	   
	file= new File(android.os.Environment.getExternalStorageDirectory(),"lock_images");
	
	
	    if (file.isDirectory())
	    {
	        listFile = file.listFiles();


	        for (int i = 0; i < listFile.length; i++)
	        {
	        	ss1 = file + filename;
	        	//Uri uri = ss1;
	//            f.add(listFile[i].getAbsolutePath());
	 //           Toast.makeText(getApplicationContext(), "file : "+f, Toast.LENGTH_SHORT).show();
	            

	        }
	 }	 

		if(file.isDirectory()){
			listFile = file.listFiles();
			if(listFile.length > 0){
				int j = listFile.length -9;
				ss1 = listFile[j].getAbsolutePath();
				sharedpreferences.edit().putString("path", ss1);
				//Toast.makeText(getApplicationContext(), "ss1 : "+ss1, Toast.LENGTH_SHORT).show();
			
			}
			if(listFile.length > 1){
				int j = listFile.length - 8;
				ss2 = listFile[j].getAbsolutePath();
				//Toast.makeText(getApplicationContext(), "ss2 : "+ss2, Toast.LENGTH_SHORT).show();
			
			}
			if(listFile.length > 2){
				int j = listFile.length - 7;
				ss3 = listFile[j].getAbsolutePath();
				//Toast.makeText(getApplicationContext(), "ss3 : "+ss3, Toast.LENGTH_SHORT).show();
			
			}
			if(listFile.length > 3){
				int j = listFile.length - 6;
				ss4 = listFile[j].getAbsolutePath();
				//Toast.makeText(getApplicationContext(), "ss4 : "+ss4, Toast.LENGTH_SHORT).show();
			
			}
			if(listFile.length >   2){
				int j = listFile.length - 5;
				ss5 = listFile[j].getAbsolutePath();
				//Toast.makeText(getApplicationContext(), "ss5 : "+ss5, Toast.LENGTH_SHORT).show();
			
			}
			if(listFile.length > 2){
				int j = listFile.length - 4;
				ss6 = listFile[j].getAbsolutePath();
				//Toast.makeText(getApplicationContext(), "ss6 : "+ss6, Toast.LENGTH_SHORT).show();
			    
			}
			if(listFile.length > 2){
				int j = listFile.length - 3;
				ss7 = listFile[j].getAbsolutePath();
			//	Toast.makeText(getApplicationContext(), "ss7 : "+ss7, Toast.LENGTH_SHORT).show();
			
			}
			if(listFile.length > 2){
				int j = listFile.length - 2;
				ss8 = listFile[j].getAbsolutePath();
		//		Toast.makeText(getApplicationContext(), "ss8 : "+ss8, Toast.LENGTH_SHORT).show();
			
			}
			if(listFile.length > 9){
				int j = listFile.length - 1;
				ss9 = listFile[j].getAbsolutePath();
	//			Toast.makeText(getApplicationContext(), "ss9 : "+ss9, Toast.LENGTH_SHORT).show();
			
			}
			
			
		}
	
	 list = ((ListView)findViewById(R.id.swipe_image_list));
    adapter = new swipe_image_select_adapter(swipe_image_select.this,cat, aimg);
    list.setAdapter(this.adapter);
    
    
    list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      
	public void onItemClick(AdapterView<?> parent, View v, final int position, long id)
      {
		
        if (position == 0)
        {
        	//ss1 = sharedpreferences.getString("path", ss1);
        	Intent galleryIntent = new Intent(swipe_image_select.this,crop_image.class);
        	galleryIntent.putExtra("val", 9);
        	galleryIntent.putExtra("str", ss1);
    		startActivityForResult(galleryIntent, 1);
        	
        }
        if (position == 1)
        {
        	Intent galleryIntent = new Intent(swipe_image_select.this,crop_image.class);
        	galleryIntent.putExtra("val", 8);
        	galleryIntent.putExtra("str", ss2);
    		startActivityForResult(galleryIntent, 2);
        }
                 
        if (position == 2)
        {
        	Intent galleryIntent = new Intent(swipe_image_select.this,crop_image.class);
        	galleryIntent.putExtra("val", 7);
        	galleryIntent.putExtra("str", ss3);
    		startActivityForResult(galleryIntent, 3);
        }
        
        if (position == 3)
          {
        	Intent galleryIntent = new Intent(swipe_image_select.this,crop_image.class);
        	galleryIntent.putExtra("val", 6);
        	galleryIntent.putExtra("str", ss4);
    		startActivityForResult(galleryIntent, 4);
          }
          if (position == 4)
          {
        	  Intent galleryIntent = new Intent(swipe_image_select.this,crop_image.class);
        	  galleryIntent.putExtra("val", 5);
      		startActivityForResult(galleryIntent, 5);
          }
          if (position == 5)
          {
        	  Intent galleryIntent = new Intent(swipe_image_select.this,crop_image.class);
        	  galleryIntent.putExtra("val", 4);
      		startActivityForResult(galleryIntent, 6);
          }
          if (position == 6)
          {
        	  Intent galleryIntent = new Intent(swipe_image_select.this,crop_image.class);
        	  galleryIntent.putExtra("val", 3);
      		startActivityForResult(galleryIntent, 7);
          }
          if (position == 7)
          {
        	  Intent galleryIntent = new Intent(swipe_image_select.this,crop_image.class);
        	  galleryIntent.putExtra("val", 2);
      		startActivityForResult(galleryIntent, 8);
          }
          if (position == 8)
          {
        	  Intent galleryIntent = new Intent(swipe_image_select.this,crop_image.class);
        	  galleryIntent.putExtra("val", 1);
      		startActivityForResult(galleryIntent, 9);
          }
      }
    });
  }
  
  
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
	sharedpreferences = getSharedPreferences(MyPREFERENCESS, MODE_PRIVATE);
			// When an Image is picked
			if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
				
				// Get the Image from data
				Bundle extras = data.getExtras();
					
				b1 = extras.getParcelable("bitmap");
				
				Toast.makeText(getApplicationContext(), "--00--- : "+b1, Toast.LENGTH_SHORT).show();
				ImageView i = (ImageView)findViewById(R.id.image_check);
				i.setImageBitmap(b1);
				
				int ijk = extras.getInt("value_pass", 0);				
			    String filename = extras.getString("file_name");
			    sharedpreferences.edit().putInt("pass_adapter", ijk).commit();
			    sharedpreferences.edit().putString("passs_adapter", filename).commit();
			    if(ijk != 0){
			    	Intent il = new Intent(this,swipe_image_select.class);
			    	finish();
			    	startActivity(il);
			    }
			    
			    
			    Toast.makeText(getApplicationContext(), "ijk : "+ijk +", "+"filename : "+filename, Toast.LENGTH_SHORT).show();
				
			}				

			if (requestCode == 2 && resultCode == RESULT_OK && null != data) {
				// Get the Image from data
				Bundle extras = data.getExtras();
				b2 = extras.getParcelable("bitmap");
				Toast.makeText(getApplicationContext(), "--00--- : "+b3, Toast.LENGTH_SHORT).show();
				ImageView i = (ImageView)findViewById(R.id.image_check);
				i.setImageBitmap(b2);				
			}				
			
			if (requestCode == 3 && resultCode == RESULT_OK && null != data) {
				// Get the Image from data
				
				Bundle extras = data.getExtras();
				b3 = extras.getParcelable("bitmap");
				Toast.makeText(getApplicationContext(), "--00--- : "+b4, Toast.LENGTH_SHORT).show();
				ImageView i = (ImageView)findViewById(R.id.image_check);
				i.setImageBitmap(b3);
			}
			if (requestCode == 4 && resultCode == RESULT_OK && null != data) {
				Bundle extras = data.getExtras();
				b4 = extras.getParcelable("bitmap");
				Toast.makeText(getApplicationContext(), "--00--- : "+b4, Toast.LENGTH_SHORT).show();
				ImageView i = (ImageView)findViewById(R.id.image_check);
				i.setImageBitmap(b4);
				
			}
			if (requestCode == 5 && resultCode == RESULT_OK && null != data) {
				Bundle extras = data.getExtras();
				b5 = extras.getParcelable("bitmap");
				Toast.makeText(getApplicationContext(), "--00--- : "+b5, Toast.LENGTH_SHORT).show();
				ImageView i = (ImageView)findViewById(R.id.image_check);
				i.setImageBitmap(b5);
				
			}
			if (requestCode == 6 && resultCode == RESULT_OK && null != data) {
				Bundle extras = data.getExtras();
				b6 = extras.getParcelable("bitmap");
				Toast.makeText(getApplicationContext(), "--00--- : "+b6, Toast.LENGTH_SHORT).show();
				ImageView i = (ImageView)findViewById(R.id.image_check);
				i.setImageBitmap(b6);
				
			}
			if (requestCode == 7 && resultCode == RESULT_OK && null != data) {
				Bundle extras = data.getExtras();
				b7 = extras.getParcelable("bitmap");
				Toast.makeText(getApplicationContext(), "--00--- : "+b7, Toast.LENGTH_SHORT).show();
				ImageView i = (ImageView)findViewById(R.id.image_check);
				i.setImageBitmap(b7);
				
			}
			if (requestCode == 8 && resultCode == RESULT_OK && null != data) {
				Bundle extras = data.getExtras();
				b8 = extras.getParcelable("bitmap");
				Toast.makeText(getApplicationContext(), "--00--- : "+b8, Toast.LENGTH_SHORT).show();
				ImageView i = (ImageView)findViewById(R.id.image_check);
				i.setImageBitmap(b8);
				
			}
			if (requestCode == 9 && resultCode == RESULT_OK && null != data) {
				// Get the Image from data
				Bundle extras = data.getExtras();
				b9 = extras.getParcelable("bitmap");
				Toast.makeText(getApplicationContext(), "--00--- : "+b9, Toast.LENGTH_SHORT).show();
				ImageView i = (ImageView)findViewById(R.id.image_check);
				i.setImageBitmap(b9);
			}
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

@Override
public void onResume(){
	
	  super.onResume();
}
@Override
public void onBackPressed()
  {
    finish();
    overridePendingTransition(R.anim.right_out,R.anim.right_in);
  }
  
  public void onClick(View paramView) {}
  
  
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onHomePressed()
  {
    return false;
  }
  

  
  public boolean onKeyDown(int KeyCode, KeyEvent Event)
  {
    if ((KeyCode == 25) || (KeyCode == 26) || (KeyCode == 24) || (KeyCode == 27)) {}
    while ((KeyCode == 82) || (KeyCode == 3) || (KeyCode == 84) || (KeyCode == 176)) {
      return false;
    }
    return super.onKeyDown(KeyCode, Event);
  }


}


