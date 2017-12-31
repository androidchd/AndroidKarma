package com.KarmaLakeLand1;

import java.util.Locale;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Contactus extends Fragment implements OnClickListener {
    MapView mapView;
    GoogleMap map;
//    GPSTracker gps;
    TextView tvHeadOffice, tvTechnical;
    LinearLayout ivDirection, ivCall, ivMail;
    double destinationLatitude = 28.365864;
    double destinationLongitude = 76.955664;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contactus, container, false);
        String mail = "karma.apphelpdesk@gmail.com";
        // Gets the MapView from the XML layout and creates it
        tvHeadOffice = (TextView) v.findViewById(R.id.tv_Head_office);
        ivDirection = (LinearLayout) v.findViewById(R.id.ivDirection);
        ivCall = (LinearLayout) v.findViewById(R.id.ivCall);
        ivMail = (LinearLayout) v.findViewById(R.id.ivMail);
        ivMail.setOnClickListener(this);
        ivCall.setOnClickListener(this);
        ivDirection.setOnClickListener(this);
        tvTechnical = (TextView) v.findViewById(R.id.tv_technical_support);
        tvTechnical.setText("Email-ID - " + mail);
        //tvHeadOffice.setText();
        try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            Log.e("Address Map", "Could not initialize google play", e);
        }
        // gps = new GPSTracker(mgetActivity());
        switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity())) {
            case ConnectionResult.SUCCESS:

                mapView = (MapView) v.findViewById(R.id.map);
                mapView.onCreate(savedInstanceState);
                // Gets to GoogleMap from the MapView and does initialization stuff
                mapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap mMap) {
                        map = mMap;

                        // For showing a move to my location button
                        // map.setMyLocationEnabled(true);

                        // For dropping a marker at a point on the Map
                        LatLng KarmaLakeLand = new LatLng(28.365864, 76.955664);
                        map.addMarker(new MarkerOptions().position(KarmaLakeLand).title("Karma LakeLand  Sector 80, Gurgaon, Haryana 201301, \n011 40644400").snippet("Marker Description")).showInfoWindow();

                        // For zooming automatically to the location of the marker
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(KarmaLakeLand).zoom(12).build();
                        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    }
                });
                break;
            case ConnectionResult.SERVICE_MISSING:

                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:

                break;
            default:



                 /*  map = mapView.getMap();
                    map.getUiSettings().setMyLocationButtonEnabled(false);
                    map.setMyLocationEnabled(true);
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(28.365864, 76.955664), 10);
                    map.animateCamera(cameraUpdate);
                    
                    Marker marker = map.addMarker(new MarkerOptions()
                    .title("Karma LakeLand  Sector 80, Gurgaon, Haryana 201301, \n011 40644400")
                    .position(
                            new LatLng(28.365864,76.955664)));
                   marker.showInfoWindow();*/

               /* break;
            case ConnectionResult.SERVICE_MISSING: 
               
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED: 
              
                break;
            default: 
        }*/
//
//                mapView.setOnClickListener(new OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        // TODO Auto-generated method stub
//                        if (gps.canGetLocation()) {
//                            String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 28.365864, 76.955664);
//                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//                            startActivity(intent);
//                        } else {
//                            gps.showSettingsAlert();
//                        }
//
//
//                    }
//                });


                // Updates the location and zoom of the MapView


        }
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


    public static Contactus newInstance(String text) {

        Contactus f = new Contactus();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivDirection:
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", destinationLatitude, destinationLongitude, "Karma LakeLand");
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(String.valueOf(Uri.parse(uri))));
                startActivity(intent);
                break;
            case R.id.ivCall:
                String mobileNumber = "+911140644400";
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mobileNumber));
                callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
                break;
            case R.id.ivMail:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri
                        .fromParts("mailto", "kamal@lakelands.com",
                                null));
                emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                emailIntent.putExtra(Intent.EXTRA_EMAIL,
                        "test@gmail.com");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        "Report Golf Issue");
                startActivity(emailIntent);
                break;
        }
    }
}