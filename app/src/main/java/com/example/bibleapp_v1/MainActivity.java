package com.example.bibleapp_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_messageSender;

    String[] REQUIRED_PERMISSIONS = {Manifest.permission.SEND_SMS};
    private static final int PERMISSIONS_REQUEST_CODE = 100;

    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_messageSender = findViewById(R.id.messageSender);
        btn_messageSender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , MessageSender.class);
                startActivity(intent);
            }
        });

        int check_permission_sendSns = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(check_permission_sendSns != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(), "권한 허용안됨", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE);
        }
    }
}