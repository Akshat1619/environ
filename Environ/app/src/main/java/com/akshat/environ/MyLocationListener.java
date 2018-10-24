package com.akshat.environ;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocationListener implements LocationListener {
    public static double latitude;
    public static double longitude;
    @Override
    public void onLocationChanged(Location location) {
        location.getLatitude();
        location.getLongitude();
        latitude=location.getLatitude();
        longitude=location.getLongitude();


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
