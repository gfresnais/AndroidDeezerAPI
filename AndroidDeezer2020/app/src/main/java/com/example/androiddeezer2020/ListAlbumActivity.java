package com.example.androiddeezer2020;

import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.androiddeezer2020.adapter.AlbumAdapter;
import com.example.androiddeezer2020.adapter.ArtistAdapter;
import com.example.androiddeezer2020.service.DeezerService;
import com.example.androiddeezer2020.service.data.DataSearchAlbum;
import com.example.androiddeezer2020.service.data.DataSearchArtist;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class ListAlbumActivity extends AppCompatActivity {
    private static final String TAG = "ListAlbumActivity";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_album);
        Toolbar toolbar = findViewById(R.id.toolbar);

        final String artist = getIntent().getStringExtra("artist");
        toolbar.setTitle(artist);

        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.progress_circular);
        hideProgress();

        recyclerView = (RecyclerView) findViewById(R.id.album_recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        /*
        Create list albums
         */
        Snackbar.make(findViewById(android.R.id.content),
                "Search " + artist,
                Snackbar.LENGTH_SHORT).show();
        showProgress();

        Response.Listener<DataSearchAlbum> rep = new Response.Listener<DataSearchAlbum>() {
            @Override
            public void onResponse(DataSearchAlbum response) {
                Log.d(TAG, "searchAlbum Found " + response.getTotal() + " album");
                AlbumAdapter mAdapter = new AlbumAdapter(response.getData());
                recyclerView.setAdapter(mAdapter);
                hideProgress();
            }
        };
        final Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "searchAlbum onErrorResponse: " + error.getMessage());
                hideProgress();
            }
        };

        DeezerService.searchAlbum(ListAlbumActivity.this, artist, rep, error);
    }

    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
