package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton bt;
    DBServer dbServer;
    DBServer.Products products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.catalogbutton);
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