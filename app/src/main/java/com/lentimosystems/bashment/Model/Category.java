package com.lentimosystems.bashment.Model;

public class Category {
    Integer id;
    Integer imageUrl;
    String category;

    public Category(Integer id, Integer imageUrl, String category) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
