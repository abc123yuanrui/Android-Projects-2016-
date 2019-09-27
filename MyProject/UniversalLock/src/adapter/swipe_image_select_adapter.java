package adapter;



import java.io.File;

import com.universallock.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class swipe_image_select_adapter extends BaseAdapter
{
	public static final String MyPREFERENCESS = "UserChoice";
  protected static final SharedPreferences preferences = null;
  
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
  private static SharedPreferences sharedpreferences = null,sharedPreferences;
  private int i1,i2;
  private int posi;
  private SwitchInterface s;
  private boolean tgpref;
  private File file,file1;
  private String ss1,ss2,ss3,ss4,ss5,ss6,ss7,ss8,ss9,ss10,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
  private String filename;
  private int ijk;
  private File[] listFile;
  private String[] patharey;
private Bitmap myBitmap,myBitmap2,myBitmap3,myBitmap4,myBitmap5,myBitmap6,myBitmap7,myBitmap8,myBitmap9;

  public swipe_image_select_adapter(Activity context, String[] Listitem, int[] aimg)
  {	  
    this.context = context;
    this.Listitem = Listitem;
    this.aimg = aimg;
        
    sharedpreferences = context.getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
    sharedPreferences = context.getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
    //i1 = sharedpreferences.getInt("value", 0);
    //i2 = sharedpreferences.getInt("switch_key", 0);
    
     ijk = sharedpreferences.getInt("pass_adapter", 0);
    filename = sharedpreferences.getString("passs_adapter", "");
   

    //Toast.makeText(context, "adapter"+" :"+"ijk is "+ijk+" file name is "+filename, Toast.LENGTH_SHORT).show();
    file= new File(android.os.Environment.getExternalStorageDirectory(),"lock_images");
    
    if(file.isDirectory()){
		listFile = file.listFiles();
		//Toast.makeText(context, "adapter"+file.listFiles() , Toast.LENGTH_SHORT).show();
		
		}
    
	    else{
	    		Toast.makeText(context, "ss9 : "+ss9, Toast.LENGTH_SHORT).show();
		}
    
    
		if(listFile.length > 0){
			
			ss1 = listFile[0].getAbsolutePath();
			ss2 = listFile[1].getAbsolutePath();
			ss3 = listFile[2].getAbsolutePath();
			ss4 = listFile[3].getAbsolutePath();
			ss5 = listFile[4].getAbsolutePath();
			ss6 = listFile[5].getAbsolutePath();
			ss7 = listFile[6].getAbsolutePath();
			ss8 = listFile[7].getAbsolutePath();
			ss9 = listFile[8].getAbsolutePath();
			
			if(listFile.length >= 9){
				System.out.println("list size : "+listFile.length);
				
				if(ijk == 9){
				File file1= new File(android.os.Environment.getExternalStorageDirectory(),"lock_images");
				 if(file1.isDirectory()){
						listFile = file1.listFiles();
						s1 = sharedpreferences.getString("ss1", "");
								File del = new File(s1);
												
								if(del.exists()){
									del.delete();
									sharedpreferences.edit().remove("ss1").commit();
									ss1 = file1 + filename;
									sharedpreferences.edit().putString("ss1", ss1).commit();
									Toast.makeText(context, "ss1 : "+ss1, Toast.LENGTH_SHORT).show();
									myBitmap = BitmapFactory.decodeFile(ss1);
									
								}else{
									Toast.makeText(context, "You can not update image at this time", Toast.LENGTH_SHORT).show();
								}
						}
				}else{	
		    
				int j = listFile.length -9;
    			ss1 = listFile[j].getAbsolutePath();
				//ss1 = file+"/"+ listFile[j];
    			
				System.out.println("ss1 : path : "+ss1 + "list of j : "+listFile[j]);
    			sharedpreferences.edit().putString("ss1", ss1).commit();
    			s1 = sharedpreferences.getString("ss1", "");
    			Toast.makeText(context, "ss1 : "+ss1+"lenth : "+listFile.length	, Toast.LENGTH_SHORT).show();
    			myBitmap = BitmapFactory.decodeFile(s1);
				}
		}
		if(listFile.length > 1){
			int j = listFile.length - 8;
			ss2 = listFile[j].getAbsolutePath();
			System.out.println("ss1 : path : "+ss1 + "list of j : "+listFile[j]);
			sharedpreferences.edit().putString("ss2", ss2).commit();
			s2 = sharedpreferences.getString("ss2", "");
			myBitmap2 = BitmapFactory.decodeFile(s2);
			Toast.makeText(context, "ss2 : "+ss2, Toast.LENGTH_SHORT).show();
		
		}
		if(listFile.length > 2){ 
			int j = listFile.length - 7;
			ss3 = listFile[j].getAbsolutePath();
			sharedpreferences.edit().putString("ss3", ss3).commit();
			s3 = sharedpreferences.getString("ss3", "");
			myBitmap3 = BitmapFactory.decodeFile(s3);
			Toast.makeText(context, "ss3 : "+ss3, Toast.LENGTH_SHORT).show();
		
		}
		if(listFile.length > 3){
			int j = listFile.length - 6;
			ss4 = listFile[j].getAbsolutePath();
			sharedpreferences.edit().putString("ss4", ss4).commit();
			s4 = sharedpreferences.getString("ss4", "");
			myBitmap4 = BitmapFactory.decodeFile(s4);
			Toast.makeText(context, "ss4 : "+ss4, Toast.LENGTH_SHORT).show();
		
		}
		if(listFile.length > 2){
			int j = listFile.length - 5;
			ss5 = listFile[j].getAbsolutePath();
			sharedpreferences.edit().putString("ss5", ss5).commit();
			s5 = sharedpreferences.getString("ss5", "");
			myBitmap5 = BitmapFactory.decodeFile(s5);
			Toast.makeText(context, "ss5 : "+ss5, Toast.LENGTH_SHORT).show();
		
		}
		if(listFile.length > 2){
			int j = listFile.length - 4;
			ss6 = listFile[j].getAbsolutePath();			
			sharedpreferences.edit().putString("ss6", ss6).commit();
			s6 = sharedpreferences.getString("ss6", "");			
			myBitmap6 = BitmapFactory.decodeFile(s6);
			Toast.makeText(context, "ss6 : "+ss6, Toast.LENGTH_SHORT).show();
		
		}
		if(listFile.length > 2){
			int j = listFile.length - 3;
			ss7 = listFile[j].getAbsolutePath();
			sharedpreferences.edit().putString("ss7", ss7).commit();
			s7 = sharedpreferences.getString("ss7", "");
			myBitmap7 = BitmapFactory.decodeFile(s7);
			Toast.makeText(context, "ss7 : "+ss7, Toast.LENGTH_SHORT).show();
		
		}
		if(listFile.length > 2){
			int j = listFile.length - 2;
			ss8 = listFile[j].getAbsolutePath();
			sharedpreferences.edit().putString("ss8", ss8).commit();			
			s8 = sharedpreferences.getString("ss8", "");
			myBitmap8 = BitmapFactory.decodeFile(s8);
			Toast.makeText(context, "ss8 : "+ss8 + "index : "+listFile[j], Toast.LENGTH_SHORT).show();
		
		}
		if(listFile.length >= 9){
			int j = listFile.length - 1 ;
			ss9 = listFile[j].getAbsolutePath();
			sharedpreferences.edit().putString("ss9", ss9).commit();
			s9 = sharedpreferences.getString("ss9", "");
			myBitmap9 = BitmapFactory.decodeFile(s9);
			Toast.makeText(context, "ss9 : "+ss9, Toast.LENGTH_SHORT).show();
		
		}
		
    }
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
    int posi;
    
    public Holder() {}
  }
  
  
  @Override
  	public View getView( int position, View convertView, ViewGroup parent)
  {
	  Holder holder = null;
	  
	  LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
        	convertView = mInflater.inflate(R.layout.swipe_image_select_adapter, parent,false);
         
        	holder = new Holder();  
        	
        	holder.htv = (TextView) convertView.findViewById(R.id.image_title);
        	holder.himg = (ImageView)convertView.findViewById(R.id.image_check);
        	
        convertView.setTag(holder);      
        }
       
        else{
        	holder = (Holder) convertView.getTag();
        }
        //RowItem rowItem = (RowItem) getItem(position);
        if(position == 0){
        
        holder.htv.setText(Listitem[position]);
        holder.himg.setImageBitmap(myBitmap);
        notifyDataSetChanged();
        holder.himg.setVisibility(View.VISIBLE);
        
        }
        if(position == 1){
            
            holder.htv.setText(Listitem[position]);
            holder.himg.setImageBitmap(myBitmap2);            
            holder.himg.setVisibility(View.VISIBLE);
            }
        if(position == 2){
            
            holder.htv.setText(Listitem[position]);
            holder.himg.setImageBitmap(myBitmap3);
            }
        if(position == 3){
            
            holder.htv.setText(Listitem[position]);     
            holder.himg.setImageBitmap(myBitmap4);
            }
        if(position == 4){
            
            holder.htv.setText(Listitem[position]);     
            holder.himg.setImageBitmap(myBitmap5);
            }
        if(position == 5){
            
            holder.htv.setText(Listitem[position]);     
            holder.himg.setImageBitmap(myBitmap6);
            }
        if(position == 6){
            
            holder.htv.setText(Listitem[position]);    
            holder.himg.setImageBitmap(myBitmap7);
            }
        if(position == 7){
            
            holder.htv.setText(Listitem[position]);   
            holder.himg.setImageBitmap(myBitmap8);
            }
        if(position == 8){
            
            holder.htv.setText(Listitem[position]);
            holder.himg.setImageBitmap(myBitmap9);
            }
        
                
        
        return convertView;
        
        
    //viewholder = (Holder) convertView.getTag();
        
  }
 

  
  
}



