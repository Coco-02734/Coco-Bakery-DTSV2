package com.nicofrnds02734.cocobakery.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.nicofrnds02734.cocobakery.Model.ModelTransaksi;

import java.util.ArrayList;
import java.util.HashMap;

public class DataHalperTransaksi extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "data_transaki";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_DATA = "transaksi";
    public static final String KEY_ID = "id";
    public static final String NAMA = "nama";
    public static final String NAMABARANG = "namabarang";
    public static final String HARGA = "harga";
    public static final String ALAMAT = "alamat";
    public static final String CATATAN = "catatan";

    public static final String SQL_TABLE_DATA = " CREATE TABLE " + TABLE_DATA
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + NAMA + " TEXT, "
            + NAMABARANG + " TEXT, "
            + HARGA + " TEXT, "
            +ALAMAT + " TEXT, "
            +CATATAN + " TEXT "
            + " ) ";

    public DataHalperTransaksi(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_TABLE_DATA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA);
    }

    public void TambahData(ModelTransaksi dataModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put(NAMA, dataModel.nama);
        values.put(NAMABARANG, dataModel.namabarang);
        values.put(HARGA, dataModel.harga);
        values.put(ALAMAT, dataModel.alamat);
        values.put(CATATAN, dataModel.catatan);
        long todo_id = db.insert(TABLE_DATA,null, values);
    }
    public ArrayList<HashMap<String, String>> getData() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM " + TABLE_DATA;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(KEY_ID, cursor.getString(0));
                map.put(NAMA, cursor.getString(1));
                map.put(NAMABARANG, cursor.getString(2));
                map.put(HARGA, cursor.getString(3));
                map.put(ALAMAT, cursor.getString(4));
                map.put(CATATAN, cursor.getString(5));
                wordList.add(map);
            } while (cursor.moveToNext());
        }
        Log.e("select sqlite ", "" + wordList);
        database.close();
        return wordList;
    }
}
