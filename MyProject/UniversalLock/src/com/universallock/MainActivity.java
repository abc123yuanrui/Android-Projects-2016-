 package com.universallock;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import adapter.ListViewAdapter;
import adapter.SwitchInterface;
import adapter.unlock_animation_interface;
 
import android.R.integer;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import receiver.lockScreenReeiver;
import service.MyService;

public class MainActivity extends Activity implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, AdapterView.OnItemClickListener, SwitchInterface
,unlock_animation_interface
{
	
	Ringtone rt;
	RingtoneManager mRingtoneManager;
	TextView text;
	Button button1;
	Cursor mcursor;
	Intent Mringtone,nringtone;
	String title;
	Uri uri;
	public static int status_key; 
	Timer timer;
	TimerTask timerTask;
	//we are going to use a handler to be able to run in our TimerTask
	final Handler handler = new Handler();
	long timeInMilliseconds = 0L;
	long timeSwapBuff = 0L;
	long updatedTime = 0L;
  public Vibrator vibrator;
  public static final String MyPREFERENCESS = "MyUserChoicess";
  public static final String MyPREFERENCES = "MyUserChoice";
  public static String Name = "None",ring;
  public static final String Position = "position";
  public static SharedPreferences sharedPreferences = null;
  public static int lockname;
  private ListAdapter adapter;
  private int[] aimg;
  private String[] cat, desc;
  private ListView list;
  private ComponentName mComponentName;
  private DevicePolicyManager mDevicePolicyManager;
  ListAdapter myadapter;
  ListView mylist;  
  private int posi,possi;
  public static int  vibratorv;
  private SharedPreferences sharedpreferences;
  private int clickedRow;
  public static int posit,lsb_key;
  private int p,p1,vvalue,top,sto;
  private Switch sw1;
  private String shake_or_swipe;
  public static String pin_pass;
  public static String pin_verify_ok;
  private String p8,p9;
  private int p7,pos7;
  private Intent intent;
  private PendingIntent pendintent;
  public static int m1,m2,m3,m4,m5,m6,m7,m8,m9,m11,m12,m13,m14,m15,m16,m17,m18,m19;
  public static String s1,s2,s3,s4,s5,s6,s7,s8,s9;
  public static String swipe_data,swipe_data1,swipe_data2,swipe_data3,swipe_data4,swipe_data5,swipe_data6,
  swipe_data7,swipe_data8;
  public static String sid1,sid2,sid3,sid4,sid5,sid6,sid7,sid8,sid9;

private Handler handler1;
private Runnable delayRunnable;
private View v;
private PowerManager pm;
private String description;
private int ADMIN_INTENT;
private int lenth;
private boolean bool = false;
public static int width,height;
private DisplayMetrics metrics;
private static String pn = "package name";
private Activity paramActivity;
private setvalue app;

//private int vval;
  
public void onCreate(Bundle savedInstanceState)
  {
	 
    super.onCreate(savedInstanceState);
     this.requestWindowFeature(Window.FEATURE_NO_TITLE);
     //getWindow().getDecorView().setSystemUiVisibility(View.VISIBLE);
    setContentView(R.layout.activity_main);
    app = (setvalue) getApplicationContext();
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		 sharedPreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
    if(swipe_image_lock_set.ab != null){
    	savePreferences("sp", swipe_image_lock_set.ab);
    }
    
      
    mDevicePolicyManager = ((DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE));
    
    //mComponentName = new ComponentName(this, device_policy.class);
    
    Switch sw = (Switch)findViewById(R.id.scl_sw);
    
    
    //Toast.makeText(getApplicationContext(), "********"+densityDpi, Toast.LENGTH_SHORT).show();
    //System.out.println("density : "+toastMsg);
    if(unlock_animation.b >= 0){
    	sharedpreferences.edit().putInt("animation", unlock_animation.b).commit();
    }
    pn = getApplication().getPackageName();
    
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
    cat = new String[] { "Preview", "Enable Screen Lock", "Select Lock Type", "Change Wallpaper", "Enable Vibration", "Notification","Lock Screen Background ", "Screen Timed Out", "Unlock Animation", "Unlock Sound", "System StatusBar", "Display lock screen items", "Settings", "Share", "Rate", "More Apps" };
    aimg = new int[] { R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow, R.drawable.dir_arrow,R.drawable.dir_arrow,R.drawable.dir_arrow,R.drawable.dir_arrow,R.drawable.dir_arrow,R.drawable.dir_arrow,R.drawable.dir_arrow};
    desc = new String[] {"","","shake or swipe","","","None","Default","Default","none","None","","","","","","",""};
	
	 
	 mRingtoneManager = new RingtoneManager(this);
	 mRingtoneManager.setType(RingtoneManager.TYPE_ALL);
	 mcursor = mRingtoneManager.getCursor();
	 //title = title.replace(mRingtoneManager.EXTRA_RINGTONE_TITLE, "Choose unlock sound");
	 final String strt ="Select Unlock Ringtone"; 
	 title = strt;
			 //mRingtoneManager.EXTRA_RINGTONE_TITLE;
	 ring = sharedPreferences.getString("ring", "");	 
	 status_key = sharedPreferences.getInt("statusbar_key", 0);
	 
		 lsb_key = sharedPreferences.getInt("lsb_value", 0);	 
	 
	//Toast.makeText(getApplicationContext(), "********"+top, Toast.LENGTH_SHORT).show();
	
	 p = sharedPreferences.getInt("value1", 0);

		if(p == 1){
			Intent i = new Intent("my.action.string3");        	   
			  i.putExtra("value9",p);		  
			  sendBroadcast(i);
		}
		else if(p == 2){
			pin_verify_ok = sharedPreferences.getString("pin_password", "");
		    Intent i = new Intent("my.action.string3");        	   
			  i.putExtra("value9",p);
			  sendBroadcast(i);
		}
		
		else if(p == 3){
			//pin_verify_ok = sharedpreferences.getString("pin_password", "");	
			 
			Intent ij = new Intent("my.action.string3");
			ij.putExtra("value9",p);
			sendBroadcast(ij);
			
		} 

		

	TextView ttc = (TextView)findViewById(R.id.scl_tv);
    list = ((ListView)findViewById(R.id.scl_lv));
    adapter = new ListViewAdapter(MainActivity.this,cat,aimg,this,this,this,this);    
    list.setAdapter(adapter);
    
    
    if(vvalue == 1){
    	Toast.makeText(getApplicationContext(), "v value : "+vvalue, Toast.LENGTH_SHORT).show();
    }else{
    	Toast.makeText(getApplicationContext(), "v value : "+vvalue, Toast.LENGTH_SHORT).show();
    }
    
    list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      


	public void onItemClick(AdapterView<?> parent, View v, final int position, long id)
      {
//		int hei=v.getLayoutParams().height;
	
         //v.requestLayout();
        if (position == 0)
        {
        		metrics = new DisplayMetrics();
      	  		getWindowManager().getDefaultDisplay().getMetrics(metrics);    

      	  		p = sharedPreferences.getInt("value1", 0);	
      		    //String ui = sharedPreferences.getString("sid1", ""); 
      			Toast.makeText(getApplicationContext(), "width : "+ metrics.widthPixels+ " height : "+metrics.heightPixels, Toast.LENGTH_SHORT).show();
      			Intent i  = new Intent(MainActivity.this,shake_or_swipe.class);
      			i.putExtra("val", p);
      			startActivity(i);
      		 
      		 
      		//window.setLayout(metrics.widthPixels, metrics.heightPixels);
      		//Log.i("width : height" , width+" / "+height);

      /*			
        	p = sharedPreferences.getInt("value1", 0);
        	
      	  if((p == 1) || (p == 0)){
      		 
    		  Intent i3 = new Intent(MainActivity.this, shake_or_swipe.class);
    		  //i3.putExtra("pos", p);
    		  startActivity(i3);
    		  MainActivity.this.overridePendingTransition(R.anim.left_in,R.anim.left_out);
    	  }
    	  if(p == 2){
    		 
    		  Intent i = new Intent(MainActivity.this,pin_lock_screen.class);
    		  i.putExtra("pin_password", pin_verify_ok);
    		  startActivity(i);
    		  MainActivity.this.overridePendingTransition(R.anim.left_in,R.anim.left_out);
    	  }
    	  if(p == 3){
    		 
    		  Intent i3 = new Intent(MainActivity.this,swipe_image_lock_set_confirm.class);
    		  startActivity(i3);
    		  overridePendingTransition(R.anim.left_in,R.anim.left_out);
    	  }*/ 
        }
        if (position == 1)
        	{        	
             		
           }
                 
          if (position == 2)
          {
        	  
        		p = sharedPreferences.getInt("value1", 0);
        	  		  
        	  if((p == 0) || (p == 1)){
        		  Intent i = new Intent(MainActivity.this, selectlocktype.class);
        		  i.putExtra("bool", bool);
        		  i.putExtra("pos", 1);
        		  startActivityForResult(i, 1);
        		  overridePendingTransition(R.anim.left_in,R.anim.left_out);
        		  }
        	  
        	  if(p == 2){

        		  Intent i = new Intent(MainActivity.this,pin_verify.class);
        		  startActivityForResult(i,2);
        		  overridePendingTransition(R.anim.left_in,R.anim.left_out);
        	  }
        	  if(p == 3){        		  
        		  String passi = sharedPreferences.getString("sp", "");        		  
        		  Intent i3 = new Intent(MainActivity.this,swipe_image_lock_set_confirm.class);
        		  i3.putExtra("swd1", passi);
        		  startActivityForResult(i3,3);
        		  overridePendingTransition(R.anim.left_in,R.anim.left_out);
        	  }
        	
          }
          if (position == 3)
          {
            Intent i4 = new Intent(MainActivity.this, wallpaper_chooser.class);
            MainActivity.this.startActivity(i4);
            MainActivity.this.overridePendingTransition(R.anim.left_in,R.anim.left_out);
          }
          if (position == 5)
          {
           startActivity(new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS));
            overridePendingTransition(R.anim.left_in,R.anim.left_out);
          }	
          if (position == 6)         {
        	  
        	  
          }
          if (position == 7)
          {
            Intent i7= new Intent(MainActivity.this, screen_time_out.class);            
            startActivityForResult(i7,7);
            overridePendingTransition(R.anim.left_in,R.anim.left_out);
                       
          }
          if (position == 8)
          {
            Intent i8= new Intent(MainActivity.this, unlock_animation.class);
            //i6.putExtra("ptc", top);
            startActivityForResult(i8,8);
            overridePendingTransition(R.anim.left_in,R.anim.left_out);
            //Toast.makeText(getApplicationContext(), "top : "+top, Toast.LENGTH_LONG).show();
          }if(position == 9){
        	  //listRingtones();
        	
        	  Mringtone = new Intent("android.intent.action.RINGTONE_PICKER");
        	  
        	  startActivityForResult(Mringtone, 9);

        	//specifies what type of tone we want, in this case "ringtone", can be notification if you want
        	Mringtone.putExtra(mRingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION);

        	//gives the title of the RingtoneManager picker title
        	Mringtone.putExtra("Choose ringtone for unlock ", strt);

        	//returns true shows the rest of the songs on the device in the default location
        	Mringtone.getBooleanExtra(mRingtoneManager.EXTRA_RINGTONE_TYPE, true);

        	String uri = null;
        	//chooses and keeps the selected item as a uri
        	if ( uri != null ) { 
        	Mringtone.putExtra(mRingtoneManager.EXTRA_RINGTONE_EXISTING_URI, Uri.parse( uri ));
        	Toast.makeText(getApplicationContext(), "working : "+uri, Toast.LENGTH_LONG).show();
        	} else { 
        	Mringtone.putExtra(mRingtoneManager.EXTRA_RINGTONE_EXISTING_URI, (Uri)null);
        	Toast.makeText(getApplicationContext(), "working : "+uri, Toast.LENGTH_LONG).show();        	  
        	}
        
          }
          if(position == 10){
          }
          if (position == 11)
          {
            Intent localIntent6 = new Intent(MainActivity.this, display_item_settings.class);
            MainActivity.this.startActivity(localIntent6);
            overridePendingTransition(R.anim.left_in,R.anim.left_out);
          }
          if (position == 12)
          {
            Intent localIntent6 = new Intent(MainActivity.this, settings.class);
            MainActivity.this.startActivity(localIntent6);
            overridePendingTransition(R.anim.left_in,R.anim.left_out);
          }
          if (position == 13)
          {
        	  
        	    Intent localIntent = new Intent("android.intent.action.SEND");
        	    localIntent.setType("text/plain");
        	    localIntent.putExtra("android.intent.extra.SUBJECT", "Universal Lock");
        	    localIntent.putExtra("android.intent.extra.TEXT", "\nTry this application, I think you will love it!\n\n" + "https://play.google.com/store/apps/details?id=com.Universallock" + " \n\n");
        	    startActivity(Intent.createChooser(localIntent, "Share"));
        	  
          }
          if(position == 14){
      		Uri link = Uri.parse("https://play.google.com/store/apps/details?id=com.Universallock");
    		Intent i = new Intent(Intent.ACTION_VIEW,link);
    		startActivity(i);
          }
          if(position == 15){
        	  
        	Uri link = Uri.parse("https://play.google.com/store/apps/details?id=com.Universallock");
      		Intent i = new Intent(Intent.ACTION_VIEW,link);
      		startActivity(i);
          }
      }
    });
  }
  
  
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) 
  {
	
    if(requestCode == 1){
    	if(resultCode == RESULT_OK){
    		//shake_or_swipe = data.getStringExtra("value_of_p");
    		int vp = data.getIntExtra("value_of_p",0);
    		//pin_pass = data.getStringExtra("pin_password");
    		if(vp == 1){
    			p = 1;
    			savePreferences("value1", vp);
    			Intent ij = new Intent("my.action.string3");
    			ij.putExtra("value9",vp);    			
    			sendBroadcast(ij);
    			updateData();
    			
    		}else if(vp == 2){
    			p = 2;    			
    			savePreferences("value1", vp);
    			Intent ij = new Intent("my.action.string3");
    			ij.putExtra("value9",vp);
    			sendBroadcast(ij);
    			savePreferences("pin_pass", pin.ss);   			
    			
    			pin_pass = sharedPreferences.getString("pin_pass", "");
    			pin_verify_ok = sharedPreferences.getString("pin_pass", "");
    			
    			updateData();
    			//savePreferences("pin_password", pin_pass);
    		}else if( vp == 3){
    			 
    			p = 3;    			
    			savePreferences("value", vp);
    			Intent ij = new Intent("my.action.string3");
    			ij.putExtra("value9",vp);
    			sendBroadcast(ij);
    			updateData();
    			
    			if(swipe_image_lock_set.ab != null){savePreferences("sid1", swipe_image_lock_set.ab);} 
    			if(swipe_image_lock_set.ab1 != null){savePreferences("sid2", swipe_image_lock_set.ab1);}
    			if(swipe_image_lock_set.ab2 != null){savePreferences("sid3", swipe_image_lock_set.ab2);}
    			if(swipe_image_lock_set.ab3 != null){savePreferences("sid4", swipe_image_lock_set.ab3);}
    			if(swipe_image_lock_set.ab4 != null){savePreferences("sid5", swipe_image_lock_set.ab4);}
    			if(swipe_image_lock_set.ab5 != null){savePreferences("sid6", swipe_image_lock_set.ab5);}
    			if(swipe_image_lock_set.ab6 != null){savePreferences("sid7", swipe_image_lock_set.ab6);}
    			if(swipe_image_lock_set.ab7 != null){savePreferences("sid8", swipe_image_lock_set.ab7);}
    			if(swipe_image_lock_set.ab8 != null){savePreferences("sid9", swipe_image_lock_set.ab8);}
    			sid1 = sharedPreferences.getString("sid1", "");
    			 String st = sid1;
    			savePreferences("st1", st);
    			
    			if((swipe_image_lock_set.x1 != 0) || (swipe_image_lock_set.x2 != 0) || (swipe_image_lock_set.x3 != 0) ||
    					  (swipe_image_lock_set.x4 != 0)  || (swipe_image_lock_set.x5 != 0) || (swipe_image_lock_set.x6 != 0) ||
    					  (swipe_image_lock_set.x7 != 0)  || (swipe_image_lock_set.x8 != 0) || (swipe_image_lock_set.x9 != 0)){
    							savePreferences("m11", swipe_image_lock_set.x1);savePreferences("m12", swipe_image_lock_set.x2);
    							savePreferences("m13", swipe_image_lock_set.x3);savePreferences("m14", swipe_image_lock_set.x4);
    							savePreferences("m15", swipe_image_lock_set.x5);savePreferences("m16", swipe_image_lock_set.x6);
    							savePreferences("m17", swipe_image_lock_set.x7);savePreferences("m18", swipe_image_lock_set.x8);
    						savePreferences("m19", swipe_image_lock_set.x9);
    			}
    		Toast.makeText(getApplicationContext(), "pin_pass : "+pin_pass, Toast.LENGTH_SHORT).show();
    		
    		}
    	}
    }
    
    if(requestCode == 2){
		 if(resultCode == RESULT_OK){
		int pin_verify_ok = data.getIntExtra("pin_verify", 0);

			if(pin_verify_ok == 2){
				
				Toast.makeText(getApplicationContext(), "this is verify result : "+pin_verify_ok,Toast.LENGTH_LONG).show();
				Intent i = new Intent(MainActivity.this, selectlocktype.class);
				i.putExtra("pos", 2);
				startActivityForResult(i, 1);
				
			}			 
		 }
    }
    
    if(requestCode == 3){
		 if(resultCode == RESULT_OK){
			 int arg = data.getIntExtra("data", 0);
			 if(arg == 3){			
				 //Toast.makeText(getApplicationContext(), "this is verify result : "+arg,Toast.LENGTH_LONG).show();
				 Intent i = new Intent(MainActivity.this, selectlocktype.class);
				 i.putExtra("pos", 3);
				 startActivityForResult(i, 1);
			 }
			 
			 	
		 }
    }
    
    if(requestCode == 6){
		 if(resultCode == RESULT_OK){
			 int pta = data.getIntExtra("screen_to", 0);
			 int position = data.getIntExtra("pt", 0);
			 savePreferences("screen_sld", pta);		
			 savePreferences("posld", position);
			 int pos = sharedPreferences.getInt("posld", 0);
			 sto = sharedpreferences.getInt("screen_sld", 0);
			 //Toast.makeText(getApplicationContext(), "sto : "+sto+" pos :"+pos,Toast.LENGTH_LONG).show();
			 if(position != -1){
//				 possi = sharedPreferences.getInt("switch_key", 0);	
					sto = sharedPreferences.getInt("screen_sld", 0);
				  Intent i = new Intent("my.action.string2");        	   
		    	  i.putExtra("posi",possi);
		    	  i.putExtra("sto", sto);
		    	  sendBroadcast(i);
		    	  updateData();
				 
			 }
			 	
		 }
  }
    
    if(requestCode == 7){
		 if(resultCode == RESULT_OK){
			 int pt = data.getIntExtra("pt", 0);
			 int time = data.getIntExtra("time",0);			 
			 
			 if(pt != -1){			 
				 
				 //savePreferences("ptm", time);
				 
				 savePreferences("ptm", pt);
				 savePreferences("time",time);
				 top = sharedPreferences.getInt("ptm", 0);
				 int pot = sharedPreferences.getInt("time", time);
				 updateData();
				 Log.d("screen time out","screen time out");
					 //Toast.makeText(getApplicationContext(), "pot :"+pos7, Toast.LENGTH_SHORT).show();	 
				
			 }
			 	
		 }
		 
   }
    if(requestCode == 8){
		 if(resultCode == RESULT_OK){
			 int uai = data.getIntExtra("uai", 0);
			 			 
			 if(uai != -1){			 
				 sharedpreferences.edit().putInt("animation", unlock_animation.b).commit();	
				// int uai1 = sharedpreferences.getInt("animation", 0);
				 //Toast.makeText(getApplicationContext(), "uai gotted : "+uai1 , Toast.LENGTH_SHORT).show();
				 Log.d("unlock animation","unlock animation");
				 updateData();
			 }
			 	
		 }
    }
    if(requestCode == 9){
		 if(resultCode == RESULT_OK){
			 
			 switch (resultCode) {
			 
			 case RESULT_OK: 
			 //sents the ringtone that is picked in the Ringtone Picker Dialog
			 uri = data.getParcelableExtra(mRingtoneManager.EXTRA_RINGTONE_PICKED_URI);
			 System.out.println("uri : path : "+uri);
			 //send the output of the selected to a string
			 	if(uri != null){
			 		String rpath = uri.toString();
			 		app.setrington(rpath);
			 		savePreferences("ring", rpath);			 
			 		ring = sharedPreferences.getString("ring", "");	 
			 		
			 		Log.i("Sample", "uri " + uri);
			 		updateData();	 
			 	}else{
			 		uri = null;
			 		String rpath = null;
			 		
			 		savePreferences("ring", rpath);			 
			 		ring = sharedPreferences.getString("ring", "");
			 		updateData();
			 	}
			 
			  }
			 }
			 	
   }
  }

  
