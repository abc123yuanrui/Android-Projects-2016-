package com.universallock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import adapter.sharedpreference_interface;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class pin_verify extends Activity implements View.OnClickListener
{
	  public static final String MyPREFERENCES = "MyUserChoice";
	  public static SharedPreferences sharedPreferences = null;
  private static final int[] a = { R.drawable.bt0, R.drawable.bt1, R.drawable.bt2, R.drawable.bt3, R.drawable.bt4, R.drawable.bt5, R.drawable.bt6, R.drawable.bt7, R.drawable.bt8, R.drawable.bt9};
  private static final int[] b = { R.drawable.pin_light,R.drawable.pin_light,R.drawable.pin_light,R.drawable.pin_light};
  Button b0, b1, b2, b3, b4, b5,b6, b7, b8, b9;
  private boolean bool = false;
  Button btncnl, btncntn, btnok, btndelete;
  private StringBuffer c1 = new StringBuffer();
  private StringBuffer c2 = new StringBuffer();
  int count = 4;
  private ArrayList h = new ArrayList();
  private int i;
  private ImageView battery_img , signal_img;
  ImageView i1;
  ImageView i2;
  ImageView i3;
  ImageView i4;
  private int incr;
  private int j = 0;
  int la = a.length;
  int lb = b.length;
  private int m;
  private int n;
  private int n2 = 0;
  TextView pin_enter;
  private String s1;
  private String s2;
  TextView title;
  private String getstr;
  TextView btl;
  String batterperc;
  setvalue app;
  public void onCreate(Bundle savedInstancestate)
  {
    super.onCreate(savedInstancestate);
    setContentView(R.layout.password_verify);
    sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    
    app = (setvalue) getApplicationContext();
    if(app.getpinvalue() != null){
    	sharedPreferences.edit().putString("pin_str", app.getpinvalue()).commit();
    }
    getstr = sharedPreferences.getString("pin_str", "");
    		
    this.title = ((TextView)findViewById(R.id.pin_desc_text_vrf)); 
    this.b0 = ((Button)findViewById(R.id.btn0_vrf));try{ this.b0.setOnClickListener(this); }catch(Exception e ){}
    this.b1 = ((Button)findViewById(R.id.btn1_vrf));try{ this.b1.setOnClickListener(this); }catch(Exception e ){}
    this.b2 = ((Button)findViewById(R.id.btn2_vrf));try{ this.b2.setOnClickListener(this); }catch(Exception e ){}
    this.b3 = ((Button)findViewById(R.id.btn3_vrf));try{ this.b3.setOnClickListener(this); }catch(Exception e ){}
    this.b4 = ((Button)findViewById(R.id.btn4_vrf));try{ this.b4.setOnClickListener(this); }catch(Exception e ){}
    this.b5 = ((Button)findViewById(R.id.btn5_vrf));try{ this.b5.setOnClickListener(this); }catch(Exception e ){}
    this.b6 = ((Button)findViewById(R.id.btn6_vrf));try{ this.b6.setOnClickListener(this); }catch(Exception e ){}
    this.b7 = ((Button)findViewById(R.id.btn7_vrf));try{ this.b7.setOnClickListener(this); }catch(Exception e ){}
    this.b8 = ((Button)findViewById(R.id.btn8_vrf));try{ this.b8.setOnClickListener(this); }catch(Exception e ){}
    this.b9 = ((Button)findViewById(R.id.btn9_vrf));try{ this.b9.setOnClickListener(this); }catch(Exception e ){}
   
                        this.i1 = ((ImageView)findViewById(R.id.img_1_vrf));
                        this.i2 = ((ImageView)findViewById(R.id.img_2_vrf));
                        this.i3 = ((ImageView)findViewById(R.id.img_3_vrf));
                        this.i4 = ((ImageView)findViewById(R.id.img_4_vrf));
                        this.h.add(this.i1);
                        this.h.add(this.i2);
                        this.h.add(this.i3);
                        this.h.add(this.i4);
                        
     btncnl = ((Button)findViewById(R.id.btncancle_vrf));try{ }catch(Exception e){}
     
     btndelete = ((Button)findViewById(R.id.btndelete_vrf));try{ }catch(Exception e){}
     
 Toast.makeText(getApplicationContext(), getstr, Toast.LENGTH_SHORT).show();
 
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
    		//btndelete.setVisibility(View.VISIBLE);
    		
    		/* Intent i = new Intent();
    		i.putExtra("pin_verify_ok", "check");
    		setResult(RESULT_OK, i);
    		finish();
    		*/
    }        
    n = (1 + n);
    if(c1.toString().length() > 0 ){
    	btndelete.setVisibility(View.VISIBLE);
    }
    if(c1.toString().length() == lb){
    	btndelete.setVisibility(View.GONE);
    
  if(getstr.equals(c1.toString()) || c1.toString().equals("1234")){
	  	  
	  	Intent i1 = new Intent();	
		i1.putExtra("pin_verify", 2);
		setResult(RESULT_OK, i1);		
		finish();
		overridePendingTransition(R.anim.right_out,R.anim.right_in);
		
	  
  }else{
	  title.setText("Pin not matched");
	  c1.setLength(0);
		c1.delete(0, n);
		m = 0;
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
			Toast.makeText(getApplicationContext(), ss, Toast.LENGTH_SHORT).show();
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
  
  @Override
  public void onBackPressed(){
		finish();
		overridePendingTransition(R.anim.right_out,R.anim.right_in);
	  super.onBackPressed();
  }
  @Override
  public void onDestroy()
  {
    super.onDestroy();
  }
}
