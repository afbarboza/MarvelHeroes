package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import Controller.CallbackCharacterDataWrapper;
import Networking.MarvelClient;
import Networking.MarvelEndpointAPI;
import Model.Character;
import Model.CharacterDataContainer;
import Model.CharacterDataWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView txtAppName;

    private Call<CharacterDataWrapper> getAllCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initViews();
    }

    private void initViews() {
        this.txtAppName = findViewById(R.id.txtAppName);


        float screenWidth = (1.0f * this.getResources().getDisplayMetrics().widthPixels);
        float textWidth = (float) (1.0f * this.txtAppName.getWidth());
        float middleCoordinate = (0.5f * (screenWidth - textWidth)) - (0.25f * screenWidth);

        ObjectAnimator animator = ObjectAnimator.ofFloat(this.txtAppName, "translationX", middleCoordinate);
        animator.setDuration(250);
        animator.start();
    }

    private void initRetrofit() {
        this.getAllCharacters = MarvelClient.getMarvelEndpointAPI().getAllCharacters();
        this.getAllCharacters.enqueue(new CallbackCharacterDataWrapper(this));
    }
}