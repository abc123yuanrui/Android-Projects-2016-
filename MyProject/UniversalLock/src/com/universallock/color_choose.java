package com.universallock;

import com.universallock.color_picker.OnColorChangedListener;

import adapter.color_adapter;
import adapter.settings_adpater;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class color_choose extends Activity{
	private LinearLayout ll;	
	private ListView list;
		private int[] aimg;
		private ListAdapter adapter;
		private String[] cat, desc;
		public static int p;
		public static  int p1,p2,p3,p4,p5,p6,p7,p8;
		public static final String MyPREFERENCES = "MyUserChoice";
		public static SharedPreferences sharedpreferences = null;
	@Override
	protected void onCreate(Bundle savedInstanceState){
	
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.color_choose);
		
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
		cat = new String[] {"Operator Name","Battery percentage","Clock","Date","Notification","Unlock Text","Pin number","Pin / Samall gallery Text"};
	    aimg = new int[] { R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow,
	    		R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow};
	    //desc = new String[] {"","","shake or swipe","","","None","Default","Default","none","None","","","","","","",""};
		 sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		    //ll = (LinearLayout)findViewById(R.id.settings_ll);
		 
		    list = ((ListView)findViewById(R.id.color_choose_ll));
		    adapter = new color_adapter(color_choose.this,cat, aimg);    
		    list.setAdapter(this.adapter);
		    list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent ,View view,
						int position, long id) {
					// TODO Auto-generated method stub
					if(position == 0){
						p = position;
						color_picker cp1=new color_picker(color_choose.this, listener, 0);  
						cp1.show(); 
						if(p1 != 0){
							updateItemAtPosition(p);
						}
					}
					if(position == 1){
						p = position;
						color_picker cp2=new color_picker(color_choose.this, listener, 0);  
						cp2.show();
					}
					if(position == 2){
						p = position;
						color_picker cp3=new color_picker(color_choose.this, listener, 0);  
						cp3.show();
					}
					if(position == 3){
						p = position;
						color_picker cp4=new color_picker(color_choose.this, listener, 0);  
						cp4.show();
					}
					if(position == 4){
						p = position;
						color_picker cp5=new color_picker(color_choose.this, listener, 0);  
						cp5.show();
					}
					if(position == 5){
						p = position;
						color_picker cp6=new color_picker(color_choose.this, listener, 0);  
						cp6.show();
					}
					if(position == 6){
						p = position;
						color_picker cp7=new color_picker(color_choose.this, listener, 0);  
						cp7.show();
					}
					if(position == 7){
						p = position;
						color_picker cp8=new color_picker(color_choose.this, listener, 0);  
						cp8.show();
					}
				}
			});
		    
	}

	OnColorChangedListener listener=new OnColorChangedListener() {  
	       @Override  
	       public void colorChanged(int color) {  
	    	   
	    	   
	         Toast.makeText(color_choose.this, ""+color, Toast.LENGTH_LONG).show();
	         if(p == 0) {p1 = color; sharedpreferences.edit().putInt("p1", p1).commit(); updateItemAtPosition(p);
	         finish(); overridePendingTransition(R.anim.right_out,R.anim.right_in);}
	         if(p == 1) {p2 = color; sharedpreferences.edit().putInt("p2", p2).commit(); updateItemAtPosition(p);
	         finish(); overridePendingTransition(R.anim.right_out,R.anim.right_in);}
	         if(p == 2) {p3 = color; sharedpreferences.edit().putInt("p3", p3).commit(); updateItemAtPosition(p);
	         finish(); overridePendingTransition(R.anim.right_out,R.anim.right_in);} 
	         if(p == 3) {p4 = color; sharedpreferences.edit().putInt("p4", p4).commit(); updateItemAtPosition(p);
	         finish(); overridePendingTransition(R.anim.right_out,R.anim.right_in);}
	         if(p == 4) {p5 = color; sharedpreferences.edit().putInt("p5", p5).commit(); updateItemAtPosition(p);
	         finish(); overridePendingTransition(R.anim.right_out,R.anim.right_in);}
	         if(p == 5) {p6 = color; sharedpreferences.edit().putInt("p6", p6).commit(); updateItemAtPosition(p);
	         finish(); overridePendingTransition(R.anim.right_out,R.anim.right_in);}
	         if(p == 6) {p7 = color; sharedpreferences.edit().putInt("p7", p7).commit(); updateItemAtPosition(p);
	         finish(); overridePendingTransition(R.anim.right_out,R.anim.right_in);}
	         if(p == 7) {p8 = color; sharedpreferences.edit().putInt("p8", p8).commit(); updateItemAtPosition(p);
	         finish(); overridePendingTransition(R.anim.right_out,R.anim.right_in);}
	         
	         //ll.setBackgroundColor(ColorAh);
	       }  
	     };  
	   private int ColorAh = Color.BLACK;  

	   @Override  
	   protected void onResume() {  
	     super.onResume();  
	     //ll.setBackgroundColor(ColorAh);  
	   }  
	   private void updateItemAtPosition(int position) {
		    int visiblePosition = list.getFirstVisiblePosition();
		    View view = list.getChildAt(position - visiblePosition);
		    list.getAdapter().getView(position, view, list);
		}
	   
	   @Override
	   public void onBackPressed(){
	   	finish();
	   	overridePendingTransition(R.anim.right_out,R.anim.right_in);
	   	super.onBackPressed();
	   }	   
}
