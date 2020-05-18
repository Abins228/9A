package com.example.myapplication;

import androidx.annotation.Nullable;
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
        s.putExtra("MotherBoard", MOTHERBOARD);
        startActivity(s);
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
        startActivity(s);
    }

    public void onClickBo(View view) {
        Intent s;
        s = new Intent(BuildActivity.this, MarketActivity.class);
        s.putExtra("BODY", BODY);
        startActivity(s);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MOTHERBOARD && resultCode == RESULT_OK) {
            if (getIntent().hasExtra("MotherBoard")) {
                Motherboards motherboards = (Motherboards) getIntent().getSerializableExtra("MotherBoard");
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
                if (getIntent().hasExtra("BP")) {
                    BP bp = (BP) getIntent().getSerializableExtra("BP");
                }
            }
        }
    }
}
