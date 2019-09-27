package com.example.administrator.passport.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.passport.R;
import com.example.administrator.passport.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class passportActivity extends AppCompatActivity {
    private Map<String,String> map =new HashMap<String,String>();
    private String country[]=new String[]{"日本","韩国","加拿大","美国","英国","法国"};
    private ArrayList<Object> list = new ArrayList<Object>();
    private int nnn=0;
    private ListViewAdapter adapter;
    private  String mmm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i=0;i<6;i++)
        {
            list.add(country[i]);
        }
        setContentView(R.layout.activity_passport);
        getIntent();

         adapter = new ListViewAdapter(passportActivity.this,list);

        adapter.notifyDataSetChanged();

        for (int i=0;i<list.size();i++)
        {
            map.put(i+"","0");
        }


        ListView testlist =(ListView)findViewById(R.id.listview);
        testlist.setAdapter(adapter);

        testlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nnn = position;
                Intent intent=new Intent();
                intent.setClass(passportActivity.this,EditTextActivity.class);
                intent.putExtra("country",list.get(position).toString());
                startActivityForResult(intent,1);
                ImageView imageButton = (ImageView) view.findViewById(R.id.choose_k);
                Log.e("onitenclick","onitenclick");
                if (imageButton.getVisibility()==View.INVISIBLE){
                   Log.e("123","321");
                   imageButton.setVisibility(View.VISIBLE);
                   map.put(position+"","1");
               }else {
                    Log.e("else,visible", "onItemClick: " );
                    imageButton.setVisibility(View.INVISIBLE);
                   map.put(position+"","0");
                }

            }
        });

        ImageView backbutton =(ImageView)findViewById(R.id.back_a);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
        Log.e("onresume", mmm+"---");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode==1)
        {
//        country[nnn]=
            mmm = data.getExtras().getString("change");
//            mmm=data.getStringExtra("change");
            country[nnn]=mmm;
            Log.e("onActivityResult", mmm+"---");
            list.clear();;
            for (int j=0;j<country.length;j++){
                list.add(country[j]);
            }

        }
    }
}
