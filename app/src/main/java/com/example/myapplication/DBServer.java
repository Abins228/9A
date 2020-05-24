package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBServer {
    private static final String DATABASE_NAME = "parts.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase database;

    public DBServer(Context context) {
        OpenHelper openHelper = new OpenHelper(context);
        try {
            openHelper.createDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.database = openHelper.getReadableDatabase();
        System.out.println(database.getPath());

    }

    public class BPTable implements Selectable<BP> {
        private static final String TABLE_NAME = "BP";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_TYPE = "Type";
        private static final String COLUMN_POWER = "Power";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_TYPE = 2;
        private static final int NUM_COLUMN_POWER = 3;
        private static final int NUM_COLUMN_PRICE = 4;
        private static final int NUM_COLUMN_DNS = 5;
        private static final int NUM_COLUMN_IMAGE = 6;

        public long insert(String name, String type, String power, String price, String dns) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_TYPE, type);
            cv.put(COLUMN_POWER, power);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<BP> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<BP> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String type = cursor.getString(NUM_COLUMN_TYPE);
                    String power = cursor.getString(NUM_COLUMN_POWER);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new com.example.myapplication.BP(id, name, type, power, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public BP select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            BP out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String type = cursor.getString(NUM_COLUMN_TYPE);
                String power = cursor.getString(NUM_COLUMN_POWER);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new BP(id, name, type, power, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }

    public class MotherboardsTable implements Selectable<Motherboards> {
        private static final String TABLE_NAME = "Motherboards";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_SOCKET = "Socket";
        private static final String COLUMN_CHIP = "Chip";
        private static final String COLUMN_TYPERAM = "TypeRAM";
        private static final String COLUMN_FORM_FACTOR = "Form_factor";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_SOCKET = 2;
        private static final int NUM_COLUMN_CHIP = 3;
        private static final int NUM_COLUMN_TYPERAM = 4;
        private static final int NUM_COLUMN_FORM_FACTOR = 5;
        private static final int NUM_COLUMN_PRICE = 6;
        private static final int NUM_COLUMN_DNS = 7;
        private static final int NUM_COLUMN_IMAGE = 8;

        public long insert(String name, String soket, String chip, String typeram, String formf, String price, String dns, byte[] image) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_SOCKET, soket);
            cv.put(COLUMN_CHIP, chip);
            cv.put(COLUMN_TYPERAM, typeram);
            cv.put(COLUMN_FORM_FACTOR, formf);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            cv.put(COLUMN_IMAGE, image);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<Motherboards> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<Motherboards> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String socket = cursor.getString(NUM_COLUMN_SOCKET);
                    String chip = cursor.getString(NUM_COLUMN_CHIP);
                    String typeram = cursor.getString(NUM_COLUMN_TYPERAM);
                    String formf = cursor.getString(NUM_COLUMN_FORM_FACTOR);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new Motherboards(id, name, socket, chip, typeram, formf, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public Motherboards select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            Motherboards out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String socket = cursor.getString(NUM_COLUMN_SOCKET);
                String chip = cursor.getString(NUM_COLUMN_CHIP);
                String typeram = cursor.getString(NUM_COLUMN_TYPERAM);
                String formf = cursor.getString(NUM_COLUMN_FORM_FACTOR);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new Motherboards(id, name, socket, chip, typeram, formf, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }

    public class Coolers_CPUTable implements Selectable<CoolersCPU> {
        private static final String TABLE_NAME = "Coolers_CPU";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_POWER = "Power";
        private static final String COLUMN_NOISE_LEVEL = "Noise_Level";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 3;
        private static final int NUM_COLUMN_POWER = 1;
        private static final int NUM_NOISE_LEVEL = 2;
        private static final int NUM_COLUMN_PRICE = 4;
        private static final int NUM_COLUMN_DNS = 5;
        private static final int NUM_COLUMN_IMAGE = 6;

        public long insert(String name, String power, String noise_level, String price, String dns) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_POWER, power);
            cv.put(COLUMN_NOISE_LEVEL, noise_level);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<CoolersCPU> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<CoolersCPU> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String power = cursor.getString(NUM_COLUMN_POWER);
                    String noise_level = cursor.getString(NUM_NOISE_LEVEL);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new CoolersCPU(id, name, power, noise_level, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public CoolersCPU select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            CoolersCPU out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String power = cursor.getString(NUM_COLUMN_POWER);
                String noise_level = cursor.getString(NUM_NOISE_LEVEL);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new CoolersCPU(id, name, power, noise_level, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }


    public class CPUTable implements Selectable<CPU> {
        private static final String TABLE_NAME = "CPU";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_PROCESSOR_SOCKET = "Processor_Socket";
        private static final String COLUMN_CPU_SPEED = "CPU_Speed";
        private static final String COLUMN_CORES_THREADS = "Cores_Threads";
        private static final String COLUMN_DDR = "DDR";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 4;
        private static final int NUM_COLUMN_PROCESSOR_SOCKET = 3;
        private static final int NUM_COLUMN_CPU_SPEED = 1;
        private static final int NUM_CORES_THREADS = 2;
        private static final int NUM_COLUMN_DDR = 7;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;
        private static final int NUM_COLUMN_IMAGE = 8;

        public long insert(String name, String soket, String chip, String typeram, String formf, String price, String dns) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_PROCESSOR_SOCKET, soket);
            cv.put(COLUMN_CPU_SPEED, chip);
            cv.put(COLUMN_CORES_THREADS, typeram);
            cv.put(COLUMN_DDR, formf);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<CPU> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<CPU> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String processor_socket = cursor.getString(NUM_COLUMN_PROCESSOR_SOCKET);
                    String cpu_speed = cursor.getString(NUM_COLUMN_CPU_SPEED);
                    String cores_threads = cursor.getString(NUM_CORES_THREADS);
                    String ddr = cursor.getString(NUM_COLUMN_DDR);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new CPU(id, name, processor_socket, cpu_speed, cores_threads, ddr, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public CPU select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            CPU out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String processor_socket = cursor.getString(NUM_COLUMN_PROCESSOR_SOCKET);
                String cpu_speed = cursor.getString(NUM_COLUMN_CPU_SPEED);
                String cores_threads = cursor.getString(NUM_CORES_THREADS);
                String ddr = cursor.getString(NUM_COLUMN_DDR);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new CPU(id, name, processor_socket, cpu_speed, cores_threads, ddr, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }

    public class HDDTable implements Selectable<HDD> {
        private static final String TABLE_NAME = "HDD";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_CAPACITY = "Capacity";
        private static final String COLUMN_MAXRW = "MaxR/W";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPACITY = 2;
        private static final int NUM_COLUMN_MAXRW = 3;
        private static final int NUM_COLUMN_PRICE = 4;
        private static final int NUM_COLUMN_DNS = 5;
        private static final int NUM_COLUMN_IMAGE = 6;

        public long insert(String name, String capacity, String maxrw, String price, String dns) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_CAPACITY, capacity);
            cv.put(COLUMN_MAXRW, maxrw);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<HDD> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<HDD> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                    String maxrw = cursor.getString(NUM_COLUMN_MAXRW);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new HDD(id, name, capacity, maxrw, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public HDD select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            HDD out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                String maxrw = cursor.getString(NUM_COLUMN_MAXRW);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new HDD(id, name, capacity, maxrw, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }

    public class SSDTable implements Selectable<SSD> {
        private static final String TABLE_NAME = "SSD";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_CAPACITY = "Capacity";
        private static final String COLUMN_WRITING_SPEED = "Writing_speed";
        private static final String COLUMN_READING_SPEED = "Reading_speed";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPACITY = 2;
        private static final int NUM_COLUMN_WRITING_SPEED = 3;
        private static final int NUM_COLUMN_READING_SPEED = 4;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;
        private static final int NUM_COLUMN_IMAGE = 7;

        public long insert(String name, String capacity, String writing_speed, String reading_speed, String price, String dns) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_CAPACITY, capacity);
            cv.put(COLUMN_WRITING_SPEED, writing_speed);
            cv.put(COLUMN_READING_SPEED, reading_speed);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<SSD> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<SSD> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                    String writing_speed = cursor.getString(NUM_COLUMN_WRITING_SPEED);
                    String reading_speed = cursor.getString(NUM_COLUMN_READING_SPEED);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new SSD(id, name, capacity, writing_speed, reading_speed, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public SSD select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            SSD out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                String writing_speed = cursor.getString(NUM_COLUMN_WRITING_SPEED);
                String reading_speed = cursor.getString(NUM_COLUMN_READING_SPEED);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new SSD(id, name, capacity, writing_speed, reading_speed, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }

    public class M2Table implements Selectable<M2> {
        private static final String TABLE_NAME = "M2";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_WRITING_SPEED = "Writing_speed";
        private static final String COLUMN_READING_SPEED = "Reading_speed";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_CAPACITY = "Capacity";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPACITY = 2;
        private static final int NUM_COLUMN_WRITING_SPEED = 3;
        private static final int NUM_COLUMN_READING_SPEED = 4;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;
        private static final int NUM_COLUMN_IMAGE = 7;

        public long insert(String name, String capacity, String writing_speed, String reading_speed, String price, String dns) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_CAPACITY, capacity);
            cv.put(COLUMN_WRITING_SPEED, writing_speed);
            cv.put(COLUMN_READING_SPEED, reading_speed);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<M2> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<M2> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                    String writing_speed = cursor.getString(NUM_COLUMN_WRITING_SPEED);
                    String reading_speed = cursor.getString(NUM_COLUMN_READING_SPEED);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new M2(id, name, capacity, writing_speed, reading_speed, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public M2 select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            M2 out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                String writing_speed = cursor.getString(NUM_COLUMN_WRITING_SPEED);
                String reading_speed = cursor.getString(NUM_COLUMN_READING_SPEED);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new M2(id, name, capacity, writing_speed, reading_speed, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }

    public class GPUTable implements Selectable<GPU> {
        private static final String TABLE_NAME = "video_cards";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_CAPASITY = "Capasity";
        private static final String COLUMN_TYPECAPASITY = "TypeCapasity";
        private static final String COLUMN_FREQUENCY = "Frequency";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPASITY = 2;
        private static final int NUM_COLUMN_TYPECAPASITY = 3;
        private static final int NUM_COLUMN_FREQUENCY = 4;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;
        private static final int NUM_COLUMN_IMAGE = 7;

        public long insert(String name, String сapasity, String typecapasity, String frequency, String price, String dns) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_CAPASITY, сapasity);
            cv.put(COLUMN_TYPECAPASITY, typecapasity);
            cv.put(COLUMN_FREQUENCY, frequency);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<GPU> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<GPU> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String сapasity = cursor.getString(NUM_COLUMN_CAPASITY);
                    String typecapasity = cursor.getString(NUM_COLUMN_TYPECAPASITY);
                    String frequency = cursor.getString(NUM_COLUMN_FREQUENCY);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new GPU(id, name, сapasity, typecapasity, frequency, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public GPU select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            GPU out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String сapasity = cursor.getString(NUM_COLUMN_CAPASITY);
                String typecapasity = cursor.getString(NUM_COLUMN_TYPECAPASITY);
                String frequency = cursor.getString(NUM_COLUMN_FREQUENCY);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new GPU(id, name, сapasity, typecapasity, frequency, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }

    public class BodyTable implements Selectable<Body> {
        private static final String TABLE_NAME = "Body";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_FORM_FACRORS = "form_facrors";
        private static final String COLUMN_FORM = "form";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_FORM_FACRORS = 3;
        private static final int NUM_COLUMN_FORM = 4;
        private static final int NUM_COLUMN_PRICE = 2;
        private static final int NUM_COLUMN_DNS = 5;
        private static final int NUM_COLUMN_IMAGE = 6;

        public long insert(String name, String form_facrors, String form, String price, String dns) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_FORM_FACRORS, form_facrors);
            cv.put(COLUMN_FORM, form);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<Body> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<Body> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String form_facrors = cursor.getString(NUM_COLUMN_FORM_FACRORS);
                    String form = cursor.getString(NUM_COLUMN_FORM);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new Body(id, name, form, form_facrors, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public Body select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            Body out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String form_facrors = cursor.getString(NUM_COLUMN_FORM_FACRORS);
                String form = cursor.getString(NUM_COLUMN_FORM);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new Body(id, name, form, form_facrors, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }

    public class RAMTable implements Selectable<RAM> {
        private static final String TABLE_NAME = "RAM";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_CAPACITY = "Capacity";
        private static final String COLUMN_RAM_SPEED = "RAM_Speed";
        private static final String COLUMN_NUMBER_OF_MODULES = "Number_of_modules";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_RAMTYPE = "RAMType";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPACITY = 2;
        private static final int NUM_COLUMN_RAM_SPEED = 3;
        private static final int NUM_COLUMN_NUMBER_OF_MODULES = 4;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;
        private static final int NUM_COLUMN_RAMTYPE = 7;
        private static final int NUM_COLUMN_IMAGE = 8;

        public long insert(String name, String capacity, String ram_speed, String number_of_modules, String price, String dns, String ramtype) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_CAPACITY, capacity);
            cv.put(COLUMN_RAM_SPEED, ram_speed);
            cv.put(COLUMN_NUMBER_OF_MODULES, number_of_modules);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            cv.put(COLUMN_RAMTYPE, ramtype);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<RAM> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<RAM> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                    String ram_speed = cursor.getString(NUM_COLUMN_RAM_SPEED);
                    String number_of_modules = cursor.getString(NUM_COLUMN_NUMBER_OF_MODULES);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    String ramtype = cursor.getString(NUM_COLUMN_RAMTYPE);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new RAM(id, name, capacity, ram_speed, number_of_modules, price, dns, ramtype, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public RAM select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            RAM out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                String ram_speed = cursor.getString(NUM_COLUMN_RAM_SPEED);
                String number_of_modules = cursor.getString(NUM_COLUMN_NUMBER_OF_MODULES);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                String ramtype = cursor.getString(NUM_COLUMN_RAMTYPE);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new RAM(id, name, capacity, ram_speed, number_of_modules, price, dns, ramtype, image);
            }
            cursor.close();
            return out;
        }
    }

    public class CoolersTable implements Selectable<Coolers> {
        private static final String TABLE_NAME = "Coolers";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "Name";
        private static final String COLUMN_FAN_SIZE = "Fan_size";
        private static final String COLUMN_MAXIMUM_VOLUME = "maximum_Volume";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_IMAGE = "Image";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_FAN_SIZE = 2;
        private static final int NUM_COLUMN_MAXIMUM_VOLUME = 3;
        private static final int NUM_COLUMN_PRICE = 4;
        private static final int NUM_COLUMN_DNS = 5;
        private static final int NUM_COLUMN_IMAGE = 6;

        public long insert(String name, String fan_size, String maximum_volume, String dns) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_FAN_SIZE, fan_size);
            cv.put(COLUMN_MAXIMUM_VOLUME, maximum_volume);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall() {
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<Coolers> selectAll() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<Coolers> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String fan_size = cursor.getString(NUM_COLUMN_FAN_SIZE);
                    String maximum_volume = cursor.getString(NUM_COLUMN_MAXIMUM_VOLUME);
                    String price = cursor.getString(NUM_COLUMN_PRICE);
                    String dns = cursor.getString(NUM_COLUMN_DNS);
                    byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                    arr.add(new Coolers(id, name, fan_size, maximum_volume, price, dns, image));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public Coolers select(int id) {
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            Coolers out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
//
                String name = cursor.getString(NUM_COLUMN_NAME);
                String fan_size = cursor.getString(NUM_COLUMN_FAN_SIZE);
                String maximum_volume = cursor.getString(NUM_COLUMN_MAXIMUM_VOLUME);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new Coolers(id, name, fan_size, maximum_volume, price, dns, image);
            }
            cursor.close();
            return out;
        }
    }

    class UserCartTable {
        private static final String TABLE_NAME = "user_cart";
        private static final String COLUMN_BP_ID = "BP_id";
        private static final String COLUMN_BODY_ID = "Body_id";
        private static final String COLUMN_CPU_ID = "CPU_id";
        private static final String COLUMN_COOLERS_CPU_ID = "Coolers_CPU_id";
        private static final String COLUMN_HDD_ID = "HDD_id";
        private static final String COLUMN_COOLERS_ID = "Coolers_id";
        private static final String COLUMN_M2_ID = "M2_id";
        private static final String COLUMN_MOTHERBOARDS_ID = "Motherboards_id";
        private static final String COLUMN_RAM_ID = "RAM_id";
        private static final String COLUMN_SSD_ID = "SSD_id";
        private static final String COLUMN_GPU_ID = "GPU_id";

        public boolean entry = false;

        public UserCartTable() {
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);
            if (cursor.getCount() > 0)
                entry = true;
            cursor.close();
        }

        public UserCart getUserCart(){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            Coolers out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
//
                String name = cursor.getString(NUM_COLUMN_NAME);
                String fan_size = cursor.getString(NUM_COLUMN_FAN_SIZE);
                String maximum_volume = cursor.getString(NUM_COLUMN_MAXIMUM_VOLUME);
                String price = cursor.getString(NUM_COLUMN_PRICE);
                String dns = cursor.getString(NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(NUM_COLUMN_IMAGE);
                out = new Coolers(id, name, fan_size, maximum_volume, price, dns, image);
            }
            cursor.close();
            return out;

        }

        public void addBP(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_BP_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_BP_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public BP getBP() {
            Cursor cursor = database.query(BPTable.TABLE_NAME, null, BPTable.COLUMN_ID + "= (select user_cart.BP_id from user_cart where ID = 1)",
                    null, null, null, null);
            BP out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();

                int id = cursor.getInt(BPTable.NUM_COLUMN_ID);
                String name = cursor.getString(BPTable.NUM_COLUMN_NAME);
                String type = cursor.getString(BPTable.NUM_COLUMN_TYPE);
                String power = cursor.getString(BPTable.NUM_COLUMN_POWER);
                String price = cursor.getString(BPTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(BPTable.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(BPTable.NUM_COLUMN_IMAGE);
                out = new BP(id, name, type, power, price, dns, image);
            }
            cursor.close();
            return out;
        }

        public void addMot(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_MOTHERBOARDS_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_MOTHERBOARDS_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public Motherboards getMot() {
            Cursor cursor = database.query(MotherboardsTable.TABLE_NAME, null, MotherboardsTable.COLUMN_ID + "= (select user_cart.MOTHERBOARDS_id from user_cart where ID = 1)",
                    null, null, null, null);
            Motherboards out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();

                int id = cursor.getInt(MotherboardsTable.NUM_COLUMN_ID);
                String name = cursor.getString(MotherboardsTable.NUM_COLUMN_NAME);
                String socket = cursor.getString(MotherboardsTable.NUM_COLUMN_SOCKET);
                String chip = cursor.getString(MotherboardsTable.NUM_COLUMN_CHIP);
                String typeram = cursor.getString(MotherboardsTable.NUM_COLUMN_TYPERAM);
                String formf = cursor.getString(MotherboardsTable.NUM_COLUMN_FORM_FACTOR);
                String price = cursor.getString(MotherboardsTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(MotherboardsTable.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(MotherboardsTable.NUM_COLUMN_IMAGE);
                out = new Motherboards(id, name, socket, chip, typeram, formf, price, dns, image);
            }
            cursor.close();
            return out;
        }


        public void addCPU(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_CPU_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_CPU_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public CPU getCPU() {
            Cursor cursor = database.query(CPUTable.TABLE_NAME, null, CPUTable.COLUMN_ID + "= (select user_cart.CPU_id from user_cart where ID = 1)",
                    null, null, null, null);
            CPU out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();

                int id = cursor.getInt(CPUTable.NUM_COLUMN_ID);
                String name = cursor.getString(CPUTable.NUM_COLUMN_NAME);
                String processor_socket = cursor.getString(CPUTable.NUM_COLUMN_PROCESSOR_SOCKET);
                String cpu_speed = cursor.getString(CPUTable.NUM_COLUMN_CPU_SPEED);
                String cores_threads = cursor.getString(CPUTable.NUM_CORES_THREADS);
                String ddr = cursor.getString(CPUTable.NUM_COLUMN_DDR);
                String price = cursor.getString(CPUTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(CPUTable.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(CPUTable.NUM_COLUMN_IMAGE);
                out=new CPU(id, name, processor_socket, cpu_speed, cores_threads, ddr, price, dns, image);
            }
            cursor.close();
            return out;
        }
        public void addCCPU(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_COOLERS_CPU_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_COOLERS_CPU_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public CoolersCPU getCCPU() {
            Cursor cursor = database.query(Coolers_CPUTable.TABLE_NAME, null, Coolers_CPUTable.COLUMN_ID + "= (select user_cart.Coolers_CPU_id from user_cart where ID = 1)",
                    null, null, null, null);
            CoolersCPU out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();

                int id = cursor.getInt(Coolers_CPUTable.NUM_COLUMN_ID);
                String name = cursor.getString(Coolers_CPUTable.NUM_COLUMN_NAME);
                String power = cursor.getString(Coolers_CPUTable.NUM_COLUMN_POWER);
                String noise_level = cursor.getString(Coolers_CPUTable.NUM_NOISE_LEVEL);
                String price = cursor.getString(Coolers_CPUTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(Coolers_CPUTable.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(Coolers_CPUTable.NUM_COLUMN_IMAGE);
                out=new CoolersCPU(id, name, power, noise_level, price, dns, image);
            }
            cursor.close();
            return out;
        }
        public void addGPU(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_GPU_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_GPU_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public GPU getGPU() {
            Cursor cursor = database.query(GPUTable.TABLE_NAME, null, Coolers_CPUTable.COLUMN_ID + "= (select user_cart.GPU_id from user_cart where ID = 1)",
                    null, null, null, null);
            GPU out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int id = cursor.getInt(GPUTable.NUM_COLUMN_ID);
                String name = cursor.getString(GPUTable.NUM_COLUMN_NAME);
                String сapasity = cursor.getString(GPUTable.NUM_COLUMN_CAPASITY);
                String typecapasity = cursor.getString(GPUTable.NUM_COLUMN_TYPECAPASITY);
                String frequency = cursor.getString(GPUTable.NUM_COLUMN_FREQUENCY);
                String price = cursor.getString(GPUTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(GPUTable.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(GPUTable.NUM_COLUMN_IMAGE);
                out = new GPU(id, name, сapasity, typecapasity, frequency, price, dns, image);
            }

            return out;
        }
        public void addRAM(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_RAM_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_RAM_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public RAM getRAM() {
            Cursor cursor = database.query(RAMTable.TABLE_NAME, null, RAMTable.COLUMN_ID + "= (select user_cart.RAM_id from user_cart where ID = 1)",
                    null, null, null, null);
            RAM out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int id = cursor.getInt(RAMTable.NUM_COLUMN_ID);
                String name = cursor.getString(RAMTable.NUM_COLUMN_NAME);
                String capacity = cursor.getString(RAMTable.NUM_COLUMN_CAPACITY);
                String ram_speed = cursor.getString(RAMTable.NUM_COLUMN_RAM_SPEED);
                String number_of_modules = cursor.getString(RAMTable.NUM_COLUMN_NUMBER_OF_MODULES);
                String price = cursor.getString(RAMTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(RAMTable.NUM_COLUMN_DNS);
                String ramtype = cursor.getString(RAMTable.NUM_COLUMN_RAMTYPE);
                byte[] image = cursor.getBlob(RAMTable.NUM_COLUMN_IMAGE);
                out=new RAM(id, name, capacity, ram_speed, number_of_modules, price, dns, ramtype, image);
            }
            return out;
        }
        public void addHDD(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_HDD_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_HDD_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public HDD getHDD() {
            Cursor cursor = database.query(HDDTable.TABLE_NAME, null, HDDTable.COLUMN_ID + "= (select user_cart.HDD_id from user_cart where ID = 1)",
                    null, null, null, null);
            HDD out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int id = cursor.getInt(HDDTable.NUM_COLUMN_ID);
                String name = cursor.getString(HDDTable.NUM_COLUMN_NAME);
                String capacity = cursor.getString(HDDTable.NUM_COLUMN_CAPACITY);
                String maxrw = cursor.getString(HDDTable.NUM_COLUMN_MAXRW);
                String price = cursor.getString(HDDTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(HDDTable.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(HDDTable.NUM_COLUMN_IMAGE);
                out=new HDD(id, name, capacity, maxrw, price, dns, image);
            }
            return out;
        }
        public void addSSD(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_SSD_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_SSD_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public SSD getSSD() {
            Cursor cursor = database.query(SSDTable.TABLE_NAME, null, SSDTable.COLUMN_ID + "= (select user_cart.SSD_id from user_cart where ID = 1)",
                    null, null, null, null);
            SSD out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int id = cursor.getInt(SSDTable.NUM_COLUMN_ID);
                String name = cursor.getString(SSDTable.NUM_COLUMN_NAME);
                String capacity = cursor.getString(SSDTable.NUM_COLUMN_CAPACITY);
                String writing_speed = cursor.getString(SSDTable.NUM_COLUMN_WRITING_SPEED);
                String reading_speed = cursor.getString(SSDTable.NUM_COLUMN_READING_SPEED);
                String price = cursor.getString(SSDTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(SSDTable.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(SSDTable.NUM_COLUMN_IMAGE);
                out = new SSD(id, name, capacity, writing_speed, reading_speed, price, dns, image);
            }
            return out;
        }
        public void addM2(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_M2_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_M2_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public M2 getM2() {
            Cursor cursor = database.query(M2Table.TABLE_NAME, null, M2Table.COLUMN_ID + "= (select user_cart.M2_id from user_cart where ID = 1)",
                    null, null, null, null);
            M2 out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int id = cursor.getInt(M2Table.NUM_COLUMN_ID);
                String name = cursor.getString(M2Table.NUM_COLUMN_NAME);
                String capacity = cursor.getString(M2Table.NUM_COLUMN_CAPACITY);
                String writing_speed = cursor.getString(M2Table.NUM_COLUMN_WRITING_SPEED);
                String reading_speed = cursor.getString(M2Table.NUM_COLUMN_READING_SPEED);
                String price = cursor.getString(M2Table.NUM_COLUMN_PRICE);
                String dns = cursor.getString(M2Table.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(M2Table.NUM_COLUMN_IMAGE);
                out = new M2(id, name, capacity, writing_speed, reading_speed, price, dns, image);
            }
            return out;
        }
        public void addCoolers(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_COOLERS_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_COOLERS_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public Coolers getCoolers() {
            Cursor cursor = database.query(CoolersTable.TABLE_NAME, null, CoolersTable.COLUMN_ID + "= (select user_cart.Coolers_id from user_cart where ID = 1)",
                    null, null, null, null);
            Coolers out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int id = cursor.getInt(CoolersTable.NUM_COLUMN_ID);
                String name = cursor.getString(CoolersTable.NUM_COLUMN_NAME);
                String fan_size = cursor.getString(CoolersTable.NUM_COLUMN_FAN_SIZE);
                String maximum_volume = cursor.getString(CoolersTable.NUM_COLUMN_MAXIMUM_VOLUME);
                String price = cursor.getString(CoolersTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(CoolersTable.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(CoolersTable.NUM_COLUMN_IMAGE);
                out = new Coolers(id, name, fan_size, maximum_volume, price, dns, image);
            }
            return out;
        }
        public void addBody(int id) {
            String quere = null;
            if (!entry) {
                quere = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_BODY_ID + ") VALUES (?)";
                entry = true;
            } else
                quere = "UPDATE " + TABLE_NAME + " SET " + COLUMN_BODY_ID + "= ? WHERE (ID = 1)";
            SQLiteStatement stmt = database.compileStatement(quere);
            stmt.bindLong(1, id);
            stmt.execute();
        }

        public Body getBody() {
            Cursor cursor = database.query(BodyTable.TABLE_NAME, null, BodyTable.COLUMN_ID + "= (select user_cart.Body_id from user_cart where ID = 1)",
                    null, null, null, null);
            Body out = null;
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int id = cursor.getInt(BodyTable.NUM_COLUMN_ID);
                String name = cursor.getString(BodyTable.NUM_COLUMN_NAME);
                String form_facrors = cursor.getString(BodyTable.NUM_COLUMN_FORM_FACRORS);
                String form = cursor.getString(BodyTable.NUM_COLUMN_FORM);
                String price = cursor.getString(BodyTable.NUM_COLUMN_PRICE);
                String dns = cursor.getString(BodyTable.NUM_COLUMN_DNS);
                byte[] image = cursor.getBlob(BodyTable.NUM_COLUMN_IMAGE);
                out = new Body(id, name, form, form_facrors, price, dns, image);
            }
            return out;
        }

    }

    private class OpenHelper extends SQLiteOpenHelper {
        private final Context myContext;
        String outFileName;
        private String DB_PATH = "/data/data/com.example.myapplication/databases/";

        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.myContext = context;
        }

        /**
         * Создание пустой системной БД и её перезапись БД из ассетов
         */
        public void createDataBase() throws IOException {
            boolean dbExist = checkDataBase();
            if (dbExist) {
                // ничего не делать - БД уже создана
            } else {
                // При вызове этого метода пустая база данных будет создана в системном пути по умолчанию
                this.getReadableDatabase();
                this.close();
                try {
                    copyDataBase();
                } catch (IOException e) {
                    throw new Error("Не удалось скопировать БД");
                }
            }
        }

        /**
         * Проверка, существует ли база данных, необходима чтобы избежать повторного копирования при каждом открытии приложения.
         *
         * @ return true, если существует, false, если нет
         */
        private boolean checkDataBase() {
            File databasePath = myContext.getDatabasePath(DATABASE_NAME);
            Log.i("TAG", databasePath.getPath());
            return databasePath.exists();
        }

        /**
         * Копирует вашу базу данных из вашей локальной папки ресурсов в только что созданную пустую базу данных в
         * системнай папке, откуда она может быть доступна и обработана.
         * Используется bytestream.
         */

        private void copyDataBase() throws IOException {
            byte[] buffer = new byte[1024];
            OutputStream myOutput = null;
            int length;
            // Open your local db as the input stream
            InputStream myInput = null;
            try {
                myInput = myContext.getAssets().open(DATABASE_NAME);
                myOutput = new FileOutputStream(myContext.getDatabasePath(DATABASE_NAME));
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.close();
                myOutput.flush();
                myInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void openDataBase() throws SQLException {
            String myPath = myContext.getDatabasePath(DATABASE_NAME).getPath();
            database = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        }

        @Override
        public synchronized void close() {
            if (database != null)
                database.close();
            super.close();
        }

        public void onCreate(SQLiteDatabase arg0) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

        }
    }
}
