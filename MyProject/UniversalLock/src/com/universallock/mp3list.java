package com.universallock;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class mp3list extends Activity{ 

	private Context context;
		@Override
		public void onCreate(Bundle savedInstanceState){
			
			super.onCreate(savedInstanceState);
			setContentView(R.layout.mp3list);
			ListView lv = (ListView) findViewById(R.id.list);
			
			
			
			AlertDialog.Builder builderSingle = new AlertDialog.Builder(
                    mp3list.this);
            builderSingle.setIcon(R.drawable.ic_launcher);
            builderSingle.setTitle("Select One Name:-");
            
            File mydir = context.getDir("MediaStore.Audio", Context.MODE_PRIVATE);              
            File lister = mydir.getAbsoluteFile();
            final ArrayAdapter<File> arrayAdapter = new ArrayAdapter<File>(mp3list.this,android.R.layout.select_dialog_singlechoice);
            for (String list : lister.list())
            {
               //       
            	arrayAdapter.add(lister);
            }
            
            /*arrayAdapter.add("Hardik");
            arrayAdapter.add("Archit");
            arrayAdapter.add("Jignesh");
            arrayAdapter.add("Umang");
            arrayAdapter.add("Gatti");*/
            
            builderSingle.setNegativeButton("cancel",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            builderSingle.setAdapter(arrayAdapter,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //String strName = arrayAdapter.getItem(which);
                        	File fname= arrayAdapter.getItem(which);
                            AlertDialog.Builder builderInner = new AlertDialog.Builder(
                                    mp3list.this);
                            builderInner.setMessage(""+fname);
                            builderInner.setTitle("Your Selected Item is");
                            builderInner.setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            builderInner.show();
                        }
                    });
            builderSingle.show();
			
		}
		
}