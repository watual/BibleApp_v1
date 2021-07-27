package com.example.bibleapp_v1;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MessageSender extends AppCompatActivity {

    private Button test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_sender);

        LinearLayout ll = (LinearLayout) findViewById(R.id.message_sender_scrollView);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        for(int i=0;i<MainActivity.bibleList.length;i++){
            Button button_n = new Button(this);
            button_n.setId(i+1);
            button_n.setText(MainActivity.bibleList[i]);
            button_n.setTextSize(40);
            button_n.setLayoutParams(params);

            int finalI = i;
            button_n.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.bibleParagraph[0] = MainActivity.bibleList[finalI];
                    Intent intent = new Intent(MessageSender.this , MessageSender_text.class);
                    startActivity(intent);
                }
            });

            ll.addView(button_n);
        }

    }

    public int getDPI(int dp){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float)dp, getResources().getDisplayMetrics());
    }
}
