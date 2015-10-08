package com.meteoru.kalei.foodslist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvMainMenu;
    DbHelper dbHelper;
    SQLiteDatabase database;
    List<String> alData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMainMenu = (ListView) findViewById(R.id.lvMainMenu);
        dbHelper = new DbHelper(this);
        alData = dbHelper.getMainMenu();
        if (alData.size() == 0){
            queryParse();
        } else {
            ArrayAdapter aLvMainMenu = new ArrayAdapter(
                    MainActivity.this, android.R.layout.simple_list_item_1, alData);
            lvMainMenu.setAdapter(aLvMainMenu);

        }
    }

    public void queryParse(){
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Food");
        parseQuery.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    Log.d("MainActivity", "Finished query with success response: " + list.size());
                    for (int i = 0; i < list.size(); i++){
                        dbHelper.insertFood(list.get(i));
                    }
                    alData = dbHelper.getMainMenu();
                    ArrayAdapter aLvMainMenu = new ArrayAdapter(
                            MainActivity.this, android.R.layout.simple_list_item_1, alData);
                    lvMainMenu.setAdapter(aLvMainMenu);
                }
            }
        });
    }

    private class FoodAdapter extends BaseAdapter {
        private List<Food> mFoods;
        private Context mContext;
        public FoodAdapter(Context context, List<Food> foods) {
            this.mContext = context;
            this.mFoods = foods;
        }

        @Override
        public int getCount() {
            return mFoods.size();
        }

        @Override
        public Food getItem(int position) {
            return mFoods.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.food_item_layout, parent, false);
            }

            Food item = getItem(position);
            //Log.d("MainActivity", item.category);
            TextView textView = (TextView) convertView.findViewById(R.id.text);
            textView.setText(item.getCategory());

            return convertView;
        }
    }
}
