package com.KarmaLakeLand1;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import Helper.App_Common;
import Utility.WebService;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ChangePwdActivity extends Activity {

    EditText oldPwd, uPwd, cPwd;
    ImageButton favriot;
    String newPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        favriot = (ImageButton) findViewById(R.id.favriot);
        favriot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        oldPwd = (EditText) findViewById(R.id.curPwd);

        uPwd = (EditText) findViewById(R.id.Newpassword);
        cPwd = (EditText) findViewById(R.id.CNewpassword);
        //oldPwd.setTypeface(type2);
        //uPwd.setTypeface(type2);
        //cPwd.setTypeface(type2);

//        final Pattern pwdPattern = Pattern
//                .compile("((?=.*\\d)(?=.*[a-z])(?=.*[!@#$%]).{6,20})");

        uPwd.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (uPwd.getText().toString().length() < 6) {
                        uPwd.setError("Password Length Should Be Atleast 6");
                    }
                    // if (!pwdPattern.matcher(uPwd.getText()).matches()) {
                    // uPwd.setError("Please Put Password Which Contains(Digit,Lowercase Character,Special Symbols eg: !@#$% and Length Between 6 to 20].");
                    // }
                }
            }
        });

        cPwd.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (uPwd.getError() == null) {
                        if (!uPwd.getText().toString()
                                .equals(cPwd.getText().toString())) {
                            cPwd.setError("Please Confirm Password Correctly.");
                        }
                    } else {
                        cPwd.setError("First Set Password.");
                    }
                }
            }
        });

        Button updatePwd = (Button) findViewById(R.id.updatePwd);

        updatePwd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (chkInputs()) {
                    if (oldPwd.getText().toString().equals(App_Common.getInstance(
                            getApplicationContext()).getUserPwd())) {
                        if (App_Common.getInstance(getApplicationContext())
                                .getUserPwd().equals(cPwd.getText().toString())) {
                            Toast.makeText(getApplicationContext(),

                                    "New and Old password can't be same!",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            newPwd = uPwd.getText().toString();
                            new AppLogin().execute();
                        }
                        //new UpdatePwd().execute();
                    } else {
                        oldPwd.setError("Old Password is Not Correct.");
                    }
                }
            }
        });

    }


    boolean chkInputs() {

        List<EditText> lisEditTexts = new ArrayList<EditText>();

        if (lisEditTexts.isEmpty()) {
            lisEditTexts.add(oldPwd);
            lisEditTexts.add(uPwd);
            lisEditTexts.add(cPwd);
        }

        for (EditText editText : lisEditTexts) {

            if (editText.getError() != null
                    || editText.getText().toString().length() == 0) {
                editText.setError("Please Provide Valid Input.");
                return false;
            }
        }
        return true;
    }

    private class AppLogin extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;
        String newPassword;
        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(ChangePwdActivity.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();

        }

        @Override
        protected Boolean doInBackground(String... params) {
            newPassword = newPwd;
            try {

                JSONObject jsonObject = new JSONObject();

                jsonObject.accumulate("userName", App_Common.getInstance(getApplicationContext()).getUserName());
                jsonObject.accumulate("emailId", App_Common.getInstance(getApplicationContext()).getUserEmailId());
                jsonObject.accumulate("mobileNo", App_Common.getInstance(getApplicationContext()).getUserNumber());
                jsonObject.accumulate("password", uPwd.getText().toString());

                jsonObject.accumulate("inviteCode", " ");
                jsonObject.accumulate("userId", App_Common.getInstance(getApplicationContext()).getUserID());
                jsonObject.accumulate("memberStatus", App_Common.getInstance(getApplicationContext()).getMemberupdate());
                jsonObject.accumulate("membershipId", App_Common.getInstance(getApplicationContext()).getMemberupdate());

                Log.i("Input", jsonObject.toString());
                String response = WebService.POST(App_Common.WebServiceUrl + "updatePassword", jsonObject.toString());
                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("status");
                    if (status.contains("Success")) {
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

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {

                App_Common.getInstance(ChangePwdActivity.this).setUserPwd(uPwd.getText().toString());
                Toast.makeText(getApplicationContext(), "Password changed successfully", Toast.LENGTH_LONG).show();
                Intent i =new Intent(ChangePwdActivity.this,Editprofile.class);
                startActivity(i);
                finish();
            } else {

            }
        }
    }
}
