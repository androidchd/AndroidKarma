package com.KarmaLakeLand1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import Helper.App_Common;
import Helper.Validation;
import Utility.WebService;

import static android.content.ContentValues.TAG;

public class AccountDetails extends Activity {
    Button register;
    EditText et_username;
    EditText et_emailID;
    EditText et_mobileNo;
    EditText et_password;
    EditText ReferralCode;
    EditText MembershipID;
    boolean resend = true;
    String get_name;
    TextView tvTermsCondition;
    Button member;
    Button nonmember;
    boolean memberstatus = false;
    static String UserID;
    String bindParameter;
    Activity activity;
    boolean isValid = false;
    String strReferalCode ="";
    String  strMemberShip=null;
    String strUserName, strEmailID, strMobile, strPassword, strSenderId, strMessage;
    View memberidview;
    static boolean buttonclick;
    List<EditText> lisEditTexts;
    ImageButton tv_header_title;
    int randomInt;
    String otp;
    String messageMobile;
    String messageEmail;

    String emailEdit;
    String resultEmail;
    String mobileEdit;
    String resultMobile;
    String userNameEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountdetails);
        inialiseUI();

    }

    public void inialiseUI() {
        MembershipID = (EditText) findViewById(R.id.MembershipID);

        strMemberShip = MembershipID.getText().toString();

        if (strMemberShip.isEmpty() || strMemberShip.equals("") || strMemberShip.equals(null)) {
            memberstatus = false;
        } else {
            memberstatus = true;
        }

        tvTermsCondition = (TextView) findViewById(R.id.tvTermsCondition);

        et_username = (EditText) findViewById(R.id.edName);
        et_password = (EditText) findViewById(R.id.edPassword);
        et_emailID = (EditText) findViewById(R.id.edemailaddress);
        et_mobileNo = (EditText) findViewById(R.id.edMobile);

        emailEdit = et_emailID.getText().toString();
        //resultEmail= emailEdit.toString().replaceAll(" ", "");
        mobileEdit = et_mobileNo.getText().toString();
        //resultMobile= emailEdit.toString().replaceAll(" ", "");
        lisEditTexts = new ArrayList<EditText>();

        final Pattern pattern = Pattern.compile(".*[^0-9].*");
        tv_header_title = (ImageButton) findViewById(R.id.favriot);
        tv_header_title.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });


        //nonmember=(Button)findViewById(R.id.nonmember);
      /*  et_username = (EditText) findViewById(R.id.edName);
        et_emailID = (EditText) findViewById(R.id.edemailaddress);*/
        tvTermsCondition.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountDetails.this, TermsandConditions.class);
                startActivity(i);
            }
        });

        et_emailID.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!Validation.isValidEmail(et_emailID.getText().toString().trim())) {
                        et_emailID.setError("Please Provide a Valid Email-Id.");
                    }
                }
            }
        });


        //   et_mobileNo = (EditText) findViewById(R.id.edMobile);

        et_mobileNo.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if ((et_mobileNo.getText().length() < 10 || et_mobileNo.getText().toString().length() > 10)
                            && pattern.matcher(et_mobileNo.getText()).matches()) {
                        et_mobileNo.setError("Please Put Only Digits And Provide 10 Digit Number.");
                    } else if (pattern.matcher(et_mobileNo.getText().toString()).matches()) {
                        et_mobileNo.setError("Please Put Only Digits.");
                    } else if (et_mobileNo.getText().toString().length() < 10
                            || et_mobileNo.getText().toString().length() > 10) {
                        et_mobileNo.setError("Please Provide 10 Digit Number.");
                    }
                }
            }
        });


        //  et_password = (EditText) findViewById(R.id.edPassword);
        memberidview = (View) findViewById(R.id.memberidview);

        //  ReferralCode = (EditText) findViewById(R.id.referralCode);

        strPassword = et_password.getText().toString();


        register = (Button) findViewById(R.id.Register);

        register.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (chkInputs()) {
                    if (Validation.isValidEmail(et_emailID.getText().toString().trim()) && Validation.isValidNumber(et_mobileNo.getText().toString())) {
                        if (et_password.getText().toString().length() >= 6) {
                            new CheckBeforeRegis().execute();
                            // new MobileRegistration().execute();
                        } else
                            et_password.setError("Please Enter minimum 6 characters ");
                    } else {

                    }
                }

            }
        });


    }

    public class AppLogin extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            //  bindParameter	=strUserName+"/"+strEmailID+"/"+strPassword+"/"+strMobile+"/"+strMemberShip;
            strEmailID = et_emailID.getText().toString();
            strMobile = et_mobileNo.getText().toString();
            strUserName = et_username.getText().toString();
            strPassword = et_password.getText().toString();
            //  strReferalCode = ReferralCode.getText().toString();
            strMemberShip = MembershipID.getText().toString();
            ringProgressDialog = ProgressDialog.show(AccountDetails.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            //String binderUrl =bindParameter;
            String response;
            String userName = strUserName;
            String emailId = strEmailID;
            String password = strPassword;
            String mobile = strMobile;
            String referalCode = strReferalCode;
            String memberShipId = strMemberShip;
            try {

                JSONObject jsonObject = new JSONObject();


                jsonObject.accumulate("userName", userName);
                jsonObject.accumulate("emailId", emailId);
                jsonObject.accumulate("mobileNo", mobile);
                jsonObject.accumulate("password", password);


                jsonObject.accumulate("inviteCode", referalCode);
                jsonObject.accumulate("userId", "");
                jsonObject.accumulate("memberStatus", memberstatus);
                jsonObject.accumulate("membershipId", memberShipId);


                Log.i("Input", jsonObject.toString());

                response = WebService.POST(App_Common.WebServiceUrl + "userRegistration", jsonObject.toString());
                //   ghgfh' oString response = WebService.POST(App_Common.WebServiceUrl+"userRegistration/",jsonObject.toString());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {

                    Toast.makeText(activity, "failed", Toast.LENGTH_SHORT).show();

                    // return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("status");
                    messageEmail = jsonresponse.getString("message");
                    if (status.contains("Success")) {
                        UserID = jsonresponse.getString("userid");
                        App_Common.getInstance(AccountDetails.this).setUserID(UserID.toString());
                        // Toast.makeText(activity,UserID+"",Toast.LENGTH_SHORT).show();
                        return true;
                    } /*else if (message.contains("Mobile no already exists.")) {
                        message = "Mobile no already exists.";
                        return false;
                    } */ else {
                        return false;
                    }

                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            return Boolean.valueOf(response);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {
                App_Common.getInstance(AccountDetails.this).setLoginS(true);
                App_Common.getInstance(AccountDetails.this).setRegistered(true);
                App_Common.getInstance(AccountDetails.this).setUserName(et_username.getText().toString());
                App_Common.getInstance(AccountDetails.this).setUserPwd(et_password.getText().toString());
                App_Common.getInstance(AccountDetails.this).setUserEmailId(et_emailID.getText().toString());
                App_Common.getInstance(AccountDetails.this).setUserNumber(et_mobileNo.getText().toString());
                //   App_Common.getInstance(AccountDetails.this).setReferralcode(ReferralCode.getText().toString());
                App_Common.getInstance(AccountDetails.this).setMemberShipId(MembershipID.getText().toString());
                App_Common.getInstance(AccountDetails.this).setUserID(UserID);

                get_name = App_Common.getInstance(AccountDetails.this).getUserName();
                Toast.makeText(AccountDetails.this, "Welcome, " + get_name + " !", Toast.LENGTH_LONG).show();

                Intent i = new Intent(AccountDetails.this, BookingSelection.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);
               /*Toast.makeText(activity,"Welcome " + et_username.getText().toString(),
                        Toast.LENGTH_LONG).show();*/
                finish();
            } else {
               /* Intent i = new Intent(AccountDetails.this, BookingSelection.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);*/
                buildAlertMessage();
            }
        }
    }

    public class CheckBeforeRegis extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            //  bindParameter	=strUserName+"/"+strEmailID+"/"+strPassword+"/"+strMobile+"/"+strMemberShip;
            strEmailID = et_emailID.getText().toString();
            strMemberShip = MembershipID.getText().toString();
            strMobile = et_mobileNo.getText().toString();
            ringProgressDialog = ProgressDialog.show(AccountDetails.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            //String binderUrl =bindParameter;
            String response;
            String emailId = strEmailID;
            String mobile = strMobile;
            String memberShipId = strMemberShip;
            if (memberShipId.contains("")){
                memberShipId=null;
            }

            try {

               /* JSONObject jsonObject = new JSONObject();


                jsonObject.accumulate("userName", userName);
                jsonObject.accumulate("emailId", emailId);
                jsonObject.accumulate("mobileNo", mobile);
                jsonObject.accumulate("password", password);


                jsonObject.accumulate("inviteCode", referalCode);
                jsonObject.accumulate("userId", "");
                jsonObject.accumulate("memberStatus", memberstatus);
                jsonObject.accumulate("membershipId", memberShipId);*/


                //  Log.i("Input", jsonObject.toString());

                response = WebService.GET(App_Common.WebServiceUrl + "checkEmailAndMobile/" + emailId + "/" + mobile + "/" + memberShipId);
                //   ghgfh' oString response = WebService.POST(App_Common.WebServiceUrl+"userRegistration/",jsonObject.toString());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {

                    Toast.makeText(activity, "failed", Toast.LENGTH_SHORT).show();

                    // return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("status");
                    messageEmail = jsonresponse.getString("message");
                    if (status.contains("Success")) {

                        return true;
                    } /*else if (message.contains("Mobile no already exists.")||message.contains("Email id already exists.")) {
                        message = "Mobile no already exists.";
                        return false;
                    }*/ else {
                        return false;
                    }

                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            return Boolean.valueOf(response);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {
                new MobileRegistration().execute();
            } else {

                buildAlertMessage();
            }
        }
    }

    public class MobileRegistration extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            //  bindParameter	=strUserName+"/"+strEmailID+"/"+strPassword+"/"+strMobile+"/"+strMemberShip;
            Random randomGenerator = new Random();
            randomInt = randomGenerator.nextInt(999999);

            strMobile = et_mobileNo.getText().toString();
            strUserName = "appcentra574727";
            strPassword = "8473";
            strSenderId = "AEPTAG";
            strMessage = "Your%20OTP%20for%20Karma%20Lakeland%20Registration%20is%20" + String.valueOf(randomInt) + "%20Please%20use%20this%20code%20for%20Registration";
            ringProgressDialog = ProgressDialog.show(AccountDetails.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            bindParameter = "/" + strMobile + "/" + strMessage;
            String sendOTPRequest = bindParameter;
            RequestQueue requestQueue;
            {
                try {

                    String url = (App_Common.WebServiceUrl + "SendOTP" + sendOTPRequest);

                    requestQueue = Volley.newRequestQueue(AccountDetails.this);
                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null,
                            new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {

                                    try {
                                        messageEmail = response.getString("message");
                                        ringProgressDialog.dismiss();
                                        SupportDialog cancelbookingdialog = new SupportDialog(AccountDetails.this);
                                        cancelbookingdialog.show();
                                        cancelbookingdialog.setCancelable(false);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    } catch (NullPointerException ee) {

                                    }
                                    //Log.d(TAG, response.toString());

                                }
                            }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            try {
                                String body;
                                //get status code here
                                String statusCode = String.valueOf(error.networkResponse.statusCode);
                                //get response body and parse with appropriate encoding
                                if (error.networkResponse.data != null) {
                                    try {
                                        body = new String(error.networkResponse.data, "UTF-8");
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    } catch (NullPointerException e) {
                                        Toast.makeText(AccountDetails.this, "Network problem ", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                //App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
                                VolleyLog.d("Error: " + error.getMessage());
                                // hide the progress dialog

                            } catch (NullPointerException ee) {

                            }
                        }
                    });
                    requestQueue.add(jsonObjReq);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return false;
                }
            }

            return true;
        }


        @Override
        protected void onPostExecute(Boolean result) {
            try {
                if (result) {

                } else if (result == null || result.equals(null)) {
                    ringProgressDialog.dismiss();
                    Toast.makeText(AccountDetails.this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                } else {
                    App_Common.getInstance(AccountDetails.this).setLoginStatus(false);

                    Toast.makeText(AccountDetails.this, "failed", Toast.LENGTH_SHORT).show();
                }
            } catch (NullPointerException ee) {
                Toast.makeText(AccountDetails.this, "Network problem ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class ResendRegistration extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            Random randomGenerator = new Random();
            randomInt = randomGenerator.nextInt(999999);

            strMobile = et_mobileNo.getText().toString();
            strMessage = "Your%20OTP%20for%20Karma%20Lakeland%20Registration%20is%20" + String.valueOf(randomInt) + "%20Please%20use%20this%20code%20for%20Registration";
            ringProgressDialog = ProgressDialog.show(AccountDetails.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            bindParameter = "/" + strMobile + "/" + strMessage;
            String sendOTPRequest = bindParameter;
            RequestQueue requestQueue;
            {
                try {

                    String url = (App_Common.WebServiceUrl + "SendOTP" + sendOTPRequest);

                    requestQueue = Volley.newRequestQueue(AccountDetails.this);
                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null,
                            new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {


                                    //messageEmail = response.getString("message");
                                    ringProgressDialog.dismiss();


                                    //Log.d(TAG, response.toString());

                                }
                            }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            try {
                                String body;
                                //get status code here
                                String statusCode = String.valueOf(error.networkResponse.statusCode);
                                //get response body and parse with appropriate encoding
                                if (error.networkResponse.data != null) {
                                    try {
                                        body = new String(error.networkResponse.data, "UTF-8");
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    } catch (NullPointerException e) {
                                        Toast.makeText(AccountDetails.this, "Network problem ", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                //App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
                                VolleyLog.d("Error: " + error.getMessage());
                                // hide the progress dialog

                            } catch (NullPointerException ee) {

                            }
                        }
                    });
                    requestQueue.add(jsonObjReq);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return false;
                }
            }

            return true;
        }


        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                try {
                    ringProgressDialog.dismiss();
                    Toast.makeText(AccountDetails.this, "Resend", Toast.LENGTH_SHORT).show();
                } catch (NullPointerException e) {

                }

            } else {
                App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
                ringProgressDialog.dismiss();
                Toast.makeText(AccountDetails.this, "failed", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void buildAlertMessage() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        try {
            if (messageEmail.contains("Mobile no already exists.")) {
                builder.setMessage(et_mobileNo.getText() + " is already registered")
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(final DialogInterface dialog,
                                                        final int id) {
                                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
                                        dialog.dismiss();

                                    }
                                });
            } else if (messageEmail.contains("Email id already exists.")) {
                builder.setMessage(et_emailID.getText() + " is already registered, Kindly Change Email-id")
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(final DialogInterface dialog,
                                                        final int id) {
                                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
                                        dialog.dismiss();

                                    }
                                });
            } else {
                builder.setMessage("Your MemberShip-ID was wrong")
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(final DialogInterface dialog,
                                                        final int id) {
                                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
                                        dialog.dismiss();

                                    }
                                });
            }


        } catch (NullPointerException ee) {

        }
        final AlertDialog alert = builder.create();
        alert.show();

    }

    boolean chkInputs() {

        if (lisEditTexts.isEmpty()) {
            lisEditTexts.add(et_username);
            lisEditTexts.add(et_password);
            lisEditTexts.add(et_mobileNo);
            lisEditTexts.add(et_emailID);
            if (buttonclick) {
                lisEditTexts.add(MembershipID);
                lisEditTexts.add(ReferralCode);
            }
        }

        for (EditText editText : lisEditTexts) {

            if (editText.getText().toString().length() == 0) {
                editText.setError("Please Provide Valid Input.");
                return false;
            }

        }
        return true;
    }

    public class SupportDialog extends Dialog implements android.view.View.OnClickListener {

        TextView tvResend;
        public Activity c;
        final Dialog d = new Dialog(getContext());
        public LinearLayout confirm;
        public LinearLayout cancel;
        public EditText etOtp;

        public SupportDialog(Activity a) {
            super(a);
            // TODO Auto-generated constructor stub
            this.c = a;

        }
        // TODO Auto-generated constructor stub


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.otp_dialog);
            etOtp = (EditText) findViewById(R.id.et_otp);
            tvResend = (TextView) findViewById(R.id.tv_resend);
            confirm = (LinearLayout) findViewById(R.id.btn_confirm);
            confirm.setOnClickListener(this);
            cancel = (LinearLayout) findViewById(R.id.btn_cancel);
            cancel.setOnClickListener(this);
            tvResend.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.btn_confirm:
                    try {
                        otp = etOtp.getText().toString();
                        int otpaa = Integer.parseInt(otp);
                        if (randomInt == otpaa) {
                            new AppLogin().execute();
                            dismiss();
                        } else if (randomInt != otpaa) {
                            etOtp.setError("Please Enter Correct OTP");
                            etOtp.setText("");
                        }
                    } catch (NullPointerException ee) {
                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);

                    } catch (NumberFormatException ee) {
                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);

                    }
                    break;

                case R.id.btn_cancel:
                    dismiss();
                    App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
                    break;
                case R.id.tv_resend:
                    if (resend == true) {
                        new ResendRegistration().execute();
                        tvResend.setText("Send");
                        resend = false;
                    } else {
                        Toast.makeText(AccountDetails.this, "Please wait...", Toast.LENGTH_SHORT).show();
                    }
                    break;

            }
        }

    }


}


