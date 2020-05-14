package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

    public class BPTable implements Selectable<BP>{
        private static final String TABLE_NAME = "BP";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_TYPE= "Type";
        private static final String COLUMN_POWER = "Power";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_TYPE = 2;
        private static final int NUM_COLUMN_POWER = 3;
        private static final int NUM_COLUMN_PRICE = 4;
        private static final int NUM_COLUMN_DNS = 5;

        public long insert(String name, String type, String power, String price, String dns){
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_TYPE, type);
            cv.put(COLUMN_POWER, power);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<BP> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<BP> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String type = cursor.getString(NUM_COLUMN_TYPE);
                    String power= cursor.getString(NUM_COLUMN_POWER);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new com.example.myapplication.BP(id,name,type,power,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public BP select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            BP out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String type = cursor.getString(NUM_COLUMN_TYPE);
                String power= cursor.getString(NUM_COLUMN_POWER);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new BP(id,name,type,power,price,dns);
            }
            cursor.close();
            return out;
        }
    }

    public class MotherboardsTable implements Selectable<Motherboards>{
        private static final String TABLE_NAME = "Motherboards";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_SOCKET = "Socket";
        private static final String COLUMN_CHIP = "Chip";
        private static final String COLUMN_TYPERAM = "TypeRAM";
        private static final String COLUMN_FORM_FACTOR = "Form_factor";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_SOCKET = 2;
        private static final int NUM_COLUMN_CHIP = 3;
        private static final int NUM_COLUMN_TYPERAM = 4;
        private static final int NUM_COLUMN_FORM_FACTOR = 5;
        private static final int NUM_COLUMN_PRICE = 6;
        private static final int NUM_COLUMN_DNS = 7;

        public long insert(String name, String soket, String chip, String typeram, String formf, String price, String dns){
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_SOCKET, soket);
            cv.put(COLUMN_CHIP, chip);
            cv.put(COLUMN_TYPERAM, typeram);
            cv.put(COLUMN_FORM_FACTOR, formf);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<Motherboards> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<Motherboards> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String soket = cursor.getString(NUM_COLUMN_SOCKET);
                    String chip= cursor.getString(NUM_COLUMN_CHIP);
                    String typeram = cursor.getString(NUM_COLUMN_TYPERAM);
                    String formf = cursor.getString(NUM_COLUMN_FORM_FACTOR);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new Motherboards(id,name,soket,chip,typeram,formf,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public Motherboards select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            Motherboards out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String socket = cursor.getString(NUM_COLUMN_SOCKET);
                String chip= cursor.getString(NUM_COLUMN_CHIP);
                String typeram = cursor.getString(NUM_COLUMN_TYPERAM);
                String formf = cursor.getString(NUM_COLUMN_FORM_FACTOR);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new Motherboards(id,name,socket,chip,typeram,formf,price,dns);
            }
            cursor.close();
            return out;
        }
    }

    public class Coolers_CPUTable implements Selectable<Coolers_CPU>{
        private static final String TABLE_NAME = "Coolers_CPU";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_POWER = "Power";
        private static final String COLUMN_NOISE_LEVEL = "Noise_Level";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 3;
        private static final int NUM_COLUMN_POWER = 1;
        private static final int NUM_NOISE_LEVEL = 2;
        private static final int NUM_COLUMN_PRICE = 4;
        private static final int NUM_COLUMN_DNS = 5;

        public long insert(String name, String power, String noise_level, String price, String dns){
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_POWER, power);
            cv.put(COLUMN_NOISE_LEVEL, noise_level);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<Coolers_CPU> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<Coolers_CPU> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String power = cursor.getString(NUM_COLUMN_POWER);
                    String noise_level= cursor.getString(NUM_NOISE_LEVEL);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new Coolers_CPU(id,name,power,noise_level,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public Coolers_CPU select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            Coolers_CPU out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String power = cursor.getString(NUM_COLUMN_POWER);
                String noise_level= cursor.getString(NUM_NOISE_LEVEL);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new Coolers_CPU(id,name,power,noise_level,price,dns);
            }
            cursor.close();
            return out;
        }
    }


    public class CPUTable implements Selectable<CPU>{
        private static final String TABLE_NAME = "CPU";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_PROCESSOR_SOCKET= "Processor_Socket";
        private static final String COLUMN_CPU_SPEED = "CPU_Speed";
        private static final String COLUMN_CORES_THREADS = "Cores_Threads";
        private static final String COLUMN_DDR = "DDR";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 4;
        private static final int NUM_COLUMN_PROCESSOR_SOCKET = 3;
        private static final int NUM_COLUMN_CPU_SPEED = 1;
        private static final int NUM_CORES_THREADS = 2;
        private static final int NUM_COLUMN_DDR = 7;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;

        public long insert(String name, String soket, String chip, String typeram, String formf, String price, String dns){
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

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<CPU> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<CPU> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String processor_socket = cursor.getString(NUM_COLUMN_PROCESSOR_SOCKET);
                    String cpu_speed= cursor.getString(NUM_COLUMN_CPU_SPEED);
                    String cores_threads = cursor.getString(NUM_CORES_THREADS);
                    String ddr = cursor.getString(NUM_COLUMN_DDR);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new CPU(id,name,processor_socket,cpu_speed,cores_threads,ddr,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public CPU select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            CPU out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String processor_socket = cursor.getString(NUM_COLUMN_PROCESSOR_SOCKET);
                String cpu_speed= cursor.getString(NUM_COLUMN_CPU_SPEED);
                String cores_threads = cursor.getString(NUM_CORES_THREADS);
                String ddr = cursor.getString(NUM_COLUMN_DDR);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new CPU(id,name,processor_socket,cpu_speed,cores_threads,ddr,price,dns);
            }
            cursor.close();
            return out;
        }
    }
    public class HDDTable implements Selectable<HDD>{
        private static final String TABLE_NAME = "HDD";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_CAPACITY = "Capacity";
        private static final String COLUMN_MAXRW = "MaxR/W";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPACITY = 2;
        private static final int NUM_COLUMN_MAXRW = 3;
        private static final int NUM_COLUMN_PRICE = 4;
        private static final int NUM_COLUMN_DNS = 5;

        public long insert(String name, String capacity, String maxrw, String price, String dns){
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_CAPACITY, capacity);
            cv.put(COLUMN_MAXRW, maxrw);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<HDD> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<HDD> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                    String maxrw= cursor.getString(NUM_COLUMN_MAXRW);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new HDD(id,name,capacity,maxrw,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public HDD select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            HDD out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                String maxrw= cursor.getString(NUM_COLUMN_MAXRW);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new HDD(id,name,capacity,maxrw,price,dns);
            }
            cursor.close();
            return out;
        }
    }

    public class SSDTable implements Selectable<SSD>{
        private static final String TABLE_NAME = "SSD";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_CAPACITY = "Capacity";
        private static final String COLUMN_WRITING_SPEED = "Writing_speed";
        private static final String COLUMN_READING_SPEED = "Reading_speed";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPACITY = 2;
        private static final int NUM_COLUMN_WRITING_SPEED = 3;
        private static final int NUM_COLUMN_READING_SPEED = 4;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;

        public long insert(String name, String capacity, String writing_speed, String reading_speed, String price, String dns){
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_CAPACITY, capacity);
            cv.put(COLUMN_WRITING_SPEED, writing_speed);
            cv.put(COLUMN_READING_SPEED, reading_speed);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<SSD> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<SSD> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                    String writing_speed= cursor.getString(NUM_COLUMN_WRITING_SPEED);
                    String reading_speed = cursor.getString(NUM_COLUMN_READING_SPEED);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new SSD(id,name,capacity,writing_speed,reading_speed,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public SSD select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            SSD out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                String writing_speed= cursor.getString(NUM_COLUMN_WRITING_SPEED);
                String reading_speed = cursor.getString(NUM_COLUMN_READING_SPEED);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new SSD(id,name,capacity,writing_speed,reading_speed,price,dns);
            }
            cursor.close();
            return out;
        }
    }

    public class M2Table implements Selectable<M2>{
        private static final String TABLE_NAME = "M2";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_WRITING_SPEED = "Writing_speed";
        private static final String COLUMN_READING_SPEED = "Reading_speed";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_CAPACITY = "Capacity";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPACITY = 2;
        private static final int NUM_COLUMN_WRITING_SPEED = 3;
        private static final int NUM_COLUMN_READING_SPEED = 4;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;

        public long insert(String name, String capacity, String writing_speed, String reading_speed, String price, String dns){
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_CAPACITY, capacity);
            cv.put(COLUMN_WRITING_SPEED, writing_speed);
            cv.put(COLUMN_READING_SPEED, reading_speed);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<M2> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<M2> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                    String writing_speed= cursor.getString(NUM_COLUMN_WRITING_SPEED);
                    String reading_speed = cursor.getString(NUM_COLUMN_READING_SPEED);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new M2(id,name,capacity,writing_speed,reading_speed,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public M2 select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            M2 out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                String writing_speed= cursor.getString(NUM_COLUMN_WRITING_SPEED);
                String reading_speed = cursor.getString(NUM_COLUMN_READING_SPEED);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new M2(id,name,capacity,writing_speed,reading_speed,price,dns);
            }
            cursor.close();
            return out;
        }
    }
    public class videoCardsTable implements Selectable<video_cards>{
        private static final String TABLE_NAME = "video_cards";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_CAPASITY = "Capasity";
        private static final String COLUMN_TYPECAPASITY = "TypeCapasity";
        private static final String COLUMN_FREQUENCY = "Frequency";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPASITY = 2;
        private static final int NUM_COLUMN_TYPECAPASITY = 3;
        private static final int NUM_COLUMN_FREQUENCY = 4;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;

        public long insert(String name, String сapasity, String typecapasity, String frequency, String price, String dns){
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_CAPASITY, сapasity);
            cv.put(COLUMN_TYPECAPASITY, typecapasity);
            cv.put(COLUMN_FREQUENCY, frequency);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<video_cards> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<video_cards> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String сapasity = cursor.getString(NUM_COLUMN_CAPASITY);
                    String typecapasity= cursor.getString(NUM_COLUMN_TYPECAPASITY);
                    String frequency = cursor.getString(NUM_COLUMN_FREQUENCY);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new video_cards(id,name,сapasity,typecapasity,frequency,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public video_cards select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            video_cards out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String сapasity = cursor.getString(NUM_COLUMN_CAPASITY);
                String typecapasity= cursor.getString(NUM_COLUMN_TYPECAPASITY);
                String frequency = cursor.getString(NUM_COLUMN_FREQUENCY);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new video_cards(id,name,сapasity,typecapasity,frequency,price,dns);
            }
            cursor.close();
            return out;
        }
    }

    public class BodyTable implements Selectable<Body>{
        private static final String TABLE_NAME = "Body";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_FORM_FACRORS = "form_facrors";
        private static final String COLUMN_FORM = "form";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_FORM_FACRORS = 3;
        private static final int NUM_COLUMN_FORM = 4;
        private static final int NUM_COLUMN_PRICE = 2;
        private static final int NUM_COLUMN_DNS = 5;

        public long insert(String name, String form_facrors, String form, String price, String dns){
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_FORM_FACRORS, form_facrors);
            cv.put(COLUMN_FORM, form);
            cv.put(COLUMN_PRICE, price);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<Body> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<Body> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String form_facrors= cursor.getString(NUM_COLUMN_FORM_FACRORS);
                    String form = cursor.getString(NUM_COLUMN_FORM);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new Body(id,name,form,form_facrors,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public Body select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            Body out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String form_facrors= cursor.getString(NUM_COLUMN_FORM_FACRORS);
                String form = cursor.getString(NUM_COLUMN_FORM);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new Body(id,name,form,form_facrors,price,dns);
            }
            cursor.close();
            return out;
        }
    }

    public class RAMTable implements Selectable<RAM>{
        private static final String TABLE_NAME = "RAM";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_CAPACITY = "Capacity";
        private static final String COLUMN_RAM_SPEED = "RAM_Speed";
        private static final String COLUMN_NUMBER_OF_MODULES = "Number_of_modules";
        private static final String COLUMN_PRICE = "Price";
        private static final String COLUMN_DNS = "DNS";
        private static final String COLUMN_RAMTYPE = "RAMType";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_CAPACITY = 2;
        private static final int NUM_COLUMN_RAM_SPEED = 3;
        private static final int NUM_COLUMN_NUMBER_OF_MODULES = 4;
        private static final int NUM_COLUMN_PRICE = 5;
        private static final int NUM_COLUMN_DNS = 6;
        private static final int NUM_COLUMN_RAMTYPE = 7;

        public long insert(String name, String capacity, String ram_speed, String number_of_modules, String price, String dns, String ramtype){
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

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<RAM> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<RAM> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                    String ram_speed= cursor.getString(NUM_COLUMN_RAM_SPEED);
                    String number_of_modules= cursor.getString(NUM_COLUMN_NUMBER_OF_MODULES);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    String ramtype = cursor.getString(NUM_COLUMN_RAMTYPE);
                    arr.add(new RAM(id,name,capacity,ram_speed,number_of_modules,price,dns,ramtype));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public RAM select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            RAM out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String capacity = cursor.getString(NUM_COLUMN_CAPACITY);
                String ram_speed= cursor.getString(NUM_COLUMN_RAM_SPEED);
                String number_of_modules= cursor.getString(NUM_COLUMN_NUMBER_OF_MODULES);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                String ramtype = cursor.getString(NUM_COLUMN_RAMTYPE);
                out = new RAM(id,name,capacity,ram_speed,number_of_modules,price,dns,ramtype);
            }
            cursor.close();
            return out;
        }
    }

    public class CoolersTable implements Selectable<Coolers>{
        private static final String TABLE_NAME = "Coolers";

        private static final String COLUMN_ID= "id";
        private static final String COLUMN_NAME= "Name";
        private static final String COLUMN_FAN_SIZE = "Fan_size";
        private static final String COLUMN_MAXIMUM_VOLUME = "maximum_Volume";
        private static final String COLUMN_DNS = "DNS";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_NAME = 1;
        private static final int NUM_COLUMN_FAN_SIZE = 2;
        private static final int NUM_COLUMN_MAXIMUM_VOLUME = 3;
        private static final int NUM_COLUMN_PRICE = 3;
        private static final int NUM_COLUMN_DNS = 4;

        public long insert(String name, String fan_size, String maximum_volume, String dns){
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            cv.put(COLUMN_FAN_SIZE, fan_size);
            cv.put(COLUMN_MAXIMUM_VOLUME, maximum_volume);
            cv.put(COLUMN_DNS, dns);
            return database.insert(TABLE_NAME, null, cv);
        }

        public void deleteall(){
            database.delete(TABLE_NAME, null, null);
        }

        public ArrayList<Coolers> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<Coolers> arr = new ArrayList<>();
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    int id = cursor.getInt(NUM_COLUMN_ID);
                    String name = cursor.getString(NUM_COLUMN_NAME);
                    String fan_size = cursor.getString(NUM_COLUMN_FAN_SIZE);
                    String maximum_volume= cursor.getString(NUM_COLUMN_MAXIMUM_VOLUME);
                    String price= cursor.getString(NUM_COLUMN_PRICE);
                    String dns= cursor.getString(NUM_COLUMN_DNS);
                    arr.add(new Coolers(id,name,fan_size,maximum_volume,price,dns));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;

        }

        public Coolers select(int id){
            Cursor cursor = database.query(TABLE_NAME, null, COLUMN_ID + " =?",
                    new String[]{String.valueOf(id)}, null, null, null);

            Coolers out = null;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                String name = cursor.getString(NUM_COLUMN_NAME);
                String fan_size = cursor.getString(NUM_COLUMN_FAN_SIZE);
                String maximum_volume= cursor.getString(NUM_COLUMN_MAXIMUM_VOLUME);
                String price= cursor.getString(NUM_COLUMN_PRICE);
                String dns= cursor.getString(NUM_COLUMN_DNS);
                out = new Coolers(id,name,fan_size,maximum_volume,price,dns);
            }
            cursor.close();
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
