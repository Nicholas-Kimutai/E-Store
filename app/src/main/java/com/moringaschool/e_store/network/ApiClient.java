package com.moringaschool.e_store.network;

import android.content.Context;
import android.widget.Toast;

import com.moringaschool.e_store.Adapters.ProductsAdapter;
import com.moringaschool.e_store.OnFetchDataListener;
import com.moringaschool.e_store.models.AllProductsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ApiClient {

    Context context;

    Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void getAllProducts(OnFetchDataListener listener){
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<AllProductsResponse> call= apiInterface.callProducts();
                try{
                    call.enqueue(new Callback<AllProductsResponse>() {
                        @Override
                        public void onResponse(Call<AllProductsResponse> call, Response<AllProductsResponse> response) {
                           if (response.isSuccessful()){
                               Toast.makeText(context,"Error!!", Toast.LENGTH_SHORT).show();
                           }
                            listener.onFetchData((List) response.body());


                        }

                        @Override
                        public void onFailure(Call<AllProductsResponse> call, Throwable t) {
                            listener.onError("Request Failed");

                        }
                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }
    }
    public ApiClient(Context context) {
        this.context = context;
    }
    public interface ApiInterface{
        @GET("products")
        Call<AllProductsResponse> callProducts();
    }

}
