package com.universallock;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.FloatMath;

@SuppressLint("NewApi")
public class shakedetector implements SensorEventListener
{
  private static final int SHAKE_COUNT_RESET_TIME_MS = 3000;
  private static final int SHAKE_SLOP_TIME_MS = 500;
  private static final float SHAKE_THRESHOLD_GRAVITY = 1.5F;
  private OnShakeListener mListener;
  private int mShakeCount;
  private long mShakeTimestamp;
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    long l;
    if (this.mListener != null)
    {
      float f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      float f4 = f1 / 9.80665F;
      float f5 = f2 / 9.80665F;
      float f6 = f3 / 9.80665F;
      if (FloatMath.sqrt(f4 * f4 + f5 * f5 + f6 * f6) > 1.5F)
      {
        l = System.currentTimeMillis();
        if (500L + this.mShakeTimestamp <= l) {
          
        }
      }
    }
    return;
    

//    this.mShakeTimestamp = l;
 //   this.mShakeCount = (1 + this.mShakeCount);
 //   this.mListener.onShake(this.mShakeCount);
  }
  
  public void setOnShakeListener(OnShakeListener paramOnShakeListener)
  {
    this.mListener = paramOnShakeListener;
  }
  
  public static abstract interface OnShakeListener
  {
    public abstract void onShake(int paramInt);
  }
}


/* Location:           D:\file\1\Compressed\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name:     com.app.universallock.child.shakedetector
 * JD-Core Version:    0.7.0.1
 */