package com.example.bundleclone;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {

    private DatabaseReference mDatabase;


    public void setmDatabase(){
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public FirebaseUser getCurrentUser(){
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public void setKategori(String kategori){
        setmDatabase();
        FirebaseUser mUser = getCurrentUser();
        mDatabase.child("users").child(mUser.getUid()).child("favKategoriler").child(mUser.getUid()+kategori).setValue(kategori);
    }

    public void setKaynak(String kaynak){
        setmDatabase();
        FirebaseUser mUser = getCurrentUser();
        mDatabase.child("users").child(mUser.getUid()).child("favKaynaklar").child(mUser.getUid()+kaynak).setValue(kaynak);
    }
}
