package com.moringaschool.e_store.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.e_store.Adapters.ProductsAdapter;
import com.moringaschool.e_store.MainActivity;
import com.moringaschool.e_store.R;
import com.moringaschool.e_store.models.AllProductsResponse;
import com.moringaschool.e_store.network.ApiClient;
import com.moringaschool.e_store.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsView extends AppCompatActivity {

    private RecyclerView recyclerView;
    ProgressDialog dialog;
    ProductsAdapter productsAdapter;
    ArrayList<AllProductsResponse> arrayList= new ArrayList<AllProductsResponse>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_view);


         dialog =new ProgressDialog(this);
         dialog.setTitle("Loading Products...");
         dialog.show();
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        ApiInterface client = ApiClient.getClient();
        Call<List<AllProductsResponse>> call = client.getProducts();
        call.enqueue(new Callback<List<AllProductsResponse>>() {
            @Override
            public void onResponse(Call<List<AllProductsResponse>> call, Response<List<AllProductsResponse>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(ProductsView.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<AllProductsResponse> allProductsResponseList=response.body();
                productsAdapter=new ProductsAdapter(ProductsView.this, allProductsResponseList);
                recyclerView.setAdapter(productsAdapter);
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<AllProductsResponse>> call, Throwable t) {

            }
        });
    }

    // Search Filter
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_bar,menu);

        MenuItem searchItem= menu.findItem(R.id.nav_search);
        SearchView searchView=(SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                productsAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    //Logout

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {

        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(ProductsView.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}
