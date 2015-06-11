package com.trifork.android.tv.test.androidtvtest.custom;

import android.app.Activity;
import android.os.Bundle;

import com.trifork.android.tv.test.androidtvtest.R;

public class DeviceActivity extends Activity {

    public static final String DEVICE_EXTRA = "device";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
    }
}
