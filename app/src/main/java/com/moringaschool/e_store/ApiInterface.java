package com.moringaschool.e_store;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("products")
    Call<AllProductsResponse>getProducts();
}
