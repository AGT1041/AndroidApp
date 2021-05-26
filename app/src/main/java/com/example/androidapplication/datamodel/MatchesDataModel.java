package com.example.androidapplication.datamodel;

import com.example.androidapplication.model.MatchesModel;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MatchesDataModel {
    private FirebaseFirestore databaseb;
    private List<ListenerRegistration> listeners;
    public  MatchesDataModel(){
        databaseb = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }
    public void addMatchs(MatchesModel matchs) {
        CollectionReference todoItemsRef = databaseb.collection("matches");
        todoItemsRef.add(matchs);
    }

    public void getMatche(Consumer<QuerySnapshot> dataChangedCallback, Consumer<FirebaseFirestoreException> dataErrorCallback){
        ListenerRegistration listener = databaseb.collection("matches")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    if(e !=null){
                        dataErrorCallback.accept(e);
                    }

                    dataChangedCallback.accept(queryDocumentSnapshots);
                });
        listeners.add(listener);
    }
    public void updateMatches(MatchesModel matches) {
        DocumentReference matchref = databaseb.collection("matches").document(matches.uid);

        Map<String, Object> info = new HashMap<>();
        info.put("name", matches.name);
        info.put("imageUrl", matches.imageUrl);
        info.put("liked", matches.liked);
        matchref.update(info);
    }
    public void clear() {
        listeners.forEach(ListenerRegistration::remove);
    }
}
