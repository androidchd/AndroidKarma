package com.KarmaLakeLand1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import Helper.App_Common;
import Utility.WebService;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Bookingdetail extends Activity {
    TextView players;
    TextView holes;
    TextView date;
    TextView time;
    TextView amount;
    String strMobile, strMessage, bindParameter;
//    TextView ADDSon;
    ImageButton favriot;
    Button cancelbooking;
    static String bookingId;
    Intent extras;
    TextView buckets;
    String session;
    ImageView flag;
    Cancelbookingdialog cdd;
    String PaymentStatus;
    String BookStatus;
    TextView bookingID;
//    final public static int SEND_SMS = 101;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookindetail1);
        extras = getIntent();
        flag = (ImageView) findViewById(R.id.flag);
        cancelbooking = (Button) findViewById(R.id.continuebooking);
        bookingId = extras.getStringExtra("BookingID");
        bookingID = (TextView) findViewById(R.id.bookingID);
        bookingID.setText("Booking ID - " + bookingId);

        PaymentStatus = extras.getStringExtra("PaymentStatus");
        BookStatus = extras.getStringExtra("bookStatus");
        try {
            if (PaymentStatus.contains("success")) {
                cancelbooking.setVisibility(View.GONE);
            }else {
                cancelbooking.setVisibility(View.VISIBLE);
            }
        } catch (NullPointerException ee) {

        }
        try {
            if (BookStatus.contains("Cancel")) {
                cancelbooking.setVisibility(View.GONE);
            }else {
                cancelbooking.setVisibility(View.VISIBLE);
            }
        } catch (NullPointerException ee) {

        }

       /* if (ToadyBookingFragment.todaybooking==true){
            cancelbooking.setVisibility(View.GONE);
        }
*/
//        Log.i("Status", PaymentStatus);
        session = extras.getStringExtra("Session");

        Log.i("BookingID", bookingId);
        date = (TextView) findViewById(R.id.date);
        date.setText(extras.getStringExtra("DATE"));
        players = (TextView) findViewById(R.id.players);
        players.setText(extras.getStringExtra("PLAYERS"));
        holes = (TextView) findViewById(R.id.holes);
        holes.setText(extras.getStringExtra("HOLE"));
        time = (TextView) findViewById(R.id.time);
        time.setText(timeconversion1(extras.getStringExtra("TIME")));
        amount = (TextView) findViewById(R.id.total);
        amount.setText("Rs." + extras.getStringExtra("AMOUNT"));
        buckets = (TextView) findViewById(R.id.buckets);
        if (session.contains("BDR")) {
            buckets.setText("No. of Buckets");
            holes.setText(extras.getStringExtra("Bucket"));
            flag.setBackgroundResource(R.drawable.buket_image);
        } else {
            flag.setBackgroundResource(R.drawable.flag);
        }

        cancelbooking.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                cdd = new Cancelbookingdialog(Bookingdetail.this);
                cdd.setCancelable(false);
                cdd.show();

            }
        });

        favriot = (ImageButton) findViewById(R.id.favriot);
        favriot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });

    }


    private class CancelBooking extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(Bookingdetail.this, null, "Cancelling.... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();

                jsonObject.accumulate("bookId", bookingId);
                //jsonObject.accumulate("membershipId","false");

                Log.i("Input", jsonObject.toString());

                String response = WebService.POST(App_Common.WebServiceUrl + "golfBookingCancel", jsonObject.toString());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("bookStatus");

                    if (status.contains("Success")) {

                        return true;
                    }
                    return false;
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
                new CancelBookingSMS().execute();

                //Toast.makeText(getApplicationContext(),"Your booking has cancelled",Toast.LENGTH_LONG).show();

            } else {

            }
        }
    }


    private class Cancelbookingdialog extends Dialog implements android.view.View.OnClickListener {

//        boolean cancelbooking = false;

        public Activity c;
        final Dialog d = new Dialog(getContext());
        public Button OK;
        private Button CANCEL;

        private Cancelbookingdialog(Activity a) {
            super(a);
            this.c = a;

        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.cancelbookingdialaglayout);
            //	d= new Dialog(getContext());

            OK = (Button) findViewById(R.id.ok);
            OK.setOnClickListener(this);
            CANCEL = (Button) findViewById(R.id.cancel);
            CANCEL.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.ok:

                    new CancelBooking().execute();
                    dismiss();

                    break;
                case R.id.cancel:
                    dismiss();

                    break;

            }
        }

    }

    public void ListingAlart() {

        String str = "<big>" + "Ok" + "</big>";
        CharSequence strFirst = Html.fromHtml(str);
        final CharSequence[] items = {"Your Booking has been successfully cancelled. Your money will be refunded within 7 working days."};

        final AlertDialog.Builder builder = new AlertDialog.Builder(Bookingdetail.this);
        builder.setTitle("Booking Cancelled");

        builder.setCancelable(false);

        builder.setPositiveButton(strFirst, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(Bookingdetail.this, BookingSelection.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        // Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        dialog.dismiss();
                    }
                });
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

            }
        });
        builder.show();
    }

    public String timeconversion1(String input) {

        //Date/time pattern of input date
        DateFormat df = new SimpleDateFormat("HH:mm");
        //Date/time pattern of desired output date
        DateFormat outputformat = new SimpleDateFormat("hh:mm a");
        Date date;
        String output = null;
        try {
            //Conversion of input String to date
            date = df.parse(input);
            //old date format to new date format
            output = outputformat.format(date);
            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return output;
    }

    private class CancelBookingSMS extends AsyncTask<String, Void, Boolean> {
        String BookingID = bookingId;
//        String phonnumber = App_Common.getInstance(getApplicationContext()).getUserNumber();
        protected ProgressDialog ringProgressDialog;
        String message = "Your%20booking%20ID-%20" + BookingID + "%20has%20been%20successfully%20cancelled." +
                "%20Your%20money%20will%20be%20refunded%20within%207%20days.";
//        String message1 = "Your%20Booking%20has%20been%20successfully%20cancelled.%20Your%20Booking%20ID-%20" + BookingID + "%20!%20" + "%20Your%20money%20will%20be%20refund%20within%207%20working%20days.%20You%20will%20receive%20update%20on%20your%20refund%20processed%20on%20your%20registered%20phone%20and%20email.";

        @Override
        protected void onPreExecute() {
            //  bindParameter	=strUserName+"/"+strEmailID+"/"+strPassword+"/"+strMobile+"/"+strMemberShip;

            strMobile = App_Common.getInstance(Bookingdetail.this).getUserNumber();
            strMessage = message;
            // ringProgressDialog = ProgressDialog.show(Bookingdetail.this, null, "Cancelling ... ", true);
            //  ringProgressDialog.setCancelable(false);
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

                    requestQueue = Volley.newRequestQueue(Bookingdetail.this);
                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                            url, null,
                            new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {

                                    try {
                                        message = response.getString("message");
                                        // ringProgressDialog.dismiss();

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    //Log.d(TAG, response.toString());

                                }
                            }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            VolleyLog.d("Error: " + error.getMessage());
                            // hide the progress dialog

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
            //  ringProgressDialog.dismiss();
            if (result) {
                ListingAlart();

            } else {

            }
        }

    }
}