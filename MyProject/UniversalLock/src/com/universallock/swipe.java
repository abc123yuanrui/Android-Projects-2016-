package com.universallock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class swipe
  extends Activity
{
  private GestureDetector gestureDetector;
  
  private void onLeftSwipe()
  {
    startActivity(new Intent(this, test.class));
  }
  
  private void onRightSwipe()
  {
    startActivity(new Intent(this, MainActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.gestureDetector = new GestureDetector(new SwipeGestureDetector());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.gestureDetector.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  private class SwipeGestureDetector
    extends GestureDetector.SimpleOnGestureListener
  {
    private static final int SWIPE_MAX_OFF_PATH = 200;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    
    private SwipeGestureDetector() {}
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      float f2;
      try
      {
        float f1 = Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY());
        f2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
        if (f1 > 200.0F) {
          return false;
        }
        if ((f2 > 120.0F) && (Math.abs(paramFloat1) > 200.0F))
        {
          swipe.this.onLeftSwipe();
          return false;
        }
      }
      catch (Exception localException)
      {
        Log.e("YourActivity", "Error on gestures");
        return false;
      }
      if ((-f2 > 120.0F) && (Math.abs(paramFloat1) > 200.0F)) {
        swipe.this.onRightSwipe();
      }
      return false;
    }
  }
}

