package com.universallock;

import service.MyService;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class th extends Activity {

	public static int j;
	/*	 KeyguardManager.KeyguardLock k1;

	 public void onAttachedToWindow() {
			// TODO Auto-generated method stub
			 this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
			super.onAttachedToWindow();
		}*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(getApplicationContext(), "I am Started", Toast.LENGTH_SHORT).show();
		
		setContentView(R.layout.th);
		Button b = (Button)findViewById(R.id.btn1);
		Button c = (Button)findViewById(R.id.btn2);
		Button d = (Button)findViewById(R.id.btn3);
		b.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
			Intent i = new Intent(th.this,StartLockScreen.class);
			startActivity(i);
	}
});
		c.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				starts();
						j = 1;
			}
		});
		d.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stops();
				j = 0;
			}
		});

		/*getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
	        KeyguardManager km =(KeyguardManager)getSystemService(KEYGUARD_SERVICE);
	        k1 = km.newKeyguardLock("IN");
	        k1.disableKeyguard();*/


	}
	public void starts(){
		//startService(new Intent(this,MyService.class));
		Intent i = new Intent(th.this,MyService.class);
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
