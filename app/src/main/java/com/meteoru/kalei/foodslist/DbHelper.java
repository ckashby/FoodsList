package com.meteoru.kalei.foodslist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "foods";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_NAME = "food";
    public static final String COL_OBJECT_ID = "objectId";
    public static final String COL_NAME = "name";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_CATEGORY = "category";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE " + TABLE_NAME
                + " ( objectId TEXT PRIMARY KEY, " +
                "name TEXT, description TEXT, category TEXT, friendly TEXT, try TEXT, caution TEXT)";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgradeQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(upgradeQuery);
        onCreate(db);
    }

    public void insertFood(ParseObject foodObject){
        ContentValues values = new ContentValues();
        values.put("objectId", foodObject.getString("objectId"));
        values.put("name", foodObject.getString("name"));
        values.put("description", foodObject.getString("description"));
        values.put("category", foodObject.getString("category"));
        values.put("friendly", foodObject.getString("friendly"));
        values.put("try", foodObject.getString("try"));
        values.put("caution", foodObject.getString("caution"));

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("food", null, values);
        db.close();
    }

    public List<Food> getAllFood(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Food> allFoods = new ArrayList<Food>();
        Cursor cursor = db.query("food", new String[] {"objectId", "name", "description", "category", "friendly", "try", "caution"}, null, null, null, null, null );
        if (cursor.moveToFirst()) {
            do {
                String objectId = cursor.getString(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                String category = cursor.getString(3);
                String friendly = cursor.getString(4);
                String tryit = cursor.getString(5);
                String caution = cursor.getString(6);
                allFoods.add(new Food(objectId, name, category, description, friendly, tryit, caution));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return allFoods;
    }

}
