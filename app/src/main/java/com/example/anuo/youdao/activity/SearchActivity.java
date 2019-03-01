package com.example.anuo.youdao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.R;
import com.example.anuo.youdao.fragment.FragmentAssociate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SearchActivity extends AppCompatActivity {
    private Context context;
    private String[] word = new String[10];
    private String[] explain = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorBackgroundSearch));
        initClick();
    }


    private void initClick() {
        final EditText editText = (EditText) findViewById(R.id.edt_search);
        final ImageView imageBack = (ImageView) findViewById(R.id.img_search_back);
        final ImageView imageClear = (ImageView) findViewById(R.id.but_search_clear);
        ImageView imageSearch = (ImageView) findViewById(R.id.img_search_black);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        imageClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(null);
            }
        });
        imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("") && editText.getText() != null) {
                    sendRequestWithHttpURLConnection(editText.getText().toString());
                }

            }
        });
    }

    private void sendRequestWithHttpURLConnection(final String data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://dict.youdao.com/suggest?le=eng&num=10000&doctype=json&q=" + data);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder databack = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        databack.append(line);
                    }
                    AboutResult(databack.toString(), data);

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

    private void AboutResult(final String databack, final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                JSONObject mJSONObject;
                {
                    try {
                        mJSONObject = new JSONObject(databack);
                        JSONObject json = mJSONObject.getJSONObject("result");
                        Log.d("SearchActivity", databack);
                        FragmentAssociate associate = new FragmentAssociate();
                        if (json.get("msg").toString().equals("not found")) {
                            Log.d("SearchActivity", databack + 1);
                            Intent intent = new Intent(SearchActivity.this, NotFindActivity.class);
                            intent.putExtra("notFind", data);
                            startActivity(intent);
                        } else {
                            JSONObject jsonObject = mJSONObject.getJSONObject("data");
                            JSONArray jsonArray = jsonObject.getJSONArray("entries");
                            if (jsonObject.get("query").toString().equals(data)) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    if (object.get("entry").toString().equals(data)) {
                                        String word = object.get("entry").toString();
                                        String explain = object.get("explain").toString();
                                        Bundle bundle = new Bundle();
                                        bundle.putString("word", word);
                                        bundle.putString("explain", explain);
                                        associate.setArguments(bundle);
                                        FragmentManager fragmentManager = getSupportFragmentManager();
                                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                        fragmentTransaction.replace(R.id.frame_search, associate);
                                        fragmentTransaction.commit();
                                    }
                                }


                            }
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

