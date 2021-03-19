package com.example.smigoc_shop.views.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smigoc_shop.AppLoader;
import com.example.smigoc_shop.R;
import com.example.smigoc_shop.databinding.CategorySaveBinding;
import com.example.smigoc_shop.db.Category;
import com.example.smigoc_shop.db.CategoryDao;
import com.example.smigoc_shop.network.ApiRequest;
import com.example.smigoc_shop.viewModel.CategorysaveViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class CategorySave extends BaseActivity<CategorySaveBinding, CategorysaveViewModel> {

    CategoryDao catDao;
    ArrayList<Category> categoryList;
    CatAdapter catAdapter;

    @Override
    protected void onCreateDone(@Nullable Bundle savedInstanceState) {
        catDao = AppLoader.getDBClient(this).categoryDao();
        categoryList = new ArrayList<>();

        catAdapter = new CatAdapter(this, R.layout.spinner_item,categoryList);
        viewBinding.spnCats.setAdapter(catAdapter);
        viewBinding.spnCats.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        viewBinding.btlogin.setOnClickListener(v -> {
            Category category = new Category(viewBinding.etcatename.getText().toString().trim(), categoryList.get(viewBinding.spnCats.getSelectedItemPosition()).parentId);
            Observable.fromCallable(() -> catDao.saveCategory(category))
                    .compose(ApiRequest.applyObservableAsync())
                    .subscribe(result->{
                        showToast(getApplicationContext(), "ID saved: "+result);
                        loadParentCategory();
                        viewBinding.etcatename.setText("");
                    }, err->{err.printStackTrace();});
            ;
        });
        loadParentCategory();
    }

    private void loadParentCategory(){
        catDao.getCategoryList().compose(ApiRequest.applyObservableAsync()).subscribe(result->{
            categoryList.clear();
            categoryList.add(new Category("No Parent", 0));
            categoryList.addAll(result);
            catAdapter.notifyDataSetChanged();
        }, err->err.printStackTrace());
    }

    private void loadSpinnerCats(){

    }

    public class CatAdapter extends ArrayAdapter<Category>{

        private final LayoutInflater mInflater;
        private final Context mContext;
        private final List<Category> items;
        private final int mResource;

        public CatAdapter(@NonNull Context context, @LayoutRes int resource,
                                  @NonNull List objects) {
            super(context, resource, 0, objects);

            mContext = context;
            mInflater = LayoutInflater.from(context);
            mResource = resource;
            items = objects;
        }


        @Override
        public View getDropDownView(int position, @Nullable View convertView,
                                    @NonNull ViewGroup parent) {
            return createItemView(position, convertView, parent);
        }

        @Override
        public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return createItemView(position, convertView, parent);
        }

        private View createItemView(int position, View convertView, ViewGroup parent){
            final View view = mInflater.inflate(mResource, parent, false);

            TextView offTypeTv = (TextView) view.findViewById(R.id.tvTitle);

            Category offerData = items.get(position);

            offTypeTv.setText(offerData.catName);

            return view;
        }
    }


    @Override
    protected Class<CategorysaveViewModel> setViewModel() {
        return CategorysaveViewModel.class;
    }

    @Override
    protected CategorySaveBinding setViewBinding() {
        return CategorySaveBinding.inflate(getLayoutInflater());
    }
}
