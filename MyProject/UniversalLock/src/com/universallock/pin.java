package com.universallock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView.Validator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class pin extends Activity implements View.OnClickListener
{
 
  public static final String MyPREFERENCES = "MyUserChoice";
  public static SharedPreferences sharedPreferences = null;
  public static setvalue sv;
  private static final int[] a = { R.drawable.bt0, R.drawable.bt1, R.drawable.bt2, R.drawable.bt3, R.drawable.bt4, R.drawable.bt5, R.drawable.bt6, R.drawable.bt7, R.drawable.bt8, R.drawable.bt9};
  private static final int[] b = { R.drawable.pin_light,R.drawable.pin_light,R.drawable.pin_light,R.drawable.pin_light};
  Button b0, b1, b2, b3, b4, b5,b6, b7, b8, b9;
  private boolean bool;
  private boolean bool1 = false;
  Button btncnl, btncntn, btnok, btndelete,btnreset;
  private StringBuffer c1 = new StringBuffer();
  private StringBuffer c2 = new StringBuffer();
  int count = 4;
  private ArrayList h = new ArrayList();
  private int i = 0;
  ImageView i1;
  ImageView i2;
  ImageView i3;
  ImageView i4;
  private int incr;
  private int j = 0;
  int la = a.length;
  int lb = b.length;
  private int m;
  private int n ;
  private int n2 = 0;
  TextView pin_enter;
  private String s1;
  private String s2;
  TextView title;
  private View hiddenpanel;
  private boolean isPanelShown;
  LinearLayout ll;
  public static String ss = null;
  private setvalue app;
  
  public void onCreate(Bundle savedInstancestate)
  {
    super.onCreate(savedInstancestate);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.password_main);
    app = (setvalue) getApplicationContext();
  	sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    this.title = ((TextView)findViewById(R.id.pin_desc_text)); 
    this.b0 = ((Button)findViewById(R.id.btn0));try{ this.b0.setOnClickListener(this); this.b0 = ((Button)findViewById(R.id.btn0));}catch(Exception e ){}
    this.b1 = ((Button)findViewById(R.id.btn1));try{ this.b1.setOnClickListener(this); this.b1 = ((Button)findViewById(R.id.btn1));}catch(Exception e ){}
    this.b2 = ((Button)findViewById(R.id.btn2));try{ this.b2.setOnClickListener(this); this.b2 = ((Button)findViewById(R.id.btn2));}catch(Exception e ){}
    this.b3 = ((Button)findViewById(R.id.btn3));try{ this.b3.setOnClickListener(this); this.b3 = ((Button)findViewById(R.id.btn3));}catch(Exception e ){}
    this.b4 = ((Button)findViewById(R.id.btn4));try{ this.b4.setOnClickListener(this); this.b4 = ((Button)findViewById(R.id.btn4));}catch(Exception e ){}
    this.b5 = ((Button)findViewById(R.id.btn5));try{ this.b5.setOnClickListener(this); this.b5 = ((Button)findViewById(R.id.btn5));}catch(Exception e ){}
    this.b6 = ((Button)findViewById(R.id.btn6));try{ this.b6.setOnClickListener(this); this.b6 = ((Button)findViewById(R.id.btn6));}catch(Exception e ){}
    this.b7 = ((Button)findViewById(R.id.btn7));try{ this.b7.setOnClickListener(this); this.b7 = ((Button)findViewById(R.id.btn7));}catch(Exception e ){}
    this.b8 = ((Button)findViewById(R.id.btn8));try{ this.b8.setOnClickListener(this); this.b8 = ((Button)findViewById(R.id.btn8));}catch(Exception e ){}
    this.b9 = ((Button)findViewById(R.id.btn9));try{ this.b9.setOnClickListener(this); this.b9 = ((Button)findViewById(R.id.btn9));}catch(Exception e ){}
   
                        this.i1 = ((ImageView)findViewById(R.id.img_1));
                        this.i2 = ((ImageView)findViewById(R.id.img_2));
                        this.i3 = ((ImageView)findViewById(R.id.img_3));
                        this.i4 = ((ImageView)findViewById(R.id.img_4));
                        this.h.add(this.i1);
                        this.h.add(this.i2);
                        this.h.add(this.i3);
                        this.h.add(this.i4);
     this.btncnl = ((Button)findViewById(R.id.btncancle));try{ }catch(Exception e){}
     this.btncntn = ((Button)findViewById(R.id.btncontinue));try{  btncntn.setVisibility(View.GONE); }catch(Exception e){}
     this.btnok = ((Button)findViewById(R.id.btnok));try{ btnok.setVisibility(View.GONE);}catch(Exception e){}
     this.btndelete = ((Button)findViewById(R.id.btndelete));try{  btndelete.setVisibility(View.GONE);}catch(Exception e){}
//     this.btnreset = ((Button)findViewById(R.id.btnreset));try{ this.btnreset.setBackgroundResource(R.drawable.round_corner); btnreset.setVisibility(View.GONE);}catch(Exception e){}
     ll = (LinearLayout)findViewById(R.id.light_ll);


     isPanelShown = false;
     bool = true;
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
     	btncnl.setOnClickListener(new View.OnClickListener()
    		 		{
    		 			public void onClick(View paramAnonymousView)
    		 			{
    		 				c2.setLength(0);
    		 				overridePendingTransition(R.anim.right_out,R.anim.right_in);
    		 				finish();
    		 				
    		 			}
    		 	   });
         

     	btncntn.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View v)
              {
            	  btndelete.setVisibility(View.GONE);
            	  title.setText("Re-enter your pin number");
            	             	  
            	//pin_enter.setText("");
                bool = false;
                bool1 = true;
                n = 4;
                do
                {
                  ((ImageView)h.get(-1 + i)).setBackgroundResource(R.drawable.pin_light);
                  i = (-1 + i);
                } while (i != 0);
                
                b0.setEnabled(true); b1.setEnabled(true); b2.setEnabled(true);b3.setEnabled(true);
                b4.setEnabled(true);b5.setEnabled(true);b6.setEnabled(true);b7.setEnabled(true);b8.setEnabled(true);
                b9.setEnabled(true); 
   
                btncntn.setVisibility(View.GONE);
              }              
            });            

       btnok.setOnClickListener(new View.OnClickListener()
       {
    	   public void onClick(View v)
    	   {
    		   if (!c1.toString().equals(c2.toString()))
    		   {
    			   title.setText("Pin number not matched");
    			  
    			   c2.setLength(0);
    			   c2.delete(0, m);
    			   m = 0;
    			   b0.setEnabled(true); b1.setEnabled(true); b2.setEnabled(true);b3.setEnabled(true);
                   b4.setEnabled(true);b5.setEnabled(true);b6.setEnabled(true);b7.setEnabled(true);b8.setEnabled(true);
                   b9.setEnabled(true);    			 
                   do
    			   {
    				   ((ImageView)h.get(i - 1)).setBackgroundResource(R.drawable.pin_light);
    				   i = (i - 1);
    			   } while (i != 0);
    			   
    		   }else{
    			   //sv.setpinvalue(c1.toString());
    			   	app.setpinvalue(c1.toString());    			   
    			   Intent i = new Intent();
    			   
    			   sharedPreferences.edit().putString("password", c1.toString()).commit();
    			   ss = sharedPreferences.getString("password", "");
	    			   
    			   i.putExtra("pin_password", ss);
    			   setResult(RESULT_OK,i);    			   
    			   finish();    			   
    			   overridePendingTransition(R.anim.right_out,R.anim.right_in);
    		   }
    	   }
       });
       
       
       btndelete.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(n < lb){
			if(c1.length() > 0){
				c1string();	
			}
			else
			{
			Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
			}
		}
			else
			if(c2.length() > 0 ){
			      c2string();
			}
		
		}
	});
       

  }     	

  public void onClick(View paramView)
  {
	  
	  if(bool){
		  
	  
	  if(n < lb){
		  c1.append(((Button)paramView).getText());
		  ((ImageView)h.get(i)).setBackgroundResource(R.drawable.pin_image_round);
//		  pin_enter.setText(c1.toString() + " c1 : "+c1.toString().length()+ " n :" + n );
		  i = (1 + i);
		  
		  btndelete.setVisibility(View.GONE);
		  n++;
	  }
	  if(n > 0){
		  btndelete.setVisibility(View.VISIBLE);
	  }
	  if(c1.toString().length() == lb){
		  btncntn.setVisibility(View.VISIBLE);b0.setEnabled(false);b1.setEnabled(false);b2.setEnabled(false);
	      b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);b6.setEnabled(false);
	      b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);     
	      btndelete.setVisibility(View.GONE);	      
	      //ll.setVisibility(View.GONE);	      
	  }   
	  
	  }else{
		  
		  if( (m < lb) && (!c1.toString().equals(c2.toString()))){
			  c2.append(((Button)paramView).getText());
			  ((ImageView)h.get(i)).setBackgroundResource(R.drawable.pin_image_round);
//			  pin_enter.setText(c2.toString() + " c2 : "+c2.toString().length()+ " m :" + m );
			  i = (1 + i);			  
			  btndelete.setVisibility(View.GONE);
			  m++;
		  }
		  if(m > 0){
			  btndelete.setVisibility(View.VISIBLE);
		  }
		  
		  if(c2.toString().length() == lb){
			  btnok.setVisibility(View.VISIBLE);b0.setEnabled(false);b1.setEnabled(false);b2.setEnabled(false);
		      b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);b6.setEnabled(false);
		      b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);     
		      btndelete.setVisibility(View.GONE);
		      
		      //slideUpDown(hiddenpanel);		      
		  }   
	  }
  
  }
  
  public void c1string(){
	
	  if(c1.toString().length() > 0){
			
			c1.setLength(c1.length() - 1);
			c1.delete(n - 1, n );
			
			
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
			btncntn.setVisibility(View.GONE);
			 b0.setEnabled(true); b1.setEnabled(true); b2.setEnabled(true);b3.setEnabled(true);
                b4.setEnabled(true);b5.setEnabled(true);b6.setEnabled(true);b7.setEnabled(true);b8.setEnabled(true);
                b9.setEnabled(true); 
		}
		if(c1.toString().length() == 0){
			btndelete.setVisibility(View.GONE);
		}
	  
  }
  public void c2string(){
	if(c2.toString().length() > 0){
			
			c2.setLength(c2.length() - 1);
			c2.delete(m - 1 ,m);
			
		}else{
			String ss = " 0 string";
			Log.i(ss, "running ss");
			//Toast.makeText(getApplicationContext(), ss, Toast.LENGTH_SHORT).show();
		}
		if(i > 0){
		
		((ImageView)h.get(-1 + i)).setBackgroundResource(R.drawable.pin_light);
		
			i = (-1 + i);				
			m = (-1 + m);
			//m = (m - 1);
		}
		if(c2.toString().length() != lb){					
			btnok.setVisibility(View.GONE);
			 b0.setEnabled(true); b1.setEnabled(true); b2.setEnabled(true);b3.setEnabled(true);
                b4.setEnabled(true);b5.setEnabled(true);b6.setEnabled(true);b7.setEnabled(true);b8.setEnabled(true);
                b9.setEnabled(true); 
		}
		  
  }
}
