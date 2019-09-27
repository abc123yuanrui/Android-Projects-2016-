package com.example.administrator.woocongress_modified;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Meetingdetail extends AppCompatActivity {
    private WebView detailweb;
    private int selection;
    private String[] website={"http://58.247.119.47:10045/unions/info/383.jspx","http://58.247.119.47:10045/unions/info/369.jspx","http://58.247.119.47:10045/unions/info/383.jspx","http://58.247.119.47:10045/unions/info/383.jspx","http://58.247.119.47:10045/unions/info/369.jspx"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetingdetail);
        detailweb = (WebView) findViewById(R.id.meetingdetail);

        detailweb.getSettings().setJavaScriptEnabled(true);
        detailweb.getSettings().setSupportZoom(true);
        detailweb.getSettings().setBuiltInZoomControls(true);
        detailweb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        detailweb.getSettings().setLoadWithOverviewMode(true);
        getIntent();
        selection = getIntent().getIntExtra("position",selection);

        detailweb.loadUrl(website[selection]);
        detailweb.setWebViewClient(new HelloWebViewClient ());
    }
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
