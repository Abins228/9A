package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton bt, sb;
    DBServer dbServer;
    // DBServer.Products products;
    private final static int GET_PERMISSION_STORAGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.catalogbutton);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        GET_PERMISSION_STORAGE);
            }
        }


//        bt.setOnClickListener(new View.OnClickListener() {
//            int height, width;
//            @Override
//            public void onClick(final View v) {
//                v.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        height = v.getHeight();
//                        width = v.getWidth();
//                    }
//                });
//                // дальше код
//            }
//        });
//
    }



    public void onClickSborka(View view) {
        Intent s;
        s = new Intent(MainActivity.this, BuildActivity.class);
        startActivity(s);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == GET_PERMISSION_STORAGE) {
            boolean permissionGranted = true; //все разрешения
            //проверка всех разрешений
            for (int curRes : grantResults)
                if (curRes == PackageManager.PERMISSION_DENIED) {
                    permissionGranted = false;
                    break;
                }
            if (permissionGranted &&
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                    checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Log.i("PermissionStorage", "Все разрешения получены");
            }
        }

    }

    @Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(MainActivity.this, CatalogActivity.class);
        startActivity(i);
    }
}