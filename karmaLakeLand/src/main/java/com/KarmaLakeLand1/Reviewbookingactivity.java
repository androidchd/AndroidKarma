package com.KarmaLakeLand1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
//import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;

import com.paytm.pgsdk.PaytmMerchant;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import Helper.App_Common;
import Utility.WebService;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Reviewbookingactivity extends FragmentActivity {
    Button continuebooking;
    TextView date;
//    Context mContext;
    TextView time;
    TextView players;
    TextView holes;
    TextView greenfee;
    TextView greenfeenonmember;
    TextView playersnumber;
    String bookingid;
    String couponCode = null;
    TextView totalgreenfee;
    TextView taxesfees;
    TextView total;

    static int totalgreenfeecalculted;
    static int totalcalculated;
    static int totalbucketcalculated;
    int totalcouponvalue=0;
    ImageButton tv_header_title;
    LinearLayout bucketlayout;
    TextView bucketselected;
    int bucketselectedIN;
    ImageView flag;
    TextView buckets;
    LinearLayout couponcodelayout;
    EditText couponcode;
    List<EditText> lisEditTexts;
    Button checksavings;
    static int couponamount;
    int memberfee;
    int memberplayer = 0;
    int nonmemberfee;
    int nonemberplayer = 0;
    int amount;
    int bolls = 0;
    int totalmemberfees;
    int totalnonmemberfees;
//    TextView tvCoupon;
    int totalCoupon;
    int tax;
    int totaltaxesandfee;
    int totaltaxesandfeeofnonmemeber;
    int totaltaxesandfeeofmemeber;

//    TextView tvTwilight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewbooking2);

        lisEditTexts = new ArrayList<EditText>();
        couponcodelayout = (LinearLayout) findViewById(R.id.couponcodelayout);
        couponcode = (EditText) findViewById(R.id.couponcode);
        //tvCoupon = (TextView) findViewById(R.id.tv_coupon);
        total = (TextView) findViewById(R.id.total);
        if (EventTournaments.eventtournament == true) {
            amount = EventTournaments.amountofeventtournament;
        } else if (Bookingdriverange.BDRtime == true) {
            amount = Reviewbookingactivity.totalbucketcalculated - Reviewbookingactivity.couponamount;
        } else if (BookElectionFrgament.bookelectiontime == true) {
            amount = Addonsbooking.totalcalculated - Addonsbooking.couponamount;
        }
        total.setText("Rs. " + String.valueOf(amount));

        couponcode.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                couponcode.setError(null);
            }
        });

        checksavings = (Button) findViewById(R.id.checksavings);
        checksavings.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs()) {
                    if (isNetworkConnected()) {
                        new Couponcode().execute();
                    } else {

                    }
                } else {

                }


            }
        });
        flag = (ImageView) findViewById(R.id.flag);
        buckets = (TextView) findViewById(R.id.buckets);

        bucketlayout = (LinearLayout) findViewById(R.id.bucketlayout);
        bucketselected = (TextView) findViewById(R.id.bucketselected);
        tv_header_title = (ImageButton) findViewById(R.id.favriot);
        tv_header_title.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

