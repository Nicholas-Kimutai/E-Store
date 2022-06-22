package com.moringaschool.e_store;

import com.moringaschool.e_store.models.AllProductsResponse;

import java.util.List;

public interface OnFetchDataListener<AllProductsResponse> {
    void onFetchData(List<AllProductsResponse> list) ;
    void onError(String message);
}
