package com.example.smsapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText phoneBox, messageBox;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneBox = findViewById(R.id.editText1);
        messageBox = findViewById(R.id.editText2);
        sendBtn = findViewById(R.id.button);

        sendBtn.setOnClickListener(v -> {
            String phoneNo = phoneBox.getText().toString();
            String message = messageBox.getText().toString();

            Uri uri = Uri.parse("smsto:" + phoneNo);

            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra("sms_body", message);
            startActivity(intent);
        });
    }
}