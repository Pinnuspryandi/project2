package com.example.project;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class librarymaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarymaps);
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

        // Add a marker in Sydney and move the camera
        LatLng library1 = new LatLng(-6.17168325, 106.88568961);
        LatLng library2 = new LatLng(-6.2269682, 106.7913575);
        LatLng library3 = new LatLng(-6.1898973, 106.829218);
        LatLng library4 = new LatLng(-6.1898972, 106.8226519);
        LatLng library5 = new LatLng(-6.2130083, 106.8274914);
        LatLng library6 = new LatLng(-6.2229314, 106.8321061);
        LatLng library7 = new LatLng(-6.1898073, 106.823521);
        LatLng library8 = new LatLng(-6.2826025, 106.7693102);

        CameraPosition cameraPosition1 = new CameraPosition.Builder().target(library1).zoom(30)
            .bearing(20).tilt(90).build();
        CameraPosition cameraPosition2 = new CameraPosition.Builder().target(library2).zoom(30)
                .bearing(20).tilt(90).build();
        CameraPosition cameraPosition3 = new CameraPosition.Builder().target(library3).zoom(30)
                .bearing(20).tilt(90).build();
        CameraPosition cameraPosition4 = new CameraPosition.Builder().target(library4).zoom(30)
                .bearing(20).tilt(90).build();
        CameraPosition cameraPosition5 = new CameraPosition.Builder().target(library5).zoom(30)
                .bearing(20).tilt(90).build();
        CameraPosition cameraPosition6 = new CameraPosition.Builder().target(library6).zoom(30)
                .bearing(20).tilt(90).build();
        CameraPosition cameraPosition7 = new CameraPosition.Builder().target(library7).zoom(30)
                .bearing(20).tilt(90).build();
        CameraPosition cameraPosition8 = new CameraPosition.Builder().target(library8).zoom(30)
                .bearing(20).tilt(90).build();


        mMap.addMarker(new MarkerOptions().position(library1).title("Badan Perpustakaan dan Arsip Daerah Provinsi DKI Jakarta"));
        mMap.addMarker(new MarkerOptions().position(library2).title("Perpustakaan Japan Foundation"));
        mMap.addMarker(new MarkerOptions().position(library3).title("Perpustakaan Goethe-Institut"));
        mMap.addMarker(new MarkerOptions().position(library4).title("Perpustakaan Nasional Republik Indonesia"));
        mMap.addMarker(new MarkerOptions().position(library5).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(library6).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(library7).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(library8).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
