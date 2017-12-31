package com.KarmaLakeLand1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import com.paytm.pgsdk.PaytmMerchant;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import Helper.App_Common;
import Helper.Validation;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class EventTournaments extends FragmentActivity {

    Button player1;
    Button player2;
    Button player3;
    Button player4;
    ImageButton favriot;

    LinearLayout playerlayout1;
    LinearLayout playerlayout2;
    LinearLayout playerlayout3;
    LinearLayout playerlayout4;
    static int playerselcted;
    static int amountofeventtournament;
    static boolean eventtournament = false;
    Button register;
    String playerdetail1;
    String playerdetail2;
    String playerdetail3;
    String playerdetail4;

    static String playerdetail;
    EditText name1;
    EditText name2;
    EditText name3;
    EditText name4;


    EditText mobile1;
    EditText mobile2;
    EditText mobile3;
    EditText mobile4;


    EditText emailID1;
    EditText emailID2;
    EditText emailID3;
    EditText emailID4;


    EditText handicap1;
    EditText handicap2;
    EditText handicap3;
    EditText handicap4;
    TextView name;
    int totalamount=0;
    TextView total;
    int amount;
    String TotalAmount;
    String bookingid;

    Bundle getBundle = null;
    String position;
    static String tournamentid;
//    String playerdetails;
    List<EditText> lisEditTexts;

    @Override


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventsandtournamentsactivity);
//-------------------------------new code ---------------------------------
          total = (TextView) findViewById(R.id.total_amount);
        if (EventTournaments.eventtournament == true) {
            amount = EventTournaments.amountofeventtournament;
        } else if (Bookingdriverange.BDRtime == true) {
            amount = Reviewbookingactivity.totalbucketcalculated - Reviewbookingactivity.couponamount;
        } else if (BookElectionFrgament.bookelectiontime == true) {
            amount = Addonsbooking.totalcalculated - Addonsbooking.couponamount;
        }



        //-------------------------------------------------------------------------
        getBundle = this.getIntent().getExtras();
        tournamentid = getBundle.getString("tournamentID");
        System.out.print(tournamentid);

        lisEditTexts = new ArrayList<EditText>();
        favriot = (ImageButton) findViewById(R.id.favriot);


        name = (TextView) findViewById(R.id.Name);
        Intent intent = getIntent();
        String tournamentFee = intent.getStringExtra("tournamentFee");
        TotalAmount=intent.getStringExtra("tournamentFee");

        total.setText("Total amount:-"+"Rs. " + TotalAmount);

        int value = Integer.parseInt(tournamentFee);
        name.setText("Registration Fee: Rs." + value + "/Player");

        favriot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        name1 = (EditText) findViewById(R.id.name1);
        name2 = (EditText) findViewById(R.id.name2);
        name3 = (EditText) findViewById(R.id.name3);
        name4 = (EditText) findViewById(R.id.name4);

        mobile1 = (EditText) findViewById(R.id.mobile1);
        mobile2 = (EditText) findViewById(R.id.mobile2);
        mobile3 = (EditText) findViewById(R.id.mobile3);
        mobile4 = (EditText) findViewById(R.id.mobile4);

        emailID1 = (EditText) findViewById(R.id.emailID1);
        emailID2 = (EditText) findViewById(R.id.emailId2);
        emailID3 = (EditText) findViewById(R.id.emailId3);
        emailID4 = (EditText) findViewById(R.id.emailId4);

        handicap1 = (EditText) findViewById(R.id.handicap1);
        handicap2 = (EditText) findViewById(R.id.handicap2);
        handicap3 = (EditText) findViewById(R.id.handicap3);
        handicap4 = (EditText) findViewById(R.id.handicap4);
        final Pattern pattern = Pattern.compile(".*[^0-9].*");

        emailID1.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!Validation
                            .isValidEmail(emailID1.getText().toString())) {
                        emailID1.setError("Please Provide a Valid Email-Id.");
                    }
                }
            }
        });
        emailID2.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!Validation
                            .isValidEmail(emailID2.getText().toString())) {
                        emailID2.setError("Please Provide a Valid Email-Id.");
                    }
                }
            }
        });
        emailID3.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!Validation
                            .isValidEmail(emailID3.getText().toString())) {
                        emailID3.setError("Please Provide a Valid Email-Id.");
                    }
                }
            }
        });
        emailID4.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!Validation
                            .isValidEmail(emailID4.getText().toString())) {
                        emailID4.setError("Please Provide a Valid Email-Id.");
                    }
                }
            }
        });


        mobile1.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if ((mobile1.getText().toString().length() < 10 || mobile1
                            .getText().toString().length() > 10)
                            && pattern.matcher(mobile1.getText()).matches()) {
                        mobile1
                                .setError("Please Put Only Digits And Provide 10 Digit Number.");
                    } else if (pattern.matcher(mobile1.getText()).matches()) {
                        mobile1.setError("Please Put Only Digits.");
                    } else if (mobile1.getText().toString().length() < 10
                            || mobile1.getText().toString().length() > 10) {
                        mobile1.setError("Please Provide 10 Digit Number.");
                    }
                }
            }
        });
        mobile2.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if ((mobile1.getText().toString().length() < 10 || mobile1
                            .getText().toString().length() > 10)
                            && pattern.matcher(mobile1.getText()).matches()) {
                        mobile1
                                .setError("Please Put Only Digits And Provide 10 Digit Number.");
                    } else if (pattern.matcher(mobile1.getText()).matches()) {
                        mobile1.setError("Please Put Only Digits.");
                    } else if (mobile1.getText().toString().length() < 10
                            || mobile1.getText().toString().length() > 10) {
                        mobile1.setError("Please Provide 10 Digit Number.");
                    }
                }
            }
        });
        mobile3.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if ((mobile1.getText().toString().length() < 10 || mobile1
                            .getText().toString().length() > 10)
                            && pattern.matcher(mobile1.getText()).matches()) {
                        mobile1
                                .setError("Please Put Only Digits And Provide 10 Digit Number.");
                    } else if (pattern.matcher(mobile1.getText()).matches()) {
                        mobile1.setError("Please Put Only Digits.");
                    } else if (mobile1.getText().toString().length() < 10
                            || mobile1.getText().toString().length() > 10) {
                        mobile1.setError("Please Provide 10 Digit Number.");
                    }
                }
            }
        });
        mobile4.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if ((mobile1.getText().toString().length() < 10 || mobile1
                            .getText().toString().length() > 10)
                            && pattern.matcher(mobile1.getText()).matches()) {
                        mobile1
                                .setError("Please Put Only Digits And Provide 10 Digit Number.");
                    } else if (pattern.matcher(mobile1.getText()).matches()) {
                        mobile1.setError("Please Put Only Digits.");
                    } else if (mobile1.getText().toString().length() < 10
                            || mobile1.getText().toString().length() > 10) {
                        mobile1.setError("Please Provide 10 Digit Number.");
                    }
                }
            }
        });

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //new Eventtournamentapi().execute();
                if (chkInputs()) {
                    Intent intent = getIntent();
                    String tournamentFee = intent.getStringExtra("tournamentFee");
                    int value = Integer.parseInt(tournamentFee);
                    amountofeventtournament = value * playerselcted;
                    eventtournament = true;


                    if (playerselcted == 1) {


                        if (Validation.isValidEmail(emailID1.getText().toString()) && Validation.isValidNumber(mobile1.getText().toString())) {

                            playerdetail1 = name1.getText().toString() + " " + emailID1.getText().toString() + " " + mobile1.getText().toString();
                            playerdetail = playerdetail1;
                            int amount = Integer.parseInt(TotalAmount);
                           totalamount =amount*1;
                            total.setText("Rs. " + String.valueOf(totalamount));

                            onStartTransaction(v);
                           /* Intent i = new Intent(EventTournaments.this, MakePayment.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                            startActivity(i);*/

                        }

                    }
                    if (playerselcted == 2) {


                        if (Validation.isValidEmail(emailID1.getText().toString()) && Validation.isValidNumber(mobile1.getText().toString())) {
                            if (Validation.isValidEmail(emailID2.getText().toString()) && Validation.isValidNumber(mobile2.getText().toString())) {
                                playerdetail1 = name1.getText().toString() + " " + emailID1.getText().toString() + " " + mobile1.getText().toString();
                                playerdetail2 = name2.getText().toString() + " " + emailID2.getText().toString() + " " + mobile2.getText().toString();
                                playerdetail = playerdetail1 + "/" + playerdetail2;

                                int amount = Integer.parseInt(TotalAmount);
                                totalamount =amount*2;
                                total.setText("Rs. " + String.valueOf(totalamount));
                                onStartTransaction(v);
/*
                                Intent i = new Intent(EventTournaments.this, MakePayment.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                                startActivity(i);*/
                            }
                        }

                    }

                    if (playerselcted == 3) {


                        if (Validation.isValidEmail(emailID1.getText().toString()) && Validation.isValidNumber(mobile1.getText().toString())) {
                            if (Validation.isValidEmail(emailID2.getText().toString()) && Validation.isValidNumber(mobile2.getText().toString())) {
                                if (Validation.isValidEmail(emailID3.getText().toString()) == true && Validation.isValidNumber(mobile3.getText().toString())) {
                                    playerdetail1 = name1.getText().toString() + " " + emailID1.getText().toString() + " " + mobile1.getText().toString();
                                    playerdetail2 = name2.getText().toString() + " " + emailID2.getText().toString() + " " + mobile2.getText().toString();
                                    playerdetail3 = name3.getText().toString() + " " + emailID3.getText().toString() + " " + mobile3.getText().toString();
                                    playerdetail = playerdetail1 + "/" + playerdetail2 + "/" + playerdetail3;
                                    int amount = Integer.parseInt(TotalAmount);
                                    totalamount =amount*3;
                                    total.setText("Rs. " + String.valueOf(totalamount));
                                    onStartTransaction(v);
                                    /*Intent i = new Intent(EventTournaments.this, MakePayment.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                                    startActivity(i);*/
                                }
                            }
                        }


                        if (playerselcted == 4) {


                            if (Validation.isValidEmail(emailID1.getText().toString()) && Validation.isValidNumber(mobile1.getText().toString())) {
                                if (Validation.isValidEmail(emailID2.getText().toString()) && Validation.isValidNumber(mobile2.getText().toString())) {
                                    if (Validation.isValidEmail(emailID3.getText().toString()) && Validation.isValidNumber(mobile3.getText().toString()))
                                        if (Validation.isValidEmail(emailID4.getText().toString()) && Validation.isValidNumber(mobile4.getText().toString())) {

                                            playerdetail1 = name1.getText().toString() + " " + emailID1.getText().toString() + " " + mobile1.getText().toString();
                                            playerdetail2 = name2.getText().toString() + " " + emailID2.getText().toString() + " " + mobile2.getText().toString();
                                            playerdetail3 = name3.getText().toString() + " " + emailID3.getText().toString() + " " + mobile3.getText().toString();
                                            playerdetail4 = name4.getText().toString() + " " + emailID4.getText().toString() + " " + mobile4.getText().toString();
                                            playerdetail = playerdetail1 + "/" + playerdetail2 + "/" + playerdetail3 + "/" + playerdetail4;

                                            int amount = Integer.parseInt(TotalAmount);
                                            totalamount =amount*4;
                                            total.setText("Rs. " + String.valueOf(totalamount));
                                            onStartTransaction(v);

                                            /*Intent i = new Intent(EventTournaments.this, Addonsbooking.class);
                                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                                            Bundle b = new Bundle();
                                            b.putString("tournamentID", tournamentid);

                                            i.putExtras(b);


                                            startActivity(i);*/
                                        }
                                }
                            }
                        }

                    }
                }
            }


        });
        playerlayout1 = (LinearLayout) findViewById(R.id.player1);
        playerlayout2 = (LinearLayout) findViewById(R.id.player2);
        playerlayout3 = (LinearLayout) findViewById(R.id.player3);
        playerlayout4 = (LinearLayout) findViewById(R.id.player4);
        playerselcted = 1;
        player1 = (Button) findViewById(R.id.btn_player1);
        player1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                playerlayout1.setVisibility(View.VISIBLE);
                playerlayout2.setVisibility(View.GONE);
                playerlayout3.setVisibility(View.GONE);
                playerlayout4.setVisibility(View.GONE);
                player1.setBackgroundColor(Color.parseColor("#3061e5"));
                player1.setTextColor(Color.parseColor("#FFFFFF"));
                player2.setBackgroundResource(R.drawable.buttonstyle);
                player2.setTextColor(Color.parseColor("#000000"));
                player3.setBackgroundResource(R.drawable.buttonstyle);
                player3.setTextColor(Color.parseColor("#000000"));
                player4.setBackgroundResource(R.drawable.buttonstyle);
                player4.setTextColor(Color.parseColor("#000000"));
                playerselcted = 1;
                int amount = Integer.parseInt(TotalAmount);
                total.setText("Total amount:-"+" Rs. " + amount);
            }
        });
        player2 = (Button) findViewById(R.id.btn_player2);
        player2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                playerlayout1.setVisibility(View.VISIBLE);
                playerlayout2.setVisibility(View.VISIBLE);
                playerlayout3.setVisibility(View.GONE);
                playerlayout4.setVisibility(View.GONE);
                player2.setBackgroundColor(Color.parseColor("#3061e5"));
                player2.setTextColor(Color.parseColor("#FFFFFF"));
                player1.setBackgroundResource(R.drawable.buttonstyle);
                player1.setTextColor(Color.parseColor("#000000"));
                player3.setBackgroundResource(R.drawable.buttonstyle);
                player3.setTextColor(Color.parseColor("#000000"));
                player4.setBackgroundResource(R.drawable.buttonstyle);
                player4.setTextColor(Color.parseColor("#000000"));
                playerselcted = 2;
                int amount = Integer.parseInt(TotalAmount);
                total.setText("Total amount:-"+" Rs. " + amount*2);
            }
        });
        player3 = (Button) findViewById(R.id.btn_player3);
        player3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                playerlayout1.setVisibility(View.VISIBLE);
                playerlayout2.setVisibility(View.VISIBLE);
                playerlayout3.setVisibility(View.VISIBLE);
                playerlayout4.setVisibility(View.GONE);
                player3.setBackgroundColor(Color.parseColor("#3061e5"));
                player3.setTextColor(Color.parseColor("#FFFFFF"));
                player1.setBackgroundResource(R.drawable.buttonstyle);
                player1.setTextColor(Color.parseColor("#000000"));
                player2.setBackgroundResource(R.drawable.buttonstyle);
                player2.setTextColor(Color.parseColor("#000000"));
                player4.setBackgroundResource(R.drawable.buttonstyle);
                player4.setTextColor(Color.parseColor("#000000"));
                playerselcted = 3;
                int amount = Integer.parseInt(TotalAmount);
                total.setText("Total amount:-"+" Rs. " + amount*3);
            }
        });

        player4 = (Button) findViewById(R.id.btn_player4);
        player4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                playerlayout1.setVisibility(View.VISIBLE);
                playerlayout2.setVisibility(View.VISIBLE);
                playerlayout3.setVisibility(View.VISIBLE);
                playerlayout4.setVisibility(View.VISIBLE);
                player4.setBackgroundColor(Color.parseColor("#3061e5"));
                player4.setTextColor(Color.parseColor("#FFFFFF"));
                player2.setBackgroundResource(R.drawable.buttonstyle);
                player2.setTextColor(Color.parseColor("#000000"));
                player3.setBackgroundResource(R.drawable.buttonstyle);
                player3.setTextColor(Color.parseColor("#000000"));
                player1.setBackgroundResource(R.drawable.buttonstyle);
                player1.setTextColor(Color.parseColor("#000000"));
                playerselcted = 4;
                int amount = Integer.parseInt(TotalAmount);
                total.setText("Total amount:-"+" Rs. " + amount*4);
            }
        });
    }


    boolean chkInputs() {

        if (lisEditTexts.isEmpty()) {

            if (playerselcted == 1) {

                lisEditTexts.add(name1);
                lisEditTexts.add(mobile1);
                lisEditTexts.add(emailID1);
                lisEditTexts.add(handicap1);
            }

            if (playerselcted == 2) {
                lisEditTexts.add(name1);
                lisEditTexts.add(mobile1);
                lisEditTexts.add(emailID1);
                lisEditTexts.add(handicap1);
                lisEditTexts.add(name2);
                lisEditTexts.add(mobile2);
                lisEditTexts.add(emailID2);
                lisEditTexts.add(handicap2);
            }
            if (playerselcted == 3) {
                lisEditTexts.add(name1);
                lisEditTexts.add(mobile1);
                lisEditTexts.add(emailID1);
                lisEditTexts.add(handicap1);
                lisEditTexts.add(name2);
                lisEditTexts.add(mobile2);
                lisEditTexts.add(emailID2);
                lisEditTexts.add(handicap2);
                lisEditTexts.add(name3);
                lisEditTexts.add(mobile3);
                lisEditTexts.add(emailID3);
                lisEditTexts.add(handicap3);
            }
            if (playerselcted == 4) {
                lisEditTexts.add(name1);
                lisEditTexts.add(mobile1);
                lisEditTexts.add(emailID1);
                lisEditTexts.add(handicap1);
                lisEditTexts.add(name2);
                lisEditTexts.add(mobile2);
                lisEditTexts.add(emailID2);
                lisEditTexts.add(handicap2);
                lisEditTexts.add(name3);
                lisEditTexts.add(mobile3);
                lisEditTexts.add(emailID3);
                lisEditTexts.add(handicap3);
                lisEditTexts.add(name4);
                lisEditTexts.add(mobile4);
                lisEditTexts.add(emailID4);
                lisEditTexts.add(handicap4);
            }

        }

        for (EditText editText : lisEditTexts) {

            if (editText.getText().toString().length() == 0) {
                editText.setError("Please enter the fields");
                return false;
            }

        }
        return true;
    }

