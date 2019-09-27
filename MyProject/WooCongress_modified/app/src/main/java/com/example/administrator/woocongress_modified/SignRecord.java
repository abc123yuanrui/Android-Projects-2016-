package com.example.administrator.woocongress_modified;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.woocongress_modified.adapter.JustwordsAdapter;

import java.util.ArrayList;
import java.util.List;

public class SignRecord extends AppCompatActivity {
    private TextView menutext;
    private String name [] ={"赵一","钱二","孙三","李四","王五","周六","吴七","正八","冯九","陈十","楚十一","卫十二"};
    private String signtime [] ={"12-24 12:00","12-24 22:03","12-14 22:02","09-24 22:22","11-22 12:22","11-22 12:22","11-22 12:22","11-22 12:22","11-22 12:22","11-22 12:22","11-22 12:22","11-22 12:22"};
    private int imageok []={1,1,0,1,0,1,1,1,1,1,0,1};
    private List<listattend> listforattend;
    private ListView namelist;
    private JustwordsAdapter justadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_record);

        namelist=(ListView)findViewById(R.id.attendlist) ;
        listforattend = new ArrayList<listattend>();
        for(int i=0;i<name.length;i++){
            listattend listattend_new= new listattend();
            listattend_new.setTime(signtime[i]);
            listattend_new.setName(name[i]);
            listattend_new.setImageid(imageok[i]);
            listforattend.add(listattend_new);
        }
        justadapter = new JustwordsAdapter(SignRecord.this,listforattend);
        justadapter.notifyDataSetChanged();

        namelist.setAdapter(justadapter);

        menutext = (TextView)findViewById(R.id.menutext);
        TextPaint tp = menutext.getPaint();
        tp.setFakeBoldText(true);
    }
}
