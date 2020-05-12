package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

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
//        this.database = openHelper.getWritableDatabase();
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

        public ArrayList<com.example.myapplication.BP> selectAll(){
            Cursor cursor = database.query(TABLE_NAME, null, null,
                    null, null, null, null);

            ArrayList<com.example.myapplication.BP> arr = new ArrayList<>();
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

        private String DATABASE_PATH = "/data/data/com.example.myapplication/databases/";
        private Context myContext;

        public OpenHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            myContext = context;
        }

        public void createDatabase() throws IOException
        {

            boolean dbExist = checkDataBase();

            if(dbExist)
            {
                Log.v("DB Exists", "db exists");
                openDatabase();
            }

            boolean dbExist1 = checkDataBase();
            if(!dbExist1)
            {
                this.getReadableDatabase();
                try
                {
                    this.close();
                    copyDataBase();
                }
                catch (IOException e)
                {
                    throw new Error("Error copying database");
                }
            }

        }
        //Check database already exist or not
        private boolean checkDataBase()
        {
            boolean checkDB = false;
            try
            {
                String myPath = DATABASE_PATH + DATABASE_NAME;
                File dbfile = new File(myPath);
                checkDB = dbfile.exists();
            }
            catch(SQLiteException e)
            {
            }
            return checkDB;
        }
        //Copies your database from your local assets-folder to the just created empty database in the system folder
        private void copyDataBase() throws IOException
        {

            InputStream mInput = myContext.getAssets().open(DATABASE_NAME);
            String outFileName = DATABASE_PATH + DATABASE_NAME;
            OutputStream mOutput = new FileOutputStream(outFileName);
            byte[] mBuffer = new byte[2024];
            int mLength;
            while ((mLength = mInput.read(mBuffer)) > 0) {
                mOutput.write(mBuffer, 0, mLength);
            }
            mOutput.flush();
            mOutput.close();
            mInput.close();
        }
        //delete database
        public void db_delete()
        {
            File file = new File(DATABASE_PATH + DATABASE_NAME);
            if(file.exists())
            {
                file.delete();
                System.out.println("delete database file.");
            }
        }
        //Open database
        public void openDatabase() throws SQLException
        {
            String myPath = DATABASE_PATH + DATABASE_NAME;
            database = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        }

        public synchronized void closeDataBase()throws SQLException
        {
            if(database != null)
                database.close();
            super.close();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                createDatabase();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            String query = "CREATE TABLE " + BPTable.TABLE_NAME + " (" +
////                    BPTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
////                    BPTable.COLUMN_NAME + " TEXT NOT NULL, " +
////                    BPTable.COLUMN_TYPE + " TEXT NOT NULL," +
////                    BPTable.COLUMN_POWER + " TEXT NOT NULL,"+
////                    BPTable.COLUMN_PRICE + " TEXT NOT NULL," +
////                    BPTable.COLUMN_DNS + " TEXT NOT NULL);";
////
////            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + BPTable.TABLE_NAME); ///11 таблиц
            onCreate(db);
        }
    }

}
