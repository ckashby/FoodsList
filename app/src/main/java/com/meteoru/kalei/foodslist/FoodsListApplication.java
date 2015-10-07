package com.meteoru.kalei.foodslist;

import android.app.Application;

import com.parse.Parse;

public class FoodsListApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "jVzr7SonnzcbcFQa7jVbCx1mgqDa6G46HXSw7Qsi", "JSv0KV9ya59AyIbsdjcUzmMjfoYGyvdi7w148T7N");

    }
}
