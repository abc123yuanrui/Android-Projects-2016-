package com.universallock;

import java.io.ObjectOutputStream.PutField;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import adapter.ListViewAdapter;
import adapter.SwitchInterface;
import adapter.color_adapter;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class pin_lock_screen extends Activity implements View.OnClickListener
{
  private static final int[] a = { R.drawable.bt0, R.drawable.bt1, R.drawable.bt2, R.drawable.bt3, R.drawable.bt4, R.drawable.bt5, R.drawable.bt6, R.drawable.bt7, R.drawable.bt8, R.drawable.bt9};
  private static final int[] b = { R.drawable.pin_light,R.drawable.pin_light,R.drawable.pin_light,R.drawable.pin_light};
  Button b0, b1, b2, b3, b4, b5,b6, b7, b8, b9;
  private boolean bool = false;
  Button btncnl, btncntn, btnok, btndelete;
  private StringBuffer c1 = new StringBuffer();
  private StringBuffer c2 = new StringBuffer();
  int count = 4;
  KeyguardManager.KeyguardLock k1;
  private ArrayList h = new ArrayList();
  private int i,lsb;
  private Typeface t1,t2,t3,t4;
  ImageView i1,i2,i3,i4;
  int la = a.length;
  int lb = b.length;
  private int a1,a2,a3,a4,a5,a6,a7,a8;
  private int n;
  private int n2 = 0,status_key;
  TextView pin_enter;
  private String s1;
  private String s2;
  TextView title;
  private String getstr;
  TextView btl;
  String batterperc;
  private ImageView battery_img , signal_img;
  private FrameLayout frm;
  public static final String MyPREFERENCES = "MyUserChoicesss";
  public static SharedPreferences sharedPreferences = null;
  private String str2;
  private int cc1,cc2,cc3,cc4,cc5,cc6,cc7,cc8,size1,size2,size3,size4,date_format,wallp;
  private String local;
  private WindowManager manager;
  private WindowManager.LayoutParams localLayoutParams;
  private customViewGroup view;
  private DisplayMetrics metrics1;
  private Context c;
  setvalue app;
  @Override
  protected void onNewIntent(Intent intent) {
      super.onNewIntent(intent);
      // getIntent() should always return the most recent
      setIntent(intent);
      //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
  }  
  
  
public void onCreate(Bundle savedInstancestate)
  {
    super.onCreate(savedInstancestate);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    hideNavBar();
    
    manager = ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE));

    localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
    localLayoutParams.gravity = Gravity.TOP;    
    
    localLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|

