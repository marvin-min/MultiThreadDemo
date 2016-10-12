package com.jarorwar.demo.multi.multithreaddemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final int UPDATE_TEXT = 1;
    private Button changeButton;
    private TextView welcomeText;

    private ProgressBar mProgressBar;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d("TTT","get....."+msg.what);
            switch (msg.what) {
                case UPDATE_TEXT:
                    welcomeText.setText("~你好~");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText = (TextView) findViewById(R.id.welcome_message);
        changeButton = (Button) findViewById(R.id.change_text_btn);
        mProgressBar = (ProgressBar) findViewById(R.id.loading_button);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask<Void, Integer, Boolean> asyncTask = getAsyncTask();
                asyncTask.execute();
            }
        });

    }

    private AsyncTask<Void, Integer, Boolean> getAsyncTask() {
        return new AsyncTask<Void, Integer, Boolean>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                welcomeText.setText("");
                mProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                mProgressBar.setVisibility(View.INVISIBLE);
                welcomeText.setText("来自远方的问候~你好~");
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                mProgressBar.setProgress(values[0]);
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    for (int i = 0; i <= 100 ; i++) {
                        Thread.sleep(200);
                        publishProgress(i);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }
        };
    }
    private void startThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = UPDATE_TEXT;
                Log.d("TTT","sending.....");
                mHandler.sendMessage(message);
            }
        }).start();
    }
}
