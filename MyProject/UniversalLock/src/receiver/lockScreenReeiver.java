package receiver;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import com.universallock.shake_or_swipe;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;

public class lockScreenReeiver extends BroadcastReceiver 
{
	Timer timer;
	TimerTask timerTask;
	private String strDate;
	private long time;
	private Intent localIntent2;
	//we are going to use a handler to be able to run in our TimerTask
	final Handler handler = new Handler();
	private Handler handler1;
	private Runnable delayRunnable;
	//private Intent localIntent2; 
	private static final String MyPREFERENCESS = "MyChoice";
	private  Context context;
	private int p,n,v,tim;
	private String n1,s1;
	private int state ;
	private SharedPreferences sharedpreferences;
	public static boolean wasScreenOn = true;
	public static boolean wasScreenOff = false;
	public static boolean off;
	private StringBuffer sb;
	private String aray,l1,l2,l3,l4,l5,l6,l7,l8,l9,swipe_data1,swipe_data2,swipe_data3,swipe_data4,swipe_data5,
	swipe_data6,swipe_data7,swipe_data8,swipe_data9;
	private int a1,a2,a3,a4,a5,a6,a7,a8,a9,s11,s2,s3,s4,s5,s6,s7,s8,s9;
	private int milliseconds,secs;
	long timeInMilliseconds = 0L;
	long timeSwapBuff = 0L;
	long updatedTime = 0L;
	private long startTime = 0L;
	private Handler customHandler = new Handler();
	private AlarmManager alarm;	
	private Calendar calendar;
	private int posi,sto,possi,stto,delay;
	private ContentResolver ContentResolver;
	private PowerManager P;
	private ActivityManager A;
	public static String lc = null,tims;
	
	@Override
public void onReceive(Context context, Intent intent)
  {
		
	sharedpreferences = context.getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
	//p = sharedpreferences.getInt("receiver_value", 0);
	
	  if(intent.getAction().equals("my.action.string3")){     
		     
		    p = intent.getIntExtra("value9", 0);
		    sharedpreferences.edit().putInt("lock2", p).commit();	    
		    	
		    	v = sharedpreferences.getInt("lock2", 0);
			    sharedpreferences.edit().putInt("valop", v).commit();
			    System.out.println("reciever p :" + p);
			    System.out.println("reciever v :" + v);
		    
	  }
	  if(intent.getAction().equals("my.action.string")){
		    tim = intent.getIntExtra("stimeo", 0);
		    tims = Integer.toString(tim);		
		    sharedpreferences.edit().putString("time_out", tims).commit();
		    //Toast.makeText(context, "+++++++++++++ "+p, Toast.LENGTH_SHORT).show();  
		        	
		    
		 }
	  if(intent.getAction().equals("my.action.string2")){     
		     
		    tim = intent.getIntExtra("stimeo", 0);
		    tims = Integer.toString(tim);
		    sharedpreferences.edit().putString("time_out", tims).commit();
		    tims = sharedpreferences.getString("time_out","");
		    Log.d("screen_time_out : " ,tims);
		        	
		 }
	  	
	  if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
		  {
		  wasScreenOn= true;
			  //off = true;
				n = sharedpreferences.getInt("valop", 0);		  
			  System.out.println("reciever value :" + n);
		//	android.provider.Settings.System.getInt(ContentResolver,Settings.System.SCREEN_OFF_TIMEOUT	
  			//Toast.makeText(context, "stto : "+stto, Toast.LENGTH_SHORT).show();
      		Intent localIntent2 = new Intent(context, shake_or_swipe.class);
      		localIntent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      		localIntent2.putExtra("val", n);      		
	    	context.startActivity(localIntent2);	    	
  		}
    
	else if (intent.getAction().equals("android.intent.action.SCREEN_ON"))
      {
		
        wasScreenOn = true;
        //9v = sharedpreferences.getInt("lock2", 0);
  		Intent localIntent2 = new Intent(context,shake_or_swipe.class);
  		localIntent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  		
  		
      }
	else if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
      {
		//tims = sharedpreferences.getString("time_out","");
  	  	//v = sharedpreferences.getInt("lock2", 0);
  	      		Intent localIntent2 = new Intent(context, shake_or_swipe.class);
  	      		localIntent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  	      		//localIntent2.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
  	      		localIntent2.putExtra("val", v);
  	      		context.startActivity(localIntent2);

     }
 		
    }
  
}

