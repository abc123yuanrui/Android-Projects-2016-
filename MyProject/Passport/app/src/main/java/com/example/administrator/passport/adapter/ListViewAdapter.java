package com.example.administrator.passport.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.passport.R;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19 0019.
 */

public class ListViewAdapter extends BaseAdapter {
    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;
    private ImageView imageButton;

    public ListViewAdapter(Context context, List<Object> list){
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return list.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.listview_item,null);
        imageButton = (ImageView)convertView.findViewById(R.id.choose_k);


        TextView tv_country_name = (TextView)convertView.findViewById(R.id.korea);
        tv_country_name.setText(list.get(position).toString());

        return convertView;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }
}
