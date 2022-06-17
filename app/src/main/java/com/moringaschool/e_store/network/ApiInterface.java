package com.moringaschool.e_store.network;

import com.moringaschool.e_store.models.AllProductsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("products")
    Call<List<AllProductsResponse>>getProducts();
}
