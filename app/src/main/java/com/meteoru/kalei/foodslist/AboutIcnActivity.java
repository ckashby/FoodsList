package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;

public class AboutIcnActivity extends AppCompatActivity {
    TextView tvAboutIcnIntro;
    WebView wvAboutIcnHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_icn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvAboutIcnIntro = (TextView) findViewById(R.id.tvAboutIcn);
        WebView wvAboutIcnHtml = (WebView) findViewById(R.id.wvAboutIcn);


    }

}
