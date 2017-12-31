
package com.KarmaLakeLand1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Helper.App_Common;
import Utility.WebService;

import static java.lang.Integer.*;

public class BookElectionFrgament extends Fragment implements OnClickListener {

    private static final int REQUEST_LOCATION = 99;
    Button continuebooking;
    LinearLayout bookselectionfragment;
    static String formattedDate;
    static boolean dateselected = false;
    Button hole9;
    Button hole18;
    //    Context ctx;
//    String members;
//    String nonmembers;
    static boolean BTTtime = false;
    static String taxesofmember;
    static String taxesofnonmember;
    static String confeeofmember;
    static String confeeofnonmember;
    static int totaltaxesofmember;
    static int totaltaxesofnonmember;
    static int taxesofmemberInt;
    static int taxesofnonmemberInt;
    static int confeeofmemberInt;
    static int confeeofnonmemberInt;
    static String greeenfeeofmember;
    static String greeenfeeofnonmember;
    static int greenfeemember;
    static int greenfeenonmemeber;
    static String Caddiehole9;
    static String Caddiehole18;
    static String Carthole9;
    static String Carthole18,texes;

//    String mobileNumber= App_Common.getInstance(ctx).getUserNumber();
//    int memberofplayer;
//    int nonmemberofplayer;

    static int totalgreenfeemember;
    static int totalgreenfeenonmember;
    String addOnCaddie;
    String addOnCart;
    static String formatid;
    String greenFee;
    String holes;
    String mType;
    static boolean memeberupdate = false;
    static String formattedDay;
    static boolean continuebookinghit = false;
    static int nonmemberplayer = 0;
    static int memberplayer = 0;
    static Ratecarddata ratecard1;
    int value = 0;
    int value1 = 0;

//    String dayId;

    public static Boolean bookelectiontime = false;
    ImageView timeselection;
    ImageView dateselection;

//    private int year;
//    private int month;
//    private int day;

    static TextView date;
    TextView RateCard;

//    static final int DATE_PICKER_ID = 1111;

    Button player1;
    Button player2;
    Button player3;
    Button player4;
    static int playerselected;
    static int hole;
    static TextView timetv;
    static String timeselected = null;
    static boolean timeselectedtime = false;
    LinearLayout timeselectedlayout;
    LinearLayout dateselectedlayout;
    String mstId;
    static String taxesandfess9hole;
    static String taxesandfees18hole;

//    Ratecarddatamember datamember1 = new Ratecarddatamember();

    Ratecarddataofnonmember dataofnonmember = new Ratecarddataofnonmember();
//    EditText dialogMobile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bookselectionfragment, container, false);

        permission();

        hole9 = (Button) view.findViewById(R.id.hole9);
        hole18 = (Button) view.findViewById(R.id.hole18);

        ratecard1 = new Ratecarddata();
        //totalgreenfeenonmember=0;
        bookselectionfragment = (LinearLayout) view.findViewById(R.id.bookselection);
        timeselectedlayout = (LinearLayout) view.findViewById(R.id.timeselectedlayout);

        timeselectedlayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (isNetworkConnected()) {
                    if (!dateselected) {
                        Toast.makeText(getActivity(),"Please select the date", Toast.LENGTH_LONG).show();
                    } else {
                        bookelectiontime = true;
                        Bookingdriverange.BDRtime = false;
                        Intent firstpage = new Intent(getActivity(), TimeSelectionActivity.class);
                        firstpage.putExtra("bucketno","BookElection");
                        startActivity(firstpage);

                    }
                } else {
                    Toast.makeText(getActivity(), "Please check your Internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });

        dateselectedlayout = (LinearLayout) view.findViewById(R.id.dateselectedlayout);

        dateselectedlayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (isNetworkConnected()) {
                    BookElectionFrgament.timeselectedtime = false;
                    timetv.setText("Select Time");
                    DialogFragment picker = new DatePickerFragment();
                    picker.show(getFragmentManager(), "datePicker");
                } else {
                    Toast.makeText(getActivity(), "Please check your Internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });

        date = (TextView) view.findViewById(R.id.date);
        Log.i("DATE set", date.getText().toString());
        //bookelectiontime = false;
        Bookingdriverange.BDRtime = false;
        playerselected = 0;
        hole = 9;
        timetv = (TextView) view.findViewById(R.id.timetv);

        player1 = (Button) view.findViewById(R.id.player1);
        player1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (dateselected == true && bookelectiontime == true) {
                    memeberupdate = false;
                    player1.setBackgroundColor(Color.parseColor("#3061e5"));
                    player1.setTextColor(Color.parseColor("#FFFFFF"));
                    player2.setBackgroundResource(R.drawable.buttonstyle);
                    player2.setTextColor(Color.parseColor("#000000"));
                    player3.setBackgroundResource(R.drawable.buttonstyle);
                    player3.setTextColor(Color.parseColor("#000000"));
                    player4.setBackgroundResource(R.drawable.buttonstyle);
                    player4.setTextColor(Color.parseColor("#000000"));
                    playerselected = 1;

                    Numberofplayer1dialog cdd = new Numberofplayer1dialog(getActivity());
                    cdd.show();
                } else {
                    Toast.makeText(getActivity(), "Please select date and time first", Toast.LENGTH_LONG).show();
                }
            }
        });
        player2 = (Button) view.findViewById(R.id.player2);
        player2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (!dateselected || !bookelectiontime) {
                    Toast.makeText(getActivity(), "Please select date and time first", Toast.LENGTH_LONG).show();
                } else {
                    memeberupdate = false;
                    player2.setBackgroundColor(Color.parseColor("#3061e5"));
                    player2.setTextColor(Color.parseColor("#FFFFFF"));
                    player1.setBackgroundResource(R.drawable.buttonstyle);
                    player1.setTextColor(Color.parseColor("#000000"));
                    player3.setBackgroundResource(R.drawable.buttonstyle);
                    player3.setTextColor(Color.parseColor("#000000"));
                    player4.setBackgroundResource(R.drawable.buttonstyle);
                    player4.setTextColor(Color.parseColor("#000000"));
                    playerselected = 2;

                    Numberofplayerdialog cdd = new Numberofplayerdialog(getActivity());
                    cdd.show();
                }
            }
        });
        player3 = (Button) view.findViewById(R.id.player3);
        player3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (!dateselected || !bookelectiontime) {
                    Toast.makeText(getActivity(), "Please select date and time first", Toast.LENGTH_LONG).show();
                } else {
                    memeberupdate = false;
                    player3.setBackgroundColor(Color.parseColor("#3061e5"));
                    player3.setTextColor(Color.parseColor("#FFFFFF"));
                    player1.setBackgroundResource(R.drawable.buttonstyle);
                    player1.setTextColor(Color.parseColor("#000000"));
                    player2.setBackgroundResource(R.drawable.buttonstyle);
                    player2.setTextColor(Color.parseColor("#000000"));
                    player4.setBackgroundResource(R.drawable.buttonstyle);
                    player4.setTextColor(Color.parseColor("#000000"));
                    playerselected = 3;
                    //  memeberupdate = true;
                    Numberofplayerdialog cdd = new Numberofplayerdialog(getActivity());
                    cdd.show();
                }
            }
        });
        player4 = (Button) view.findViewById(R.id.player4);
        player4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (!dateselected || !bookelectiontime) {

                } else {
                    memeberupdate = false;
                    player4.setBackgroundColor(Color.parseColor("#3061e5"));
                    player4.setTextColor(Color.parseColor("#FFFFFF"));
                    player2.setBackgroundResource(R.drawable.buttonstyle);
                    player2.setTextColor(Color.parseColor("#000000"));
                    player3.setBackgroundResource(R.drawable.buttonstyle);
                    player3.setTextColor(Color.parseColor("#000000"));
                    player1.setBackgroundResource(R.drawable.buttonstyle);
                    player1.setTextColor(Color.parseColor("#000000"));
                    playerselected = 4;
                    Numberofplayerdialog cdd = new Numberofplayerdialog(getActivity());
                    cdd.show();
                }
            }
        });
        hole9 = (Button) view.findViewById(R.id.hole9);
        hole9.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                hole9.setBackgroundColor(Color.parseColor("#3061e5"));
                hole9.setTextColor(Color.parseColor("#FFFFFF"));
                hole18.setBackgroundResource(R.drawable.buttonstyle);
                hole18.setTextColor(Color.parseColor("#000000"));
                hole = 9;
                memeberupdate = false;
                player1.setBackgroundResource(R.drawable.buttonstyle);
                player1.setTextColor(Color.parseColor("#000000"));
                player2.setBackgroundResource(R.drawable.buttonstyle);
                player2.setTextColor(Color.parseColor("#000000"));
                player3.setBackgroundResource(R.drawable.buttonstyle);
                player3.setTextColor(Color.parseColor("#000000"));
                player4.setBackgroundResource(R.drawable.buttonstyle);
                player4.setTextColor(Color.parseColor("#000000"));
                //new RateCardofNonmember().execute();
                // new RateCardofmember().execute();

            }
        });
        hole18 = (Button) view.findViewById(R.id.hole18);
        hole18.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                hole18.setBackgroundColor(Color.parseColor("#3061e5"));
                hole18.setTextColor(Color.parseColor("#FFFFFF"));
                hole9.setBackgroundResource(R.drawable.buttonstyle);
                hole9.setTextColor(Color.parseColor("#000000"));
                hole = 18;
                memeberupdate = false;
                player1.setBackgroundResource(R.drawable.buttonstyle);
                player1.setTextColor(Color.parseColor("#000000"));
                player2.setBackgroundResource(R.drawable.buttonstyle);
                player2.setTextColor(Color.parseColor("#000000"));
                player3.setBackgroundResource(R.drawable.buttonstyle);
                player3.setTextColor(Color.parseColor("#000000"));
                player4.setBackgroundResource(R.drawable.buttonstyle);
                player4.setTextColor(Color.parseColor("#000000"));
                // new RateCardofNonmember().execute();
                //new RateCardofmember().execute();
            }
        });
        RateCard = (TextView) view.findViewById(R.id.ratecard);

        RateCard.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (isNetworkConnected()) {
                    if ((!dateselected)) {
                        Toast.makeText(getActivity(), "Please select date and time ", Toast.LENGTH_LONG).show();
                    } else {
                        if (!timeselectedtime) {
                            Toast.makeText(getActivity(), "Please select the time", Toast.LENGTH_LONG).show();
                        } else {
                            new RateCard6().execute();
                        }
                    }
                } else {
                    Toast.makeText(getActivity(), "Please check your Internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });

        timeselection = (ImageView) view.findViewById(R.id.timeselection);
        dateselection = (ImageView) view.findViewById(R.id.dateselection);

        continuebooking = (Button) view.findViewById(R.id.continuebooking);

        continuebooking.setOnClickListener(this);

        return view;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) (getActivity().getSystemService(Context.CONNECTIVITY_SERVICE));
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onClick(View view) {
    /*	Intent i =new Intent(getActivity(),Reviewbookingactivity.class);
        startActivity(i);*/
        switch (view.getId()) {
            case R.id.continuebooking:
                if ((!dateselected)) {
                    Toast.makeText(getActivity(), "Please select date and time", Toast.LENGTH_SHORT).show();
                } else {
                    if (!timeselectedtime) {
                        Toast.makeText(getActivity(), "Please select  time", Toast.LENGTH_SHORT).show();
                    } else {

                        if (memeberupdate) {
                        } else {
                            if (playerselected == 1) {
                                Numberofplayer1dialog cdd = new Numberofplayer1dialog(getActivity());
                                cdd.show();
                            } else {
                                Toast.makeText(getActivity(), "Please update the player information ", Toast.LENGTH_SHORT).show();
                            }
                        }

                        if (isNetworkConnected()) {
                            if (!memeberupdate) {
                                Toast.makeText(getActivity(), "Please update the player information ", Toast.LENGTH_SHORT).show();
                            } else {
                                continuebookinghit = true;
                                new RateCard().execute();
                                bookelectiontime = true;
                                BTTtime = true;
                                Bookingdriverange.BDRtime = false;

                            }
                        } else {
                            Toast.makeText(getActivity(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        }
    }

    public static BookElectionFrgament newInstance(String text) {

        BookElectionFrgament f = new BookElectionFrgament();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    private static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            Date today = new Date();
            c.setTime(today);
            // c.add( Calendar.MONTH, -6); // Subtract 6 months
            long minDate = c.getTime().getTime();
            final Calendar c1 = Calendar.getInstance();
            c1.setTime(today);
            c1.add(Calendar.DATE, 30);
            long maxdate = c1.getTime().getTime();

            // Create a new instance of DatePickerDialog and return it
            DatePickerDialog pickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);

            pickerDialog.getDatePicker().setMinDate(minDate);
            pickerDialog.getDatePicker().setMaxDate(maxdate);
            return pickerDialog;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            Calendar c = Calendar.getInstance();
            c.set(year, month, day);

            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            formattedDate = sdf.format(c.getTime());
            dateselected = true;

            SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE");

            formattedDay = sdf1.format(c.getTime());
            ratecard1.setDayselected(formattedDay);
            Log.i(formattedDate, formattedDay);
            date.setText(formattedDate);


        }
    }

    private class Numberofplayerdialog extends Dialog implements android.view.View.OnClickListener {

//        boolean cancelbooking = false;

        public Activity c;
        final Dialog d = new Dialog(getContext());
        public Button OK;
        private Button CANCEL;
        private EditText members;
        private EditText nonmembers;

        private Numberofplayerdialog(Activity a) {
            super(a);
            // TODO Auto-generated constructor stub
            this.c = a;

        }
        // TODO Auto-generated constructor stub


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.numberplayersdialog);
            //	d= new Dialog(getContext());
            d.setCanceledOnTouchOutside(false);

            members = (EditText) findViewById(R.id.members);
            nonmembers = (EditText) findViewById(R.id.nonmembers);
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

                    try {
                        value = parseInt(members.getText().toString());
                    } catch (NumberFormatException ignored) {

                    }
                    try {
                        value1 = parseInt(nonmembers.getText().toString());
                    } catch (NumberFormatException ignored) {

                    }

                    if ((members.getText().toString().length() > 0) || (nonmembers.getText().toString().length() > 0)) {
                        if (playerselected == 2) {
                            int total = value + value1;
                            if (total == 2) {
                                if (value == playerselected || value1 == playerselected || value + value1 == playerselected) {
                                    memberplayer = value;
                                    nonmemberplayer = value1;
                                    memeberupdate = true;
                                    App_Common.getInstance(getActivity()).setMemberPlayer(Integer.toString(value));
                                    App_Common.getInstance(getActivity()).setMemberPlayer(Integer.toString(value1));
                                    new RateCardofmember().execute();
                                    new RateCardofNonmember().execute();
                                    dismiss();
                                } else {
                                    Toast.makeText(getActivity(), "Invalid number of players", Toast.LENGTH_SHORT).show();
                                    value = 0;
                                    value1 = 0;
                                }
                            } else {
                                Toast.makeText(getActivity(), "Invalid number of players", Toast.LENGTH_SHORT).show();
                                value = 0;
                                value1 = 0;
                            }

                        } else if (playerselected == 3) {
                            int total = value + value1;
                            if (total == 3) {
                                if (value == playerselected || value1 == playerselected || value + value1 == playerselected) {
                                    memberplayer = value;
                                    nonmemberplayer = value1;
                                    memeberupdate = true;
                                    App_Common.getInstance(getActivity()).setMemberPlayer(Integer.toString(value));
                                    App_Common.getInstance(getActivity()).setMemberPlayer(Integer.toString(value1));
                                    new RateCardofmember().execute();
                                    new RateCardofNonmember().execute();
                                    dismiss();
                                } else {
                                    Toast.makeText(getActivity(), "Invalid number of players", Toast.LENGTH_SHORT).show();
                                    value = 0;
                                    value1 = 0;
                                }
                            } else {
                                Toast.makeText(getActivity(), "Invalid number of players", Toast.LENGTH_SHORT).show();
                                value = 0;
                                value1 = 0;
                            }
                        } else if (playerselected == 4) {
                            int total = value + value1;
                            if (total == 4) {
                                if (value == playerselected || value1 == playerselected || value + value1 == playerselected) {
                                    memberplayer = value;
                                    nonmemberplayer = value1;
                                    memeberupdate = true;
                                    App_Common.getInstance(getActivity()).setMemberPlayer(Integer.toString(value));
                                    App_Common.getInstance(getActivity()).setMemberPlayer(Integer.toString(value1));
                                    new RateCardofmember().execute();
                                    new RateCardofNonmember().execute();
                                    dismiss();
                                } else {
                                    Toast.makeText(getActivity(), "Invalid number of players", Toast.LENGTH_SHORT).show();
                                    value = 0;
                                    value1 = 0;
                                }
                            } else {
                                Toast.makeText(getActivity(), "Invalid number of players", Toast.LENGTH_SHORT).show();
                                value = 0;
                                value1 = 0;
                            }
                        }

                    } else {
                        Toast.makeText(getActivity(), "Please select the players", Toast.LENGTH_SHORT).show();

                    }

                    c.finishActivity(1);
                    break;
                case R.id.cancel:
                    dismiss();
                    value = 0;
                    value1 = 0;
                    player1.setBackgroundResource(R.drawable.buttonstyle);
                    player1.setTextColor(Color.parseColor("#000000"));
                    player2.setBackgroundResource(R.drawable.buttonstyle);
                    player2.setTextColor(Color.parseColor("#000000"));
                    player3.setBackgroundResource(R.drawable.buttonstyle);
                    player3.setTextColor(Color.parseColor("#000000"));
                    player4.setBackgroundResource(R.drawable.buttonstyle);
                    player4.setTextColor(Color.parseColor("#000000"));
                    // c.finishActivity(1);
                    break;

            }
        }

    }


    private class Numberofplayer1dialog extends Dialog implements
            android.view.View.OnClickListener {

        //        boolean cancelbooking = false;
         Activity c;
        final Dialog d = new Dialog(getContext());
        private Button OK;
        private Button CANCEL;
        private RadioGroup radioSexGroup;
        private RadioButton radioSexButton;

        private Numberofplayer1dialog(Activity a) {
            super(a);
            // TODO Auto-generated constructor stub
            this.c = a;

        }
        // TODO Auto-generated constructor stub


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.player1dialog);
            //	d= new Dialog(getContext());


            OK = (Button) findViewById(R.id.ok);
            OK.setOnClickListener(this);
            CANCEL = (Button) findViewById(R.id.cancel);
            CANCEL.setOnClickListener(this);

            radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);

        }


        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.ok:
                    int selectedId = radioSexGroup.getCheckedRadioButtonId();

                    // find the radiobutton by returned id
                    radioSexButton = (RadioButton) findViewById(selectedId);

					/*Toast.makeText(getActivity(),
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();*/
                    Log.i("Selection", radioSexButton.getText().toString());
                    if (radioSexButton.getText().toString().matches("Member")) {

                        memberplayer = 1;
                        nonmemberplayer = 0;
                        memeberupdate = true;
                        new RateCardofmember().execute();


                    } else if (radioSexButton.getText().toString().matches("Non Member")) {

                        memberplayer = 0;
                        nonmemberplayer = 1;
                        memeberupdate = true;
                        new RateCardofNonmember().execute();

                    } else {
                        dismiss();
                    }
                    dismiss();
                    break;
                case R.id.cancel:
                    dismiss();
                    player1.setBackgroundResource(R.drawable.buttonstyle);
                    player1.setTextColor(Color.parseColor("#000000"));

                    // c.finishActivity(1);
                    break;
            }
        }
    }

    private class RateCard extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(getActivity(), null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

//                JSONObject jsonObject = new JSONObject();

                boolean member = App_Common.getInstance(getActivity()).getMember();

                String date = formattedDate;

                if (member == true) {
                    mstId = "1";

                    if (playerselected == 1) {
                    }

                } else {
                    mstId = "2";
                    if (playerselected == 1) {
                        // nonmemberplayer=1;
                    }

                }

                String timeid = String.valueOf(TimeselectionFragment.sessiontype);

                String bindparameter = date + "/" + mstId + "/" + timeid;

                String response = WebService.GET(App_Common.WebServiceUrl + "getRateCard/" + bindparameter);

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                JSONObject jsonobject = new JSONObject(response);

                JSONArray jsonarray = jsonobject.getJSONArray("holesPriceBTT");

                for (int i = 0; i < jsonarray.length(); i++) {

                    String dayId = jsonarray.getJSONObject(i).getString("dayId");
                    if (dayId.contains("1")) {
                        ratecard1.setDay1(jsonarray.getJSONObject(i).getString("days"));

                        JSONArray json1 = new JSONArray(jsonarray.getJSONObject(i).getString("holesPriceBTTHoles"));
                        for (int k = 0; k < json1.length(); k++) {

                            addOnCaddie = json1.getJSONObject(k).getString("addOnCaddie");
                            addOnCart = json1.getJSONObject(k).getString("addOnCart");

                            String hole = json1.getJSONObject(k).getString("holes");
                            Log.i("Holes", hole);

                            String greenFee = json1.getJSONObject(k).getString("greenFee");
                            if (hole.contains("9")) {
                                taxesandfess9hole = json1.getJSONObject(k).getString("taxesAndFees");
                                Caddiehole9 = addOnCaddie;
                                Carthole9 = addOnCart;
                                ratecard1.setHole9rate(greenFee);
                                Log.e("Shama", greenFee);
                                ratecard1.setCaddiehole9(addOnCaddie);
                                ratecard1.setCarthole9(addOnCart);
                            } else if (hole.contains("18")) {
                                ratecard1.setHole18rate(greenFee);
                                taxesandfees18hole = json1.getJSONObject(k).getString("taxesAndFees");
                                ratecard1.setCaddiehole18(addOnCaddie);
                                ratecard1.setCarthole18(addOnCart);
                                Caddiehole18 = addOnCaddie;
                                Caddiehole9 = addOnCart;

                            }

                            mType = json1.getJSONObject(k).getString("mType");
                        }
                        // greenfesscalcultion(mstId);
                        Log.i("Data ", "Caddiefee -" + addOnCaddie + "Cartfee-" + addOnCart + "Greenfee" + greenFee + "Membertype" + mType);
                    }

                    if (dayId.contains("2")) {
                        ratecard1.setDay2(jsonarray.getJSONObject(i).getString("days"));

                        JSONArray json1 = new JSONArray(jsonarray.getJSONObject(i).getString("holesPriceBTTHoles"));
                        for (int k = 0; k < json1.length(); k++) {

                            addOnCaddie = json1.getJSONObject(k).getString("addOnCaddie");
                            addOnCart = json1.getJSONObject(k).getString("addOnCart");

                            String hole = json1.getJSONObject(k).getString("holes");
                            Log.i("Holes", hole);
                            String greenFee = json1.getJSONObject(k).getString("greenFee");
                            if (hole.contains("9")) {

                                ratecard1.setHole91rate(greenFee);
                                ratecard1.setCaddiehole9(addOnCaddie);
                                ratecard1.setCarthole9(addOnCart);
                                Caddiehole9 = addOnCaddie;
                                Carthole9 = addOnCart;
                            } else if (hole.contains("18")) {

                                ratecard1.setHole181rate(greenFee);
                                ratecard1.setCaddiehole18(addOnCaddie);
                                ratecard1.setCarthole18(addOnCart);
                                Caddiehole18 = addOnCaddie;
                                Carthole18 = addOnCart;
                            }

                            mType = json1.getJSONObject(k).getString("mType");
                        }
                        //greenfesscalcultion(mstId);
                        Log.i("Data ", "Caddiefee -" + addOnCaddie + "Cartfee-" + addOnCart + "Greenfee" + greenFee + "Membertype" + mType);

                    }

                }

                if (response == null || response.equals("")) {
                    return false;
                } else {

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

            if (result) {
                if (continuebookinghit == true) {
                    ringProgressDialog.dismiss();
                    // new RateCard1().execute();
                    Intent i = new Intent(getActivity(), Reviewbooking.class);
                    startActivity(i);

                } else {

                    //continuebookinghit=true;
                }
            } else {

            }
        }

    }


    private void ListingAlart() {

//        String day1 = (dataofnonmember.getDay1());
//        String day2 = (dataofnonmember.getDay2());

        int holeRate9one = parseInt((dataofnonmember.getHole9rateday1()));
        int holeRate18one = parseInt((dataofnonmember.getHole18rateday1()));

        int taxes9hole = parseInt(taxesandfess9hole);
        int taxes18hole = parseInt(taxesandfees18hole);

        int totalTaxes9hole = holeRate9one + taxes9hole;
        int totalTaxes18hole = holeRate18one + taxes18hole;

//        int holeRate9two = Integer.parseInt((dataofnonmember.getHole9rateday2()));
//        int holeRate18two = Integer.parseInt((dataofnonmember.getHole18rateday2()));
//
//        int taxes9holetwo = Integer.parseInt(taxesandfess9hole);
//        int taxes18holetwo = Integer.parseInt(taxesandfees18hole);

        int totalfee9two = 1500;
        int totalfe18two = 2200;

        String cart9hole = (dataofnonmember).getCart9hole();
        String cart18hole = (dataofnonmember).getCart18hole();
        String caddie9hole = (dataofnonmember).getCaddie9hole();
        String caddie18hole = (dataofnonmember).getCaddie18hole();

        String strOne = "<small>" + "Mon - Friday (Weekdays) 9 Holes - Rs. " + "</small>" + "<small>" + totalTaxes9hole + "</small>";
        String strTwo = "<small>" + "Mon - Friday (Weekdays) 18 Holes - Rs. " + "</small>" + "<small>" + totalTaxes18hole + "</small>";
        String strThree = "<small>" + "Sat - Sun (Weekends) 9 Holes - Rs. " + "</small>" + "<small>" + totalfee9two + "</small>";
        String strFour = "<small>" + "Sat - Sun (Weekends) 18 Holes - Rs. " + "</small>" + "<small>" + totalfe18two + "</small>";
        String strFive = "<small>" + "Cart Fees (9 Holes ) Rs. " + "</small>" + "<small>" + cart9hole + "</small>";
        String strSix = "<small>" + "Caddie Fees (9 Holes ) Rs. " + "</small>" + "<small>" + caddie9hole + "</small>";
        String strSeven = "<small>" + "Cart Fees (18 Holes ) Rs. " + "</small>" + "<small>" + cart18hole + "</small>";
        String strEight = "<small>" + "Caddie Fees (18 Holes ) Rs. " + "</small>" + "<small>" + caddie18hole + "</small>";
        String strNine = "<small>" + "Twilight Fees (Weekdays) Rs. " + "</small>" + "<small>" + "750" + "</small>";
        String strTen = "<small>" + "Twilight Fees (Weekends ) Rs. " + "</small>" + "<small>" + "1100" + "</small>";
        String strEleven = "<small>" + "          * All Taxes are included" + "</small>";

        CharSequence strFirst = Html.fromHtml(strOne);

        CharSequence strSecond = Html.fromHtml(strTwo);

        CharSequence strThird = Html.fromHtml(strThree);

        CharSequence strFourth = Html.fromHtml(strFour);

        CharSequence strFifth = Html.fromHtml(strFive);

        CharSequence strSixth = Html.fromHtml(strSix);

        CharSequence strSeventh = Html.fromHtml(strSeven);

        CharSequence strEigth = Html.fromHtml(strEight);
        CharSequence StrNine = Html.fromHtml(strNine);

        CharSequence StrTen = Html.fromHtml(strTen);
        CharSequence StrEleven = Html.fromHtml(strEleven);


        final CharSequence[] items = {strFirst, strSecond, strThird, strFourth, strFifth, strSixth, strSeventh, strEigth, StrNine, StrTen, StrEleven};
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Rate Card");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                builder.setCancelable(false);

            }

        });
        builder.show();
    }

    public class Customdialog extends Dialog implements android.view.View.OnClickListener {

        //member
        TextView dayID1;
        TextView holerate91;
        TextView holerate181;

        TextView dayID11;
        TextView holerate911;
        TextView holerate1811;

        //nonmember
//        TextView dayID2;
//        TextView holerate92;
//        TextView holerate182;
//
//
//        TextView dayID22;
//        TextView holerate922;
//        TextView holerate1822;


        public Activity c;

        final Dialog d = new Dialog(getContext());
        public Button OK;
        public Button Cancel;

        public Customdialog(Activity a) {
            super(a);
            this.c = a;

        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.customdialoglayout);
            //	d= new Dialog(getContext());
            dayID1 = (TextView) findViewById(R.id.dayID1);
            holerate91 = (TextView) findViewById(R.id.holerate91);
            holerate181 = (TextView) findViewById(R.id.holerate181);

            dayID11 = (TextView) findViewById(R.id.dayID11);
            holerate911 = (TextView) findViewById(R.id.holerate911);
            holerate1811 = (TextView) findViewById(R.id.holerate1811);

            dayID1.setText(dataofnonmember.getDay1());
            holerate91.setText(dataofnonmember.getHole9rateday1());
            holerate181.setText(dataofnonmember.getHole18rateday1());
            dayID11.setText(dataofnonmember.getDay2());
            holerate911.setText(dataofnonmember.getHole9rateday2());
            holerate1811.setText(dataofnonmember.getHole18rateday2());

	 		/*dayID2.setText(dataofnonmember.getDay1());
             holerate92.setText(dataofnonmember.getHole9rateday1());
	 	    holerate182.setText(dataofnonmember.getHole18rateday1());
	 	    dayID22.setText(dataofnonmember.getDay2());
	 	   holerate922.setText(dataofnonmember.getHole9rateday2());
	 	  holerate1822.setText(dataofnonmember.getHole18rateday2());*/

            OK = (Button) findViewById(R.id.ok);
            OK.setOnClickListener(this);
            Cancel = (Button) findViewById(R.id.cancel);

            Cancel.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.ok:
                    dismiss();
                    // c.finishActivity(1);
                    break;
                case R.id.cancel:
                    dismiss();

                    // c.finishActivity(1);
                    break;
            }

        }

    }

    private class RateCardofmember extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(getActivity(), null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                String mstId = "1";
                String date = formattedDate;
                String timeid = String.valueOf(TimeselectionFragment.sessiontype);
                String bindparameter = date + "/" + mstId + "/" + timeid;
                String response = WebService.GET(App_Common.WebServiceUrl + "getRateCard/" + bindparameter);
                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                JSONObject jsonobject = new JSONObject(response);
                JSONArray jsonarray = jsonobject.getJSONArray("holesPriceBTT");

                if (formattedDay.contains("Saturday") | formattedDay.contains("Sunday")) {
                    formatid = "2";
                    Log.d("Daydid", formatid);
                } else {
                    formatid = "1";
                    Log.d("Daydid", formatid);
                }
                for (int i = 0; i < jsonarray.length(); i++) {
                    String dayId = jsonarray.getJSONObject(i).getString("dayId");
                    confeeofmember = jsonarray.getJSONObject(i).getString("conFee");
                    confeeofmemberInt = parseInt(confeeofmember);
                    if (dayId.matches(formatid)) {
                        JSONArray json1 = new JSONArray(jsonarray.getJSONObject(i).getString("holesPriceBTTHoles"));
                        for (int k = 0; k < json1.length(); k++) {

                            holes = json1.getJSONObject(k).getString("holes");
                             texes = json1.getJSONObject(k).getString("taxesAndFees");
                            Log.i("Holes", holes);

                            if (holes.matches(Integer.toString(hole))) {
                                taxesofmember = json1.getJSONObject(k).getString("taxesAndFees");
                                taxesofmemberInt = parseInt(taxesofmember);

                                greeenfeeofmember = json1.getJSONObject(k).getString("greenFee");
                                greenfeemember = parseInt(greeenfeeofmember);

                            }

                        }
                    }

                }
                if (response == null || response.equals("")) {
                    return false;
                } else {

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
            if (result) {
                ringProgressDialog.dismiss();
                value1 = 0;
                value = 0;
                totaltaxesofmember = taxesofmemberInt;
//                confeeofmemberInt = confeeofmemberInt;
                int sum = value * parseInt(greeenfeeofmember);
                System.out.println("Memberfee" + Integer.toString(sum));
                totalgreenfeemember = totalgreenfeemember + sum;
            } else {

            }
        }

    }

    private class RateCardofNonmember extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(getActivity(), null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                String mstId = "2";
                String date = formattedDate;
                String timeid = String.valueOf(TimeselectionFragment.sessiontype);
                String bindparameter = date + "/" + mstId + "/" + timeid;
                String response = WebService.GET(App_Common.WebServiceUrl + "getRateCard/" + bindparameter);
                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);
                JSONObject jsonobject = new JSONObject(response);

                if (formattedDay.contains("Saturday") | formattedDay.contains("Sunday")) {
                    formatid = "2";
                    Log.d("Daydid", formatid);
                } else {
                    formatid = "1";
                    Log.d("Daydid", formatid);
                }

                JSONArray jsonarray = jsonobject.getJSONArray("holesPriceBTT");

                for (int i = 0; i < jsonarray.length(); i++) {
                    String dayId = jsonarray.getJSONObject(i).getString("dayId");
                    confeeofnonmember = jsonarray.getJSONObject(i).getString("conFee");
                    confeeofnonmemberInt = parseInt(confeeofnonmember);
                    if (dayId.matches(formatid)) {
                        JSONArray json1 = new JSONArray(jsonarray.getJSONObject(i).getString("holesPriceBTTHoles"));
                        for (int k = 0; k < json1.length(); k++) {
                            String holes = json1.getJSONObject(k).getString("holes");
                            Log.i("Holes", holes);
                            greenFee = json1.getJSONObject(k).getString("greenFee");
                            if (holes.matches(Integer.toString(hole))) {
                                taxesofnonmember = json1.getJSONObject(k).getString("taxesAndFees");
                                taxesofnonmemberInt = parseInt(taxesofnonmember);

                                greeenfeeofnonmember = json1.getJSONObject(k).getString("greenFee");
                                greenfeenonmemeber = parseInt(greeenfeeofnonmember);

                            }
                        }
                    }
                }
                if (response == null || response.equals("")) {
                    return false;
                } else {
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

            if (result) {
                ringProgressDialog.dismiss();
                value1 = 0;
                value = 0;
                totaltaxesofnonmember = taxesofnonmemberInt;
                int sum = value1 * parseInt(greeenfeeofnonmember);
                System.out.println("Non memeberfee" + Integer.toString(sum));
                totalgreenfeenonmember = totalgreenfeenonmember + sum;
            } else {

            }
        }

    }
