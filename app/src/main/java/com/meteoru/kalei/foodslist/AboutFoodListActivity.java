package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class AboutFoodListActivity extends AppCompatActivity {
    TextView tvAboutFoodListIntro;
    TextView tvAboutFoodListHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_food_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvAboutFoodListIntro = (TextView) findViewById(R.id.tvAboutFoodListIntro);
        tvAboutFoodListHtml = (TextView) findViewById(R.id.tvAboutFoodListHtml);

        String htmlAsString = getString(R.string.about_icn_html);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString);
        tvAboutFoodListHtml.setText(htmlAsSpanned);

    }

}
