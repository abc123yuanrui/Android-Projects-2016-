package com.example.administrator.woocongress.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.woocongress.Camera_main;
import com.example.administrator.woocongress.MainActivity;
import com.example.administrator.woocongress.R;
import com.example.administrator.woocongress.SignRecord;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19 0019.
 */

public class ListViewAdapter extends BaseAdapter {
    private List<Object> list_meet;
    private List<Object> list_time;
    private List<Object> list_location;
    private Context context;
    private LayoutInflater inflater;
    private ImageView codebutton;
    private ImageView signbuton;
    private TextView signdetail;
    private int item=-1;
    Dialog dia;

    public  void selectitem (int position){
        this.item=position;

    }

    public ListViewAdapter(Context context, List<Object> list_meet,List<Object> list_time,List<Object>list_location){
        this.context = context;
        this.list_meet = list_meet;
        this.list_time = list_time;
        this.list_location=list_location;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return list_meet.size();
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        dia = new Dialog(context,R.style.OverlayDialog);
        dia.setContentView(R.layout.popout);
        ImageView imageView = (ImageView) dia.findViewById(R.id.popoutimage);
        final TextView signdetails = (TextView)dia.findViewById(R.id.signdetail);
        imageView.setBackgroundResource(R.drawable.popcode);

        convertView = inflater.inflate(R.layout.listview_item,null);
        codebutton = (ImageView)convertView.findViewById(R.id.codebutton);
        signbuton = (ImageView)convertView.findViewById(R.id.signbutton);
        TextView tv_meet_name = (TextView)convertView.findViewById(R.id.meeting);
        TextView tv_time_name = (TextView)convertView.findViewById(R.id.starttime);
        TextView tv_location_name = (TextView)convertView.findViewById(R.id.address);
        tv_meet_name.setText(list_meet.get(position).toString());
        tv_time_name.setText(list_time.get(position).toString());
        tv_location_name.setText(list_location.get(position).toString());
        if (position==0||position==2){
//            "临时用position判断代替"
            codebutton.setVisibility(View.INVISIBLE);
        }
        codebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dia.show();
                dia.setCanceledOnTouchOutside(true);
//                Window w = dia.getWindow();
//                WindowManager.LayoutParams lp = w.getAttributes();
//                lp.x = 0;
//                lp.y = 40;
//                dia.onWindowAttributesChanged(lp);

            }
        });
        signdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("进入签到记录", "onClick: ");
                Intent tosigndetails = new Intent();
                tosigndetails.setClass(context, SignRecord.class);
                tosigndetails.putExtra("signdetail_which",position);
                context.startActivity(tosigndetails);
            }
        });
        signbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startsign = new Intent();
                startsign.setClass(context, Camera_main.class);
                context.startActivity(startsign);
                Log.e("123", "onClick: " );
            }
        });

        return convertView;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public Object getItem(int position) {

        return list_meet.get(position);
    }
}
