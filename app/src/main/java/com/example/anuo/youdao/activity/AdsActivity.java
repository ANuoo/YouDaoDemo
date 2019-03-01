package com.example.anuo.youdao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.anuo.youdao.R;
import com.example.anuo.youdao.activity.MainActivity;

public class AdsActivity extends AppCompatActivity {
    private Activity activity;
    private TextView textView;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        activity = this;
        textView = (TextView) findViewById(R.id.txt_ads);
        countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("跳过广告" + (millisUntilFinished / 1000) + "秒");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(activity, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }.start();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                Intent intent = new Intent(activity, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
