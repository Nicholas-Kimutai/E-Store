package com.moringaschool.e_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listView);

        //Create data
        ArrayList<Categories> arrayList =new ArrayList<>();
        arrayList.add(new Categories(R.drawable.electronics, "Electronics", "View Products"));
        arrayList.add(new Categories(R.drawable.jewellery, "Jewelery", "View Products"));
        arrayList.add(new Categories(R.drawable.mens, "Men Collections", "View Products"));
        arrayList.add(new Categories(R.drawable.womens, "Women Collections", "View Products"));

       // Make custom Adapter
       CategoriesAdapter categoriesAdapter =new CategoriesAdapter(this, R.layout.list_row, arrayList);
       listView.setAdapter(categoriesAdapter);

       BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
       bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

 private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment=null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment=new HomeFragment();
                            break;

                        case R.id.nav_search:
                            selectedFragment=new SearchFragment();
                            break;

                        case R.id.nav_user:
                            selectedFragment=new UserFragment();
                            break;

                        case R.id.nav_cart:
                            selectedFragment=new CartFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                            selectedFragment).commit();
                    return true;
                }
            };
}