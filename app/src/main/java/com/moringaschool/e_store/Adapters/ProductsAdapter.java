package com.moringaschool.e_store.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.e_store.R;
import com.moringaschool.e_store.models.AllProductsResponse;
import com.moringaschool.e_store.ui.ProductDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.AllProductsResponseViewHolder> implements Filterable{
   private List<AllProductsResponse> allProductsResponse;
    Context context;
    private List<AllProductsResponse> allProductsResponseFull;

//Constructor
    public ProductsAdapter(Context context, List<AllProductsResponse> allProductsResponse){
        this.context=context;
        this.allProductsResponse=allProductsResponse;
        allProductsResponseFull=new ArrayList<>(allProductsResponse);
    }

    @NonNull
    @Override
    public AllProductsResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent, false);
        return new AllProductsResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllProductsResponseViewHolder holder, int position) {

        Picasso.get().load(allProductsResponse.get(position).getImage()).into(holder.image);
        holder.title.setText(allProductsResponse.get(position).getTitle());
        holder.category.setText(allProductsResponse.get(position).getCategory());
        //holder.description.setText(allProductsResponse.get(position).getDescription());
       // holder.price.setText(allProductsResponse.getPrice());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, ProductDetails.class);
                intent.putExtra("detail", allProductsResponse.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allProductsResponse.size();
    }

    @Override
    public Filter getFilter() {
        return allProductsFilter;
    }
    private Filter allProductsFilter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<AllProductsResponse>filteredList = new ArrayList<>();
            if(constraint ==null|| constraint.length()==0){
                filteredList.addAll(allProductsResponseFull);

            }
            else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (AllProductsResponse allProductsResponse: allProductsResponseFull){
                    if(allProductsResponse.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(allProductsResponse);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values=filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            allProductsResponse.clear();
            allProductsResponse.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    public class AllProductsResponseViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,category,description, rating, price;

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
