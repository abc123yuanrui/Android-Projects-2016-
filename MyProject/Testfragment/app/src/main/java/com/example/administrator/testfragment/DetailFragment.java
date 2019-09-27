package com.example.administrator.testfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/1/25 0025.
 */

public class DetailFragment extends Fragment {
    public static DetailFragment newInstance(int index){
        DetailFragment f = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        Log.e("useDetail", "newInstance: " );
        f.setArguments(bundle);
        return  f;
    }
    public int getShownIndex(){
        return  getArguments().getInt("index",0);
    }

    public View onCreatView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        if (container==null){
            return null;
        }
        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        text.setPadding(10,10,10,10);
        scroller.addView(text);
        text.setText(Data.DETIL[getShownIndex()]);
        return  scroller;
    }
}
