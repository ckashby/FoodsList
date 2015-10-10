package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AboutIcnActivity extends AppCompatActivity {
    TextView tvAboutIcnIntro;
    TextView tvAboutIcnHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_icn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvAboutIcnIntro = (TextView) findViewById(R.id.tvAboutIcn);
        tvAboutIcnHtml = (TextView) findViewById(R.id.tvAboutIcnHtml);

    }

}
