package com.example.acer.myapplicationiu;

import android.support.annotation.NonNull;

import com.google.firebase.firestore.Exclude;

public class ComPostId {

    @Exclude
    public String ComPostId;

    public <T extends ComPostId> T withId(@NonNull final String id) {
        this.ComPostId = id;
        return (T) this;
    }

}
