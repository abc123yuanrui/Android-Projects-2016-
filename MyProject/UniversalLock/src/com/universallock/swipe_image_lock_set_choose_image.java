package com.universallock;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.tv.TvInputService.HardwareSession;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class swipe_image_lock_set_choose_image extends Activity {
	public static final String MyPREFERENCESS = "MyUserChoices";
	private SharedPreferences sharedpreferences;
	private int count;
	private Bitmap[] thumbnails;
	private boolean[] thumbnailsselection;
	private String[] arrPath;
	private ImageAdapter imageAdapter;
	private Uri picUri;
	private ImageView imgView;
	private String[] a;
	StringBuilder builder;
	public String[] sa;
	private ArrayList<String> h = new ArrayList<String>();
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_image_lock_set_choose_image);
		
		sharedpreferences = getSharedPreferences(MyPREFERENCESS, MODE_PRIVATE);
		
		imgView = (ImageView)findViewById(R.id.img);
		a = new String[] {};
		final String[] columns = { MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID };
		final String orderBy = MediaStore.Images.Media._ID;
		Cursor imagecursor = managedQuery(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
				null, orderBy);
		int image_column_index = imagecursor.getColumnIndex(MediaStore.Images.Media._ID);
		this.count = imagecursor.getCount();
		this.thumbnails = new Bitmap[this.count];
		this.arrPath = new String[this.count];
		this.thumbnailsselection = new boolean[this.count];
		for (int i = 0; i < this.count; i++) {
			imagecursor.moveToPosition(i);
			int id = imagecursor.getInt(image_column_index);
			int dataColumnIndex = imagecursor.getColumnIndex(MediaStore.Images.Media.DATA);
			thumbnails[i] = MediaStore.Images.Thumbnails.getThumbnail(
					getApplicationContext().getContentResolver(), id,
					MediaStore.Images.Thumbnails.MICRO_KIND, null);
			arrPath[i]= imagecursor.getString(dataColumnIndex);
		}
		GridView imagegrid = (GridView) findViewById(R.id.PhoneImageGrid);
		imageAdapter = new ImageAdapter();
		imagegrid.setAdapter(imageAdapter);
		//imagecursor.close();
		
		final Button selectBtn = (Button) findViewById(R.id.selectBtn);
		selectBtn.setOnClickListener(new OnClickListener() {
			
			private String imgDecodableString;
			private Uri selectedImage;

			public void onClick(View v) {
				// TODO Auto-generated method stub
				String[] filePathColumn = { MediaStore.Images.Media.DATA };

				final int len = thumbnailsselection.length;
				int cnt = 0;
				String selectImages = "";
				for (int i =0; i<len; i++)
				{
					if (thumbnailsselection[i]){
						cnt++;
						selectImages = selectImages + arrPath[i] + "|";
					//	Toast.makeText(getApplicationContext(), arrPath[i], Toast.LENGTH_SHORT).show();
						builder = new StringBuilder();
					//String a[];
						h.add(arrPath[i]);
						System.out.println("ara : "+arrPath[i] );
						
						
						
						
					}
				}
			
			 if (cnt == 0){
					Toast.makeText(getApplicationContext(),
							"Please select at least one image",
							Toast.LENGTH_LONG).show();
				} 	if(cnt >9){
					Toast.makeText(getApplicationContext(),
							"Please select only nine images",
							Toast.LENGTH_LONG).show();
				}else if(cnt < 9){
					Toast.makeText(getApplicationContext(),
							"Please select nine image",
							Toast.LENGTH_LONG).show();
				}
				if(cnt == 9){
					Log.d("SelectedImages", selectImages);
					
					//String[] sa = h.toArray(new String[h.size()]);
					
					sa = new String[h.size()];
					sa = h.toArray(sa);
					
					
					Intent i = new Intent();
					i.putStringArrayListExtra("array", h);
					i.putExtra("aa", 1);
					setResult(RESULT_OK,i);
					finish();
			
					

				}
			}
		});
		
	}
	@Override
	public void onBackPressed(){	
		super.onBackPressed();	
		
	}
@Override
public void onDestroy(){
	super.onDestroy();
}
@Override
public void onResume(){
	super.onResume();
}
	public class ImageAdapter extends BaseAdapter {
		private LayoutInflater mInflater;

		public ImageAdapter() {
			mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return count;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = mInflater.inflate(
						R.layout.swipe_image_lock_set_choose_image_adapter, null);
				holder.imageview = (ImageView) convertView.findViewById(R.id.thumbImage);
				holder.checkbox = (CheckBox) convertView.findViewById(R.id.itemCheckBox);
				
				convertView.setTag(holder);
			}
			else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.checkbox.setId(position);
			holder.imageview.setId(position);
			holder.checkbox.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					CheckBox cb = (CheckBox) v;
					int id = cb.getId();
					if (thumbnailsselection[id]){
						cb.setChecked(false);
						thumbnailsselection[id] = false;
					} else {
						cb.setChecked(true);
						thumbnailsselection[id] = true;
					}
				}
			});
			holder.imageview.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					int id = v.getId();
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setDataAndType(Uri.parse("file://" + arrPath[id]), "image/*");
					startActivity(intent);
				}
			});
			holder.imageview.setImageBitmap(thumbnails[position]);
			holder.checkbox.setChecked(thumbnailsselection[position]);
			holder.id = position;
			return convertView;
		}
	}
	class ViewHolder {
		ImageView imageview;
		CheckBox checkbox;
		int id;
	}
	
}