//    Button register;
//    EditText et_username;
//    EditText et_emailID;
//    EditText et_mobileNo;
//    EditText et_password;
//    EditText ReferralCode;
//    EditText MembershipID;
//    boolean resend = true;
//    String get_name;
//    TextView tvTermsCondition;
//    Button member;
//    Button nonmember;
//    boolean memberstatus = false;
//    static String UserID;
//    String bindParameter;
//    Activity activity;
//    boolean isValid = false;
//    String strReferalCode = "";
//    String strMemberShip = null;
//    String strUserName, strEmailID, strMobile, strPassword, strSenderId, strMessage;
//    View memberidview;
//    static boolean buttonclick;
//    List<EditText> lisEditTexts;
//    ImageButton tv_header_title;
//    private int randomInt;
//    String otp;
//    String messageMobile;
//    String messageEmail;
//
//    String emailEdit;
//    String resultEmail;
//    String mobileEdit;
//    String resultMobile;
//    String userNameEdit;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.accountdetails);
//        inialiseUI();
//
//    }
//
//    public void inialiseUI() {
//        MembershipID = (EditText) findViewById(R.id.MembershipID);
//
//        strMemberShip = MembershipID.getText().toString();
//
//        memberstatus = !(strMemberShip.isEmpty() || strMemberShip.equals("") || strMemberShip.equals(null));
//
//        tvTermsCondition = (TextView) findViewById(R.id.tvTermsCondition);
//
//        et_username = (EditText) findViewById(R.id.edName);
//        et_password = (EditText) findViewById(R.id.edPassword);
//        et_emailID = (EditText) findViewById(R.id.edemailaddress);
//        et_mobileNo = (EditText) findViewById(R.id.edMobile);
//
//        emailEdit = et_emailID.getText().toString();
//        resultEmail = emailEdit.toString().replaceAll(" ", "");
//        mobileEdit = et_mobileNo.getText().toString();
//        resultMobile = emailEdit.toString().replaceAll(" ", "");
//
//        lisEditTexts = new ArrayList<EditText>();
//
//        final Pattern pattern = Pattern.compile(".*[^0-9].*");
//        tv_header_title = (ImageButton) findViewById(R.id.favriot);
//        tv_header_title.setOnClickListener(new OnClickListener() {
//
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                finish();
//            }
//        });
//
//
//        //nonmember=(Button)findViewById(R.id.nonmember);
//      /*  et_username = (EditText) findViewById(R.id.edName);
//        et_emailID = (EditText) findViewById(R.id.edemailaddress);*/
//        tvTermsCondition.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(AccountDetails.this, TermsandConditions.class);
//                startActivity(i);
//            }
//        });
//
//        et_emailID.setOnFocusChangeListener(new OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    if (!Validation.isValidEmail(et_emailID.getText().toString().trim())) {
//                        et_emailID.setError("Please Provide a Valid Email-Id.");
//                    }
//                }
//            }
//        });
//
//
//        et_mobileNo = (EditText) findViewById(R.id.edMobile);
//
//        et_mobileNo.setOnFocusChangeListener(new OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    if ((et_mobileNo.getText().length() < 10 || et_mobileNo.getText().toString().length() > 10)
//                            && pattern.matcher(et_mobileNo.getText()).matches()) {
//                        et_mobileNo.setError("Please Put Only Digits And Provide 10 Digit Number.");
//                    } else if (pattern.matcher(et_mobileNo.getText().toString()).matches()) {
//                        et_mobileNo.setError("Please Put Only Digits.");
//                    } else if (et_mobileNo.getText().toString().length() < 10
//                            || et_mobileNo.getText().toString().length() > 10) {
//                        et_mobileNo.setError("Please Provide 10 Digit Number.");
//                    }
//                }
//            }
//        });
//
//
//        et_password = (EditText) findViewById(R.id.edPassword);
//        memberidview = findViewById(R.id.memberidview);
//
////        ReferralCode = (EditText) findViewById(R.id.referralCode);
//
//        strPassword = et_password.getText().toString();
//
//
//        register = (Button) findViewById(R.id.Register);
//
//        register.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//
//                if (chkInputs()) {
//                    if (Validation.isValidEmail(et_emailID.getText().toString().trim()) && Validation.isValidNumber(et_mobileNo.getText().toString())) {
//                        if (et_password.getText().toString().length() >= 6) {
//                            new CheckBeforeRegis().execute();
//                            // new MobileRegistration().execute();
//                        } else
//                            et_password.setError("Please Enter minimum 6 characters ");
//                    } else {
//                        Log.d("et_emailID", "et_emailID" + et_emailID);
//                    }
//                }
//
//            }
//        });
//
//
//    }
//
//    private class AppLogin extends AsyncTask<String, Void, Boolean> {
//
//        protected ProgressDialog ringProgressDialog;
//
//
//        @Override
//        protected void onPreExecute() {
//            bindParameter = strUserName + "/" + strEmailID + "/" + strPassword + "/" + strMobile + "/" + strMemberShip;
//            strEmailID = et_emailID.getText().toString();
//            strMobile = et_mobileNo.getText().toString();
//            strUserName = et_username.getText().toString();
//            strPassword = et_password.getText().toString();
//            strReferalCode = ReferralCode.getText().toString();
//            strMemberShip = MembershipID.getText().toString();
//            ringProgressDialog = ProgressDialog.show(AccountDetails.this, null, "Processing ... ", true);
//            ringProgressDialog.setCancelable(false);
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Boolean doInBackground(String... params) {
//            String binderUrl = bindParameter;
//            String response;
//            String userName = strUserName;
//            String emailId = strEmailID;
//            String password = strPassword;
//            String mobile = strMobile;
//            String referalCode = strReferalCode;
//            String memberShipId = strMemberShip;
//            try {
//
//                JSONObject jsonObject = new JSONObject();
//                jsonObject.accumulate("userName", userName);
//                jsonObject.accumulate("emailId", emailId);
//                jsonObject.accumulate("mobileNo", mobile);
//                jsonObject.accumulate("password", password);
//                jsonObject.accumulate("inviteCode", referalCode);
//                jsonObject.accumulate("userId", "");
//                jsonObject.accumulate("memberStatus", memberstatus);
//                jsonObject.accumulate("membershipId", memberShipId);
//
//                Log.i("Input", jsonObject.toString());
//
//                response = WebService.POST(App_Common.WebServiceUrl + "userRegistration", jsonObject.toString());
//                //   ghgfh' oString response = WebService.POST(App_Common.WebServiceUrl+"userRegistration/",jsonObject.toString());
//
//                Log.i(App_Common.TAG, response);
//                Log.e("RESPONSE", response);
//
//                if (response == null || response.equals("")) {
//
//                    Toast.makeText(activity, "failed", Toast.LENGTH_SHORT).show();
//
//                    // return false;
//                } else {
//                    JSONObject jsonresponse = new JSONObject(response);
//                    String status = jsonresponse.getString("status");
//                    messageEmail = jsonresponse.getString("message");
//                    if (status.contains("Success")) {
//                        UserID = jsonresponse.getString("userid");
//                        App_Common.getInstance(AccountDetails.this).setUserID(UserID);
//                        // Toast.makeText(activity,UserID+"",Toast.LENGTH_SHORT).show();
//                        return true;
//                    } /*else if (message.contains("Mobile no already exists.")) {
//                        message = "Mobile no already exists.";
//                        return false;
//                    } */ else {
//                        return false;
//                    }
//
//                }
//
//
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                return false;
//            }
//            return Boolean.valueOf(response);
//        }
//
//        @Override
//        protected void onPostExecute(Boolean result) {
//            ringProgressDialog.dismiss();
//            if (result) {
//                App_Common.getInstance(AccountDetails.this).setLoginS(true);
//                App_Common.getInstance(AccountDetails.this).setRegistered(true);
//                App_Common.getInstance(AccountDetails.this).setUserName(et_username.getText().toString());
//                App_Common.getInstance(AccountDetails.this).setUserPwd(et_password.getText().toString());
//                App_Common.getInstance(AccountDetails.this).setUserEmailId(et_emailID.getText().toString());
//                App_Common.getInstance(AccountDetails.this).setUserNumber(et_mobileNo.getText().toString());
//                App_Common.getInstance(AccountDetails.this).setReferralcode(ReferralCode.getText().toString());
//                App_Common.getInstance(AccountDetails.this).setMemberShipId(MembershipID.getText().toString());
//                App_Common.getInstance(AccountDetails.this).setUserID(UserID);
//
//                get_name = App_Common.getInstance(AccountDetails.this).getUserName();
//                Toast.makeText(AccountDetails.this, "Welcome, " + get_name + " !", Toast.LENGTH_LONG).show();
//
//                Intent i = new Intent(AccountDetails.this, BookingSelection.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(i);
//                overridePendingTransition(R.anim.right_to_left_activity, R.anim.left_to_right_activity);
//               /*Toast.makeText(activity,"Welcome " + et_username.getText().toString(),
//                        Toast.LENGTH_LONG).show();*/
//                finish();
//            } else {
//               /* Intent i = new Intent(AccountDetails.this, BookingSelection.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(i);*/
//                buildAlertMessage();
//            }
//        }
//    }
//
//    private class CheckBeforeRegis extends AsyncTask<String, Void, Boolean> {
//
//        protected ProgressDialog ringProgressDialog;
//
//        @Override
//        protected void onPreExecute() {
//            bindParameter = strUserName + "/" + strEmailID + "/" + strPassword + "/" + strMobile + "/" + strMemberShip;
//            strEmailID = et_emailID.getText().toString();
//            strMemberShip = MembershipID.getText().toString();
//            strMobile = et_mobileNo.getText().toString();
//            ringProgressDialog = ProgressDialog.show(AccountDetails.this, null, "Processing ... ", true);
//            ringProgressDialog.setCancelable(false);
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Boolean doInBackground(String... params) {
//            String binderUrl = bindParameter;
//            String response;
//            String emailId = strEmailID;
//            String mobile = strMobile;
//            String memberShipId = strMemberShip;
//            if (memberShipId.contains("")) {
//                memberShipId = null;
//            }
//
//            try {
//
//               /* JSONObject jsonObject = new JSONObject();
//
//
//                jsonObject.accumulate("userName", userName);
//                jsonObject.accumulate("emailId", emailId);
//                jsonObject.accumulate("mobileNo", mobile);
//                jsonObject.accumulate("password", password);
//
//
//                jsonObject.accumulate("inviteCode", referalCode);
//                jsonObject.accumulate("userId", "");
//                jsonObject.accumulate("memberStatus", memberstatus);
//                jsonObject.accumulate("membershipId", memberShipId);*/
//
//
//                //  Log.i("Input", jsonObject.toString());
//
//                response = WebService.GET(App_Common.WebServiceUrl + "checkEmailAndMobile/" + emailId + "/" + mobile + "/" + memberShipId);
//                //   ghgfh' oString response = WebService.POST(App_Common.WebServiceUrl+"userRegistration/",jsonObject.toString());
//
//                Log.i(App_Common.TAG, response);
//                Log.e("RESPONSE", response);
//
//                if (response == null || response.equals("")) {
//
//                    Toast.makeText(activity, "failed", Toast.LENGTH_SHORT).show();
//
//                    // return false;
//                } else {
//                    JSONObject jsonresponse = new JSONObject(response);
//                    String status = jsonresponse.getString("status");
//                    messageEmail = jsonresponse.getString("message");
//                    if (status.contains("Success")) {
//                        Log.d("messageEmail", "messageEmail" + messageEmail);
//                        return true;
//                    } /*else if (message.contains("Mobile no already exists.")||message.contains("Email id already exists.")) {
//                        message = "Mobile no already exists.";
//                        return false;
//                    }*/ else {
//                        return false;
//                    }
//
//                }
//
//
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                return false;
//            }
//            return Boolean.valueOf(response);
//        }
//
//        @Override
//        protected void onPostExecute(Boolean result) {
//            ringProgressDialog.dismiss();
//            if (result) {
//                new MobileRegistration().execute();
//            } else {
//
//                buildAlertMessage();
//            }
//        }
//    }
//
//    private class MobileRegistration extends AsyncTask<String, Void, Boolean> {
//
//        protected ProgressDialog ringProgressDialog;
//        String statusCode, body;
//
//        @Override
//        protected void onPreExecute() {
//            bindParameter	=strUserName+"/"+strEmailID+"/"+strPassword+"/"+strMobile+"/"+strMemberShip;
//            Random randomGenerator = new Random();
//            randomInt = randomGenerator.nextInt(999999);
//
//            strMobile = et_mobileNo.getText().toString();
//            strUserName = "appcentra574727";
//            strPassword = "8473";
//            strSenderId = "AEPTAG";
//            strMessage = "Your%20OTP%20for%20Karma%20Lakeland%20Registration%20is%20" + String.valueOf(randomInt) + "%20Please%20use%20this%20code%20for%20Registration";
//            ringProgressDialog = ProgressDialog.show(AccountDetails.this, null, "Processing ... ", true);
//            ringProgressDialog.setCancelable(false);
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Boolean doInBackground(String... params) {
//            bindParameter = "/" + strMobile + "/" + strMessage;
//            String sendOTPRequest = bindParameter;
//            RequestQueue requestQueue;
//            {
//                try {
//
//                    String url = (App_Common.WebServiceUrl + "SendOTP" + sendOTPRequest);
//                    requestQueue = Volley.newRequestQueue(AccountDetails.this);
//                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null,
//                            new Response.Listener<JSONObject>() {
//
//                                @Override
//                                public void onResponse(JSONObject response) {
//
//                                    try {
//                                        messageEmail = response.getString("message");
//                                        ringProgressDialog.dismiss();
//                                        SupportDialog cancelbookingdialog = new SupportDialog(AccountDetails.this);
//                                        cancelbookingdialog.show();
//                                        cancelbookingdialog.setCancelable(false);
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    } catch (NullPointerException ee) {
//                                        Log.d(TAG, response.toString());
//                                    }
//
//                                }
//                            }, new Response.ErrorListener() {
//
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            try {
//                                //get status code here
//                                statusCode = String.valueOf(error.networkResponse.statusCode);
//                                //get response body and parse with appropriate encoding
//                                if (error.networkResponse.data != null) {
//                                    try {
//                                        body = new String(error.networkResponse.data, "UTF-8");
//                                    } catch (UnsupportedEncodingException e) {
//                                        e.printStackTrace();
//                                    } catch (NullPointerException e) {
//                                        Toast.makeText(AccountDetails.this, "Network problem ", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                //App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//                                VolleyLog.d("Error: " + error.getMessage());
//                                // hide the progress dialog
//
//                            } catch (NullPointerException ee) {
//                                Log.d("ee", "ee" + ee);
//                            }
//                        }
//                    });
//                    requestQueue.add(jsonObjReq);
//
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                    return false;
//                }
//            }
//
//            return true;
//        }
//
//
//        @Override
//        protected void onPostExecute(Boolean result) {
//            try {
//                if (result) {
//                    Log.d("result", "result" + true);
//                } else if (result.equals(null)) {
//                    ringProgressDialog.dismiss();
//                    Toast.makeText(AccountDetails.this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
//                } else {
//                    App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//
//                    Toast.makeText(AccountDetails.this, "failed", Toast.LENGTH_SHORT).show();
//                }
//            } catch (NullPointerException ee) {
//                Toast.makeText(AccountDetails.this, "Network problem ", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private class ResendRegistration extends AsyncTask<String, Void, Boolean> {
//
//        protected ProgressDialog ringProgressDialog;
//        String body, statusCode;
//
//        @Override
//        protected void onPreExecute() {
//            Random randomGenerator = new Random();
//            randomInt = randomGenerator.nextInt(999999);
//
//            strMobile = et_mobileNo.getText().toString();
//            strMessage = "Your%20OTP%20for%20Karma%20Lakeland%20Registration%20is%20" + String.valueOf(randomInt) + "%20Please%20use%20this%20code%20for%20Registration";
//            ringProgressDialog = ProgressDialog.show(AccountDetails.this, null, "Processing ... ", true);
//            ringProgressDialog.setCancelable(false);
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Boolean doInBackground(String... params) {
//            bindParameter = "/" + strMobile + "/" + strMessage;
//            String sendOTPRequest = bindParameter;
//            RequestQueue requestQueue;
//            {
//                try {
//
//                    String url = (App_Common.WebServiceUrl + "SendOTP" + sendOTPRequest);
//
//                    requestQueue = Volley.newRequestQueue(AccountDetails.this);
//                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null,
//                            new Response.Listener<JSONObject>() {
//
//                                @Override
//                                public void onResponse(JSONObject response) {
//
//
//                                    //messageEmail = response.getString("message");
//                                    ringProgressDialog.dismiss();
//
//
//                                    //Log.d(TAG, response.toString());
//
//                                }
//                            }, new Response.ErrorListener() {
//
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            try {
//
//                                //get status code here
//                                statusCode = String.valueOf(error.networkResponse.statusCode);
//                                //get response body and parse with appropriate encoding
//                                if (error.networkResponse.data != null) {
//                                    try {
//                                        body = new String(error.networkResponse.data, "UTF-8");
//                                    } catch (UnsupportedEncodingException e) {
//                                        e.printStackTrace();
//                                    } catch (NullPointerException e) {
//                                        Toast.makeText(AccountDetails.this, "Network problem ", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                //App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//                                VolleyLog.d("Error: " + error.getMessage());
//                                // hide the progress dialog
//
//                            } catch (NullPointerException ee) {
//                            }
//                        }
//                    });
//                    requestQueue.add(jsonObjReq);
//
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                    return false;
//                }
//            }
//
//            return true;
//        }
//
//
//        @Override
//        protected void onPostExecute(Boolean result) {
//            if (result) {
//                try {
//                    ringProgressDialog.dismiss();
//                    Toast.makeText(AccountDetails.this, "Resend", Toast.LENGTH_SHORT).show();
//                } catch (NullPointerException e) {
//                }
//
//            } else {
//                App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//                ringProgressDialog.dismiss();
//                Toast.makeText(AccountDetails.this, "failed", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//
//    public void buildAlertMessage() {
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        try {
//            if (messageEmail.contains("Mobile no already exists.")) {
//                builder.setMessage(et_mobileNo.getText() + " is already registered")
//                        .setCancelable(false)
//                        .setPositiveButton("OK",
//                                new DialogInterface.OnClickListener() {
//                                    public void onClick(final DialogInterface dialog,
//                                                        final int id) {
//                                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//                                        dialog.dismiss();
//
//                                    }
//                                });
//            } else if (messageEmail.contains("Email id already exists.")) {
//                builder.setMessage(et_emailID.getText() + " is already registered, Kindly Change Email-id")
//                        .setCancelable(false)
//                        .setPositiveButton("OK",
//                                new DialogInterface.OnClickListener() {
//                                    public void onClick(final DialogInterface dialog,
//                                                        final int id) {
//                                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//                                        dialog.dismiss();
//
//                                    }
//                                });
//            } else {
//                builder.setMessage("Your MemberShip-ID was wrong")
//                        .setCancelable(false)
//                        .setPositiveButton("OK",
//                                new DialogInterface.OnClickListener() {
//                                    public void onClick(final DialogInterface dialog,
//                                                        final int id) {
//                                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//                                        dialog.dismiss();
//
//                                    }
//                                });
//            }
//
//
//        } catch (NullPointerException ee) {
//        }
//        final AlertDialog alert = builder.create();
//        alert.show();
//
//    }
//
//    boolean chkInputs() {
//
//        if (lisEditTexts.isEmpty()) {
//            lisEditTexts.add(et_username);
//            lisEditTexts.add(et_password);
//            lisEditTexts.add(et_mobileNo);
//            lisEditTexts.add(et_emailID);
//            if (buttonclick) {
//                lisEditTexts.add(MembershipID);
//                lisEditTexts.add(ReferralCode);
//            }
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
//
//    private class SupportDialog extends Dialog implements android.view.View.OnClickListener {
//
//        TextView tvResend;
//        Activity c;
//        final Dialog d = new Dialog(getContext());
//        private LinearLayout confirm;
//        private LinearLayout cancel;
//        private EditText etOtp;
//
//        private SupportDialog(Activity a) {
//            super(a);
//            // TODO Auto-generated constructor stub
//            this.c = a;
//
//        }
//        // TODO Auto-generated constructor stub
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            requestWindowFeature(Window.FEATURE_NO_TITLE);
//            setContentView(R.layout.otp_dialog);
//            etOtp = (EditText) findViewById(R.id.et_otp);
//            tvResend = (TextView) findViewById(R.id.tv_resend);
//            confirm = (LinearLayout) findViewById(R.id.btn_confirm);
//            confirm.setOnClickListener(this);
//            cancel = (LinearLayout) findViewById(R.id.btn_cancel);
//            cancel.setOnClickListener(this);
//            tvResend.setOnClickListener(this);
//
//
//        }
//
//        @Override
//        public void onClick(View v) {
//            // TODO Auto-generated method stub
//            switch (v.getId()) {
//                case R.id.btn_confirm:
//                    try {
//                        otp = etOtp.getText().toString();
//                        int otpaa = Integer.parseInt(otp);
//                        if (randomInt == otpaa) {
//                            new AppLogin().execute();
//                            dismiss();
//                        } else {
//                            etOtp.setError("Please Enter Correct OTP");
//                            etOtp.setText("");
//                        }
//                    } catch (NullPointerException ee) {
//                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//
//                    } catch (NumberFormatException ee) {
//                        App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//
//                    }
//                    break;
//
//                case R.id.btn_cancel:
//                    dismiss();
//                    App_Common.getInstance(AccountDetails.this).setLoginStatus(false);
//                    break;
//                case R.id.tv_resend:
//                    if (!resend) {
//                        Toast.makeText(AccountDetails.this, "Please wait...", Toast.LENGTH_SHORT).show();
//                    } else {
//                        new ResendRegistration().execute();
//                        tvResend.setText("Send");
//                        resend = false;
//                    }
//                    break;
//
//            }
//        }
//
//    }
//}