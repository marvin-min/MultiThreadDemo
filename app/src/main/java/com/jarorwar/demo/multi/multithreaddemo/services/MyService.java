package com.jarorwar.demo.multi.multithreaddemo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by marvinmin on 10/12/16.
 */

public class MyService extends Service {
    public static final String MY_SERVICE_TAG = "MyService";

    private DownloadBinder mDownloadBinder = new DownloadBinder();
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(MY_SERVICE_TAG, "onBind: ====");
        return mDownloadBinder;
    }

    @Override
    public void onCreate() {
        Log.d(MY_SERVICE_TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(MY_SERVICE_TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(MY_SERVICE_TAG, "onDestroy: ");
        super.onDestroy();
    }


    public class DownloadBinder extends Binder {
        public static final String TAG ="DownloadBinder";
        public void startDownload(){
            Log.d(TAG, "startDownload: ");
        }

        public int getProgress(){
            Log.d(TAG, "getProgress: ");
            return 0;
        }
    }
}
