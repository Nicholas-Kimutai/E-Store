package com.moringaschool.e_store.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.e_store.R;
import com.moringaschool.e_store.models.AllProductsResponse;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetails extends AppCompatActivity implements View.OnClickListener{
@BindView(R.id.backArrow)
ImageView backArrow;
@BindView(R.id.orderButton)
Button orderButton;

    ImageView descriptionImage;
    TextView producDescription,productname, productCategory;
    AllProductsResponse allProductsResponse = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);



        final Object object=getIntent().getSerializableExtra("detail");
        if(object instanceof AllProductsResponse){
            allProductsResponse= (AllProductsResponse) object;
        }

        descriptionImage=findViewById(R.id.imageView2);
        productCategory=findViewById(R.id.productName);
        productname=findViewById(R.id.textView3);
        producDescription=findViewById(R.id.textView5);


        if(allProductsResponse !=null){
            Picasso.get().load(allProductsResponse.getImage()).into(descriptionImage);
            productname.setText(allProductsResponse.getTitle());
            producDescription.setText(allProductsResponse.getDescription());
            productCategory.setText(allProductsResponse.getCategory());


        }


        ButterKnife.bind(this);
        backArrow.setOnClickListener(this);
        orderButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == backArrow) {
            this.finish();
        }
        if (v == orderButton) {
            Intent intent = new Intent(ProductDetails.this, Order.class);
            startActivity(intent);
        }
    }
}