package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Catalog_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageButton bt;
    static final int MOTHERBOARD = 1;
    static final int PROCES = 2;
    static final int COOLERS = 3;
    static final int GPU = 4;
    static final int RAM = 5;
    static final int HDD = 6;
    static final int SSD = 7;
    static final int M2 = 8;
    static final int CPUCOOLER = 9;
    static final int BP = 10;
    static final int BODY = 11;

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
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("MotherBoard",MOTHERBOARD);
        startActivity(s);
    }

    public void onClickProcessor(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("Central processor",PROCES);
        startActivity(s);
    }

    public void onClickCpuCooler(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this,MarketActivity .class);
        s.putExtra("CPUCOOLER",CPUCOOLER);
        startActivity(s);
    }

    public void onClickGpu(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("Graphics card",GPU);
        startActivity(s);
    }

    public void onClickRam(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("Ram",RAM);
        startActivity(s);
    }

    public void onClickHdd(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("HDD",HDD);
        startActivity(s);
    }

    public void onClickSsd(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("SSD",SSD);
        startActivity(s);
    }

    public void onClickM2(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("M2",M2);
        startActivity(s);
    }

    public void onClickCooler(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("Cooler",COOLERS);
        startActivity(s);
    }

    public void onClickBp(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("BP",BP);
        startActivity(s);

    }

    public void onClickBody(View view) {
        Intent s;
        s = new Intent(Catalog_Activity.this, MarketActivity.class);
        s.putExtra("BODY",BODY);
        startActivity(s);
    }



}