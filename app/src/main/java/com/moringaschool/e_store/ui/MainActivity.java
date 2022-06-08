package com.moringaschool.e_store.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.moringaschool.e_store.CategoriesAdapter;
import com.moringaschool.e_store.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.listView)
    ListView listView;

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

