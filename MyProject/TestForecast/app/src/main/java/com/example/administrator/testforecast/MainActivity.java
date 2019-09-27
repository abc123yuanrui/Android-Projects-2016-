package com.example.administrator.testforecast;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    String location = "101050101";
    private FloatingActionButton button;
    private TextView textView;
    private ImageView imageView;
    String count = "";
    private int picid =1 ;
    private CoordinatorLayout tex;
    private int[] imageid = new int[]{R.drawable.beijing,R.drawable.harbin,R.drawable.shanghai,R.drawable.tianjin,R.drawable.lanzhou,R.drawable.wuhan};
    final String Urladdress = "api.openweathermap.org/data/2.5/weather?q=Harbin,uk&APPID=a81f98218efbee5615b345d21d7d1283";
    HttpURLConnection urlConn = null;
    boolean isPost = true;
    URL url = null;
    String resultData = "";
    Toolbar toolbar;
//    private void initInstances() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//
//    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case 0:
                    Log.e("handle","0000000000");
                    Log.e("handle",msg.toString());
                   String re = (String)msg.obj;
                    Snackbar.make(tex, re, Snackbar.LENGTH_SHORT) .setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                        }
                    })
                            .show();

//                    imageView =(ImageView)findViewById(R.id.picture);
//                    imageView.setImageResource(imageid[picid]);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tex = (CoordinatorLayout) findViewById(R.id.tex);
        CollapsingToolbarLayout collapsing = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsing.setTitle("123321");
        button = (FloatingActionButton)findViewById(R.id.fabBtn);
        setSupportActionBar(toolbar);

//        button=(Button) findViewById(R.id.button2);
//        textView = (TextView) findViewById(R.id.textView1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "点击了Button");
//                Snackbar.make(tex, "Hello. I am Snackbar!", Snackbar.LENGTH_SHORT)
//                        .setAction("Undo", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                            }
//                        })
//                        .show();
//                sendRequestWithHttpClient();
             HttpURL();




            }
        });
  }
