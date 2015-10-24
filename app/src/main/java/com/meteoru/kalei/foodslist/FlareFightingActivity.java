package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class FlareFightingActivity extends AppCompatActivity {
    TextView tvFlareFightingIntro;
    TextView tvFlareFightingHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flare_fighting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvFlareFightingIntro = (TextView) findViewById(R.id.tvFlareFightingIntro);
        tvFlareFightingHtml = (TextView) findViewById(R.id.tvFlareFightingHtml);

        String htmlAsString = getString(R.string.flare_fighting_foods_html);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString);
        tvFlareFightingHtml.setText(htmlAsSpanned);
    }

}
