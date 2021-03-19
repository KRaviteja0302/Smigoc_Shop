package com.example.smigoc_shop.models;

import java.util.List;

public class GetItems extends BaseResponse {
    List<Categories> categories;
    List<Items> items;

    public List<Categories> getCategories() {
        return categories;
    }

    public List<Items> getItems() {
        return items;
    }
}
