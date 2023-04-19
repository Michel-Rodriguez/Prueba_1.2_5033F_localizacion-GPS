package com.example.prueba_12_5033f;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {


    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng Spain = new LatLng(37.9805324,-1.1271753);
        mMap.addMarker(new MarkerOptions().position(Spain).title("Murcia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Spain));


    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);

        mMap.clear();
        LatLng Spain = new LatLng(latLng.latitude,latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(Spain).title("Murcia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Spain));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);

        mMap.clear();
        LatLng Spain = new LatLng(latLng.latitude,latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(Spain).title("Murcia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Spain));
    }
}