package com.example.androidapplication;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MatchCardViewHolder extends RecyclerView.ViewHolder{
    public Button likedB;
    public TextView matcheName;
    public ImageView matcheImg;

    public MatchCardViewHolder(@NonNull View itemView) {
        super(itemView);
        likedB = itemView.findViewById(R.id.likeButton);
        matcheName = itemView.findViewById(R.id.matcheNameTextView);
        matcheImg = itemView.findViewById(R.id.matcheImgView);

        likedB.setOnClickListener(view -> {
            Toast t = Toast.makeText(view.getContext(), "You liked  " + matcheName.getText().toString() + "they are added to your liked", Toast.LENGTH_LONG);
            t.show();
        });
    }
}
