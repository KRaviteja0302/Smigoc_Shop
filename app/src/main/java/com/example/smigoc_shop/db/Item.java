package com.example.smigoc_shop.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey(autoGenerate = true)
    public Integer itemId;
    public String itemName;
    public Integer catId;
    public Double price;
    public Double salePrice;

    public Item(String itemName, Integer catId, Double price, Double salePrice) {
        this.itemName = itemName;
        this.catId = catId;
        this.price = price;
        this.salePrice = salePrice;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getCatId() {
        return catId;
    }

    public Double getPrice() {
        return price;
    }

    public Double getSalePrice() {
        return salePrice;
    }
}
