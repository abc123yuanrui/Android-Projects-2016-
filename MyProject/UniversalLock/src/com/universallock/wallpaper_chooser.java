package com.universallock;


import adapter.wallpaper_adapter;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class wallpaper_chooser extends Activity implements ViewFactory {
	
	WallpaperManager wm;
	public static final String MyPREFERENCESS = "MyUserChoice";
	  public int p;
	  public static int wall;
	  public static final String MyPREFERENCES = "MyUserChoicesss";
	  public static SharedPreferences sharedPreferences = null;	  
  int[] imageIDs = { R.drawable.background1,R.drawable.background2,R.drawable.background3, R.drawable.background4,R.drawable.background5};
  int[] img = {R.drawable.abc,R.drawable.abc22,R.drawable.abc23};
  
  private ImageSwitcher imageSwitcher;
private Button setwall;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.wallpaper_chooser);
  
    /*DisplayMetrics metrics1 = getResources().getDisplayMetrics();
    
    int densityDpi = (int)(metrics1.density * 160f);
    Toast.makeText(getApplicationContext(), "dip : "+densityDpi, Toast.LENGTH_SHORT).show();
    int screenSize = getResources().getConfiguration().screenLayout &
            Configuration.SCREENLAYOUT_SIZE_MASK;

    String toastMsg;
    switch(screenSize) {
    	case Configuration.SCREENLAYOUT_SIZE_XLARGE:
    		toastMsg = "X-Large screen";
    		break;
        case Configuration.SCREENLAYOUT_SIZE_LARGE:
            toastMsg = "Large screen";
            break;
        case Configuration.SCREENLAYOUT_SIZE_NORMAL:
            toastMsg = "Normal screen";
            break;
        case Configuration.SCREENLAYOUT_SIZE_SMALL:
            toastMsg = "Small screen";
            break;
        default:
            toastMsg = "Screen size is neither large, normal or small";
    }
    
    
    
    Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
    */
    setwall = (Button)findViewById(R.id.btn_set_walllaper);
    setwall.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			try{
		    	wall = imageIDs[p];		    		
		    	
				//wm.setResource(imageIDs[p]);
		    	finish();
		    	overridePendingTransition(R.anim.right_out, R.anim.right_in);
		    	
		    }catch(Exception e){
		    	e.printStackTrace();
		    }		
			
		}
	});
    imageSwitcher = (ImageSwitcher) findViewById(R.id.switcher1);
    imageSwitcher.setFactory(new ViewFactory() {
		
		@Override
		public View makeView() {
			// TODO Auto-generated method stub
			
			ImageView myView = new ImageView(getApplicationContext());
            myView.setScaleType(ImageView.ScaleType.FIT_XY);
            myView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
            
            return myView;
		}
	});
    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
        android.R.anim.slide_in_left));
    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
        android.R.anim.slide_out_right));

    Gallery gallery = (Gallery) findViewById(R.id.gallery1);

    wallpaper_adapter imgadapter = new wallpaper_adapter(this,imageIDs);
    
    gallery.setAdapter(imgadapter);
    gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
				long id) {
			// TODO Auto-generated method stub
			imageSwitcher.setImageResource(imageIDs[position]);
			
			p = arg0.getPositionForView(arg1);
				
			Toast.makeText(getApplicationContext(), "position : "+p , Toast.LENGTH_SHORT).show();
			
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
   
	
  }
@Override
public View makeView() {
	// TODO Auto-generated method stub
	return null;
}

  
  
}
  
