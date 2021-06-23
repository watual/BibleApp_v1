package com.example.bibleapp_v1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MessageSender extends AppCompatActivity {

    private Button test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_sender);

        test1 = findViewById(R.id.창세기);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageSender.this , MessageSender_text.class);
                startActivity(intent);
            }
        });

    }
}
