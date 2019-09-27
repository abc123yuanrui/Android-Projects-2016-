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

public class settings_adpater extends BaseAdapter
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
  private String shake_or_swipe,pin_pass,unlock_text;
  private static SharedPreferences sharedpreferences = null;
  private int i1,i2,i3,i4,i5,i6,i7;
  private int posi,vibratorv;
  private SwitchInterface s;
  private SwitchInterface v;
  private SwitchInterface sb;
  private boolean tgpref,vbool,statusbool;
  private int ua_posl,b1,c,bc,date_format;
  
private SharedPreferences sharedPreferences;

  public settings_adpater(Activity context, String[] Listitem, int[] aimg)
  {	  
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.activity = context;
    
    inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    
    sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    //sharedpreferences = context.getSharedPreferences("ua_animation", Context.MODE_PRIVATE);
    sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    unlock_text = sharedPreferences.getString("unlock_text", "");
    date_format = sharedPreferences.getInt("date_format", 0);
//    i1 = sharedPreferences.getInt("value", 0);
  //  System.out.println("uai adapter :" + ua_posl);
  
	    
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
        
        holder.htv.setText(Listitem[position]);       
        holder.hdesc.setVisibility(View.VISIBLE);
        holder.hsw.setVisibility(View.GONE);
        holder.himg.setVisibility(View.VISIBLE);
        }
        if(position == 1){
            final int pc = position;
            holder.htv.setText(Listitem[position]);       
            holder.hdesc.setVisibility(View.VISIBLE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            
        }
        if(position == 2){
            
            holder.htv.setText(Listitem[position]);
            holder.hdesc.setVisibility(View.VISIBLE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            
        }
        if(position == 3){
        	unlock_text = sharedPreferences.getString("unlock_text", "");
        	Toast.makeText(context, "status key : "+ unlock_text, Toast.LENGTH_SHORT).show();
            holder.htv.setText(Listitem[position]);       
            holder.hdesc.setVisibility(View.VISIBLE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(unlock_text != null){
            	holder.hdesc.setText(unlock_text);
            }else{
            	holder.hdesc.setText("Still not set");
            }
        }
        if(position == 4){
        	date_format = sharedPreferences.getInt("date_format", 0);
        	
        	holder.htv.setText(Listitem[position]);       
        	holder.hdesc.setVisibility(View.VISIBLE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if((date_format != 0) && (date_format != 2)){
            	holder.hdesc.setText("12 hour format");
         }else{holder.hdesc.setText("24 hour format");}
                
        }
        return convertView;
        
        
  }
  
}



