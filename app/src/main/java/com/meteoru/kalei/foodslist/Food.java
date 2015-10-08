package com.meteoru.kalei.foodslist;

import android.util.Log;

public class Food {
    private String mObjectId;
    private String mName;
    private String mDescription;
    private String mCategory;
    private String mFriendly;
    private String mTryIt;
    private String mCaution;

    public Food(String objectId, String name, String description, String category, String friendly, String tryit, String caution) {
        this.mObjectId = objectId;
        this.mName = name;
        this.mDescription = description;
        this.mCategory = category;
        this.mFriendly = friendly;
        this.mTryIt = tryit;
        this.mCaution = caution;

        Log.d("Food", "Creating food with " + category + " category");
    }

    @Override
    public String toString() {
        return mName;
    }

    public String getObjectId() {
        return mObjectId;
    }

    public void setObjectId(String objectId) {
        this.mObjectId = objectId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getFriendly() {
        return mFriendly;
    }

    public void setFriendly(String friendly) {
        this.mFriendly = friendly;
    }

    public String getTryit() {
        return mTryIt;
    }

    public void setTryit(String tryit) {
        this.mTryIt = tryit;
    }

    public String getCaution() {
        return mCaution;
    }

    public void setCaution(String caution) {
        this.mCaution = caution;
    }
}
