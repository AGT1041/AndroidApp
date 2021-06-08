package com.example.androidapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidapplication.model.MatchesModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MatchesCardRecyclerViewAdapter extends RecyclerView.Adapter<MatchCardViewHolder>{
    //private List<MatcheDatas> matchesList;
    private List<MatchesModel> matchedatasList;
    Context context;

    MatchesCardRecyclerViewAdapter(List<MatchesModel> matchedatasList) {
        this.matchedatasList = matchedatasList;
        //this.context=context;
    }



    @NonNull
    @Override
    public MatchCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.matches_card, parent, false);
        return new MatchCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchCardViewHolder holder, int position) {
        if (matchedatasList != null) {
            MatchesModel match = this.matchedatasList.get(position);
            holder.matcheName.setText(match.name);
            Picasso.get().load(match.imageUrl).into(holder.matcheImg);
            //holder.matcheImg.set
            //imageRequester.setImageFromUrl(holder.matchImage, m.imageUrl);
           // Picasso.with(context).load(ImageURL).into(imageView);
            //holder.matcheName.setText(matcheData.getMatcheName());
        }
        //holder.matcheName.setText(matcheData.getMatcheName());
    }

    @Override
    public int getItemCount() {
        return matchedatasList.size();
    }
    public void setMatches(List<MatchesModel> match) {
        this.matchedatasList = match;
    }
}
