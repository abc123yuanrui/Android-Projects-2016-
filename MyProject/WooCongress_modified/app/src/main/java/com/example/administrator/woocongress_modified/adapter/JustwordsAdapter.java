package com.example.administrator.woocongress_modified.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.woocongress_modified.R;
import com.example.administrator.woocongress_modified.listattend;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7 0007.
 */

public class JustwordsAdapter extends BaseAdapter {
    private List<listattend> list_sam;
    private Context context;
    private LayoutInflater inflater;
    public JustwordsAdapter(Context context, List<listattend> list_sam){
        this.context = context;
        this.list_sam = list_sam;
        this.inflater = LayoutInflater.from(context);
    }

    public int getCount() {

        return list_sam.size();
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.listview_attend,null);
        TextView tv_sam_name = (TextView)convertView.findViewById(R.id.name);
        TextView tv_sam_signedornot = (TextView)convertView.findViewById(R.id.ifsigned) ;
        ImageView tv_sam_laugh = (ImageView)convertView.findViewById(R.id.laugh) ;
        TextView tv_sam_time = (TextView)convertView.findViewById(R.id.signtime) ;
        tv_sam_name.setText(list_sam.get(position).getName());
        tv_sam_time.setText(list_sam.get(position).getTime());
        if(list_sam.get(position).getImageid()==1){
            tv_sam_signedornot.setText("已签到");
            tv_sam_laugh.setImageResource(R.drawable.laughface);
        }
        if(list_sam.get(position).getImageid()==0){
            tv_sam_signedornot.setText("未签到");
            tv_sam_laugh.setImageResource(R.drawable.sadface);
        }


        return convertView;
    }

    public long getItemId(int position) {

        return position;
    }


    public Object getItem(int position) {

        return list_sam.get(position);
    }
}
