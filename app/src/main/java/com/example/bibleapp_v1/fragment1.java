package com.example.bibleapp_v1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class fragment1 extends Fragment {
    TextView data1;
    private int frag_num;
    LinearLayout ly;

    public static fragment1 newinstance(int num){
        fragment1 fragment = new fragment1();
        Bundle args = new Bundle();
        args.putInt("num",num);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        frag_num = getArguments().getInt("num",0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ly = view.findViewById(R.id.test_linearLayout);
        for(int i=0;i<20;i++){
            TextView text = new TextView(view.getContext());
            text.setText("이게 되나요");
            text.setTextSize(30);
            ly.addView(text);
        }

    }
}