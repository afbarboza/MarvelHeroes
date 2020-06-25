package com.example.marvelapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

import Utils.Constants;

public class SplashScreenSpinner extends AsyncTask<Void, Void, Void> {
    private WeakReference<Context> weakRefContext;
    private WeakReference<ProgressBar> weakRefSpinner;
    private static final String TAG = "SplashScreenSpinner";

    public SplashScreenSpinner(Context context, ProgressBar spinner) {
        this.weakRefContext = new WeakReference<Context>(context);
        this.weakRefSpinner = new WeakReference<ProgressBar>(spinner);

        execute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        if (weakRefContext == null) {
            cancel(true);
        }

        try {
            Thread.sleep(1500);
        } catch (Exception e) {}

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        ProgressBar progressBar;

        if (weakRefSpinner == null) {
            return;
        }

        progressBar = weakRefSpinner.get();
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(1000);
        animation.setAnimationListener(new SpinnerAnimationListener());
        progressBar.setAnimation(animation);
        progressBar.setVisibility(View.VISIBLE);
    }

    private class SpinnerAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) { }

        @Override
        public void onAnimationEnd(Animation animation) {
            Context runningContext = weakRefContext.get();
            Intent i = new Intent(Constants.EVENT_SPLASH_SCREEN_FINISHED);
            runningContext.sendBroadcast(i);
        }

        @Override
        public void onAnimationRepeat(Animation animation) { }
    }

}
