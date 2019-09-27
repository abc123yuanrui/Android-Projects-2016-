package com.universallock;


import adapter.font_adapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
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

public class font_chooser extends Activity{
	private LinearLayout ll;	
	private ListView list;
		private int[] aimg;
		private ListAdapter adapter;
		private String[] cat, desc;
		public static int p;
		public static  int p1,p2,p3,p4,p5,p6,p7,p8;
		public static String MyPREFERENCES = "MyUserChoice";
		public static SharedPreferences sharedpreferences;
		private Context context;
		private int posi;
		private String f1,f2,f3,f4;
	
	public void onCreate(Bundle savedInstanceState){
	
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.font_chooser);
		sharedpreferences = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
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
	    
	    if(f1 != null){
			sharedpreferences.edit().putString("f1", f1).commit();
		}else{
			sharedpreferences.edit().putString("f1", "fonts/f1.ttf").commit();
		}
	    if(f2 != null){
			sharedpreferences.edit().putString("f2", f2).commit();
		}else{
			sharedpreferences.edit().putString("f2", "fonts/f1.ttf").commit();
		}
	    if(f3 != null){
			sharedpreferences.edit().putString("f3", f3).commit();
		}else{
			sharedpreferences.edit().putString("f3", "fonts/f1.ttf").commit();
		}
	    if(f4 != null){
			sharedpreferences.edit().putString("f4", f4).commit();
		}else{
			sharedpreferences.edit().putString("f4", "fonts/f1.ttf").commit();
		}
	    
		cat = new String[] {"Clock","Date","Unlock text","Pin / Small gallery title"};
	    aimg = new int[] { R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow};

	    
		 
		    list = ((ListView)findViewById(R.id.font_chooser));
		    adapter = new font_adapter(font_chooser.this,cat, aimg);    
		    list.setAdapter(this.adapter);
		    list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent ,View view,
						int position, long id) {
					// TODO Auto-generated method stub
					if(position == 0){
    					 posi = position;
						 Intent i = new Intent(font_chooser.this,font_typeface_chooser.class);
						 i.putExtra("posi", position);
						 startActivityForResult(i,1);
						 overridePendingTransition(R.anim.left_in,R.anim.left_out);
					}
					if(position == 1){
						posi = position;
						Intent i = new Intent(font_chooser.this,font_typeface_chooser.class);
						 i.putExtra("posi", position);
						 startActivityForResult(i,2);
						 overridePendingTransition(R.anim.left_in,R.anim.left_out);
					}
					if(position == 2){
						posi = position;
						Intent i = new Intent(font_chooser.this,font_typeface_chooser.class);
						 i.putExtra("posi", position);
						 startActivityForResult(i,3);
						 overridePendingTransition(R.anim.left_in,R.anim.left_out);
						
					}
					if(position == 3){
						posi = position;
						Intent i = new Intent(font_chooser.this,font_typeface_chooser.class);
						 i.putExtra("posi", position);
						 startActivityForResult(i,4);
						 overridePendingTransition(R.anim.left_in,R.anim.left_out);
					}
					
				}
			});
		    
	}

		   private void updateItemAtPosition(int position) {
		    int visiblePosition = list.getFirstVisiblePosition();
		    View view = list.getChildAt(position - visiblePosition);
		    list.getAdapter().getView(position, view, list);
		}
		   
		  @Override
		  public void onActivityResult(int requestCode, int resultCode, Intent data) 
		  {
			
		    if(requestCode == 1){
		    	if(resultCode == RESULT_OK){
		    		 f1 = data.getStringExtra("p1_f1");
		    		if(f1 != null){
		    			sharedpreferences.edit().putString("f1", f1).commit();
		    		}else{
		    			sharedpreferences.edit().putString("f1", "fonts/f1.ttf").commit();
		    		}
		    		Toast.makeText(getApplicationContext(), "text : "+f1, Toast.LENGTH_SHORT).show();
		    		updateItemAtPosition(posi);
		    	}
		    }
		    if(requestCode == 2){
		    	if(resultCode == RESULT_OK){
		    		f2 = data.getStringExtra("p2_f2");
		    		if(f2 != null){
		    			sharedpreferences.edit().putString("f2", f2).commit();
		    		}else{
		    			sharedpreferences.edit().putString("f2", "fonts/f1.ttf").commit();
		    		}
		    		Toast.makeText(getApplicationContext(), "text : "+f2, Toast.LENGTH_SHORT).show();
		    		updateItemAtPosition(posi);
		    	}
		    }
		    if(requestCode == 3){
		    	if(resultCode == RESULT_OK){
		    		f3 = data.getStringExtra("p3_f3");
		    		if(f3 != null){
		    			sharedpreferences.edit().putString("f3", f3).commit();
		    		}else{
		    			sharedpreferences.edit().putString("f3", "fonts/f1.ttf").commit();
		    		}
		    		Toast.makeText(getApplicationContext(), "text : "+f3, Toast.LENGTH_SHORT).show();
		    		updateItemAtPosition(posi);
		    	}
		    }
		    if(requestCode == 4){
		    	if(resultCode == RESULT_OK){
		    		f4 = data.getStringExtra("p4_f4");
		    		if(f4 != null){
		    			sharedpreferences.edit().putString("f4", f4).commit();
		    		}else{
		    			sharedpreferences.edit().putString("f4", "fonts/f1.ttf").commit();
		    		}
		    		Toast.makeText(getApplicationContext(), "text : "+f4, Toast.LENGTH_SHORT).show();
		    		updateItemAtPosition(posi);
		    	}
		    }
		 }
	
@Override
public void onResume(){
	super.onResume();
}

@Override
	public void onBackPressed(){	
		finish();
		overridePendingTransition(R.anim.right_out,R.anim.right_in);
		super.onBackPressed();
	}	
@Override
	public void onDestroy(){
		super.onDestroy();
	}
}
