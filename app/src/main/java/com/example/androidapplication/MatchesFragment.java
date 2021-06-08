package com.example.androidapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidapplication.model.MatchesModel;
import com.example.androidapplication.viewmodel.MatchesViewModel;

import java.util.ArrayList;
public class MatchesFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    static final String ARG_DATA_SET = "data-set";
    MatcheDatas matchesData;
    View v;
    RecyclerView recycler;
    public ArrayList matches=new ArrayList();
    public MatchesViewModel mviewModel=new MatchesViewModel();
    private FragmentManager manager;
    private ArrayList<String>  names;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            matches = getArguments().getParcelableArrayList(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_matches, container, false);

        recycler = v.findViewById(R.id.recycler_view);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        MatchesCardRecyclerViewAdapter adapter = new MatchesCardRecyclerViewAdapter(matches);
       // List<MatcheDatas> matchesDataList = new ArrayList<>();



       // matchesData = new MatcheDatas(R.drawable.dogs,"Pele");
        //matchesDataList.add(matchesData);
        //matchesData = new MatcheDatas(R.drawable.messi, "lionel Messi");
        //matchesDataList.add(matchesData);
        //matchesData = new MatcheDatas(R.drawable.lion, "Ronaldo");
        //matchesDataList.add(matchesData);


        recycler.setAdapter(adapter);
        //recyclerView.addItemDecoration
        mviewModel.getMatche(
                (ArrayList<MatchesModel> m)-> {

                    adapter.setMatches(m);
                    adapter.notifyDataSetChanged();
                   // for (int i = 0; i < matches.size(); i++) {
                  //  names.add(m.get(i).name);

                }//}
        );

        return v;
    }
    @Override
    public void onPause() {
        mviewModel.clear();
        super.onPause();
    }

    }