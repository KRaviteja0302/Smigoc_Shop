package com.example.smigoc_shop.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smigoc_shop.AppLoader;
import com.example.smigoc_shop.db.Category;
import com.example.smigoc_shop.network.ApiRequest;

import java.util.List;

public class FragmentHomeviewmodel extends BaseViewModel {

    private MutableLiveData<List<Category>> categorylist;

    public FragmentHomeviewmodel() {
    }

    public MutableLiveData<List<Category>> getCategorylist(){
        if(categorylist==null)
            categorylist = new MutableLiveData<>();
        return categorylist;
    }

    public void loadCatList(Context context){
        AppLoader.getDBClient(context).categoryDao().getLiveCategoryList().compose(ApiRequest.applyObservableAsync()).subscribe(list->{
            categorylist.setValue(list);
        }, err-> err.printStackTrace());

    }
}
