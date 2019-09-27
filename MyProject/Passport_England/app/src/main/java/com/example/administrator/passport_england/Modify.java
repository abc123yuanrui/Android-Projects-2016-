package com.example.administrator.passport_england;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Modify extends AppCompatActivity {
    private String change;
    private int position;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        editText=(EditText)findViewById(R.id.edit) ;
        getIntent();
        position=getIntent().getIntExtra("selection",position);
        Log.e(position+"", "onCreate: " );
        Button verified =(Button)findViewById(R.id.verified);
        verified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("modify",editText.getText().toString());
                intent.putExtra("select",position);
                setResult(Activity.RESULT_OK,intent);
                finish();
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
