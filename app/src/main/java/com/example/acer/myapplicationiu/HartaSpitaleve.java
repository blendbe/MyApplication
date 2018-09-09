package com.example.acer.myapplicationiu;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class HartaSpitaleve extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Bundle bundle;
    String spitali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harta_spitaleve);
        bundle = new Bundle();
        spitali = getIntent().getStringExtra("spitali");
        Log.d("d", spitali);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        if (spitali.equals("Peje")) {
            // Add a marker in Sydney and move the camera
            LatLng spitalirajonal = new LatLng(42.6627821, 20.2737414);
            LatLng klinikaBesi = new LatLng(42.6605865, 20.2916585);
            LatLng internationalHosp = new LatLng(42.6544053, 20.3122022);
            mMap.addMarker(new MarkerOptions().position(spitalirajonal).title("Spitali Rajonal i Pejes"));
            mMap.addMarker(new MarkerOptions().position(klinikaBesi).title("Klinika Dentare 'DR-BESI'"));
            mMap.addMarker(new MarkerOptions().position(internationalHosp).title("International Hospital"));
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(spitalirajonal);
            builder.include(klinikaBesi);
            builder.include(internationalHosp);
            LatLngBounds bounds = builder.build();
            int width = getResources().getDisplayMetrics().widthPixels;
            int height = getResources().getDisplayMetrics().heightPixels;
            int padding = (int) (width * 0.10); // offset from edges of the map 10% of screen
            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
            mMap.animateCamera(cu);
        }
        else if (spitali.equals("Prishtine"))
        {
            int height = 100;
            int width = 100;
            BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.hosploc);
            Bitmap b=bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
            LatLng qkuk = new LatLng(42.6436710, 21.1608334);
            LatLng spitaliLindja = new LatLng(42.6284907, 21.1555250);
            LatLng spitaliAmerikan = new LatLng(42.6427392, 21.1580603);
            LatLng aloka = new LatLng(42.6297779, 21.1487514);
            LatLng spitaliVita = new LatLng(42.6284907, 21.1555250);
            LatLng rezonaca = new LatLng(42.6563286, 21.1570250);
            LatLng kubati = new LatLng(42.6767631, 21.1835594);
            LatLng bahceci = new LatLng(42.5673386, 21.1294673);
            mMap.addMarker(new MarkerOptions().position(kubati).title("Qendra Laserike e Syrit 'KUBATI'").snippet("Klinike profesionale e sherbimeve te syrit").
                    icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).flat(true));
            mMap.addMarker(new MarkerOptions().position(qkuk).title("Qendra Klinike Universitare e Kosoves").snippet("Qender e te gjitha sherbimeve spitalore").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            mMap.addMarker(new MarkerOptions().position(spitaliLindja).title("Spitali LINDJA").snippet("Qender e te gjitha sherbimeve gjinekologjike").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            mMap.addMarker(new MarkerOptions().position(spitaliAmerikan).title("Spitali Amerikan").snippet("Qender e sherbimeve spitalore").flat(true).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            mMap.addMarker(new MarkerOptions().position(aloka).title("Spitali ALOKA").snippet("Qendra e te gjitha sherbimeve spitalore").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            mMap.addMarker(new MarkerOptions().position(spitaliVita).title("Spitali VITA").snippet("Qendra e sherbimeve gjinekologjike").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            mMap.addMarker(new MarkerOptions().position(rezonaca).title("Q.D.T Rezonanca").snippet("Qender e sherbimeve spitalore").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            mMap.addMarker(new MarkerOptions().position(bahceci).title("Bahceci Specialty Hospital").snippet("Qender e sherbimeve spitalore").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            LatLngBounds.Builder builder1 = new LatLngBounds.Builder();
            builder1.include(spitaliLindja);
            builder1.include(qkuk);
            builder1.include(spitaliAmerikan);
            builder1.include(aloka);
            builder1.include(spitaliVita);
            builder1.include(rezonaca);
            builder1.include(kubati);
            builder1.include(bahceci);
            LatLngBounds bounds1 = builder1.build();
            int width1 = getResources().getDisplayMetrics().widthPixels;
            int height1 = getResources().getDisplayMetrics().heightPixels;
            int padding1 = (int) (width1 * 0.10); // offset from edges of the map 10% of screen
            CameraUpdate cu1 = CameraUpdateFactory.newLatLngBounds(bounds1, width1, height1, padding1);
            mMap.animateCamera(cu1);
        }
    }
}
