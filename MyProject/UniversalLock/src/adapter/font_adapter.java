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
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.text.style.TypefaceSpan;
import android.util.Log;
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

public class font_adapter extends BaseAdapter
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
  private static SharedPreferences sharedpreferences;
  private int i1,i2,i3,i4,i5,i6,i7;
  private int posi,vibratorv;
  private SwitchInterface s;
  private SwitchInterface v;
  private SwitchInterface sb;
  private boolean tgpref,vbool,statusbool;
  private int ua_posl,b1,c,bc;
  public static String p1,p2,p3,p4,p5,p6,p7,p8;
  private Typeface tf1,tf2,tf3,tf4,t1;
  
private SharedPreferences sharedPreferences;

  public font_adapter(Activity context, String[] Listitem, int[] aimg)
  {	  
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.activity = context;
    
    t1 = Typeface.createFromAsset(context.getAssets(), "fonts/f1.ttf");
    
    inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    
    sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    sharedPreferences = context.getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
    
    p1 = sharedpreferences.getString("f1", ""); p2 = sharedpreferences.getString("f2", ""); 
    p3 = sharedpreferences.getString("f3", ""); p4 = sharedpreferences.getString("f4", "");
    
    if(p1.length() > 0 && p1 != null){
    	tf1 = Typeface.createFromAsset(context.getAssets(), p1);	
    }
    if(p2.length() > 0  && p2 != null){
    	tf2 = Typeface.createFromAsset(context.getAssets(), p2);	
    }
    if(p3.length() > 0  && p3 != null){
    	tf3 = Typeface.createFromAsset(context.getAssets(), p3);	
    }
    if(p4.length() > 0  && p4 != null){
    	tf4 = Typeface.createFromAsset(context.getAssets(), p4);
    }
    
    Log.d("type face : ",tf1.toString());
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
            p1 = sharedpreferences.getString("f1", "");            
            tf1 = Typeface.createFromAsset(context.getAssets(), p1);            
            holder.htv.setText(Listitem[position]);       
            holder.hdesc.setVisibility(View.VISIBLE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
        	if(tf1 != null  && tf1 != null){
        		holder.hdesc.setText("Clock Font");
        		holder.hdesc.setTypeface(tf1);
        	}else{        		
        		holder.hdesc.setText("Clock Font");
        		holder.hdesc.setTypeface(t1);
        	}
        }
        if(position == 1){
        	
        	p2 = sharedpreferences.getString("f2", "");        	
        	tf2 = Typeface.createFromAsset(context.getAssets(), p2);        	
            holder.htv.setText(Listitem[position]);       
            holder.hdesc.setVisibility(View.VISIBLE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(tf2 != null  && tf2 != null){
            	holder.hdesc.setText("Date Font");
            	holder.hdesc.setTypeface(tf2);
            }else{
            	holder.hdesc.setText("Date Font");
            	holder.hdesc.setTypeface(t1);
            }   
        }
        if(position == 2){
            
        	p3 = sharedpreferences.getString("f3", "");
        	tf3 = Typeface.createFromAsset(context.getAssets(), p3);
            holder.htv.setText(Listitem[position]);
            holder.hdesc.setVisibility(View.VISIBLE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(tf3 != null  && tf3 != null){
            	holder.hdesc.setText("Unlock Text Font");
            	holder.hdesc.setTypeface(tf3);
            }else{
            	holder.hdesc.setText("Unlock Text Font");            	
            	holder.hdesc.setTypeface(t1);
            }
        }
        if(position == 3){
            
        	p4 = sharedpreferences.getString("f4", "");
        	tf4 = Typeface.createFromAsset(context.getAssets(), p4);
            holder.htv.setText(Listitem[position]);       
            holder.hdesc.setVisibility(View.VISIBLE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(tf4 != null  && tf4 != null){
            	holder.hdesc.setText("Pin / Small Gallery Text Font");
            	holder.hdesc.setTypeface(tf4);
            }else{
            	holder.hdesc.setText("Pin / Small Gallery Text Font");
            	holder.hdesc.setTypeface(t1);
            }
        }
        
        return convertView;
        
  }
  
}



 