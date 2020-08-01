package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import Controller.BooksGridAdapter;

public class HeroesGallery extends AppCompatActivity {

    private GridView gridView;
    private BooksGridAdapter booksGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_gallery);

        gridView = findViewById(R.id.gridView);
        booksGridAdapter = new BooksGridAdapter(this);
        gridView.setAdapter(booksGridAdapter);
    }

    @Override
    public void onBackPressed() {}
}