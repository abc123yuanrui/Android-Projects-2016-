package com.example.administrator.drawviewforu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= new MenuInflater(this);
        inflater.inflate(R.menu.toolsmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        DrawView dv = (DrawView)findViewById(R.id.drawView1);
        DrawView dv2 = (DrawView)findViewById(R.id.drawView2);
        dv.paint.setXfermode(null);
        dv.paint.setStrokeWidth(5);
        switch (item.getItemId()){
            case R.id.red:
                dv.paint.setColor(Color.RED);
                item.setCheckable(true);
                break;
            case R.id.green:
                dv.paint.setColor(Color.GREEN);
                item.setCheckable(true);
                break;
            case R.id.blue:
                dv.paint.setColor(Color.BLUE);
                item.setCheckable(true);
                break;
            case R.id.width_1:
                dv.paint.setStrokeWidth(1);
                break;
            case R.id.width_2:
                dv.paint.setStrokeWidth(5);
                break;
            case R.id.width_3:
                dv.paint.setStrokeWidth(10);
                break;
            case R.id.clear:
                dv.clear();
                break;
            case R.id.save:
                dv.save();
                break;
            case R.id.guess:
                dv.setVisibility(View.INVISIBLE);
                dv.invalidate();
                dv2.paint.setXfermode(null);
                dv2.paint.setColor(Color.BLUE);
                dv2.paint.setStrokeWidth(10);
                item.setCheckable(true);

        }
        return true;

    }

}
