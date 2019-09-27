package com.universallock;

import adapter.slidelockadapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
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

public class slidelock extends Activity
{
  public static final String MyPREFERENCES = "MyUserChoice";
  Button clearAll;
  Button getChoice;
  ListView myList;
  ListAdapter adapter;
  ArrayList<String> selectedItems = new ArrayList();
  SharedPreferences sharedpreferences;  
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.slidelock);
    myList = ((ListView)findViewById(R.id.sdl_lv));
    
    String [] name = new String[] {"Shake or Swipe","Pin Lock","Image switch lock"}; 
    
    int [] aimg = new int[] {R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow}; 
   // ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.slide_type),getResources().getIntArray(R.drawable.right_arrow));
    
    int [] cbi = new int[] {R.drawable.lock_type_check_right,R.drawable.lock_type_check_right,R.drawable.lock_type_check_right};
    myList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);    
    adapter = new slidelockadapter(this, name, aimg, cbi);
    myList.setAdapter(adapter);
    
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    
    if (sharedpreferences.contains(MyPREFERENCES)) {
    
    }
    
    myList.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			// TODO Auto-generated method stub
			//int i = (int) myList.getItemAtPosition(position);
			if(position == 0 ){
				
				String str = "first";
				Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
			}
			if(position == 1){
				Intent i = new Intent(slidelock.this, pin.class);
				startActivityForResult(i, 1);
				slidelock.this.overridePendingTransition(R.anim.left_in,R.anim.left_out);
				
				
				String str = "second";
				Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
			}
			if(position == 2){
				String str = "third";
				Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
			}
			
		}
	});
  }
      
public void onBackPressed()
  {
    finish();
    overridePendingTransition(R.anim.left_in,R.anim.left_out);
  }
  

}