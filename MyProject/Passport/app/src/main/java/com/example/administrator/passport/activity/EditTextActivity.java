package com.example.administrator.passport.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.passport.R;


public class EditTextActivity extends AppCompatActivity {
    private String country="Text";
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        Button button2 = (Button)findViewById(R.id.button2);
        editText =(EditText)findViewById(R.id.edit);
        textView = (TextView)findViewById(R.id.textView) ;
        Button button = (Button)findViewById(R.id.button);
        getIntent();
        country = getIntent().getStringExtra("country");
        editText.setHint(country);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(country);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText());
                Button button3 = (Button)findViewById(R.id.button3);

                }});
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("change",editText.getText().toString()+"----");
//                    intent.putExtra("change","change");
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
        });



    }
}
