package com.meteoru.kalei.foodslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvDescription;
    TextView tvFriendlyTitle;
    TextView tvFriendlyText;
    TextView tvTryItTitle;
    TextView tvTryItText;
    TextView tvCautionTitle;
    TextView tvCautionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvName = (TextView) findViewById(R.id.tvName);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvFriendlyTitle = (TextView) findViewById(R.id.tvFriendlyTitle);
        tvFriendlyText = (TextView) findViewById(R.id.tvFriendlyText);
        tvTryItTitle = (TextView) findViewById(R.id.tvFriendlyTitle);
        tvTryItText = (TextView) findViewById(R.id.tvTryItText);
        tvCautionTitle = (TextView) findViewById(R.id.tvCautionTitle);
        tvCautionText = (TextView) findViewById(R.id.tvCautionText);

        Food food = getIntent().getParcelableExtra(ProductMenuActivity.ITEM_EXTRA);

        tvName.setText(food.getName());
        tvDescription.setText(food.getDescription());
        tvFriendlyText.setText(food.getFriendly());
        tvTryItText.setText(food.getTryit());
        tvCautionText.setText(food.getCaution());

        if (food.getFriendly() == null || food.getFriendly().trim().isEmpty()){
            tvFriendlyTitle.setVisibility(TextView.GONE);
            tvFriendlyText.setVisibility(TextView.GONE);
        }

        if (food.getTryit() == null || food.getTryit().trim().isEmpty()){
            tvTryItTitle.setVisibility(TextView.GONE);
            tvTryItText.setVisibility(TextView.GONE);
        }

        if (food.getCaution() == null || food.getCaution().trim().isEmpty()){
            tvCautionTitle.setVisibility(TextView.GONE);
            tvCautionText.setVisibility(TextView.GONE);
        }
    }

}
