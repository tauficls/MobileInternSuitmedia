package com.taufic.eventapps;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.taufic.eventapps.Adapter.PhotoAdapter;

import java.util.ArrayList;

/**
 * Created by taufic on 4/5/2017.
 */

public class EventTwo extends Fragment implements OnMapReadyCallback {

    private View eventTwo;
    private Context mContext;

    private RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private GoogleMap mMap;
    private MapView mapView;

    public EventTwo() {

    }
    // Initialize a new BroadcastReceiver instance
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Receive the broadcast message
            int receivePhoto = intent.getIntExtra("PHOTOS",0);
            //setmap
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        eventTwo = inflater.inflate(R.layout.mapview, container, false);
        Bundle bundle = getArguments();
        if(bundle != null) {
            int[] pics = bundle.getIntArray("Photos");
            int[] longitude = bundle.getIntArray("Lng");
            int[] latitude = bundle.getIntArray("Lat");
        }
        mContext = eventTwo.getContext();

        // Register the Local Broadcast
        LocalBroadcastManager.getInstance(mContext).registerReceiver(
                mBroadcastReceiver,
                new IntentFilter("BROADCAST_PHOTO")
        );

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) eventTwo.findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) eventTwo.findViewById(R.id.recycler_view);

        // Specify a layout for RecyclerView
        // Create a horizontal RecyclerView
        mLayoutManager = new LinearLayoutManager(
                mContext,
                LinearLayoutManager.HORIZONTAL,
                false
        );
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initialize photo list
        ArrayList<Integer> photos = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            photos.add(R.mipmap.ic_launcher);
        }

        // Initialize a new Adapter for RecyclerView
        mAdapter = new PhotoAdapter(mContext,photos);

        // Set an adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);




        return eventTwo;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) eventTwo.findViewById(R.id.map);
        if(mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(this.getActivity());
        mMap = googleMap;
        mMap.setMapType(mMap.MAP_TYPE_NORMAL);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}
