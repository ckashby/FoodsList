package com.meteoru.kalei.foodslist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutFoodListActivity extends AppCompatActivity {
    TextView tvAboutFoodListIntro;
    TextView tvAboutFoodListHtml;
    TextView tvAboutFoodListHtml2;
    Button btWebICNetwork;

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
        btWebICNetwork = (Button) findViewById(R.id.btWebICNetwork);

        String htmlAsString = getString(R.string.about_food_list_html);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString);
        tvAboutFoodListHtml.setText(htmlAsSpanned);

        btWebICNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.ic-network.com";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });


        String htmlAsString2 = getString(R.string.about_food_list_html2);
        Spanned htmlAsSpanned2 = Html.fromHtml(htmlAsString2);
        tvAboutFoodListHtml2.setText(htmlAsSpanned2);

    }

}
