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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class MarketActivity extends AppCompatActivity {

    DBServer dbServer;
    ListView list;
    ListAdapter listAdapter;
    Selectable table;
    TextView namemarket;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_activity);

        dbServer = new DBServer(this);

        list = findViewById(R.id.listView);
        namemarket = findViewById(R.id.namemarket);

        if (getIntent().hasExtra("MotherBoard")) {
            int value = getIntent().getIntExtra("MotherBoard", 1);
            if (value == BuildActivity.MOTHERBOARD) {
                table = dbServer.new MotherboardsTable();
                listAdapter = new ListAdapter<Motherboards>(this, table.selectAll());
                namemarket.setText("Материнские платы");
            }
        }
        if (getIntent().hasExtra("Central processor")) {
            int value = getIntent().getIntExtra("Central processor", 2);
            if (value == BuildActivity.PROCES) {
                table = dbServer.new CPUTable();
                listAdapter = new ListAdapter<CPU>(this, table.selectAll());
                namemarket.setText("Процессоры");
            }
        }
        if (getIntent().hasExtra("Cooler")) {
            int value = getIntent().getIntExtra("Cooler", 3);
            if (value == BuildActivity.COOLERS){
                namemarket.setText("Вентиляторы");
                table = dbServer.new CoolersTable();
                listAdapter = new ListAdapter<Coolers>(this, table.selectAll());
            }
        }
        if (getIntent().hasExtra("Graphics card")) {
            int value = getIntent().getIntExtra("Graphics card", 4);
            if (value == BuildActivity.GPU) {
                table = dbServer.new videoCardsTable();
                listAdapter = new ListAdapter<video_cards>(this, table.selectAll());
                namemarket.setText("Видеокарты");
            }
        }
        if (getIntent().hasExtra("Ram")) {
            int value = getIntent().getIntExtra("Ram", 5);
            if (value == BuildActivity.RAM) {
                namemarket.setText("Оперативная память");
                table = dbServer.new RAMTable();
                listAdapter = new ListAdapter<RAM>(this, table.selectAll());
            }
        }
        if (getIntent().hasExtra("HDD")) {
            int value = getIntent().getIntExtra("HDD", 6);
            if (value == BuildActivity.HDD) {
                table = dbServer.new HDDTable();
                listAdapter = new ListAdapter<HDD>(this, table.selectAll());
                namemarket.setText("HDD диски");
            }
        }
        if (getIntent().hasExtra("SSD")) {
            int value = getIntent().getIntExtra("SSD", 7);
            if (value == BuildActivity.SSD) {
                namemarket.setText("SSD диски");
                table = dbServer.new SSDTable();
                listAdapter = new ListAdapter<SSD>(this, table.selectAll());
            }
        }
        if (getIntent().hasExtra("M2")) {
            int value = getIntent().getIntExtra("M2", 8);
            if (value == BuildActivity.M2) {
                table = dbServer.new M2Table();
                listAdapter = new ListAdapter<M2>(this, table.selectAll());
                namemarket.setText("M2 накопители");
            }
        }
        if (getIntent().hasExtra("CPUCOOLER")) {
            int value = getIntent().getIntExtra("CPUCOOLER", 9);
            if (value == BuildActivity.CPUCOOLER) {
                table = dbServer.new Coolers_CPUTable();
                listAdapter = new ListAdapter<Coolers_CPU>(this, table.selectAll());
                namemarket.setText("Кулеры для процессора");
            }
        }
        if (getIntent().hasExtra("BP")) {
            int value = getIntent().getIntExtra("BP", 10);
            if (value == BuildActivity.BP) {
                table = dbServer.new BPTable();
                listAdapter = new ListAdapter<BP>(this, table.selectAll());
                namemarket.setText("Блоки питания");
            }
        }
        if (getIntent().hasExtra("BODY")) {
            int value = getIntent().getIntExtra("BODY", 11);
            if (value == BuildActivity.BODY) {
                namemarket.setText("Корпуса");
                table = dbServer.new BodyTable();
                listAdapter = new ListAdapter<Body>(this, table.selectAll());

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

            ImageView image = convertView.findViewById(R.id.image);
            TextView name = convertView.findViewById(R.id.name);
            TextView description = convertView.findViewById(R.id.description);
            TextView price = convertView.findViewById(R.id.price);

            T preview = (T) getItem(position);

            ByteArrayInputStream imageStream = new ByteArrayInputStream(preview.getImage());
            Bitmap theImage = BitmapFactory.decodeStream(imageStream);
            image.setImageBitmap(theImage);
            name.setText(preview.getName());
            description.setText("Краткое описание: " + preview.getDescription());
            price.setText("Цена: " + preview.getPrice() + " ₽");

            return convertView;
        }
    }
}


