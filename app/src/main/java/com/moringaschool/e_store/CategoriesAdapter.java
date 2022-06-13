package com.moringaschool.e_store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.e_store.models.AllProductsResponse;
import com.squareup.picasso.Picasso;

import java.util.List;


//public class CategoriesAdapter extends BaseAdapter {
//    private Context mContext;
//    private LayoutInflater inflater;
//    private String products;
//

//    public CategoriesAdapter(Context mContext, String products) {
//        this.mContext = mContext;
//        this.products = products;
//    }
//
//
//
//    @Override
//    public int getCount() {
//        return products.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return products.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (inflater == null) {
//            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        }
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.activity_products_view, null);
//        }
//        ImageView productImage = convertView.findViewById(R.id.image);
//        TextView categoriesTitle = convertView.findViewById(R.id.categoriesTitle);
//
//        //Picasso.get().load(products.get(position).getImage().getUrl()).into(productImage);
//        //categoriesTitle.setText(products.get(position).getName());
//        return convertView;
//
//}

