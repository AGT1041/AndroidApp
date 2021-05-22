package com.example.androidapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MatchesCardRecyclerViewAdapter extends RecyclerView.Adapter<MatchCardViewHolder>{
    private List<MatcheDatas> matchesList;
    Context context;

    MatchesCardRecyclerViewAdapter(Context context,List<MatcheDatas> matchesList) {
        this.matchesList = matchesList;
        this.context=context;
    }



    @NonNull
    @Override
    public MatchCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.matches_card, parent, false);
        return new MatchCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchCardViewHolder holder, int position) {
        MatcheDatas matcheData = matchesList.get(position);
        holder.matcheImg.setImageResource(matcheData.getMatcheImg());
        holder.matcheName.setText(matcheData.getMatcheName());
    }

    @Override
    public int getItemCount() {
        return matchesList.size();
    }
}
