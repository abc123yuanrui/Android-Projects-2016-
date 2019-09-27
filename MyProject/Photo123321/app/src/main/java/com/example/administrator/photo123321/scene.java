package com.example.administrator.photo123321;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class scene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        Log.e("-------", "onCreate: " );
        ImageView back_a = (ImageView)findViewById(R.id.back_1);
        back_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ImageView photo123 =(ImageView)findViewById(R.id.photo) ;
        photo123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                return;
            }
        });
        Button buttonIntent =(Button)findViewById(R.id.button_intent);
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scene.this,Intentactivity.class);
                intent.putExtra("name_1","abc");
                startActivity(intent);
            }
        });
        Button buttonIntent_right =(Button)findViewById(R.id.button_intent_right);
        buttonIntent_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scene.this,Intentactivity.class);
                intent.putExtra("name_1","bbb");
                startActivity(intent);

            }
        });
        Button buttonIntent_left =(Button)findViewById(R.id.button_intent_left);
        buttonIntent_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scene.this,Intentactivity.class);
                intent.putExtra("name_1","ccc");
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        Log.e("-------", "onStart: " );
        Log.i("-----","onstart");

        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e("------","onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("------","onPause");
    }
}
