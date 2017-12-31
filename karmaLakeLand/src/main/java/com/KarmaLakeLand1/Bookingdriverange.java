package com.KarmaLakeLand1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import Helper.App_Common;
import Utility.WebService;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import static android.app.ProgressDialog.*;

public class Bookingdriverange extends Fragment implements OnClickListener, OnItemSelectedListener {

    ImageView dateimage;
//    ImageView timeimage;
//    Button noofplayers;
    String mstId;
    static boolean memeberupdate = false;
    Button continuebooking;
    static String formattedDate;
    static String formattedDay;
    static boolean dateselected = false;
    static boolean timeSelecteddrivergne = false;
    static int nonmemberplayer = 0;
    static int memberplayer = 0;
    static boolean BDRTime = false;
//    static final int DATE_PICKER_ID = 1111;
    Button player1;
    Button player2;
    Button player3;
    Button player4;
    boolean continuebookinghit = false;
    static int playerselected;
    static boolean BDRtime = false;
//    static boolean BDR = false;
    static boolean selectBalls = false;
    TextView bookingdrive;
    int key = 0;
    TextView popofballs;
    static TextView date;
    int value = 0;
    int value1 = 0;
    static String timeselected = null;
    static TextView time;
    ImageButton dropdown;
    LinearLayout lowerid;
    LinearLayout lowerid1;
    LinearLayout check0;
    LinearLayout check1;
    LinearLayout check2;
    LinearLayout check3;
    LinearLayout check4;
//    LinearLayout check5;
//    LinearLayout check6;
//    LinearLayout check7;
//    LinearLayout check8;
//    LinearLayout check9;
    static int bucketselected;
    LinearLayout sliding;
    LinearLayout topid;

    LinearLayout dateselectedlayout;
    LinearLayout timeselectedlayout;
//
//    static String taxesandfeesofmember;
//    static String taxesandfeesofnonmember;
    static int taxesandfeesofmemberInt;
    static int taxesandfeesofnonmemberInt;

    static String greeenfeeofmember;
    static String greeenfeeofnonmemberratecardWeekDays;
    static String greeenfeeofnonmemberratecardWeekEndDays;
    static String greeenfeeofnonmember;

    static int greeenfeeofmemberInt;
    static int greeenfeeofnonmemberInt;

    static String bucketofmember;
    static String bucketofnonmember;

    static String bucketofnonmemberweekdays;
    static String bucketofnonmemberweekenddays;

    static int totalbucketofmember;
    static int totalbucketofnonmember;

    static int totalmember;
    static int totalnonmember;

//    RelativeLayout popofballslayout;
    LinearLayout popofballslayout1;

//    int memberofplayer;
//    int nonmemberofplayer;
    static String taxesandfees;
    static String taxesandfeesweekdays;
    static String taxesandfeesweekend;
    static int totaltaxesandfees;

