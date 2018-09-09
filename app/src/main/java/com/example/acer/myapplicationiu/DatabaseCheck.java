package com.example.acer.myapplicationiu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseCheck extends SQLiteAssetHelper {
    private static final String DB_NAME = "projektikosmed.db";
    private static final int DB_VER = 1;
    public DatabaseCheck(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }
    public Cursor data(int numri1, int numri2, int numri3, int numri4)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        Cursor cursor = db.rawQuery("SELECT disease_name, SUM(probabiliteti) FROM diseases, symptom_disease" +
                " WHERE ID = d_id AND s_id IN " + "(" + numri1 + ", " + numri2 + "," + numri3 + ", " + numri4 + ")" + " GROUP BY disease_name ORDER BY SUM(probabiliteti) DESC", null);
        return cursor;

    }
}