private void updateItemAtPosition(int position) {
    int visiblePosition = list.getFirstVisiblePosition();
    View view = list.getChildAt(position - visiblePosition);
    list.getAdapter().getView(position, view, list);
}

@Override
public void onResume(){
	//if(lockScreenReeiver.wasScreenOff == true){
		//startTimer();
	//}
	  super.onResume();
}
@Override
public void onBackPressed()
  {
    finish();
    overridePendingTransition(R.anim.right_out,R.anim.right_in);
    super.onBackPressed();
  }
  
  public void onClick(View paramView) {}
  
  
  
  protected void onDestroy()
  {
		sid1 = sharedPreferences.getString("sid1", "");sid2 = sharedPreferences.getString("sid2", "");
		sid3 = sharedPreferences.getString("sid3", "");sid4 = sharedPreferences.getString("sid4", "");
		sid5 = sharedPreferences.getString("sid5", "");sid6 = sharedPreferences.getString("sid6", "");
		sid7 = sharedPreferences.getString("sid7", "");sid8 = sharedPreferences.getString("sid8", "");
		sid9 = sharedPreferences.getString("sid9", "");

		m11 = sharedpreferences.getInt("swp1", 0);m12 = sharedpreferences.getInt("swp2", 0);m13 = sharedpreferences.getInt("swp3", 0);
		m14 = sharedpreferences.getInt("swp4", 0);m15 = sharedpreferences.getInt("swp5", 0);m16 = sharedpreferences.getInt("swp6", 0);
		m17 = sharedpreferences.getInt("swp7", 0);m18 = sharedpreferences.getInt("swp8", 0);m19 = sharedpreferences.getInt("swp9", 0);
		
		m1 = sharedpreferences.getInt("swp1", 0);m2 = sharedpreferences.getInt("swp2", 0);m3 = sharedpreferences.getInt("swp3", 0);
		m4 = sharedpreferences.getInt("swp4", 0);m5 = sharedpreferences.getInt("swp5", 0);m6 = sharedpreferences.getInt("swp6", 0);
		m7 = sharedpreferences.getInt("swp7", 0);m8 = sharedpreferences.getInt("swp8", 0);m9 = sharedpreferences.getInt("swp9", 0);
		
    super.onDestroy();
  }
  
  public boolean onHomePressed()
  {
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onKeyDown(int KeyCode, KeyEvent Event)
  {
    if ((KeyCode == 25) || (KeyCode == 26) || (KeyCode == 24) || (KeyCode == 27)) {}
    while ((KeyCode == 82) || (KeyCode == 3) || (KeyCode == 84) || (KeyCode == 176)) {
      return false;
    }
    return super.onKeyDown(KeyCode, Event);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString) {}


@Override
public void setValues(int posi2) {
	// TODO Auto-generated method stub
	posi = posi2;
		
	
	sto = sharedPreferences.getInt("screen_sld", 0);
	if(posi == 1){
		starts();
		savePreferences("switch_key", posi);
		posit = sharedPreferences.getInt("switch_key", 0);
		//Intent i = new Intent("my.action.string");
		//i.putExtra("va", posit);
		//sendBroadcast(i);
		//Toast.makeText(getApplicationContext(), "position on : "+posit , Toast.LENGTH_SHORT).show();
		sto = sharedPreferences.getInt("screen_sld", 0);
		
		//startService(new Intent(this, S.class).setAction("android.intent.action.SCREEN_OFF"));   	
	}else{		
		stops();
		savePreferences("switch_key", 0);
		posit = sharedPreferences.getInt("switch_key", 0);
		//Intent i = new Intent("my.action.string");
		//i.putExtra("va", posit);
		//sendBroadcast(i);
		
		//stopService(new Intent(this, MyService.class));
	}
}
@Override
public void setValue(int vval){

	//System.out.println(SwitchInterface.vibratorv);
	vibratorv = vval;
		  
	if(vibratorv == 0){
		
		sharedpreferences.edit().remove("vibrator_key").commit();
		savePreferences("vibrator_key", vibratorv);
		vibratorv = sharedPreferences.getInt("vibrator_key", 0);
		
	
	Toast.makeText(getApplicationContext(), "v value : "+vibratorv, Toast.LENGTH_SHORT).show();
}else{
	//erroe while swipping listview
	sharedpreferences.edit().remove("vibrator_key").commit();
	savePreferences("vibrator_key", 1);
	vibratorv = sharedPreferences.getInt("vibrator_key", 0);
	Toast.makeText(getApplicationContext(), "v value : "+vibratorv , Toast.LENGTH_SHORT).show();
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
public void setuapos(int pos) {
	// TODO Auto-generated method stub
	sharedpreferences.edit().putInt("uai_main", pos).commit();
}


@Override
public void setstopos(int pos2) {
	// TODO Auto-generated method stub
	
}


@Override
public void setstatusbar(int statusb) {
	// TODO Auto-generated method stub



if(status_key == 0){
	savePreferences("statusbar_key", statusb);
}else{
	savePreferences("statusbar_key", 1);
}

}
class MyTimerTask extends TimerTask {

	  @Override
	  public void run() {
	   Calendar calendar = Calendar.getInstance();
	   SimpleDateFormat simpleDateFormat = 
	     new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss");
	   final String strDate = simpleDateFormat.format(calendar.getTime());
	   

	   runOnUiThread(new Runnable(){

		    @Override
		    public void run() {
		   // 	Toast.makeText(getApplicationContext(),"time : "+strDate, Toast.LENGTH_SHORT).show();
		   // 	System.out.println("time :"+strDate);
		    }});
	  }
	  
	 }

private void updateData() {
 
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
                ((BaseAdapter) adapter).notifyDataSetChanged();
        }
    });
}


