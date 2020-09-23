package com.lentimosystems.bashment.Model;

import android.graphics.drawable.Drawable;

public class RecentlyViewed {
    String name, price, quantity, unit;
    int imageUrl;
    int bgImageUrl;

    public RecentlyViewed(String name, String price, String quantity, String unit, int imageUrl, int bgImageUrl) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.imageUrl = imageUrl;
        this.bgImageUrl = bgImageUrl;
    }

    public int getBgImageUrl() {
        return bgImageUrl;
    }

    public void setBgImageUrl(int bgImageUrl) {
        this.bgImageUrl = bgImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
