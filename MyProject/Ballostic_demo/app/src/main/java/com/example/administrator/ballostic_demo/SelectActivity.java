package com.example.administrator.ballostic_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        final ListView listView =(ListView)findViewById(R.id.select_list) ;
        int[] imageid = new int[]{R.drawable.berserker_icon,R.drawable.vanguard_icon,R.drawable.wraith_icon,R.drawable.shadow_icon,R.drawable.tank_icon,R.drawable.grenadier_icon,R.drawable.marksman_icon};
        String[] vocation = new String[]{"狂战士","冲锋队","幽灵","暗影","坦克","投弹手","光战队"};
        final List<Map<String,Object>> listItems =new ArrayList<Map<String, Object>>();
        for (int i=0;i<imageid.length;i++){
            Map<String,Object> map =new HashMap<String,Object>();
            map.put("image",imageid[i]);
            map.put("title",vocation[i]);
            listItems.add(map);
        }

        SimpleAdapter adapter=new SimpleAdapter(this,listItems,R.layout.selectvocation,new String[]{"title","image"},new int[]{
                R.id.vocation,R.id.classimage
        });
        listView.setAdapter(adapter);
        ImageView back=(ImageView)findViewById(R.id.back_a);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent();
                intent.setClass(SelectActivity.this,Scene.class);
                intent.putExtra("select",position);
                Log.e(position+"", "123 ");
                startActivity(intent);
        }});
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
