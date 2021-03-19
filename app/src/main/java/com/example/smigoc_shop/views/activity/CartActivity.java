package com.example.smigoc_shop.views.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.smigoc_shop.databinding.CartActivityBinding;
import com.example.smigoc_shop.viewModel.CartActivityViewmodel;

public class CartActivity extends BaseActivity<com.example.smigoc_shop.databinding.CartActivityBinding, CartActivityViewmodel> {
    @Override
    protected void onCreateDone(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected Class<CartActivityViewmodel> setViewModel() {
        return CartActivityViewmodel.class;
    }

    @Override
    protected CartActivityBinding setViewBinding() {
        return CartActivityBinding.inflate(getLayoutInflater());
    }
}
