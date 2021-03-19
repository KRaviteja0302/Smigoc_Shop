package com.example.smigoc_shop.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBinding;

import com.example.smigoc_shop.utils.IBaseListener;
import com.example.smigoc_shop.utils.ICartListener;


import java.util.List;

public abstract class BaseFragment<T extends ViewBinding, V extends ViewModel> extends Fragment implements IBaseListener {

    protected T viewBinding;
    protected V viewModel;
    ICartListener iCartListener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = setLayout(inflater, container, savedInstanceState);
        viewModel = setViewModel();
        onCreateDone(savedInstanceState);
        return viewBinding.getRoot();
    }

    protected abstract void onCreateDone(Bundle savedInstanceState);

    protected abstract T setLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected abstract V setViewModel();

    protected void showLoader() {
        showLoader(getActivity().getSupportFragmentManager());
    }

    protected void hideLoader() {
        hideLoader(getActivity().getSupportFragmentManager());
    }

    protected void navigateNext(Class activity) {
        navigateNext(getActivity(), activity);
    }

    protected void navigateNext(Class activity, boolean clear) {
        navigateNext(getActivity(), activity, clear);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
       iCartListener = (ICartListener) context;
    }

//    protected void showAlertOptions(List<ProductType> typeList, IProductTypeListener listener) {
//        String[] titles = new String[typeList.size()];
//        for (int i = 0; i < typeList.size(); i++)
//            titles[i] = typeList.get(i).weight + typeList.get(i).unitCode;
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("SELECT WEIGHT");
//        builder.setItems(titles, (dialog, which) -> {
//            dialog.dismiss();
//            listener.onProductTypeChanged(typeList.get(which));
//        });
//        builder.show();
    //}
}
