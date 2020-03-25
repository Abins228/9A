package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MarketActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_activity);
        if (getIntent().hasExtra("MotherBoard")) {
            int value = getIntent().getIntExtra("MotherBoard", 1);
            if (value == BuildActivity.MOTHERBOARD) {
                Toast.makeText(getApplicationContext(), "материнки", Toast.LENGTH_LONG).show();
            } else if (value == BuildActivity.PROCES) {
                    Toast.makeText(getApplicationContext(), "Процы", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

