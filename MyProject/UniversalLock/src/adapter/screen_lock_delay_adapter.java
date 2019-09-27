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

public class screen_lock_delay_adapter extends BaseAdapter
{
  private static SharedPreferences sharedpreferences = null;
private static final LayoutInflater parent = null;
public static final String MyPREFERENCES = "screen_lock_delay";
String[] Listitem;
  int[] aimg;
  Activity context;
  SharedPreferences.Editor editor;
  LayoutInflater inflater;
  private boolean[] itemchecked;
  private int[] cbi;
  private String _lock_name;
  private String pin ;
  private String pin_verify;
  private String shake_or_swipe_var;
  private String shake_or_swipe;
  private String val,p1;
  private SharedPreferences pos;
  private int p,data,data1,pta;
  public screen_lock_delay_adapter(Activity context, String[] Listitem, int[] aimg, int[] cbi)
  {
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.cbi = cbi;
        
    sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
   
    pta = sharedpreferences.getInt("pta", 0);
    
    
    Toast.makeText(context, "pta"+ pta, Toast.LENGTH_SHORT).show();
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
    final Holder localHolder;
    if (convertView == null)
    {
    	convertView = mInflater.inflate(R.layout.slidelockadapter, parent,false);
      
      localHolder = new Holder();
      localHolder.hstv = ((TextView)convertView.findViewById(R.id.sdl_tv));
      localHolder.hscb = ((ImageView)convertView.findViewById(R.id.sdl_cb));
      localHolder.hsimg = ((ImageView)convertView.findViewById(R.id.sdl_img));
      
      if(position ==0){
    	  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);
      if(pta == 0){
    		  
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
	    	  
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }  
		  
  }
      if(position == 5){
    	  
		  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		  if(pta == 5){
	    	  
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }	  
		  
  }	if(position == 6){
	  
	  localHolder.hstv.setText(Listitem[position] );
	  localHolder.hsimg.setImageResource(aimg[position]);    		  
	  if(pta == 6){
    	  
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