//    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= new MenuInflater(this);
        inflater.inflate(R.menu.menu_city,menu);
        return super.onCreateOptionsMenu(menu);
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.beijing:
//                location="101010100";
//                picid = 0;
//                button.setText("北京");
//                break;
//            case R.id.harbin:
//                location="101050101";
//                picid = 1;
//                button.setText("哈尔滨");
//                break;
//            case R.id.shanghai:
//                location="101020100";
//                picid = 2;
//                button.setText("上海");
//                break;
//            case R.id.tianjin:
//                location="101030100";
//                picid = 3;
//                button.setText("天津");
//                break;
//            case R.id.lanzhou:
//                location="101160101";
//                picid = 4;
//                button.setText("兰州");
//                break;
//            case R.id.wuhan:
//                location="101200101";
//                picid = 5;
//                button.setText("武汉");
//                break;
//            case R.id.qingdao:
//                location="101120201";
//                picid = 0;
//                button.setText("青岛");
//                break;
//            case R.id.shijiazhuang:
//                location="101090101";
//                picid = 0;
//                button.setText("石家庄");
//                break;
//            case R.id.shenzhen:
//                location="101280601";
//                picid = 0;
//                button.setText("深圳");
//                break;
//            case R.id.guangzhou:
//                location="101280101";
//                picid = 0;
//                button.setText("广州");
//                break;
//            case R.id.zhumadian:
//                location="101181601";
//                picid = 0;
//                button.setText("驻马店");
//                break;
//            case R.id.ningbo:
//                location="101210401";
//                picid = 0;
//                button.setText("宁波");
//                break;
//
//        }
//        return true;
//    }
    private void HttpURLConnection_Get(){
        try{
            isPost = false;
            //通过openConnection 连接

            URL url = new java.net.URL(Urladdress);
            urlConn=(HttpURLConnection)url.openConnection();
            //设置输入和输出流
//            urlConn.setDoOutput(true);
            urlConn.setDoInput(true);
            //关闭连接
            urlConn.disconnect();
        }catch(Exception e){
            count = "连接超时";
            Log.d("GETWRONG", "HttpURLConnection_Get: ");
            Message mg = Message.obtain();
            mg.obj = count;
            handler.sendMessage(mg);
            e.printStackTrace();
        }
    }
    private void HttpURL() {
        new Thread(){
            public void run() {

                try{
                    HttpURLConnection_Get();


                    InputStreamReader in = new InputStreamReader(urlConn.getInputStream());
                    BufferedReader buffer = new BufferedReader(in);
                    StringBuilder response = new StringBuilder();
                    String inputLine = null;
                    while (((inputLine = buffer.readLine()) != null)){
                        response.append(inputLine);
                    }
                    parseJSONObjectOrJSONArray(response.toString());
                    in.close();

                }catch(Exception e){
                    count = "连接超时";
                    Log.e("HttpURL", "run: " );
                    e.printStackTrace();
                }finally{
                    try{
                        //关闭连接
                        if(isPost)
                            urlConn.disconnect();

                       /* Message mg = Message.obtain();
                        mg.obj = resultData;
                        handler.sendMessage(mg);*/
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    private void parseJSONObjectOrJSONArray(String jsonData){
        try {
            count = "";
            Log.d(jsonData, "weather ");
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject jsonArray = jsonObject.getJSONObject("weather");
//            if (jsonObject.length()>0){


//                for (int i=0;i<jsonArray.length();i++){
                    String city = jsonArray.optString("main");
                    String lowtem = jsonArray.optString("description");
                    String hightem = jsonArray.optString("ticon");
                    String weather = jsonArray.optString("weather");
                    count =count +"\n"+ "城市："+city + "   最低气温： " + lowtem + "   最高气温 " + hightem + "  天气" + weather;
                    Log.i("AAA",count);

//                }

                Message message = new Message();
                message.what = 0;
                message.obj = count;
                handler.sendMessage(message);
//            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }
//    private void sendRequestWithHttpClient(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//
//                    URL url = new URL("http://www.weather.com.cn/data/cityinfo/101010100.html");
//                    connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setConnectTimeout(5000);
//                    connection.setReadTimeout(5000);
//                    InputStream in = connection.getInputStream();
//                    Log.e("getconnection", "run");
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        response.append(line);
//                    }
//                    Log.i("TAG", response.toString());
//                    parseJSONObjectOrJSONArray(response.toString());
//                }
//                catch (MalformedURLException e){
//                    e.printStackTrace();
//                }
//                catch (IOException e){
//                    e.printStackTrace();
//                    Log.e("IOexception", "run: " );
//                }
//                }
//        }).start();
//    }
//    private void parseJSONObjectOrJSONArray(String jsonData){
//        try {
//            String count = "";
//            JSONObject jsonObject = new JSONObject(jsonData);
//            JSONArray jsonArray = jsonObject.getJSONArray("results");
//            if (jsonArray.length()>0){
//                JSONObject object = jsonArray.getJSONObject(0);
//                String city = object.optString("currentCity");
//                JSONArray array = object.getJSONArray("weather_data");
//                for (int i=0;i<array.length();i++){
//                    JSONObject jsonObject1 = array.getJSONObject(i);
//                    String dateDay = jsonObject1.optString("date");
//                    String weather = jsonObject1.optString("weather");
//                    String wind = jsonObject1.optString("wind");
//                    String temperature = jsonObject1.optString("temperature");
//                    count =count +"\n"+ dateDay + " " + weather + " " + wind + " " + temperature;
//                    Log.i("AAA",count);
//
//                }
//                Message message = new Message();
//                message.what = 0;
//                message.obj = count;
//                handler.sendMessage(message);
//            }
//        }
//        catch (JSONException e){
//            e.printStackTrace();
//        }
//    }
}
