package com.example.moallems_task.Adapters;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moallems_task.Model.Subject;
import com.example.moallems_task.R;
import com.example.moallems_task.SubjectClick;
import com.example.moallems_task.VedioClick;

import java.util.ArrayList;

public class VideosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
   VedioClick vedioClick;
    public VideosAdapter(Activity context, VedioClick click) {
        this.context = context;
        this.vedioClick = click;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.video_item,parent,false);
        return new VideosAdapter.RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final VideosAdapter.RecyclerViewViewHolder viewHolder= (VideosAdapter.RecyclerViewViewHolder) holder;

        MediaController mediaController= new MediaController(context);
        mediaController.setAnchorView(viewHolder.videoView);
        //Location of Media File
        Uri uri = Uri.parse("android.resource://" + "com.example.moallems_task" + "/" + R.raw.dummy_video);
        //Starting VideView By Setting MediaController and URI
        viewHolder.videoView.setMediaController(mediaController);
        viewHolder.videoView.setVideoURI(uri);
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vedioClick.onClick(viewHolder.videoView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        LinearLayout linearLayout;
        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.vdVw);
            linearLayout = itemView.findViewById(R.id.vedioHolder);


        }
    }
}
