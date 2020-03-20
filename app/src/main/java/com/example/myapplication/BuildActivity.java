package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BuildActivity extends AppCompatActivity implements View.OnClickListener {
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
        setContentView(R.layout.build_activity);
        bt = findViewById(R.id.back2);
        bt.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MainActivity.class);
        startActivity(s);
    }

    public void onClickM(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("MotherBoard",MOTHERBOARD);
        startActivity(s);
    }

    public void onClickP(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("Central processor",PROCES);
        startActivity(s);
    }

    public void onClickC(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("Cooler",COOLERS);
        startActivity(s);
    }

    public void onClickG(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("Graphics card",GPU);
        startActivity(s);
    }

    public void onClickR(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("Ram",RAM);
        startActivity(s);
    }

    public void onClickH(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("HDD",HDD);
        startActivity(s);
    }

    public void onClickS(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("SSD",SSD);
        startActivity(s);
    }
    public void onClickM2(View view) {//
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("M2",M2);
        startActivity(s);
    }

    public void onClickCPUCOOL(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("CPUCOOLER",CPUCOOLER);
        startActivity(s);
    }

    public void onClickB(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("BP",BP);
        startActivity(s);
    }

    public void onClickBo(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("BODY",BODY);
        startActivity(s);
    }

}
