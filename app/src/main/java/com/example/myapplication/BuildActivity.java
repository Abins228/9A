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
import android.widget.Toast;

import java.io.ByteArrayInputStream;

public class BuildActivity extends AppCompatActivity {
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

    UserCart userCart;

    ImageButton bpImgBt;
    ImageButton moImgBt;
    ImageButton cpuImgBt;
    ImageButton ccpuImgBt;
    ImageButton gpuImgBt;
    ImageButton ramImgBt;
    ImageButton hddImgBt;
    ImageButton ssdImgBt;
    ImageButton m2ImgBt;
    ImageButton bodyImgBt;
    ImageButton coolersImgBt;
    ImageView trash;


    TextView priceSborka;

    FrameLayout bpContainer;
    FrameLayout motherContainer;
    FrameLayout cpuContainer;
    FrameLayout ccpuContainer;
    FrameLayout gpuContainer;
    FrameLayout ramContainer;
    FrameLayout hddContainer;
    FrameLayout ssdContainer;
    FrameLayout m2Container;
    FrameLayout bodyContainer;
    FrameLayout coolersContainer;

    DBServer.UserCartTable user_carts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_activity);
        bpImgBt = findViewById(R.id.bpIm);
        moImgBt = findViewById(R.id.motherIm);
        cpuImgBt = findViewById(R.id.cpuIm);
        ccpuImgBt = findViewById(R.id.CPUcoollerIm);
        gpuImgBt = findViewById(R.id.gpuIm);
        ramImgBt = findViewById(R.id.ramIm);
        hddImgBt = findViewById(R.id.hddIm);
        ssdImgBt = findViewById(R.id.ssdIm);
        m2ImgBt = findViewById(R.id.m2Im);
        bodyImgBt = findViewById(R.id.bodyIm);
        coolersImgBt = findViewById(R.id.coollersIm);

        bpContainer = findViewById(R.id.bpContainer);
        motherContainer = findViewById(R.id.motherContainer);
        cpuContainer = findViewById(R.id.cpuContainer);
        ccpuContainer = findViewById(R.id.CPUcoollerContainer);
        gpuContainer = findViewById(R.id.gpuContainer);
        ramContainer = findViewById(R.id.ramContainer);
        hddContainer = findViewById(R.id.hddContainer);
        ssdContainer = findViewById(R.id.ssdContainer);
        m2Container = findViewById(R.id.m2Container);
        bodyContainer = findViewById(R.id.bodyContainer);
        coolersContainer = findViewById(R.id.coollersContainer);

        priceSborka = findViewById(R.id.priceSborka);

        DBServer dbServer = new DBServer(this);
        user_carts = dbServer.new UserCartTable();
        userCart = user_carts.getUserCart();

        bt = findViewById(R.id.sborkaBack);
        trash = findViewById(R.id.trashbutton);
        trash.setOnClickListener(onTrashClickListener());
        bt.setOnClickListener(onBackClickListener());
        bpImgBt.setOnClickListener(onClickListener());
        moImgBt.setOnClickListener(onClickListener());
        cpuImgBt.setOnClickListener(onClickListener());
        ccpuImgBt.setOnClickListener(onClickListener());
        gpuImgBt.setOnClickListener(onClickListener());
        ramImgBt.setOnClickListener(onClickListener());
        hddImgBt.setOnClickListener(onClickListener());
        ssdImgBt.setOnClickListener(onClickListener());
        m2ImgBt.setOnClickListener(onClickListener());
        bodyImgBt.setOnClickListener(onClickListener());
        coolersImgBt.setOnClickListener(onClickListener());


        if (user_carts.entry) {
            invalidateAll();
        }

    }

    public void invalidateAll(){
        invalidateBpBt();
        invalidateMoBt();
        invalidateCPUBt();
        invalidateGPUBt();
        invalidateCCPUBt();
        invalidateRAMBt();
        invalidateHDDBt();
        invalidateSSDBt();
        invalidateM2Bt();
        invalidateCoolersBt();
        invalidateBodyBt();
        invalidatePriceSborka();
    }

    public void invalidatePriceSborka() {
        priceSborka.setText("Общая стоимость: " + String.valueOf(userCart.getAmount()) + " ₽");
    }

    public <T extends Idetificate> void invalidateBt(T preview, FrameLayout container) {
        if (preview != null) {
            View view = getLayoutInflater().inflate(R.layout.item, null);
            ImageView image = view.findViewById(R.id.image);
            TextView name = view.findViewById(R.id.name);
            TextView description = view.findViewById(R.id.description);
            TextView price = view.findViewById(R.id.price);
            image.setImageBitmap(buildImg(preview.getImage()));
            name.setText(preview.getName());
            description.setText(preview.getDescription());
            price.setText("Цена: " + preview.getPrice() + "₽");
            replaceView(view, container);
        }
    }

    public void invalidateBpBt() {
        BP bp = user_carts.getBP();
        userCart.setBp(bp);
        invalidateBt(bp, bpContainer);
    }

    public void invalidateMoBt() {
        Motherboards motherboards = user_carts.getMot();
        userCart.setMotherboards(motherboards);
        invalidateBt(motherboards, motherContainer);
    }

    public void invalidateCPUBt() {
        CPU cpu = user_carts.getCPU();
        userCart.setCpu(cpu);
        invalidateBt(cpu, cpuContainer);
    }

    public void invalidateGPUBt() {
        GPU gpu = user_carts.getGPU();
        userCart.setGpu(gpu);
        invalidateBt(gpu, gpuContainer);
    }

    public void invalidateCCPUBt() {
        CoolersCPU coolers_cpu = user_carts.getCCPU();
        userCart.setCoolersCPU(coolers_cpu);
        invalidateBt(coolers_cpu, ccpuContainer);
    }

    public void invalidateRAMBt() {
        RAM ram = user_carts.getRAM();
        userCart.setRam(ram);
        invalidateBt(ram, ramContainer);
    }

    public void invalidateHDDBt() {
        HDD hdd = user_carts.getHDD();
        userCart.setHdd(hdd);
        invalidateBt(hdd, hddContainer);
    }

    public void invalidateSSDBt() {
        SSD ssd = user_carts.getSSD();
        userCart.setSsd(ssd);
        invalidateBt(ssd, ssdContainer);
    }

    public void invalidateM2Bt() {
        M2 m2 = user_carts.getM2();
        userCart.setM2(m2);
        invalidateBt(m2, m2Container);
    }

    public void invalidateCoolersBt() {
        Coolers coolers = user_carts.getCoolers();
        userCart.setCoolers(coolers);
        invalidateBt(coolers, coolersContainer);
    }

    public void invalidateBodyBt() {
        Body body = user_carts.getBody();
        userCart.setBody(body);
        invalidateBt(body, bodyContainer);
    }

    public View.OnClickListener onClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                Intent s = new Intent(BuildActivity.this, MarketActivity.class);
                if (id == R.id.bpIm || id == R.id.bpContainer) {
                    s.putExtra("BP", BP);
                    startActivityForResult(s, BP);
                } else if (id == R.id.motherIm || id == R.id.motherContainer) {
                    s.putExtra("MotherBoard", MOTHERBOARD);
                    startActivityForResult(s, MOTHERBOARD);
                } else if (id == R.id.cpuIm || id == R.id.cpuContainer) {
                    s.putExtra("Central processor", PROCES);
                    startActivityForResult(s, PROCES);
                } else if (id == R.id.CPUcoollerIm || id == R.id.CPUcoollerContainer) {
                    s.putExtra("CPUCOOLER", CPUCOOLER);
                    startActivityForResult(s, CPUCOOLER);
                } else if (id == R.id.ramIm || id == R.id.ramContainer) {
                    s.putExtra("Ram", RAM);
                    startActivityForResult(s, RAM);
                } else if (id == R.id.hddIm || id == R.id.hddContainer) {
                    s.putExtra("HDD", HDD);
                    startActivityForResult(s, HDD);
                } else if (id == R.id.ssdIm || id == R.id.ssdContainer) {
                    s.putExtra("SSD", SSD);
                    startActivityForResult(s, SSD);
                } else if (id == R.id.m2Im || id == R.id.m2Container) {
                    s.putExtra("M2", M2);
                    startActivityForResult(s, M2);
                } else if (id == R.id.coollersIm || id == R.id.coollersContainer) {
                    s.putExtra("Cooler", COOLERS);
                    startActivityForResult(s, COOLERS);
                } else if (id == R.id.bodyIm || id == R.id.bodyContainer) {
                    s.putExtra("BODY", BODY);
                    startActivityForResult(s, BODY);
                } else if (id == R.id.gpuIm || id == R.id.gpuContainer) {
                    s.putExtra("Graphics card", GPU);
                    startActivityForResult(s, GPU);
                }

            }
        };
    }

    public View.OnClickListener onBackClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };
    }

    public View.OnClickListener onTrashClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //user_carts.deleteall();
                //userCart = new UserCart();
                //invalidateAll();
                Toast.makeText(BuildActivity.this, "Сборка очищена! (Пока не работает)",
                        Toast.LENGTH_LONG).show();
            }
        };
    }

    public Bitmap buildImg(byte[] bytes) {
        ByteArrayInputStream imageStream = new ByteArrayInputStream(bytes);
        return BitmapFactory.decodeStream(imageStream);
    }

    public void replaceView(View view, FrameLayout container) {
        container.removeAllViews();
        container.addView(view);
        container.setOnClickListener(onClickListener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MOTHERBOARD && resultCode == RESULT_OK) {
            invalidateMoBt();
        } else if (requestCode == PROCES && resultCode == RESULT_OK) {
            invalidateCPUBt();
        } else if (requestCode == CPUCOOLER && resultCode == RESULT_OK) {
            invalidateCCPUBt();
        } else if (requestCode == GPU && resultCode == RESULT_OK) {
            invalidateGPUBt();
        } else if (requestCode == RAM && resultCode == RESULT_OK) {
            invalidateRAMBt();
        } else if (requestCode == HDD && resultCode == RESULT_OK) {
            invalidateHDDBt();
        } else if (requestCode == SSD && resultCode == RESULT_OK) {
            invalidateSSDBt();
        } else if (requestCode == M2 && resultCode == RESULT_OK) {
            invalidateM2Bt();
        } else if (requestCode == COOLERS && resultCode == RESULT_OK) {
            invalidateCoolersBt();
        } else if (requestCode == BODY && resultCode == RESULT_OK) {
            invalidateBodyBt();
        } else if (requestCode == BP && resultCode == RESULT_OK) {
            invalidateBpBt();
        }
        invalidatePriceSborka();
    }
}


