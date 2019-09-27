package service;


import com.universallock.MainActivity;
import com.universallock.th;
import receiver.lockScreenReeiver;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

public class MyService extends Service{
	 BroadcastReceiver mReceiver;
	 private KeyguardManager.KeyguardLock k1;
	 //private KeyguardLock km;
	// Intent myIntent;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}


@Override
public void onCreate() {
	 //KeyguardManager.KeyguardLock k1;

	 //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

	 k1 =((KeyguardManager)getSystemService(KEYGUARD_SERVICE)).newKeyguardLock("lock1");
	 Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
	 Log.d("running : ","01");
     g();
     c();

     /*try{
     StateListener phoneStateListener = new StateListener();
     TelephonyManager telephonyManager =(TelephonyManager)getSystemService(TELEPHONY_SERVICE);
     telephonyManager.listen(phoneStateListener,PhoneStateListener.LISTEN_CALL_STATE);
     }catch(Exception e){
    	 System.out.println(e);
     }*/

    /* myIntent = new Intent(MyService.this,LockScreenAppActivity.class);
     myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     Bundle myKillerBundle = new Bundle();
     myKillerBundle.putInt("kill",1);
     myIntent.putExtras(myKillerBundle);*/

     IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
     filter.addAction(Intent.ACTION_SCREEN_OFF);

     mReceiver = new lockScreenReeiver();
     registerReceiver(mReceiver, filter);


    super.onCreate();


}
@Override
public void onStart(Intent intent, int startId) {
	// TODO Auto-generated method stub

	super.onStart(intent, startId);
}

/*class StateListener extends PhoneStateListener{
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        super.onCallStateChanged(state, incomingNumber);
        switch(state){
            case TelephonyManager.CALL_STATE_RINGING:
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                System.out.println("call Activity off hook");
            	getApplication().startActivity(myIntent);



                break;
            case TelephonyManager.CALL_STATE_IDLE:
                break;
        }
    }
};*/



public void r(){
	k1.reenableKeyguard();
	if(k1 != null) {
	k1 = null;	
	}
}

public void c(){
KeyguardManager	km = (KeyguardManager)getSystemService("keyguard");
Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
Log.d("running : ","02");
	if(g()){
	  if(km.inKeyguardRestrictedInputMode()){
	    	k1.disableKeyguard();
	    	Toast.makeText(getApplicationContext(), "03", Toast.LENGTH_SHORT).show();
	    	Log.d("running : ","03");
  		}
	}
  while(!km.inKeyguardRestrictedInputMode()){
	    	return;	  
  }
 r(); 
}
public boolean g(){
if(MainActivity.posit == 1){
	return true;
}else{
	r();
	return false;
	
}
}  
@Override
public void onDestroy() {
	unregisterReceiver(mReceiver);
	super.onDestroy();
	r();
	
}
}
