package com.uta.cse.team7.newscenter.models;

import android.graphics.drawable.Drawable;

public class CategoryItem {
    private String categoryName;
    private Drawable categoryImg;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Drawable getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(Drawable categoryImg) {
        this.categoryImg = categoryImg;
    }
}
