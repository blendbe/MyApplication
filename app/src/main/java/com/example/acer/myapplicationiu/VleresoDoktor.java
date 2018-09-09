package com.example.acer.myapplicationiu;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VleresoDoktor extends AppCompatActivity {
    RatingBar ratingBar;
    Button button;
    String emri;
    int pozita;
    float numri;
    String path;
    TextView textView;
    FirebaseFirestore firebaseFirestore;
    Bundle bundle;
    Map<String, Object> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlereso_doktor);
        ratingBar = (RatingBar)findViewById(R.id.rateStars);
        bundle = getIntent().getExtras();
        firebaseFirestore = FirebaseFirestore.getInstance();
        data = new HashMap<>();
        path = this.getDatabasePath("projektii.db").toString();
        emri = bundle.getString("emriG");
        pozita = bundle.getInt("pozitaG");
        textView = (TextView)findViewById(R.id.bb);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                numri = ratingBar.getRating();
                Log.d("M", "Numri" + numri);
            }
        });
        button = (Button)findViewById(R.id.rate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.put("doc_id", pozita);
                data.put("doc_name", emri);
                data.put("doc_rating", numri);
                firebaseFirestore.collection("ratings").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(VleresoDoktor.this, "Vleresimi u realizua me sukses.", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(VleresoDoktor.this, "Vleresimi deshtoi!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
