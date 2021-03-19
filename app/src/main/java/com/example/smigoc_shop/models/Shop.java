package com.example.smigoc_shop.models;

public class Shop {
String shopname;
String mobile;
String address;
String shopid;

    public Shop(String shopname, String mobile, String address, String shopid) {
        this.shopname = shopname;
        this.mobile = mobile;
        this.address = address;
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getShopid() {
        return shopid;
    }
}



