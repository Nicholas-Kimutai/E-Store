package com.moringaschool.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SignalStrengthUpdateRequest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.e_store.ui.Order;
import com.moringaschool.e_store.ui.ProductDetails;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity {
    @BindView(R.id.signUp)
    Button signUp;
    @BindView(R.id.signIn_reg)
    TextView signIn;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.email_reg)
    EditText email;
    @BindView(R.id.password_reg)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //ButterKnife.bind(this);
        //signIn.setOnClickListener(this);
       // Intent intent = getIntent();

//        signIn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
//            }
//        });
    }

//    @Override
//    public void onClick(View v) {
//        if (v == signIn) {
//            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
//            startActivity(intent);
//        }
//    }
}