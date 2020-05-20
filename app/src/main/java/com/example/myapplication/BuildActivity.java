package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;

public class BuildActivity extends AppCompatActivity{
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

    ImageButton bpImgBt;
    FrameLayout bpContainer;

    DBServer.UserCart user_carts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_activity);
        bpImgBt = findViewById(R.id.bpIm);
        bpContainer = findViewById(R.id.bpContainer);
        DBServer dbServer = new DBServer(this);
        user_carts = dbServer.new UserCart();

        bt = findViewById(R.id.sborkaBack);
        bt.setOnClickListener(onBackClickListener());

        bpImgBt.setOnClickListener(onClickListener());

        if (user_carts.entry){
            invalidateBpBt();
            // повторить для всех элементов user_cart
        }

    }

    public <T extends Idetificate> void invalidateBt(T preview){
        if (preview != null) {
            View view = getLayoutInflater().inflate(R.layout.item, null);
            ImageView image = view.findViewById(R.id.image);
            TextView name = view.findViewById(R.id.name);
            TextView description = view.findViewById(R.id.description);
            TextView price = view.findViewById(R.id.price);
            image.setImageBitmap(buildImg(preview.getImage()));
            name.setText(preview.getName());
            description.setText(preview.getDescription());
            price.setText("Цена: "+preview.getPrice()+"₽");
            replaceView(view, bpContainer);
        }
    }

    // повторить для всех элементов user_cart
    public void invalidateBpBt(){
        BP bp = user_carts.getBP();
        invalidateBt(bp);
    }

    // дописать условия для остальных кнопок и контейнеров
    public View.OnClickListener onClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                Intent s = new Intent(BuildActivity.this, MarketActivity.class);
                if (id == R.id.bpIm || id == R.id.bpContainer) {
                    s.putExtra("BP", BP);
                    startActivityForResult(s, BP);
                } else if (id == R.id.bpIm || id == R.id.bpContainer) // вставить id motherboard и id motherboard container
                {
                    s.putExtra("MotherBoard", MOTHERBOARD);
                    startActivityForResult(s, MOTHERBOARD);
                }
                // вот сюда
                // потом выкинуть все он клики которые были
            }
        };
    }

    public View.OnClickListener onBackClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };
    }


    public void onClickP(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("Central processor", PROCES);
        startActivity(s);
    }

    public void onClickC(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("Cooler", COOLERS);
        startActivity(s);
    }

    public void onClickG(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("Graphics card", GPU);
        startActivity(s);
    }

    public void onClickR(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("Ram", RAM);
        startActivity(s);
    }

    public void onClickH(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("HDD", HDD);
        startActivity(s);
    }

    public void onClickS(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("SSD", SSD);
        startActivity(s);
    }

    public void onClickM2(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("M2", M2);
        startActivity(s);
    }

    public void onClickCPUCOOL(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("CPUCOOLER", CPUCOOLER);
        startActivity(s);
    }

    public void onClickB(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("BP", BP);
        startActivityForResult(s, BP);
    }

    public void onClickBo(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("BODY", BODY);
        startActivity(s);
    }

    public Bitmap buildImg(byte[] bytes){
        ByteArrayInputStream imageStream = new ByteArrayInputStream(bytes);
        return BitmapFactory.decodeStream(imageStream);
    }

    public void replaceView(View view, FrameLayout container){
        container.removeAllViews();
        container.addView(view);
        container.setOnClickListener(onClickListener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MOTHERBOARD && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("MotherBoard")) {
                Motherboards motherboards = (Motherboards) getIntent().getSerializableExtra("MotherBoard");
            }
        } else if (requestCode == PROCES && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("Central processor")) {
                CPU cpu = (CPU) getIntent().getSerializableExtra("Central processor");
            }
        } else if (requestCode == CPUCOOLER && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("CPUCOOLER")) {
                Coolers_CPU coolers_cpu = (Coolers_CPU) getIntent().getSerializableExtra("CPUCOOLER");
            }
        } else if (requestCode == GPU && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("Graphics card")) {
                video_cards videoCards = (video_cards) getIntent().getSerializableExtra("Graphics card");
            }
        } else if (requestCode == RAM && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("Ram")) {
                RAM ram = (RAM) getIntent().getSerializableExtra("Ram");
            }
        } else if (requestCode == HDD && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("HDD")) {
                HDD hdd = (HDD) getIntent().getSerializableExtra("HDD");
            }
        }else if (requestCode == SSD && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("SSD")) {
                SSD ssd = (SSD) getIntent().getSerializableExtra("SSD");
            }
        }else if (requestCode == M2 && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("M2")) {
                M2 m2 = (M2) getIntent().getSerializableExtra("M2");
            }
        }else if (requestCode == COOLERS && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("Cooler")) {
                Coolers coolers = (Coolers) getIntent().getSerializableExtra("Cooler");
            }
        }else if (requestCode == BODY && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("BODY")) {
                Body body = (Body) getIntent().getSerializableExtra("BODY");
            }
        }else if (requestCode == BP && resultCode == RESULT_OK) {
            invalidateBpBt();
        }

    }
}
