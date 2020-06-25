package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import Controller.CallbackCharacterDataWrapper;
import Networking.MarvelClient;
import Model.CharacterDataWrapper;
import Utils.Constants;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView txtAppName;
    private ProgressBar loadingProgressBar;
    private SplashScreenSpinner progressBarThread;

    private Call<CharacterDataWrapper> getAllCharacters;

    private boolean isRequestFinished = false;
    private boolean isProgressBarFinished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initRetrofit();
        registerEventBroadcastsReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        animateSplashScreen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.progressBarThread != null) {
            this.progressBarThread.cancel(true);
            this.progressBarThread = null;
            System.gc();
        }
    }

    private void initViews() {
        this.txtAppName = findViewById(R.id.txtAppName);
        this.loadingProgressBar = findViewById(R.id.progressBar);
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

        progressBarThread = new SplashScreenSpinner(this, loadingProgressBar);
    }

    private void initRetrofit() {
        this.getAllCharacters = MarvelClient.getMarvelEndpointAPI().getAllCharacters();
        this.getAllCharacters.enqueue(new CallbackCharacterDataWrapper(getBaseContext()));
    }

    private void registerEventBroadcastsReceiver() {
        BroadcastReceiver request = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                isRequestFinished = true;

                if (isProgressBarFinished) {
                    Toast.makeText(context, "Pode ir para a outra tela", Toast.LENGTH_LONG).show();
                }
            }
        };
        registerReceiver(request, new IntentFilter(Constants.EVENT_REQUEST_FINISIHED));

        BroadcastReceiver progressBarAnimation = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                isProgressBarFinished = true;

                if (isRequestFinished) {
                    Toast.makeText(context, "Pode ir para a outra tela", Toast.LENGTH_LONG).show();
                }
            }
        };
        registerReceiver(progressBarAnimation, new IntentFilter(Constants.EVENT_SPLASH_SCREEN_FINISHED));

    }
}