//    		WindowManager.LayoutParams.FLAG_LAYOUT_ATTACHED_IN_DECOR |
    		WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN |
    		
           // this is to enable the notification to recieve touch events
           //WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN |
    		WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
           // Draws over status bar
   WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

    
   //localLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
   localLayoutParams.height = (int) (50 * getResources().getDisplayMetrics().scaledDensity);
   localLayoutParams.format = PixelFormat.TRANSPARENT;

   view = new customViewGroup(this);
   
   manager.addView(view, localLayoutParams);   
    setContentView(R.layout.pin_screen_lock); 
    app = (setvalue) getApplicationContext();
    
    local = "1478";
    sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    
    if(app.getpinvalue() != null){
    	sharedPreferences.edit().putString("get_str", app.getpinvalue()).commit();
    }
    getstr = sharedPreferences.getString("get_str", "");
    
    Log.d("get-str : ",getstr);
    if(wallpaper_chooser.wall != 0){
    	sharedPreferences.edit().putInt("wallpaper_choose", wallpaper_chooser.wall).commit();
    }else{
    	sharedPreferences.edit().putInt("wallpaper_choose", R.drawable.abc23).commit();
    }  
    // wallpaer variable
    wallp = sharedPreferences.getInt("wallpaper_choose", 0);
    
    FrameLayout frml = (FrameLayout)findViewById(R.id.pin_frm_scn);
    if(ListViewAdapter.i8 != -1){
    	sharedPreferences.edit().putInt("lsb_key", ListViewAdapter.i8).commit();
    	lsb = sharedPreferences.getInt("lsb_key", 0);
    }else{
    	sharedPreferences.edit().putInt("lsb_key", 1).commit();
    	lsb = sharedPreferences.getInt("lsb_key", 0);
    }
    if(lsb == 1 ){frml.setBackgroundResource(wallp);}
    else{ frml.removeView(frml);}
    
	//getstr = sharedPreferences.getString("getstr", "");
	
    status_key = MainActivity.status_key;
    View pin_set = findViewById(R.id.statusbar_pin);
    if(status_key == 0){
    	pin_set.setVisibility(View.GONE);    	
    }else{
    	pin_set.setVisibility(View.VISIBLE);
    }
    if(color_adapter.p1 != 0){sharedPreferences.edit().putInt("c1", color_adapter.p1).commit();}
    else{sharedPreferences.edit().putInt("c1", -16711684).commit();}
    if(color_adapter.p2 != 0){sharedPreferences.edit().putInt("c2", color_adapter.p2).commit();}
    else{sharedPreferences.edit().putInt("c2", -16711684).commit();}
    if(color_adapter.p3 != 0){sharedPreferences.edit().putInt("c3", color_adapter.p3).commit();}
    else{sharedPreferences.edit().putInt("c3", -16711684).commit();}
    if(color_adapter.p4 != 0){sharedPreferences.edit().putInt("c4", color_adapter.p4).commit();}
    else{sharedPreferences.edit().putInt("c4", -16711684).commit();}
    if(color_adapter.p5 != 0){sharedPreferences.edit().putInt("c5", color_adapter.p5).commit();}
    else{sharedPreferences.edit().putInt("c5", -16711684).commit();}
    if(color_adapter.p6 != 0){sharedPreferences.edit().putInt("c6", color_adapter.p6).commit();}
    else{sharedPreferences.edit().putInt("c6", -16711684).commit();}
    if(color_adapter.p7 != 0){sharedPreferences.edit().putInt("c7", color_adapter.p7).commit();}
    else{sharedPreferences.edit().putInt("c7", -16711684).commit();}
    if(color_adapter.p8 != 0){sharedPreferences.edit().putInt("c8", color_adapter.p8).commit();}
    else{sharedPreferences.edit().putInt("c8", -16711684).commit();}
    
    // clock size changed
    if(Text_size_dialog.p1 != 0){sharedPreferences.edit().putInt("pp1", Text_size_dialog.p1).commit();}
    else{sharedPreferences.edit().putInt("pp1", 36).commit();}
    if(Text_size_dialog.p2 != 0){sharedPreferences.edit().putInt("pp2", Text_size_dialog.p2).commit();}
    else{sharedPreferences.edit().putInt("pp2", 25).commit();}
    if(Text_size_dialog.p3 != 0){sharedPreferences.edit().putInt("pp3", Text_size_dialog.p3).commit();}
    else{sharedPreferences.edit().putInt("pp3", 25).commit();}
    if(Text_size_dialog.p4 != 0)sharedPreferences.edit().putInt("size", Text_size_dialog.p4).commit();
    else{sharedPreferences.edit().putInt("size", 25).commit();}
    
    size1 = sharedPreferences.getInt("pp1", 0);size2 = sharedPreferences.getInt("pp2", 0);
    size3 = sharedPreferences.getInt("pp3", 0);size4 = sharedPreferences.getInt("size", 0);
    
    cc1 = sharedPreferences.getInt("c1", 0); cc2 = sharedPreferences.getInt("c2", 0);
    cc3 = sharedPreferences.getInt("c3", 0); cc4 = sharedPreferences.getInt("c4", 0);
    cc5 = sharedPreferences.getInt("c5", 0); cc6 = sharedPreferences.getInt("c6", 0);
    cc7 = sharedPreferences.getInt("c7", 0); cc8 = sharedPreferences.getInt("c8", 0);
    
    if(font_typeface_chooser.p1 != null){sharedPreferences.edit().putString("t1", font_typeface_chooser.p1).commit();}
    else{sharedPreferences.edit().putString("t1", "fonts/f4.ttf").commit();}
    if(font_typeface_chooser.p2 != null){sharedPreferences.edit().putString("t2", font_typeface_chooser.p2).commit();}
    else{sharedPreferences.edit().putString("t2", "fonts/f4.ttf").commit();}    
    if(font_typeface_chooser.p4 != null){sharedPreferences.edit().putString("t4", font_typeface_chooser.p4).commit();}
    else{sharedPreferences.edit().putString("t4", "fonts/f4.ttf").commit();}
    
    	 t1 = Typeface.createFromAsset(getAssets(),sharedPreferences.getString("t1", ""));
    	 t2 = Typeface.createFromAsset(getAssets(),sharedPreferences.getString("t2", ""));
    	 t4 = Typeface.createFromAsset(getAssets(),sharedPreferences.getString("t4", ""));
    	 
    if(settings.date_format != 0){
    	sharedPreferences.edit().putInt("date_form", settings.date_format).commit();
    }
    date_format = sharedPreferences.getInt("date_form", 0);
    
    if(display_item_settings.p1 != -1){ sharedPreferences.edit().putInt("iv1", display_item_settings.p1).commit();}
    else{sharedPreferences.edit().putInt("iv1", 1).commit();}
    if(display_item_settings.p2 != -1){ sharedPreferences.edit().putInt("iv2", display_item_settings.p2).commit();}
    else{sharedPreferences.edit().putInt("iv2", 1).commit();}
    if(display_item_settings.p3 != -1){ sharedPreferences.edit().putInt("iv3", display_item_settings.p3).commit();}
    else{sharedPreferences.edit().putInt("iv3", 1).commit();}
    if(display_item_settings.p4 != -1){ sharedPreferences.edit().putInt("iv4", display_item_settings.p4).commit();}
    else{sharedPreferences.edit().putInt("iv4", 1).commit();}
    if(display_item_settings.p5 != -1){ sharedPreferences.edit().putInt("iv5", display_item_settings.p5).commit();}
    else{sharedPreferences.edit().putInt("iv5", 1).commit();}
    if(display_item_settings.p6 != -1){ sharedPreferences.edit().putInt("iv6", display_item_settings.p6).commit();}
    else{sharedPreferences.edit().putInt("iv6", 1).commit();}
    if(display_item_settings.p7 != -1){ sharedPreferences.edit().putInt("iv7", display_item_settings.p7).commit();}
    else{sharedPreferences.edit().putInt("iv7", 1).commit();}
    if(display_item_settings.p8 != -1){ sharedPreferences.edit().putInt("iv8", display_item_settings.p8).commit();}
    else{sharedPreferences.edit().putInt("iv8", 1).commit();}
    a1 = sharedPreferences.getInt("iv1", 0);a2 = sharedPreferences.getInt("iv2", 0);
    a3 = sharedPreferences.getInt("iv3", 0);a4 = sharedPreferences.getInt("iv4", 0);
    a5 = sharedPreferences.getInt("iv5", 0);a6 = sharedPreferences.getInt("iv6", 0);
    a7 = sharedPreferences.getInt("iv7", 0);a8 = sharedPreferences.getInt("iv8", 0);
    
    //getWindow().getDecorView().setSystemUiVisibility(View.GONE);
    
    title = ((TextView)findViewById(R.id.pin_desc_text_scn)); 
    title.setTextColor(cc8); title.setTextSize(size4); title.setTypeface(t4);
    b0 = ((Button)findViewById(R.id.btn0_scn));try{ b0.setOnClickListener(this);  b0.setTextColor(cc7);}catch(Exception e ){}
    b1 = ((Button)findViewById(R.id.btn1_scn));try{ b1.setOnClickListener(this);  b1.setTextColor(cc7);}catch(Exception e ){}
    b2 = ((Button)findViewById(R.id.btn2_scn));try{ b2.setOnClickListener(this);  b2.setTextColor(cc7);}catch(Exception e ){}
    b3 = ((Button)findViewById(R.id.btn3_scn));try{ b3.setOnClickListener(this);  b3.setTextColor(cc7);}catch(Exception e ){}
    b4 = ((Button)findViewById(R.id.btn4_scn));try{ b4.setOnClickListener(this);  b4.setTextColor(cc7);}catch(Exception e ){}
    b5 = ((Button)findViewById(R.id.btn5_scn));try{ b5.setOnClickListener(this);  b5.setTextColor(cc7);}catch(Exception e ){}
    b6 = ((Button)findViewById(R.id.btn6_scn));try{ b6.setOnClickListener(this);  b6.setTextColor(cc7);}catch(Exception e ){}
    b7 = ((Button)findViewById(R.id.btn7_scn));try{ b7.setOnClickListener(this);  b7.setTextColor(cc7);}catch(Exception e ){}
    b8 = ((Button)findViewById(R.id.btn8_scn));try{ b8.setOnClickListener(this);  b8.setTextColor(cc7);}catch(Exception e ){}
    b9 = ((Button)findViewById(R.id.btn9_scn));try{ b9.setOnClickListener(this);  b9.setTextColor(cc7);}catch(Exception e ){}
    
   frm = (FrameLayout)findViewById(R.id.pin_frm_scn);
                        i1 = ((ImageView)findViewById(R.id.img_1_scn));
                        i2 = ((ImageView)findViewById(R.id.img_2_scn));
                        i3 = ((ImageView)findViewById(R.id.img_3_scn));
                        i4 = ((ImageView)findViewById(R.id.img_4_scn));
                        h.add(i1);
                        h.add(i2);
                        h.add(i3);
                        h.add(i4);
                        
                        try
                        {
                          btl = ((TextView)findViewById(R.id.battery_tv));
                          
                          TextView time_id = (TextView)findViewById(R.id.time_id);
                          	
                          TextView time_apmp = (TextView)findViewById(R.id.time_AMPM);
                          
                          TextView date_id = (TextView)findViewById(R.id.date_id);
                          
                          if (Calendar.getInstance().get(9) == 0) {}
                          for (String str1 = "PM";; str1 = "AM")
                          {
                            SimpleDateFormat time1 = new SimpleDateFormat("HH:mm ");
                            SimpleDateFormat date1 = new SimpleDateFormat("E, MMM  dd, yyyy");
                            Calendar clnd = Calendar.getInstance();
                            Date today = new Date();
                            if((date_format != 0) && (date_format != 2)){str2 = time1.format(today);}
                            else{str2 = time1.format(clnd.getTime());}
                            String str3 = date1.format(clnd.getTime());
                            time_id.setText(str2); time_id.setTextColor(cc3); time_id.setTextSize(size2); time_id.setTypeface(t1);
                            time_apmp.setText(str1);
                            if(a1 == 1){time_id.setVisibility(View.VISIBLE); time_apmp.setVisibility(View.VISIBLE);}
                            else{time_id.setVisibility(View.VISIBLE); time_apmp.setVisibility(View.GONE);}
                            date_id.setText(str3); date_id.setTextColor(cc4); date_id.setTextSize(size1); date_id.setTypeface(t2);
                            if(a2 == 1){date_id.setVisibility(View.VISIBLE);} else{date_id.setVisibility(View.GONE);}
                            battery_img = ((ImageView)findViewById(R.id.battery_img));
                            if(a5 == 1){battery_img.setVisibility(View.VISIBLE);} else{battery_img.setVisibility(View.GONE);}
                            signal_img = ((ImageView)findViewById(R.id.signal_img));
                            if(a7 == 1){signal_img.setVisibility(View.VISIBLE);}else{signal_img.setVisibility(View.GONE);}
                            registerBatteryLevelReceiver();
                            displayTelephonyInfo();
                            
                            //startService(new Intent(this, MyService.class).setAction("android.intent.action.SCREEN_OFF"));
                            return;
                          }
                          
                        }
                        catch (Exception localException) {}

                        
     btncnl = ((Button)findViewById(R.id.btncancle_scn1));try{ }catch(Exception e){}
     
     btndelete = ((Button)findViewById(R.id.btndelete_scn1));try{ }catch(Exception e){}
     btncntn = (Button)findViewById(R.id.btncontinue); btncntn.setVisibility(View.GONE);
     btnok = (Button) findViewById(R.id.btnok); btnok.setVisibility(View.GONE);
     //getstr = getIntent().getStringExtra("pin_password");
     
     if(MainActivity.pin_pass != null){
    	 sharedPreferences.edit().putString("get_set", MainActivity.pin_pass).commit();
     }
     getstr = sharedPreferences.getString("get_set", "");
    
    
 //Toast.makeText(getApplicationContext(), getstr, Toast.LENGTH_SHORT).show();
 
     	btncnl.setOnClickListener(new View.OnClickListener()
    		 		{
    		 			public void onClick(View paramAnonymousView)
    		 			{
    		 				finish();
    		 			}
    		 	   });
                 
       btndelete.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			c1string();
		}
	});
  }           

  private BroadcastReceiver battery_receiver = new BroadcastReceiver()
  {
    public void onReceive(Context context, Intent intent)
    {
    	boolean isPresent = intent.getBooleanExtra("present", false);
      int scale = intent.getIntExtra("scale", -1);
      int status = intent.getIntExtra("status", 0);
      int rawlevel= intent.getIntExtra("level", -1);
      Log.i("BatteryLevel", intent.getExtras().toString());
      int level = 0;
  		Bundle bundle = intent.getExtras();
  		Log.i("BatteryLevel", bundle.toString());
  		if (isPresent) {
  			if (rawlevel >= 0 && scale > 0) {
  				level = (rawlevel * 100) / scale;
  				 batterperc = "" + level + "%";
  				 setBatteryLevelText(batterperc);
  			}
     }
      while (rawlevel < 10 || rawlevel == 9 )
      {
        battery_img.setImageResource(R.drawable.btr10);
        return;
      //setBatteryLevelText("Battery not present!!!");
        
      }
      if (rawlevel < 20 || rawlevel == 19)
      {
        battery_img.setImageResource(R.drawable.btr20);
        return;
      }
      if (rawlevel < 30 || rawlevel == 29)
      {
        battery_img.setImageResource(R.drawable.btr30);
        return;
      }
      if (rawlevel < 40 || rawlevel == 39)
      {
        battery_img.setImageResource(R.drawable.btr40);
        return;
      }
      if (rawlevel < 50 || rawlevel == 49)
      {
        battery_img.setImageResource(R.drawable.btr50);
        return;
      }
      if (rawlevel < 60 || rawlevel == 59)
      {
        battery_img.setImageResource(R.drawable.btr60);
        return;
      }
      if (rawlevel < 70 || rawlevel == 69)
      {
        battery_img.setImageResource(R.drawable.btr70);
        return;
      }
      if (rawlevel < 80 || rawlevel == 79)
      {
        battery_img.setImageResource(R.drawable.btr80);
        return;
      }
      if (rawlevel < 90 || rawlevel == 89)
      {
        battery_img.setImageResource(R.drawable.btr90);
        return;
      }
      battery_img.setImageResource(R.drawable.btrfull);
     
    }
  };


  private void displayTelephonyInfo()
  {
    TelephonyManager tm = (TelephonyManager)getSystemService("phone");
    String str = tm.getNetworkOperatorName();
    ((TextView)findViewById(R.id.operator_tv)).setText(str);
    ((TextView)findViewById(R.id.operator_tv)).setTextColor(cc1);
    if(a6 == 1){((TextView)findViewById(R.id.operator_tv)).setVisibility(View.VISIBLE);} else{((TextView)findViewById(R.id.operator_tv)).setVisibility(View.GONE);}
  }

  private String getSignalLevelString(int level)
  {
    if (level > 80)
    {
      signal_img.setImageResource(R.drawable.signalfull);
      
    }
    if (level > 60)
    {
      signal_img.setImageResource(R.drawable.signal80);
      
    }
    if (level > 40)
    {
      signal_img.setImageResource(R.drawable.signal60);      
    }
    if (level > 25)
    {
      signal_img.setImageResource(R.drawable.signal40);    
    }
    
    if (level < 10)
    {
      signal_img.setImageResource(R.drawable.signal25);    
    }
  	return null;
    
  }

  private String getStatusString(int status)
  {
  		String statusString = "Unknown";
  		switch (status) {
  		case BatteryManager.BATTERY_STATUS_CHARGING:
  			statusString = "Charging";
  			break;
  		case BatteryManager.BATTERY_STATUS_DISCHARGING:
  			statusString = "Discharging";
  			break;
  		case BatteryManager.BATTERY_STATUS_FULL:
  			statusString = "Full";
  			break;
  		case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
  			statusString = "Not Charging";
  			break;
  		}

  		return statusString;
  }


  private void setBatteryLevelText(String str)
  {
  	  	btl.setText(str); btl.setTextColor(cc2);
  }

  private void setSignalLevel(int id, int infoid, int level)
  {
  	  int progress = (int) ((((float)level)/31.0) * 100);
      
      String signalLevelString = getSignalLevelString(progress);
      
      //set the status 
      ((ProgressBar)findViewById(id)).setProgress(progress);
      
      //set the status string
      ((TextView)findViewById(infoid)).setText(signalLevelString);      
      
      Log.i("signalLevel ","" + progress);
  }


  private void registerBatteryLevelReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    registerReceiver(battery_receiver, localIntentFilter);
  }

  public void onClick(View paramView)
  {
	  
    paramView.getId();
    if (n < lb)
    {
    		title.setText("enter your pin number");
    		
    		c1.append(((Button)paramView).getText());
    		((ImageView)h.get(i)).setBackgroundResource(R.drawable.pin_image_round);    		
    		s1 = new String(c1.toString());
    		i = (1 + i);
    }        
    n = (1 + n);
    if(c1.toString().length() > 0 ){
    	btndelete.setVisibility(View.VISIBLE);
    }
    if(c1.toString().length() == lb){
    	btndelete.setVisibility(View.GONE);
    
  if(getstr.toString().equals(c1.toString())){
	
	  finish();
	  switch(unlock_animation.ua_pos){
	
	  	case 0:
	  		finish();
	  		break;
	  	case 1:
	  		finish();
	  		overridePendingTransition(0, R.anim.rotate);	
	  		break;
	  	case 2:
	  		finish();
	  		overridePendingTransition(0, R.anim.fade_out);
	  		break;
	  	case 3:
	  		finish();
	  		overridePendingTransition(0, R.anim.zoom_in);
	  		break;
	  	case 4:
	  		finish();
	  		overridePendingTransition(0, R.anim.bounce);	  		
	  		break;
	  	case 5:
	  		finish();
	  		overridePendingTransition(0, R.anim.blink);
	  		break;	  	
	  		
	  }
		
		
	  
  }else{
	  title.setText("Pin not matched");
	  c1.setLength(0);
		c1.delete(0, n);
		
		n = 0;
		do{
				((ImageView)h.get(-1 + i)).setBackgroundResource(R.drawable.pin_light);
				
				i = (i - 1);
		}while(i != 0);
  }
  }
    
  }
  
  
  public void c1string(){
		
	  if(c1.toString().length() > 0){
			
			c1.setLength(c1.length() - 1);
			c1.delete(n - 1, n );
			btndelete.setVisibility(View.VISIBLE);
			
		}else{
			String ss = " 0 string";
			//Toast.makeText(getApplicationContext(), ss, Toast.LENGTH_SHORT).show();
		}
		if(i > 0){
		
		((ImageView)h.get(-1 + i)).setBackgroundResource(R.drawable.pin_light);
		
			i = (-1 + i);				
			n = (-1 + n);
		
		}
		if(c1.toString().length() != lb){			
			
			 b0.setEnabled(true); b1.setEnabled(true); b2.setEnabled(true);b3.setEnabled(true);
                b4.setEnabled(true);b5.setEnabled(true);b6.setEnabled(true);b7.setEnabled(true);b8.setEnabled(true);
                b9.setEnabled(true); 
		}
		if(c1.toString().length() == 0 || c1.toString().length() == lb){
			btndelete.setVisibility(View.GONE);
		}
		
	  
  }
  public void onDestroy()
  {
    unregisterReceiver(battery_receiver);
    manager.removeView(view);
    super.onDestroy();
  }
  @Override
  protected void onResume()
  {
  	executeDelayed();
    super.onResume();
    Log.d("overheardword", "onResume Invoked");
  }
  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
	  executeDelayed();
  	super.onWindowFocusChanged(hasFocus);
      
  }
  public class customViewGroup extends ViewGroup {
		 
		public customViewGroup(Context context) {
			super(context);
		}

		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
		}

		@Override
		public boolean onInterceptTouchEvent(MotionEvent ev) {
			Log.v("customViewGroup", "**********Intercepted");
			return true;
		}
	}

