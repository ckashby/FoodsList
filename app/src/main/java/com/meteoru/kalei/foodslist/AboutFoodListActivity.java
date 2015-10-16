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
    TextView tvAboutFoodListHtml2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_food_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvAboutFoodListIntro = (TextView) findViewById(R.id.tvAboutFoodListIntro);
        tvAboutFoodListHtml = (TextView) findViewById(R.id.tvAboutFoodListHtml);
        tvAboutFoodListHtml2 = (TextView) findViewById(R.id.tvAboutFoodListHtml2);

        String htmlAsString = getString(R.string.about_food_list_html);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString);
        tvAboutFoodListHtml.setText(htmlAsSpanned);

        String htmlAsString2 = getString(R.string.about_food_list_html2);
        Spanned htmlAsSpanned2 = Html.fromHtml(htmlAsString2);
        tvAboutFoodListHtml2.setText(htmlAsSpanned2);

    }

}
