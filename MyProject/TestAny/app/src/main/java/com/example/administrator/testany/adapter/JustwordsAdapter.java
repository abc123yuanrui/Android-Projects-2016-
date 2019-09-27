package com.example.administrator.testany.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.testany.R;


import java.util.List;

/**
 * Created by Administrator on 2017/2/7 0007.
 */

public class JustwordsAdapter extends BaseAdapter {
    private List<Object> list_sam;
    private Context context;
    private LayoutInflater inflater;
    public JustwordsAdapter(Context context, List<Object> list_sam){
        this.context = context;
        this.list_sam = list_sam;
        this.inflater = LayoutInflater.from(context);
    }

    public int getCount() {

        return list_sam.size();
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.listview_sam,null);
        TextView tv_sam_name = (TextView)convertView.findViewById(R.id.samtext);
        tv_sam_name.setText(list_sam.get(position).toString());


        return convertView;
    }

    public long getItemId(int position) {

        return position;
    }


    public Object getItem(int position) {

        return list_sam.get(position);
    }
}
