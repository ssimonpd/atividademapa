package com.example.atividademapa;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.atividademapa.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private ActivityMapsBinding binding;
    private GoogleMap mMap;
    double latitude, longitude;
    //EditText mtxtlatitude;
    //EditText mtxtlongitude;

    //double lat = Double.parseDouble(Tela_inicial.mtxtlatitude.getText().toString());
   //double log = Double.parseDouble(Tela_inicial.mtxtlongitude.getText().toString());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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
            public void onMapReady(GoogleMap googleMap){
                double lat = Double.parseDouble(Tela_inicial.mtxtlatitude.getText().toString());
                double log = Double.parseDouble(Tela_inicial.mtxtlongitude.getText().toString());
                longitude = log;
           latitude =lat;

            mMap = googleMap;
            String local = "Você está aqui";


            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            mMap.addMarker(new MarkerOptions()
                    .position(sydney)
                    .snippet("Você está aqui")
                    .title(local));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 11));


            CircleOptions circleOptions = new CircleOptions();

            circleOptions.center(sydney);
            circleOptions.fillColor(Color.argb(50, 255, 0, 0));
            circleOptions.strokeWidth(10);
            circleOptions.strokeColor(Color.argb(50, 255, 0, 0));
            circleOptions.radius(10000.00);
            mMap.addCircle(circleOptions);



        }
    }

