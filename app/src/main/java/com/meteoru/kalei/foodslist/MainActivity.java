package com.meteoru.kalei.foodslist;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ListView lvMainMenu;
    DbHelper dbHelper;
    List<String> alData;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMainMenu = (ListView) findViewById(R.id.lvMainMenu);
        lvMainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ProductMenuActivity.class);
                intent.putExtra(ProductMenuActivity.CATEGORY_EXTRA, alData.get(position));
                startActivity(intent);
            }
        });
        dbHelper = new DbHelper(this);
        alData = dbHelper.getMainMenu();
        if (alData.size() == 0){
            if (!Util.isConnectedToInternet(this)) {
                Util.noInternetDialog(this).show();
                return;
            } 
            queryParse();
        } else {
            ArrayAdapter aLvMainMenu = new ArrayAdapter(
                    MainActivity.this, R.layout.food_item_layout, R.id.tvFoodListView, alData);
            lvMainMenu.setAdapter(aLvMainMenu);
        }
    }

    public void queryParse(){
        progressDialog = ProgressDialog.show(this, getString(R.string.title_progress_bar), "");
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Food");
        parseQuery.setLimit(500);
        parseQuery.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> list, ParseException e) {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
                if (e == null) {
                    Log.d(TAG, "Finished query with successfull response: " + list.size());
                    for (int i = 0; i < list.size(); i++){
                        dbHelper.insertFood(list.get(i));
                    }
                    alData = dbHelper.getMainMenu();
                    ArrayAdapter aLvMainMenu = new ArrayAdapter(
                            MainActivity.this, R.layout.food_item_layout, R.id.tvFoodListView, alData);
                    lvMainMenu.setAdapter(aLvMainMenu);
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.title_progress_parse_unavailable),
                            Toast.LENGTH_LONG).show();
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

    public void goPrelief(View view) {
        String preliefUrl = "http://www.prelief.com/";
        Uri webpage = Uri.parse(preliefUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void goIcn(View view) {
        String preliefUrl = "http://www.ic-network.com/";
        Uri webpage = Uri.parse(preliefUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Launch selected Activity from the drop down menu
        switch (item.getItemId()){
            case R.id.action_flare_fighting:
                goFlareFighting();
                return true;
            case R.id.action_about_foodlist:
                goAboutFoodList();
                return true;
            case R.id.action_wellness:
                goWellness();
                return true;
            case R.id.action_about_icn:
                goAboutIcn();
                return true;
            case R.id.action_about_our_sponsor:
                goAboutOurSponsor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goFlareFighting(){
        Intent i = new Intent(this, FlareFightingActivity.class);
        startActivity(i);
    }

    private void goAboutIcn(){
        Intent i = new Intent(this, AboutIcnActivity.class);
        startActivity(i);
    }

    private void goWellness(){
        Intent i = new Intent(this, WellnessCoachingActivity.class);
        startActivity(i);
    }

    private void goAboutFoodList(){
        Intent i = new Intent(this, AboutFoodListActivity.class);
        startActivity(i);
    }

    private void goAboutOurSponsor() {
        Intent i = new Intent(this, AboutOurSponsor.class);
        startActivity(i);
    }
}
