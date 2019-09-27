package com.example.administrator.testgame;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameoverActivity extends AppCompatActivity {
    private String[] charactor={"战斗郑","驴哥","拉面","狗三","扎刺四"};
    private int imageid;
    private int[] pictureid ={R.drawable.zheng,R.drawable.lv,R.drawable.mian,R.drawable.san,R.drawable.si,};
    private Chronometer chronometer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        getIntent();
        imageid = getIntent().getIntExtra("imageid2",imageid);
        TextView word=(TextView)findViewById(R.id.textView2);
        chronometer = (Chronometer)findViewById(R.id.chronometer3);
        word.setText(charactor[imageid]+"已经被打的惨不忍睹，他拉着你不让你走了");
        ImageView picture = (ImageView)findViewById(R.id.imageView2);
        picture.setImageResource(pictureid[imageid]);
        Log.e(""+imageid, "onCreate: " );
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setFormat("已用时间： %s");
        chronometer.start();
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime()-chronometer.getBase()>=5000){
                    android.os.Process.killProcess(android.os.Process.myPid() );
                    System.exit(0);

                }
            }
        });


    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
