package com.meteoru.kalei.foodslist;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Food implements Parcelable {
    private String mObjectId;
    private String mName;
    private String mDescription;
    private String mCategory;
    private String mFriendly;
    private String mTryIt;
    private String mCaution;
    public static Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel source) {
            return new Food(source);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public Food(Parcel source) {
        this.mObjectId = source.readString();
        this.mName = source.readString();
        this.mDescription = source.readString();
        this.mFriendly = source.readString();
        this.mTryIt = source.readString();
        this.mCaution = source.readString();
        this.mCategory = source.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mObjectId);
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeString(mFriendly);
        dest.writeString(mTryIt);
        dest.writeString(mCaution);
        dest.writeString(mCategory);

    }
}
