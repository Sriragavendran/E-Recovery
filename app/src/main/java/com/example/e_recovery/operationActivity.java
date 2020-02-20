package com.example.e_recovery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.time.Instant;

public class operationActivity extends AppCompatActivity {
    private Button vehicle, patientData, emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        vehicle = (Button) findViewById(R.id.vehicle);
        patientData = (Button) findViewById(R.id.pdata);
        emergency = (Button) findViewById(R.id.emergency);
        vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(operationActivity.this, vehicleActivity.class));
            }
        });
        patientData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(operationActivity.this, patientActivity.class));
            }
        });
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("9786285478", null, "", null, null);
            }
        });

    }
}
