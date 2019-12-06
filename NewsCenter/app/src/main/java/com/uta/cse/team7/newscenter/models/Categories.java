package com.uta.cse.team7.newscenter.models;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;

import com.uta.cse.team7.newscenter.R;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private Context mContext;

    public Categories(Context context) {
        this.mContext = context;
    }

    public List<CategoryItem> getCategoryItems() {
        List<CategoryItem> categoryItems = new ArrayList<>();

        String[] categoryNames = mContext.getResources().getStringArray(R.array.category_names);
        TypedArray categoryImgs = mContext.getResources().obtainTypedArray(R.array.category_drawables);

        for (int i = 0; i < categoryNames.length; i++) {
            CategoryItem categoryItem = new CategoryItem();
            categoryItem.setCategoryName(categoryNames[i]);
            categoryItem.setCategoryImg(ContextCompat.getDrawable(mContext, categoryImgs.getResourceId(i, -1)));
            categoryItems.add(categoryItem);
        }

        return categoryItems;
    }

    public int getDrawableId(String category) {
        switch (category) {
            case "图书":
                return R.drawable.ic_book_24dp;
            case "商业":
                return R.drawable.ic_business_24dp;
            case "动漫":
                return R.drawable.ic_comics_24dp;
            case "股票":
                return R.drawable.ic_deals_24dp;
            case "经济":
                return R.drawable.ic_economics_24dp;
            case "教育":
                return R.drawable.ic_education_24dp;
            case "娱乐":
                return R.drawable.ic_entertainment_24dp;
            case "时尚":
                return R.drawable.ic_fashion_24dp;
            case "健康":
                return R.drawable.ic_fitness_24dp;
            case "食品":
                return R.drawable.ic_food_24dp;
            case "游戏":
                return R.drawable.ic_gaming_24dp;
            case "硬件":
                return R.drawable.ic_hardware_24dp;
            case "国际":
                return R.drawable.ic_international_24dp;
            case "市场":
                return R.drawable.ic_marketing_24dp;
            case "音乐":
                return R.drawable.ic_music_24dp;
            case "国家":
                return R.drawable.ic_national_24dp;
            case "政治":
                return R.drawable.ic_politics_24dp;
            case "生产":
                return R.drawable.ic_productivity_24dp;
            case "程序":
                return R.drawable.ic_programming_24dp;
            case "研究":
                return R.drawable.ic_research_24dp;
            case "科学":
                return R.drawable.ic_science_24dp;
            case "软件":
                return R.drawable.ic_software_24dp;
            case "太空":
                return R.drawable.ic_space_24dp;
            case "运动":
                return R.drawable.ic_sports_24dp;
            case "科技":
                return R.drawable.ic_technology_24dp;
            case "其他":
                return R.drawable.ic_unknown_24dp;
            default:
                return 0;
        }
    }
}
