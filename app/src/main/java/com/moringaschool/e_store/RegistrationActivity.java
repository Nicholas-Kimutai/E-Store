package com.moringaschool.e_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SignalStrengthUpdateRequest;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.e_store.models.User;
import com.moringaschool.e_store.ui.Order;
import com.moringaschool.e_store.ui.ProductDetails;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity {
    @BindView(R.id.signUpButton)
    Button signUser;
    @BindView(R.id.signIn_reg)
    TextView signInReg;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.email_reg)
    EditText email;
    @BindView(R.id.password_reg)
    EditText password;
    ProgressBar progressbar;
    FirebaseAuth auth;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        auth = FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        progressbar=findViewById(R.id.progressbar);
        progressbar.setVisibility(View.GONE);

        ButterKnife.bind(this);
        signInReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
                progressbar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void createUser() {
        String userName=name.getText().toString();
        String userEmail=email.getText().toString();
        String userPassword= password.getText().toString();

        if(TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Name is empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Email; is empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Password is empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPassword.length()<6){
            Toast.makeText(this, "Password must have a minimum of 6 letters!", Toast.LENGTH_SHORT).show();
        return;
        }

        //Create User
        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            User user= new User(userName,userEmail,userPassword);
                            String id=task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);
                            progressbar.setVisibility(View.GONE);

                            Toast.makeText(RegistrationActivity.this, "Sign-up successful", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            progressbar.setVisibility(View.GONE);
                            Toast.makeText(RegistrationActivity.this, "Error", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}