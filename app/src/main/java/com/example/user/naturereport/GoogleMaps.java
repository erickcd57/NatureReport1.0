package com.example.user.naturereport;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class GoogleMaps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        map.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng peru= new LatLng(-12.0464,-77.0428);
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(peru)
                        .zoom(5)
                        .build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                //LatLngBounds PERU= new LatLngBounds(
                //      new LatLng(-18.352222, -70.3775),new LatLng(-0.03,-75.174722));
                //googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(PERU,10));
            }
        });
    }
}
