package com.example.acer.myapplicationiu;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView textView;
    Button button;
    RatingBar ratingBar;
    double rating;
    List<Double> lista = new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    double avgrating;
    private static final String TAG = "MapsActivity";
    String emriB;
    DatabaseReference databaseReference;
    int pozitaB;
    ImageView imageView;
    TextView emriMjeku;
    TextView profesioniMjeku;
    TextView spitali;
    TextView rruga;
    TextView bio;
    String emrii;
    int pozitaa;
    TextView vleresimet;
    Bundle bundle;
    String emriG;
    int pozitaG;
    double sum = 0;
    int i = 0;
    int totali;
    FirebaseFirestore firebaseFirestore;
    CollectionReference collectionReference;
    DocumentReference ref;
    private ArrayList<Double> ratingg = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        bundle = getIntent().getExtras();
        textView = (TextView) findViewById(R.id.telefoni);
        imageView = (ImageView) findViewById(R.id.fotoMjeku);
        emriG = bundle.getString("emri");
        pozitaG = bundle.getInt("pozita");
        ratingBar = (RatingBar) findViewById(R.id.docRating1);
        emriMjeku = (TextView) findViewById(R.id.emriMjeku);
        profesioniMjeku = (TextView) findViewById(R.id.profesioniMjeku);
        spitali = (TextView) findViewById(R.id.spitali);
        bio = (TextView) findViewById(R.id.bio);
        rruga = (TextView) findViewById(R.id.rruga);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
            if (pozitaG == 0)
            {
                imageView.setImageDrawable(getDrawable(R.drawable.atdhe));
                emriMjeku.setText("Dr. Bardhyl Berdynaj");
                profesioniMjeku.setText("Otorinolaringolog");
                spitali.setText("Spitali regjional i Pejes");
                textView.setText("+383 44 543 212");
                bio.setText(emriG + " ka diplomuar ne Universitetin e Prishtines, Fakulteti i Mjekesise ne vitin 1995.\n" +
                        "        Ai specializon ne fushen e Otorinolaringologjise. Ka pervoje pune mbi 10 vjecare ne fushen perkatese.");
                rruga.setText("Rr. Nëna Tereza, Pejë, KS 30000");
                FirestoreConnection(pozitaG);
            }
            else
            {
                FirestoreConnection(pozitaG);
            }
            ratingBar.setStepSize(0.5f);
            vleresimet = (TextView) findViewById(R.id.vleresimet);
            button = (Button) findViewById(R.id.vlereso);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MapsActivity.this, VleresoDoktor.class);
                    Bundle bundleG = new Bundle();
                    bundleG.putString("emriG", emriG);
                    bundleG.putInt("pozitaG", pozitaG);
                    intent.putExtras(bundleG);
                    Log.d("MAPS", emriG + pozitaG);
                    startActivity(intent);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phone_no = textView.getText().toString().replaceAll("-", "");
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + phone_no));
                    startActivity(callIntent);
                }


            });

        }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(42.6622487, 20.27339511141777);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Spitali regjional i Pejes"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        CameraUpdate center=
                CameraUpdateFactory.newLatLng(new LatLng(42.6622487,
                        20.27339511141777));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);

        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }
    public void FirestoreConnection(int doc_id)
    {
        firebaseFirestore = FirebaseFirestore.getInstance();
        collectionReference = firebaseFirestore.collection("ratings");
        Query query = collectionReference.whereEqualTo("doc_id", doc_id);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot document : task.getResult()) {
                        Rating rating = document.toObject(Rating.class);
                        ratingg.add(rating.getDoc_rating());
                        sum = sum + ratingg.get(i);
                        i++;
                    }
                    Log.d("MSG", "Shuma" + sum / 8);
                    for (int a = 0; a < ratingg.size(); a++) {
                        totali++;
                    }
                    ratingBar.setRating((float) sum / totali);
                    if (totali == 1){
                    vleresimet.setText(totali + " vleresim");}
                    else {vleresimet.setText(totali + " vleresime");}

                } else {
                    Log.d("BB", "Failed");
                }
            }
        });

    }

}
