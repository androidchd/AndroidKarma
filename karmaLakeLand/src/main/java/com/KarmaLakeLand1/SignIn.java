package com.KarmaLakeLand1;

//import java.util.ArrayList;
//import java.util.List;

import org.json.JSONObject;

import Helper.App_Common;
//import Helper.Validation;
import Utility.WebService;

//import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.facebook.LoginActivity;
import com.facebook.*;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;


public class SignIn extends FragmentActivity implements OnClickListener/*, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener */ {

//    private static ProgressDialog ringProgressDialog;
    Button registernewaccount;
    Button login;
    EditText username;
    String userNameStr;
    String resultUserNameStr;
    Context context;
    String passwordStr;
    EditText password;
//    String userID;
//    String emailID;
//    String mobile_number;
//    boolean gmail = false;
//    boolean FB = false;
//    boolean memberstatus = true;
    TextView forgetpassword;
//    List<EditText> lisEditTexts;
//    Activity activity;
//    String eMail;
//    SharedPreferences preferences;
//    SharedPreferences.Editor editor;
    String bindParameter;
//    private static String APP_ID = "1068514146565266";
//    private static final int RC_SIGN_IN = 100;
//    LoginButton facebookbtn;
//    SignInButton gmailSignIn;
//    CallbackManager callbackManager;
//    String personName;
//    EditText dialogEmail, dialogMobile;
//    String personPhotoUrl;
//    String email;
//    String facebookid;
//    boolean faceBookStatus = false;
//    boolean isGmail = false;
//    boolean isFaceBook = false;
//    String strDialogEmail, strDialogMobile;// Logcat tag
//    private static final String TAG = "MainActivity";
//    // Profile pic image size in pixels
//    private static final int PROFILE_PIC_SIZE = 400;
//    // Google client to interact with Google API
//    private GoogleApiClient mGoogleApiClient;
//    GoogleSignInOptions gso;
//    /**
//     * A flag indicating that a PendingIntent is in progress and prevents us
//     * from starting further intents.
//     */
//    private boolean mIntentInProgress;
//
//    private boolean mSignInClicked;
//
//    private ConnectionResult mConnectionResult;
//    String get_id, get_gender, get_email, profile_image;
    String get_name;
    public static Bitmap bitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* FacebookSdk.sdkInitialize(this.getApplicationContext());
        AppEventsLogger.activateApp(this);
        FacebookSdk.setApplicationId(APP_ID);*/
        setContentView(R.layout.signin);
        initialiseUI();
        // facebookLogin();
        //getLogin();

    }

    public void initialiseUI() {

        username = (EditText) findViewById(R.id.usernamemailID);
        password = (EditText) findViewById(R.id.password);
        registernewaccount = (Button) findViewById(R.id.register);
        registernewaccount.setOnClickListener(this);
        forgetpassword = (TextView) findViewById(R.id.tvforgetpasswd);
        forgetpassword.setOnClickListener(this);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        // gmailSignIn = (SignInButton) findViewById(R.id.gmail_Login);
        // gmailSignIn.setOnClickListener(this);
        // getLoginstatus();
    }

   /* public void getLoginstatus() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN)
                //.addScope(Plus.SCOPE_PLUS_PROFILE)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

    }*/

    /* public void showTextDialogFacebook() {
         final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
         dialogBuilder.show();
         LayoutInflater inflater = this.getLayoutInflater();
         final View dialogView = inflater.inflate(R.layout.text_dialog, null);
         dialogBuilder.setView(dialogView);

         dialogEmail = (EditText) dialogView.findViewById(R.id.et_dialog_email);
         dialogMobile = (EditText) dialogView.findViewById(R.id.et_dialog_mobile);

         dialogBuilder.setTitle("Email and Mobile necessery");
         dialogBuilder.setMessage("Enter text below");


         dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int whichButton) {
                 strDialogEmail = dialogEmail.getText().toString();
                 strDialogMobile = dialogEmail.getText().toString();
                 boolean entriesValid = true;

                 try {
                     if (TextUtils.isEmpty(strDialogEmail)) {
                         dialogEmail.setError("Please enter a value");
                         entriesValid = false;
                     } else if (TextUtils.isEmpty(strDialogMobile)) {
                         dialogMobile.setError("Please enter a value");
                         entriesValid = false;
                     }else {
                         dialog.dismiss();
                         App_Common.getInstance(SignIn.this).setUserEmailId(strDialogEmail);
                         App_Common.getInstance(SignIn.this).setUserNumber(strDialogMobile);
                         new SocialAppRegisteration().execute();
                         entriesValid=true;
                     }
                 } catch (Exception e) {
                     entriesValid = false;
                 }

             }
         });


         dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int whichButton) {
                 App_Common.getInstance(getApplicationContext()).setGmailStatus(false);
                 disconnectFromFacebook();
                 dialog.dismiss();
             }
         });

         AlertDialog negtive = dialogBuilder.create();
         negtive.show();
     }

     public void showTextDialogGmail() {
         final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
         dialogBuilder.show();
         LayoutInflater inflater = this.getLayoutInflater();
         final View dialogView = inflater.inflate(R.layout.text_dialog, null);
         dialogBuilder.setView(dialogView);

         dialogEmail = (EditText) dialogView.findViewById(R.id.et_dialog_email);
         dialogMobile = (EditText) dialogView.findViewById(R.id.et_dialog_mobile);

         dialogBuilder.setTitle("Email and Mobile necessery");
         dialogBuilder.setMessage("Enter text below");
         dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int whichButton) {

                 boolean validator = true;

                 strDialogEmail = dialogEmail.getText().toString();
                 strDialogMobile = dialogMobile.getText().toString();
                 try {
                     if (strDialogEmail.isEmpty()) {
                         dialogEmail.setError("Enter Valid Email");
                         validator = false;
                     } else if (strDialogMobile.isEmpty()) {
                         dialogMobile.setError("Enter Valid Number");

                         validator = false;
                     } else {
                         dialog.dismiss();
                         new Socialgoogleplus().execute();

                     }
                 } catch (EmptyStackException ee) {
                     validator = false;
                 }
             }

         });
         dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int whichButton) {
                 App_Common.getInstance(getApplicationContext()).setGmailStatus(false);

                 if (mGoogleApiClient.isConnected()) {
                     Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                     mGoogleApiClient.disconnect();
                    // mGoogleApiClient.connect();
                     // updateUI(false);
                 }
                 //  signOutFromGplus();
                 dialog.dismiss();
             }
         });
         AlertDialog b = dialogBuilder.create();
         b.show();
     }


     public void facebookLogin() {
         isFaceBook = true;
         facebookbtn = (LoginButton) findViewById(R.id.facebookbtn);
         callbackManager = CallbackManager.Factory.create();
         faceBookStatus = App_Common.getInstance(getApplicationContext()).getFacebookStatus();
         if (faceBookStatus == false) {
             disconnectFromFacebook();
         }
         LoginManager.getInstance().registerCallback(callbackManager,
                 new FacebookCallback<LoginResult>() {
                     @Override
                     public void onSuccess(final LoginResult loginResult) {
                         // getInformation();

                         final GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                             @Override
                             public void onCompleted(JSONObject object, GraphResponse response) {

                                 if (response != null) {
                                     try {
                                         get_name = object.optString("name", "");
                                         App_Common.getInstance(getApplicationContext()).setUserName(get_name);
                                         // If you asked for email permission
                                         get_id = object.optString("id", "");
                                         facebookid = object.getString("id");
                                         App_Common.getInstance(getApplicationContext()).setFacebookID(facebookid);
                                         //get_name = object.optString("first_name", "");
                                         // get_name = object.optString("last_name", "");
                                         get_gender = object.optString("gender", "");
                                         String locale = object.optString("locale", "");
                                         String timezone = object.optString("timezone", "");
                                         String updated_time = object.optString("updated_time", "");
                                         String link = object.optString("link", "");
                                         get_email = object.getString("email");
                                         App_Common.getInstance(getApplicationContext()).setUserEmailId(get_email);

                                         // new AsynhTakFacebook().execute();
                                         String accessToken = loginResult.getAccessToken().getToken();
                                         //   setUserData(name, eMail, user_id, firstName, lastName, gender, locale, timezone, updated_time, link, accessToken);
                                         Log.i("FB mail iD", object.getString(eMail));

                                         // Log.e("USER DETAIL", "Name: " + name + " Email: " + eMail + "user_id" + user_id + "   ");*//**//**//**//*
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        Log.d("", "Exception e");
                                    }

                                }


                                Log.v("LoginActivity", response.toString());
                                // new AsynhTakFacebook().execute();
                                new AppFacebooklogin().execute();
                            }
                        });

                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email,gender, birthday,first_name,last_name,updated_time,timezone,locale,link");
                        request.setParameters(parameters);
                        request.executeAsync();

                        Log.d("LoginManager", "On Success");
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }

                });
    }




    public static void disconnectFromFacebook() {
        if (AccessToken.getCurrentAccessToken() == null) {
            return; // already logged out
        }

        new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/permissions/", null, HttpMethod.DELETE, new GraphRequest
                .Callback() {
            @Override
            public void onCompleted(GraphResponse graphResponse) {
                LoginManager.getInstance().logOut();

            }
        }).executeAsync();

    }*/
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                Intent registerIntent = new Intent(SignIn.this, AccountDetails.class);
                startActivity(registerIntent);
                break;
            case R.id.tvforgetpasswd:
                Intent forgotIntent = new Intent(SignIn.this, Forgetpassword.class);
                startActivity(forgotIntent);
                break;
            case R.id.login:

                userNameStr = username.getText().toString().trim();
                resultUserNameStr =userNameStr.toString().replaceAll(" ", "");

                passwordStr = password.getText().toString();
                App_Common.getInstance(SignIn.this).setUserPwd(password.getText().toString());
                if (isNetworkConnected()) {
                    if (userNameStr.isEmpty() && passwordStr.isEmpty()) {
                        username.setError("Please Provide Valid Input.");
                    } else {
                        new AppLogin().execute();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
           /* case R.id.gmail_Login:
                isGmail = true;
                signInWithGplus();
                // initGoogle();
               *//* ringProgressDialog = ProgressDialog.show(SignIn.this, null, "Processing ... ", true);
                ringProgressDialog.setCancelable(false);
*//*
                break;*/
          /*  case R.id.dialog_cancel:
                dialog.dismiss();
                break;
            case R.id.dialog_ok:
                new SocialAppRegisteration().execute();
                break;*/


    public class AppLogin extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {

            ringProgressDialog = ProgressDialog.show(SignIn.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            bindParameter = "/" + userNameStr + "/" + passwordStr;
            String userIdPwd = bindParameter;
            {
                try {

//                    JSONObject jsonObject = new JSONObject();

                    String response = WebService.GET(App_Common.WebServiceUrl + "userLogin" + userIdPwd);

                    Log.e("RESPONSE", response);

                    if (response == null || response.equals("")) {
                        return false;
                    } else {
                        JSONObject jsonresponse = new JSONObject(response);
                        String status = jsonresponse.getString("status");

                        if (status.contains("True")) {
                            App_Common.getInstance(getApplicationContext()).setLoginS(true);
                            App_Common.getInstance(getApplicationContext()).setRegistered(true);
                            String member = jsonresponse.getString("memberStatus");

                            if (member.contains("True")) {
                                App_Common.getInstance(getApplicationContext()).setMemeber(true);
                            } else {
                                App_Common.getInstance(getApplicationContext()).setMemeber(false);
                            }
                            App_Common.getInstance(getApplicationContext()).setUserName(jsonresponse.getString("userName"));
                            App_Common.getInstance(getApplicationContext()).setUserNumber(jsonresponse.getString("mobileNo"));
                            App_Common.getInstance(getApplicationContext()).setUserID(jsonresponse.getString("userId"));
                            App_Common.getInstance(getApplicationContext()).setUserEmailId(jsonresponse.getString("emailId"));
                            // App_Common.getInstance(getApplicationContext()).setUserPwd(password.getText().toString());
                            App_Common.getInstance(getApplicationContext()).setReferralcode(jsonresponse.getString("inviteCode"));
                            App_Common.getInstance(getApplicationContext()).setUserCode(jsonresponse.getString("userCode"));

                            String value = jsonresponse.getString("userCode");
                            Log.e("UserCode", value);


                            get_name = App_Common.getInstance(SignIn.this).getUserName();
                            return true;

                        } else {
                            return false;
                        }
                    }


                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return false;
                }
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {
                get_name = App_Common.getInstance(SignIn.this).getUserName();
                Toast.makeText(SignIn.this, "Welcome, " + get_name + " !", Toast.LENGTH_LONG).show();
                Intent i = new Intent(SignIn.this, BookingSelection.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);

                finish();
            } else {
                buildAlertMessage();
            }
        }
    }

    public void buildAlertMessage() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Email-ID or password not valid")
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog,
                                                final int id) {

                                dialog.dismiss();

                            }
                        });
        final AlertDialog alert = builder.create();
        alert.show();

    }

    /*public void mailAlartDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Email ID is Necessary")
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog,
                                                final int id) {
                                Intent mailIntent = new Intent(SignIn.this, ChangeEmailIDActivity.class);
                                startActivity(mailIntent);
                                dialog.dismiss();

                            }
                        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(final DialogInterface dialog,
                                final int id) {
                if (AccessToken.getCurrentAccessToken() != null) {
                    new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/permissions/", null, HttpMethod.DELETE, new GraphRequest
                            .Callback() {
                        @Override
                        public void onCompleted(GraphResponse graphResponse) {
                            LoginManager.getInstance().logOut();

                        }
                    });
                }else if (mGoogleApiClient.isConnected()) {
                        Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                        mGoogleApiClient.disconnect();
                        mGoogleApiClient.connect();
                        dialog.dismiss();

                } else {
                    Toast.makeText(SignIn.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        final AlertDialog alert = builder.create();
        alert.show();

    }
*/
//    boolean chkInputDialog() {
//        if (lisEditTexts.isEmpty()) {
//            lisEditTexts.add(dialogEmail);
//            lisEditTexts.add(dialogMobile);
//        }
//        for (EditText editText : lisEditTexts) {
//
//            if (editText.getText().toString().length() == 0) {
//                editText.setError("Please Provide Valid Input.");
//                return false;
//            }
//
//        }
//        return true;
//    }

