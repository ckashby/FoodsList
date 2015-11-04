package com.meteoru.kalei.foodslist;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    TextView tvName;
    TextView tvDescription;
    TextView tvFriendlyTitle;
    TextView tvFriendlyText;
    TextView tvTryItTitle;
    TextView tvTryItText;
    TextView tvCautionTitle;
    TextView tvCautionText;

    Food food;

    public static Fragment newInstance(Food foodItem){
        Fragment detailsFragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ProductMenuActivity.ITEM_EXTRA, foodItem);
        detailsFragment.setArguments(args);
        return detailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        food = getArguments().getParcelable(ProductMenuActivity.ITEM_EXTRA);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.content_details, container, false);
        tvName = (TextView) layout.findViewById(R.id.tvName);
        tvDescription = (TextView) layout.findViewById(R.id.tvDescription);
        tvFriendlyTitle = (TextView) layout.findViewById(R.id.tvFriendlyTitle);
        tvFriendlyText = (TextView) layout.findViewById(R.id.tvFriendlyText);
        tvTryItTitle = (TextView) layout.findViewById(R.id.tvTryItTitle);
        tvTryItText = (TextView) layout.findViewById(R.id.tvTryItText);
        tvCautionTitle = (TextView) layout.findViewById(R.id.tvCautionTitle);
        tvCautionText = (TextView) layout.findViewById(R.id.tvCautionText);

        tvName.setText(food.getName());
        tvDescription.setText(food.getDescription());
        tvFriendlyText.setText(food.getFriendly());
        tvTryItText.setText(food.getTryit());
        tvCautionText.setText(food.getCaution());

        if (food.getFriendly() == null || food.getFriendly().trim().isEmpty()){
            tvFriendlyTitle.setVisibility(TextView.GONE);
            tvFriendlyText.setVisibility(TextView.GONE);
        }

        if (food.getTryit() != null && !food.getTryit().trim().isEmpty()){
            tvTryItTitle.setVisibility(TextView.VISIBLE);
            tvTryItText.setVisibility(TextView.VISIBLE);
        }

        if (food.getCaution() == null || food.getCaution().trim().isEmpty()){
            tvCautionTitle.setVisibility(TextView.GONE);
            tvCautionText.setVisibility(TextView.GONE);
        }

        return layout;
    }
}
