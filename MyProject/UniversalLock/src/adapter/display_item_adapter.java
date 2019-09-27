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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class display_item_adapter extends BaseAdapter
{
	public static final String MyPREFERENCES1 = "displayitem";
	public static SharedPreferences sharedPreferences = null;	
  	private static final LayoutInflater parent = null;
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
	private String val;
	private SharedPreferences pos;
	public static int p1,p2,p3,p4,p5,p6,p7,p8,sw1;
	private static Activity activity = null;
	private display_item_interface div;
  public display_item_adapter(Activity context, String[] Listitem, int[] aimg)
  {
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
    this.cbi = cbi;
    this.activity = context;
        
    inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    sharedPreferences = context.getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
    
    p1 = sharedPreferences.getInt("iv1", 0);p2 = sharedPreferences.getInt("iv2", 0);
    p3 = sharedPreferences.getInt("iv3", 0);p4 = sharedPreferences.getInt("iv4", 0);
    p5 = sharedPreferences.getInt("iv5", 0);p6 = sharedPreferences.getInt("iv6", 0);
    p7 = sharedPreferences.getInt("iv7", 0);p8 = sharedPreferences.getInt("iv8", 0);
    
sw1 = sharedPreferences.getInt("sw_p", 0);
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
    Switch hsw;
    TextView hstv;
    
    public Holder() {}
  }

  
  
  public View getView(final int position, View convertView, ViewGroup parent)
  {
  //  this.context.getSharedPreferences("sharedPrefs", 0);
	  
	    sharedPreferences = context.getSharedPreferences(MyPREFERENCES1, Context.MODE_PRIVATE);
	    
	    Toast.makeText(context, "pta"+ p1+" / "+p2+" / "+p3+" / "+p4+" / "+p5+" / "+p6+" / "+p7+" / "+p8, Toast.LENGTH_SHORT).show();		
	  LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    final Holder localHolder;
    if (convertView == null)
    {
    	convertView = mInflater.inflate(R.layout.screenlock_adapter, parent,false);
      
      localHolder = new Holder();
      localHolder.hstv = ((TextView)convertView.findViewById(R.id.scl_tv));
      localHolder.hsw = (Switch) convertView.findViewById(R.id.scl_sw);
      localHolder.hsimg = ((ImageView)convertView.findViewById(R.id.scl_img));
		
      
      //localHolder.hsimg.setVisibility(View.GONE);
      
      if(position ==0){
    	  
    	  localHolder.hstv.setText(Listitem[position] );
    		localHolder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
										
					if(isChecked){
						sharedPreferences.edit().putInt("iv1", 1).commit();
						
					}else{
						sharedPreferences.edit().putInt("iv1", 0).commit();
						sharedPreferences.edit().putInt("sw_p", 1).commit();
					}
				}
			});
    		if(p1 == 1 || sw1 == 0){
    			sharedPreferences.edit().putInt("iv1", 1).commit();
    			p1 = sharedPreferences.getInt("iv1", 0);
				localHolder.hsw.setChecked(true);
				localHolder.hsw.setTextColor(R.string.switch_on);
				
			}
			else{    		  
				sharedPreferences.edit().putInt("iv1", 0).commit();
				p1 = sharedPreferences.getInt("iv1", 0);
	    		localHolder.hsw.setChecked(false);
	    		localHolder.hsw.setTextColor(R.string.switch_off);
	    		
	    	  }
    		  convertView.setTag(localHolder);
      
      
      }
      if(position == 1){
    	  
    	  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);
		      		  
	    		localHolder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub
					
						if(isChecked){							
							sharedPreferences.edit().putInt("iv2", 1).commit();
							p2 = sharedPreferences.getInt("iv2", 0);
							Toast.makeText(context, "adapter"+p1+" / "+p2+" / "+p3+" / "+p4+" / "+p5+" / "+p6+" / "+p7+" / "+p8, Toast.LENGTH_SHORT).show();
							
							
						}else{
							sharedPreferences.edit().putInt("sw_p", 1).commit();
							sharedPreferences.edit().putInt("iv2", 0).commit();
							p2 = sharedPreferences.getInt("iv2", 0);
							Toast.makeText(context, "adapter"+p1+" / "+p2+" / "+p3+" / "+p4+" / "+p5+" / "+p6+" / "+p7+" / "+p8, Toast.LENGTH_SHORT).show();
							
						}
			
						
					}
				});
				if(p2 == 1 || sw1 == 0){
					localHolder.hsw.setChecked(true);
				}else{
		    		  localHolder.hsw.setChecked(false);
		    		  
		    	  }
	    		  convertView.setTag(localHolder);
    	  
      }
      if(position == 2){
    	  
    		  localHolder.hstv.setText(Listitem[position] );
    		  localHolder.hsimg.setImageResource(aimg[position]);

    		  localHolder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    					
    					@Override
    					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    						// TODO Auto-generated method stub
    					
    						if(isChecked){
    							sharedPreferences.edit().putInt("iv3", 1).commit();
    							p3 = sharedPreferences.getInt("iv3", 0);
    						}else{
    							sharedPreferences.edit().putInt("sw_p", 1).commit();
    							sharedPreferences.edit().putInt("iv3", 0).commit();
    							p3 = sharedPreferences.getInt("iv3", 0);
    						}
    						
    				
    					}
    				});
    			if(p3 == 1 || sw1 == 0){
					localHolder.hsw.setChecked(true);
					
				}else{
	        		  localHolder.hsw.setChecked(false);
	        		  
	        	  }
    	    		  convertView.setTag(localHolder);
        	    
    		  
      }
      if(position == 3){
    	  
		  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		      		  
	    		localHolder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub

						if(isChecked){
							sharedPreferences.edit().putInt("iv4", 1).commit();
							p4 = sharedPreferences.getInt("iv4", 0);
						}else{
							sharedPreferences.edit().putInt("sw_p", 1).commit();
							sharedPreferences.edit().putInt("iv4", 0).commit();
							p4 = sharedPreferences.getInt("iv4", 0);
						}
						
						
					}
				});
	    		if(p4 == 1 || sw1 == 0){
					localHolder.hsw.setChecked(true);
					
				}else{
		    		  localHolder.hsw.setChecked(false);
		    		  
		    	  } 
	    		  convertView.setTag(localHolder);
    	   
		  
  }
      if(position == 4){

    	  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		      		  
	    		localHolder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub

						if(isChecked){
							sharedPreferences.edit().putInt("iv5", 1).commit();
							p5 = sharedPreferences.getInt("iv5", 0);
						}else{
							sharedPreferences.edit().putInt("sw_p", 1).commit();
							sharedPreferences.edit().putInt("iv5", 0).commit();
							p5 = sharedPreferences.getInt("iv5", 0);
						}

					 
					}
				});
	    		if(p5 == 1 || sw1 == 0){
					localHolder.hsw.setChecked(true);
					
				}else{
		    		  localHolder.hsw.setChecked(false);
		    		  
		    	  }
	    		  convertView.setTag(localHolder);
    	   
		  
  }
      if(position == 5){

    	  localHolder.hstv.setText(Listitem[position] );
		  localHolder.hsimg.setImageResource(aimg[position]);    		  
		      		  
	    		localHolder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub

						if(isChecked){
							sharedPreferences.edit().putInt("iv6", 1).commit();
							p6 = sharedPreferences.getInt("iv6", 0);
						}else{
							sharedPreferences.edit().putInt("sw_p", 1).commit();
							sharedPreferences.edit().putInt("iv6", 0).commit();
							p6 = sharedPreferences.getInt("iv6", 0);
						}

						
						
					}
				});
	    		if(p6 == 1 || sw1 == 0){
					localHolder.hsw.setChecked(true);
					
				}else{
		    		  localHolder.hsw.setChecked(false);
		    		  
		    	  }
	    		  convertView.setTag(localHolder);
    	    
		  
  }	if(position == 6){

	  localHolder.hstv.setText(Listitem[position] );
	  localHolder.hsimg.setImageResource(aimg[position]);    		  

	  localHolder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub

					if(isChecked){
						sharedPreferences.edit().putInt("iv7", 1).commit();
						p7 = sharedPreferences.getInt("iv7", 0);
					}else{
						sharedPreferences.edit().putInt("sw_p", 1).commit();
						sharedPreferences.edit().putInt("iv7", 0).commit();
						p7 = sharedPreferences.getInt("iv7", 0);
					}
						
				}
			});if(p7 == 1 || sw1 == 0){
				localHolder.hsw.setChecked(true);
				
				
			}else{
				  localHolder.hsw.setChecked(false);
				  
				
			  }
  		  convertView.setTag(localHolder);
	    
  }
		if(position == 7){

			localHolder.hstv.setText(Listitem[position] );
			  localHolder.hsimg.setImageResource(aimg[position]);    		  

			  localHolder.hsw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						
						@Override
						public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
							// TODO Auto-generated method stub

							if(isChecked){
								sharedPreferences.edit().putInt("iv8", 1).commit();
								p8 = sharedPreferences.getInt("iv8", 0);
							}else{
								sharedPreferences.edit().putInt("sw_p", 1).commit();
								sharedPreferences.edit().putInt("iv8", 0).commit();
								p8 = sharedPreferences.getInt("iv8", 0);
							}
				
						}
					});
				if(p8 == 1 || sw1 == 0){
					localHolder.hsw.setChecked(true);
					
				}else{
					  localHolder.hsw.setChecked(false);
					  
				  }
		    		  convertView.setTag(localHolder);
			  
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