private void executeDelayed() {
  Handler handler = new Handler();
  handler.postDelayed(new Runnable() {
      @Override
      public void run() {
          // execute after 500ms
          hideNavBar();
      }
  }, 500);
}


private void hideNavBar() {
	
   metrics1 = getResources().getDisplayMetrics();
  
  int densityDpi = (int)(metrics1.density * 160f);
  
  int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

if((screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE) ||(screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE))
{
	
	if (Build.VERSION.SDK_INT > 18) {
      View v = getWindow().getDecorView();
      v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                              | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                              | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                              | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                              | View.SYSTEM_UI_FLAG_FULLSCREEN
                              | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                              
		////getWindow().getDecorView().setSystemUiVisibility(View.GONE);
  }else{
  	getWindow().getDecorView().setSystemUiVisibility(View.GONE);	
  }

  
}else{
	if (Build.VERSION.SDK_INT > 18) {
      View v = getWindow().getDecorView();
      v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                              | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                              | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                              | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                              | View.SYSTEM_UI_FLAG_FULLSCREEN
                              | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
  }else{
  	
  }
}
}
public int getNavBarHeight(Context c) {
    int result = 0;
    boolean hasMenuKey = ViewConfiguration.get(c).hasPermanentMenuKey();
    boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);

    if(!hasMenuKey && !hasBackKey) {
        //The device has a navigation bar
        Resources resources = getBaseContext().getResources();

        int orientation = getResources().getConfiguration().orientation;
        int resourceId;
        if (isTablet(c)){
            resourceId = resources.getIdentifier(orientation == Configuration.ORIENTATION_PORTRAIT ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
        }  else {
            resourceId = resources.getIdentifier(orientation == Configuration.ORIENTATION_PORTRAIT ? "navigation_bar_height" : "navigation_bar_width", "dimen", "android");     
        }

        if (resourceId > 0) {
            return getResources().getDimensionPixelSize(resourceId);
        }
    }
    return result;
} 


private boolean isTablet(Context c) {
return (c.getResources().getConfiguration().screenLayout
       & Configuration.SCREENLAYOUT_SIZE_MASK)
       >= Configuration.SCREENLAYOUT_SIZE_LARGE;
}


}
