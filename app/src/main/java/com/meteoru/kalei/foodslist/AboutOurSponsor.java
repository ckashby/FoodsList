package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class AboutOurSponsor extends AppCompatActivity {
    TextView tvTitleAboutOurSponsor, tvAboutOurSponsorHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_our_sponsor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTitleAboutOurSponsor = (TextView) findViewById(R.id.tvTitleAboutOurSponsor);
        tvAboutOurSponsorHtml = (TextView) findViewById(R.id.tvAboutOurSponsorHtml);

        String htmlAsString = getString(R.string.about_our_sponsor_html);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString);
        tvAboutOurSponsorHtml.setText(htmlAsSpanned);

    }

}
