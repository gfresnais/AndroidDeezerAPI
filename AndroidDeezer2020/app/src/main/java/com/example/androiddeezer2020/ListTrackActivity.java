package com.example.androiddeezer2020;

import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.androiddeezer2020.adapter.TrackAdapter;
import com.example.androiddeezer2020.service.DeezerService;
import com.example.androiddeezer2020.service.data.DataSearchTrack;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class ListTrackActivity extends AppCompatActivity {
    private static final String TAG = "ListTrackActivity";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_track);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int album = getIntent().getIntExtra("album", 0);
        toolbar.setTitle(String.valueOf(album));

        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.progress_circular);
        hideProgress();

        recyclerView = (RecyclerView) findViewById(R.id.track_recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        /*
        Create list tracks
         */
        Snackbar.make(findViewById(android.R.id.content),
                "Search " + album,
                Snackbar.LENGTH_SHORT).show();
        showProgress();

        Response.Listener<DataSearchTrack> rep = new Response.Listener<DataSearchTrack>() {
            @Override
            public void onResponse(DataSearchTrack response) {
                Log.d(TAG, "searchTrack Found " + response.getTotal() + " track");
                TrackAdapter mAdapter = new TrackAdapter(response.getData());
                recyclerView.setAdapter(mAdapter);
                hideProgress();
            }
        };
        final Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "searchTrack onErrorResponse: " + error.getMessage());
                hideProgress();
            }
        };

        DeezerService.searchAlbumTrack(ListTrackActivity.this, album, rep, error);
    }

    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        MediaPlayerSingleton.INSTANCE.mp.reset();
        return true;
    }
}
