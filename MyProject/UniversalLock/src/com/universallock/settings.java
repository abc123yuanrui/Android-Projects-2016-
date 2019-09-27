package com.universallock;


import adapter.settings_adpater;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class settings extends Activity{
	private LinearLayout ll;	
	private ListView list;
	private int posi,val;
	public static int date_format;
		private int[] aimg;
		private ListAdapter adapter;
		private String[] cat, desc,dateformat;
		private EditText ed;
		private Button b12,b24;;
		public static String unlock_Text;
		public static final String MyPREFERENCES = "MyUserChoice";
		public static SharedPreferences sharedPreferences ;
	@Override
	protected void onCreate(Bundle savedInstanceState){
	
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.settings);
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
		cat = new String[] {"Color","Font","Text Size","Unlock Text","Date Format"};
	    aimg = new int[] { R.drawable.right_arrow, R.drawable.right_arrow, R.drawable.right_arrow,
	    		R.drawable.right_arrow, R.drawable.right_arrow};
	    //desc = new String[] {"","","shake or swipe","","","None","Default","Default","none","None","","","","","","",""};
	    dateformat = new String[] {"12 hour format","24 hour format"};
		 sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		 
		    ll = (LinearLayout)findViewById(R.id.settings_ll);
		    list = ((ListView)findViewById(R.id.settings_listview));
		    adapter = new settings_adpater(settings.this,cat, aimg);    
		    list.setAdapter(this.adapter);
		    list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent ,View view,
						int position, long id) {
					// TODO Auto-generated method stub
					if(position == 0){
						Intent i = new Intent(settings.this,color_choose.class);
						startActivity(i);
						overridePendingTransition(R.anim.left_in,R.anim.left_out);
						
					}
					if(position == 1){

						Intent i = new Intent(settings.this,font_chooser.class);						
						startActivity(i);
						overridePendingTransition(R.anim.left_in,R.anim.left_out);

					}
					if(position == 2){
						
						Intent i = new Intent(settings.this,Text_size_dialog.class);
						startActivity(i);
						overridePendingTransition(R.anim.left_in,R.anim.left_out);					
					}
					if(position == 3){
						posi = position;
						ShowDialog();
					}
					if(position == 4){
						posi = position;

						showDateDialog(settings.this, "Choose Time Fotmat", new String[] { "Ok" },
							    new DialogInterface.OnClickListener() {

							        @Override
							        public void onClick(DialogInterface dialog, int which) {

							        }
							    });
					}
				}
			});
		    
	}
	
	public void showDateDialog(Context context, String title, String[] btnText,
	        DialogInterface.OnClickListener listener) {

	    final CharSequence[] items = { "12 Houe Format", "24 Hour Format" };

	    if (listener == null)
	        listener = new DialogInterface.OnClickListener() {
	            @Override
	            public void onClick(DialogInterface paramDialogInterface,
	                    int paramInt) {
	                paramDialogInterface.dismiss();
	            }
	        };
	    AlertDialog.Builder builder = new AlertDialog.Builder(context);
	    builder.setTitle(title);

	    builder.setSingleChoiceItems(items, -1,
	            new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int item) {
	                	
	                	sharedPreferences.edit().putInt("date_format", item+1).commit();
	                	date_format = sharedPreferences.getInt("date_format", 0);
	//                	Toast.makeText(getApplicationContext(), "length : "+items.length+" date format first : "+date_format, Toast.LENGTH_SHORT).show();
	                	updateItemAtPosition(posi);
	                	
	                }
	            });
	    builder.setPositiveButton(btnText[0], listener);
	    if (btnText.length != 1) {
	        builder.setNegativeButton(btnText[1], listener);
	    }
	    builder.show();
	}
	
	
public void ShowDialog()
{
	
	//p1 = sharedPreferences.getInt("prog1", 0);p2 = sharedPreferences.getInt("prog2", 0);
	
	 AlertDialog.Builder popDialog = new AlertDialog.Builder(this);
	 ll = new LinearLayout(this);
	 ll.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	ll.setOrientation(LinearLayout.VERTICAL);		
	
	  ed = new EditText(this);
	  ed.setGravity(Gravity.CENTER_HORIZONTAL);
	  ed.setTextSize(25);
	  ll.addView(ed);
	//p1 = sharedPreferences.getInt("prog1", 0);
	//if(pp1 == 0) tv.setText(Integer.toString(p1));seek.setProgress(p1); if(pp1 == 1) tv.setText(Integer.toString(p2));seek.setProgress(p2);
	
	
	popDialog.setIcon(android.R.drawable.btn_star_big_on);
	popDialog.setTitle("clock size ");		
	popDialog.setView(ll);
	
	// Button OK
	popDialog.setPositiveButton("OK",
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					
					System.out.println("ed : "+ ed.getText().toString());
					System.out.println("position :"+posi);
					if(ed.getText().toString() != null)
					{ 
						sharedPreferences.edit().putString("unlock_text", ed.getText().toString()).commit();
						unlock_Text = sharedPreferences.getString("unlock_text", "");
					//	Toast.makeText(getApplicationContext(),"positon "+posi+ "ed : "+sharedPreferences.getString("unlock_text", ""),Toast.LENGTH_SHORT).show();
						updateItemAtPosition(posi);}
					dialog.dismiss();
				}

			});
	popDialog.setNegativeButton("Cancle",
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
private void updateItemAtPosition(int position) {
    int visiblePosition = list.getFirstVisiblePosition();
    View view = list.getChildAt(position - visiblePosition);
    list.getAdapter().getView(position, view, list);
}
@Override
public void onBackPressed(){
	finish();
	overridePendingTransition(R.anim.left_in,R.anim.left_out);
	super.onBackPressed();
}

}
