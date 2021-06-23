package com.example.bibleapp_v1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MessageSender_text extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_sender_text);

        File file = new File("/개역개정판성경.txt");
    }
}