//                boolean member = App_Common.getInstance(Reviewbookingactivity.this).getMember();

                // Bookingdriverange.date.setText("Select Date");
                //  Bookingdriverange.time.setText("Select Time");
                //  Bookingdriverange.timed = false;
                //   Bookingdriverange.dateselected = false;


                finish();
            }
        });
        continuebooking = (Button) findViewById(R.id.continuebooking);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        players = (TextView) findViewById(R.id.players);
        holes = (TextView) findViewById(R.id.holes);
        greenfee = (TextView) findViewById(R.id.greenfee);
        greenfeenonmember = (TextView) findViewById(R.id.greenfeenonmember);
        playersnumber = (TextView) findViewById(R.id.playersnumber);
        totalgreenfee = (TextView) findViewById(R.id.totalgreenfee);
        taxesfees = (TextView) findViewById(R.id.taxesfees);
        total = (TextView) findViewById(R.id.total);

        if (Bookingdriverange.BDRtime == true) {
            System.out.println(Integer.toString(Bookingdriverange.bucketselected));

            holes.setText(Integer.toString(Bookingdriverange.bucketselected));
            buckets.setText("No. of Balls");
            flag.setBackgroundResource(R.drawable.buket_image);
            if (Bookingdriverange.bucketselected == 50) {
                if (Bookingdriverange.memberplayer == 0) {
                    bolls = Bookingdriverange.totalbucketofnonmember;
                    bucketselectedIN = (Bookingdriverange.totalbucketofnonmember);
                } else {
                    bolls = Bookingdriverange.totalbucketofmember;
                    bucketselectedIN = (Bookingdriverange.totalbucketofmember);
                }
               // bucketselectedIN = (Bookingdriverange.totalbucketofnonmember);
            }
            if (Bookingdriverange.bucketselected == 100) {
                if (Bookingdriverange.memberplayer == 0) {
                    bolls = Bookingdriverange.totalbucketofnonmember;
                } else {
                    bolls = Bookingdriverange.totalbucketofmember;
                }
                bucketselectedIN = (bolls + 100);
            }
            if (Bookingdriverange.bucketselected == 150) {
                if (Bookingdriverange.memberplayer == 0) {
                    bolls = Bookingdriverange.totalbucketofnonmember;
                } else {
                    bolls = Bookingdriverange.totalbucketofmember;
                }
                bucketselectedIN = (bolls + 250);
            }
            if (Bookingdriverange.bucketselected == 200) {
                if (Bookingdriverange.memberplayer == 0) {
                    bolls = Bookingdriverange.totalbucketofnonmember;
                } else {
                    bolls = Bookingdriverange.totalbucketofmember;
                }
                bucketselectedIN = (bolls + 350);
            }

            bucketlayout.setVisibility(View.VISIBLE);
            bucketselected.setText("Rs. " + String.valueOf(bucketselectedIN));
            date.setText(Bookingdriverange.formattedDate);
            time.setText(timeconversion1(Bookingdriverange.timeselected));
            players.setText(String.valueOf(Bookingdriverange.playerselected));

            // greenfee.setText("Rs. 900");
            if (Bookingdriverange.greeenfeeofmember == null) {

            } else {
                try {
                    totaltaxesandfeeofmemeber = (Bookingdriverange.taxesandfeesofmemberInt * Bookingdriverange.memberplayer);
                } catch (NumberFormatException ee) {

                }
                memberfee = Bookingdriverange.greeenfeeofmemberInt;
                memberplayer = (Bookingdriverange.memberplayer);
                totalmemberfees = memberfee * memberplayer;
                if (memberplayer != 0) {
                    greenfee.setText(memberfee + "*" + memberplayer + " = Rs." + Integer.toString(totalmemberfees));
                }
            }
            if (Bookingdriverange.greeenfeeofnonmember == null) {

            } else {
                try {
                    totaltaxesandfeeofnonmemeber = (Bookingdriverange.taxesandfeesofnonmemberInt * Bookingdriverange.nonmemberplayer);
                } catch (NumberFormatException ee) {

                }
                nonmemberfee = Bookingdriverange.greeenfeeofnonmemberInt;
                nonemberplayer = Bookingdriverange.nonmemberplayer;
                totalnonmemberfees = nonmemberfee * nonemberplayer;
                if (nonemberplayer != 0) {
                    greenfeenonmember.setText(nonmemberfee + "*" + nonemberplayer + " = Rs." + Integer.toString(totalnonmemberfees));
                }
            }

            playersnumber.setText(String.valueOf(Bookingdriverange.playerselected));



                int totaltprice = totalmemberfees + totalnonmemberfees;
                totalgreenfeecalculted = totaltprice;
                totalgreenfee.setText("Rs. " + String.valueOf(totalgreenfeecalculted));
                totaltaxesandfee = totaltaxesandfeeofnonmemeber + totaltaxesandfeeofmemeber + 15;
                taxesfees.setText("Rs." + String.valueOf(totaltaxesandfee));
                tax = totaltaxesandfee;
                totalcalculated = totalgreenfeecalculted + tax + bucketselectedIN;
                totalbucketcalculated = totalcalculated;
                total.setText("Rs. " + String.valueOf(totalcalculated));


        }
        continuebooking.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                EventTournaments.eventtournament = false;
                onStartTransaction(v);


            }
        });

    }

    boolean chkInputs() {

        if (lisEditTexts.isEmpty()) {
            lisEditTexts.add(couponcode);

        }

        for (EditText editText : lisEditTexts) {

            if (editText.getText().toString().length() == 0) {
                editText.setError("Please enter the coupon code number.");
                return false;
            }

        }
        return true;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) (this.getSystemService(Context.CONNECTIVITY_SERVICE));
        return cm.getActiveNetworkInfo() != null;
    }

    public class Couponcode extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            couponCode = couponcode.getText().toString();
            ringProgressDialog = ProgressDialog.show(Reviewbookingactivity.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String couponCode1 = couponCode;
            try {

//                JSONObject jsonObject = new JSONObject();

                String bindParameter = "/" + couponCode1;


                String response = WebService.GET(App_Common.WebServiceUrl + "getCoupon" + bindParameter);


                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("cstatus");

                    if (status.contains("True")) {

                        couponamount = Integer.parseInt(jsonresponse.getString("cAmount"));


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
                try {

                    if (totalgreenfeecalculted>=couponamount) {
                        totalcouponvalue = totalgreenfeecalculted - couponamount;
                        Toast.makeText(getApplicationContext(), "Coupon code applied successfully ",Toast.LENGTH_LONG).show();

                    }else if (totalgreenfeecalculted<couponamount){
                        if (totalgreenfeecalculted==0){
                            Toast.makeText(getApplicationContext(), "Sorry! Your Range fee already 0. Coupon code applied on Range fee only", Toast.LENGTH_LONG).show();
                            totalcouponvalue=0;
                        }else if (totalgreenfeecalculted<couponamount){
                            Toast.makeText(getApplicationContext(), "Coupon code applied successfully ",Toast.LENGTH_LONG).show();
                            totalcouponvalue=0;
                        }

                    }
                    totalCoupon = totalcouponvalue + tax + bucketselectedIN;
                    totalcalculated = totalCoupon;

                        total.setText("Rs. " + String.valueOf(totalcalculated));


                    //couponcode.setText("");
                } catch (NullPointerException ee) {

                }
            } else {
                Toast.makeText(getApplicationContext(), "Oops! The coupon code entered is either invalid or has expired.", Toast.LENGTH_LONG).show();
                couponcode.setText("");
            }
        }
    }

    @Override
    public void onBackPressed() {
        memberplayer = 0;
        nonemberplayer = 0;
        Bookingdriverange.memeberupdate = false;
        Bookingdriverange.memberplayer = 0;
        Bookingdriverange.nonmemberplayer = 0;
        //   Bookingdriverange.date.setText("Select Date");
        //  Bookingdriverange.time.setText("Select Time");
        //  Bookingdriverange.timed = false;
        //  Bookingdriverange.dateselected = false;
        super.onBackPressed();
        finish();
    }

    public String timeconversion1(String input) {

        //Date/time pattern of input date
        DateFormat df = new SimpleDateFormat("HH:mm");
        //Date/time pattern of desired output date
        DateFormat outputformat = new SimpleDateFormat("hh:mm a");
        Date date = null;
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

    public void onStartTransaction(View view) {
        String url = "https://secure.paytm.in/oltp-web/processTransaction";
        String emial = App_Common.getInstance(Reviewbookingactivity.this).getUserEmailId();
        String mobile = App_Common.getInstance(Reviewbookingactivity.this).getUserNumber();
        int total = totalcalculated;

        PaytmPGService Service =PaytmPGService.getProductionService();
                //PaytmPGService.getStagingService();
        Map<String, String> paramMap = new HashMap<String, String>();

        // these are mandatory parameters
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);

        paramMap.put("ORDER_ID", String.valueOf(randomInt));
        paramMap.put("REQUEST_TYPE", "DEFAULT");
        paramMap.put("MID", "Appcen82465872859698");
        paramMap.put("CUST_ID", App_Common.getInstance(Reviewbookingactivity.this).getUserName() +String.valueOf(randomInt));
        paramMap.put("CHANNEL_ID", "WAP");
        paramMap.put("INDUSTRY_TYPE_ID", "Retail92");
        paramMap.put("WEBSITE", "AppcenWAP");
        paramMap.put("TXN_AMOUNT", Integer.toString(total));
        paramMap.put("THEME", "merchant");
        paramMap.put("EMAIL", emial);
        paramMap.put("MOBILE_NO", mobile);
        paramMap.put("CALLBACK_URL", url);
        PaytmOrder Order = new PaytmOrder(paramMap);
        PaytmMerchant Merchant = new PaytmMerchant("http://50.62.134.38:9191/GenerateChecksum.aspx", "http://50.62.134.38:9191/VerifyChecksum.aspx");


        Service.initialize(Order, Merchant, null);

        Service.startPaymentTransaction(Reviewbookingactivity.this, true, true,
                new PaytmPaymentTransactionCallback() {
                    @Override
                    public void someUIErrorOccurred(String inErrorMessage) {
                        Toast.makeText(Reviewbookingactivity.this, "Please Re-try ", Toast.LENGTH_LONG).show();
                        // Some UI Error Occurred in Payment Gateway Activity.
                        // // This may be due to initialization of views in
                        // Payment Gateway Activity or may be due to //
                        // initialization of webview. // Error Message details
                        // the error occurred.
                    }

                    @Override
                    public void onTransactionSuccess(Bundle inResponse) {
                        // After successful transaction this method gets called.
                        // // Response bundle contains the merchant response
                        // parameters.
                        Log.d("LOG", "Payment Transaction is successful " + inResponse);
                        Toast.makeText(Reviewbookingactivity.this, "Payment Transaction is successful ", Toast.LENGTH_LONG).show();

                        if (EventTournaments.eventtournament == true) {
                            new Addtournamnet().execute();
                        } else

                        {
                            new Bookingelection().execute();
                        }

                    }

                    @Override
                    public void onTransactionFailure(String inErrorMessage,
                                                     Bundle inResponse) {
                        // This method gets called if transaction failed. //
                        // Here in this case transaction is completed, but with
                        // a failure. // Error Message describes the reason for
                        // failure. // Response bundle contains the merchant
                        // response parameters.
                        Log.d("LOG", "Payment Transaction Failed " + inErrorMessage);
                        Toast.makeText(Reviewbookingactivity.this, "Payment Transaction Failed ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void networkNotAvailable() {
                        // If network is not
                        // available, then this
                        // method gets called.
                    }

                    @Override
                    public void clientAuthenticationFailed(String inErrorMessage) {
                        // This method gets called if client authentication
                        // failed. // Failure may be due to following reasons //
                        // 1. Server error or downtime. // 2. Server unable to
                        // generate checksum or checksum response is not in
                        // proper format. // 3. Server failed to authenticate
                        // that client. That is value of payt_STATUS is 2. //
                        // Error Message describes the reason for failure.
                    }

                    @Override
                    public void onErrorLoadingWebPage(int iniErrorCode,
                                                      String inErrorMessage, String inFailingUrl) {

                    }

                    // had to be added: NOTE
                    @Override
                    public void onBackPressedCancelTransaction() {
                        // TODO Auto-generated method stub
                    }

                });
    }

    public class Bookingelection extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(Reviewbookingactivity.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();


                jsonObject.accumulate("userId", App_Common.getInstance(Reviewbookingactivity.this).getUserID());
                if (BookElectionFrgament.bookelectiontime == true) {

                    jsonObject.accumulate("hole", String.valueOf(BookElectionFrgament.hole));
                    jsonObject.accumulate("date", String.valueOf(BookElectionFrgament.formattedDate));
                    jsonObject.accumulate("time", BookElectionFrgament.timeselected);
                    jsonObject.accumulate("session", "BTT");
                    jsonObject.accumulate("bucket", "0");
                    App_Common.getInstance(Reviewbookingactivity.this).setDate(BookElectionFrgament.formattedDate);
                    jsonObject.accumulate("player", String.valueOf(BookElectionFrgament.playerselected));
                } else if (Bookingdriverange.BDRtime == true) {

                    jsonObject.accumulate("hole", "0");
                    jsonObject.accumulate("date", String.valueOf(Bookingdriverange.formattedDate));
                    jsonObject.accumulate("time", Bookingdriverange.timeselected);
                    jsonObject.accumulate("session", "BDR");
                    jsonObject.accumulate("bucket", Bookingdriverange.bucketselected);
                    jsonObject.accumulate("player", String.valueOf(Bookingdriverange.playerselected));
                    App_Common.getInstance(Reviewbookingactivity.this).setDate(Bookingdriverange.formattedDate);

                }
                jsonObject.accumulate("addOn", " ");

                jsonObject.accumulate("amount", String.valueOf(Reviewbookingactivity.totalcalculated));
                jsonObject.accumulate("paymentMode", "netbanking");
                jsonObject.accumulate("sessionType", Integer.toString(TimeselectionFragment.sessiontype));


                Log.i("Input", jsonObject.toString());

                String response = WebService.POST(App_Common.WebServiceUrl + "golfBooking", jsonObject.toString());


                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("bookStatus");
                    if (status.contains("Error")) {
                        return false;
                    } else {
                        bookingid = jsonresponse.getString("bookId");
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

                Intent i = new Intent(Reviewbookingactivity.this, Bookingconfirmation.class);
                i.putExtra("Bookingid", bookingid);
                i.putExtra("AMOUNT", amount);


                startActivity(i);

            } else {

            }
        }
    }

    public class Addtournamnet extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(Reviewbookingactivity.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();

                jsonObject.accumulate("userId", App_Common.getInstance(Reviewbookingactivity.this).getUserID());
                jsonObject.accumulate("tournamentId", EventTournaments.tournamentid);
                jsonObject.accumulate("players", EventTournaments.playerselcted);
                jsonObject.accumulate("addon", " ");
                jsonObject.accumulate("amount", 200 * EventTournaments.playerselcted);
                jsonObject.accumulate("paymentMode", "netbanking");

                jsonObject.accumulate("playerdetail", EventTournaments.playerdetail);


                Log.i("Input", jsonObject.toString());

                String response = WebService.POST(App_Common.WebServiceUrl + "addTournamentDetail", jsonObject.toString());


                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("bookStatus");
                    if (status.contains("Error")) {
                        return false;
                    } else {
                        bookingid = jsonresponse.getString("bookId");
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

                Intent i = new Intent(Reviewbookingactivity.this, Bookingconfirmation1.class);

                i.putExtra("Bookingid", bookingid);
                startActivity(i);

            } else {

            }
        }
    }
}
