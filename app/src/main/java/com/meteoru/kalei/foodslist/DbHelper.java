package com.meteoru.kalei.foodslist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        Cursor cursor = db.query("food", new String[]{"objectId", "name", "description", "category", "friendly", "try", "caution"}, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int objectIdIdx = cursor.getColumnIndex("objectId");
                String objectId = cursor.getString(objectIdIdx);

                int nameIdx = cursor.getColumnIndex("name");
                String name = cursor.getString(nameIdx);

                int descIdx = cursor.getColumnIndex("description");
                String description = cursor.getString(descIdx);

                int categoryIdx = cursor.getColumnIndex("category");
                String category = cursor.getString(categoryIdx);

                int friendlyIdx = cursor.getColumnIndex("friendly");
                String friendly = cursor.getString(friendlyIdx);

                int tryIdx = cursor.getColumnIndex("try");
                String tryit = cursor.getString(tryIdx);

                int cautionIdx = cursor.getColumnIndex("caution");
                String caution = cursor.getString(cautionIdx);
                Log.d("DbHelper", name + " with category " + category);
                allFoods.add(new Food(objectId, name, description, category, friendly, tryit, caution));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return allFoods;
    }

    public List<String> getMainMenu(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> allFoods = new ArrayList<String>();
        Cursor cursor = db.query(true, "food", new String[]{ "category"}, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int categoryIdx = cursor.getColumnIndex("category");
                String category = cursor.getString(categoryIdx);
                allFoods.add(category);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return allFoods;
    }

    public List<Food> getFoodsByCategory(String category_extra){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Food> productMenu = new ArrayList<Food>();
        Cursor cursor = db.query("food", new String[] {"objectId", "name", "description", "category", "friendly", "try", "caution"}, "WHERE category = ?", new String[] {category_extra}, null, null, null );
        if (cursor.moveToFirst()) {
            do {
                int objectIdIdx = cursor.getColumnIndex("objectId");
                String objectId = cursor.getString(objectIdIdx);

                int nameIdx = cursor.getColumnIndex("name");
                String name = cursor.getString(nameIdx);

                int descIdx = cursor.getColumnIndex("description");
                String description = cursor.getString(descIdx);

                int categoryIdx = cursor.getColumnIndex("category");
                String category = cursor.getString(categoryIdx);

                int friendlyIdx = cursor.getColumnIndex("friendly");
                String friendly = cursor.getString(friendlyIdx);

                int tryIdx = cursor.getColumnIndex("try");
                String tryit = cursor.getString(tryIdx);

                int cautionIdx = cursor.getColumnIndex("caution");
                String caution = cursor.getString(cautionIdx);
                Log.d("DbHelper", name + " with category " + category);
                productMenu.add(new Food(objectId, name, description, category, friendly, tryit, caution));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return productMenu;

    }

}
