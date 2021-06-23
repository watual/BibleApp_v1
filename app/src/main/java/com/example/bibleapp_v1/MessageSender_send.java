package com.example.bibleapp_v1;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MessageSender_send extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_sender_send);

        Button but_send = (Button) findViewById(R.id.sendMessage);
        EditText text_message = (EditText) findViewById(R.id.text_message);
        EditText text_number = (EditText) findViewById(R.id.text_number);

        but_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = text_number.getText().toString();
                String sms = text_message.getText().toString();
                Toast.makeText(getApplicationContext(), phoneNo+sms, Toast.LENGTH_SHORT).show();

                try {
                    SmsManager mSmsManager = SmsManager.getDefault();
                    mSmsManager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "전송완료", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                    e.toString();
                    TextView er = findViewById(R.id.errorText);
                    er.setText(e.toString());
                }
            }
        });

    }
}
