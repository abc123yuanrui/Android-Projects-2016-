package com.universallock;

import adapter.color_adapter;
import adapter.text_size_adapter;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

public class Text_size_dialog extends Activity {

	public TextView txtView;
	private ListView list;
	private int[] aimg;
	private ListAdapter adapter;
	private String[] cat, desc;
	public static int p;
	public static  int p1,p2,p3,p4;
	private int pp1,pp2,pp3,pp4,progress;
	public static final String MyPREFERENCES = "MyUserChoice";
	public static SharedPreferences sharedPreferences = null;
	private TextView tv;
	private LinearLayout ll;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_size_changer);
        
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
		cat = new String[] {"Date","Clock","Unlock text","Pin / Small galary title text"};
	    aimg = new int[] { R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow};
	   
	    
		 sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE); 
				 
		    //ll = (LinearLayout)findViewById(R.id.settings_ll);
		 
		    list = ((ListView)findViewById(R.id.text_size_hanger_list));
		    adapter = new text_size_adapter(Text_size_dialog.this,cat, aimg);    
		    list.setAdapter(this.adapter);

		    list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					if(position == 0){
						pp1 = position;
						ShowDialog();
					}
					if(position == 1){
						pp1 = position;
						ShowDialog();
					}
					if(position == 2){
						pp1 = position;
						ShowDialog();
					}
					if(position == 3){
						pp1 = position;
						ShowDialog();
					}
				}
			});
        
        
	}
	
	public void ShowDialog()
	{
		
		p1 = sharedPreferences.getInt("prog1", 0);p2 = sharedPreferences.getInt("prog2", 0);
		p3 = sharedPreferences.getInt("prog3", 0);p4 = sharedPreferences.getInt("prog4", 0);
		final AlertDialog.Builder popDialog = new AlertDialog.Builder(this);
		 ll = new LinearLayout(this);
		 ll.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		ll.setOrientation(LinearLayout.VERTICAL);		
		SeekBar seek = new SeekBar(this);
		seek.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT , 70));
		
		seek.setMax(100);
		
		  tv = new TextView(this);
		  tv.setGravity(Gravity.CENTER_HORIZONTAL);
		  tv.setTextSize(32);
		p1 = sharedPreferences.getInt("prog1", 0);
		if(pp1 == 0) tv.setText("Date size : "+Integer.toString(p1));seek.setProgress(p1); if(pp1 == 1) tv.setText("Clock size : "+Integer.toString(p2));seek.setProgress(p2);
		if(pp1 == 2) tv.setText("unlock text size : "+Integer.toString(p3));seek.setProgress(p3); if(pp1 == 3) tv.setText("pin / Small gallery text size : "+Integer.toString(p4));seek.setProgress(p4);
		
		
		popDialog.setIcon(android.R.drawable.btn_star_big_on);
				
		ll.addView(tv);
		ll.addView(seek);
		
		
		popDialog.setView(ll);
		
		
		
		seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
		        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
		            //Do something here with new value
		        	
		        	if(pp1 == 0){		        			
		        		

		        			p1 = sharedPreferences.getInt("prog1", 0);
		        			
		        			if(fromUser){
				        		sharedPreferences.edit().putInt("prog1", progress).commit();
		        				tv.setText("Date size : "+Integer.toString(progress));
		        			}
		        		
		        	}
		        	if(pp1 == 1){		        			
		        		
	        			p2 = sharedPreferences.getInt("prog2", 0);
	        			popDialog.setTitle("clock size ");
	         			if(fromUser){
	         				sharedPreferences.edit().putInt("prog2", progress).commit();
	        				tv.setText("Clock size : "+Integer.toString(progress));
	        			}
	        			
	        	}
		        	if(pp1 == 2){		        			
	        			p3 = sharedPreferences.getInt("prog3", 0);
	        			
	         			if(fromUser){
	         				sharedPreferences.edit().putInt("prog3", progress).commit();
	        				tv.setText("Unlock text size : "+Integer.toString(progress));
	        			}
	        			
	        	}
		        	if(pp1 == 3){		        			
		        		
	        			p4 = sharedPreferences.getInt("prog4", 0);
	         			if(fromUser){
	         				sharedPreferences.edit().putInt("prog4", progress).commit();
	        				tv.setText("Pin / Small gallery text size : "+Integer.toString(progress));
	        			}
	        			
	        	}
		        	
		        }

				public void onStartTrackingTouch(SeekBar arg0) {
					// TODO Auto-generated method stub
					
				}

				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
		    });
		
 

		// Button OK
		popDialog.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						
					}

				});


		popDialog.create();
		popDialog.show();
        
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
	  public void onBackPressed(){
	  	finish();
	  	overridePendingTransition(R.anim.right_out,R.anim.right_in);
	  	super.onBackPressed();
	  }

}
