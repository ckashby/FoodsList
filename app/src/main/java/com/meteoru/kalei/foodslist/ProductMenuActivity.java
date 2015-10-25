package com.meteoru.kalei.foodslist;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

public class ProductMenuActivity extends AppCompatActivity {
    public static String CATEGORY_EXTRA = "category_extra";
    public static String ITEM_EXTRA = "item_extra";
    private String category;

    List<Food> productList;
    ListView lvProducts;
    ArrayAdapter<Food> aLvProducts;
    DbHelper dbHelper;
    FrameLayout detailsContainer;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(CATEGORY_EXTRA, category);
        if (category == null){
            Log.d("ProductMenuActivity", "Category is Null");
        }
        Log.d("ProductMenuActivity", "outState Function was called");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_menu);
        detailsContainer = (FrameLayout) findViewById(R.id.detailsContainer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvProducts = (ListView) findViewById(R.id.productListView);
        if (savedInstanceState == null) {
            category = getIntent().getStringExtra(CATEGORY_EXTRA);
        } else {
            category = savedInstanceState.getString(CATEGORY_EXTRA);
            Log.d("ProductMenuActivity", category.toString());
        }
        dbHelper = new DbHelper(this);
        productList = dbHelper.getFoodsByCategory(category);

        aLvProducts = new ArrayAdapter<Food>(
                this, R.layout.food_item_layout, R.id.tvFoodListView, productList);
        lvProducts.setAdapter(aLvProducts);
        if (detailsContainer == null) {
            lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Food food = productList.get(position);
                    Intent intent = new Intent(ProductMenuActivity.this, DetailsActivity.class);
                    intent.putExtra(ITEM_EXTRA, food);
                    startActivity(intent);
                }
            });
        } else {
            lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    selectItem(position);
                }
            });
            selectItem(0);
        }
    }

    private void selectItem(int position){
        Food food = productList.get(position);
        Fragment detailsFragment = DetailsFragment.newInstance(food);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.detailsContainer, detailsFragment);
        ft.commit();
    }
}
