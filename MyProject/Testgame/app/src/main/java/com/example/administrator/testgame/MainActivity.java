package com.example.administrator.testgame;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;
    private Button button5 = null;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private Chronometer chronometer;
    private Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        image1 = (ImageView)findViewById(R.id.imageView);
        image2 = (ImageView)findViewById(R.id.imageView2);
        image3 = (ImageView)findViewById(R.id.imageView3);
        image4 = (ImageView)findViewById(R.id.imageView4);
        image5 = (ImageView)findViewById(R.id.imageView5);
        chronometer = (Chronometer)findViewById(R.id.chronometer2) ;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                RotateAnimation rotateAnimation = new RotateAnimation(-45,45, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(250);
                rotateAnimation.setRepeatCount(ValueAnimator.INFINITE);
                rotateAnimation.setRepeatMode(Animation.REVERSE);
                animationSet.addAnimation(rotateAnimation);
                image1.startAnimation(animationSet);
                chronometer.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.setFormat("已用时间： %s");
                chronometer.start();
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if (SystemClock.elapsedRealtime()-chronometer.getBase()>=5000){
                            intent.setClass(MainActivity.this,Game.class);
                            intent.putExtra("imageid",0);
                            startActivity(intent);
                        }
                    }
                });


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                RotateAnimation rotateAnimation = new RotateAnimation(-45,45, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(280);
                rotateAnimation.setRepeatCount(ValueAnimator.INFINITE);
                rotateAnimation.setRepeatMode(Animation.REVERSE);
                animationSet.addAnimation(rotateAnimation);
                image2.startAnimation(animationSet);
                chronometer.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.setFormat("已用时间： %s");
                chronometer.start();
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if (SystemClock.elapsedRealtime()-chronometer.getBase()>=5000){
                            intent.setClass(MainActivity.this,Game.class);
                            intent.putExtra("imageid",1);
                            startActivity(intent);



                        }
                    }
                });


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                RotateAnimation rotateAnimation = new RotateAnimation(-45,45, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(250);
                rotateAnimation.setRepeatCount(ValueAnimator.INFINITE);
                rotateAnimation.setRepeatMode(Animation.REVERSE);
                animationSet.addAnimation(rotateAnimation);
                image3.startAnimation(animationSet);
                chronometer.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.setFormat("已用时间： %s");
                chronometer.start();
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if (SystemClock.elapsedRealtime()-chronometer.getBase()>=5000){
                            intent.setClass(MainActivity.this,Game.class);
                            intent.putExtra("imageid",2);
                            startActivity(intent);
                        }
                    }
                });


            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                RotateAnimation rotateAnimation = new RotateAnimation(-45,45, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(250);
                rotateAnimation.setRepeatCount(ValueAnimator.INFINITE);
                rotateAnimation.setRepeatMode(Animation.REVERSE);
                animationSet.addAnimation(rotateAnimation);
                image4.startAnimation(animationSet);
                chronometer.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.setFormat("已用时间： %s");
                chronometer.start();
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if (SystemClock.elapsedRealtime()-chronometer.getBase()>=5000){
                            intent.setClass(MainActivity.this,Game.class);
                            intent.putExtra("imageid",3);
                            startActivity(intent);
                        }
                    }
                });


            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                RotateAnimation rotateAnimation = new RotateAnimation(-45,45, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(250);
                rotateAnimation.setRepeatCount(ValueAnimator.INFINITE);
                rotateAnimation.setRepeatMode(Animation.REVERSE);
                animationSet.addAnimation(rotateAnimation);
                image5.startAnimation(animationSet);
                chronometer.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.setFormat("已用时间： %s");
                chronometer.start();
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if (SystemClock.elapsedRealtime()-chronometer.getBase()>=5000){
                            intent.setClass(MainActivity.this,Game.class);
                            intent.putExtra("imageid",4);
                            startActivity(intent);
                        }
                    }
                });


            }
        });

    }
}
