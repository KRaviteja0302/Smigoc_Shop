package com.example.smigoc_shop.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.smigoc_shop.AppLoader;
import com.example.smigoc_shop.models.LoginRequest;
import com.example.smigoc_shop.models.LoginResopnse;
import com.example.smigoc_shop.network.ApiRequest;
import com.example.smigoc_shop.utils.IApiListener;

public class Login_ViewModel extends BaseViewModel {
    private MutableLiveData<LoginRequest> user;
    public MutableLiveData<String> mobileno = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();


    public MutableLiveData<LoginRequest> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();

        }
        return user;

    }

    public void onclick(View view) {
        LoginRequest loginRequest = new LoginRequest(mobileno.getValue(), password.getValue());
        user.setValue(loginRequest);
    }

    public void userLogin(String token,LoginRequest login, IApiListener<LoginResopnse> listener) {
              AppLoader.getRetrofit().validateLogin(token,login)
                .compose(ApiRequest.applyObservableAsync())
                .subscribe(result -> {
                    listener.onSuccess(result);
                }, error -> {
                    listener.onFailure( error);
                });
    }
}
