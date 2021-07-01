package com.example.bibleapp_v1;


import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyAdapter_fragment extends Fragment {
    private int frag_num;

    public static MyAdapter_fragment newinstance(int num){
        MyAdapter_fragment fragment = new MyAdapter_fragment();
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
        View view = inflater.inflate(R.layout.message_sender_text_veiwpager,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //asset 파일에서 데이터 가져오기
        AssetManager am = getResources().getAssets();
        InputStream is = null;


        try {
            is = am.open("test4.txt");

            BufferedReader bufrd = new BufferedReader(new InputStreamReader(is));

            String line = "";
            boolean out_check = false;
            while((line = bufrd.readLine()) != null){
                String[] line_check = {"창", "1"};
                if( Character.isDigit(line.charAt(1)) ){
                    String tmp_line_check = line.substring(0, line.indexOf(":"));
                    line_check[0] = tmp_line_check.substring(0,1);
                    line_check[1] = tmp_line_check.substring(1);
                }else {
                    String tmp_line_check = line.substring(0, line.indexOf(":"));
                    line_check[0] = tmp_line_check.substring(0,2);
                    line_check[1] = tmp_line_check.substring(2);
                }
                if(MainActivity.bibleParagraph[0].equals(line_check[0]) && MainActivity.bibleParagraph[1].equals(line_check[1])){
                    out_check = true;
                    //각각의 textview를 생성해 가져온 한줄의 성경데이터를 주입
                    LinearLayout container = (LinearLayout) view.findViewById(R.id.m_s_t_v_linearlayout);
                    //TextView 생성
                    TextView textV = new TextView(view.getContext());
                    textV.setText(line);
                    textV.setTextSize(20);
                    textV.setTextColor(Color.BLACK);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.gravity = Gravity.LEFT;
                    textV.setLayoutParams(lp);
                    //뷰 추가
                    container.addView(textV);
                    final String fLine = line;
                    textV.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MainActivity.messageToSend = fLine;
                            Intent intent = new Intent(v.getContext(), MessageSender_send.class);
                            startActivity(intent);
                        }
                    });
                }else if(out_check){
                    break;
                }
            }
            //장수 올리기
            MainActivity.bibleParagraph[1] = Integer.toString(Integer.parseInt(MainActivity.bibleParagraph[1])+1);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}