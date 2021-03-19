package com.example.smigoc_shop.utils;

public interface IApiListener<T> {
    void  onSuccess(T t);
    void onFailure(Throwable throwable);
}
