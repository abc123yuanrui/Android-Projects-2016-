package com.example.administrator.ballostic_demo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class Scene extends AppCompatActivity {
    public int[] imageid = new int[]{R.drawable.beserker,R.drawable.van,R.drawable.wraith,R.drawable.shadow,R.drawable.tank,R.drawable.gren,R.drawable.marks};
    private ImageSwitcher imageSwitcher;
    private int index = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageswitcher1);
//        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
//        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(Scene.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                return imageView;
            }
        });

        getIntent();
        index= getIntent().getIntExtra("select",0);
        imageSwitcher.setImageResource(imageid[index]);
        Button down = (Button)findViewById(R.id.button1) ;
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<imageid.length-1){
                    index++;
                }else {
                    index=0;
                }
                imageSwitcher.setImageResource(imageid[index]);
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
}
