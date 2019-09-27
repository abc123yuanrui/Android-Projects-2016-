package com.universallock;

import adapter.display_item_adapter;
import adapter.display_item_interface;
import adapter.font_adapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class display_item_settings extends Activity {
	private LinearLayout ll;	
	private ListView list;
		private int[] aimg;
		private ListAdapter adapter;
		private String[] cat, desc;
		public static int p;
		public static  int p1,p2,p3,p4,p5,p6,p7,p8;
		public static final String MyPREFERENCES = "MyUserChoice";
		public static SharedPreferences sharedPreferences = null;
	@Override
	protected void onCreate(Bundle savedInstanceState){
	
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.display_item_settings);
		cat = new String[] {"Clock","Date","Camera","WiFi","batterty","Operator","Signal","Unlock Text"};
	    aimg = new int[] { R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow,
	    		R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow};
	    
		 sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

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
		 	//setdivalue(p1, p2, p3, p4, p5, p6, p7, p8);
		    list = ((ListView)findViewById(R.id.display_item_list));
		
		    adapter = new display_item_adapter(display_item_settings.this,cat, aimg);
		    
		    list.setAdapter(this.adapter);
		    list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent ,View view,
						int position, long id) {
					// TODO Auto-generated method stub
					if(position == 0){
				
						p1 = sharedPreferences.getInt("di_1", 0);
						updateItemAtPosition(position);
						
					}
					if(position == 1){
						
						p2 = sharedPreferences.getInt("di_2", 0);
						updateItemAtPosition(position);
					}
					if(position == 2){
						
						p3 = sharedPreferences.getInt("di_3", 0);
						updateItemAtPosition(position);
					}
					if(position == 3){
						
						p4 = sharedPreferences.getInt("di_4", 0);
						updateItemAtPosition(position);
					}
					if(position == 4){
						
						p5 = sharedPreferences.getInt("di_5", 0);
						updateItemAtPosition(position);
					}
					if(position == 5){
						
						p6 = sharedPreferences.getInt("di_6", 0);
						updateItemAtPosition(position);
					}
					if(position == 6){
						
						p7 = sharedPreferences.getInt("di_7", 0);
						updateItemAtPosition(position);
					}
					if(position == 7){
						p8 = sharedPreferences.getInt("di_8", 0);
						updateItemAtPosition(position);
					}
					
				}
			});
		    
	}

		   private void updateItemAtPosition(int position) {
		    int visiblePosition = list.getFirstVisiblePosition();
		    View view = list.getChildAt(position - visiblePosition);
		    list.getAdapter().getView(position, view, list);
		}

		

		
}
