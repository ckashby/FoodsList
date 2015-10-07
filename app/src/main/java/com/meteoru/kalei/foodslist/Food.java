package com.meteoru.kalei.foodslist;

public class Food {
    public String objectId;
    public String name;
    public String description;
    public String category;
    public String friendly;
    public String tryit;
    public String caution;

    public Food(String objectId, String name, String description, String category, String friendly, String tryit, String caution) {
        this.objectId = objectId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.friendly = friendly;
        this.tryit = tryit;
        this.caution = caution;
    }

    @Override
    public String toString() {
        return category;

//        return super.toString();
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFriendly() {
        return friendly;
    }

    public void setFriendly(String friendly) {
        this.friendly = friendly;
    }

    public String getTryit() {
        return tryit;
    }

    public void setTryit(String tryit) {
        this.tryit = tryit;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }
}
