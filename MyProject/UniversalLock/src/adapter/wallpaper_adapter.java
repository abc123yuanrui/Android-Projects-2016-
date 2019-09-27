package adapter;

import com.universallock.R;

import adapter.ListViewAdapter.Holder;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class wallpaper_adapter extends BaseAdapter {
    private Context context;
    private int itemBackground;
    private Button setwall;
    private int[] img;
    public wallpaper_adapter(Context c,int[] img) {
      context = c;
      this.img = img;

     // TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
      //itemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
      //a.recycle();
    }

    public int getCount() {
      return img.length;
    }

    public Object getItem(int position) {
      return position;
    }

    public long getItemId(int position) {
      return position;
    }
    public class Holder
    {      
      ImageView himg;
          
      public Holder() {}
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
    	
    	  Holder holder = null;
    		
    	  
    	  LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if(convertView == null){
            	convertView = mInflater.inflate(R.layout.wallpaper_item, parent,false);
             
            	holder = new Holder(); 
            	
            	holder.himg = (ImageView)convertView.findViewById(R.id.wallpapr_image);
            	holder.himg.setImageResource(img[position]);
            	//Toast.makeText(context, "pos : "+img[position], Toast.LENGTH_SHORT).show();
            	setwall = (Button)convertView.findViewById(R.id.btn_set_walllaper);
           // holder.hdesc = (TextView) convertView.findViewById(R.id.scl_desc);
            	 convertView.setTag(holder);      
            }
            
            else{
            	holder = (Holder) convertView.getTag();
            }

      return convertView;
  }
}