//
//    private boolean checkmemebernonmemebr(int membernumber, int nonmembernumber) {
//
//
//        if (playerselected == membernumber + nonmembernumber) {
//
//            memberplayer = membernumber;
//            nonmemberplayer = nonmembernumber;
//            new RateCardofmember().execute();
//            new RateCardofNonmember().execute();
//            return true;
//        } else {
//
//            return false;
//        }
//
//    }

    private class RateCard6 extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(getActivity(), null, "Loading Rate Card...", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

//                JSONObject jsonObject = new JSONObject();

//                boolean member = App_Common.getInstance(getActivity()).getMember();

                String date = formattedDate;

                mstId = "2";

                String timeid = String.valueOf(TimeselectionFragment.sessiontype);

                String bindparameter = date + "/" + mstId + "/" + timeid;

                String response = WebService.GET(App_Common.WebServiceUrl + "getRateCard/" + bindparameter);

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                JSONObject jsonobject = new JSONObject(response);

                JSONArray jsonarray = jsonobject.getJSONArray("holesPriceBTT");

                for (int i = 0; i < jsonarray.length(); i++) {

                    String dayId = jsonarray.getJSONObject(i).getString("dayId");
                    if (dayId.contains("1")) {
                        dataofnonmember.setDay1(jsonarray.getJSONObject(i).getString("days"));

                        JSONArray json1 = new JSONArray(jsonarray.getJSONObject(i).getString("holesPriceBTTHoles"));
                        for (int k = 0; k < json1.length(); k++) {

                            addOnCaddie = json1.getJSONObject(k).getString("addOnCaddie");
                            addOnCart = json1.getJSONObject(k).getString("addOnCart");

                            String hole = json1.getJSONObject(k).getString("holes");
                            Log.i("Holes", hole);

                            String greenFee = json1.getJSONObject(k).getString("greenFee");
                            if (hole.contains("9")) {
                                taxesandfess9hole = json1.getJSONObject(k).getString("taxesAndFees");
                                dataofnonmember.setCart9hole(addOnCart);
                                dataofnonmember.setCaddie9hole(addOnCaddie);

                                Caddiehole9 = addOnCaddie;
                                Carthole9 = addOnCart;
                                // ratecard1.setHole9rate(greenFee);
                                dataofnonmember.setHole9rateday1(greenFee);

                                ratecard1.setCaddiehole9(addOnCaddie);
                                ratecard1.setCarthole9(addOnCart);
                            } else if (hole.contains("18")) {
                                dataofnonmember.setCart18hole(addOnCart);
                                dataofnonmember.setCaddie18hole(addOnCaddie);
                                // ratecard1.setHole18rate(greenFee);
                                taxesandfees18hole = json1.getJSONObject(k).getString("taxesAndFees");
                                //  ratecard1.setCaddiehole18(addOnCaddie);
                                //  ratecard1.setCarthole18(addOnCart);
                                dataofnonmember.setHole18rateday1(greenFee);

                                Caddiehole18 = addOnCaddie;
                                Caddiehole9 = addOnCart;
                            }

                            mType = json1.getJSONObject(k).getString("mType");
                        }
                        // greenfesscalcultion(mstId);
                        Log.i("Data ", "Caddiefee -" + addOnCaddie + "Cartfee-" + addOnCart + "Greenfee" + greenFee + "Membertype" + mType);
                    }

                    if (dayId.contains("2")) {
                        //ratecard1.setDay2(jsonarray.getJSONObject(i).getString("days"));
                        dataofnonmember.setDay2(jsonarray.getJSONObject(i).getString("days"));
                        JSONArray json1 = new JSONArray(jsonarray.getJSONObject(i).getString("holesPriceBTTHoles"));
                        for (int k = 0; k < json1.length(); k++) {

                            addOnCaddie = json1.getJSONObject(k).getString("addOnCaddie");
                            addOnCart = json1.getJSONObject(k).getString("addOnCart");

                            String hole = json1.getJSONObject(k).getString("holes");
                            Log.i("Holes", hole);
                            String greenFee = json1.getJSONObject(k).getString("greenFee");
                            if (hole.contains("9")) {
                                dataofnonmember.setCart9hole(addOnCart);
                                dataofnonmember.setCaddie9hole(addOnCaddie);
                                dataofnonmember.setHole9rateday2(greenFee);
                                //  ratecard1.setHole91rate(greenFee);
                                //  ratecard1.setCaddiehole9(addOnCaddie);
                                //  ratecard1.setCarthole9(addOnCart);
                                Caddiehole9 = addOnCaddie;
                                Carthole9 = addOnCart;
                            } else if (hole.contains("18")) {
                                dataofnonmember.setCart18hole(addOnCart);
                                dataofnonmember.setCaddie18hole(addOnCaddie);
                                dataofnonmember.setHole18rateday2(greenFee);
                                //   ratecard1.setHole181rate(greenFee);
                                //   ratecard1.setCaddiehole18(addOnCaddie);
                                //   ratecard1.setCarthole18(addOnCart);
                                Caddiehole18 = addOnCaddie;
                                Carthole18 = addOnCart;
                            }

                            mType = json1.getJSONObject(k).getString("mType");
                        }
                        //greenfesscalcultion(mstId);
                        Log.i("Data ", "Caddiefee -" + addOnCaddie + "Cartfee-" + addOnCart + "Greenfee" + greenFee + "Membertype" + mType);

                    }

                }

                if (response == null || response.equals("")) {
                    return false;
                } else {

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
                ListingAlart();

            } else {

            }

        }

    }

    public void permission() {
        if (ActivityCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(),
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,
                            android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Log.e("DB", "PERMISSION GRANTED");
        }
    }
}



