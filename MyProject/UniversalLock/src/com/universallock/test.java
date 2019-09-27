package com.universallock;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

public class test
  extends Activity
  implements SwipeRefreshLayout.OnRefreshListener
{
  SwipeRefreshLayout swipeLayout;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903051);
    this.swipeLayout = ((SwipeRefreshLayout)findViewById(2131427413));
    this.swipeLayout.setOnRefreshListener(this);
    this.swipeLayout.setColorScheme(new int[] { 17170459, 17170452, 17170456, 17170454 });
  }
  
  public void onRefresh()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        test.this.swipeLayout.setRefreshing(false);
      }
    }, 0L);
  }
}

