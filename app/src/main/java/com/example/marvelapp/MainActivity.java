package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

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
    
    private Call<CharacterDataWrapper> getAllCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRetrofit();
    }

    private void initRetrofit() {
        this.getAllCharacters = MarvelClient.getMarvelEndpointAPI().getAllCharacters();
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