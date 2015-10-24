package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class WellnessCoachingActivity extends AppCompatActivity {
    TextView tvWellnessCoachingIntro;
    TextView getTvWellnessCoachingHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness_coaching);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvWellnessCoachingIntro = (TextView) findViewById(R.id.tvWellnessCoachingIntro);
        getTvWellnessCoachingHtml = (TextView) findViewById(R.id.tvWellnessCoachingHtml);
        tvWellnessCoachingIntro.setText(getString(R.string.wellnessCoachingIntro));


    }

}
