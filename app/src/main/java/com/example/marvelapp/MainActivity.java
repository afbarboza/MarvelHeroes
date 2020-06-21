package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import Controller.CallbackCharacterDataWrapper;
import Networking.MarvelClient;
import Model.CharacterDataWrapper;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView txtAppName;

    private Call<CharacterDataWrapper> getAllCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtAppName = findViewById(R.id.txtAppName);
        initRetrofit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        animateSplashScreen();
    }

    private void animateSplashScreen() {
        float screenWidth = (1.0f * this.getResources().getDisplayMetrics().widthPixels);
        float textWidth = (float) (1.0f * this.txtAppName.getWidth());
        float middleCoordinate = (0.5f * (screenWidth - textWidth)) - (0.25f * screenWidth);

        ObjectAnimator animator = ObjectAnimator.ofFloat(this.txtAppName, "translationX", middleCoordinate);
        animator.setDuration(1000);
        animator.start();

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(2000);
        this.txtAppName.startAnimation(animation);
    }



    private void initRetrofit() {
        this.getAllCharacters = MarvelClient.getMarvelEndpointAPI().getAllCharacters();
        this.getAllCharacters.enqueue(new CallbackCharacterDataWrapper(this));
    }
}