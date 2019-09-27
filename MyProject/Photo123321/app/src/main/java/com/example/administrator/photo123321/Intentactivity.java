package com.example.administrator.photo123321;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Intentactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentactivity);

        Intent intent2 = getIntent();
        String name_intent2 = intent2.getStringExtra("name_1");
        TextView intent2_text = (TextView) findViewById(R.id.intenttext);
        intent2_text.setText(name_intent2);
        intent2_text.setTextColor(getResources().getColor(R.color.text_color));
        if(TextUtils.equals(name_intent2,"abc")){
            Toast.makeText(this,"you push the central button",Toast.LENGTH_LONG).show();
        }else if(TextUtils.equals(name_intent2,"bbb"))
        {
            Toast.makeText(this,"you push the left button",Toast.LENGTH_LONG).show();
        }else if(TextUtils.equals(name_intent2,"ccc"))
        {
            Toast.makeText(this,"you push the right button",Toast.LENGTH_LONG).show();
        }
        ImageView back_a = (ImageView)findViewById(R.id.back_1);
        back_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intentactivity.this,scene.class);
//                startActivity(intent1);
                finish();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e( "123","onStop: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("321", "onPause: ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("4212", "onDestroy: ");
    }
}
