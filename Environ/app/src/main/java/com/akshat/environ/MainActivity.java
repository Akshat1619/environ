package com.akshat.environ;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("A Better Place To live");

    }

    public void onclick(View view) {
        Intent i = new Intent(this, Report.class);
        startActivity(i);
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
    }

    public void onclick2(View view) {
        Intent i = new Intent(this, Tips.class);
        startActivity(i);
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
    }

    public void onclick3(View view) {

        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
    }

    public void message1(View view) {
    }
}
