package com.universallock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StatusBarActivity
  extends Activity
{
  private static final int EXCELLENT_LEVEL = 80;
  private static final int GOOD_LEVEL = 60;
  private static final int MODERATE_LEVEL = 40;
  private static final int VERY_WEAK_LEVEL = 10;
  private static final int WEAK_LEVEL = 25;
  private ImageView battery_img;
  TextView btl;
  private ImageView btn;
  ScrollView scrl;
  private ImageView signal_img;
  private int rawlevel;
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.homescreen);
    this.btl = ((TextView)findViewById(2131427360));
    TextView time_id = (TextView)findViewById(R.id.time_id);
    TextView time_ampm = (TextView)findViewById(R.id.time_AMPM);
    TextView date_id = (TextView)findViewById(R.id.date_id);    
    
    if (Calendar.getInstance().get(9) == 0) {}
    for (String str1 = "PM";; str1 = "AM")
    {
      SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("HH:mm ");
      SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("E, MMM  dd, yyyy");
      Calendar localCalendar = Calendar.getInstance();
      String str2 = localSimpleDateFormat1.format(localCalendar.getTime());
      String str3 = localSimpleDateFormat2.format(localCalendar.getTime());
      time_id.setText(str2);
      time_ampm.setText(str1);
      date_id.setText(str3);
      battery_img = ((ImageView)findViewById(R.id.battery_img));
      signal_img = ((ImageView)findViewById(R.id.signal_img));
      registerBatteryLevelReceiver();
      displayTelephonyInfo();
      return;
    }
  }
  
  
  private BroadcastReceiver battery_receiver = new BroadcastReceiver()
  {
    public void onReceive(Context context, Intent intent)
    {
      boolean isPresent = intent.getBooleanExtra("present", false);
      int scale = intent.getIntExtra("scale", -1);
      int status = intent.getIntExtra("status", 0);
      int rawlevel = intent.getIntExtra("level", -1);
      Log.i("BatteryLevel", intent.getExtras().toString());
		int level = 0;
		Bundle bundle = intent.getExtras();
		Log.i("BatteryLevel", bundle.toString());
		if (isPresent) {
			if (rawlevel >= 0 && scale > 0) {
				level = (rawlevel * 100) / scale;
			}
      while (rawlevel <= 10)
      {
        StatusBarActivity.this.battery_img.setImageResource(R.drawable.btr10);
        return;
        //StatusBarActivity.this.setBatteryLevelText("Battery not present!!!");
      
      }
      if (rawlevel <= 20)
      {
        StatusBarActivity.this.battery_img.setImageResource(R.drawable.btr20);
        return;
      }
      if (rawlevel <= 30)
      {
        StatusBarActivity.this.battery_img.setImageResource(R.drawable.btr30);
        return;
      }
      if (rawlevel <= 40)
      {
        StatusBarActivity.this.battery_img.setImageResource(R.drawable.btr40);
        return;
      }
      if (rawlevel <= 50)
      {
        StatusBarActivity.this.battery_img.setImageResource(R.drawable.btr50);
        return;
      }
      if (rawlevel <= 60)
      {
        StatusBarActivity.this.battery_img.setImageResource(R.drawable.btr60);
        return;
      }
      if (rawlevel < 70)
      {
        StatusBarActivity.this.battery_img.setImageResource(R.drawable.btr70);
        return;
      }
      if (rawlevel < 80)
      {
        StatusBarActivity.this.battery_img.setImageResource(R.drawable.btr80);
        return;
      }
      if (rawlevel < 90)
      {
        StatusBarActivity.this.battery_img.setImageResource(R.drawable.btr90);
        return;
      }      
      else{
    	  StatusBarActivity.this.battery_img.setImageResource(R.drawable.btrfull);
      }
    }
  } 
  };
  private void displayTelephonyInfo()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)getSystemService("phone");    
    String str = localTelephonyManager.getNetworkOperatorName();
    ((TextView)findViewById(R.id.operator_tv)).setText(str);
  }
  
  private String getSignalLevelString(int level)
  {
    if (level > 80)
    {
      this.signal_img.setImageResource(R.drawable.signalfull);
      //return "Weak";
    }
    if (level > 60)
    {
      this.signal_img.setImageResource(R.drawable.signal80);
      //return "Weak";
    }
    if (level > 40)
    {
      this.signal_img.setImageResource(R.drawable.signal60);
    //  return "Weak";
    }
    if (level > 25)
    {
      this.signal_img.setImageResource(R.drawable.signal40);
      //return "Weak";
    }
    if (level > 10)
    {
      this.signal_img.setImageResource(R.drawable.signal25);
      //return "Weak";
    }
    if (level < 10)
    {
      this.signal_img.setImageResource(R.drawable.signal0);
      //return "Weak";
    }
    return level + "";
  }
  
  private String getStatusString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown";
    case 2: 
      return "Charging";
    case 3: 
      return "Discharging";
    case 5: 
      return "Full";
    }
    //return "Not Charging";
  }
  
  private void registerBatteryLevelReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    registerReceiver(this.battery_receiver, localIntentFilter);
  }
  
  private void setBatteryLevelText(String paramString)
  {
    this.btl.setText(paramString);
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
  
  protected void onResume()
  {
    super.onResume();
  }
  
}
