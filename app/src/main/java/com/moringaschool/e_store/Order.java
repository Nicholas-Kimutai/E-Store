package com.moringaschool.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Order extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.userName)
    EditText userName;
    @BindView(R.id.userEmail)
    EditText userEmail;
    @BindView(R.id.userLocation)
    EditText userLocation;
    @BindView(R.id.phoneNumber)
    EditText phoneNumber;
   @BindView(R.id.confirmButton)
   Button orderConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ButterKnife.bind(this);
        orderConfirmation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

//user input validation
        if(v == orderConfirmation) {
            String username = userName.getText().toString();
            String useremail = userEmail.getText().toString();
            String userlocation= userLocation.getText().toString();
            String phonenumber=phoneNumber.getText().toString();
            if (username.isEmpty() || useremail.isEmpty() ||userlocation.isEmpty()||phonenumber.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please fill all required fields", Toast.LENGTH_LONG).show();
            }
            else {
                Intent intent = new Intent(Order.this, Order.class);
                intent.putExtra("username", username);
                intent.putExtra("Email", useremail);
                intent.putExtra("location", userlocation);
                intent.putExtra("PhoneNumber", phonenumber);
                Toast.makeText(getApplicationContext(),"Your order has been placed! We will contact you shortly",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        }
    }
}