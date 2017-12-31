package com.KarmaLakeLand1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Reviewbooking extends FragmentActivity {
    Button continuebooking;
    TextView date;
    TextView time;
    TextView players;
    TextView holes;
    TextView greenfee;
    TextView greenfeenonmember;
    TextView playersnumber;
    TextView totalgreenfee;
    TextView taxesfees;
    TextView total;
    static int totalTexAndConfeeofmembers;
    static int totalTexAndConfeeofnonmembers;
    static int totalgreenfeecalculted = 0;
    static int totalcalculated;
    static int totalcalculatedint;
    //    static int totalbucketcalculated;
    ImageButton tv_header_title;
    LinearLayout bucketlayout;
    TextView bucketselected;
    //    int bucketselectedIN;
    ImageView flag;
    TextView buckets;
    //    LinearLayout couponcodelayout;
//    EditText couponcode;
//    List<EditText> lisEditTexts;
    Intent intent = getIntent();
    int sumHoleM9 = 0;
    int sumHoleN9 = 0;
    int sumHoleM18 = 0;
    int sumHoleN18 = 0;
    static int totaltaccalculation = 0;
    Date timecurrentDate;
    Date timejson;
    TextView tvTwilight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewbooking3);


        flag = (ImageView) findViewById(R.id.flag);
        buckets = (TextView) findViewById(R.id.buckets);
        greenfeenonmember = (TextView) findViewById(R.id.greenfeenonmember);
        bucketlayout = (LinearLayout) findViewById(R.id.bucketlayout);
        bucketselected = (TextView) findViewById(R.id.bucketselected);
        tv_header_title = (ImageButton) findViewById(R.id.favriot);
        tvTwilight = (TextView) findViewById(R.id.tv_twilight);

        tv_header_title.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //BookElectionFrgament.memeberupdate = false;
                //  BookElectionFrgament.dateselected = false;
                //   BookElectionFrgament.timeselectedtime = false;
                //   BookElectionFrgament.timetv.setText("Select Time");
                //   BookElectionFrgament.date.setText("Select Date");

                //   BookElectionFrgament.greenfeenonmemeber = 0;
                //   BookElectionFrgament.greenfeemember = 0;
                //     BookElectionFrgament.memberplayer = 0;
                //    BookElectionFrgament.nonmemberplayer = 0;
                BookElectionFrgament.memeberupdate = false;
                greenfeenonmember.setText("");
                greenfee.setText("");
                totalgreenfee.setText("");
                totalgreenfee.setText("");
                taxesfees.setText("");
                total.setText("");
                holes.setText("");
                players.setText("");
                playersnumber.setText("");
                totaltaccalculation = 0;
                sumHoleN9 = 0;
                sumHoleN18 = 0;
                sumHoleM9 = 0;
                sumHoleM18 = 0;
                totalTexAndConfeeofnonmembers = 0;
                totalgreenfeecalculted = 0;


                finish();
            }
        });
        continuebooking = (Button) findViewById(R.id.continuebooking);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        players = (TextView) findViewById(R.id.players);
        holes = (TextView) findViewById(R.id.holes);
        greenfee = (TextView) findViewById(R.id.greenfee);
        playersnumber = (TextView) findViewById(R.id.playersnumber);
        totalgreenfee = (TextView) findViewById(R.id.totalgreenfee);
        taxesfees = (TextView) findViewById(R.id.taxesfees);
        total = (TextView) findViewById(R.id.total);

        flag.setBackgroundResource(R.drawable.flag);

        date.setText(BookElectionFrgament.formattedDate);
        time.setText(timeconversion1(BookElectionFrgament.timeselected));
        players.setText(String.valueOf(BookElectionFrgament.playerselected));
        holes.setText(String.valueOf(BookElectionFrgament.hole) + " hole");

        if (BookElectionFrgament.hole == 18) {

            Log.i("memberplauer", Integer.toString(BookElectionFrgament.greenfeemember));
            Log.i("memberplauer", Integer.toString(BookElectionFrgament.memberplayer));
            Log.i("nonmemberplauer", Integer.toString(BookElectionFrgament.nonmemberplayer));
            Log.i("Greenfeememeber", Integer.toString(BookElectionFrgament.greenfeemember));

            Log.i("Greenfeenonmemeber", Integer.toString(BookElectionFrgament.greenfeenonmemeber));
            //	Log.i("memberplauer", Integer.toString(BookElectionFrgament.greenfeemember));
            if (BookElectionFrgament.memberplayer != 0) {
                //greenfee.setText("Rs ."+Integer.toString((BookElectionFrgament.greenfeemember)*(BookElectionFrgament.memberplayer)));
                String str = Integer.toString((BookElectionFrgament.greenfeemember) * (BookElectionFrgament.memberplayer));
                greenfee.setText(Integer.toString((BookElectionFrgament.greenfeemember)) + "*" + (BookElectionFrgament.memberplayer) + "= Rs ." + str);
                sumHoleM18 = ((BookElectionFrgament.greenfeemember) * (BookElectionFrgament.memberplayer));
                totalTexAndConfeeofmembers = (BookElectionFrgament.totaltaxesofmember) * (BookElectionFrgament.memberplayer);
            }
            playersnumber.setText(String.valueOf(BookElectionFrgament.playerselected));
            if (BookElectionFrgament.nonmemberplayer != 0) {
                String time = BookElectionFrgament.timeselected;
                SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
                try {
                    timejson = format.parse(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String time2 = "14:50 PM";
                SimpleDateFormat format1 = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
                try {
                    timecurrentDate = format1.parse(time2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (timejson.after(timecurrentDate)) {
                    if (BookElectionFrgament.formatid == "1") {
                        String stringBal = Integer.toString((BookElectionFrgament.greenfeenonmemeber) * (BookElectionFrgament.nonmemberplayer));
                        int bal = Integer.parseInt(stringBal);
                        String stri = Integer.toString((652) * (BookElectionFrgament.nonmemberplayer));
                        greenfeenonmember.setText(Integer.toString((652)) + "*" + (BookElectionFrgament.nonmemberplayer) + "= Rs ." + stri);
                        sumHoleN18 = ((652) * (BookElectionFrgament.nonmemberplayer));
                        totalTexAndConfeeofnonmembers = (98) * (BookElectionFrgament.nonmemberplayer);
                        tvTwilight.setText("Rs. - " + (bal - (652 * BookElectionFrgament.nonmemberplayer)));
                    } else {
                        String stringBal = Integer.toString((BookElectionFrgament.greenfeenonmemeber) * (BookElectionFrgament.nonmemberplayer));
                        int bal = Integer.parseInt(stringBal);
                        String stri = Integer.toString((957) * (BookElectionFrgament.nonmemberplayer));
                        greenfeenonmember.setText(Integer.toString((957)) + "*" + (BookElectionFrgament.nonmemberplayer) + "= Rs ." + stri);
                        sumHoleN18 = ((957) * (BookElectionFrgament.nonmemberplayer));
                        totalTexAndConfeeofnonmembers = (143) * (BookElectionFrgament.nonmemberplayer);
                        tvTwilight.setText("Rs. " + (bal - (957 * BookElectionFrgament.nonmemberplayer)));
                    }
                } else {
                    //greenfeenonmember.setText("Rs ."+Integer.toString((BookElectionFrgament.greenfeenonmemeber)*(BookElectionFrgament.nonmemberplayer)));
                    String stri = Integer.toString((BookElectionFrgament.greenfeenonmemeber) * (BookElectionFrgament.nonmemberplayer));
                    greenfeenonmember.setText(Integer.toString((BookElectionFrgament.greenfeenonmemeber)) + "*" + (BookElectionFrgament.nonmemberplayer) + "= Rs ." + stri);
                    sumHoleN18 = ((BookElectionFrgament.greenfeenonmemeber) * (BookElectionFrgament.nonmemberplayer));
                    totalTexAndConfeeofnonmembers = (BookElectionFrgament.totaltaxesofnonmember) * (BookElectionFrgament.nonmemberplayer);
                }
            }

            totalgreenfeecalculted = (sumHoleM18 + sumHoleN18);


            //totalgreenfeecalculted = sumHoleM18 + sumHoleN18;
            totaltaccalculation = totalTexAndConfeeofmembers + totalTexAndConfeeofnonmembers + BookElectionFrgament.confeeofnonmemberInt;
            totalgreenfee.setText("Rs ." + String.valueOf(totalgreenfeecalculted));
            taxesfees.setText("Rs." + (totaltaccalculation));
            // int tax = Integer.parseInt(BookElectionFrgament.taxesandfees18hole);
            totalcalculated = totalgreenfeecalculted + totaltaccalculation;

            totalcalculatedint = totalcalculated;
            total.setText("Rs. " + String.valueOf(totalcalculatedint));
        }
        if (BookElectionFrgament.hole == 9) {
           /* greenfee.setText("Rs ." + BookElectionFrgament.totalgreenfeemember);
            playersnumber.setText(String.valueOf(BookElectionFrgament.playerselected));
            greenfeenonmember.setText("Rs ." + BookElectionFrgament.totalgreenfeenonmember);
            int sum = BookElectionFrgament.totalgreenfeemember + BookElectionFrgament.totalgreenfeenonmember;
            totalgreenfeecalculted = sum;
            totalgreenfee.setText("Rs. " + String.valueOf(totalgreenfeecalculted));
            taxesfees.setText("Rs. 300");
            totalcalculated = totalgreenfeecalculted;
            total.setText("Rs. " + String.valueOf(totalcalculated));*/


            //  Log.i("taxesandfess9hole", Integer.toString((BookElectionFrgament.totaltaxesANdconfeofmember)));
            Log.i("memberplauer", Integer.toString(BookElectionFrgament.greenfeemember));
            Log.i("memberplauer", Integer.toString(BookElectionFrgament.memberplayer));
            Log.i("nonmemberplauer", Integer.toString(BookElectionFrgament.nonmemberplayer));
            Log.i("Greenfeememeber", Integer.toString(BookElectionFrgament.greenfeemember));
            Log.i("Greenfeenonmemeber", Integer.toString(BookElectionFrgament.greenfeenonmemeber));
            if (BookElectionFrgament.memberplayer != 0) {
                //greenfee.setText("Rs ."+Integer.toString((BookElectionFrgament.greenfeemember)*(BookElectionFrgament.memberplayer)));
                String str = Integer.toString((BookElectionFrgament.greenfeemember) * (BookElectionFrgament.memberplayer));
                greenfee.setText(Integer.toString((BookElectionFrgament.greenfeemember)) + "*" + (BookElectionFrgament.memberplayer) + "= Rs ." + str);
                sumHoleM9 = ((BookElectionFrgament.greenfeemember) * (BookElectionFrgament.memberplayer));
                totalTexAndConfeeofmembers = (BookElectionFrgament.memberplayer * BookElectionFrgament.totaltaxesofmember);
            }
            playersnumber.setText(String.valueOf(BookElectionFrgament.playerselected));
            if (BookElectionFrgament.nonmemberplayer != 0) {

                String time = BookElectionFrgament.timeselected;
                SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
                try {
                    timejson = format.parse(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String time2 = "14:50 PM";
                SimpleDateFormat format1 = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
                try {
                    timecurrentDate = format1.parse(time2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (timejson.after(timecurrentDate)) {
                    if (BookElectionFrgament.formatid == "2") {
                        String stringBalnce = Integer.toString(BookElectionFrgament.greenfeenonmemeber * BookElectionFrgament.nonmemberplayer);
                        int balnce = Integer.parseInt(stringBalnce);
                        String stri = Integer.toString(957 * BookElectionFrgament.nonmemberplayer);
                        greenfeenonmember.setText(Integer.toString((957)) + "*" + (BookElectionFrgament.nonmemberplayer) + "= Rs ." + stri);
                        sumHoleN9 = ((957) * (BookElectionFrgament.nonmemberplayer));
                        tvTwilight.setText("Rs. - " + (balnce - (957 * BookElectionFrgament.nonmemberplayer)));
                        totalTexAndConfeeofnonmembers = ((BookElectionFrgament.nonmemberplayer * 143));
                    } else {
                        String stringBalnce = Integer.toString(BookElectionFrgament.greenfeenonmemeber * BookElectionFrgament.nonmemberplayer);
                        int balnce = Integer.parseInt(stringBalnce);
                        String stri = Integer.toString(652 * BookElectionFrgament.nonmemberplayer);
                        greenfeenonmember.setText(Integer.toString((652)) + "*" + (BookElectionFrgament.nonmemberplayer) + "= Rs ." + stri);
                        sumHoleN9 = ((652) * (BookElectionFrgament.nonmemberplayer));
                        tvTwilight.setText("Rs. - " + (balnce - (652 * BookElectionFrgament.nonmemberplayer)));
                        totalTexAndConfeeofnonmembers = ((BookElectionFrgament.nonmemberplayer * 98));
                    }
                } else {
                    //greenfeenonmember.setText("Rs ."+Integer.toString((BookElectionFrgament.greenfeenonmemeber)*(BookElectionFrgament.nonmemberplayer)));
                    String stri = Integer.toString(BookElectionFrgament.greenfeenonmemeber * BookElectionFrgament.nonmemberplayer);
                    greenfeenonmember.setText(Integer.toString((BookElectionFrgament.greenfeenonmemeber)) + "*" + (BookElectionFrgament.nonmemberplayer) + "= Rs ." + stri);
                    sumHoleN9 = ((BookElectionFrgament.greenfeenonmemeber) * (BookElectionFrgament.nonmemberplayer));
                    totalTexAndConfeeofnonmembers = ((BookElectionFrgament.nonmemberplayer * BookElectionFrgament.totaltaxesofnonmember));
                }


                totalgreenfeecalculted = (sumHoleM9 + sumHoleN9);
            }

            if (BookElectionFrgament.nonmemberplayer != 0) {
                totaltaccalculation = totalTexAndConfeeofmembers + totalTexAndConfeeofnonmembers + BookElectionFrgament.confeeofnonmemberInt;
            } else {
                totaltaccalculation = totalTexAndConfeeofmembers + totalTexAndConfeeofnonmembers + BookElectionFrgament.confeeofmemberInt;
            }
            totalgreenfee.setText("Rs ." + String.valueOf(totalgreenfeecalculted));
            taxesfees.setText("Rs." + String.valueOf(totaltaccalculation));
            // int tax = Integer.parseInt(BookElectionFrgament.taxesandfess9hole);


            totalcalculated = totalgreenfeecalculted + totaltaccalculation;
            total.setText("Rs. " + String.valueOf(totalcalculated));


        }


        continuebooking.setOnClickListener(new

                                                   OnClickListener() {

                                                       @Override
                                                       public void onClick(View v) {
                                                           // TODO Auto-generated method stub

                                                           Intent i = new Intent(Reviewbooking.this, Addonsbooking.class);
                                                           startActivity(i);

                                                       }
                                                   }

        );
    }

//    boolean chkInputs() {
//
//        if (lisEditTexts.isEmpty()) {
//            lisEditTexts.add(couponcode);
//
//        }
//
//        for (EditText editText : lisEditTexts) {
//
//            if (editText.getText().toString().length() == 0) {
//                editText.setError("Please enter the coupon code number.");
//                return false;
//            }
//
//        }
//        return true;
//    }


    @Override
    public void onBackPressed() {
        //   BookElectionFrgament.memeberupdate = false;
        //  BookElectionFrgament.timeselectedtime = false;
        // BookElectionFrgament.timetv.setText("Select Time");
        //  BookElectionFrgament.date.setText("Select Date");
        //  BookElectionFrgament.dateselected = false;

        //BookElectionFrgament.greenfeenonmemeber = 0;
        // BookElectionFrgament.greenfeemember = 0;
        // BookElectionFrgament.memberplayer = 0;
        // BookElectionFrgament.nonmemberplayer = 0;
        BookElectionFrgament.memeberupdate = false;
        greenfeenonmember.setText("");
        greenfee.setText("");
        totalgreenfee.setText("");
        totalgreenfee.setText("");
        taxesfees.setText("");
        total.setText("");
        holes.setText("");
        players.setText("");
        playersnumber.setText("");
        totaltaccalculation = 0;
        sumHoleN9 = 0;
        sumHoleN18 = 0;
        sumHoleM9 = 0;
        sumHoleM18 = 0;
        totalTexAndConfeeofnonmembers = 0;
        totalgreenfeecalculted = 0;
        Log.i("Greenfeenonmemeber", Integer.toString(BookElectionFrgament.greenfeenonmemeber));
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
        } catch (NullPointerException ee) {

        }
        return output;
    }

}
