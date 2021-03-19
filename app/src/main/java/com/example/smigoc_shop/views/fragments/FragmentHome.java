package com.example.smigoc_shop.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smigoc_shop.Adapters.ItemProductAdapter;
import com.example.smigoc_shop.AppLoader;
import com.example.smigoc_shop.databinding.FragmentHomeBinding;
import com.example.smigoc_shop.db.Category;
import com.example.smigoc_shop.db.CategoryDao;
import com.example.smigoc_shop.models.Categories;
import com.example.smigoc_shop.utils.ICartListener;
import com.example.smigoc_shop.viewModel.FragmentHomeviewmodel;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends BaseFragment<FragmentHomeBinding, FragmentHomeviewmodel> implements ItemProductAdapter.ICategoryListener {
    ItemProductAdapter categoryadapter;
    List<Category> categoryList;


    @Override
    protected void onCreateDone(Bundle savedInstanceState) {
        categoryList = new ArrayList<>();
        categoryadapter = new ItemProductAdapter(categoryList, getActivity());
        categoryadapter.setICategoryListener(this);
        viewModel.getCategorylist().observe(this, list -> {
            if (list == null)
                return;
            categoryList.clear();
            categoryList.addAll(list);
            viewBinding.categorieslist.setLayoutManager(new GridLayoutManager(getActivity(),2, RecyclerView.VERTICAL,false));
           viewBinding.categorieslist.setAdapter(categoryadapter);
            showToast(getActivity(), list.size() + "");
        });
        viewModel.loadCatList(getActivity());
    }


    @Override
    protected FragmentHomeBinding setLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return FragmentHomeBinding.inflate(getLayoutInflater(), container, false);

    }

    @Override
    protected FragmentHomeviewmodel setViewModel() {
        return new ViewModelProvider(this).get(FragmentHomeviewmodel.class);
    }

    @Override
    public void onCategorySelected(Category category) {
        FragmentHomeDirections.HomeToItems action = FragmentHomeDirections.homeToItems();
        action.setId(String.valueOf(category.catId));
        Navigation.findNavController(viewBinding.getRoot()).navigate(action);

    }
}
