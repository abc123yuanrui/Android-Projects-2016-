package com.example.administrator.drawviewforu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/2 0002.
 */

public class DrawView extends View {
    private int view_width = 0;
    private int view_height = 0;
    private float preX;
    private float preY;
    private Path path;
    public Paint paint = null;
    Bitmap cacheBitmap = null;
    Canvas cacheCanvas = null;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.view_width = context.getResources().getDisplayMetrics().widthPixels;
        this.view_height = context.getResources().getDisplayMetrics().heightPixels;
        System.out.println(this.view_width + "*" + this.view_height);
        this.cacheBitmap = Bitmap.createBitmap(this.view_width, this.view_height, Bitmap.Config.ARGB_8888);
        this.cacheCanvas = new Canvas();
        this.path = new Path();
        this.cacheCanvas.setBitmap(this.cacheBitmap);
        this.paint = new Paint(Paint.DITHER_FLAG);
        this.paint.setColor(Color.RED);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeJoin(Paint.Join.ROUND);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setStrokeWidth(1);
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0xFFFFFFFF);
        Paint bmpPaint = new Paint();
        canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
        canvas.drawPath(path, paint);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event, findxy findx) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - preX);
                float dy = Math.abs(y - preY);
                if (dx >= 5 || dy >= 5) {
                    path.quadTo(preX, preY, (x + preX) / 2, (y + preY) / 2);
                    preX = x;
                    preY = y;
                    findx.setX(x);
                    findx.setY(y);

                }
                break;
            case MotionEvent.ACTION_UP:
                cacheCanvas.drawPath(path, paint);
                path.reset();
                break;
        }
        invalidate();
        return true;
    }

    public void clear() {
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setStrokeWidth(50);
    }

    public void save() {
        try {
            saveBitmap("myPicture");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveBitmap(String fileName) throws IOException {
        File file = new File("/sdcard/pictures/" + fileName + ".png");
        file.createNewFile();
        FileOutputStream fileOS = new FileOutputStream(file);
        cacheBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOS);
        fileOS.flush();
        fileOS.close();
    }

    public void clearall() {

        path.close();

    }
}
