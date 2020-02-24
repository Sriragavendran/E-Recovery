package com.example.e_recovery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class operationActivity extends AppCompatActivity {
    private Button vehicle, patientData, emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        vehicle = findViewById(R.id.vehicle);
        patientData = findViewById(R.id.pdata);
        emergency = findViewById(R.id.emergency);
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
                sendEmail();
            }
        });

    }

    private void sendEmail() {
        String[] To = {"ssrivishnu80@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, To);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Emergency");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");


        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(operationActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
