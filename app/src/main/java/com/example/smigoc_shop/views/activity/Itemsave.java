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
import com.example.smigoc_shop.databinding.ItemSaveBinding;
import com.example.smigoc_shop.db.Category;
import com.example.smigoc_shop.db.CategoryDao;
import com.example.smigoc_shop.db.Item;
import com.example.smigoc_shop.db.ItemDao;
import com.example.smigoc_shop.network.ApiRequest;
import com.example.smigoc_shop.viewModel.ItemSaveViewmodel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class Itemsave extends BaseActivity<ItemSaveBinding, ItemSaveViewmodel> {
    ItemDao itemDao;
    ItemAdapter itemAdapter;
    ArrayList<Category> categories;
    CategoryDao categoryDao;


    @Override
    protected void onCreateDone(@Nullable Bundle savedInstanceState) {

        itemDao= AppLoader.getDBClient(this).itemDao();
        categoryDao = AppLoader.getDBClient(this).categoryDao();
        categories = new ArrayList<>();

      itemAdapter = new ItemAdapter(this, R.layout.spinner_item,categories);
        viewBinding.spnitems.setAdapter(itemAdapter);

        viewBinding.spnitems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        viewBinding.btItemlogin.setOnClickListener(v->{
            Item item=new Item(viewBinding.etitemname.getText().toString().trim(),categories.get(viewBinding.spnitems.getSelectedItemPosition()).catId,
                    Double.parseDouble(viewBinding.etitemprice.getText().toString().trim()),Double.parseDouble(viewBinding.etactualprice.getText().toString().trim()));
            Observable.fromCallable(() -> itemDao.saveItem(item))
                        .compose(ApiRequest.applyObservableAsync())
                    .subscribe(result->{
                        showToast(getApplicationContext(),"ID saved: "+result);
                        loadParentItem();
                    },error->{
                      error.printStackTrace();
                    });

        });

        loadParentItem();

    }


    private void loadParentItem(){
        categoryDao.getCategoryList().compose(ApiRequest.applyObservableAsync()).subscribe(result->{
            categories.clear();
            categories.add(new Category("Select Category", 0));
            categories.addAll(result);
            itemAdapter.notifyDataSetChanged();
        }, err->err.printStackTrace());

    }

    public class ItemAdapter extends ArrayAdapter<Category> {

        private final LayoutInflater mInflater;
        private final Context mContext;
        private final List<Category> items;
        private final int mResource;

        public ItemAdapter(@NonNull Context context, @LayoutRes int resource,
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
    protected Class<ItemSaveViewmodel> setViewModel() {
        return ItemSaveViewmodel.class;
    }

    @Override
    protected ItemSaveBinding setViewBinding() {
        return ItemSaveBinding.inflate(getLayoutInflater());
    }
}
