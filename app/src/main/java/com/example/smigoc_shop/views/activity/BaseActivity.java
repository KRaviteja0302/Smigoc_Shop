package com.example.smigoc_shop.views.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.smigoc_shop.utils.AppManagerDreamHome;
import com.example.smigoc_shop.utils.IBaseListener;


public abstract class BaseActivity<VB extends ViewBinding, VM extends ViewModel> extends AppCompatActivity implements IBaseListener {

    protected VB viewBinding;
    protected VM viewModel;
    AppManagerDreamHome appManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewBinding = setViewBinding();
        setContentView(this.viewBinding.getRoot());
        this.viewModel = new ViewModelProvider(this).get(setViewModel());
        appManager = new AppManagerDreamHome(this);
        onCreateDone(savedInstanceState);
    }

    protected abstract void onCreateDone(@Nullable Bundle savedInstanceState);

    protected abstract Class<VM> setViewModel();

    protected abstract VB setViewBinding();
    protected void navigateNext(Class activity, boolean clear) {
        navigateNext(this, activity, clear);
    }
}
