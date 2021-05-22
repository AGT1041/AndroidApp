package com.example.androidapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MatchesFragment extends Fragment {

    MatcheDatas matchesData;
    View v;
    RecyclerView recycler;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_matches, container, false);

        recycler = v.findViewById(R.id.recycler_view);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));

        List<MatcheDatas> matchesDataList = new ArrayList<>();



        matchesData = new MatcheDatas(R.drawable.dogs,"Pele");
        matchesDataList.add(matchesData);
        matchesData = new MatcheDatas(R.drawable.messi, "lionel Messi");
        matchesDataList.add(matchesData);
        matchesData = new MatcheDatas(R.drawable.lion, "Ronaldo");
        matchesDataList.add(matchesData);
        MatchesCardRecyclerViewAdapter adapter = new MatchesCardRecyclerViewAdapter(getContext(), matchesDataList);
        recycler.setAdapter(adapter);
        return v;
    }
}