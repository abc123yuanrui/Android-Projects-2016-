package com.example.administrator.woocongress_modified.adapter;

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

import com.example.administrator.woocongress_modified.Camera_main;
import com.example.administrator.woocongress_modified.MainActivity;
import com.example.administrator.woocongress_modified.R;
import com.example.administrator.woocongress_modified.SignRecord;
import com.example.administrator.woocongress_modified.WeDroidAlignTextView;
import com.example.administrator.woocongress_modified.listelement;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19 0019.
 */

public class ListViewAdapter extends BaseAdapter {
//    private List<Object> list_meet;
//    private List<Object> list_time;
//    private List<Object> list_location;
//    private List<Object>list_theme;
//    private List<Object>list_details;
    private List<listelement> listelement;
    private Context context;
    private LayoutInflater inflater;
    private ImageView codebutton;
    private ImageView signbuton;
    private ImageView signedbutton;
    private TextView signdetail;
    private int type;
    static int item=-1;

    Dialog dia;

    public  void selectitem (int position){
//        this.item=position;

    }

    public ListViewAdapter(Context context,int type, List<listelement> listelement){
        this.context = context;
        this.type = type;
        this.listelement=listelement;
//        this.list_time = list_time;
//        this.list_location=list_location;
//        this.list_theme=list_theme;
//        this.list_details=list_details;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return listelement.size();
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (type==0) {

            dia = new Dialog(context, R.style.OverlayDialog);
            dia.setContentView(R.layout.popout);
            ImageView imageView = (ImageView) dia.findViewById(R.id.popoutimage);
            final TextView signdetails = (TextView) dia.findViewById(R.id.signdetail);
            imageView.setBackgroundResource(R.drawable.popcode);

            convertView = inflater.inflate(R.layout.listview_item, null);
            signedbutton = (ImageView)convertView.findViewById(R.id.signedbutton) ;
            codebutton = (ImageView) convertView.findViewById(R.id.codebutton);
            signbuton = (ImageView) convertView.findViewById(R.id.signbutton);
            TextView tv_meet_name = (TextView) convertView.findViewById(R.id.meeting);
            TextView tv_time_name = (TextView) convertView.findViewById(R.id.starttime);
            TextView tv_location_name = (TextView) convertView.findViewById(R.id.address);
            tv_meet_name.setText(listelement.get(position).getMeeting());
            tv_time_name.setText(listelement.get(position).getTime());
            tv_location_name.setText(listelement.get(position).getAddress());
            if (listelement.get(position).getSignornot()==1)
            {
                signedbutton.setVisibility(View.VISIBLE);
            }
            if (position == 0 || position == 2) {
//            "临时用position判断代替"
                codebutton.setVisibility(View.INVISIBLE);
            }
//            if (position == item){
//                signedbutton.setVisibility(View.VISIBLE);
//            }
            codebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dia.show();
                    dia.setCanceledOnTouchOutside(true);
                }

            });

            signdetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("进入签到记录", "onClick: ");
                    Intent tosigndetails = new Intent();
                    tosigndetails.setClass(context, SignRecord.class);
                    tosigndetails.putExtra("signdetail_which", position);
                    context.startActivity(tosigndetails);
                }
            });
            signbuton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent startsign = new Intent();

                    startsign.setClass(context, Camera_main.class);
                    startsign.putExtra("meetingnumber",position);
                    item =position;
                    ((MainActivity)context).startActivityForResult(startsign,1);
                    Log.e("123", "onClick: ");
                }
            });
        }
        if (type ==1)
        {
            convertView = inflater.inflate(R.layout.listview_withdetail, null);
            TextView tv_theme_name = (TextView) convertView.findViewById(R.id.theme);
            TextView tv_details_name = (TextView) convertView.findViewById(R.id.details);
            tv_theme_name.setText(listelement.get(position).getTheme());
            tv_details_name.setText(listelement.get(position).getDetails());
        }

        return convertView;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public Object getItem(int position) {

        return listelement.get(position);
    }
}
