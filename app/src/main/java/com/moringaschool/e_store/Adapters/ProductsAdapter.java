package com.moringaschool.e_store.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.e_store.R;
import com.moringaschool.e_store.models.AllProductsResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.AllProductsResponseViewHolder> {

    List<AllProductsResponse> allProductsResponseList;
    Context context;

    public ProductsAdapter(Context context,List<AllProductsResponse>productsResponses){
        this.context=context;
        allProductsResponseList=productsResponses;
    }


    @NonNull
    @Override
    public AllProductsResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent, false);
        return new AllProductsResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllProductsResponseViewHolder holder, int position) {

        AllProductsResponse allProductsResponse=allProductsResponseList.get(position);
        Picasso.get().load(allProductsResponse.getImage()).into(holder.image);
        holder.title.setText(allProductsResponse.getTitle());
        holder.category.setText(allProductsResponse.getCategory());
       // holder.rating.setText(allProductsResponse.getRating());
       // holder.price.setText(allProductsResponse.getPrice());


    }

    @Override
    public int getItemCount() {
        return allProductsResponseList.size();
    }

    public class AllProductsResponseViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,category, rating, price;

        public AllProductsResponseViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.productImage);
            title=itemView.findViewById(R.id.productName);
            category=itemView.findViewById(R.id.productCategory);
           //rating=itemView.findViewById(R.id.productRating);
           //price=itemView.findViewById(R.id.productPrice);
        }
    }
}
