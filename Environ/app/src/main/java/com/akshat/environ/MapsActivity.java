package com.akshat.environ;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
       SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        LatLng mum1 = new LatLng(19.0607, 72.8362);
        mMap.addMarker(new MarkerOptions().position(mum1).title("Dustbin in Bandra"));
        LatLng mum2 = new LatLng(19.0729578, 72.8999708);
        mMap.addMarker(new MarkerOptions().position(mum2).icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)).title("Dustbin in KJ Somaiya"));
        LatLng mum3 = new LatLng(19.2372, 72.8441);
        mMap.addMarker(new MarkerOptions().position(mum3).title("Dustbin in Borivali"));
        LatLng mum4 = new LatLng(18.656654, 72.879868);
        mMap.addMarker(new MarkerOptions().position(mum4).title("Dustbin in Alibaug"));
        CameraPosition cameraPosition = new CameraPosition.Builder().
                target(mum2).
                tilt(60).
                zoom(15).
                bearing(0).
                build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        float zoomLevel = 15.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mum2, zoomLevel));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("Dustbin in KJ Somaiya")){
                    Intent i=new Intent(MapsActivity.this,QRCode.class);
                    startActivity(i);
                    }
                return false;
            }
        });



    }
}
