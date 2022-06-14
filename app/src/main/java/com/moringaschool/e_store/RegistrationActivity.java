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
    @BindView(R.id.signUpButton)
    Button SignUp;
    @BindView(R.id.signIn_reg)
    TextView signInReg;
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
        ButterKnife.bind(this);
        signInReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}