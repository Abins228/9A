package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class sborka_activity extends AppCompatActivity implements View.OnClickListener {
    ImageButton bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sborka_activity);
        bt = findViewById(R.id.back2);
        bt.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent s;
        s = new Intent(sborka_activity.this, MainActivity.class);
        startActivity(s);
    }
}
