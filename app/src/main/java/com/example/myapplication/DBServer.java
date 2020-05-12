package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
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
