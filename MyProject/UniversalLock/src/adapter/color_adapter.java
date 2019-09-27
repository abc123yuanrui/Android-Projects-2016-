package adapter;


import java.security.acl.NotOwnerException;
import java.util.Vector;
import com.universallock.R;

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
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class color_adapter extends BaseAdapter
{
  private static final String MyPREFERENCES = "MyUserChoice";
  protected static final SharedPreferences preferences = null;
  private static String MyPREFERENCESS = "MyUserChoicess" ;
  private static Activity activity = null;
  String[] Listitem;
  int[] aimg;
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
  private int i1,i2,i3,i4,i5,i6,i7;
  private int posi,vibratorv;
  private SwitchInterface s;
  private SwitchInterface v;
  private SwitchInterface sb;
  private boolean tgpref,vbool,statusbool;
  private int ua_posl,b1,c,bc;
  public static int p1,p2,p3,p4,p5,p6,p7,p8;
private SharedPreferences sharedPreferences;

  public color_adapter(Activity context, String[] Listitem, int[] aimg)
  {	  
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.activity = context;
    
    inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    
    sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    //sharedpreferences = context.getSharedPreferences("ua_animation", Context.MODE_PRIVATE);
    sharedPreferences = context.getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
    p1 = sharedpreferences.getInt("p1", 0);p2 = sharedpreferences.getInt("p2", 0); 
    p3 = sharedpreferences.getInt("p3", 0);p3 = sharedpreferences.getInt("p4", 0);
    p5 = sharedpreferences.getInt("p5", 0);p4 = sharedpreferences.getInt("p5", 0);
    p7 = sharedpreferences.getInt("p7", 0);p5 = sharedpreferences.getInt("p6", 0);
  }

  public int getCount()
  {
    return Listitem.length;
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
	  Holder holder = null;
	/*  sharedpreferences = context.getSharedPreferences("ua_animation", Context.MODE_PRIVATE);
	  
	  c = unlock_animation.b;
	  
		  sharedPreferences.edit().putInt("u_anim", c).commit();
		  b1 = sharedPreferences.getInt("u_anim", 0);
	  
	  
		  sharedPreferences.edit().putInt("sto_time", screen_time_out.pt).commit();
		  i4 = sharedPreferences.getInt("sto_time", 0);
	  */
	  LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	  
        if(convertView == null){
        	convertView = mInflater.inflate(R.layout.screenlock_adapter, parent,false);
     
        	holder = new Holder();       	
        	holder.htv = (TextView) convertView.findViewById(R.id.scl_tv);
        	holder.himg = (ImageView)convertView.findViewById(R.id.scl_img);
        	holder.hsw = (Switch) convertView.findViewById(R.id.scl_sw);
        	//older.hsw = (Switch) convertView.findViewById(R.id.scl_sw);
        	holder.hdesc = (TextView) convertView.findViewById(R.id.scl_desc);
       // holder.hdesc = (TextView) convertView.findViewById(R.id.scl_desc);
        convertView.setTag(holder);        
        }
       
        else{
        	holder = (Holder) convertView.getTag();
        }
        
        if(position == 0){
            p1 = sharedpreferences.getInt("p1", 0);
        holder.htv.setText(Listitem[position]);       
        holder.hdesc.setVisibility(View.GONE);
        holder.hsw.setVisibility(View.GONE);
        holder.himg.setVisibility(View.VISIBLE);
        if(p1 != 0){
        	holder.htv.setTextColor(p1);
        	
        }
        }
        if(position == 1){
        	
        	p2 = sharedpreferences.getInt("p2", 0);
            holder.htv.setText(Listitem[position]);       
            holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p2 != 0){
            	holder.htv.setTextColor(p2);
            	
            }   
        }
        if(position == 2){
            
        	p3 = sharedpreferences.getInt("p3", 0);
            holder.htv.setText(Listitem[position]);
            holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p3 != 0){
            	holder.htv.setTextColor(p3);
            	
            }
        }
        if(position == 3){
            
        	p4 = sharedpreferences.getInt("p4", 0);
            holder.htv.setText(Listitem[position]);       
            holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p4 != 0){
            	holder.htv.setTextColor(p4);
            	
            }
        }
        if(position == 4){
            
        	p5 = sharedpreferences.getInt("p5", 0);
        	holder.htv.setText(Listitem[position]);       
        	holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p5 != 0){
            	holder.htv.setTextColor(p5);
            	
            }
         }
        if(position == 5){
            
        	p6 = sharedpreferences.getInt("p6", 0);
        	holder.htv.setText(Listitem[position]);       
        	holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p6 != 0){
            	holder.htv.setTextColor(p6);
            	
            }
         }
        if(position == 6){
    
        	p7 = sharedpreferences.getInt("p7", 0);
        	holder.htv.setText(Listitem[position]);       
        	holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p7 != 0){
            	holder.htv.setTextColor(p7);
            	
            }
         }
        if(position == 7){
    
        	p8 = sharedpreferences.getInt("p8", 0);
        	holder.htv.setText(Listitem[position]);       
        	holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p8 != 0){
            	holder.htv.setTextColor(p8);
            	
            }
         }
                
        
        return convertView;
        
        
  }
  
}



