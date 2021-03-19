package com.example.smigoc_shop.views.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.smigoc_shop.databinding.ActivityLoginBinding;
import com.example.smigoc_shop.viewModel.Login_ViewModel;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, Login_ViewModel> {

    @Override
    protected void onCreateDone(@Nullable Bundle savedInstanceState) {
        viewBinding.btlogin.setOnClickListener(v -> {
            try {
                navigateNext(this, HomeActivity.class);
            }
        catch (Exception e){
                e.printStackTrace();
        }
        });
    }

    @Override
    protected Class<Login_ViewModel> setViewModel() {
        return Login_ViewModel.class;
    }

    @Override
    protected ActivityLoginBinding setViewBinding() {
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }
}