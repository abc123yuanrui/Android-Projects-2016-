package com.universallock;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class crop_image extends Activity{

	public static final String MyPREFERENCESS = "UserChoice";
	private Uri picUri1,picUri2,picUri3,picUri4,picUri5,picUri6,picUri7,picUri8,picUri9;
	private int CROP_PIC = 0,CROP_PIC1 = 11,CROP_PIC2 = 12,CROP_PIC3 = 13,CROP_PIC4 = 14,CROP_PIC5 = 15,
			  CROP_PIC6 = 16,CROP_PIC7 = 17,CROP_PIC8 = 18,CROP_PIC9 = 19;
	  private String p1,p2,p3,p4,p5,p6,p7,p8,p9;
	  private Bitmap b1,b2,b3,b4,b5,b6,b7,b8,b9;
	  private int a;
	  private SharedPreferences sharedpreferences;
	  private LinearLayout ll1,ll2,ll3,ll4,ll5,ll6;
	  private SharedPreferences sharedPreferences;
	  private String inputPath = null,inputFile = null,inString,path;
	  private int ij,jk;
	private File[] listFile;
	private File file1;
	
	@Override
	protected void onCreate(Bundle savedInsatanceState){
		super.onCreate(savedInsatanceState);
		setContentView(R.layout.crop_image);
		sharedpreferences = getSharedPreferences(MyPREFERENCESS, MODE_PRIVATE);
		sharedPreferences = getSharedPreferences(MyPREFERENCESS, MODE_PRIVATE);
		ll1 = (LinearLayout)findViewById(R.id.crop_image_ll_1);
		ll2 = (LinearLayout)findViewById(R.id.crop_image_ll_2);
		ll3 = (LinearLayout)findViewById(R.id.crop_image_ll_3);
		ll4 = (LinearLayout)findViewById(R.id.crop_image_ll_4);
		ll5 = (LinearLayout)findViewById(R.id.crop_image_ll_5);
		ll6 = (LinearLayout)findViewById(R.id.crop_image_ll_6);
		
		ij = getIntent().getIntExtra("val", 0);
		path = getIntent().getStringExtra("str");
		savePreferences("pass", ij);
		savePreferences("path", path);
		
		jk  = sharedPreferences.getInt("pass", 0);
		
		Toast.makeText(getApplicationContext(), "ij : "+ij+" path : " + path, Toast.LENGTH_SHORT).show();
		
		ll1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent galleryIntent = new Intent(Intent.ACTION_PICK,
	    				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	    		startActivityForResult(galleryIntent, 1);
	    		
			}
		});
	
	ll2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent galleryIntent = new Intent(Intent.ACTION_PICK,
	    				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	    		startActivityForResult(galleryIntent, 2);
	    		
			}
		});
	
	ll3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent galleryIntent = new Intent(Intent.ACTION_PICK,
    				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    		startActivityForResult(galleryIntent, 3);
    		
		}
	});
	ll4.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent galleryIntent = new Intent(Intent.ACTION_PICK,
    				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    		startActivityForResult(galleryIntent, 4);
    		
		}		
	});
	ll5.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent galleryIntent = new Intent(Intent.ACTION_PICK,
    				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    		startActivityForResult(galleryIntent, 5);
    		
		}
	});
	ll6.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent galleryIntent = new Intent(Intent.ACTION_PICK,
    				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    		startActivityForResult(galleryIntent, 6);
    		
		}
	});
	
       

	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
		
			// When an Image is picked
			if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
				
				// Get the Image from data
					
				picUri1 = data.getData();
				
				//performCrop();
				performCropverticallow();
				Uri selectedImage = data.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };
				System.out.println("file path : "+filePathColumn);
				Toast.makeText(getApplicationContext(), "path : "+filePathColumn, Toast.LENGTH_SHORT).show();
				// Get the cursor
				Cursor cursor = getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				cursor.moveToFirst();
				
				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				p1 = cursor.getString(columnIndex);
				//cursor.close();
				System.out.println("image cursor : "+p1);
			}				
			  
		

			if (requestCode == 2 && resultCode == RESULT_OK && null != data) {
				// Get the Image from data
				
				picUri1 = data.getData();
				//performCrop();
				performCropverticallowsquarehigh();
				Uri selectedImage2 = data.getData();
				String[] filePathColumn2 = { MediaStore.Images.Media.DATA };
				System.out.println("file path : "+filePathColumn2);
				Toast.makeText(getApplicationContext(), "path : "+filePathColumn2, Toast.LENGTH_SHORT).show();
				// Get the cursor
				Cursor cursor2 = getContentResolver().query(selectedImage2,
						filePathColumn2, null, null, null);
				cursor2.moveToFirst();
				
				int columnIndex2 = cursor2.getColumnIndex(filePathColumn2[0]);
				p2 = cursor2.getString(columnIndex2);
				cursor2.close();
				//System.out.println("image cursor : "+p1);
			}				
			 
			
			if (requestCode == 3 && resultCode == RESULT_OK
					&& null != data) {
				// Get the Image from data
				//a = 3;
				//sharedpreferences.edit().putInt("a", a).commit();
				picUri1 = data.getData();
				//Toast.makeText(getApplicationContext(), "path : "+picUri1, Toast.LENGTH_SHORT).show();
				//performCrop();
				performCrophorizontallow();
				Uri selectedImage3 = data.getData();
				String[] filePathColumn3 = { MediaStore.Images.Media.DATA };
				System.out.println("file path : "+filePathColumn3);
				Toast.makeText(getApplicationContext(), "path : "+filePathColumn3, Toast.LENGTH_SHORT).show();
				// Get the cursor
				Cursor cursor3 = getContentResolver().query(selectedImage3,
						filePathColumn3, null, null, null);
				cursor3.moveToFirst();
				
				int columnIndex3 = cursor3.getColumnIndex(filePathColumn3[0]);
				p3 = cursor3.getString(columnIndex3);
				cursor3.close();
				//System.out.println("image cursor : "+p3);
				
			}
			if (requestCode == 4 && resultCode == RESULT_OK
					&& null != data) {
				// Get the Image from data
			//	a = 4;
			//	sharedpreferences.edit().putInt("a", a).commit();
			//	picUri4 = data.getData();
				//performCrop();
				picUri1 = data.getData();
				performCrophorizontalhigh();
				Uri selectedImage4 = data.getData();
				String[] filePathColumn4 = { MediaStore.Images.Media.DATA };
				System.out.println("file path : "+filePathColumn4);
				Toast.makeText(getApplicationContext(), "path : "+filePathColumn4, Toast.LENGTH_SHORT).show();
				// Get the cursor
				Cursor cursor4 = getContentResolver().query(selectedImage4,
						filePathColumn4, null, null, null);
				cursor4.moveToFirst();
				
				int columnIndex4 = cursor4.getColumnIndex(filePathColumn4[0]);
				p4 = cursor4.getString(columnIndex4);
				cursor4.close();
				//System.out.println("image cursor : "+p4);
				
			}
			if (requestCode == 5 && resultCode == RESULT_OK
					&& null != data) {
				// Get the Image from data
				//a = 5;
				//sharedpreferences.edit().putInt("a", a).commit();
				picUri1 = data.getData();
				//performCrop();
				performCropverticallowsquarelow();
				Uri selectedImage5 = data.getData();
				String[] filePathColumn5 = { MediaStore.Images.Media.DATA };
				System.out.println("file path : "+filePathColumn5);
				Toast.makeText(getApplicationContext(), "path : "+filePathColumn5, Toast.LENGTH_SHORT).show();
				// Get the cursor
				Cursor cursor5 = getContentResolver().query(selectedImage5,
						filePathColumn5, null, null, null);
				cursor5.moveToFirst();
				
				int columnIndex5 = cursor5.getColumnIndex(filePathColumn5[0]);
				p5 = cursor5.getString(columnIndex5);
				cursor5.close();
				//System.out.println("image cursor : "+p5);
				
			}
			if (requestCode == 6 && resultCode == RESULT_OK
					&& null != data) {
				// Get the Image from data
				//a = 6;
				//sharedpreferences.edit().putInt("a", a).commit();
				picUri1 = data.getData();
				//performCrop();
				performCropverticallowsquarehigh();
				Uri selectedImage6 = data.getData();
				String[] filePathColumn6 = { MediaStore.Images.Media.DATA };
				//System.out.println("file path : "+filePathColumn);
				Toast.makeText(getApplicationContext(), "path : "+filePathColumn6, Toast.LENGTH_SHORT).show();
				// Get the cursor
				Cursor cursor6 = getContentResolver().query(selectedImage6,
						filePathColumn6, null, null, null);
				cursor6.moveToFirst();
				
				int columnIndex6 = cursor6.getColumnIndex(filePathColumn6[0]);
				p6 = cursor6.getString(columnIndex6);
				cursor6.close();
				//System.out.println("image cursor : "+p6);
				
			}
			if (requestCode == CROP_PIC) {
				// get the returned data
				if(CROP_PIC == 11){
			try{
				Bundle extras = data.getExtras();
				// get the cropped bitmap
				
				Bitmap b1 = extras.getParcelable("data");
				
				System.out.println("image : "+b1);
				Toast.makeText(this, "image : "+b1,Toast.LENGTH_SHORT).show();
				Toast.makeText(getApplicationContext(), "b1 : "+b1, Toast.LENGTH_SHORT).show();
				//ImageView picView = (ImageView) findViewById(R.id.image_check);
				//picView.setImageBitmap(b1);
				
				String root = Environment.getExternalStorageDirectory().toString();
				
				/*File file1= new File(android.os.Environment.getExternalStorageDirectory(),"lock_images");
				 if(file1.isDirectory()){
						listFile = file1.listFiles();
						if(b1 != null){
							if(jk != 0){
							//	int i =listFile.length - jk;
							//	String str = listFile[i].getAbsolutePath();
								
								String str =sharedpreferences.getString("path", "");
								
								String sp  =  listFile[jk].getAbsolutePath();
								
								File del = new File(str);
								
								if(del.exists()){
									del.delete();
									
								}else{
									Toast.makeText(getApplicationContext(), "You can not update image at this time", Toast.LENGTH_SHORT).show();
								}
							}
						}
						}
				 */
                File myDir = new File(root + "/lock_Images");
                
                myDir.mkdirs();
                Random generator = new Random();
                int n = 10000;
                n = generator.nextInt(n);
                String fname = "Image-"+ n +".jpg";
                System.out.println("fname :"+ fname );
                Toast.makeText(this, "image path of fname : "+fname,Toast.LENGTH_SHORT).show();
                File file = new File (myDir, fname);
                if (file.exists ()) file.delete (); 
                try {
                   FileOutputStream out = new FileOutputStream(file);
                   b1.compress(Bitmap.CompressFormat.JPEG, 90, out);
                   out.flush();
                   out.close();
                } catch (Exception e) {
                   e.printStackTrace();
                }
            

            File f = new File(picUri1.getPath());
            System.out.println("f :"+ f );
            Toast.makeText(this, "image path of f : "+f,Toast.LENGTH_SHORT).show();
            if (f.exists()) f.delete();     
            
				
				Intent i = new Intent();
				//i.putExtra("bitmap", b1);
				i.putExtra("file_name", fname);				
				i.putExtra("value_pass", jk);
				setResult(RESULT_OK, i);
				picUri1 = null;
				data = null;				
				finish();
			}				
			catch(Exception e){
				Toast.makeText(this, "You haven't picked Image of"+CROP_PIC+" position" ,Toast.LENGTH_SHORT).show();
			}
				}		
	}
			
	}
	private void performCropverticallow() {
		// take care of exceptions
		
		try {
			
			Intent cropIntent = new Intent("com.android.camera.action.CROP");
			cropIntent.putExtra("crop", "true");
			cropIntent.putExtra("aspectX", 1);
			cropIntent.putExtra("aspectY", 2);
			cropIntent.putExtra("outputX", 256);
			cropIntent.putExtra("outputY", 256);
			cropIntent.putExtra("return-data", true);
			System.out.println("picuri : "+picUri1);
			if(picUri1 != null){CROP_PIC = CROP_PIC1;  cropIntent.setDataAndType(picUri1, "image/*");startActivityForResult(cropIntent, CROP_PIC);}
			
		}
		// respond to users whose devices do not support the crop action
		catch (ActivityNotFoundException anfe) {
			Toast toast = Toast
					.makeText(this, "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
			toast.show();
		}
	}
	private void performCropverticalhigh() {
		// take care of exceptions
		
		try {
			
			Intent cropIntent = new Intent("com.android.camera.action.CROP");
			cropIntent.putExtra("crop", "true");
			cropIntent.putExtra("aspectX", 1);
			cropIntent.putExtra("aspectY", 2);
			cropIntent.putExtra("outputX", 480);
			cropIntent.putExtra("outputY", 480);
			cropIntent.putExtra("return-data", true);
			System.out.println("picuri : "+picUri1);
			if(picUri1 != null){CROP_PIC = CROP_PIC1;  cropIntent.setDataAndType(picUri1, "image/*");startActivityForResult(cropIntent, CROP_PIC);}
			
		}
		// respond to users whose devices do not support the crop action
		catch (ActivityNotFoundException anfe) {
			Toast toast = Toast
					.makeText(this, "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
			toast.show();
		}
	}
	private void performCrophorizontallow() {
		// take care of exceptions
		
		try {
			
			Intent cropIntent = new Intent("com.android.camera.action.CROP");
			cropIntent.putExtra("crop", "true");
			cropIntent.putExtra("aspectX", 2);
			cropIntent.putExtra("aspectY", 1);
			cropIntent.putExtra("outputX", 256);
			cropIntent.putExtra("outputY", 256);
			cropIntent.putExtra("return-data", true);
			System.out.println("picuri : "+picUri1);
			if(picUri1 != null){CROP_PIC = CROP_PIC1;  cropIntent.setDataAndType(picUri1, "image/*");startActivityForResult(cropIntent, CROP_PIC);}

		}
		// respond to users whose devices do not support the crop action
		catch (ActivityNotFoundException anfe) {
			Toast toast = Toast
					.makeText(this, "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
			toast.show();
		}
	}
	private void performCrophorizontalhigh() {
		// take care of exceptions
		
		try {
			
			Intent cropIntent = new Intent("com.android.camera.action.CROP");
			cropIntent.putExtra("crop", "true");
			cropIntent.putExtra("aspectX", 2);
			cropIntent.putExtra("aspectY", 1);
			cropIntent.putExtra("outputX", 480);
			cropIntent.putExtra("outputY", 480);
			cropIntent.putExtra("return-data", true);
			System.out.println("picuri : "+picUri1);
			if(picUri1 != null){CROP_PIC = CROP_PIC1;  cropIntent.setDataAndType(picUri1, "image/*");startActivityForResult(cropIntent, CROP_PIC);}

		}
		// respond to users whose devices do not support the crop action
		catch (ActivityNotFoundException anfe) {
			Toast toast = Toast
					.makeText(this, "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
			toast.show();
		}
	}
	private void performCropverticallowsquarelow() {
		// take care of exceptions
		
		try {
			
			Intent cropIntent = new Intent("com.android.camera.action.CROP");
			cropIntent.putExtra("crop", "true");
			cropIntent.putExtra("aspectX", 2);
			cropIntent.putExtra("aspectY", 2);
			cropIntent.putExtra("outputX", 256);
			cropIntent.putExtra("outputY", 256);
			cropIntent.putExtra("return-data", true);
			System.out.println("picuri : "+picUri1);
			if(picUri1 != null){CROP_PIC = CROP_PIC1;  cropIntent.setDataAndType(picUri1, "image/*");startActivityForResult(cropIntent, CROP_PIC);}
		}
		// respond to users whose devices do not support the crop action
		catch (ActivityNotFoundException anfe) {
			Toast toast = Toast
					.makeText(this, "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
			toast.show();
		}
	}
	private void performCropverticallowsquarehigh() {
		// take care of exceptions
		
		try {
			
			Intent cropIntent = new Intent("com.android.camera.action.CROP");
			cropIntent.putExtra("crop", "true");
			cropIntent.putExtra("aspectX", 2);
			cropIntent.putExtra("aspectY", 2);
			cropIntent.putExtra("outputX", 480);
			cropIntent.putExtra("outputY", 480);
			cropIntent.putExtra("return-data", true);
			System.out.println("picuri : "+picUri1);
			if(picUri1 != null){CROP_PIC = CROP_PIC1;  cropIntent.setDataAndType(picUri1, "image/*");startActivityForResult(cropIntent, CROP_PIC);}
		
		}
		// respond to users whose devices do not support the crop action
		catch (ActivityNotFoundException anfe) {
			Toast toast = Toast
					.makeText(this, "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
			toast.show();
		}
	}

private void savePreferences(String key, String value) {
	
	sharedPreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
	Editor e = sharedPreferences.edit();
	e.putString(key, value);
	e.commit();
	
	
}
private void savePreferences(String key, int value) {

	sharedPreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
	Editor e = sharedPreferences.edit();
	e.putInt(key, value);
	e.commit();
	
}

@Override
public void onResume(){
	
	  super.onResume();
}
@Override
public void onBackPressed()
  {
    finish();
    overridePendingTransition(R.anim.right_out,R.anim.right_in);
  }
  
  public void onClick(View paramView) {}
  
  
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  public String getRealPathFromURI(Uri contentUri) {
	  String[] proj = { MediaStore.Images.Media.DATA };
	  
	  //This method was deprecated in API level 11
	  //Cursor cursor = managedQuery(contentUri, proj, null, null, null);
	  
	  CursorLoader cursorLoader = new CursorLoader(
	            this, 
	            contentUri, proj, null, null, null);        
	  Cursor cursor = cursorLoader.loadInBackground();
	  
	  int column_index = 
	    cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	  cursor.moveToFirst();
	  return cursor.getString(column_index); 
	 }

}
