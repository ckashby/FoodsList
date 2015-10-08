package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ProductMenuActivity extends AppCompatActivity {
    public static String CATEGORY_EXTRA = "category_extra";

    List<Food> productList;
    ListView lvProducts;
    ArrayAdapter<Food> aLvProducts;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvProducts = (ListView) findViewById(R.id.productListView);
        String category = getIntent().getStringExtra(CATEGORY_EXTRA);
        dbHelper = new DbHelper(this);
        productList = dbHelper.getFoodsByCategory(category);
        aLvProducts = new ArrayAdapter<Food>(
                this, R.layout.food_item_layout, R.id.tvFoodListView, productList);
        lvProducts.setAdapter(aLvProducts);

    }

}
