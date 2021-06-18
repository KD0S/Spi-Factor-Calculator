package com.example.spider_appdev_task_1;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class practiceactivity extends MainActivity {
    double velocity;
    double calcFactor;
    double lorentzFactor;
    double c = 300000000;
    TextView value;
    View view;
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practiceactivity);
        Button backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(view -> finish());
        EditText inputVelocity = findViewById(R.id.inputv);
        EditText inputLorentz = findViewById(R.id.inputgamma);
        value = findViewById(R.id.correct);
        view = findViewById(R.id.pracAct);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        Button check = findViewById(R.id.CheckBtn);
        check.setOnClickListener(v -> {
            try {
                String pracVelocity = inputVelocity.getText().toString();
                velocity = Double.parseDouble(pracVelocity);
                String pracGamma = inputLorentz.getText().toString();
                calcFactor = Double.parseDouble(pracGamma);
                ChkLorentzFactor(velocity,calcFactor);
            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void ChkLorentzFactor(double velocity,double calcFactor) {
        if (velocity>c) {
            Toast.makeText(getApplicationContext(), "Velocity Should be less than c", Toast.LENGTH_SHORT).show();
        }
        else {
            lorentzFactor = (1 / Math.sqrt(1 - (Math.pow(velocity / c, 2))));
            if(calcFactor == lorentzFactor){
                Toast.makeText(getApplicationContext(), "Correct Value", Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
            }
            else {
                Toast.makeText(getApplicationContext(), "Incorrect Value", Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                vibrator.vibrate(500);


            }
               value.setText(String.valueOf(lorentzFactor));

        }
    }
}