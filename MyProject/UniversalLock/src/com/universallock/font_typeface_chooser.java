package com.universallock;


import adapter.font_typeface_chooser_adapter;
import adapter.settings_adpater;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
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

public class font_typeface_chooser extends Activity{
	private LinearLayout ll;	
	private ListView list;
		private int[] aimg, cbi;
		private ListAdapter adapter;
		private String[] Clock, Date,utxt,title_txt;
		public static int p;
		public static String p1,p2,p3,p4;
		private String s1,s2,s3,s4,ss1,ss2,ss3,ss4,ss5,ss6,ss7,ss8,ss9,ss10;		
		private int posi;
		public static final String MyPREFERENCES = "MyUserChoice";
		public static SharedPreferences sharedPreferences = null;
	@Override
	protected void onCreate(Bundle savedInstanceState){
	
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.font_typeface_chooser);
		posi = getIntent().getIntExtra("posi", 0);
		
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
			overridePendingTransition(R.anim.right_out,R.anim.right_in);
			}
		});
	    icon_tw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri link = Uri.parse("https://twitter.com/Universal_Lock");
				Intent i = new Intent(Intent.ACTION_VIEW,link);
				startActivity(i);
				overridePendingTransition(R.anim.right_out,R.anim.right_in);
			}
		});
	    icon_gp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri link = Uri.parse("https://plus.google.com/116983587903359769433");
				Intent i = new Intent(Intent.ACTION_VIEW,link);
				startActivity(i);
				overridePendingTransition(R.anim.right_out,R.anim.right_in);
			}
		});
		
		Clock = new String[] {"9:01","9:10","9:10","9:10","9:10","9:10","9:10","9:10","9:10","9:10"};
		
	    aimg = new int[] { R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow,	    		
	    		R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow
	    		, R.drawable.right_arrow};
	    Date = new String[] {" jul 04 2015","jul 04 2015","jul 04 2015", "jul 04 2015","jul 04 2015",
	    		"jul 04 2015","jul 04 2015","jul 04 2015","jul 04 2015","jul 04 2015"};
	    utxt = new String[] {"Swipe to Unlock","Swipe to Unlock","Swipe to Unlock","Swipe to Unlock","Swipe to Unlock",
	    		"Swipe to Unlock","Swipe to Unlock","Swipe to Unlock","Swipe to Unlock","Swipe to Unlock"};
	    title_txt = new String[] {"Pin / Gallery","Pin / Gallery","Pin / Gallery","Pin / Gallery","Pin / Gallery",
	    		"Pin / Gallery","Pin / Gallery","Pin / Gallery","Pin / Gallery","Pin / Gallery"};
	    cbi = new int[] {R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check
	    		,R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check,R.drawable.lock_type_check
	    		,R.drawable.lock_type_check,R.drawable.lock_type_check};
	    //desc = new String[] {"","","shake or swipe","","","None","Default","Default","none","None","","","","","","",""};
		 sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		    //ll = (LinearLayout)findViewById(R.id.settings_ll);
		 
		    list = ((ListView)findViewById(R.id.font_typeface_chooser_list));
		    list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		    if(posi == 0){
		    	adapter = new font_typeface_chooser_adapter(font_typeface_chooser.this,Clock, aimg,cbi);
		    }else if(posi == 1){  
		    	adapter = new font_typeface_chooser_adapter(font_typeface_chooser.this,Date, aimg,cbi);
		    }else if(posi == 2){
		    	adapter = new font_typeface_chooser_adapter(font_typeface_chooser.this,utxt, aimg,cbi);
		    }else if(posi == 3){
		    	adapter = new font_typeface_chooser_adapter(font_typeface_chooser.this,title_txt, aimg,cbi);
		    } 
		    list.setAdapter(adapter);
		    list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent ,View view,
						int position, long id) {
					// TODO Auto-generated method stub
					if(position == 0){
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f1.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f1.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						//if((p2 != null) && (posi == 1)){Toast.makeText(getApplicationContext(), "p2 : "+p2, Toast.LENGTH_SHORT).show();}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f1.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f1.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");
						Intent i = new Intent();
						i.putExtra("p4_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
					}
					if(position == 1){
						
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f2.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f2.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f2.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f2.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");
						Intent i = new Intent();
						i.putExtra("p4_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
					}
					if(position == 2){				  
						
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f3.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f3.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f3.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f3.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");
						Intent i = new Intent();
						i.putExtra("p1_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
					}
					if(position == 3){
						
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f4.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f4.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f4.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f4.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");
						Intent i = new Intent();
						i.putExtra("p4_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
					}
					if(position == 4){
					
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f5.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f5.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f5.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f5.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");
						Intent i = new Intent();
						i.putExtra("p4_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
					}
					if(position == 5){
					
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f6.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f6.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f6.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f6.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");
						Intent i = new Intent();
						i.putExtra("p4_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
					}
					if(position == 6){
					
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f7.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f7.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f7.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f7.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");
						Intent i = new Intent();
						i.putExtra("p4_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
					}
					if(position == 7){
					
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f8.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f8.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f8.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f8.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");
						Intent i = new Intent();
						i.putExtra("p4_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
					}
					if(position == 8){
						
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f9.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f9.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f9.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f9.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");
						Intent i = new Intent();
						i.putExtra("p4_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
					}
					if(position == 9){
						
						if(posi == 0){sharedPreferences.edit().putString("p_1", "fonts/f10.ttf").commit(); p1 = sharedPreferences.getString("p_1", "");
						Intent i = new Intent();
						i.putExtra("p1_f1", p1);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 1){sharedPreferences.edit().putString("p_2", "fonts/f10.ttf").commit(); p2 = sharedPreferences.getString("p_2", "");
						Intent i = new Intent();
						i.putExtra("p2_f2", p2);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 2){sharedPreferences.edit().putString("p_3", "fonts/f10.ttf").commit(); p3 = sharedPreferences.getString("p_3", "");
						Intent i = new Intent();
						i.putExtra("p3_f3", p3);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
						}
						if(posi == 3){sharedPreferences.edit().putString("p_4", "fonts/f10.ttf").commit(); p4 = sharedPreferences.getString("p_4", "");					}
						Intent i = new Intent();
						i.putExtra("p4_f4", p4);
						setResult(RESULT_OK, i);
						finish();
						overridePendingTransition(R.anim.right_out, R.anim.right_in);
					}
				}
			});
		    
	}
	
@Override
public void onResume(){
	super.onResume();
}
@Override
public void onBackPressed(){
	finish();
	overridePendingTransition(R.anim.right_out, R.anim.right_in);
	super.onBackPressed();
}
@Override
public void onDestroy(){
	super.onDestroy();
}

	
}
