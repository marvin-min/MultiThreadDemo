package com.jarorwar.demo.multi.multithreaddemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final int UPDATE_TEXT = 1;
    private Button changeButton;
    private TextView welcomeText;

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

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

    }
}
