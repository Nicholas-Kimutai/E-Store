package com.moringaschool.e_store;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView title;
    public TextView category;
    TextView rating;
    TextView price;
    public ProductsViewHolder(@NonNull View itemView) {
        super(itemView);

        image=itemView.findViewById(R.id.productImage);
        title=itemView.findViewById(R.id.productName);
        category=itemView.findViewById(R.id.productCategory);
        //rating=itemView.findViewById(R.id.productRating);
        //price=itemView.findViewById(R.id.productPrice);
    }
}
