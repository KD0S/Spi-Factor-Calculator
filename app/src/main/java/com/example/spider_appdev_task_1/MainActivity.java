package com.example.spider_appdev_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;


import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        ImageButton spiFactorBtn = findViewById(R.id.SpiBtn);
        ImageButton lorentzFactorBtn = findViewById(R.id.LorentzBtn);
        spiFactorBtn.setOnClickListener(v -> switchActivities2());
        lorentzFactorBtn.setOnClickListener(v -> switchActivities1());
    }

    private void switchActivities1() {
        Intent switchActivityIntent = new Intent(this, LorentzFactorCalculator.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivities2() {
        Intent switchActivityIntent = new Intent(this, SpifactorCalculator.class);
        startActivity(switchActivityIntent);
    }
}
