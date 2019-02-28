package com.example.anuo.youdao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuo.youdao.R;
import com.example.anuo.youdao.activity.MainActivity;
import com.example.anuo.youdao.activity.NotFindActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        sendRequestWithHttpURLConnection(data);

    }

    private void sendRequestWithHttpURLConnection(final String data){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://dict.youdao.com/jsonapi?jsonversion=2&client=mobile&network=4g&q="+data);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder dataBack = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        dataBack.append(line);
                    }
                    AboutResult(dataBack.toString(),data);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void AboutResult(final String dataBack,final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                JSONObject mJSONObject;
                {
                    try {
                        mJSONObject = new JSONObject(dataBack);
                        JSONObject object = mJSONObject.getJSONObject("simple");
                        Log.d("WordActivity",dataBack);
                        if(object.get("query").toString().equals(data)){
                            JSONArray array = object.getJSONArray("word");
                            for(int i = 0;i<array.length();i++){
                                JSONObject object1 = array.getJSONObject(i);
                                String britain = object1.get("ukphone").toString();
                                String american = object1.getString("usphone");
                                initView(britain,american,data);
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void initView(String britain,String american,String data){
        TextView textData = (TextView)findViewById(R.id.txt_word_result);
        TextView textBritain = (TextView)findViewById(R.id.txt_word_pronunciation_britain);
        TextView textAmerican = (TextView)findViewById(R.id.txt_word_pronunciation_american);
        textBritain.setText(britain);
        textAmerican.setText(american);
        textData.setText(data);
    }

}
