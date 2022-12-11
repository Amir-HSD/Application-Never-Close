package com.example.myapplication589;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.widget.Toast;

public class MyService extends Service {

    @Override
    public void onDestroy() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.myapplication589");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else{
            Toast.makeText(getApplicationContext(),"ریدم :) تو برنده شدی و برنامه بسته شد",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        BroadcastReceiver mReceiver;
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_BOOT_COMPLETED);
        mReceiver = new BootCompleteReceiver();
        registerReceiver(mReceiver, intentFilter);
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}