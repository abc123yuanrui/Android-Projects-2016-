package com.universallock;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class pin_size_set extends Activity{

	private FrameLayout frm;
	private View v11,v22;
	private ViewGroup inflater;
	private SeekBar seek1,seek2;
	private View v1,v2;
	private LinearLayout ll;
	private int progressvalue;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pin_resize_include);
		
		seek1 = (SeekBar)findViewById(R.id.seek_pin);
		seek1.setProgress(1);
		seek1.incrementProgressBy(10);
		
		seek1.setMax(700);
		seek1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
			if(fromUser){
		
				float Fl = 0;
				 int i1 = (int)(getResources().getDimensionPixelSize(R.id.pin_keypade_size));
				 progress = 700;
				progress --;
				/*if(progress < 11) progress = 700;
	            
				else if(progress < 21) progress = 650;
				
	            else if(progress < 31 ) progress = 600;
	            else if(progress < 41 ) progress = 550;
	            else if(progress < 51 ) progress = 500;
	            else if(progress < 61 ) progress = 450;
	            else if(progress < 71 ) progress = 400;
	            else if(progress < 81 ) progress = 350;
	            else if(progress < 91 ) progress = 300;
	            else if(progress > 91 ) progress = 250; */
				
				 if(progress != 0)
		                setViewHeight(progress);	  
			}
	        
			}
		});
		((FrameLayout)findViewById(R.id.pin_keypade_size)).setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)); 
	}
	private void setViewHeight(int progress)
	{
		((FrameLayout)findViewById(R.id.pin_keypade_size)).setLayoutParams(new FrameLayout.LayoutParams(progress,progress));
	}
	
	 public void count(){
		 
		 
	 if(seek1.getProgress() == 1){
		 progressvalue = 10;
		 
	  }
	  if(seek1.getProgress() == 2){
		  progressvalue = 20;
	  }
	  if(seek1.getProgress() == 3){
		  progressvalue = 30;
	  }
	  if(seek1.getProgress() == 4){
		  progressvalue = 40;
	  }
	  if(seek1.getProgress() == 5){
		  progressvalue = 50;
	  }
	  if(seek1.getProgress() == 6){
		  progressvalue = 60;
	  }
	  if(seek1.getProgress() == 7){
		  progressvalue = 70;
	  }
	  if(seek1.getProgress() == 8){
		  progressvalue = 80;
	  }
	  if(seek1.getProgress() == 9){
		  progressvalue = 90;
	  }
	  }
	/*private Handler handler = new Handler(){
	    @Override
	    public void handleMessage(final Message msgs) {
	        if(msgs.what == 1){
	        	v1 = inflater.inflate(R.layout.pin_resize_include, null);
	    		v2 = inflater.inflate(R.layout.galary_resize_include , null);
	    		v1.setVisibility(View.INVISIBLE);
	    		v2.setVisibility(View.VISIBLE);
	        }
	    }
	};*/
}
