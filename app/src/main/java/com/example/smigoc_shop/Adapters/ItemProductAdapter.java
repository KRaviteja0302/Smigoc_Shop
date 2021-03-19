package com.example.smigoc_shop.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smigoc_shop.R;
import com.example.smigoc_shop.db.Category;
import com.example.smigoc_shop.models.Categories;
import com.example.smigoc_shop.views.fragments.FragmentItems;

import java.util.List;

import okhttp3.internal.concurrent.Task;

public class ItemProductAdapter extends RecyclerView.Adapter<ItemProductAdapter.ItemProductViewHolder> {

    List<Category> categories;
    Context context;
    ICategoryListener listener;

    public ItemProductAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    public void setICategoryListener(ICategoryListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_categories, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemProductViewHolder holder, int position) {
        Category cat = categories.get(position);
        holder.name.setText(cat.getCatName());

        holder.itemView.setOnClickListener(v -> {
          if(listener!=null)
              listener.onCategorySelected(cat);

        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ItemProductViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        public ItemProductViewHolder(@NonNull View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);

        }
    }

    public interface ICategoryListener{
        void onCategorySelected(Category category);
    }
}

