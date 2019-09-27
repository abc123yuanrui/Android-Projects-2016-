package adapter;

import com.universallock.R;
import com.universallock.screen_time_out;

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

public class screen_time_out_adapter extends BaseAdapter
{
  private static SharedPreferences sharedpreferences = null;
private static final LayoutInflater parent = null;
public static final String MyPREFERENCES = "screen_time_out";
public static  String MyPREFERENCESS = "screen_time_out_choice";
private SharedPreferences sharedPreferences;
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
  private int p,data,data1,pta;
  private unlock_animation_interface sto_pos ;
  private static Activity activity = null;
  public screen_time_out_adapter(Activity context, String[] Listitem, int[] aimg, int[] cbi,unlock_animation_interface sto_pos)
  {
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.cbi = cbi;
    this.sto_pos = sto_pos;
    this.activity = context;
        
    inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    sharedPreferences = context.getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
   
    data = screen_time_out.pt;
    if(data != 0){
    sharedPreferences.edit().putInt("screen_time_out_adapter", data).commit();
    pta = sharedPreferences.getInt("screen_time_out_adapter", 0);
    }else{
    	pta = sharedPreferences.getInt("screen_time_out_adapter", 0);	   
    	  Toast.makeText(context, "screen time out"+ pta, Toast.LENGTH_SHORT).show();
    }
    
    Toast.makeText(context, "pta"+ pta, Toast.LENGTH_SHORT).show();
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
	  
	  
	  data = screen_time_out.pt;
	    if(data != 0){
	    sharedPreferences.edit().putInt("screen_time_out_adapter", data).commit();
	    pta = sharedPreferences.getInt("screen_time_out_adapter", 0);
	    }else{
	    	data = sharedPreferences.getInt("screen_time_out", 0);	    	
	    }
		
	  LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    final Holder localHolder;
    localHolder = new Holder();	
    convertView = null;

    if (convertView == null)
    {
    	convertView = mInflater.inflate(R.layout.slidelockadapter, parent,false);
          
      localHolder.hstv = ((TextView)convertView.findViewById(R.id.sdl_tv));
      localHolder.hscb = ((ImageView)convertView.findViewById(R.id.sdl_cb));
      localHolder.hsimg = ((ImageView)convertView.findViewById(R.id.sdl_img));
    } /*else{
    	localHolder = (Holder) convertView.getTag(); 
    }*/
      if(position ==0){
    	  
    	  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);
      if(pta == 0){
    		sto_pos.setstopos(pta);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
      }else{    		  
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }
      
      }
      if(position == 1){
    	  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);
    	  if(pta == 1){
    		  sto_pos.setstopos(pta);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }
      }
      if(position == 2){
    	  
    		  localHolder.hstv.setText(Listitem[position] );
    		  localHolder.hsimg.setImageResource(aimg[position]);    		  
    		  if(pta == 2){
    			  sto_pos.setstopos(pta);
        		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
        		  convertView.setTag(localHolder);
        	  }else{
        		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
        	  }  
    		  
      }
      if(position == 3){
    	  
		  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		  if(pta == 3){
			  sto_pos.setstopos(pta);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }  
		  
  }
      if(position == 4){
    	  
		  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		  if(pta == 4){
			  sto_pos.setstopos(pta);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }  
		  
  }
      if(position == 5){
    	  
		  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		  if(pta ==5){
			  sto_pos.setstopos(pta);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }	  
		  
  }	if(position == 6){
	  
	  localHolder.hstv.setText(Listitem[position] );
	  localHolder.hsimg.setImageResource(aimg[position]);    		  
	  if(pta == 6){
		  sto_pos.setstopos(pta);
		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
		  convertView.setTag(localHolder);
	  }else{
		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
	  }	  
	  
}
      
      
      
      //localHolder.hscb.setImageResource(aimg[position]);
      
      convertView.setTag(localHolder);
      
    
    
	return convertView;
  
}
  }