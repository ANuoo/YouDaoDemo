package com.example.anuo.youdao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anuo.youdao.R;
import com.example.anuo.youdao.activity.WordActivity;

public class FragmentAssociate extends Fragment  {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.search_recycleview_associate_item, container, false);
            Bundle bundle = this.getArguments();

            TextView textWord = (TextView)view.findViewById(R.id.txt_search_associate_enter);
            TextView textExplain = (TextView)view.findViewById(R.id.txt_search_associate_explain);
            final String data = bundle.getString("word");
            textWord.setText(data);
            textExplain.setText(bundle.getString("explain"));
            textWord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),WordActivity.class);
                    intent.putExtra("data",data);
                    startActivity(intent);
                }
            });
            textExplain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),WordActivity.class);
                    intent.putExtra("data",data);
                    startActivity(intent);
                }
            });
            }

        return view;
    }

}
