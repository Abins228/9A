package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class MarketActivity extends AppCompatActivity {

    DBServer dbServer;
    ListView list;
    ListAdapter listAdapter;
    Selectable table;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_activity);

        dbServer = new DBServer(this);

        list = findViewById(R.id.listView);

        if (getIntent().hasExtra("MotherBoard")) {
            int value = getIntent().getIntExtra("MotherBoard", 1);
            if (value == BuildActivity.MOTHERBOARD) {
                Toast.makeText(getApplicationContext(), "материнки", Toast.LENGTH_SHORT).show();
                table = dbServer.new MotherboardsTable();
                listAdapter = new ListAdapter<Motherboards>(this, table.selectAll());
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
                table = dbServer.new BPTable();
                listAdapter = new ListAdapter<BP>(this, table.selectAll());
            }
        }
        if (getIntent().hasExtra("BODY")) {
            int value = getIntent().getIntExtra("BODY", 11);
            if (value == BuildActivity.BODY) {
                Toast.makeText(getApplicationContext(), "корпуса", Toast.LENGTH_SHORT).show();
            }


        }
        list.setAdapter(listAdapter);

    }


    public class ListAdapter<T extends Idetificate> extends BaseAdapter {
        LayoutInflater inflater;
        ArrayList<T> data;

        public ListAdapter(Context context, ArrayList<T> data) {
            inflater = LayoutInflater.from(context);
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            T ob = data.get(position);
            if (ob != null) {
                return ob.getId();
            }
            return -1;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = getLayoutInflater().inflate(R.layout.item, null);

//            ImageView image = convertView.findViewById(R.id.image);
            TextView name = convertView.findViewById(R.id.name);
            TextView description = convertView.findViewById(R.id.description);
            TextView price = convertView.findViewById(R.id.price);

            T preview = (T) getItem(position);

//            ByteArrayInputStream imageStream = new ByteArrayInputStream(preview.getImage());
////            Bitmap theImage = BitmapFactory.decodeStream(imageStream);
//////            image.setImageBitmap(theImage);
            name.setText(preview.getName());
            description.setText("Краткое описание: " + preview.getDescription());
            price.setText("Цена: " + preview.getPrice() + " ₽");

            return convertView;
        }
    }
}


