package com.example.e_recovery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class patientActivity extends AppCompatActivity {
    private EditText patientName, problem;
    private Button save;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        patientName = (EditText) findViewById(R.id.name);
        problem = (EditText) findViewById(R.id.vehicleNumber);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = "Name :" + patientName.getText().toString().trim() + "Vehicle Number :" + problem.getText().toString().trim();
                try {
                    FileOutputStream fos = new FileOutputStream(file);

                    // fos=openFileOutput(filename, Context.MODE_APPEND);
                    fos.write(data.getBytes());
                    fos.close();
                    // Toast.makeText(this,"Please enter valid details",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}
