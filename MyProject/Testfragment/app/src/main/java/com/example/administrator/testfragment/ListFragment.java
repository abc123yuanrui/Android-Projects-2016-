package com.example.administrator.testfragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/1/24 0024.
 */

public class ListFragment extends android.app.ListFragment{
    boolean dualpane;
    int curCheckPosition = 0;


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_checked,Data.TITLE));
        View detalFrame =  getActivity().findViewById(R.id.detail);
        Log.e("123", "onActivityCreated: " );
        dualpane = detalFrame!=null&&
                detalFrame.getVisibility()==View.VISIBLE;
        if (savedInstanceState!=null){
            curCheckPosition = savedInstanceState.getInt("curChoice",0);
        }
        if (dualpane){

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(curCheckPosition);
        }
    }
@Override
public void onSaveInstanceState(Bundle outState){
    super.onSaveInstanceState(outState);
    outState.putInt("curChoice",curCheckPosition);

}


void showDetails(int index){
    curCheckPosition=index;
    if (dualpane){
        getListView().setItemChecked(index,true);
        DetailFragment details = (DetailFragment)getFragmentManager().findFragmentById(R.id.detail);
        if (details==null||details.getShownIndex()!=index){
            details = DetailFragment.newInstance(index);
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.replace(R.id.detail,details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }else {
        Intent intent = new Intent(getActivity(),MainActivity.DetailActivity.class);
        intent.putExtra("index",index);
        startActivity(intent);
    }
}
    @Override
    public void onListItemClick(ListView I,View v,int position,long id){
        showDetails(position);
    }




}
