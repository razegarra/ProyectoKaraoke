package com.example.android.proyectokaraoke;

import android.Manifest;
import android.content.pm.PackageManager;


import android.graphics.Color;
import android.location.Location;
import android.support.annotation.NonNull;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class UbicameActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    LatLng myUbicacion;
    LatLng lima = new LatLng(-12.136605, -77.006035);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicame);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //FragmentManager manager=this.getSupportFragmentManager();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions()
                .position(lima)
                .title("KARAOKE")
                .snippet("Punto de Encuentro")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_dialog2)));
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lima, 17.0f));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(UbicameActivity.this,marker.getSnippet(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d("PROYECTO KARAOKE", "NO HAY PERMISOSSSSSSSS XXXXXXXXXXXXX_XXXXXXXXXXXXX_XXXXXXXXXXXX_XXXXXXXXXXXXXXX");
            return;
        }
        mMap.setMyLocationEnabled(true);

    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d("PROYECTO KARAOKE", "NO HAY PERMISOSSSSSSSS XXXXXXXXXXXXX_XXXXXXXXXXXXX_XXXXXXXXXXXX_XXXXXXXXXXXXXXX");

            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            myUbicacion = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(myUbicacion).title("Mi Ubicación").snippet("Aqui te encuentras"));
            mMap.addPolyline(new PolylineOptions()
                    .add(myUbicacion, lima)
                    .width(5)
                    .color(Color.RED));

            //'-12.059642, -77.035461
            //'-12.1295, -77.0015
            //LatLngBounds distancia = new LatLngBounds(lima,myUbicacion);
            //mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(distancia, 0));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lima, 15));
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 6000, null);
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(myUbicacion)      // Sets the center of the map to Mountain View
                    .zoom(17)                   // Sets the zoom
                    .build();                   // Creates a CameraPosition from the builder
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myUbicacion, 17.0f));

        }



    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d("PROYECTO KARAOKE","PASO POR AQUI onConnectionSuspended XXXXXXXXXXXXX_XXXXXXXXXXXXX_XXXXXXXXXXXX_XXXXXXXXXXXXXXX");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("PROYECTO KARAOKE","PASO POR AQUI onConnectionFailed XXXXXXXXXXXXX_XXXXXXXXXXXXX_XXXXXXXXXXXX_XXXXXXXXXXXXXXX");
    }
}
