package com.example.smigoc_shop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smigoc_shop.R;
import com.example.smigoc_shop.db.Item;
import com.example.smigoc_shop.models.Items;
import com.example.smigoc_shop.utils.IBaseListener;
import com.example.smigoc_shop.views.activity.CartActivity;

import java.util.ArrayList;
import java.util.List;

public class ListCategoryAdapter extends RecyclerView.Adapter<ListCategoryAdapter.ListCategoryViewHolder> implements IBaseListener {
    List<Item> items;
    Context context;

    public ListCategoryAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ListCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListCategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_adapter_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListCategoryViewHolder holder, int position) {
        Item listitems = items.get(position);
        holder.name.setText(listitems.getItemName());
    /*    holder.image.setImageResource(listitems.getImage());*/
     //   holder.catgeory.setText(listitems.getCatId());
        holder.tvSalePrice.setText(listitems.getSalePrice()+"");
        holder.tvPrice.setText(listitems.getPrice()+"");
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateNext(context, CartActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ListCategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, catgeory, tvSalePrice, tvPrice;
        TextView btnAdd;

        public ListCategoryViewHolder(@NonNull View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            catgeory = itemView.findViewById(R.id.catgeory);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvSalePrice = itemView.findViewById(R.id.tvSalePrice);
            btnAdd = itemView.findViewById(R.id.btnAdd);
        }
    }
}
