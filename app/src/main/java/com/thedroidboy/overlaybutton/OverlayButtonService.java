package com.thedroidboy.overlaybutton;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by yaakov shahak on 03/11/2015.
 */
public class OverlayButtonService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PRIORITY_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        layoutParams.gravity = Gravity.TOP | Gravity.START;
        layoutParams.x = 50;
        layoutParams.y = 50;
        @SuppressLint("InflateParams")
        View btn = ((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.button, null);
        final WindowManager windowManager = ((WindowManager) getSystemService(WINDOW_SERVICE));
        windowManager.addView(btn, layoutParams);
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //here you can do whatever action you want after click
                close(v);
                return false;
            }
        });

    }


    public void close(View view){
        try {
            final WindowManager windowManager = ((WindowManager) getSystemService(WINDOW_SERVICE));
            windowManager.removeView(view);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            stopSelf();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
