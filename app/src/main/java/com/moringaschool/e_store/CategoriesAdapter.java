package com.moringaschool.e_store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CategoriesAdapter extends ArrayAdapter<Categories> {
    private Context mContext;
    private int mResource;
    public CategoriesAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Categories> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView categoriesTitle =convertView.findViewById(R.id.categoriesTitle);

        imageView.setImageResource(getItem(position).getImage());
        categoriesTitle.setText(getItem(position).getTittle());
        return convertView;

    }
}

