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

public class text_size_adapter extends BaseAdapter
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

  public text_size_adapter(Activity context, String[] Listitem, int[] aimg)
  {	  
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    
    
    sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    //sharedpreferences = context.getSharedPreferences("ua_animation", Context.MODE_PRIVATE);
    sharedPreferences = context.getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
    
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
        holder.htv.setText(Listitem[position]);       
        holder.hdesc.setVisibility(View.GONE);
        holder.hsw.setVisibility(View.GONE);
        holder.himg.setVisibility(View.VISIBLE);
        if(p1 != 0){
        	convertView.setBackgroundColor(p1);
        	
        }
        }
        if(position == 1){
        	
            holder.htv.setText(Listitem[position]);       
            holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p2 != 0){
            	convertView.setBackgroundColor(p2);
            	
            }   
        }
        if(position == 2){
            
            holder.htv.setText(Listitem[position]);
            holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p3 != 0){
            	convertView.setBackgroundColor(p3);
            	
            }
        }
        if(position == 3){
            
            holder.htv.setText(Listitem[position]);       
            holder.hdesc.setVisibility(View.GONE);
            holder.hsw.setVisibility(View.GONE);
            holder.himg.setVisibility(View.VISIBLE);
            if(p3 != 0){
            	convertView.setBackgroundColor(p3);
            	
            }
    
         }
                
        
        return convertView;
        
        
  }
  
}



