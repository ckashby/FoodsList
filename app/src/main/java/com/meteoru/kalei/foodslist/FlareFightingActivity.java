package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add a Note or Recipe?", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvFlareFightingIntro = (TextView) findViewById(R.id.tvFlareFightingIntro);
        tvFlareFightingHtml = (TextView) findViewById(R.id.tvFlareFightingHtml);

        String htmlAsString = getString(R.string.flare_fighting_foods_html);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString);

        tvFlareFightingHtml.setText(htmlAsSpanned);


    }

}
