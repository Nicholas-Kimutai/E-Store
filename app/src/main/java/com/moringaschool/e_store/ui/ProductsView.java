package com.moringaschool.e_store.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.moringaschool.e_store.Adapters.ProductsAdapter;
import com.moringaschool.e_store.OnFetchDataListener;
import com.moringaschool.e_store.R;
import com.moringaschool.e_store.models.AllProductsResponse;
import com.moringaschool.e_store.network.ApiClient;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsView extends AppCompatActivity {

    private RecyclerView recyclerView;
    ProgressDialog dialog;
    ProductsAdapter productsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_view);


        ApiClient apiClient= new ApiClient(this);
        apiClient.getAllProducts(listener);
//        dialog= new ProgressDialog(this);
//        dialog.setTitle("Loading products ...");
//        dialog.show();


    }

    private final OnFetchDataListener<AllProductsResponse>listener=new OnFetchDataListener<AllProductsResponse>() {

        @Override
        public void onFetchData(List<AllProductsResponse> list) {
            showProducts(list);

        }

        @Override
        public void onError(String message) {

        }
    };

    private void showProducts(List<AllProductsResponse> list) {

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        productsAdapter=new ProductsAdapter(this, list);
        recyclerView.setAdapter(productsAdapter);

    }

}