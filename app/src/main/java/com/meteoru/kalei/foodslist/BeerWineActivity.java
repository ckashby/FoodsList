package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class BeerWineActivity extends AppCompatActivity {
    TextView tvBeerWineIntro;
    TextView tvBeerWineHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_wine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvBeerWineIntro = (TextView) findViewById(R.id.tvAboutFoodListIntro);
        tvBeerWineHtml = (TextView) findViewById(R.id.tvBeerWineHtml);
    }

}
