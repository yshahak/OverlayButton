package com.thedroidboy.overlaybutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yaakov shahak on 03/11/2015.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, OverlayButtonService.class));
        finish();
    }
}
