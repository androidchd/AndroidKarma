package com.KarmaLakeLand1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import Helper.App_Common;
import Helper.Prefs;

public class splash extends Activity {

    private static final int REQUEST_LOCATION = 0;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;
    boolean isLogin = false;
    long Delay = 5000;
    Activity activity;

    static ArrayList<Contacts> contacts = new ArrayList<Contacts>();
    boolean isGPSEnabled = false;
    boolean statusOfGPS;
    // flag for network status

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
        statusOfGPS= manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (statusOfGPS) {

        }else {
            showSettingsAlert();
        }

        // StartAnimations();
        //new Allbooking.Allbookingapi().execute();
        preferences = getSharedPreferences(Prefs.Prefrence, MODE_PRIVATE);
        editor = preferences.edit();

        isLogin = App_Common.getInstance(splash.this).getLoginStatus();

        Timer RunSplash = new Timer();

        // Task to do when the timer ends
        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run() {
                // Close SplashScreenActivity.class
                try {
                    if (isNetworkConnected()) {
                        if (isLogin) {
                            Intent myIntent = new Intent(splash.this, BookingSelection.class);
                            startActivity(myIntent);
                            splash.this.overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);

                        } else {
                            Intent myIntent = new Intent(splash.this, SignIn.class);
                            startActivity(myIntent);
                            splash.this.overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);

                        }
                    } else {
                        Toast.makeText(activity, "Check you Internet Connection", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {

                }
            }
        };


        // Start the timer
        RunSplash.schedule(ShowSplash, Delay);

    }

    public static boolean networkChk(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
    /*public void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(splash.this, R.anim.splash_b);
        anim.reset();
       *//* ImageView ivLogo = (ImageView) findViewById(R.id.iv_splash);
        ivLogo.clearAnimation();
        ivLogo.startAnimation(anim);*//*

        anim = AnimationUtils.loadAnimation(splash.this, R.anim.splash_b);
        anim.reset();
        TextView ivScissor = (TextView) findViewById(R.id.tv_powered);
        ivScissor.clearAnimation();
        ivScissor.startAnimation(anim);

       *//* anim = AnimationUtils.loadAnimation(splash.this, R.anim.splash_a);
        anim.reset();
       // TextView tvSplash = (TextView) findViewById(R.id.tv_golf);
        tvSplash.setVisibility(View.VISIBLE);
        tvSplash.clearAnimation();
        tvSplash.startAnimation(anim);*//*


    }
*/

    public void permission() {
        if (ActivityCompat.checkSelfPermission(splash.this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(splash.this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(splash.this,
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,
                            android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Log.e("DB", "PERMISSION GRANTED");
        }
    }

    public void showSettingsAlert() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(splash.this);
        // Setting Dialog Title
        alertDialog.setTitle("GPS Settings");
        // Setting Dialog Message
        alertDialog.setMessage("GPS is not active. Do you want to open?");
        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                splash.this.startActivity(intent);
            }
        });
        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

}











//    private static final int REQUEST_LOCATION = 0;
//    SharedPreferences preferences;
//    SharedPreferences.Editor editor;
//    Context context;
//    boolean isLogin = false;
//    long Delay = 5000;
//    Activity activity;
//
//    static ArrayList<Contacts> contacts = new ArrayList<Contacts>();
//    boolean statusOfGPS;
//
//    // flag for network status
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.splash);
//
//        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//
//
//        if (statusOfGPS) {
//
//        } else {
//            showSettingsAlert();
//        }
//
//        // StartAnimations();
//        //new Allbooking.Allbookingapi().execute();
//
//        preferences = getSharedPreferences(Prefs.Prefrence, MODE_PRIVATE);
//        editor = preferences.edit();
//
//        isLogin = App_Common.getInstance(splash.this).getLoginStatus();
//
//        Timer RunSplash = new Timer();
//
//        // Task to do when the timer ends
//        TimerTask ShowSplash = new TimerTask() {
//            @Override
//            public void run() {
//                // Close SplashScreenActivity.class
//                try {
//                    if (isNetworkConnected()) {
//                        if (isLogin) {
//                            Intent myIntent = new Intent(splash.this, BookingSelection.class);
//                            startActivity(myIntent);
//                            splash.this.overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);
//
//                        } else {
//                            Intent myIntent = new Intent(splash.this, SignIn.class);
//                            startActivity(myIntent);
//                            splash.this.overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);
//                        }
//                    } else {
//                        Toast.makeText(activity, "Check you Internet Connection", Toast.LENGTH_LONG).show();
//                    }
//                } catch (Exception e) {
//
//                }
//            }
//        };
//
//        RunSplash.schedule(ShowSplash, Delay);
//    }
//
//    public static boolean networkChk(Context context) {
//        ConnectivityManager connectivity = (ConnectivityManager) context
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (connectivity != null) {
//            NetworkInfo[] info = connectivity.getAllNetworkInfo();
//            if (info != null)
//                for (int i = 0; i < info.length; i++)
//                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
//                        return true;
//                    }
//        }
//        return false;
//    }
//
//    private boolean isNetworkConnected() {
//        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        return cm.getActiveNetworkInfo() != null;
//    }
//    /*public void StartAnimations() {
//        Animation anim = AnimationUtils.loadAnimation(splash.this, R.anim.splash_b);
//        anim.reset();
//       *//* ImageView ivLogo = (ImageView) findViewById(R.id.iv_splash);
//        ivLogo.clearAnimation();
//        ivLogo.startAnimation(anim);*//*
//
//        anim = AnimationUtils.loadAnimation(splash.this, R.anim.splash_b);
//        anim.reset();
//        TextView ivScissor = (TextView) findViewById(R.id.tv_powered);
//        ivScissor.clearAnimation();
//        ivScissor.startAnimation(anim);
//
//       *//* anim = AnimationUtils.loadAnimation(splash.this, R.anim.splash_a);
//        anim.reset();
//       // TextView tvSplash = (TextView) findViewById(R.id.tv_golf);
//        tvSplash.setVisibility(View.VISIBLE);
//        tvSplash.clearAnimation();
//        tvSplash.startAnimation(anim);*//*
//
//
//    }
//*/
//    public void permission() {
//        if (ActivityCompat.checkSelfPermission(splash.this,
//                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(splash.this,
//                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(splash.this,
//                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,
//                            android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
//        } else {
//            Log.e("DB", "PERMISSION GRANTED");
//        }
//    }
//
//    public void showSettingsAlert() {
//
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(splash.this);
//        // Setting Dialog Title
//        alertDialog.setTitle("GPS Settings");
//        // Setting Dialog Message
//        alertDialog.setMessage("GPS is not active. Do you want to open?");
//        // On pressing Settings button
//        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                splash.this.startActivity(intent);
//            }
//        });
//        // on pressing cancel button
//        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//        // Showing Alert Message
//        alertDialog.show();
//    }
//}
