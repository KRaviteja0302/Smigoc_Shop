package com.example.smigoc_shop.models;

public class Categories {

String id;
String name;
String parentid;

    public Categories(String id, String name, String parentid) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParentid() {
        return parentid;
    }
}