//    boolean chkInputs() {
//
//        if (lisEditTexts.isEmpty()) {
//            lisEditTexts.add(username);
//            lisEditTexts.add(password);
//
//        }
//
//        for (EditText editText : lisEditTexts) {
//
//            if (editText.getText().toString().length() == 0) {
//                editText.setError("Please Provide Valid Input.");
//                return false;
//            }
//
//        }
//        return true;
//    }



//    public void getLogin() {
//        lisEditTexts = new ArrayList<EditText>();
//        username.setOnFocusChangeListener(new OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    if (!Validation.isValidEmail(username.getText().toString())) {
//                        username.setError("Please Provide a Valid Email-Id.");
//                    }
//                }
//            }
//        });
//
//        //     boolean isSave = App_Common.getInstance(SignIn.this).getLoginS();
//
//
//        //   username.setText("" + App_Common.getInstance(SignIn.this).getUserEmailId());
//        // password.setText("" + App_Common.getInstance(SignIn.this).getUserPwd());
//
//        if (!Validation.networkChk(SignIn.this)) {
//            Validation.serverNotConnectedDialog(SignIn.this);
//        } else if (chkInputs()) {
//            // new AppLogin().execute();
//
//        }
//
//    }


   /* protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
        //getProfileInformation();
        //  new Googlepluslogin().execute();
    }

    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    private void resolveSignInError() {
        if (mConnectionResult.hasResolution()) {
            try {
                mIntentInProgress = true;
                mConnectionResult.startResolutionForResult(this, RC_SIGN_IN);
            } catch (IntentSender.SendIntentException e) {
                mIntentInProgress = false;
                mGoogleApiClient.connect();
            }
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {

        if (!result.hasResolution()) {
            GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(), this,
                    0).show();
            return;
        }

        if (!mIntentInProgress) {
            // Store the ConnectionResult for later usage
            mConnectionResult = result;
            //Toast.makeText(SignIn.this, "failed", Toast.LENGTH_SHORT).show();
            if (mSignInClicked) {
                // The user has already clicked 'sign-in' so we attempt to
                // resolve all
                // errors until the user is signed in, or they cancel.
                resolveSignInError();
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode,
                                    Intent intent) {
        //  super.onActivityResult(requestCode, responseCode, intent);
        if (isGmail) {
            if (requestCode == RC_SIGN_IN) {
                if (responseCode != RESULT_OK) {
                    mSignInClicked = false;
                }

                mIntentInProgress = false;

                if (!mGoogleApiClient.isConnecting()) {
                    mGoogleApiClient.connect();
                }
            }
        } else if (isFaceBook) {
            super.onActivityResult(requestCode, responseCode, intent);
            callbackManager.onActivityResult(requestCode, responseCode, intent);
        } else {
            Toast.makeText(SignIn.this, "failed", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onConnected(Bundle arg0) {
        if (mGoogleApiClient.isConnected()) {

            mSignInClicked = false;
           //Toast.makeText(this, "Welcome User", Toast.LENGTH_LONG).show();

            // Get user's information
            // getProfileInformation();

            // new AsynhTak().execute();

            new Googlepluslogin().execute();
        } else {

            Toast.makeText(this, "User is not connected!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        mGoogleApiClient.disconnect();
        //   updateUI(false);
    }

    public void signInWithGplus() {


        if (!mGoogleApiClient.isConnecting()) {
            mSignInClicked = true;
            mGoogleApiClient.connect();
//                resolveSignInError();
        }
    }


    public void signOutFromGplus() {

        if (mGoogleApiClient.isConnected()) {
            Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
            mGoogleApiClient.disconnect();
            mGoogleApiClient.connect();
            // updateUI(false);
        } else {
            Toast.makeText(SignIn.this, "Welcome", Toast.LENGTH_SHORT).show();
        }

    }

    private void revokeGplusAccess() {
        if (mGoogleApiClient.isConnected()) {
            Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
            Plus.AccountApi.revokeAccessAndDisconnect(mGoogleApiClient)
                    .setResultCallback(new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status arg0) {
                            Log.e(TAG, "User access revoked!");
                            mGoogleApiClient.connect();

                        }

                    });
        }
    }

    public void getProfileInformation() {
        try {
            if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null) {
                Person currentPerson = Plus.PeopleApi
                        .getCurrentPerson(mGoogleApiClient);
                get_name = currentPerson.getDisplayName();
                App_Common.getInstance(SignIn.this).setUserName(get_name);
                get_id = currentPerson.getId();
                App_Common.getInstance(SignIn.this).setGmailID(get_id);
                personPhotoUrl = currentPerson.getImage().getUrl();
                String personGooglePlusProfile = currentPerson.getUrl();
                get_email = Plus.AccountApi.getAccountName(mGoogleApiClient);
                App_Common.getInstance(SignIn.this).setUserEmailId(get_email);


                Log.e(TAG, "Name: " + personName + ", plusProfile: "
                        + personGooglePlusProfile + ", email: " + email
                        + ", Image: " + personPhotoUrl);


                personPhotoUrl = personPhotoUrl.substring(0, personPhotoUrl.length() - 2) + PROFILE_PIC_SIZE;


            } else {
                Toast.makeText(getApplicationContext(),
                        "Person information is null", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    /* public class AppFacebooklogin extends AsyncTask<String, Void, Boolean> {

         protected ProgressDialog ringProgressDialog;


         @Override
         protected void onPreExecute() {
             ringProgressDialog = ProgressDialog.show(SignIn.this, null, "Processing ... ", true);
             ringProgressDialog.setCancelable(false);
             super.onPreExecute();
         }

         @Override
         protected Boolean doInBackground(String... params) {

             *//*App_Common.getInstance(getApplicationContext()).setUserName(get_name);
            App_Common.getInstance(getApplicationContext()).setUserEmailId(get_email);
            App_Common.getInstance(getApplicationContext()).setUserID(facebookid);*//*

            try {

                JSONObject jsonObject = new JSONObject();
                String bindParameter = "/" + get_email + "/" + facebookid;
                String response = WebService.GET(App_Common.WebServiceUrl + "userSocialLogin" + bindParameter);

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("status");
                    // String message = jsonresponse.getString("message");
                    userID = jsonresponse.getString("userId");
                    mobile_number = jsonresponse.getString("mobileNo");
                    try {
                        emailID = jsonresponse.getString("emailId");
                    } catch (NullPointerException e) {

                    }

                    if (status.contains("Email id and password is not correct!")) {
                        return false;
                    } else {
                        return true;

                    }
                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {
                if (emailID == null || emailID.equals("")) {
                    showTextDialogFacebook();
                } else {
                    App_Common.getInstance(SignIn.this).setUserEmailId(emailID);
                    // get_email = App_Common.getInstance(context).getUserEmailId();
                    App_Common.getInstance(SignIn.this).setUserID(userID);
                    App_Common.getInstance(SignIn.this).setUserNumber(mobile_number);
                    Toast.makeText(SignIn.this, "Welcome "+ get_name, Toast.LENGTH_LONG).show();
                    App_Common.getInstance(getApplicationContext()).setFaceBookStatus(Prefs.status);

                    Intent i = new Intent(SignIn.this, BookingSelection.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);
                }
            } else {
                showTextDialogFacebook();
            }
        }
    }


    public class Googlepluslogin extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            getProfileInformation();
            ringProgressDialog = ProgressDialog.show(SignIn.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);

        }

        @Override
        protected Boolean doInBackground(String... params) {
            String usermail;
            try {
                String socialID = App_Common.getInstance(getApplicationContext()).getGmailID();
                String userEmail = App_Common.getInstance(getApplicationContext()).getUserEmailId();
                if(userEmail==null||userEmail.equals("")){
                   usermail = null;
                }else {
                    usermail = null;
                }
                JSONObject jsonObject = new JSONObject();


                String bindParameter = "/" +  usermail + "/" +socialID;


                String response = WebService.GET(App_Common.WebServiceUrl + "userSocialLogin" + bindParameter);


                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("status");
                    userID = jsonresponse.getString("userId");
                    try {
                        emailID = jsonresponse.getString("emailId");
                        mobile_number=jsonresponse.getString("mobileNo");
                    } catch (NullPointerException e) {

                    }

                    if (status.contains("Email id and password is not correct!")) {
                        return false;
                    } else {

                        return true;
                    }
                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {
                if (emailID == null || emailID.equals("")) {
                    showTextDialogGmail();
                } else {

                    preferences = getSharedPreferences(Prefs.Prefrence, MODE_PRIVATE);
                    editor = preferences.edit();
                    editor.putBoolean(String.valueOf(Prefs.GmailLOGIN), Prefs.status);
                    editor.commit();
                    Toast.makeText(SignIn.this, "Welcome "+ get_name, Toast.LENGTH_LONG).show();
                    App_Common.getInstance(SignIn.this).setUserEmailId(emailID);
                    App_Common.getInstance(SignIn.this).setUserID(userID);
                    App_Common.getInstance(SignIn.this).setUserNumber(mobile_number);

                    Intent i = new Intent(SignIn.this, BookingSelection.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);

                }
                *//*gmail = true;
                mailAlartDialog();*//*


            } else {
                showTextDialogGmail();
            }
        }
    }


    public class SocialAppRegisteration extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;
        String userid = App_Common.getInstance(SignIn.this).getUserID();

        @Override
        protected void onPreExecute() {
            strDialogEmail = dialogEmail.getText().toString();
            strDialogMobile = dialogMobile.getText().toString();

            ringProgressDialog = ProgressDialog.show(SignIn.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {

            String dialogEmailID = strDialogEmail;
            String dialogMobileNumber = strDialogMobile;
            String getEmail = emailID;
            *//*String userId = userID;

            try {
                userId = App_Common.getInstance(SignIn.this).getUserID();
                userId = App_Common.getInstance(getApplicationContext()).getUserID();
            } catch (NullPointerException e) {
                userId = "";
            }

            userId = userID;*//*
            try {

                JSONObject jsonObject = new JSONObject();


                jsonObject.accumulate("userName", get_name);
                if (getEmail == null || getEmail.equals("")) {
                    jsonObject.accumulate("emailId", dialogEmailID);
                } else {
                    jsonObject.accumulate("emailId", emailID);
                }
                jsonObject.accumulate("mobileNo", dialogMobileNumber);
                jsonObject.accumulate("password", "");


                //		image    ,  socialId  , sType
                jsonObject.accumulate("sType", "FB");
                jsonObject.accumulate("socialId", facebookid);
                jsonObject.accumulate("inviteCode", "");
                try {
                    jsonObject.accumulate("userId", userid);
                } catch (NullPointerException e) {
                    jsonObject.accumulate("userId", "");
                }
                jsonObject.accumulate("memberStatus", "false");
                jsonObject.accumulate("membershipId", "false");


                Log.i("Input", jsonObject.toString());

                String response = WebService.POST(App_Common.WebServiceUrl + "userRegistration", jsonObject.toString());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String message = jsonresponse.getString("message");
                    userID = jsonresponse.getString("userid");
                    try {
                        emailID = jsonresponse.getString("emailid");
                    } catch (Exception e) {

                    }
                    return true;
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }

        }

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {

                // App_Common.getInstance(SignIn.this).setUserEmailId(strDialogEmail);


                App_Common.getInstance(SignIn.this).setUserName(get_name);
                App_Common.getInstance(getApplicationContext()).setFaceBookStatus(Prefs.status);
                App_Common.getInstance(SignIn.this).setUserID(userID);
                App_Common.getInstance(SignIn.this).setUserNumber(strDialogMobile);
                App_Common.getInstance(SignIn.this).setUserEmailId(strDialogEmail);

                Intent i = new Intent(SignIn.this, BookingSelection.class);
                Toast.makeText(SignIn.this, "Welcome "+ get_name, Toast.LENGTH_SHORT).show();
                startActivity(i);
                overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);

            } else {
                App_Common.getInstance(getApplicationContext()).setFaceBookStatus(false);
                disconnectFromFacebook();
               *//* App_Common.getInstance(SignIn.this).setUserName(get_name);
                App_Common.getInstance(getApplicationContext()).setFaceBookStatus(Prefs.status);
                App_Common.getInstance(SignIn.this).setUserEmailId(strDialogEmail);
                App_Common.getInstance(SignIn.this).setUserNumber(strDialogMobile);

                Intent i = new Intent(SignIn.this, BookingSelection.class);
                Toast.makeText(SignIn.this, "Welcome User", Toast.LENGTH_SHORT).show();
                startActivity(i);
                overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);*//*
                Toast.makeText(SignIn.this, "Sorry", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public class Socialgoogleplus extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;
        String userid = App_Common.getInstance(SignIn.this).getUserID();

        @Override
        protected void onPreExecute() {
            strDialogEmail = dialogEmail.getText().toString();
            strDialogMobile = dialogMobile.getText().toString();
            ringProgressDialog = ProgressDialog.show(SignIn.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String strDialogEmailID = strDialogEmail;
            String strDialogMobileNumber = strDialogMobile;
            try {

                JSONObject jsonObject = new JSONObject();


                jsonObject.accumulate("userName", get_name);
                jsonObject.accumulate("emailId", strDialogEmailID);
                jsonObject.accumulate("mobileNo", strDialogMobileNumber);
                jsonObject.accumulate("password", "");


                //		image    ,  socialId  , sType
                jsonObject.accumulate("sType", "GB");
                jsonObject.accumulate("socialId", get_id);
                jsonObject.accumulate("inviteCode", "");
                jsonObject.accumulate("userId", userid);
                jsonObject.accumulate("memberStatus", "false");
                jsonObject.accumulate("membershipId", "false");


                Log.i("Input", jsonObject.toString());

                String response = WebService.POST(App_Common.WebServiceUrl + "userRegistration", jsonObject.toString());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("status");
                    userID = jsonresponse.getString("userid");
                    try {
                        emailID = jsonresponse.getString("emailid");
                    } catch (Exception e) {

                    }
                    if (status.contains("Error")) {
                        return false;
                    }
                    {
                        return true;
                    }
                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {
                App_Common.getInstance(SignIn.this).setUserName(get_name);
                preferences = getSharedPreferences(Prefs.Prefrence, MODE_PRIVATE);
                editor = preferences.edit();
                editor.putBoolean(String.valueOf(Prefs.GmailLOGIN), Prefs.status);
                editor.commit();
                App_Common.getInstance(SignIn.this).setUserEmailId(strDialogEmail);
                App_Common.getInstance(SignIn.this).setUserNumber(strDialogMobile);
                Toast.makeText(SignIn.this, "Welcome "+get_name, Toast.LENGTH_LONG).show();
                Intent i = new Intent(SignIn.this, BookingSelection.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);

            } else {
                App_Common.getInstance(getApplicationContext()).setFaceBookStatus(false);
                signOutFromGplus();
                Toast.makeText(SignIn.this, "Sorry", Toast.LENGTH_SHORT).show();
                *//*App_Common.getInstance(SignIn.this).setUserName(get_name);
                preferences = getSharedPreferences(Prefs.Prefrence, MODE_PRIVATE);
                editor = preferences.edit();
                editor.putBoolean(String.valueOf(Prefs.GmailLOGIN), Prefs.status);
                editor.commit();
                App_Common.getInstance(SignIn.this).setUserEmailId(strDialogEmail);
                App_Common.getInstance(SignIn.this).setUserNumber(strDialogMobile);
                Intent i = new Intent(SignIn.this, BookingSelection.class);
                Toast.makeText(SignIn.this, "Welcome User", Toast.LENGTH_LONG).show();
                startActivity(i);
                overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);*//*
            }
        }
    }*/
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStackImmediate();

        } else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Are you sure you want to exit?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // SignIn.this.finish();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });

            builder1.setNegativeButton(
                    "Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
            //super.onBackPressed();
        }

    }
}
    /*@Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SignIn.this.finish();
                    }
                }).setNegativeButton("No", null).show();

    }

}*/


