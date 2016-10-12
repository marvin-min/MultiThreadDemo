package com.jarorwar.demo.multi.multithreaddemo.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by marvinmin on 10/12/16.
 */
public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmReceiver", "onReceive: ");
        Intent i = new Intent(context,LongTimeRunningService.class);
        context.startService(i);
    }
}
