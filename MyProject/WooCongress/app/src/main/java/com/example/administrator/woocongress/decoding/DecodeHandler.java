/*
 * Copyright (C) 2010 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.administrator.woocongress.decoding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.example.administrator.woocongress.Camera_main;
import com.example.administrator.woocongress.R;
import com.example.administrator.woocongress.camera.CameraManager;
import com.example.administrator.woocongress.camera.PlanarYUVLuminanceSource;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

import java.util.Hashtable;

public final class DecodeHandler extends Handler {

  private static final String TAG = DecodeHandler.class.getSimpleName();

  private final Camera_main activity;
  private final MultiFormatReader multiFormatReader;
  private static DecodeHandler decodeHandler;

  DecodeHandler(Camera_main activity, Hashtable<DecodeHintType, Object> hints) {
	  decodeHandler = this;
    multiFormatReader = new MultiFormatReader();
    multiFormatReader.setHints(hints);
    this.activity = activity;
  }
  
  public static DecodeHandler getInstance(){
	  return decodeHandler;
  }

  @Override
  public void handleMessage(Message message) {
   
    if(message.what == R.id.decode){
    	 Log.d(TAG, "Got decode message");
        decode((byte[]) message.obj, message.arg1, message.arg2,false);
    }else if(message.what == R.id.quit){
    	 Looper.myLooper().quit();
    }
  }

  /**
   * Decode the data within the viewfinder rectangle, and time how long it took. For efficiency,
   * reuse the same reader objects from one decode to the next.
   *
   * @param data   The YUV preview frame.
   * @param width  The width of the preview frame.
   * @param height The height of the preview frame.
   * @param isFromALbum is data come from Album. �������������Ƿ��������
   */
  public void decode(byte[] data, int width, int height,boolean isFromALbum) {
    long start = System.currentTimeMillis();
    Result rawResult = null;
		if (!isFromALbum) {//�����ֱ��ɨ�裬ͼƬ�����������
			// ����
			byte[] rotatedData = new byte[data.length];
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++)
					rotatedData[x * height + height - y - 1] = data[x + y* width];
			}
			int tmp = width; // Here we are swapping, that's the difference to #11
			width = height;
			height = tmp;
			data = rotatedData;// ���ܹؼ���
			// --------------------
		}
//		Log.d("TAG", "decode:width--->"+width+"height--->"+height);
    PlanarYUVLuminanceSource source = CameraManager.get().buildLuminanceSource(data, width, height);
    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
    try {
      rawResult = multiFormatReader.decodeWithState(bitmap);
    } catch (ReaderException re) {
      // continue
    } finally {
      multiFormatReader.reset();
    }

    if (rawResult != null) {
      long end = System.currentTimeMillis();
      Log.d(TAG, "Found barcode (" + (end - start) + " ms):\n" + rawResult.toString());
      Message message = Message.obtain(activity.getHandler(), R.id.decode_succeeded, rawResult);
      Bundle bundle = new Bundle();
      bundle.putParcelable(DecodeThread.BARCODE_BITMAP, source.renderCroppedGreyscaleBitmap());
      message.setData(bundle); 
      //Log.d(TAG, "Sending decode succeeded message...");
      message.sendToTarget();
    } else {
    	Message message = new Message();
    	message.what = R.id.decode_failed;
    	activity.getHandler().sendMessage(message);
//      Message message = Message.obtain(activity.getHandler(), R.id.decode_failed);
//      message.sendToTarget();
    }
  }

}
