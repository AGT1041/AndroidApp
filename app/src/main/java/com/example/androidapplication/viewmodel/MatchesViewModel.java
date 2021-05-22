package com.example.androidapplication.viewmodel;

import com.example.androidapplication.datamodel.MatchesDataModel;
import com.example.androidapplication.model.MatchesModel;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MatchesViewModel {
    private MatchesDataModel matchesDataM;

    public MatchesViewModel(){
        matchesDataM = new MatchesDataModel();
    }
    public void addMatch(MatchesModel matches){
        matchesDataM.addMatchs(matches);
    }

    public void getMatche(Consumer<ArrayList<MatchesModel>> responseCallback){
        matchesDataM.getMatche(
                (QuerySnapshot querySnapshot) ->{
                    if(querySnapshot != null){
                        ArrayList<MatchesModel> matchViews = new ArrayList<>();
                        for (DocumentSnapshot matchesSnap : querySnapshot.getDocuments()){
                            MatchesModel matchesModel = matchesSnap.toObject(MatchesModel.class);
                            assert  matchesModel !=null;
                            matchesModel.uid =matchesSnap.getId();
                            matchViews.add(matchesModel);
                        }
                        responseCallback.accept(matchViews);
                    }
                },
                (databaseError -> System.out.println("Error something went wrong" + databaseError))
        );
    }

    public void clear(){
        matchesDataM.clear();
    }
}
