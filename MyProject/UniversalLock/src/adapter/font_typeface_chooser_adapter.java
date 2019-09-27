package adapter;

import java.util.ArrayList;
import java.util.List;

import com.universallock.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.graphics.Typeface;
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

public class font_typeface_chooser_adapter extends BaseAdapter
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
  private Typeface[] saray;
  private Typeface t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
  private SharedPreferences pos;
  private ArrayList<List> al = new ArrayList<List>();
  private int p,data,data1;
  public static int ua_pos;
  private unlock_animation_interface uaiua;
  private static Activity activity = null;
  
  public font_typeface_chooser_adapter(Activity context, String[] Listitem, int[] aimg, int[] cbi)
  {
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.cbi = cbi;
 //   sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
  //  sharedpreferences = context.getSharedPreferences("ua_animation", Context.MODE_PRIVATE);
    
//    ua_pos = sharedpreferences.getInt("ua_pos", 0);
    
    //Toast.makeText(context, "adapter ua position"+ ua_pos, Toast.LENGTH_SHORT).show();
     t1 = Typeface.createFromAsset(context.getAssets(), "fonts/f1.ttf");
  	 t2 = Typeface.createFromAsset(context.getAssets(), "fonts/f2.ttf");
	 t3 = Typeface.createFromAsset(context.getAssets(), "fonts/f3.ttf");
	 t4 = Typeface.createFromAsset(context.getAssets(), "fonts/f4.ttf");
	 t5 = Typeface.createFromAsset(context.getAssets(), "fonts/f5.ttf");
	 t6 = Typeface.createFromAsset(context.getAssets(), "fonts/f6.ttf");
	 t7 = Typeface.createFromAsset(context.getAssets(), "fonts/f7.ttf");
	 t8 = Typeface.createFromAsset(context.getAssets(), "fonts/f8.ttf");
	 t9 = Typeface.createFromAsset(context.getAssets(), "fonts/f9.ttf");
	 t10 = Typeface.createFromAsset(context.getAssets(), "fonts/f10.ttf");
	
		saray = new Typeface[] {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10};
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
  	
	
  
  public View getView( final int position, View convertView, ViewGroup parent)
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
      localHolder.hstv.setText(Listitem[position]);
      localHolder.hstv.setTextSize(25);
      localHolder.hstv.setTypeface(saray[position]);
      localHolder.hsimg.setImageResource(aimg[position]);
      
    
      /*if(position ==0){
    	  localHolder.hstv.setText(Listitem[position] );
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
	  
}*/  
	  

      
      
      
      //localHolder.hscb.setImageResource(aimg[position]);
      
      convertView.setTag(localHolder);
      
    }
    else{
    	localHolder = (Holder) convertView.getTag(); 
    }
	return convertView;
  
}
  }