    ArrayList<String> Bucketfee = new ArrayList<String>();
//    ArrayList<String> Memberfee = new ArrayList<String>();
//    ArrayList<String> NonMemberfee = new ArrayList<String>();
    static boolean timed = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bookingdrivingrange, container, false);

        dateselectedlayout = (LinearLayout) view.findViewById(R.id.dateselectedlayout);
        popofballslayout1 = (LinearLayout) view.findViewById(R.id.popofballslayout1);

        dateselectedlayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (isNetworkConnected()) {
                    timed = false;
                    time.setText("Select Time");
                    DialogFragment newFragment = new DatePickerFragment();
                    newFragment.show(getFragmentManager(), "DatePicker");
                } else {
                    Toast.makeText(getActivity(), "Please check internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });


        timeselectedlayout = (LinearLayout) view.findViewById(R.id.timeselectedlayout);

        timeselectedlayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (isNetworkConnected()) {
                    if (dateselected == true) {
                        BDRtime = true;
                        timeSelecteddrivergne = true;
                        // BookElectionFrgament.bookelectiontime = false;
                        Intent firstpage = new Intent(getActivity(), TimeSelectionActivity.class);
                        firstpage.putExtra("bucketno", "Bookingdriverange");
                        startActivity(firstpage);
                    } else {
                        Toast.makeText(getActivity(), "Please select the date", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please check internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });


        topid = (LinearLayout) view.findViewById(R.id.topid);
        lowerid = (LinearLayout) view.findViewById(R.id.lowerid);
        lowerid1 = (LinearLayout) view.findViewById(R.id.lowerid1);
        playerselected = 0;
        bucketselected = 0;
        date = (TextView) view.findViewById(R.id.date);
        BookElectionFrgament.bookelectiontime = false;
        popofballs = (TextView) view.findViewById(R.id.popofballs);
        time = (TextView) view.findViewById(R.id.time);

        check0 = (LinearLayout) view.findViewById(R.id.check0);
        check0.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                bucketselected = 0;
                popofballs.setText("0");
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                selectBalls=false;
            }
        });
        check1 = (LinearLayout) view.findViewById(R.id.check1);
        check1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                selectBalls=true;
                bucketselected = 50;
                popofballs.setText("50");
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                lowerid1.setVisibility(View.VISIBLE);
            }
        });

        //popofballs.setText(selectedcheck);
        check2 = (LinearLayout) view.findViewById(R.id.check2);
        check2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                selectBalls=true;
                bucketselected = 100;
                popofballs.setText("100");
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                lowerid1.setVisibility(View.VISIBLE);
            }
        });

        check3 = (LinearLayout) view.findViewById(R.id.check3);
        check3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                selectBalls=true;
                popofballs.setText("150");
                bucketselected = 150;
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                lowerid1.setVisibility(View.VISIBLE);
            }
        });

        check4 = (LinearLayout) view.findViewById(R.id.check4);
        check4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                selectBalls=true;
                popofballs.setText("200");
                bucketselected = 200;
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                lowerid1.setVisibility(View.VISIBLE);
            }
        });

       /* check5 = (LinearLayout) view.findViewById(R.id.check5);
        check5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                popofballs.setText("5");
                bucketselected = 5;
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                lowerid1.setVisibility(View.VISIBLE);
                //check5.setChecked(false);
            }
        });

        check6 = (LinearLayout) view.findViewById(R.id.check6);
        check6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                popofballs.setText("6");
                bucketselected = 6;
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                lowerid1.setVisibility(View.VISIBLE);
                //check6.setChecked(false);
            }
        });

        check7 = (LinearLayout) view.findViewById(R.id.check7);
        check7.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                popofballs.setText("7");
                bucketselected = 7;
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                lowerid1.setVisibility(View.VISIBLE);
                //check7.setChecked(false);
            }
        });

        check8 = (LinearLayout) view.findViewById(R.id.check8);
        check8.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                popofballs.setText("8");
                bucketselected = 8;
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                lowerid1.setVisibility(View.VISIBLE);
                //check8.setChecked(false);
            }
        });

        check9 = (LinearLayout) view.findViewById(R.id.check9);
        check9.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                popofballs.setText("9");
                bucketselected = 9;
                sliding.setVisibility(View.GONE);
                topid.setVisibility(View.VISIBLE);
                lowerid.setVisibility(View.VISIBLE);
                lowerid1.setVisibility(View.VISIBLE);
                //check9.setChecked(false);
            }
        });*/

        player1 = (Button) view.findViewById(R.id.player1);
        player2 = (Button) view.findViewById(R.id.player2);
        player3 = (Button) view.findViewById(R.id.player3);
        player4 = (Button) view.findViewById(R.id.player4);
        dropdown = (ImageButton) view.findViewById(R.id.slidingdown);
        sliding = (LinearLayout) view.findViewById(R.id.sliding);
        BDRtime = false;
        dropdown.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (key == 0) {
                    key = 1;
                    topid.setVisibility(View.GONE);
                    sliding.setVisibility(View.VISIBLE);
                    lowerid.setVisibility(View.GONE);
                    lowerid1.setVisibility(View.GONE);
                } else if (key == 1) {
                    key = 0;
                    sliding.setVisibility(View.GONE);
                    topid.setVisibility(View.VISIBLE);
                    //  btn.setBackgroundResource(R.drawable.collapse);
                }
            }
        });

        popofballslayout1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (key == 0) {
                    key = 1;
                    topid.setVisibility(View.GONE);
                    sliding.setVisibility(View.VISIBLE);
                    lowerid.setVisibility(View.GONE);
                    lowerid1.setVisibility(View.GONE);
                } else if (key == 1) {
                    key = 0;
                    sliding.setVisibility(View.GONE);
                    topid.setVisibility(View.VISIBLE);
                    //  btn.setBackgroundResource(R.drawable.collapse);
                }
            }
        });

        dateimage = (ImageView) view.findViewById(R.id.dateselection);
        bookingdrive = (TextView) view.findViewById(R.id.ratecard);
        bookingdrive.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if ((dateselected == true)) {
                    if (timed == true) {
                        new RateCard1().execute();
                    } else {
                        Toast.makeText(getActivity(), "Please select the time", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please select date and time ", Toast.LENGTH_LONG).show();
                }
            }
        });

        player1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //App_Common.getInstance(getActivity()).setMemeberupdate(true);
                if (dateselected == true && timeSelecteddrivergne == true) {
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

        player2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //App_Common.getInstance(getActivity()).setMemeberupdate(false);
                if (dateselected == true && timeSelecteddrivergne == true) {
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
                } else {
                    Toast.makeText(getActivity(), "Please select date and time first", Toast.LENGTH_LONG).show();
                }
            }
        });

        player3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (dateselected == true && timeSelecteddrivergne == true) {
                    memeberupdate = false;
                    player3.setBackgroundColor(Color.parseColor("#3061e5"));
                    player3.setTextColor(Color.parseColor("#FFFFFF"));
                    player2.setBackgroundResource(R.drawable.buttonstyle);
                    player2.setTextColor(Color.parseColor("#000000"));
                    player1.setBackgroundResource(R.drawable.buttonstyle);
                    player1.setTextColor(Color.parseColor("#000000"));
                    player4.setBackgroundResource(R.drawable.buttonstyle);
                    player4.setTextColor(Color.parseColor("#000000"));
                    playerselected = 3;
                    Numberofplayerdialog cdd = new Numberofplayerdialog(getActivity());
                    cdd.show();
                } else {
                    Toast.makeText(getActivity(), "Please select date and time first", Toast.LENGTH_LONG).show();
                }
            }
        });

        player4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (dateselected == true && timeSelecteddrivergne == true) {
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
                } else {
                    Toast.makeText(getActivity(), "Please select date and time first", Toast.LENGTH_LONG).show();
                }
            }
        });

        continuebooking = (Button) view.findViewById(R.id.continuebooking);

        continuebooking.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (isNetworkConnected()) {
                    if ((dateselected == true)) {
                        if (timed == true) {
                            if (memeberupdate == false) {
                                if (playerselected == 1) {
                                    Numberofplayer1dialog cdd = new Numberofplayer1dialog(getActivity());
                                    cdd.show();
                                }
                            }
                            if (memeberupdate == true) {
                                if(selectBalls==true) {
                                    continuebookinghit = true;
                                    new RateCard().execute();
                                    BookElectionFrgament.bookelectiontime = false;
                                    BDRTime = true;
                                    BookElectionFrgament.BTTtime = false;
                                }else {
                                    Toast.makeText(getActivity(), "Please Select Balls", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(getActivity(), "Please update player details", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Please select  time", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "Please select date and time", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please check internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) (getActivity().getSystemService(Context.CONNECTIVITY_SERVICE));
        return cm.getActiveNetworkInfo() != null;
    }

    public static Bookingdriverange newInstance(String text) {

        Bookingdriverange f = new Bookingdriverange();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            //Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            Date today = new Date();
            c.setTime(today);
            //c.add( Calendar.MONTH, -6); // Subtract 6 months
            long minDate = c.getTime().getTime();
            final Calendar c1 = Calendar.getInstance();

            c1.setTime(today);
            c1.add(Calendar.DATE, 30);
            long maxdate = c1.getTime().getTime();

            //Create a new instance of DatePickerDialog and return it
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
            SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE");

            formattedDay = sdf1.format(c.getTime());
            System.out.println(formattedDay);
            date.setText(formattedDate);
            dateselected = true;
            //new RateCard().execute();
        }
    }

    private class Numberofplayerdialog extends Dialog implements android.view.View.OnClickListener {

        public EditText member;
        private EditText nonmember;
//        boolean cancelbooking = false;
        public Activity c;
        final Dialog d = new Dialog(getContext());
        public Button OK;
        private Button CANCEL;

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
            //d= new Dialog(getContext());

            OK = (Button) findViewById(R.id.ok);
            OK.setOnClickListener(this);
            CANCEL = (Button) findViewById(R.id.cancel);
            CANCEL.setOnClickListener(this);
            member = (EditText) findViewById(R.id.members);
            nonmember = (EditText) findViewById(R.id.nonmembers);
        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.ok:
                    try {
                        value = Integer.parseInt(member.getText().toString());
                    } catch (NumberFormatException e) {

                    }
                    try {
                        value1 = Integer.parseInt(nonmember.getText().toString());
                    } catch (NumberFormatException ee) {

                    }
                   /* if (member.getText().toString().length() == 0) {
                        memberofplayer = 0;
                    } else {
                        App_Common.getInstance(getActivity()).setMemeber(true);
                        memberofplayer = Integer.parseInt(member.getText().toString());
                    }
                    if (nonmember.getText().toString().length() == 0) {
                        nonmemberofplayer = 0;
                    } else {
                        App_Common.getInstance(getActivity()).setMemeber(false);
                        nonmemberofplayer = Integer.parseInt(nonmember.getText().toString());
                    }

                    boolean b = checkmemebernonmemebr(memberofplayer, nonmemberofplayer);
                    if (b == true) {
                        memeberupdate = true;
                        dismiss();
                    } else {
                        // Toast.makeText(getActivity(), "Invalid number of players", Toast.LENGTH_LONG).show();
                    }*/
                    if ((member.getText().toString().length() > 0) || (nonmember.getText().toString().length() > 0)) {
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
                        Toast.makeText(getActivity(), "Please enter the fields", Toast.LENGTH_SHORT).show();
                    }
                    // c.finishActivity(1);
                    break;
                case R.id.cancel:
                    dismiss();
                    player2.setBackgroundResource(R.drawable.buttonstyle);
                    player2.setTextColor(Color.parseColor("#000000"));
                    player1.setBackgroundResource(R.drawable.buttonstyle);
                    player1.setTextColor(Color.parseColor("#000000"));
                    player3.setBackgroundResource(R.drawable.buttonstyle);
                    player3.setTextColor(Color.parseColor("#000000"));
                    player4.setBackgroundResource(R.drawable.buttonstyle);
                    player4.setTextColor(Color.parseColor("#000000"));
                    // c.finishActivity(1);
                    break;
            }
        }
    }

    private class Numberofplayer1dialog extends Dialog implements android.view.View.OnClickListener {

//        boolean cancelbooking = false;

        public Activity c;
        final Dialog d = new Dialog(getContext());
        public Button OK;
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
            //d= new Dialog(getContext());

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
                    Toast.makeText(getActivity(), radioSexButton.getText(), Toast.LENGTH_SHORT).show();

                    if (radioSexButton.getText().toString().matches("Member")) {
                        memberplayer = 1;
                        nonmemberplayer = 0;
                        memeberupdate = true;
                        new RateCardofmember().execute();
                    } else if (radioSexButton.getText().toString().matches("Non Member")) {
                        nonmemberplayer = 1;
                        memberplayer = 0;
                        memeberupdate = true;
                        new RateCardofNonmember().execute();
                    }
                    //memeberupdate=true;
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

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    private class RateCard extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = show(getActivity(), null, "Processing ... ", true);
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
                  /*  if (playerselected == 1) {
                        memberplayer = 1;
                    }*/
                } else {
                    mstId = "2";
                   /* if (playerselected == 1) {
                        nonmemberplayer = 1;
                    }*/
                }

                Log.e("Monu", mstId);
                String timeid = String.valueOf(TimeselectionFragment.sessiontype);
                String bindparameter = date + "/" + mstId + "/" + timeid;
                String response = WebService.GET(App_Common.WebServiceUrl + "getRateCard/" + bindparameter);
                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);
                JSONObject jsonobject = new JSONObject(response);
                JSONArray jsonarray = jsonobject.getJSONArray("holesPriceBDR");
                for (int i = 0; i < jsonarray.length(); i++) {
                     String rangefee = jsonarray.getJSONObject(i).getString("rangeFee");
                     //bucketofmember = jsonarray.getJSONObject(i).getString("rangeFee");
                      Bucketfee.add(rangefee);
                    taxesandfees = jsonarray.getJSONObject(i).getString("taxesAndFees");
                    totaltaxesandfees = Integer.parseInt(taxesandfees);
                }
                greenfesscalcultion(mstId);
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
                if (continuebookinghit == true) {
                    Intent i = new Intent(getActivity(), Reviewbookingactivity.class);
                    startActivity(i);
                }
            } else {
            }
        }
    }

    private class RateCard1 extends AsyncTask<String, Void, Boolean> {
        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = show(getActivity(), null, "Fetching Rate Card... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
//                JSONObject jsonObject = new JSONObject();
//                boolean member = App_Common.getInstance(getActivity()).getMember();
                String date = formattedDate;
                /*if (member == true) {
                    mstId = "1";
                    memberplayer++;
                } else {*/
                mstId = "2";
                nonmemberplayer++;

                String timeid = String.valueOf(TimeselectionFragment.sessiontype);
                String bindparameter = date + "/" + mstId + "/" + timeid;
                String response = WebService.GET(App_Common.WebServiceUrl + "getRateCard/" + bindparameter);
                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);
                JSONObject jsonobject = new JSONObject(response);
                JSONArray jsonarray = jsonobject.getJSONArray("holesPriceBDR");

                for (int i = 0; i < jsonarray.length(); i++) {
                    String day = jsonarray.getJSONObject(i).getString("day");
                    //if (formattedDay.contains("Saturday") | formattedDay.contains("Sunday")) {
                    if (day.contains("Sat to Sun")) {
                        greeenfeeofnonmemberratecardWeekEndDays = jsonarray.getJSONObject(i).getString("rangeFee");
                        bucketofnonmemberweekenddays = jsonarray.getJSONObject(i).getString("bucketFeePerPlayer");
                        // totalbucketofnonmember = Integer.parseInt(bucketofnonmember);
                        taxesandfeesweekend = jsonarray.getJSONObject(i).getString("taxesAndFees");
                    } else {
                        if (day.matches("Mon to Fri")) {
                            greeenfeeofnonmemberratecardWeekDays = jsonarray.getJSONObject(i).getString("rangeFee");
                            bucketofnonmemberweekdays = jsonarray.getJSONObject(i).getString("bucketFeePerPlayer");
                            //   totalbucketofnonmember = Integer.parseInt(bucketofnonmember);
                            //   greeenfeeofnonmemberInt = Integer.parseInt(greeenfeeofnonmember);
                            taxesandfeesweekdays = jsonarray.getJSONObject(i).getString("taxesAndFees");
                        }

                   /* greeenfeeofnonmemberratecard = jsonarray.getJSONObject(i).getString("rangeFee");
                    bucketofnonmember = jsonarray.getJSONObject(i).getString("bucketFeePerPlayer");
                    Bucketfee.add(bucketofnonmember);
                    taxesandfees = jsonarray.getJSONObject(i).getString("taxesAndFees");*/
                    }
                }
                //greenfesscalcultion(mstId);
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
                ListingAlart();
              /*  Customdialog1 cdd = new Customdialog1(getActivity());
                cdd.show();*/
            } else {
            }
        }
    }

    public void ListingAlart() {

        /*String bucketWeekdays = (bucketofnonmemberweekdays);
        String bucketWeekend = (bucketofnonmemberweekenddays);*/
        int rangefeeweekdays = Integer.parseInt((greeenfeeofnonmemberratecardWeekDays));

        int taxesweekdays = Integer.parseInt((taxesandfeesweekdays));

        int totalRangeFee = rangefeeweekdays + taxesweekdays;


        /*String strOne = "<small>" + "Mon - Friday (Weekdays) Bucket-Fee. - " + "</small>" + "<small>" + bucketWeekdays + "</small>";
        String strTwo = "<small>" + "Sat - Sunday (WeekEnd) Bucket-Fee. - " + "</small>" + "<small>" + bucketWeekend + "</small>";
       */
        String strThree = "<small>" + "Driving Range Fee - Rs. " + "</small>" + "<small>" + totalRangeFee + "</small>";
        String strFive = "<small>" + "50 Balls - Rs. " + "</small>" + "<small>" + "150" + "</small>";
        String strsix = "<small>" + "100 Balls - Rs. " + "</small>" + "<small>" + "250" + "</small>";
        String strSeven = "<small>" + "150 Balls - Rs. " + "</small>" + "<small>" + "400" + "</small>";
        String strEight = "<small>" + "200 Balls - Rs. " + "</small>" + "<small>" + "500" + "</small>";
        String strNinth = "<small>" + "        * All Taxes are included " + "</small>";


      /*  CharSequence strFirst = Html.fromHtml(strOne);
        CharSequence strSecond = Html.fromHtml(strTwo);*/
        CharSequence strThrird = Html.fromHtml(strThree);
        CharSequence strFiveth = Html.fromHtml(strFive);
        CharSequence strSixth = Html.fromHtml(strsix);
        CharSequence strSeventh = Html.fromHtml(strSeven);
        CharSequence strEighth = Html.fromHtml(strEight);
        CharSequence strninth = Html.fromHtml(strNinth);

        final CharSequence[] items = {/*strFirst, strSecond,*/ strThrird, strFiveth, strSixth, strSeventh, strEighth, strninth};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Rate Card");
        builder.setCancelable(false);
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

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

//    public class Customdialog1 extends Dialog implements android.view.View.OnClickListener {
//
//        public Activity c;
//        final Dialog d = new Dialog(getContext());
//        public Button OK;
//        public Button Cancel;
//        private TextView bucketfee1;
//        private TextView bucketfee2;
//
//        public Customdialog1(Activity a) {
//            super(a);
//            // TODO Auto-generated constructor stub
//            this.c = a;
//        }
//
//        // TODO Auto-generated constructor stub
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            requestWindowFeature(Window.FEATURE_NO_TITLE);
//            setContentView(R.layout.numberofplayersdialog);
//            //d= new Dialog(getContext());
//
//            bucketfee1 = (TextView) findViewById(R.id.bucketfee1);
//            bucketfee2 = (TextView) findViewById(R.id.bucketfee2);
//            OK = (Button) findViewById(R.id.ok);
//            OK.setOnClickListener(this);
//            Cancel = (Button) findViewById(R.id.cancel);
//            Cancel.setOnClickListener(this);
//            bucketfee1.setText(Bucketfee.get(0).toString());
//            bucketfee2.setText(Bucketfee.get(1).toString());
//        }
//
//        @Override
//        public void onClick(View v) {
//            // TODO Auto-generated method stub
//            switch (v.getId()) {
//                case R.id.ok:
//                    dismiss();
//                    //c.finishActivity(1);
//                    break;
//                case R.id.cancel:
//                    dismiss();
//                    //c.finishActivity(1);
//                    break;
//            }
//        }
//    }

    private class RateCardofmember extends AsyncTask<String, Void, Boolean> {
        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = show(getActivity(), null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
//                JSONObject jsonObject = new JSONObject();
//                boolean member = App_Common.getInstance(getActivity()).getMember();
                String mstId = "1";
                String date = formattedDate;
                String timeid = String.valueOf(TimeselectionFragment.sessiontype);
                String bindparameter = date + "/" + mstId + "/" + timeid;
                String response = WebService.GET(App_Common.WebServiceUrl + "getRateCard/" + bindparameter);
                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);
                JSONObject jsonobject = new JSONObject(response);
                JSONArray jsonarray = jsonobject.getJSONArray("holesPriceBDR");

                for (int i = 0; i < jsonarray.length(); i++) {
                    String day = jsonarray.getJSONObject(i).getString("day");
                    //String rangefee	=jsonarray.getJSONObject(i).getString("rangeFee");
                    taxesandfees = jsonarray.getJSONObject(i).getString("taxesAndFees");
                    if (formattedDay.contains("Saturday") | formattedDay.contains("Sunday")) {
                        if (day.contains("Sat to Sun")) {
                            greeenfeeofmember = jsonarray.getJSONObject(i).getString("rangeFee");
                            bucketofmember = jsonarray.getJSONObject(i).getString("bucketFeePerPlayer");
                        }
                    } else {
                        if (day.matches("Mon to Fri")) {
                            greeenfeeofmember = jsonarray.getJSONObject(i).getString("rangeFee");
                            bucketofmember = jsonarray.getJSONObject(i).getString("bucketFeePerPlayer");
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
                try {
                    greeenfeeofmemberInt = Integer.parseInt(greeenfeeofmember);
                } catch (NumberFormatException ee) {

                }
                try {
                    taxesandfeesofmemberInt = Integer.parseInt(taxesandfees);
                } catch (NumberFormatException ee) {

                }
                try {
                    totalbucketofmember = Integer.parseInt(bucketofmember);
                } catch (NumberFormatException ee) {

                }
                value = 0;
                value1 = 0;
            } else {
            }
        }
    }

    private class RateCardofNonmember extends AsyncTask<String, Void, Boolean> {
        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = show(getActivity(), null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
//                JSONObject jsonObject = new JSONObject();
//                boolean member = App_Common.getInstance(getActivity()).getMember();
                String mstId = "2";
                String date = formattedDate;
                String timeid = String.valueOf(TimeselectionFragment.sessiontype);
                String bindparameter = date + "/" + mstId + "/" + timeid;
                String response = WebService.GET(App_Common.WebServiceUrl + "getRateCard/" + bindparameter);
                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);
                JSONObject jsonobject = new JSONObject(response);
                JSONArray jsonarray = jsonobject.getJSONArray("holesPriceBDR");

                for (int i = 0; i < jsonarray.length(); i++) {
                    String day = jsonarray.getJSONObject(i).getString("day");
                    //String rangefee	=jsonarray.getJSONObject(i).getString("rangeFee");
                    taxesandfees = jsonarray.getJSONObject(i).getString("taxesAndFees");
                    taxesandfeesofnonmemberInt = Integer.parseInt(taxesandfees);
                    if (formattedDay.contains("Saturday") | formattedDay.contains("Sunday")) {
                        if (day.contains("Sat to Sun")) {
                            greeenfeeofnonmember = jsonarray.getJSONObject(i).getString("rangeFee");
                            bucketofnonmember = jsonarray.getJSONObject(i).getString("bucketFeePerPlayer");
                            totalbucketofnonmember = Integer.parseInt(bucketofnonmember);
                        }
                    } else {
                        if (day.matches("Mon to Fri")) {
                            greeenfeeofnonmember = jsonarray.getJSONObject(i).getString("rangeFee");
                            bucketofnonmember = jsonarray.getJSONObject(i).getString("bucketFeePerPlayer");
                            totalbucketofnonmember = Integer.parseInt(bucketofnonmember);
                            greeenfeeofnonmemberInt = Integer.parseInt(greeenfeeofnonmember);

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
                try {
                    greeenfeeofnonmemberInt = Integer.parseInt(greeenfeeofnonmember);
                } catch (NumberFormatException ee) {

                }
                try {
                    totalbucketofnonmember = Integer.parseInt(bucketofnonmember);
                } catch (NumberFormatException ee) {

                }
                try {
                    taxesandfeesofnonmemberInt = Integer.parseInt(taxesandfees);
                } catch (NumberFormatException ee) {

                }
                value = 0;
                value1 = 0;
            } else {
            }
        }
    }

    public void greenfesscalcultion(String mstID) {
        if (mstID.contains("2")) {
            totalnonmember = 1;
            if (formattedDay.contains("Saturday") | formattedDay.contains("Sunday")) {
                greeenfeeofnonmember = Bucketfee.get(1).toString();
            } else {
                greeenfeeofnonmember = Bucketfee.get(0).toString();
            }
        } else if (mstID.contains("1")) {
            totalmember = 1;
            if (formattedDay.contains("Saturday") | formattedDay.contains("Sunday")) {
                greeenfeeofmember = Bucketfee.get(1).toString();
            } else {
                greeenfeeofnonmember = Bucketfee.get(0).toString();
            }
        }
    }
//
//    public boolean checkmemebernonmemebr(int membernumber, int nonmembernumber) {
//        if (playerselected == membernumber + nonmembernumber) {
//            memberplayer = membernumber;
//            nonmemberplayer = nonmembernumber;
//            new RateCardofmember().execute();
//            new RateCardofNonmember().execute();
//            return true;
//        } else {
//            return false;
//        }
//    }
}

