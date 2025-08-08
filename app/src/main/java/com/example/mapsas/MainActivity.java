package com.example.mapsas;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {
    GoogleMap mapa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;

        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);

        CameraUpdate camUpd1 =
CameraUpdateFactory
.newLatLngZoom(new LatLng(-1.01235, -79.4694),17);
mapa.moveCamera(camUpd1);


        PolylineOptions lineas = new PolylineOptions()
.add(new LatLng(-1.0118607532168495, -79.47195046357629))
.add(new LatLng(-1.0132660112399545, -79.4719182770691))
.add(new LatLng(-1.0136092802827519, -79.4672726911961))
.add(new LatLng(-1.0126545631673562, -79.46710102982435))
                .add(new LatLng(-1.0118607532168495, -79.47195046357629));

lineas.width(8);
lineas.color(Color.RED);
mapa.addPolyline(lineas);

        LatLng punto =
                new LatLng(-1.0125580187242953, -79.4696115773862);
        mapa.addMarker(new MarkerOptions().position(punto)
                .title("UTEQ"));


    }
}
