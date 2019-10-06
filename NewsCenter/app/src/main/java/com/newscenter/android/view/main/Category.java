package com.newscenter.android.view.main;

import com.bignerdranch.expandablerecyclerview.model.SimpleParent;
import com.newscenter.common.StringUtil;
import com.newscenter.model.Subscription;

import java.util.List;

/**
 * @description:
 * @author: Match
 * @date: 8/4/16
 */
public class Category extends SimpleParent<Subscription> {
    private String mName;

    public Category(List<Subscription> childItemList) {
        super(childItemList);
        if (childItemList != null && childItemList.size() != 0 && childItemList.get(0) != null) {
            mName = childItemList.get(0).getCategory();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o.getClass() == Category.class) {
            Category category = (Category) o;
            return StringUtil.equals(category.getName(), getName());
        }
        return false;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return true;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
       mName = name;
    }
}
