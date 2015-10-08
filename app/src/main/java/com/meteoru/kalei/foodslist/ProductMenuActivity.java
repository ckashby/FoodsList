package com.meteoru.kalei.foodslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ProductMenuActivity extends AppCompatActivity {
    public static String CATEGORY_EXTRA = "category_extra";
    public static String ITEM_EXTRA = "item_extra";

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
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = productList.get(position);
                Intent intent = new Intent(ProductMenuActivity.this, DetailsActivity.class);
                intent.putExtra(ITEM_EXTRA, food);
                startActivity(intent);
            }
        });

    }

}
