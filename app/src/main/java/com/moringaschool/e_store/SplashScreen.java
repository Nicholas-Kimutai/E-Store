package com.moringaschool.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity {
private static int SPLASH_SCREEN=2500;
ImageView imageView;
TextView splashtitle, splashslogan;
Animation top, bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        imageView=findViewById(R.id.splashImage);
        splashtitle=findViewById(R.id.splashtitle);
        splashslogan=findViewById(R.id.splashdescription);

        top= AnimationUtils.loadAnimation(this, R.anim.top);
        bottom=AnimationUtils.loadAnimation(this, R.anim.top);

        imageView.setAnimation(top);
        splashtitle.setAnimation(bottom);
        splashslogan.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN);

    }
}