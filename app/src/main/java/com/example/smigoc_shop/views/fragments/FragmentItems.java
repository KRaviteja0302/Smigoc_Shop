package com.example.smigoc_shop.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.smigoc_shop.Adapters.ListCategoryAdapter;
import com.example.smigoc_shop.R;
import com.example.smigoc_shop.databinding.FragmentHomeBinding;
import com.example.smigoc_shop.databinding.FragmentItemsBinding;
import com.example.smigoc_shop.db.Item;
import com.example.smigoc_shop.viewModel.FragmentHomeviewmodel;
import com.example.smigoc_shop.viewModel.FragmentItemsviewmodel;

import java.util.ArrayList;
import java.util.List;

public class FragmentItems extends BaseFragment<FragmentItemsBinding, FragmentItemsviewmodel> {
    List<Item> itemList;
    ListCategoryAdapter itemadapter;
    int catId;




    @Override
    protected void onCreateDone(Bundle savedInstanceState) {


        catId = Integer.parseInt(FragmentItemsArgs.fromBundle(getArguments()).getId());
        itemList = new ArrayList<>();
        itemadapter = new ListCategoryAdapter(itemList, getActivity());

        viewModel.getItemlivedata().observe(getActivity(), list -> {
            if (itemList == null)
                return;
            itemList.addAll(list);
            viewBinding.listrv.setLayoutManager(new LinearLayoutManager(getActivity()));
            viewBinding.listrv.setAdapter(itemadapter);

        });

        viewModel.loaditemlist(getActivity(), catId);

    }


    @Override
    protected FragmentItemsBinding setLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return FragmentItemsBinding.inflate(getLayoutInflater(), container, false);
    }

    @Override
    protected FragmentItemsviewmodel setViewModel() {
        return new ViewModelProvider(this).get(FragmentItemsviewmodel.class);
    }
}
