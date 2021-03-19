package com.example.smigoc_shop.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    public Integer catId;
    public String catName;
    public Integer parentId;

    public Category(String catName, Integer parentId) {
        this.catName = catName;
        this.parentId = parentId;
    }

    public Integer getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public Integer getParentId() {
        return parentId;
    }
}
