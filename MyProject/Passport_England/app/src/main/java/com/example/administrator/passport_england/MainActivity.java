package com.example.administrator.passport_england;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.passport_england.adapter.ListViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String country[]=new String[]{"日本","韩国","印度","美国","加拿大","英国"};
    private ArrayList<Object> list= new ArrayList<Object>();
    private ListViewAdapter adapter;
    private int selection;
    private ListView testlist;
    private Button toast;
    private NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i=0;i<country.length;i++)
        {
            list.add(country[i]);
        }
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        setContentView(R.layout.activity_main);
        adapter = new ListViewAdapter(MainActivity.this,list);
        adapter.notifyDataSetChanged();

        testlist = (ListView)findViewById(R.id.listview) ;
        testlist.setAdapter(adapter);

        final Button tonext = (Button)findViewById(R.id.tonext);
        toast = (Button)findViewById(R.id.toast) ;

        testlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

               adapter.selectitem(position);
                adapter.notifyDataSetChanged();
                tonext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=(new Intent());
                        intent.setClass(MainActivity.this,Modify.class);
                        intent.putExtra("selection",position);
                        startActivityForResult(intent,1);
                    }
                });
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK){
            Notification.Builder notify = new Notification.Builder(this);
            notify.setContentTitle("您修改了列表");
            notify.setContentText("滑动消息框关闭");
            notify.setSmallIcon(R.drawable.question);



            Notification notification = notify.getNotification();

            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notification.when = System.currentTimeMillis();
            notification.defaults = Notification.DEFAULT_ALL;

            notificationManager.notify(1,notification);
            selection=data.getExtras().getInt("select");
            country[selection]=data.getExtras().getString("modify");
            Log.e(country[selection], "123" );
            list.clear();
            for(int j=0;j<country.length;j++){
                list.add(country[j]);
            }
            adapter.notifyDataSetChanged();
            toast.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(country[selection], "onClick: " );
                    Toast toastthis = Toast.makeText(MainActivity.this,country[selection],Toast.LENGTH_LONG);
                    toastthis.show();
                }
            });
        }
    }
}
