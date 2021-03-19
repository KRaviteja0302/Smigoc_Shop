package com.example.smigoc_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smigoc_shop.utils.ICartListener;

public class MainActivity extends AppCompatActivity implements ICartListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}