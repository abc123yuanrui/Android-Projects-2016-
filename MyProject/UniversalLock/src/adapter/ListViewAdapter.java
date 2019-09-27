	package adapter;


import java.security.acl.NotOwnerException;
import java.util.Vector;
import com.squareup.picasso.Picasso;
import com.universallock.R;
import com.universallock.screen_time_out;
import com.universallock.unlock_animation;

import android.R.string;
import android.app.Activity;
import android.content.ClipData.Item;
import android.content.SharedPreferences.Editor;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ListViewAdapter<list> extends BaseAdapter
{
  private static final String MyPREFERENCES = "MyUserChoice";
  protected static final SharedPreferences preferences = null;
  private static String MyPREFERENCESS = "MyUserChoicess" ;
  private static Activity activity = null;
  String[] Listitem;
  private int[] aimg;
  Activity context;
  //screenlockdata[] data;
  TextView desc;
  String[] desc1;
  SharedPreferences getpref;
  LayoutInflater inflater;
  Switch sw;
  private int data,data1;
  private String shake_or_swipe,pin_pass;
  private static SharedPreferences sharedpreferences = null;
  private int i1,i2,i3,i4,i5,i6,i7,count;
  public static int i8;
  private int posi,vibratorv;
  private SwitchInterface s;
  private SwitchInterface v;
  private SwitchInterface sb;
  private SwitchInterface lsb;
  private boolean tgpref,vbool,statusbool,lockbool1,lockbool2,lockbool3,lsbbool;
  private int ua_posl,b1,c,bc,sw1,che;
 
private SharedPreferences sharedPreferences;

  public ListViewAdapter(Activity context, String[] Listitem,int[] aimg, SwitchInterface s,SwitchInterface v,SwitchInterface sb,SwitchInterface lsb)
  {	  
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.activity = context;
    this.s = s;
    this.v = v;
    this.sb = sb;
    this.lsb = lsb;
    inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    
    sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    sharedPreferences = context.getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
    i2 = sharedPreferences.getInt("switch_key", 0);
    i3 = sharedPreferences.getInt("vibrator_key", 0);
    i4 = sharedpreferences.getInt("ptm", 0);
    i5 = sharedpreferences.getInt("posld", 0);
    i6 = sharedpreferences.getInt("screen_sld",0);
    i7 = sharedPreferences.getInt("statusbar_key", 0);
    i8 = sharedPreferences.getInt("lsb_value", 0);
    //ua_posl = sharedpreferences.getInt("uai_main", 0);
    c = sharedpreferences.getInt("animation", 0);
    b1 = c;
    
    //sharedPreferences.edit().putInt("oncreate_key", che).commit();
    
    sw1 = sharedPreferences.getInt("oncreate_key", 0);
    posi();
    System.out.println("uai adapter :" + ua_posl);
    Toast.makeText(context, "status key : "+ i7, Toast.LENGTH_SHORT).show();  
   if(i2 == 1 || sw1 == 0){  tgpref = true; }else { tgpref = false; }
   if(i3 == 1 || sw1 == 0){ 
	   vbool = true;	   
   }else{
	   vbool = false;
   }
   if(i7 == 1 || sw1 == 0){
	   statusbool = true;
   }else{
	   statusbool = false;
   }
   if(i8 == 1 || sw1 == 0){ lsbbool = true;  }else{lsbbool = false;}
  }
  
  public int getCount()
  {
    return 16;
  }
  
  @Override
  public Object getItem(int position) {
  	// TODO Auto-generated method stub
  	return null;
  }
  
  public long getItemId(int position)
  {
	  
    return position;
    
  }
  
  public class Holder
  {
    TextView hdesc;
    ImageView himg;
    Switch hsw;
    TextView htv;
    int posi,vibratorv;
    
    public Holder() {}
  }
  
   
  
  @Override
  	public View getView( int position, View convertView, ViewGroup parent)
  {
	   
	  sharedpreferences = context.getSharedPreferences("ua_animation", Context.MODE_PRIVATE);
	  sharedPreferences = context.getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
	  Holder holder = null;
	  c = unlock_animation.b;
	  	  
		  sharedPreferences.edit().putInt("u_anim", c).commit();
		  b1 = sharedPreferences.getInt("u_anim", 0);
		  sharedPreferences.edit().putInt("sto_time", screen_time_out.pt).commit();				  
		  i4 = sharedPreferences.getInt("ptm", 0);
		  i2 = sharedPreferences.getInt("switch_key", 0);
		  i3 = sharedPreferences.getInt("vibrator_key", 0);
		  i7 = sharedPreferences.getInt("statusbar_key", 0);
		  i8 = sharedPreferences.getInt("lsb_value", 0);
		  if(i2 == 1 || sw1 == 0){  tgpref = true; }else { tgpref = false; }
		  int i = 0;
		  int position1 = getViewTypeCount();
		   if(i3 == 1 || sw1 == 0){vbool = true;}else{vbool = false;}
		   if(i7 == 1 || sw1 == 0){statusbool = true;}else{statusbool = false;}
		   if(i8 == 1 || sw1 == 0){ lsbbool = true;  }else{lsbbool = false;}
	  LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
  	
	  	convertView = null;
        if(convertView == null){

        	convertView = mInflater.inflate(R.layout.screenlock_adapter, parent,false);
        	
        	holder = new Holder();   	
        	holder.htv = (TextView) convertView.findViewById(R.id.scl_tv);
        	holder.himg = (ImageView) convertView.findViewById(R.id.scl_img);
        	holder.hsw = (Switch) convertView.findViewById(R.id.scl_sw);
        	holder.hdesc = (TextView) convertView.findViewById(R.id.scl_desc);        
        	convertView.setTag(holder);
        	
        }
        /*else{      	        	
        	holder = (Holder) convertView.getTag();
        	 
        }*/
        	
        
        if(position  == 0){
        		        
        holder.htv.setText(Listitem[position]);        
        holder.hdesc.setVisibility(View.GONE);        
        holder.hsw.setVisibility(View.GONE);
        
        Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
        	holder.himg.setVisibility(View.VISIBLE);
        }            
        if(position == 1){
            holder.htv.setText(Listitem[position]);            
            holder.himg.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.VISIBLE);            
            holder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // do something, the isChecked will be
                    // true if the switch is in the On position
                	 if(!isChecked ){
                		 
                		posi = 0; 
                		s.setValues(0);
                		che  = 1;
            	    	sharedPreferences.edit().putInt("oncreate_key", che).commit();
            	    	sw1 = sharedPreferences.getInt("oncreate_key", 0);
            	    	Toast.makeText(context, "sw1 : "+sw1, Toast.LENGTH_SHORT).show();		
                	    }else{
                	    	
                	    	posi = 1;
                	    	s.setValues(1);
                	  
                	    }
                } 
            });
            if(!tgpref ){
            		holder.hsw.setChecked(false);
               			
            }else
            {
            	holder.hsw.setChecked(true);
             	
            	            	
            }
            
        }
            if(position == 2){
            	i1 = sharedPreferences.getInt("value1", 0);        	
            holder.htv.setText(Listitem[position]);
            Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
            holder.hsw.setVisibility(View.GONE);
            
            switch(i1){
            
            case 0:
            	holder.hdesc.setText("None");
            	break;
            case 1:
            	holder.hdesc.setText("None");
            	break;
            case 2:
            	holder.hdesc.setText("pin");
            	break;
            case 3:
            	holder.hdesc.setText("Small galary lock");
            	break;
            }
            
            }
            if(position == 3){
        	
            holder.htv.setText(Listitem[position]);
            holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
            holder.himg.setVisibility(View.VISIBLE);
            
            }
            if(position == 4){
        	
        	holder.htv.setText(Listitem[position]);
            holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.VISIBLE);
            holder.himg.setVisibility(View.GONE);
            //holder.himg.setVisibility(View.GONE);
            holder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(!isChecked ){
               		 
                	 vibratorv = 0;
						v.setValue(0);
                	    }else{
                	    vibratorv = 1;
                	    	v.setValue(1);
                	    }
					}
			});
            if(vbool ){
            		holder.hsw.setChecked(true);
            }else{
            	holder.hsw.setChecked(false);
            }
            }
            if(position == 5){
        	
        	holder.htv.setText(Listitem[position]);
        	Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
            holder.hsw.setVisibility(View.GONE);
            holder.hdesc.setVisibility(View.GONE);           
            
            }
            if(position == 6){

            //Toast.makeText(context, "lsb from adapter : "+i8, Toast.LENGTH_SHORT).show();
        	holder.htv.setText(Listitem[position]);  
        	holder.himg.setVisibility(View.GONE);        	
        	holder.hdesc.setVisibility(View.GONE);
        	holder.hsw.setVisibility(View.VISIBLE);        	
        	
        	holder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					
						if(isChecked){ lsb.setlsb(1); }else{lsb.setlsb(0);}
				}
			});
        	if(lsbbool ){
            		holder.hsw.setChecked(true);
        	}else{holder.hsw.setChecked(false);}
            }
            if(position == 7){
            
            Toast.makeText(context, "i4 : "+i4, Toast.LENGTH_SHORT).show();
        	holder.htv.setText(Listitem[position]);
        	holder.hdesc.setVisibility(View.VISIBLE);        	
        	holder.hsw.setVisibility(View.GONE);        
        	Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
        	
        	if(i4 == 1){holder.hdesc.setText("0s");}
        	else if(i4 == 2){holder.hdesc.setText("3s");}
        	else if(i4 == 3){holder.hdesc.setText("5s");}
        	else if(i4 == 4){holder.hdesc.setText("15s");}
        	else if(i4 == 5){holder.hdesc.setText("30s");}
        	else if(i4 == 6){holder.hdesc.setText("1m");}
        	else{holder.	hdesc.setText("Default");}
        	
            }
            if(position == 8){
        	
        	holder.htv.setText(Listitem[position]);
        	Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
            holder.hsw.setVisibility(View.GONE);            
            switch(b1){
            	
            case 0:
            	holder.hdesc.setText("None");       
            	break;
            case 1:
            	holder.hdesc.setText("Rotate");
            	break;
            case 2:
            	holder.hdesc.setText("Fade");
            	break;
            case 3:
            	holder.hdesc.setText("Zoom");
            	break;
            case 4:
            	holder.hdesc.setText("Bounce");
            	break;
            case 5:
            	holder.hdesc.setText("Blink");
            	break;
            }
            
            }
            if(position == 9){
            	
        	Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
        	holder.htv.setText(Listitem[position]);
            holder.hsw.setVisibility(View.GONE);
            
            
            
            }
            if(position == 10){
        	
        	holder.htv.setText(Listitem[position]);
        	holder.himg.setVisibility(View.GONE);
            holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.VISIBLE);            

            holder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(!isChecked ){
               		 
						sb.setstatusbar(0);
                		
                	    }else{
                	   // sb = "0";
                	    	sb.setstatusbar(1);
                	    }
					}
			});
            if(statusbool){
            		holder.hsw.setChecked(true);
            }else{
            	holder.hsw.setChecked(false);
            }
            
            }
            if(position == 11){
        	
        	holder.htv.setText(Listitem[position]);
        	Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
        	holder.hdesc.setVisibility(View.GONE);
        	holder.hsw.setVisibility(View.GONE);
        	
        	
            }
            if(position == 12){
        	
        	holder.htv.setText(Listitem[position]);        	
        	Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
        	holder.hdesc.setVisibility(View.GONE);
        	holder.hsw.setVisibility(View.GONE);
        	
        	
            }
            if(position == 13){
        	
        	holder.htv.setText(Listitem[position]);             	
        	Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
        	holder.hdesc.setVisibility(View.VISIBLE);
        	holder.hsw.setVisibility(View.GONE);
        	
            }
            if(position == 14){
        	
        	holder.htv.setText(Listitem[position]);        	
        	Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
        	holder.hdesc.setVisibility(View.GONE);
        	holder.hsw.setVisibility(View.GONE);
        	
            }
            if(position == 15){
        		
        	holder.htv.setText(Listitem[position]);        	
        	Picasso.with(this.context).load(R.drawable.dir_arrow).into(holder.himg);
        	holder.hdesc.setVisibility(View.GONE);
        	holder.hsw.setVisibility(View.GONE);
        	
        }
       
        return convertView;
        
  }
  
 public void posi(){
	 sharedpreferences.edit().putInt("ua_anim", unlock_animation.b).commit();
	 bc = sharedpreferences.getInt("ua_anim", 0);
 }

 
 
}



