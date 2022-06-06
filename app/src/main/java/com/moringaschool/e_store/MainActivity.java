package com.moringaschool.e_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.listView)
    ListView listView;
    String[] categories = new String[]{"Electronics", "Jewellery", "Mens Collections", "Women Collections"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        CategoriesAdapter adapter = new CategoriesAdapter(MainActivity.this, categories);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "You clicked " + categories[position], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ProductDetails.class);
        intent.putExtra("category", categories[position]);
        startActivity(intent);
    }
}

