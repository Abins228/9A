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
                Toast.makeText(getApplicationContext(), "материнки", Toast.LENGTH_SHORT).show();
            }
       }
        if (getIntent().hasExtra("Central processor")) {
            int value = getIntent().getIntExtra("Central processor", 2);
            if (value == BuildActivity.PROCES) {
                Toast.makeText(getApplicationContext(), "Процы", Toast.LENGTH_SHORT).show();
            }
        }
        if (getIntent().hasExtra("Cooler")) {
            int value = getIntent().getIntExtra("Cooler", 3);
            if (value == BuildActivity.COOLERS) {
                Toast.makeText(getApplicationContext(), "кулера", Toast.LENGTH_SHORT).show();
            }
        }
        if (getIntent().hasExtra("Graphics card")) {
            int value = getIntent().getIntExtra("Graphics card", 4);
            if (value == BuildActivity.GPU) {
                Toast.makeText(getApplicationContext(), "видюхи", Toast.LENGTH_SHORT).show();
            }
        }
        if (getIntent().hasExtra("Ram")) {
            int value = getIntent().getIntExtra("Ram", 5);
            if (value == BuildActivity.RAM) {
                Toast.makeText(getApplicationContext(), "память", Toast.LENGTH_SHORT).show();
            }
        }
        if (getIntent().hasExtra("HDD")) {
            int value = getIntent().getIntExtra("HDD", 6);
            if (value == BuildActivity.HDD) {
                Toast.makeText(getApplicationContext(), "жесткие", Toast.LENGTH_SHORT).show();
            }
        }
        if (getIntent().hasExtra("SSD")) {
            int value = getIntent().getIntExtra("SSD", 7);
            if (value == BuildActivity.SSD) {
                Toast.makeText(getApplicationContext(), "SSD", Toast.LENGTH_SHORT).show();
            }
        }
        if (getIntent().hasExtra("M2")) {
            int value = getIntent().getIntExtra("M2", 8);
            if (value == BuildActivity.M2) {
                Toast.makeText(getApplicationContext(), "M2", Toast.LENGTH_SHORT).show();
            }
        }
        if (getIntent().hasExtra("CPUCOOLER")) {
            int value = getIntent().getIntExtra("CPUCOOLER", 9);
            if (value == BuildActivity.CPUCOOLER) {
                Toast.makeText(getApplicationContext(), "кулер проца", Toast.LENGTH_SHORT).show();
            }
        }
        if (getIntent().hasExtra("BP")) {
            int value = getIntent().getIntExtra("BP", 10);
            if (value == BuildActivity.BP) {
                Toast.makeText(getApplicationContext(), "блоки питания", Toast.LENGTH_SHORT).show();
            }
        }
        if (getIntent().hasExtra("BODY")) {
            int value = getIntent().getIntExtra("BODY", 11);
            if (value == BuildActivity.BODY) {
                Toast.makeText(getApplicationContext(), "корпуса", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


