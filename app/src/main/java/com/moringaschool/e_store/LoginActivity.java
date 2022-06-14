package com.moringaschool.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.signInButton)
    Button signIn;
    @BindView(R.id.email_login)
    EditText email;
    @BindView(R.id.password_login)
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        signIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
//
//            }
//        });
    }
}