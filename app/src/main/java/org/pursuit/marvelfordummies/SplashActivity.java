package org.pursuit.marvelfordummies;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIMER = 2500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Glide.with(SplashActivity.this)
          .load(R.drawable.marvelsplash)
          .into(this.<ImageView>findViewById(R.id.splash_screen_image));
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, SPLASH_SCREEN_TIMER);
    }
}
