package ru.mirea.utts.mireaproject.ui.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import ru.mirea.utts.mireaproject.R;

public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {
    protected static GoogleMap map;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            MapsFragment.map = googleMap;

            LatLng Mirea1 = new LatLng(55.6695953, 37.4798824);
            map.addMarker(new MarkerOptions().position(Mirea1).title(getResources().getString(R.string.Mirea1))
                    .snippet(getResources().getString(R.string.Mirea1Snippet)));


            LatLng Mirea2 = new LatLng(55.6618971, 37.4745255);
            map.addMarker(new MarkerOptions().position(Mirea2).title(getResources().getString(R.string.Mirea2))
                    .snippet(getResources().getString(R.string.Mirea2Snippet)));

            LatLng Mirea3 = new LatLng(55.7938058, 37.7000664);
            map.addMarker(new MarkerOptions().position(Mirea3).title(getResources().getString(R.string.Mirea3))
                    .snippet(getResources().getString(R.string.Mirea3Snippet)));


            LatLng Mirea4 = new LatLng(55.7317977, 37.5745506);
            map.addMarker(new MarkerOptions().position(Mirea4).title(getResources().getString(R.string.Mirea4))
                    .snippet(getResources().getString(R.string.Mirea4Snippet)));


            LatLng Mirea5 = new LatLng(55.7648399, 37.7392163);
            map.addMarker(new MarkerOptions().position(Mirea5).title(getResources().getString(R.string.Mirea5))
                    .snippet(getResources().getString(R.string.Mirea5Snippet)));

            LatLng Mirea6 = new LatLng(55.7250254, 37.6304868);
            map.addMarker(new MarkerOptions().position(Mirea6).title(getResources().getString(R.string.Mirea6))
                    .snippet(getResources().getString(R.string.Mirea6Snippet)));


            LatLng Mirea7 = new LatLng(55.728676, 37.5708812);
            map.addMarker(new MarkerOptions().position(Mirea7).title(getResources().getString(R.string.Mirea7))
                    .snippet(getResources().getString(R.string.Mirea7Snippet)));

            LatLng Mirea8 = new LatLng(45.0508385, 41.9097125);
            map.addMarker(new MarkerOptions().position(Mirea8).title(getResources().getString(R.string.Mirea8))
                    .snippet(getResources().getString(R.string.Mirea8Snippet)));

            LatLng Mirea9 = new LatLng(55.9604333, 38.049562);
            map.addMarker(new MarkerOptions().position(Mirea9).title(getResources().getString(R.string.Mirea9))
                    .snippet(getResources().getString(R.string.Mirea9Snippet)));

            LatLng moscow = new LatLng(55.5815244, 36.8251221);
            map.moveCamera(CameraUpdateFactory.newLatLng(moscow));
            map.getUiSettings().setZoomControlsEnabled(true);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapClickListener(this);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.setTrafficEnabled(true);
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                latLng).zoom(12).build();
        map.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        map.addMarker(new MarkerOptions().title("Где я?")
                .snippet("Новое место").position(latLng));
    }
}

