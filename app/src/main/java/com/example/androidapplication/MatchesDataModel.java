package com.example.androidapplication;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;

import java.util.ArrayList;
import java.util.List;

public class MatchesDataModel {
    private FirebaseFirestore databaseb;
    private List<ListenerRegistration> listeners;
    public  MatchesDataModel(){
        databaseb = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }
    public void addMatch(MatcheDatas matchs) {
        CollectionReference todoItemsRef = databaseb.collection("matches");
        todoItemsRef.add(matchs);
    }
}
