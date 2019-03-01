package com.example.anuo.youdao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuo.youdao.R;
import com.example.anuo.youdao.activity.NotFindActivity;
import com.example.anuo.youdao.activity.SearchActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class FragmentTranslate extends Fragment {
    @Nullable

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_translate, container, false);
        Window window = getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getActivity().getResources().getColor(R.color.colorStateBar));
        ImageView imageClear = (ImageView) view.findViewById(R.id.img_translate_clear);
        final ImageView imageView = (ImageView) view.findViewById(R.id.img_translate_search);
        final EditText editText = (EditText) view.findViewById(R.id.edt_translate_text);
        final TextView textView = (TextView) view.findViewById(R.id.txt_translate_result);
        imageClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(null);
                textView.setText(null);

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestByPost(editText.getText().toString());
            }
        });
        initView(view);
        return view;
    }

    private void initView(View view) {
    }

    private void requestByPost(final String pass) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://fanyi.youdao.com/translate");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.setConnectTimeout(5000);
                    connection.setDoInput(true);
                    connection.setReadTimeout(5000);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);
                    connection.connect();
                    OutputStream outPutStream = connection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outPutStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    bufferedWriter.write("doctype=json&jsonversion=&type=EN2ZH_CN&network=4g&i=" + pass);
                    bufferedWriter.flush();

                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    String dataBack;
                    while (true) {
                        if ((dataBack = bufferedReader.readLine()) != null) {
                            initResult(dataBack, pass);
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    private void initResult(final String dataBack, final String pass) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                JSONObject mJSONObject;
                {
                    try {
                        mJSONObject = new JSONObject(dataBack);
                        if (mJSONObject.getString("errorCode").equals("0")) {
                            JSONArray array = mJSONObject.getJSONArray("translateResult");
                            for (int i = 0; i < array.length(); i++) {
                                JSONArray array1 = array.getJSONArray(i);
                                JSONObject object1 = array1.getJSONObject(i);
                                if (object1.getString("src").equals(pass)) {
                                    String result = object1.getString("tgt");
                                    initShow(result);
                                }
                            }


                        } else {
                            Toast.makeText(getActivity(), "网络不给力哦", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void initShow(String result) {
        TextView textView = (TextView) getActivity().findViewById(R.id.txt_translate_result);
        String mark = "译文: ";
        textView.setText(mark + result);
    }

}


