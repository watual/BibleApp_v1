package com.example.bibleapp_v1;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class MessageSender_text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_sender_text);


        AssetManager am = getResources().getAssets();
        InputStream is = null;
        byte buf[] = new byte[1024];
        String text = "";

        try {
            is = am.open("test1.txt");
            if(is.read(buf) > 0){
                text = new String(buf);
            }

            TextView b1 = (TextView)findViewById(R.id.b1);
            b1.setText(text);

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
