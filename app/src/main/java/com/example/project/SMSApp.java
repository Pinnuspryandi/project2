package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class SMSApp extends AppCompatActivity {

    EditText sendTo,message,verified;
    Button sendBtn, sendVerified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsapp);

        sendTo = findViewById(R.id.sendTo);
        message= findViewById(R.id.msg);
        sendBtn = findViewById(R.id.sendBtn);
        verified = findViewById(R.id.verified);
        final String confirmationcode;

        sendVerified = findViewById(R.id.sendVerified);
        int sendSMSPermission =
                ContextCompat.checkSelfPermission(
                        this, Manifest.permission.SEND_SMS
                );
        Random rand = new Random();
        int n = rand.nextInt(1000000);
        confirmationcode = n+"";
        //Check permission

        if (sendSMSPermission != PackageManager.PERMISSION_GRANTED){
            //Request Permission Lagi
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        }

        int phoneState=ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_PHONE_STATE
        );
            if (phoneState != PackageManager.PERMISSION_GRANTED){
                //Request Permission Lagi
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},2);
            }


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = sendTo.getText().toString();
                String msg = message.getText().toString();
                SmsManager smsManager = SmsManager.getDefault();

                smsManager.sendTextMessage(address,null,confirmationcode,null,null);
            }
        });


        sendVerified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = verified.getText().toString();
                if(message.equals(confirmationcode)){
                    Toast.makeText(SMSApp.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);


                } else{
                    Toast.makeText(SMSApp.this, "Confirmation Code is Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
