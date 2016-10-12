package com.jarorwar.demo.multi.multithreaddemo.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.jarorwar.demo.multi.multithreaddemo.MainActivity;
import com.jarorwar.demo.multi.multithreaddemo.R;

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


        long[] vars = {0, 1000, 0, 10000};
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new Notification.Builder(this).setContentText("看啦看啦")
                .setContentTitle("一朵花儿开呀开")
                .setTicker("大美无疆,干净桌面图片")
                .setSmallIcon(R.drawable.bee)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setVibrate(vars)
                .setLights(Color.RED, 1000, 1000)
                .build();

        startForeground(1, notification);

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
