package com.meteoru.kalei.foodslist;

import android.app.Application;

import com.parse.Parse;

public class FoodsListApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "yaKGnpPhnNzU0yw4gqStXRAJTGkD4VCwGgoqdQjx", "z5GYmUxBiWFb93YfWKDYQuza0xQ4MvlPxOWRNfoG");

    }
}
