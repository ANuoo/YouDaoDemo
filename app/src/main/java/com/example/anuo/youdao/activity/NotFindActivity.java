package com.example.anuo.youdao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuo.youdao.R;

public class NotFindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_find);
        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.txt_not_find);
        textView.setText(intent.getStringExtra("notFind"));
        Toast.makeText(NotFindActivity.this,"没有找到这个单词哦",Toast.LENGTH_LONG).show();
    }
}