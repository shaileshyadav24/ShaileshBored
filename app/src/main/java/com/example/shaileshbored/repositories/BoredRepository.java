// Created by Shailesh Yadav - 101332535

package com.example.shaileshbored.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.shaileshbored.model.Bored;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BoredRepository {
    private final String TAG = this.getClass().getCanonicalName();
    private final String COLLECTION_NAME = "FAVLIST";
    public MutableLiveData<String> boredMutableData = new MutableLiveData<>();

    private final FirebaseFirestore db;

    public BoredRepository() {
        db = FirebaseFirestore.getInstance();
    }


    public void addBoredToFavList(Bored bored) {

        try {
            db.collection(COLLECTION_NAME)
                    .add(bored)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "Document added with ID : " + documentReference.getId());
                            boredMutableData.postValue("Added to Favorite list");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.e(TAG, "Error adding document to the store " + e);
                            boredMutableData.postValue("Failure occured while adding to fav list");
                        }
                    });

        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
            Log.e(TAG, ex.getLocalizedMessage());
            boredMutableData.postValue("Failure occured while adding to fav list");
        }

    }


}
