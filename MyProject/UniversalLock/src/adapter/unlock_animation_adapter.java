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

public class unlock_animation_adapter extends BaseAdapter
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
  private int p,data,data1;
  public static int ua_pos;
  private unlock_animation_interface uaiua;
  private static Activity activity = null;
  
  public unlock_animation_adapter(Activity context, String[] Listitem, int[] aimg, int[] cbi,unlock_animation_interface uaiua)
  {
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.cbi = cbi;
    this.uaiua = uaiua;
    this.activity = context;
    
    inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    
    sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    sharedpreferences = context.getSharedPreferences("ua_animation", Context.MODE_PRIVATE);
    
    ua_pos = sharedpreferences.getInt("ua_pos", 0);
    
    Toast.makeText(context, "adapter ua position"+ ua_pos, Toast.LENGTH_SHORT).show();
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
    localHolder = new Holder();
    convertView = null;
    if (convertView == null)
    {
    	convertView = mInflater.inflate(R.layout.slidelockadapter, parent,false);     
      
      localHolder.hstv = ((TextView)convertView.findViewById(R.id.sdl_tv));
      localHolder.hscb = ((ImageView)convertView.findViewById(R.id.sdl_cb));
      localHolder.hsimg = ((ImageView)convertView.findViewById(R.id.sdl_img));
    }
    /*else{
    	localHolder = (Holder) convertView.getTag(); 
    }*/
    
      if(position ==0 ){
    	  localHolder.hstv.setText(Listitem[position]);
		  localHolder.hsimg.setImageResource(aimg[position]);
      if(ua_pos == 0){
    	  uaiua.setuapos(ua_pos);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
      }else{    		  
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }
      
      }
      if(position == 1){
    	  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);
    	  if(ua_pos == 1){
    		  uaiua.setuapos(ua_pos);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }
      }
      if(position == 2){
    	  
    		  localHolder.hstv.setText(Listitem[position] );
    		  localHolder.hsimg.setImageResource(aimg[position]);    		  
    		  if(ua_pos == 2){
    			  uaiua.setuapos(ua_pos);
        		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
        		  convertView.setTag(localHolder);
        	  }else{
        		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
        	  }  
    		  
      }
      if(position == 3){
    	  
		  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		  if(ua_pos == 3){
			  uaiua.setuapos(ua_pos);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }  
		  
  }
      if(position == 4){
    	  
		  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		  if(ua_pos == 4){
			  uaiua.setuapos(ua_pos);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }  
		  
  }
      if(position == 5){
    	  
		  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		  if(ua_pos == 5){
			  uaiua.setuapos(ua_pos);
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check_right);
    		  convertView.setTag(localHolder);
    	  }else{
    		  localHolder.hscb.setImageResource(R.drawable.lock_type_check);
    	  }	  
		  
  }	if(position == 6){
	  
	  localHolder.hstv.setText(Listitem[position] );
	  localHolder.hsimg.setImageResource(aimg[position]);    		  
	  if(ua_pos == 6){
		  uaiua.setuapos(ua_pos);
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