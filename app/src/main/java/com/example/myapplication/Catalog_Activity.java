package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Catalog_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageButton bt;
    Button motherbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        bt = findViewById(R.id.back);
        bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;
        i = new Intent(Catalog_Activity.this, MainActivity.class);
        startActivity(i);
    }

    public void onClickMotherBoard(View view) {
        Intent m;
        m = new Intent(Catalog_Activity.this, MarketActivity.class);
        startActivity(m);
    }
}