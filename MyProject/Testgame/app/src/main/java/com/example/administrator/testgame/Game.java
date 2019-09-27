package com.example.administrator.testgame;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {
    private int imageid;
    private int score=0;
    private int [] pictureid ={R.drawable.zheng2,R.drawable.lv,R.drawable.mian2,R.drawable.san2,R.drawable.si2,};
    private ImageView image;
    private Handler handler= new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int index = 0;

            if (score == 5){
                Intent intent = new Intent();
                intent.setClass(Game.this,GameoverActivity.class);
                intent.putExtra("imageid2",imageid);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
                finish();
              score ++;
//
//                Log.d("besent", imageid+" ");

            }
            if (msg.what == 0) {
                index = msg.arg1;
                image.setX(position[index][0]);
                image.setY(position[index][1]);
                image.setVisibility(View.VISIBLE);
            }
            super.handleMessage(msg);
        }
    };
    public int[][] position = new int[][]{
            {231,325},{424,349},{521,256},{543,296},{715,245},{832,292},{722,358}
    };
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            int index =0;
            while (!Thread.currentThread().isInterrupted()){
                index = new Random().nextInt(position.length);
                Message m =handler.obtainMessage();
                m.arg1 = index;
                m.what = 0;
                handler.sendMessage(m);
                try {
                    Thread.sleep(new Random().nextInt(500)+500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    });




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getIntent();
        imageid = getIntent().getIntExtra("imageid",imageid);
        Log.e(""+imageid, "onCreate: " );
        final AnimationSet animationSet = new AnimationSet(true);
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1,1,1,0,animationSet.RELATIVE_TO_SELF,0.5f,animationSet.RELATIVE_TO_SELF,3);
        animationSet.setDuration(500);
        t.start();
        image = (ImageView)findViewById(R.id.mouse) ;
        image.setImageResource(pictureid[imageid]);
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                animationSet.addAnimation(scaleAnimation);
                image.startAnimation(animationSet);
//                v.setVisibility(View.INVISIBLE);
                score++;
                Toast.makeText(Game.this,"打到"+score+"次",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        if (score>= 3){
//            finish();
//        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
//    public void onAttachedToWindow() {
//        this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
//        super.onAttachedToWindow();
//    }
}