//    public boolean isValidEmail(String email) {
//        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//
//        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }

    // validating password with retype password
//    public boolean isValidMobile(String phone2) {
//        String text = " ";
//        boolean check = false;
//        if (!Pattern.matches("[a-zA-Z]+", text)) {
//            if (phone2.length() < 6 || phone2.length() > 13) {
//                check = false;
//                // txtPhone.setError("Not Valid Number");
//            } else {
//                check = true;
//            }
//        } else {
//            check = false;
//        }
//        return check;
//    }

    public class Bookingelection extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(EventTournaments.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();


                jsonObject.accumulate("userId", App_Common.getInstance(EventTournaments.this).getUserID());
                if (BookElectionFrgament.bookelectiontime == true) {

                    jsonObject.accumulate("hole", String.valueOf(BookElectionFrgament.hole));
                    jsonObject.accumulate("date", String.valueOf(BookElectionFrgament.formattedDate));
                    jsonObject.accumulate("time", BookElectionFrgament.timeselected);
                    jsonObject.accumulate("session", "BTT");
                    jsonObject.accumulate("bucket", "0");
                    App_Common.getInstance(EventTournaments.this).setDate(BookElectionFrgament.formattedDate);
                    jsonObject.accumulate("player", String.valueOf(BookElectionFrgament.playerselected));
                } else if (Bookingdriverange.BDRtime == true) {

                    jsonObject.accumulate("hole", "0");
                    jsonObject.accumulate("date", String.valueOf(Bookingdriverange.formattedDate));
                    jsonObject.accumulate("time", Bookingdriverange.timeselected);
                    jsonObject.accumulate("session", "BDR");
                    jsonObject.accumulate("bucket", Bookingdriverange.bucketselected);
                    jsonObject.accumulate("player", String.valueOf(Bookingdriverange.playerselected));
                    App_Common.getInstance(EventTournaments.this).setDate(Bookingdriverange.formattedDate);

                }
                jsonObject.accumulate("addOn", " ");

                jsonObject.accumulate("amount", String.valueOf(Addonsbooking.totalcalculated));
                jsonObject.accumulate("paymentMode", "netbanking");
                jsonObject.accumulate("sessionType", Integer.toString(TimeselectionFragment.sessiontype));


                Log.i("Input", jsonObject.toString());

                String response = Utility.WebService.POST(App_Common.WebServiceUrl + "golfBooking", jsonObject.toString());


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

                Intent i = new Intent(EventTournaments.this, Bookingconfirmation.class);
                i.putExtra("Bookingid", bookingid);


                startActivity(i);

            } else {

            }
        }
    }

    public class Addtournamnet extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(EventTournaments.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();

                jsonObject.accumulate("userId", App_Common.getInstance(EventTournaments.this).getUserID());
                jsonObject.accumulate("tournamentId", EventTournaments.tournamentid);
                jsonObject.accumulate("players", EventTournaments.playerselcted);
                jsonObject.accumulate("addon", " ");
                jsonObject.accumulate("amount", 200 * EventTournaments.playerselcted);
                jsonObject.accumulate("paymentMode", "netbanking");

                jsonObject.accumulate("playerdetail", EventTournaments.playerdetail);


                Log.i("Input", jsonObject.toString());

                String response = Utility.WebService.POST(App_Common.WebServiceUrl + "addTournamentDetail", jsonObject.toString());


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

                Intent i = new Intent(EventTournaments.this, Bookingconfirmation1.class);

                i.putExtra("Bookingid", bookingid);
                startActivity(i);

            } else {

            }
        }
    }

    public void onStartTransaction(View view) {

        PaytmPGService Service = null;
        Service = PaytmPGService.getStagingService();
        Map<String, String> paramMap = new HashMap<String, String>();

        // these are mandatory parameters
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);


 /*PaytmMerchant Merchant = new PaytmMerchant("https://pguat.paytm.com/merchant-chksum/ChecksumGenerator",
                "https://pguat.paytm.com/merchant-chksum/ValidateChksum");*/


        paramMap.put("ORDER_ID", String.valueOf(randomInt));
        paramMap.put("REQUEST_TYPE", "DEFAULT");
        paramMap.put("MID", "Appcen73346246512349");
        paramMap.put("CUST_ID", /*App_Common.getInstance(EventTournaments.this).getUserName() +*/ String.valueOf(randomInt));
        paramMap.put("CHANNEL_ID", "WAP");
        paramMap.put("INDUSTRY_TYPE_ID", "Retail");
        paramMap.put("WEBSITE", "Appcenwap");
        paramMap.put("TXN_AMOUNT", Integer.toString(totalamount));
        paramMap.put("THEME", "merchant");
        paramMap.put("EMAIL", App_Common.getInstance(EventTournaments.this).getUserEmailId());
        paramMap.put("MOBILE_NO", App_Common.getInstance(EventTournaments.this).getUserNumber());


        PaytmOrder Order = new PaytmOrder(paramMap);

        PaytmMerchant Merchant = new PaytmMerchant("http://golfapp.webfreak.in/GenerateChecksum.aspx",
                "http://golfapp.webfreak.in/VerifyChecksum.aspx");


        Service.initialize(Order, Merchant, null);

        Service.startPaymentTransaction(EventTournaments.this, true, true,
                new PaytmPaymentTransactionCallback() {
                    @Override
                    public void someUIErrorOccurred(String inErrorMessage) {
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
                        Toast.makeText(EventTournaments.this, "Payment Transaction is successful ", Toast.LENGTH_LONG).show();

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
                        Toast.makeText(EventTournaments.this, "Payment Transaction Failed ", Toast.LENGTH_LONG).show();
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
}
