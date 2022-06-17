package com.moringaschool.e_store.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.moringaschool.e_store.Adapters.ProductsAdapter;
import com.moringaschool.e_store.R;
import com.moringaschool.e_store.models.AllProductsResponse;
import com.moringaschool.e_store.models.Rating;
import com.moringaschool.e_store.network.ApiClient;
import com.moringaschool.e_store.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsView extends AppCompatActivity {

    List<AllProductsResponse> allProductsResponseList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_view);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


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
                ProductsAdapter productsAdapter=new ProductsAdapter(ProductsView.this, allProductsResponseList);
                recyclerView.setAdapter(productsAdapter);
            }

            @Override
            public void onFailure(Call<List<AllProductsResponse>> call, Throwable t) {

            }
        });




    }
}