package com.moringaschool.e_store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CategoriesAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private String[] categories;


    public CategoriesAdapter(Context mContext, String[] categories) {
        this.mContext = mContext;
        this.categories = categories;
    }



    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public Object getItem(int position) {
        return categories[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_products_view, null);
        }

        TextView categoriesTitle = convertView.findViewById(R.id.categoriesTitle);
        categoriesTitle.setText(categories[position]);
        return convertView;
    }
}

