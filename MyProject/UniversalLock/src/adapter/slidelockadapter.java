package adapter;

import com.universallock.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class slidelockadapter extends BaseAdapter
{
  private static SharedPreferences sharedpreferences = null;
private static final LayoutInflater parent = null;
private static final String MyPREFERENCES = null;
String[] Listitem;
  int[] aimg;
  Activity context;
  SharedPreferences.Editor editor;
  LayoutInflater inflater;
  boolean[] itemchecked;
  int[] cbi;
  private String _lock_name;
  private String pin ;
  private String pin_verify;
  private String shake_or_swipe_var;
  private String shake_or_swipe;
  private String val,p1;
  private SharedPreferences pos;
  private int p,data,data1;
  public slidelockadapter(Activity context, String[] Listitem, int[] aimg, int[] cbi)
  {
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.cbi = cbi;
    pos = context.getSharedPreferences("MyPREFERENCESS", 0);
    
    //this.itemchecked = new boolean[paramArrayOfString.length];
    
    //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    
    //SharedPreferences sharedPreferences = parent.getContext().getSharedPreferences("pos1", Context.MODE_PRIVATE);
    
    sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
   
    data = context.getIntent().getIntExtra("pos", 0);
    
    //data1 = context.getIntent().getIntExtra("pin_verify_ok", 0);
    
    
    	p = sharedpreferences.getInt("pos1", data);
    
    Toast.makeText(context, "THis is adapter pos 2 "+ data1, Toast.LENGTH_SHORT).show();
    /* pin = sharedPreferences.getString("pin_password", pin);
	shake_or_swipe = sharedPreferences.getString("shake_or_swipe", shake_or_swipe);
	pin_verify = sharedPreferences.getString("pin_password_verify", pin);
	shake_or_swipe_var = sharedPreferences.getString(shake_or_swipe, shake_or_swipe); */	
	
    //p = sharedpreferences.getInt("pos1", 1); 
	
	//p1 = ""+data;
//Toast.makeText(getApplicationContext(),"this is pin :"+ pin + "this is Data : " + data, Toast.LENGTH_SHORT).show();

//	Toast.makeText(context, "THis is Data "+data, Toast.LENGTH_SHORT).show();
	
	//pos = this.context.getSharedPreferences("pos1", data);
	  
//	  p = sharedpreferences.getInt("pos1", data);
	  
	    //Toast.makeText(context, "THis is p - pos  activity "+p, Toast.LENGTH_SHORT).show();
	//	p = pos;

	
  //  Toast.makeText(context, "THis is pos 2 " + pos, Toast.LENGTH_SHORT).show();
		
  }
  
  private SharedPreferences getSharedPreferences(String mypreferences2,
		int modePrivate) {
	// TODO Auto-generated method stub
	return null;
}

public int getCount()
  {
    return this.Listitem.length;
  }
  
  public Object getItem(int position)
  {
    return null;
  }
  
  public long getItemId(int position)
  {
    return 0;
  }
  
  public class Holder
  {
	ImageView hscb;
    ImageView hsimg;
    Switch hssw;
    TextView hstv;
    
    public Holder() {}
  }
  
  
  public View getView(final int position, View convertView, ViewGroup parent)
  {
  //  this.context.getSharedPreferences("sharedPrefs", 0);
	  
	  LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    Holder localHolder;
    if (convertView == null)
    {
    	convertView = mInflater.inflate(R.layout.slidelockadapter, parent,false);
    	convertView.setMinimumHeight(90);
      
      localHolder = new Holder();
      localHolder.hstv = ((TextView)convertView.findViewById(R.id.sdl_tv));
      localHolder.hscb = ((ImageView)convertView.findViewById(R.id.sdl_cb));
      localHolder.hsimg = ((ImageView)convertView.findViewById(R.id.sdl_img));
      
      if(position ==0){
    	  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);
      if(p == 1){
    		  
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
      }else{    		  
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }
      
      }
      if(position == 1){
    	  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);
    	  if(p == 2){
    	  
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }
      }
      if(position == 2){
    	  
    		  localHolder.hstv.setText(Listitem[position] );
    		  localHolder.hsimg.setImageResource(aimg[position]);    		  
    		  if(p == 3){
    	    	  
        		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
        		  convertView.setTag(localHolder);
        	  }else{
        		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
        	  }  
    		  
      }
      
      
      //localHolder.hscb.setImageResource(aimg[position]);
      
      convertView.setTag(localHolder);
      
    }
    else{
    	localHolder = (Holder) convertView.getTag(); 
    }
	return convertView;
  
}
  }