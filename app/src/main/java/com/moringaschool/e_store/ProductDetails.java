package com.moringaschool.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetails extends AppCompatActivity implements View.OnClickListener {
@BindView(R.id.backArrow)
    ImageView backArrow;

@BindView(R.id.productName)
    TextView productName;
@BindView(R.id.orderButton)
Button orderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);
        backArrow.setOnClickListener(this);
        orderButton.setOnClickListener(this);
        Intent intent = getIntent();
        String item = intent.getStringExtra("category");
        productName.setText(item);
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