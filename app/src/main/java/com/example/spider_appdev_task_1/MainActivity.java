package com.example.spider_appdev_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    double velocity;
    double lorentzFactor;
    double c = 300000000;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        EditText input = findViewById(R.id.input);
        Button calcLorentz = findViewById(R.id.calculateBtn);
        Button practiceButton = findViewById(R.id.pracBtn);
        practiceButton.setOnClickListener(v -> {
            switchActivities();
        });
        calcLorentz.setOnClickListener(v -> {
            try {
                String inputVelocity = input.getText().toString();
                velocity = Double.parseDouble(inputVelocity);
                CalcLorentzFactor(velocity);
            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void CalcLorentzFactor(double velocity) {
        if (velocity>c) {
            Toast.makeText(getApplicationContext(), "Velocity Should be less than c", Toast.LENGTH_SHORT).show();
        }
        else {
            lorentzFactor = (1 / Math.sqrt(1 - (Math.pow(velocity / c, 2))));
            result.setText(String.valueOf(lorentzFactor));
        }
    }
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, practiceactivity.class);
        startActivity(switchActivityIntent);
    }
}