@Override
public void setlsb(int lsb) {
	// TODO Auto-generated method stub

	
if(lsb == 0){
	savePreferences("lsb_value", lsb);
	updateData();
}else{
	savePreferences("lsb_value", 1);
	updateData();
}
lsb_key = sharedPreferences.getInt("lsb_value", 0);
}


public void onShareClick(View v) {
    Resources resources = getResources();

    Intent emailIntent = new Intent();
    emailIntent.setAction(Intent.ACTION_SEND);
    // Native email client doesn't currently support HTML, but it doesn't hurt to try in case they fix it
    emailIntent.putExtra(Intent.EXTRA_TEXT, " \n Try this app, I think you love it...!\n" +"\n https://play.google.com/store/apps/details?id=com.Universallock \n");
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Universal Lock");
    emailIntent.setType("message/rfc822");

    PackageManager pm = getPackageManager();
    Intent sendIntent = new Intent(Intent.ACTION_SEND);     
    sendIntent.setType("text/plain");

    }
public void starts(){
	//startService(new Intent(this,MyService.class));
	Intent i = new Intent(MainActivity.this,MyService.class);
	i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	startService(i);
	
}
public void stops(){
stopService(new Intent(this,MyService.class));
//Intent i = new Intent(LockScreenAppActivity.this,MyService.class);
//i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//stopService(i);
}
}
