package com.example.androiddeezer2020.adapter;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddeezer2020.MediaPlayerSingleton;
import com.example.androiddeezer2020.R;
import com.example.androiddeezer2020.service.data.Track;

import java.io.IOException;
import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {
    private static final String TAG = "AdapterAlbum";

    private List<Track> listTrack;

    public Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTrackName;
        private TextView textTrackDuration;
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            //c'est ici que l'on fait nos findView
            textTrackName = (TextView) itemView.findViewById(R.id.textTrackName);
            textTrackDuration = (TextView) itemView.findViewById(R.id.textTrackDuration);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TrackAdapter(List<Track> listAlbum) {
        this.listTrack = listAlbum;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_track, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Track track = listTrack.get(position);

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textTrackName.setText(track.getTitle());
        holder.textTrackDuration.setText(""+track.getDuration());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "click on <" + track.getTitle()+ ">");
                Log.d(TAG, "url : " + track.getPreview());
                MediaPlayerSingleton.INSTANCE.mp.reset();
                MediaPlayerSingleton.INSTANCE.mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    MediaPlayerSingleton.INSTANCE.mp.setDataSource(track.getPreview());
                    MediaPlayerSingleton.INSTANCE.mp.prepare();
                } catch (IOException e) {
                    Log.e(TAG, "erreur media preview", e);
                }
                MediaPlayerSingleton.INSTANCE.mp.start();
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listTrack.size();
    }
}
