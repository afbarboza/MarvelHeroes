package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import Controller.RequestInterceptor;
import Controller.RetrofitClient;
import Model.Character;
import Model.CharacterDataContainer;
import Model.CharacterDataWrapper;
import Utils.Constants;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Retrofit retrofit;
    private RetrofitClient retrofitClient;
    private Call<CharacterDataWrapper> getAllCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRetrofit();
    }

    private void initRetrofit() {
        /* init interceptor for REST requests */
        Interceptor i = new RequestInterceptor();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(i)
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL_VALUE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        this.retrofitClient = this.retrofit.create(RetrofitClient.class);

        this.getAllCharacters = retrofitClient.getAllCharacters();
        this.getAllCharacters.enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, retrofit2.Response<CharacterDataWrapper> response) {
                Log.d(TAG, "onResponse: SUCCESS");
                CharacterDataWrapper characterDataWrapper = response.body();
                CharacterDataContainer characterDataContainer = characterDataWrapper.getData();
                List<Character> allCharacters = characterDataContainer.getResults();

                for (Character c : allCharacters) {
                    Log.d(TAG, "onResponse: " + c.getName());
                }
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}