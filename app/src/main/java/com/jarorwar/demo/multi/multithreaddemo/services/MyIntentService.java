package com.jarorwar.demo.multi.multithreaddemo.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by marvinmin on 10/12/16.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super(MyIntentService.class.getName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "onDestroy: ");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MyIntentService", "onHandleIntent: " + Thread.currentThread().getName());
    }
}
