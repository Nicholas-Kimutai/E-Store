package com.moringaschool.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
@BindView(R.id.signupSelect)
TextView signup;
@BindView(R.id.loginSelectButton)
TextView login;
ProgressBar progressbar;
Animation top, bottom;
ImageView imageView;
TextView splashtitle, splashslogan, about;

private static int SPLASH_SCREEN=2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressbar = findViewById(R.id.progressbar);
        progressbar.setVisibility(View.GONE);

        imageView=findViewById(R.id.splashImage);
        splashtitle=findViewById(R.id.logo);
        splashslogan=findViewById(R.id.motto);
        about=findViewById(R.id.about);

     //Animations
        top= AnimationUtils.loadAnimation(this, R.anim.top);
        bottom=AnimationUtils.loadAnimation(this, R.anim.top);


        splashtitle.setAnimation(top);
        imageView.setAnimation(top);
        splashslogan.setAnimation(top);
        about.setAnimation(bottom);



        ButterKnife.bind(this);

        //Sign-Up
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        //Login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });





    }


}

