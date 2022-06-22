package com.moringaschool.e_store.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.e_store.ProductsViewHolder;
import com.moringaschool.e_store.R;
import com.moringaschool.e_store.models.AllProductsResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {
private Context context;
private List<AllProductsResponse> allProducts;

    public ProductsAdapter(Context context, List<AllProductsResponse> allProducts) {
        this.context = context;
        this.allProducts = allProducts;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductsViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {

        holder.title.setText(allProducts.get(position).getTitle());
        holder.category.setText(allProducts.get(position).getCategory());
        Picasso.get().load(allProducts.get(position).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return allProducts.size();
    }
}
