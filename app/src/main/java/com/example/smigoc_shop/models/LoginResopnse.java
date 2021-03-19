package com.example.smigoc_shop.models;

public class LoginResopnse extends BaseResponse{
    Jwt jwt;
    Shop shop;
    LoginRequest request;

    public LoginRequest getRequest() {
        return request;
    }

    public Jwt getJwt() {
        return jwt;
    }

    public Shop getShop() {
        return shop;
    }
}
