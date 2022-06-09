package com.moringaschool.e_store.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.moringaschool.e_store.CategoriesAdapter;
import com.moringaschool.e_store.R;
import com.moringaschool.e_store.models.AllProductsResponse;
import com.moringaschool.e_store.network.ApiClient;
import com.moringaschool.e_store.network.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.listView)
    ListView listView;
    List<AllProductsResponse>mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listView.setOnItemClickListener(this);
        listView.setVisibility(View.INVISIBLE);

        ApiInterface client = ApiClient.getClient();
        Call<AllProductsResponse> call = client.getProducts();
        call.enqueue(new Callback<AllProductsResponse>() {

            @Override
            public void onResponse(Call<AllProductsResponse> call, Response<AllProductsResponse> response) {

                if(response.isSuccessful()){
                    String mList  = response.body().getCategory();
                CategoriesAdapter adapter = new CategoriesAdapter(MainActivity.this, response.body().getTitle());
                listView.setAdapter(adapter);
                listView.setVisibility(View.VISIBLE);

            }

            }

            @Override
            public void onFailure(Call<AllProductsResponse> call, Throwable t) {

            }
        });

        }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "You clicked " + mList.get(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ProductDetails.class);
        intent.putExtra("category", (Parcelable) mList.get(position));
        startActivity(intent);
    }
}

