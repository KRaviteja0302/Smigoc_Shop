package com.example.smigoc_shop.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.smigoc_shop.AppLoader;
import com.example.smigoc_shop.network.ApiService;


public class BaseViewModel extends ViewModel {


    private ApiService apiService;

    public MutableLiveData<Throwable> throwableMutableLiveData;

    public BaseViewModel() {
       apiService = AppLoader.getRetrofit();
        if (throwableMutableLiveData == null)
            throwableMutableLiveData = new MutableLiveData<>();
    }

    protected ApiService getApiService() {
        return apiService;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
