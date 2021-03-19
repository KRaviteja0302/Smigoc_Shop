package com.example.smigoc_shop.viewModel;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.MutableLiveData;

import com.example.smigoc_shop.AppLoader;
import com.example.smigoc_shop.db.Category;
import com.example.smigoc_shop.db.Item;
import com.example.smigoc_shop.network.ApiRequest;

import java.util.List;

public class FragmentItemsviewmodel extends BaseViewModel {


    private MutableLiveData<List<Item>>itemlivedata;

    public MutableLiveData<List<Item>> getItemlivedata() {
        if(itemlivedata==null)
            itemlivedata=new MutableLiveData<>();
        return itemlivedata;
    }

    public void loaditemlist(Context context ,int catid)
    {
        AppLoader.getDBClient(context).itemDao().getCategoryItemList(catid).compose(ApiRequest.applyObservableAsync())
                .subscribe(result->itemlivedata.setValue(result),err->err.printStackTrace());

    }
}
