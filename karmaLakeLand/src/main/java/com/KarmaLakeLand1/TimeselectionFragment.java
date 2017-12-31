
package com.KarmaLakeLand1;

import android.text.format.Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONObject;

import Helper.App_Common;
import Utility.WebService;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class TimeselectionFragment extends Fragment {

    // DateTimeZone kolkataTimeZone = DateTimeZone.forID( "Asia/Kolkata" );

    DateFormat TimeFormatter = new SimpleDateFormat("HH:mm");

    DateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy");

    int i;
    static int sessiontype;
    //------------------first slot----
    TextView tvslothd;
    TextView tvslothd1;
    TextView tvslothd2;
    TextView times1;
    TextView times2;
    TextView times3;
    TextView times4;
    TextView times5;
    TextView times6;
    TextView times7;
    TextView times8;
    TextView times9;
    TextView times10;
    TextView times11;
    TextView times12;
    TextView times13;
    TextView times14;
    TextView times15;
    TextView times16;
    TextView times17;
    TextView times18;
    TextView times19;
    TextView times20;
    TextView times21;
    TextView times22;
    TextView times23;
    TextView times24;
    //-----------------second slot---------
    TextView times25;
    TextView times26;
    TextView times27;
    TextView times28;
    TextView times29;
    TextView times30;
    TextView times31;
    TextView times32;
    TextView times33;
    TextView times34;
    TextView times35;
    TextView times36;
    TextView times37;
    TextView times38;
    TextView times39;
    TextView times40;
    TextView times41;
    TextView times42;
    TextView times43;
    TextView times44;
    TextView times45;
    TextView times46;
    TextView times47;
    TextView times48;
    //-------------third slot-----
    TextView times49;
    TextView times50;
    TextView times51;
    TextView times52;
    TextView times53;
    TextView times54;
    TextView times55;
    TextView times56;
    TextView times57;
    TextView times58;
    TextView times59;
    TextView times60;
    TextView times61;
    TextView times62;
    TextView times63;
    TextView times64;
    TextView times65;
    TextView times66;
    TextView times67;
    TextView times68;
    TextView times69;
    TextView times70;
    TextView times71;
    TextView times72;
    static String session;
    static String timesessionid;
    static String timedate;

    ArrayList<String> Sessionname = new ArrayList<String>();
    List<String> Sessionid = new ArrayList<String>();
    HashMap<String, ArrayList<String>> sessiontimedetail = new HashMap<String, ArrayList<String>>();

    ArrayList<String> slotTIME = new ArrayList<String>();
    ArrayList<String> slotTIME1 = new ArrayList<String>();
    ArrayList<String> slotTIME2 = new ArrayList<String>();
    List<String> finalTIME = new ArrayList<String>();
    ArrayList<HashMap<String, String>> listFinal = new ArrayList<HashMap<String, String>>();

    ScrollView scrool1;
    String timeselected;
    LinearLayout lparent;
    List<EditText> lisEditTexts;
    List<TextView> TimeText1;
    List<TextView> TimeText2;
    List<TextView> TimeText3;

    TextView[] timetext1;
    TextView[] timetext2;
    TextView[] timetext3;
    DateFormat dateFormat;
    DateFormat timeformat;
    Date date;
    String currentTime;
    String timeslot;
    String newtime;
    String currentDate;
    String jsonDate;
    ArrayList<String> timeslots = new ArrayList<String>();
//--------------

    Date parseTime;
    Date parseTime1;

    Date parseDate;
    Date parseDate1;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.timeslot1, container, false);
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        currentDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
        //get current date time with Date()
        date = new Date();
        System.out.println(dateFormat.format(date));

        timeformat = new SimpleDateFormat("HH:mm:ss");
        timeconversion(timeformat.toString());
        System.out.println(timeformat.format(date));

        lparent = (LinearLayout) rootView.findViewById(R.id.parent);
        scrool1 = (ScrollView) rootView.findViewById(R.id.scrool1);
        tvslothd = (TextView) rootView.findViewById(R.id.timeslothd);


        //timetext3=new TextView[16];
        //--------------------first slot------------
        times1 = (TextView) rootView.findViewById(R.id.time1);
        times2 = (TextView) rootView.findViewById(R.id.time2);
        times3 = (TextView) rootView.findViewById(R.id.time3);
        times4 = (TextView) rootView.findViewById(R.id.time4);
        times5 = (TextView) rootView.findViewById(R.id.time5);
        times6 = (TextView) rootView.findViewById(R.id.time6);
        times7 = (TextView) rootView.findViewById(R.id.time7);
        times8 = (TextView) rootView.findViewById(R.id.time8);
        times9 = (TextView) rootView.findViewById(R.id.time9);
        times10 = (TextView) rootView.findViewById(R.id.time10);
        times11 = (TextView) rootView.findViewById(R.id.time11);
        times12 = (TextView) rootView.findViewById(R.id.time12);
        times13 = (TextView) rootView.findViewById(R.id.time13);
        times14 = (TextView) rootView.findViewById(R.id.time14);
        times15 = (TextView) rootView.findViewById(R.id.time15);
        times16 = (TextView) rootView.findViewById(R.id.time16);
        times17 = (TextView) rootView.findViewById(R.id.time17);
        times18 = (TextView) rootView.findViewById(R.id.time18);
        times19 = (TextView) rootView.findViewById(R.id.time19);
        times20 = (TextView) rootView.findViewById(R.id.time20);
        times21 = (TextView) rootView.findViewById(R.id.time21);
        times22 = (TextView) rootView.findViewById(R.id.time22);
        times23 = (TextView) rootView.findViewById(R.id.time23);
        times24 = (TextView) rootView.findViewById(R.id.time24);
        //-----------------second slot--------------
        times25 = (TextView) rootView.findViewById(R.id.time25);
        times26 = (TextView) rootView.findViewById(R.id.time26);
        times27 = (TextView) rootView.findViewById(R.id.time27);
        times28 = (TextView) rootView.findViewById(R.id.time28);
        times29 = (TextView) rootView.findViewById(R.id.time29);
        times30 = (TextView) rootView.findViewById(R.id.time30);
        times31 = (TextView) rootView.findViewById(R.id.time31);
        times32 = (TextView) rootView.findViewById(R.id.time32);
        times33 = (TextView) rootView.findViewById(R.id.time33);
        times34 = (TextView) rootView.findViewById(R.id.time34);
        times35 = (TextView) rootView.findViewById(R.id.time35);
        times36 = (TextView) rootView.findViewById(R.id.time36);
        times37 = (TextView) rootView.findViewById(R.id.time37);
        times38 = (TextView) rootView.findViewById(R.id.time38);
        times39 = (TextView) rootView.findViewById(R.id.time39);
        times40 = (TextView) rootView.findViewById(R.id.time40);
        times41 = (TextView) rootView.findViewById(R.id.time41);
        times42 = (TextView) rootView.findViewById(R.id.time42);
        times43 = (TextView) rootView.findViewById(R.id.time43);
        times44 = (TextView) rootView.findViewById(R.id.time44);
        times45 = (TextView) rootView.findViewById(R.id.time45);
        times46 = (TextView) rootView.findViewById(R.id.time46);
        times47 = (TextView) rootView.findViewById(R.id.time47);
        times48 = (TextView) rootView.findViewById(R.id.time48);

        //------------------third slot-------------------

        times49 = (TextView) rootView.findViewById(R.id.time49);
        times50 = (TextView) rootView.findViewById(R.id.time50);
        times51 = (TextView) rootView.findViewById(R.id.time51);
        times52 = (TextView) rootView.findViewById(R.id.time52);
        times53 = (TextView) rootView.findViewById(R.id.time53);
        times54 = (TextView) rootView.findViewById(R.id.time54);
        times55 = (TextView) rootView.findViewById(R.id.time55);
        times56 = (TextView) rootView.findViewById(R.id.time56);
        times57 = (TextView) rootView.findViewById(R.id.time57);
        times58 = (TextView) rootView.findViewById(R.id.time58);
        times59 = (TextView) rootView.findViewById(R.id.time59);
        times60 = (TextView) rootView.findViewById(R.id.time60);
        times61 = (TextView) rootView.findViewById(R.id.time61);
        times62 = (TextView) rootView.findViewById(R.id.time62);
        times63 = (TextView) rootView.findViewById(R.id.time63);
        times64 = (TextView) rootView.findViewById(R.id.time64);
        times65 = (TextView) rootView.findViewById(R.id.time65);
        times66 = (TextView) rootView.findViewById(R.id.time66);
        times67 = (TextView) rootView.findViewById(R.id.time67);
        times68 = (TextView) rootView.findViewById(R.id.time68);
        times69 = (TextView) rootView.findViewById(R.id.time69);
        times70 = (TextView) rootView.findViewById(R.id.time70);
        times71 = (TextView) rootView.findViewById(R.id.time71);
        times72 = (TextView) rootView.findViewById(R.id.time72);

        lisEditTexts = new ArrayList<EditText>();

        //-------------------first time slot-----------------

        TimeText1 = new ArrayList<TextView>();
        timetext1 = new TextView[]{times1, times2, times3, times4, times5, times6, times7, times8, times9, times10, times11, times12, times13, times14, times15, times16, times17, times18, times19, times20, times21, times22, times23, times24};
        TimeText1.add(times1);
        TimeText1.add(times2);
        TimeText1.add(times3);
        TimeText1.add(times4);
        TimeText1.add(times5);
        TimeText1.add(times6);
        TimeText1.add(times7);
        TimeText1.add(times8);
        TimeText1.add(times9);
        TimeText1.add(times10);
        TimeText1.add(times11);
        TimeText1.add(times12);
        TimeText1.add(times13);
        TimeText1.add(times14);
        TimeText1.add(times15);
        TimeText1.add(times16);
        TimeText1.add(times17);
        TimeText1.add(times18);
        TimeText1.add(times19);
        TimeText1.add(times20);
        TimeText1.add(times21);
        TimeText1.add(times22);
        TimeText1.add(times23);
        TimeText1.add(times24);
        //-----------------------second time slot ----------------
        TimeText2 = new ArrayList<TextView>();
        timetext2 = new TextView[]{times25, times26, times27, times28, times29, times30, times31, times32, times33, times34, times35, times36, times37, times38, times39, times40, times41, times42, times43, times44, times45, times46, times47, times48};
        TimeText2.add(times25);
        TimeText2.add(times26);
        TimeText2.add(times27);
        TimeText2.add(times28);
        TimeText2.add(times29);
        TimeText2.add(times30);
        TimeText2.add(times31);
        TimeText2.add(times32);
        TimeText2.add(times33);
        TimeText2.add(times34);
        TimeText2.add(times35);
        TimeText2.add(times36);
        TimeText2.add(times37);
        TimeText2.add(times38);
        TimeText2.add(times39);
        TimeText2.add(times40);
        TimeText2.add(times41);
        TimeText2.add(times42);
        TimeText2.add(times43);
        TimeText2.add(times44);
        TimeText2.add(times45);
        TimeText2.add(times46);
        TimeText2.add(times47);
        TimeText2.add(times48);
        //----------------------------third time slot--------------------

        TimeText3 = new ArrayList<TextView>();
        timetext3 = new TextView[]{times49, times50, times51, times52, times53, times54, times55, times56, times57, times58, times59, times60, times61, times62, times63, times64, times65, times66, times67, times68, times69, times70, times71, times72};
        TimeText3.add(times49);
        TimeText3.add(times50);
        TimeText3.add(times51);
        TimeText3.add(times52);
        TimeText3.add(times53);
        TimeText3.add(times54);
        TimeText3.add(times55);
        TimeText3.add(times56);
        TimeText3.add(times57);
        TimeText3.add(times58);
        TimeText3.add(times59);
        TimeText3.add(times60);
        TimeText3.add(times61);
        TimeText3.add(times62);
        TimeText3.add(times63);
        TimeText3.add(times64);
        TimeText3.add(times65);
        TimeText3.add(times66);
        TimeText3.add(times67);
        TimeText3.add(times68);
        TimeText3.add(times69);
        TimeText3.add(times70);
        TimeText3.add(times71);
        TimeText3.add(times72);
        //   TimeText3.add(times48);
        try {
            Time time = new Time(Time.getCurrentTimezone());
            time.setToNow();
            currentTime = (time.hour + ":" + time.minute);

            DateFormat formatter = new SimpleDateFormat("HH:mm");
            formatter.setTimeZone(TimeZone.getTimeZone("IST"));
            parseTime = (Date) formatter.parse(currentTime);
            // parseCurrentTime = java.sql.Time.valueOf((currentTime));
            //jsonDate = String.valueOf( );
            System.out.println("time: " + time.hour + ":" + time.minute);

        } catch (NumberFormatException ee) {

        } catch (ParseException e) {
            e.printStackTrace();
        }

        times1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sessiontype = 1;

                timeselected = (times1.getText().toString());
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {

                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }

                    times1.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times2.getText().toString());


                sessiontype = 1;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times2.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times3.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {
                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times3.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times4.getText().toString());
                sessiontype = 1;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {

                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times4.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times5.getText().toString());
                sessiontype = 1;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times5.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times6.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {
                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times6.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times7.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times7.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {
                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times7.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times8.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times8.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times8.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times9.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times9.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times9.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times10.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times10.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times10.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times11.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times11.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times11.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times12.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times12.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {
                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times12.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times13.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times13.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times13.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times14.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times14.getText().toString());
                sessiontype = 1;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {
                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times14.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times15.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times15.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {
                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times15.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times16.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                timeselected = (times16.getText().toString());
                sessiontype = 1;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times16.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times17.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times17.getText().toString());
                sessiontype = 1;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {

                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }

                    times17.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times18.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times18.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times18.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times19.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times19.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times19.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();

                }
            }
        });
        times20.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times20.getText().toString());
                sessiontype = 1;


                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times20.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times21.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times21.getText().toString());
                sessiontype = 1;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times21.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times22.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times22.getText().toString());
                sessiontype = 1;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times22.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times23.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times23.getText().toString());
                sessiontype = 1;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times23.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times24.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times24.getText().toString());
                sessiontype = 1;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times24.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times25.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times25.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {

                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times25.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times26.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times26.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times26.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times27.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times27.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times27.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times28.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times28.getText().toString());
                sessiontype = 2;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times28.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times29.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times29.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times29.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times30.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times30.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times30.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times31.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times31.getText().toString());
                sessiontype = 2;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times31.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times32.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times32.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times32.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times33.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sessiontype = 2;
                timeselected = (times33.getText().toString());

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times33.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times34.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times34.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {

                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times34.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times35.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times35.getText().toString());
                sessiontype = 2;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times35.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times36.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times36.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times36.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times37.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times37.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times37.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times38.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times38.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {

                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times38.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times39.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times39.getText().toString());
                sessiontype = 2;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times39.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times40.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times40.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times40.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times41.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times41.getText().toString());
                sessiontype = 2;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {
                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times41.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times42.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times42.getText().toString());
                ;
                sessiontype = 2;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times42.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times43.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times43.getText().toString());
                ;
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times43.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times44.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times44.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times44.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times45.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times45.getText().toString());
                sessiontype = 2;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times45.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times46.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times46.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times46.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times47.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times47.getText().toString());
                sessiontype = 2;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times47.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times48.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times48.getText().toString());
                sessiontype = 2;

                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {

                    if (BookElectionFrgament.bookelectiontime == true) {
                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times48.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times49.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times49.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times49.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times50.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times50.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times50.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times51.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times51.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times51.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times52.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times52.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times52.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times53.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times53.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times53.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times54.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times54.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times54.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times55.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times55.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times55.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times56.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times56.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times56.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times57.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times57.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times57.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times58.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times58.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times58.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times59.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times59.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times59.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times60.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times60.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times60.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });


        times61.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times61.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times61.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times62.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times62.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times62.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times63.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times63.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times63.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times64.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times64.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times64.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times65.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times65.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times65.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times66.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times66.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times66.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times67.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times67.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times67.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times68.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times68.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times68.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times69.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times69.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times69.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times70.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times70.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times70.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times71.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times71.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times71.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });
        times72.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timeselected = (times72.getText().toString());
                sessiontype = 3;
                if (timeselected.isEmpty()) {
                    times1.setClickable(false);
                } else {


                    if (BookElectionFrgament.bookelectiontime == true) {

                        BookElectionFrgament.timeselectedtime = true;
                        BookElectionFrgament.timeselected = timeselected;
                        BookElectionFrgament.timetv.setText(timeconversion1(timeselected));
                    }
                    if (Bookingdriverange.BDRtime == true) {

                        Bookingdriverange.timed = true;
                        Bookingdriverange.timeselected = timeselected;
                        Bookingdriverange.time.setText(timeconversion1(timeselected));
                    }
                    times72.setBackgroundResource(R.drawable.active_icon);
                    getActivity().finish();
                }
            }
        });


        tvslothd1 = (TextView) rootView.findViewById(R.id.timeslothd1);
        tvslothd2 = (TextView) rootView.findViewById(R.id.timeslothd2);
        new AppLogin().execute();
        new Sessiontype().execute();
        new Sessiontypeavailablity().execute();


        return rootView;
    }

    public static TimeselectionFragment newInstance(String text) {

        TimeselectionFragment f = new TimeselectionFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    public class AppLogin extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(getActivity(), null, "Retrieving the available time slots for you", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();

                String response = WebService.GET((App_Common.WebServiceUrl + "getSession"));

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);
                if (response == null || response.equals("")) {
                    return false;
                } else {


                    try {
                        JSONArray jsonresponse = new JSONArray(response);

                        for (int i = 0; i < jsonresponse.length(); i++)

                        {
                            JSONObject jsonobject = jsonresponse.getJSONObject(i);
                            String BookingSlotId = jsonobject.getString("sessionId");
                            String BookingSlot = jsonobject.getString("sessionName");

                            Sessionid.add(BookingSlotId);
                            Sessionname.add(BookingSlot);

                        }
                    } catch (Exception e) {
                        // TODO: handle exception
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
                for (int j = 0; j < Sessionname.size(); j++) {
                    tvslothd.setText(Sessionname.get(0));
                    tvslothd1.setText(Sessionname.get(1));
                    tvslothd2.setText(Sessionname.get(2));
                }
            } else {

            }
        }
    }

    public class Sessiontype extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;
        String response;

        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(getActivity(), null, "Retrieving the available time slots for you", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();


                if (BookElectionFrgament.bookelectiontime == true) {
                    session = "BDR";

                }
                if (Bookingdriverange.BDRtime == true) {
                    session = "BDR";

                }
                for (i = 0; i < Sessionid.size(); i++) {

                    if (BookElectionFrgament.bookelectiontime == true) {
                        newtime = BookElectionFrgament.formattedDate;

                    }

                    if (Bookingdriverange.BDRtime == true) {
                        newtime = Bookingdriverange.formattedDate;

                    }


                    String value = String.valueOf(Sessionid.get(i));
                    response = WebService.GET((App_Common.WebServiceUrl + "getSessionTimeById" + "/" + value + "/" + session + "/" + newtime));

                    JSONArray jsonresponse = new JSONArray(response);

                    for (int j = 0; j < jsonresponse.length(); j++)

                    {
                        JSONObject jsonobject = jsonresponse.getJSONObject(j);
                        String SessionTimeID = jsonobject.getString("sessiontimeId");
                        String SessiontimeName = jsonobject.getString("sessiontimeName");

                        if (i == 0) {
                            slotTIME.add(SessiontimeName);
                        }
                        if (i == 1) {
                            slotTIME1.add(SessiontimeName);
                        }
                        if (i == 2) {
                            slotTIME2.add(SessiontimeName);
                        }

                        Log.e("Sesiontimename", SessiontimeName);
                    }


                    sessiontimedetail.put(Sessionname.get(i), slotTIME);
                    Log.e("HaHAHAHAHAH", sessiontimedetail.toString());


                    for (Map.Entry<String, ArrayList<String>> entry : sessiontimedetail.entrySet()) {
                        String key = entry.getKey();
                        ArrayList<String> valuee = entry.getValue();
                        for (int l = 1; l < valuee.size(); l++) {
                            System.out.println("Key = " + key);

                            System.out.println(valuee.get(l) + "\n");
                        }

                    }


                    Log.i(App_Common.TAG, response);
                    Log.e("RESPONSE", response);

                    if (response == null || response.equals("")) {
                        return false;
                    }


                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {
                TimeFormatter.setTimeZone(TimeZone.getTimeZone("IST"));
                //-------------slot 1----------------
                if (slotTIME.size() > timetext1.length) {
                    for (int p = 0; p < slotTIME.size(); p++) {
                        timetext1[p].setText((slotTIME.get(p)));
                    }

                } else {

                    for (int p = 0; p < slotTIME.size(); p++) {
                        try {
                            parseTime1 = (Date) TimeFormatter.parse(slotTIME.get(p));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (currentDate.equals(timedate)) {
                            if (parseTime1.after(parseTime)) {
                                timetext1[p].setText((slotTIME.get(p)));
                            } else {
                                try {
                                    timetext1[p].setTextColor(getResources().getColor(R.color.default_color));
                                    timetext1[p].setText((slotTIME.get(p)));
                                    timetext1[p].setClickable(false);
                                    timetext1[p].setBackgroundResource(R.drawable.not_avilabele_icon);
                                } catch (IndexOutOfBoundsException ee) {

                                }
                            }

                        } else {
                            timetext1[p].setText((slotTIME.get(p)));
                        }

                    }
                }
                //-------------------------------slot 2---------------
                if (slotTIME1.size() > timetext2.length) {
                    for (int p = 0; p < slotTIME1.size(); p++) {

                        timetext2[p].setText((slotTIME1.get(p)));
                    }

                } else {

                    for (int p = 0; p < slotTIME1.size(); p++) {
                        try {
                            parseTime1 = (Date) TimeFormatter.parse(slotTIME1.get(p));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (currentDate.equals(timedate)) {
                            if (parseTime1.after(parseTime)) {
                                timetext2[p].setText((slotTIME1.get(p)));
                            } else {
                                try {
                                    timetext2[p].setTextColor(getResources().getColor(R.color.default_color));
                                    timetext2[p].setText((slotTIME1.get(p)));
                                    timetext2[p].setClickable(false);
                                    timetext2[p].setBackgroundResource(R.drawable.not_avilabele_icon);
                                } catch (IndexOutOfBoundsException ee) {

                                }
                            }
                        } else {
                            timetext2[p].setText((slotTIME1.get(p)));
                        }

                    }
                }


                //-----------------------------------slot 3-------------------
                if (slotTIME2.size() > timetext3.length) {
                    for (int p = 0; p < slotTIME2.size(); p++) {

                        timetext3[p].setText((slotTIME2.get(p)));
                    }

                } else {

                    for (int p = 0; p < slotTIME2.size(); p++) {
                        try {
                            parseTime1 = (Date) TimeFormatter.parse(slotTIME2.get(p));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (currentDate.equals(timedate)) {
                            if (parseTime1.after(parseTime)) {
                                timetext3[p].setText((slotTIME2.get(p)));
                            } else {
                                try {
                                    timetext3[p].setText((slotTIME2.get(p)));
                                    timetext3[p].setClickable(false);
                                    timetext3[p].setTextColor(getResources().getColor(R.color.default_color));
                                    timetext3[p].setBackgroundResource(R.drawable.not_avilabele_icon);
                                } catch (IndexOutOfBoundsException ee) {

                                }
                            }
                        } else {
                            timetext3[p].setText((slotTIME2.get(p)));
                        }

                    }
                }

            } else if (timetext1.equals("") && timetext2.equals("") && timetext3.equals("")) {
                Toast.makeText(getContext(), "Sorry! No Slot Available for the Day. Choose another date for ", Toast.LENGTH_LONG).show();
            }


        }
    }

    public class Sessiontypeavailablity extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(getActivity(), null, "Retrieving the available time slots for you", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();


                if (BookElectionFrgament.bookelectiontime == true) {
                    timedate = BookElectionFrgament.formattedDate;
                    timesessionid = "1";
                }

                if (Bookingdriverange.BDRtime == true) {
                    timedate = Bookingdriverange.formattedDate;
                    timesessionid = "2";
                }

                //	String sessionId="1";


                String response = WebService.GET((App_Common.WebServiceUrl + "getSessionTimeAvailability" + "/" + timedate + "/" + timesessionid));

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONArray jsonresponse = new JSONArray(response);
                    for (int i = 0; i < jsonresponse.length(); i++)

                    {
                        JSONObject jsonobject = (JSONObject) jsonresponse.get(i);
                        String availaibility = jsonobject.getString("availability");
                        timeslot = jsonobject.getString("timeslot");

                        if (availaibility.contains("Not avaible!")) {
                            timeslots.add(timeslot);
                        }
                        Log.i("Available", availaibility);
                        Log.i("Timselsot", timeslot);

                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }

            return true;


        }

        @Override
        protected void onPostExecute(Boolean result) {
            ringProgressDialog.dismiss();
            if (result) {

                for (int i = 0; i < timeslots.size(); i++) {
                    String timeslot = (timeslots.get(i));
                    //int timebooked= Integer.parseInt(timeslot);
                    String timeslot1 = (timeslot);
                    for (int j = 0; j < timetext1.length; j++) {


                        if (timeslot1.matches(timetext1[j].getText().toString())) {
                            timetext1[j].setBackgroundResource(R.drawable.not_avilabele_icon);
                            timetext1[j].setClickable(false);
                        }


                    }
                    for (int j = 0; j < timetext2.length; j++) {
                        if (timeslot1.matches(timetext2[j].getText().toString())) {
                            timetext2[j].setBackgroundResource(R.drawable.not_avilabele_icon);
                            timetext2[j].setClickable(false);
                        }


                    }
                    for (int j = 0; j < timetext3.length; j++) {
                        if (timeslot1.matches(timetext3[j].getText().toString())) {
                            timetext3[j].setBackgroundResource(R.drawable.not_avilabele_icon);
                            timetext3[j].setClickable(false);
                        }
                    }

                }

            } else {
                Toast.makeText(getContext(), "Please check your internet connection", Toast.LENGTH_LONG).show();
            }
        }
    }

    public class Getallbookingdetails extends AsyncTask<String, Void, Boolean> {

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

                JSONObject jsonObject = new JSONObject();


                String sessionId = "1";


                String response = WebService.GET((App_Common.WebServiceUrl + "getAllBookingDetailByUserId"));

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONArray jsonresponse = new JSONArray(response);
                    for (int i = 0; i < jsonresponse.length(); i++)

                    {
                        JSONObject jsonobject = (JSONObject) jsonresponse.get(i);
                        String availaibility = jsonobject.getString("availability");
                        String timeslot = jsonobject.getString("timeslot");
                        Log.i("Available", availaibility);
                        Log.i("Timselsot", timeslot);

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


            } else {

            }
        }
    }

    public String timeconversion(String input) {

        //Date/time pattern of input date
        DateFormat df = new SimpleDateFormat("HH:mm");
        //Date/time pattern of desired output date
        DateFormat outputformat = new SimpleDateFormat("hh:mm");
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

    public String timeconversion1(String input) {

        //Date/time pattern of input date
        DateFormat df = new SimpleDateFormat("HH:mm");
        //Date/time pattern of desired output date
        DateFormat outputformat = new SimpleDateFormat("hh:mm");
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
}
