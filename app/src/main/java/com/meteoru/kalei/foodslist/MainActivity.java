package com.meteoru.kalei.foodslist;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvMainMenu;
    DbHelper dbHelper;
    SQLiteDatabase database;
    List<Food> alData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMainMenu = (ListView) findViewById(R.id.lvMainMenu);
        dbHelper = new DbHelper(this);
        alData = dbHelper.getAllFood();
        if (alData.size() == 0){
            Log.d("MAINACTIVITY", "query parse");
            queryParse();
        } else {
            Log.d("MAINACTIVTY", "setup ArrayAdapter");
            ArrayAdapter<Food> aLvMainMenu = new ArrayAdapter<Food>(
                    MainActivity.this, android.R.layout.simple_list_item_1, alData);
            lvMainMenu.setAdapter(aLvMainMenu);
        }
    }

    public void queryParse(){
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Food");
        parseQuery.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> list, ParseException e) {
                Log.d("MAINMENU", "Finished query");
                if (e == null) {
                    for (int i = 0; i < list.size(); i++){
                        dbHelper.insertFood(list.get(i));
                    }
                    alData = dbHelper.getAllFood();
                    ArrayAdapter<Food> aLvMainMenu = new ArrayAdapter<Food>(
                            MainActivity.this, android.R.layout.simple_list_item_1, alData);
                    lvMainMenu.setAdapter(aLvMainMenu);
                }
            }
        });
    }
}
