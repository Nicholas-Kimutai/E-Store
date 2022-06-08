package com.moringaschool.e_store.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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

    List<AllProductsResponse> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_view);

        ApiInterface client = ApiClient.getClient();
        Call<AllProductsResponse> call = client.getProducts();
        call.enqueue(new Callback<AllProductsResponse>() {
            @Override
            public void onResponse(Call<AllProductsResponse> call, Response<AllProductsResponse> response) {
                if(response.isSuccessful()){
                    products = response.body();
                    mAdapter = new SalesListAdapter(sales,SalesActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SalesActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    showSales();
                }else{
                    showUnsuccessfulMessage();
                }

            }

            @Override
            public void onFailure(Call<AllProductsResponse> call, Throwable t) {

            }
        });
    }
}