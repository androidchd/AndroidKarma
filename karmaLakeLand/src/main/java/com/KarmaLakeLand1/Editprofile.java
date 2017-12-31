package com.KarmaLakeLand1;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;


import Helper.App_Common;
import Helper.Prefs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Editprofile extends Activity implements OnClickListener, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks{

    EditText name, number, emailId;
    TextView userProfileName;
    ImageButton favriot;
//    Boolean LoginStatus;
    LinearLayout editName;
    TextView username;
    TextView mobilenumber;
    Boolean gmailStatus = false;
    GoogleApiClient mGoogleApiClient;
    SharedPreferences prefrence;
    SharedPreferences.Editor editor;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN).build();
        favriot = (ImageButton) findViewById(R.id.favriot);
        favriot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });



        prefrence = getSharedPreferences(Prefs.Prefrence, MODE_PRIVATE);
        editor = prefrence.edit();
        username = (TextView) findViewById(R.id.rusername);
        mobilenumber = (TextView) findViewById(R.id.ruserNo);
        gmailStatus = prefrence.getBoolean(Prefs.GmailLOGIN, Boolean.parseBoolean(null));

        editName = (LinearLayout) findViewById(R.id.yourName);
        userProfileName = (TextView) findViewById(R.id.user_profile_name);
        emailId = (EditText) findViewById(R.id.yourID);
        number = (EditText) findViewById(R.id.yourNumber);

        editName.setOnClickListener(this);
        emailId.setOnClickListener(this);
        number.setOnClickListener(this);

		
		/*((TextView) findViewById(R.id.yourID)).setText(App_Common.getInstance(
                this).getUserEmailId());*/
        emailId.setText(App_Common.getInstance(this).getUserEmailId());
       // name.setText(App_Common.getInstance(this).getUserName());
        userProfileName.setText(App_Common.getInstance(this).getUserName());
        number.setText(App_Common.getInstance(this).getUserNumber());

        logout = (Button) findViewById(R.id.logout);
        //logout.setTypeface(type2);
        logout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(isNetworkConnected()){
                gmailStatus = prefrence.getBoolean(Prefs.GmailLOGIN, Boolean.parseBoolean(null));
                if (gmailStatus == true) {
                    if (mGoogleApiClient.isConnected()) {
                        Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                        mGoogleApiClient.disconnect();
                        mGoogleApiClient.connect();
                        prefrence.edit().clear().apply();
                    }
                }


                App_Common.getInstance(Editprofile.this).setUserEmailId("");
                App_Common.getInstance(Editprofile.this).setUserPwd("");
                App_Common.getInstance(Editprofile.this).setLoginS(false);
                App_Common.getInstance(Editprofile.this).setTimeselected("");
                App_Common.getInstance(Editprofile.this).setDate("");
                App_Common.getInstance(Editprofile.this).setHolescore1("");
                App_Common.getInstance(Editprofile.this).setHolescore2("");
                App_Common.getInstance(Editprofile.this).setHolescore3("");
                App_Common.getInstance(Editprofile.this).setHolescore4("");
                App_Common.getInstance(Editprofile.this).setHolescore5("");
                App_Common.getInstance(Editprofile.this).setHolescore6("");
                App_Common.getInstance(Editprofile.this).setHolescore7("");
                App_Common.getInstance(Editprofile.this).setHolescore8("");
                App_Common.getInstance(Editprofile.this).setHolescore9("");
                App_Common.getInstance(Editprofile.this).setHolescore10("");
                App_Common.getInstance(Editprofile.this).setHolescore11("");
                App_Common.getInstance(Editprofile.this).setHolescore12("");
                App_Common.getInstance(Editprofile.this).setHolescore13("");
                App_Common.getInstance(Editprofile.this).setHolescore14("");
                App_Common.getInstance(Editprofile.this).setHolescore15("");
                App_Common.getInstance(Editprofile.this).setHolescore16("");
                App_Common.getInstance(Editprofile.this).setHolescore17("");
                App_Common.getInstance(Editprofile.this).setHolescore18("");


                //mDrawerLayout.closeDrawers();
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }else {
                    Toast.makeText(Editprofile.this, "Check you Internet Connection", Toast.LENGTH_LONG).show();
                }
                }
        });


        findViewById(R.id.changePassword).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getBaseContext(),
                                ChangePwdActivity.class);
                        startActivity(intent);
                    }
                });

        /*findViewById(R.id.changeName).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // name.setFocusable(true);
                // name.setFocusableInTouchMode(true);
                // name.requestFocus();
                // final InputMethodManager imm = (InputMethodManager)
                // getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                // imm.showSoftInput(name, InputMethodManager.SHOW_IMPLICIT);
                Intent intent = new Intent(getBaseContext(),
                        ChangeNameActivity.class);
                startActivity(intent);
            }
        });*/

		/*findViewById(R.id.changeNumber).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// number.setFocusable(true);
						// number.setFocusableInTouchMode(true);
						// number.requestFocus();
						// final InputMethodManager imm = (InputMethodManager)
						// getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
						// imm.showSoftInput(number,
						// InputMethodManager.SHOW_IMPLICIT);
						Intent intent = new Intent(getBaseContext(),
								ChangeNumberActivity.class);
						startActivity(intent);
					}
				});*/

    }

    @Override
    protected void onStart() {
        userProfileName.setText(App_Common.getInstance(this).getUserName());
        number.setText(App_Common.getInstance(this).getUserNumber());
        super.onStart();
        mGoogleApiClient.connect();
        //	GoogleAnalytics.getInstance(ProfileActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onResume() {
        userProfileName.setText(App_Common.getInstance(this).getUserName());
        number.setText(App_Common.getInstance(this).getUserNumber());
        super.onResume();
    }

    @Override
    protected void onPause() {
        userProfileName.setText(App_Common.getInstance(this).getUserName());
        number.setText(App_Common.getInstance(this).getUserNumber());
        super.onPause();
    }


    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
        super.onBackPressed();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.yourName:
                userProfileName.setFocusable(true);
                userProfileName.setFocusableInTouchMode(true);
                userProfileName.requestFocus();
                final InputMethodManager immName = (InputMethodManager)
                        getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                immName.showSoftInput(userProfileName, InputMethodManager.SHOW_IMPLICIT);
                Intent intentName = new Intent(getBaseContext(),
                        ChangeNameActivity.class);
                startActivity(intentName);
                break;*/

            /*case R.id.yourNumber:
                number.setFocusable(true);
                number.setFocusableInTouchMode(true);
                number.requestFocus();
                final InputMethodManager immNumber = (InputMethodManager)
                        getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                immNumber.showSoftInput(number, InputMethodManager.SHOW_IMPLICIT);
                Intent intentNumber = new Intent(getBaseContext(),
                        ChangeNumberActivity.class);
                startActivity(intentNumber);

                break;*/
           /* case R.id.yourID:
                emailId.setFocusable(true);
                emailId.setFocusableInTouchMode(true);
                emailId.requestFocus();
                final InputMethodManager immEmailId = (InputMethodManager)
                        getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                immEmailId.showSoftInput(emailId, InputMethodManager.SHOW_IMPLICIT);
                Intent intentEmail = new Intent(getBaseContext(),
                        ChangeEmailIDActivity.class);
                startActivity(intentEmail);*/
        }

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}



