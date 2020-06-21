package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;

import Controller.CallbackCharacterDataWrapper;
import Networking.MarvelClient;
import Model.CharacterDataWrapper;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView txtAppName;
    private ProgressBar loadingProgressBar;
    private ProgressBarThread progressBarThread;

    private Call<CharacterDataWrapper> getAllCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtAppName = findViewById(R.id.txtAppName);
        this.loadingProgressBar = findViewById(R.id.progressBar);
        initRetrofit();
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

        progressBarThread = new ProgressBarThread();
        progressBarThread.execute();
    }

    private void initRetrofit() {
        this.getAllCharacters = MarvelClient.getMarvelEndpointAPI().getAllCharacters();
        this.getAllCharacters.enqueue(new CallbackCharacterDataWrapper(this));
    }

    private class ProgressBarThread extends AsyncTask<Void, Void, Void> {
        private static final String TAG = "ProgressBarThread";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                Log.d(TAG, "doInBackground: " + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Animation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setDuration(500);
            loadingProgressBar.setAnimation(animation);
            loadingProgressBar.setVisibility(View.VISIBLE);
        }
    }

}