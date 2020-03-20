package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.catalogbutton);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        i = new Intent(MainActivity.this, Catalog_Activity.class);
        startActivity(i);
    }
    public void onClickSborka(View view) {
        Intent s;
        s = new Intent(MainActivity.this, BuildActivity.class);
        startActivity(s);
    }
}