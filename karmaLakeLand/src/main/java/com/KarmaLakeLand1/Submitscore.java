package com.KarmaLakeLand1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONObject;

import Helper.App_Common;
import Utility.WebService;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Submitscore extends Fragment {

    Button submitscorecard;
    Button startnewround;

    EditText putts1;
    EditText putts2;
    EditText putts3;
    EditText putts4;
    EditText putts5;
    EditText putts6;
    EditText putts7;
    EditText putts8;
    EditText putts9;


    EditText putts10;
    EditText putts11;
    EditText putts12;
    EditText putts13;
    EditText putts14;
    EditText putts15;
    EditText putts16;
    EditText putts17;
    EditText putts18;


    String puttts1;
    String puttts2;
    String puttts3;
    String puttts4;
    String puttts5;
    String puttts6;
    String puttts7;
    String puttts8;
    String puttts9;


    String puttts10;
    String puttts11;
    String puttts12;
    String puttts13;
    String puttts14;
    String puttts15;
    String puttts16;
    String puttts17;
    String puttts18;


    //strokes
    EditText strokes1;
    EditText strokes2;
    EditText strokes3;
    EditText strokes4;
    EditText strokes5;
    EditText strokes6;
    EditText strokes7;
    EditText strokes8;
    EditText strokes9;


    EditText strokes10;
    EditText strokes11;
    EditText strokes12;
    EditText strokes13;
    EditText strokes14;
    EditText strokes15;
    EditText strokes16;
    EditText strokes17;
    EditText strokes18;


    String strokess1;
    String strokess2;
    String strokess3;
    String strokess4;
    String strokess5;
    String strokess6;
    String strokess7;
    String strokess8;
    String strokess9;


    String strokess10;
    String strokess11;
    String strokess12;
    String strokess13;
    String strokess14;
    String strokess15;
    String strokess16;
    String strokess17;
    String strokess18;


    /*EditText penalty1;
    EditText penalty2;
    EditText penalty3;
    EditText penalty4;
    EditText penalty5;
    EditText penalty6;
    EditText penalty7;
    EditText penalty8;
    EditText penalty9;


    EditText penalty10;
    EditText penalty11;
    EditText penalty12;
    EditText penalty13;
    EditText penalty14;
    EditText penalty15;
    EditText penalty16;
    EditText penalty17;
    EditText penalty18;*/

//    String penaltys1;
//    String penaltys2;
//    String penaltys3;
//    String penaltys4;
//    String penaltys5;
//    String penaltys6;
//    String penaltys7;
//    String penaltys8;
//    String penaltys9;
//
//
//    String penaltys10;
//    String penaltys11;
//    String penaltys12;
//    String penaltys13;
//    String penaltys14;
//    String penaltys15;
//    String penaltys16;
//    String penaltys17;
//    String penaltys18;
    //
    Button savescore1;
    Button savescore2;
    Button savescore3;
    Button savescore4;
    Button savescore5;
    Button savescore6;
    Button savescore7;
    Button savescore8;
    Button savescore9;

    Button savescore10;
    Button savescore11;
    Button savescore12;
    Button savescore13;
    Button savescore14;
    Button savescore15;
    Button savescore16;
    Button savescore17;
    Button savescore18;

    int penaltyvalue;

    static String strDate;
    String totaldeatilscore = null;

//    String detailscore;
    String detailscore1;
    String detailscore2;
    String detailscore3;
    String detailscore4;
    String detailscore5;
    String detailscore6;
    String detailscore7;
    String detailscore8;
    String detailscore9;

    static int totalnumberofputts;

    String detailscore10;
    String detailscore11;
    String detailscore12;
    String detailscore13;
    String detailscore14;
    String detailscore15;
    String detailscore16;
    String detailscore17;
    String detailscore18;
    CharSequence s;

//    static String totalnumberofputs;
//    static String totalnumberofpenalty;
//    static String totalnumberofstrokes;
    static int totalnumberofstroke;

    //VAlUE FOR BUTTON HIT
    boolean statussubmitscore = false;
    static String hole = "9";
    Button holes9;
    Button holes18;
    LinearLayout layouthole1;
    TableLayout tablelayout10;
    TableLayout tablelayout11;
    TableLayout tablelayout12;
    TableLayout tablelayout13;
    TableLayout tablelayout14;
    TableLayout tablelayout15;
    TableLayout tablelayout16;
    TableLayout tablelayout17;
    TableLayout tablelayout18;
    TableRow tablerow1;
    TableRow tablerow2;
//    TableRow tablerow3;
    TableRow tablerow4;
    TableRow tablerow5;
//    TableRow tablerow6;
    TableRow tablerow7;
    TableRow tablerow8;
//    TableRow tablerow9;
    TableRow tablerow10;
    TableRow tablerow11;
//    TableRow tablerow12;
    TableRow tablerow13;
    TableRow tablerow14;
//    TableRow tablerow15;
    TableRow tablerow16;
    TableRow tablerow17;
//    TableRow tablerow18;
    TableRow tablerow19;
    TableRow tablerow20;
//    TableRow tablerow21;
//    TableRow tablerow22;
    TableRow tablerow23;
    TableRow tablerow24;
//    TableRow tablerow25;
    TableRow tablerow26;
    TableRow tablerow27;
//    TableRow tablerow28;
    TableRow tablerow29;
    TableRow tablerow30;
//    TableRow tablerow31;
    TableRow tablerow32;
    TableRow tablerow33;
//    TableRow tablerow34;
    TableRow tablerow35;
    TableRow tablerow36;
//    TableRow tablerow37;
    TableRow tablerow38;
    TableRow tablerow39;
//    TableRow tablerow40;
    TableRow tablerow41;
    TableRow tablerow42;
//    TableRow tablerow43;
    TableRow tablerow44;
    TableRow tablerow45;
//    TableRow tablerow46;
    TableRow tablerow47;
    TableRow tablerow48;
//    TableRow tablerow49;
    TableRow tablerow50;
    TableRow tablerow51;
//    TableRow tablerow52;
    TableRow tablerow53;
    TableRow tablerow54;
//    TableRow tablerow55;

    static boolean submitscore = false;

//    String holeno;

    static Boolean totalclick = false;
    static boolean counter1 = true;
    static boolean counter2 = true;
    static boolean counter3 = true;
    static boolean counter4 = true;
    static boolean counter5 = true;
    static boolean counter6 = true;
    static boolean counter7 = true;
    static boolean counter8 = true;
    static boolean counter9 = true;

    static boolean counter10 = true;
    static boolean counter11 = true;
    static boolean counter12 = true;
    static boolean counter13 = true;
    static boolean counter14 = true;
    static boolean counter15 = true;
    static boolean counter16 = true;
    static boolean counter17 = true;
    static boolean counter18 = true;

//    static boolean newcounter1 = false;
//    static boolean newcounter2 = false;
//    static boolean newcounter3 = false;
//    static boolean newcounter4 = false;
//    static boolean newcounter5 = false;
//    static boolean newcounter6 = false;
//    static boolean newcounter7 = false;
//    static boolean newcounter8 = false;
//    static boolean newcounter9 = false;
//
//    static boolean newcounter10 = false;
//    static boolean newcounter11 = false;
//    static boolean newcounter12 = false;
//    static boolean newcounter13 = false;
//    static boolean newcounter14 = false;
//    static boolean newcounter15 = false;
//    static boolean newcounter16 = false;
//    static boolean newcounter17 = false;
//    static boolean newcounter18 = false;

    TextView puttstv1;
    TextView puttstv2;
    TextView puttstv3;
    TextView puttstv4;
    TextView puttstv5;
    TextView puttstv6;
    TextView puttstv7;
    TextView puttstv8;
    TextView puttstv9;

    TextView puttstv10;
    TextView puttstv11;
    TextView puttstv12;
    TextView puttstv13;
    TextView puttstv14;
    TextView puttstv15;
    TextView puttstv16;
    TextView puttstv17;
    TextView puttstv18;

//    TextView penaltytv1;
    TextView penaltytv2;
//    TextView penaltytv3;
//    TextView penaltytv4;
//    TextView penaltytv5;
//    TextView penaltytv6;
//    TextView penaltytv7;
//    TextView penaltytv8;
//    TextView penaltytv9;

    String currentTime;


//    TextView penaltytv10;
//    TextView penaltytv11;
//    TextView penaltytv12;
//    TextView penaltytv13;
//    TextView penaltytv14;
//    TextView penaltytv15;
//    TextView penaltytv16;
//    TextView penaltytv17;
//    TextView penaltytv18;


    TextView strokestv1;
    TextView strokestv2;
    TextView strokestv3;
    TextView strokestv4;
    TextView strokestv5;
    TextView strokestv6;
    TextView strokestv7;
    TextView strokestv8;
    TextView strokestv9;


    TextView strokestv10;
    TextView strokestv11;
    TextView strokestv12;
    TextView strokestv13;
    TextView strokestv14;
    TextView strokestv15;
    TextView strokestv16;
    TextView strokestv17;
    TextView strokestv18;


    String stime;
    static int holeselected = 0;

    List<EditText> lisEditTexts1;
    List<EditText> lisEditTexts2;
    List<EditText> lisEditTexts3;
    List<EditText> lisEditTexts4;
    List<EditText> lisEditTexts5;
    List<EditText> lisEditTexts6;
    List<EditText> lisEditTexts7;
    List<EditText> lisEditTexts8;
    List<EditText> lisEditTexts9;


    List<EditText> lisEditTexts10;
    List<EditText> lisEditTexts11;
    List<EditText> lisEditTexts12;
    List<EditText> lisEditTexts13;
    List<EditText> lisEditTexts14;
    List<EditText> lisEditTexts15;
    List<EditText> lisEditTexts16;
    List<EditText> lisEditTexts17;
    List<EditText> lisEditTexts18;


    LinearLayout linearlayout10;
    LinearLayout linearlayout11;
    LinearLayout linearlayout12;
    LinearLayout linearlayout13;
    LinearLayout linearlayout14;
    LinearLayout linearlayout15;
    LinearLayout linearlayout16;
    LinearLayout linearlayout17;
    LinearLayout linearlayout18;

    boolean _areLecturesLoaded = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !_areLecturesLoaded) {


            _areLecturesLoaded = true;
        } else {
            _areLecturesLoaded = false;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.submitscore, container, false);

        App_Common.getInstance(getActivity()).setTotalPuts("");
        App_Common.getInstance(getActivity()).setTotalStrokes("");

        timeslection();
        //  new Getholescore().execute();
        Calendar c = Calendar.getInstance();
        lisEditTexts1 = new ArrayList<EditText>();
        lisEditTexts2 = new ArrayList<EditText>();
        lisEditTexts3 = new ArrayList<EditText>();
        lisEditTexts4 = new ArrayList<EditText>();
        lisEditTexts5 = new ArrayList<EditText>();
        lisEditTexts6 = new ArrayList<EditText>();
        lisEditTexts7 = new ArrayList<EditText>();
        lisEditTexts8 = new ArrayList<EditText>();
        lisEditTexts9 = new ArrayList<EditText>();


        lisEditTexts10 = new ArrayList<EditText>();
        lisEditTexts11 = new ArrayList<EditText>();
        lisEditTexts12 = new ArrayList<EditText>();
        lisEditTexts13 = new ArrayList<EditText>();
        lisEditTexts14 = new ArrayList<EditText>();
        lisEditTexts15 = new ArrayList<EditText>();
        lisEditTexts16 = new ArrayList<EditText>();
        lisEditTexts17 = new ArrayList<EditText>();
        lisEditTexts18 = new ArrayList<EditText>();

        Date parseTime;
        Time time = new Time(Time.getCurrentTimezone());
        time.setToNow();
        currentTime = (time.hour + ":" + time.minute);
        stime = currentTime;

        DateFormat formatter = new SimpleDateFormat("HH:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("IST"));
        try {
            parseTime = (Date) formatter.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
      /* stime = String.valueOf(parseTime);*/

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        strDate = sdf.format(c.getTime());

        layouthole1 = (LinearLayout) view.findViewById(R.id.layouthole1);
        linearlayout10 = (LinearLayout) view.findViewById(R.id.linearlayout10);
        linearlayout11 = (LinearLayout) view.findViewById(R.id.linearlayout11);
        linearlayout12 = (LinearLayout) view.findViewById(R.id.linearlayout12);
        linearlayout13 = (LinearLayout) view.findViewById(R.id.linearlayout13);
        linearlayout14 = (LinearLayout) view.findViewById(R.id.linearlayout14);
        linearlayout15 = (LinearLayout) view.findViewById(R.id.linearlayout15);
        linearlayout16 = (LinearLayout) view.findViewById(R.id.linearlayout16);
        linearlayout17 = (LinearLayout) view.findViewById(R.id.linearlayout17);
        linearlayout18 = (LinearLayout) view.findViewById(R.id.linearlayout18);

        tablelayout10 = (TableLayout) view.findViewById(R.id.tablelayout10);
        tablelayout11 = (TableLayout) view.findViewById(R.id.tablelayout11);
        tablelayout12 = (TableLayout) view.findViewById(R.id.tablelayout12);
        tablelayout13 = (TableLayout) view.findViewById(R.id.tablelayout13);
        tablelayout14 = (TableLayout) view.findViewById(R.id.tablelayout14);
        tablelayout15 = (TableLayout) view.findViewById(R.id.tablelayout15);
        tablelayout16 = (TableLayout) view.findViewById(R.id.tablelayout16);
        tablelayout17 = (TableLayout) view.findViewById(R.id.tablelayout17);
        tablelayout18 = (TableLayout) view.findViewById(R.id.tablelayout18);


        tablerow1 = (TableRow) view.findViewById(R.id.tablerow1);
        tablerow2 = (TableRow) view.findViewById(R.id.tablerow2);
     //   tablerow3 = (TableRow) view.findViewById(R.id.tablerow3);
        tablerow4 = (TableRow) view.findViewById(R.id.tablerow4);
        tablerow5 = (TableRow) view.findViewById(R.id.tablerow5);
      //  tablerow6 = (TableRow) view.findViewById(R.id.tablerow6);
        tablerow7 = (TableRow) view.findViewById(R.id.tablerow7);
        tablerow8 = (TableRow) view.findViewById(R.id.tablerow8);
     //   tablerow9 = (TableRow) view.findViewById(R.id.tablerow9);
        tablerow10 = (TableRow) view.findViewById(R.id.tablerow10);
        tablerow11 = (TableRow) view.findViewById(R.id.tablerow11);
      //  tablerow12 = (TableRow) view.findViewById(R.id.tablerow12);
        tablerow13 = (TableRow) view.findViewById(R.id.tablerow13);
        tablerow14 = (TableRow) view.findViewById(R.id.tablerow14);
      //  tablerow15 = (TableRow) view.findViewById(R.id.tablerow15);
        tablerow16 = (TableRow) view.findViewById(R.id.tablerow16);
        tablerow17 = (TableRow) view.findViewById(R.id.tablerow17);
     //   tablerow18 = (TableRow) view.findViewById(R.id.tablerow18);
        tablerow19 = (TableRow) view.findViewById(R.id.tablerow19);
        tablerow20 = (TableRow) view.findViewById(R.id.tablerow20);
     //   tablerow21 = (TableRow) view.findViewById(R.id.tablerow21);

        tablerow23 = (TableRow) view.findViewById(R.id.tablerow23);
        tablerow24 = (TableRow) view.findViewById(R.id.tablerow24);
       // tablerow25 = (TableRow) view.findViewById(R.id.tablerow25);
        tablerow26 = (TableRow) view.findViewById(R.id.tablerow26);
        tablerow27 = (TableRow) view.findViewById(R.id.tablerow27);
      //  tablerow28 = (TableRow) view.findViewById(R.id.tablerow28);

        tablerow29 = (TableRow) view.findViewById(R.id.tablerow29);
        tablerow30 = (TableRow) view.findViewById(R.id.tablerow30);
     //   tablerow31 = (TableRow) view.findViewById(R.id.tablerow31);
        tablerow32 = (TableRow) view.findViewById(R.id.tablerow32);
        tablerow33 = (TableRow) view.findViewById(R.id.tablerow33);
      //  tablerow34 = (TableRow) view.findViewById(R.id.tablerow34);
        tablerow35 = (TableRow) view.findViewById(R.id.tablerow35);
        tablerow36 = (TableRow) view.findViewById(R.id.tablerow36);
       // tablerow37 = (TableRow) view.findViewById(R.id.tablerow37);
        tablerow38 = (TableRow) view.findViewById(R.id.tablerow38);
        tablerow39 = (TableRow) view.findViewById(R.id.tablerow39);
      //  tablerow40 = (TableRow) view.findViewById(R.id.tablerow40);
        tablerow41 = (TableRow) view.findViewById(R.id.tablerow41);
        tablerow42 = (TableRow) view.findViewById(R.id.tablerow42);
       // tablerow43 = (TableRow) view.findViewById(R.id.tablerow43);
        tablerow44 = (TableRow) view.findViewById(R.id.tablerow44);
        tablerow45 = (TableRow) view.findViewById(R.id.tablerow45);
       // tablerow46 = (TableRow) view.findViewById(R.id.tablerow46);
        tablerow47 = (TableRow) view.findViewById(R.id.tablerow47);
        tablerow48 = (TableRow) view.findViewById(R.id.tablerow48);
        //tablerow49 = (TableRow) view.findViewById(R.id.tablerow49);

        tablerow50 = (TableRow) view.findViewById(R.id.tablerow50);
        tablerow51 = (TableRow) view.findViewById(R.id.tablerow51);
      //  tablerow52 = (TableRow) view.findViewById(R.id.tablerow52);
        tablerow53 = (TableRow) view.findViewById(R.id.tablerow53);
        tablerow54 = (TableRow) view.findViewById(R.id.tablerow54);
       // tablerow55 = (TableRow) view.findViewById(R.id.tablerow55);


        putts1 = (EditText) view.findViewById(R.id.puts1);

        putts2 = (EditText) view.findViewById(R.id.putts2);
        putts3 = (EditText) view.findViewById(R.id.putts3);
        putts4 = (EditText) view.findViewById(R.id.putts4);
        putts5 = (EditText) view.findViewById(R.id.putts5);
        putts6 = (EditText) view.findViewById(R.id.putts6);
        putts7 = (EditText) view.findViewById(R.id.putts7);
        putts8 = (EditText) view.findViewById(R.id.putts8);
        putts9 = (EditText) view.findViewById(R.id.putts9);

        putts10 = (EditText) view.findViewById(R.id.putts10);

        putts11 = (EditText) view.findViewById(R.id.putts11);
        putts12 = (EditText) view.findViewById(R.id.putts12);
        putts13 = (EditText) view.findViewById(R.id.putts13);
        putts14 = (EditText) view.findViewById(R.id.putts14);
        putts15 = (EditText) view.findViewById(R.id.putts15);
        putts16 = (EditText) view.findViewById(R.id.putts16);
        putts17 = (EditText) view.findViewById(R.id.putts17);
        putts18 = (EditText) view.findViewById(R.id.putts18);


        puttstv1 = (TextView) view.findViewById(R.id.puttstv1);
        puttstv2 = (TextView) view.findViewById(R.id.puttstv2);
        puttstv3 = (TextView) view.findViewById(R.id.puttstv3);
        puttstv4 = (TextView) view.findViewById(R.id.puttstv4);
        puttstv5 = (TextView) view.findViewById(R.id.puttstv5);
        puttstv6 = (TextView) view.findViewById(R.id.puttstv6);
        puttstv7 = (TextView) view.findViewById(R.id.puttstv7);
        puttstv8 = (TextView) view.findViewById(R.id.puttstv8);
        puttstv9 = (TextView) view.findViewById(R.id.puttstv9);


        puttstv10 = (TextView) view.findViewById(R.id.puttstv10);
        puttstv11 = (TextView) view.findViewById(R.id.puttstv11);
        puttstv12 = (TextView) view.findViewById(R.id.puttstv12);
        puttstv13 = (TextView) view.findViewById(R.id.puttstv13);
        puttstv14 = (TextView) view.findViewById(R.id.puttstv14);
        puttstv15 = (TextView) view.findViewById(R.id.puttstv15);
        puttstv16 = (TextView) view.findViewById(R.id.puttstv16);
        puttstv17 = (TextView) view.findViewById(R.id.puttstv17);
        puttstv18 = (TextView) view.findViewById(R.id.puttstv18);


        strokes1 = (EditText) view.findViewById(R.id.strokes1);
        strokes2 = (EditText) view.findViewById(R.id.strokes2);
        strokes3 = (EditText) view.findViewById(R.id.strokes3);
        strokes4 = (EditText) view.findViewById(R.id.strokes4);
        strokes5 = (EditText) view.findViewById(R.id.strokes5);
        strokes6 = (EditText) view.findViewById(R.id.strokes6);
        strokes7 = (EditText) view.findViewById(R.id.strokes7);
        strokes8 = (EditText) view.findViewById(R.id.strokes8);
        strokes9 = (EditText) view.findViewById(R.id.strokes9);


        strokes10 = (EditText) view.findViewById(R.id.strokes10);
        strokes11 = (EditText) view.findViewById(R.id.strokes11);
        strokes12 = (EditText) view.findViewById(R.id.strokes12);
        strokes13 = (EditText) view.findViewById(R.id.strokes13);
        strokes14 = (EditText) view.findViewById(R.id.strokes14);
        strokes15 = (EditText) view.findViewById(R.id.strokes15);
        strokes16 = (EditText) view.findViewById(R.id.strokes16);
        strokes17 = (EditText) view.findViewById(R.id.strokes17);
        strokes18 = (EditText) view.findViewById(R.id.strokes18);


        strokestv1 = (TextView) view.findViewById(R.id.strokestv1);
        strokestv2 = (TextView) view.findViewById(R.id.strokestv2);
        strokestv3 = (TextView) view.findViewById(R.id.strokestv3);
        strokestv4 = (TextView) view.findViewById(R.id.strokestv4);
        strokestv5 = (TextView) view.findViewById(R.id.strokestv5);
        strokestv6 = (TextView) view.findViewById(R.id.strokestv6);
        strokestv7 = (TextView) view.findViewById(R.id.strokestv7);
        strokestv8 = (TextView) view.findViewById(R.id.strokestv8);
        strokestv9 = (TextView) view.findViewById(R.id.strokestv9);

        strokestv10 = (TextView) view.findViewById(R.id.strokestv10);
        strokestv11 = (TextView) view.findViewById(R.id.strokestv11);
        strokestv12 = (TextView) view.findViewById(R.id.strokestv12);
        strokestv13 = (TextView) view.findViewById(R.id.strokestv13);
        strokestv14 = (TextView) view.findViewById(R.id.strokestv14);
        strokestv15 = (TextView) view.findViewById(R.id.strokestv15);
        strokestv16 = (TextView) view.findViewById(R.id.strokestv16);
        strokestv17 = (TextView) view.findViewById(R.id.strokestv17);
        strokestv18 = (TextView) view.findViewById(R.id.strokestv18);


       /* penalty1 = (EditText) view.findViewById(R.id.penalty1);
        penalty2 = (EditText) view.findViewById(R.id.penalty2);
        penalty3 = (EditText) view.findViewById(R.id.penalty3);
        penalty4 = (EditText) view.findViewById(R.id.penalty4);
        penalty5 = (EditText) view.findViewById(R.id.penalty5);
        penalty6 = (EditText) view.findViewById(R.id.penalty6);
        penalty7 = (EditText) view.findViewById(R.id.penalty7);
        penalty8 = (EditText) view.findViewById(R.id.penalty8);
        penalty9 = (EditText) view.findViewById(R.id.penalty9);


        penalty10 = (EditText) view.findViewById(R.id.penalty10);
        penalty11 = (EditText) view.findViewById(R.id.penalty11);
        penalty12 = (EditText) view.findViewById(R.id.penalty12);
        penalty13 = (EditText) view.findViewById(R.id.penalty13);
        penalty14 = (EditText) view.findViewById(R.id.penalty14);
        penalty15 = (EditText) view.findViewById(R.id.penalty15);
        penalty16 = (EditText) view.findViewById(R.id.penalty16);
        penalty17 = (EditText) view.findViewById(R.id.penalty17);
        penalty18 = (EditText) view.findViewById(R.id.penalty18);
*/

      /*  penaltytv1 = (TextView) view.findViewById(R.id.penaltytv1);
        penaltytv2 = (TextView) view.findViewById(R.id.penaltytv2);
        penaltytv3 = (TextView) view.findViewById(R.id.penaltytv3);
        penaltytv4 = (TextView) view.findViewById(R.id.penaltytv4);
        penaltytv5 = (TextView) view.findViewById(R.id.penaltytv5);
        penaltytv6 = (TextView) view.findViewById(R.id.penaltytv6);
        penaltytv7 = (TextView) view.findViewById(R.id.penaltytv7);
        penaltytv8 = (TextView) view.findViewById(R.id.penaltytv8);
        penaltytv9 = (TextView) view.findViewById(R.id.penaltytv9);


        penaltytv10 = (TextView) view.findViewById(R.id.penaltytv10);
        penaltytv11 = (TextView) view.findViewById(R.id.penaltytv11);
        penaltytv12 = (TextView) view.findViewById(R.id.penaltytv12);
        penaltytv13 = (TextView) view.findViewById(R.id.penaltytv13);
        penaltytv14 = (TextView) view.findViewById(R.id.penaltytv14);
        penaltytv15 = (TextView) view.findViewById(R.id.penaltytv15);
        penaltytv16 = (TextView) view.findViewById(R.id.penaltytv16);
        penaltytv17 = (TextView) view.findViewById(R.id.penaltytv17);
        penaltytv18 = (TextView) view.findViewById(R.id.penaltytv18);*/


        //
        savescore1 = (Button) view.findViewById(R.id.savescore1);
        savescore2 = (Button) view.findViewById(R.id.savescore2);
        savescore3 = (Button) view.findViewById(R.id.savescore3);
        savescore4 = (Button) view.findViewById(R.id.savescore4);
        savescore5 = (Button) view.findViewById(R.id.savescore5);
        savescore6 = (Button) view.findViewById(R.id.savescore6);
        savescore7 = (Button) view.findViewById(R.id.savescore7);
        savescore8 = (Button) view.findViewById(R.id.savescore8);
        savescore9 = (Button) view.findViewById(R.id.savescore9);

        savescore10 = (Button) view.findViewById(R.id.savescore10);
        savescore11 = (Button) view.findViewById(R.id.savescore11);
        savescore12 = (Button) view.findViewById(R.id.savescore12);
        savescore13 = (Button) view.findViewById(R.id.savescore13);
        savescore14 = (Button) view.findViewById(R.id.savescore14);
        savescore15 = (Button) view.findViewById(R.id.savescore15);
        savescore16 = (Button) view.findViewById(R.id.savescore16);
        savescore17 = (Button) view.findViewById(R.id.savescore17);
        savescore18 = (Button) view.findViewById(R.id.savescore18);


        lisEditTexts1.add(putts1);
        lisEditTexts1.add(strokes1);

        putts1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts1.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes1.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts2.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes2.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts3.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts3.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes3.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes3.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts4.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts4.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes4.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes4.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts5.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts5.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes5.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes5.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts6.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts6.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes6.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes6.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts7.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts7.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes7.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes7.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts8.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts8.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes8.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes8.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts9.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts9.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes9.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes9.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });


        putts10.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts10.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes10.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes10.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts11.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts11.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes11.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes11.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts12.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts12.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes12.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes12.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts13.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts13.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes13.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes13.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts14.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts14.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes14.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes14.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts15.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts15.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes15.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes15.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts16.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts16.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes16.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes16.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts17.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts17.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes17.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes17.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        putts18.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                putts18.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
        strokes18.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // Your validation code goes here
                strokes18.setBackgroundResource(R.drawable.buttonstyle);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        savescore1.setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        // TODO Auto-generated method stub

                        if (chkInputs1()) {

                            if (counter1 == true)

                            {
                                int strokevalue = Integer.parseInt(strokes1.getText().toString());
                                //  int penaltyvalue = Integer.parseInt(penalty1.getText().toString());
                               /* if (penalty1.getText().toString().length() == 0) {
                                    penaltyvalue = 0;
                                } else {
                                    penaltyvalue = Integer.parseInt(penalty1.getText().toString());
                                }
*/
                                int puttsvalue = Integer.parseInt(putts1.getText().toString());

                                if (strokevalue > penaltyvalue + puttsvalue)

                                {
                                    detailscore1 = "hole-1" + "," + "putts-" + putts1.getText().toString() + "," + "strock-" + strokes1.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "4";
                                    // detailscore1 = detailscore;
                                    App_Common.getInstance(getActivity()).setHolescore1(detailscore1);
                                    putts1.setBackgroundResource(R.drawable.buttonstyle1);
                                    puttstv1.setBackgroundResource(R.drawable.buttonstyle1);
                                   // penalty1.setBackgroundResource(R.drawable.buttonstyle1);
                                    //penaltytv1.setBackgroundResource(R.drawable.buttonstyle1);
                                    strokes1.setBackgroundResource(R.drawable.buttonstyle1);
                                    strokestv1.setBackgroundResource(R.drawable.buttonstyle1);
                                    savescore1.setBackgroundColor(Color.parseColor("#D8D8D8"));
                                    savescore1.setText("Edit");
                                    savescore1.setTextColor(Color.parseColor("#000000"));
                                    putts1.setEnabled(false);
                                    strokes1.setEnabled(false);
                                 //   penalty1.setEnabled(false);
                                    holeselected++;
                                    counter1 = false;
                                    submitscore = true;

                                    //  new Addholescore().execute();
                                } else {
                                    Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                App_Common.getInstance(getActivity()).setHolescore1("");


                                putts1.setBackgroundResource(R.drawable.buttonstyle);
                                puttstv1.setBackgroundResource(R.drawable.buttonstyle);
                              //  penalty1.setBackgroundResource(R.drawable.buttonstyle);
                              //  penaltytv1.setBackgroundResource(R.drawable.buttonstyle);
                                strokes1.setBackgroundResource(R.drawable.buttonstyle);
                                strokestv1.setBackgroundResource(R.drawable.buttonstyle);
                                savescore1.setBackgroundColor(Color.parseColor("#33CC33"));
                                savescore1.setText("SAVE SCORE");
                                holeselected--;
                                savescore1.setTextColor(Color.parseColor("#000000"));
                                putts1.setEnabled(true);
                                strokes1.setEnabled(true);
                              //  penalty1.setEnabled(true);
                                counter1 = true;
                            }


                        } else {

                        }

                    }

                });
        savescore2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs2()) {
                    Log.i("Value of inputs", String.valueOf(counter2));
                    if (counter2 == true) {


                        int strokevalue = Integer.parseInt(strokes2.getText().toString());
                        //   int penaltyvalue = Integer.parseInt(penalty2.getText().toString());
                        int puttsvalue = Integer.parseInt(putts2.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore2 = "hole-2" + "," + "putts-" + putts2.getText().toString() + "," + "strock-" + strokes2.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "3";
                            //detailscore2 = detailscore;

                            putts2.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv2.setBackgroundResource(R.drawable.buttonstyle1);
                           // penalty2.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penaltytv2.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes2.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv2.setBackgroundResource(R.drawable.buttonstyle1);

                            putts2.setEnabled(false);
                            strokes2.setEnabled(false);
                          //  penalty2.setEnabled(false);

                            savescore2.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore2.setText("Edit");
                            savescore2.setTextColor(Color.parseColor("#000000"));
                            holeselected++;
                            counter2 = false;
                            submitscore = true;

                            App_Common.getInstance(getActivity()).setHolescore2(detailscore2);


                            //  new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        putts2.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv2.setBackgroundResource(R.drawable.buttonstyle);
                      //  penalty2.setBackgroundResource(R.drawable.buttonstyle);
                        penaltytv2.setBackgroundResource(R.drawable.buttonstyle);
                        strokes2.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv2.setBackgroundResource(R.drawable.buttonstyle);
                        savescore2.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore2.setText("SAVE SCORE");
                        savescore2.setTextColor(Color.parseColor("#000000"));
                        putts2.setEnabled(true);
                        holeselected--;
                        strokes2.setEnabled(true);
                      //  penalty2.setEnabled(true);
                        counter2 = true;

                        App_Common.getInstance(getActivity()).setHolescore2("");


                    }


                }

            }
        });
        holes9 = (Button) view.findViewById(R.id.hole9);
        holes18 = (Button) view.findViewById(R.id.hole18);
        holes9.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                hole = "9";
                holes9.setBackgroundColor(Color.parseColor("#3061e5"));
                holes9.setTextColor(Color.parseColor("#FFFFFF"));
                holes18.setBackgroundResource(R.drawable.buttonstyle);
                holes18.setTextColor(Color.parseColor("#000000"));

                savescore10.setVisibility(View.GONE);
                tablelayout10.setVisibility(View.GONE);
                linearlayout10.setVisibility(View.GONE);

                savescore11.setVisibility(View.GONE);
                tablelayout11.setVisibility(View.GONE);
                linearlayout11.setVisibility(View.GONE);

                savescore12.setVisibility(View.GONE);
                tablelayout12.setVisibility(View.GONE);
                linearlayout12.setVisibility(View.GONE);

                savescore13.setVisibility(View.GONE);
                tablelayout13.setVisibility(View.GONE);
                linearlayout13.setVisibility(View.GONE);

                savescore14.setVisibility(View.GONE);
                tablelayout14.setVisibility(View.GONE);
                linearlayout14.setVisibility(View.GONE);

                savescore15.setVisibility(View.GONE);
                tablelayout15.setVisibility(View.GONE);
                linearlayout15.setVisibility(View.GONE);

                savescore16.setVisibility(View.GONE);
                tablelayout16.setVisibility(View.GONE);
                linearlayout16.setVisibility(View.GONE);

                savescore17.setVisibility(View.GONE);
                tablelayout17.setVisibility(View.GONE);
                linearlayout17.setVisibility(View.GONE);


                savescore18.setVisibility(View.GONE);
                tablelayout18.setVisibility(View.GONE);
                linearlayout18.setVisibility(View.GONE);


            }
        });
        holes18.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                hole = "18";
                holes18.setBackgroundColor(Color.parseColor("#3061e5"));
                holes18.setTextColor(Color.parseColor("#FFFFFF"));
                holes9.setBackgroundResource(R.drawable.buttonstyle);
                holes9.setTextColor(Color.parseColor("#000000"));

                savescore10.setVisibility(View.VISIBLE);
                tablelayout10.setVisibility(View.VISIBLE);
                linearlayout10.setVisibility(View.VISIBLE);

                savescore11.setVisibility(View.VISIBLE);
                tablelayout11.setVisibility(View.VISIBLE);
                linearlayout11.setVisibility(View.VISIBLE);

                savescore12.setVisibility(View.VISIBLE);
                tablelayout12.setVisibility(View.VISIBLE);
                linearlayout12.setVisibility(View.VISIBLE);

                savescore13.setVisibility(View.VISIBLE);
                tablelayout13.setVisibility(View.VISIBLE);
                linearlayout13.setVisibility(View.VISIBLE);

                savescore14.setVisibility(View.VISIBLE);
                tablelayout14.setVisibility(View.VISIBLE);
                linearlayout14.setVisibility(View.VISIBLE);

                savescore15.setVisibility(View.VISIBLE);
                tablelayout15.setVisibility(View.VISIBLE);
                linearlayout15.setVisibility(View.VISIBLE);

                savescore16.setVisibility(View.VISIBLE);
                tablelayout16.setVisibility(View.VISIBLE);
                linearlayout16.setVisibility(View.VISIBLE);

                savescore17.setVisibility(View.VISIBLE);
                tablelayout17.setVisibility(View.VISIBLE);
                linearlayout17.setVisibility(View.VISIBLE);


                savescore18.setVisibility(View.VISIBLE);
                tablelayout18.setVisibility(View.VISIBLE);
                linearlayout18.setVisibility(View.VISIBLE);
            }
        });
        savescore3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (chkInputs3()) {
                    if (counter3 == true) {

                       /* if (penalty3.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty3.getText().toString());
                        }*/
                        Log.i("Penalty value", String.valueOf(penaltyvalue));

                        int strokevalue = Integer.parseInt(strokes3.getText().toString());
                        // int penaltyvalue=Integer.parseInt(penalty3.getText().toString());
                        int puttsvalue = Integer.parseInt(putts3.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore3 = "hole-3" + "," + "putts-" + putts3.getText().toString() + "," + "strock-" + strokes3.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "3";
                            //detailscore3 = detailscore;
                            putts3.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv3.setBackgroundResource(R.drawable.buttonstyle1);
                        //    penalty3.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penaltytv3.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes3.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv3.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore3.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore3.setText("Edit");
                            savescore3.setTextColor(Color.parseColor("#000000"));
                            counter3 = false;
                            holeselected++;
                            putts3.setEnabled(false);
                            strokes3.setEnabled(false);
                           // penalty3.setEnabled(false);
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore3(detailscore3);

                            // new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        putts3.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv3.setBackgroundResource(R.drawable.buttonstyle);
                    //    penalty3.setBackgroundResource(R.drawable.buttonstyle);
                     //   penaltytv3.setBackgroundResource(R.drawable.buttonstyle);
                        strokes3.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv3.setBackgroundResource(R.drawable.buttonstyle);
                        savescore3.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore3.setText("SAVE SCORE");
                        savescore3.setTextColor(Color.parseColor("#000000"));
                        putts3.setEnabled(true);
                        strokes3.setEnabled(true);
                     //   penalty3.setEnabled(true);
                        holeselected--;
                        counter3 = true;
                        App_Common.getInstance(getActivity()).setHolescore3("");
                    }


                }


            }
        });
        savescore4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs4()) {


                    if (counter4 == true)

                    {

                       /* if (penalty4.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty4.getText().toString());
                        }
*/

                        int strokevalue = Integer.parseInt(strokes4.getText().toString());
                        //  int penaltyvalue = Integer.parseInt(penalty4.getText().toString());
                        int puttsvalue = Integer.parseInt(putts4.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore4 = "hole-4" + "," + "putts-" + putts4.getText().toString() + "," + "strock-" + strokes4.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "5";
                            // detailscore4 = detailscore;
                            putts4.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv4.setBackgroundResource(R.drawable.buttonstyle1);
                        //    penalty4.setBackgroundResource(R.drawable.buttonstyle1);
                        //    penaltytv4.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes4.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv4.setBackgroundResource(R.drawable.buttonstyle1);

                            putts4.setEnabled(false);
                            strokes4.setEnabled(false);
                        //    penalty4.setEnabled(false);
                            counter4 = false;
                            savescore4.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore4.setText("Edit");
                            holeselected++;
                            submitscore = true;

                            App_Common.getInstance(getActivity()).setHolescore4(detailscore4);


                            // new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        putts4.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv4.setBackgroundResource(R.drawable.buttonstyle);
                    //    penalty4.setBackgroundResource(R.drawable.buttonstyle);
                    //    penaltytv4.setBackgroundResource(R.drawable.buttonstyle);
                        strokes4.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv4.setBackgroundResource(R.drawable.buttonstyle);
                        savescore4.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore4.setText("SAVE SCORE");
                        holeselected--;
                        savescore4.setTextColor(Color.parseColor("#000000"));
                        putts4.setEnabled(true);
                        strokes4.setEnabled(true);
                     //   penalty4.setEnabled(true);
                        counter4 = true;
                        App_Common.getInstance(getActivity()).setHolescore4("");
                    }
                }
            }
        });
        savescore5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                System.out.print(counter5);

                if (chkInputs5()) {

                    if (counter5 == true) {
                        int strokevalue = Integer.parseInt(strokes5.getText().toString());
                        //    int penaltyvalue = Integer.parseInt(penalty5.getText().toString());
                        int puttsvalue = Integer.parseInt(putts5.getText().toString());


                       /* if (penalty5.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty5.getText().toString());
                        }*/

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {
                            detailscore5 = "hole-5" + "," + "putts-" + putts5.getText().toString() + "," + "strock-" + strokes5.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "4";
                            //detailscore5 = detailscore;


                            putts5.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv5.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penalty5.setBackgroundResource(R.drawable.buttonstyle1);
                       //     penaltytv5.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes5.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv5.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore5.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore5.setTextColor(Color.parseColor("#000000"));
                            savescore5.setText("Edit");
                            putts5.setEnabled(false);
                            strokes5.setEnabled(false);
                         //   penalty5.setEnabled(false);
                            counter5 = false;
                            holeselected++;
                            submitscore = true;

                            App_Common.getInstance(getActivity()).setHolescore5(detailscore5);


                            //   new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        holeselected--;
                        putts5.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv5.setBackgroundResource(R.drawable.buttonstyle);
                     //   penalty5.setBackgroundResource(R.drawable.buttonstyle);
                     //   penaltytv5.setBackgroundResource(R.drawable.buttonstyle);
                        strokes5.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv5.setBackgroundResource(R.drawable.buttonstyle);
                        savescore5.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore5.setText("SAVE SCORE");
                        savescore5.setTextColor(Color.parseColor("#000000"));
                        putts5.setEnabled(true);
                        strokes5.setEnabled(true);
                       // penalty5.setEnabled(true);
                        counter5 = true;
                        App_Common.getInstance(getActivity()).setHolescore5("");
                    }
                }
            }
        });
        savescore6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (chkInputs6())

                    if (counter6 == true) {

                     /*   if (penalty6.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty6.getText().toString());
                        }*/


                        int strokevalue = Integer.parseInt(strokes6.getText().toString());
                        //  int penaltyvalue = Integer.parseInt(penalty6.getText().toString());
                        int puttsvalue = Integer.parseInt(putts6.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore5 = "hole-6" + "," + "putts-" + putts6.getText().toString() + "," + "strock-" + strokes6.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "3";
                            //detailscore6 = detailscore;
                            putts6.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv6.setBackgroundResource(R.drawable.buttonstyle1);
                        //    penalty6.setBackgroundResource(R.drawable.buttonstyle1);
                       //     penaltytv6.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes6.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv6.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore6.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            putts6.setEnabled(false);
                            strokes6.setEnabled(false);
                         //   penalty6.setEnabled(false);
                            counter6 = false;
                            savescore6.setText("Edit");
                            savescore6.setTextColor(Color.parseColor("#000000"));

                            App_Common.getInstance(getActivity()).setHolescore6(detailscore6);

                            holeselected++;
                            submitscore = true;
                            // new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        holeselected--;
                        putts6.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv6.setBackgroundResource(R.drawable.buttonstyle);
                       // penalty6.setBackgroundResource(R.drawable.buttonstyle);
                       // penaltytv6.setBackgroundResource(R.drawable.buttonstyle);
                        strokes6.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv6.setBackgroundResource(R.drawable.buttonstyle);
                        savescore6.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore6.setText("SAVE SCORE");
                        savescore6.setTextColor(Color.parseColor("#000000"));
                        putts6.setEnabled(true);
                        strokes6.setEnabled(true);
                      //  penalty6.setEnabled(true);
                        counter6 = true;
                        App_Common.getInstance(getActivity()).setHolescore6("");
                    }
            }

        });
        savescore7.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs7())


                {


                    if (counter7 == true) {

                       /* if (penalty7.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty7.getText().toString());
                        }
*/

                        int strokevalue = Integer.parseInt(strokes7.getText().toString());
                        //  int penaltyvalue = Integer.parseInt(penalty7.getText().toString());
                        int puttsvalue = Integer.parseInt(putts7.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore7 = "hole-7" + "," + "putts-" + putts7.getText().toString() + "," + "strock-" + strokes7.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "4";
                            //detailscore7 = detailscore;
                            putts7.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv7.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penalty7.setBackgroundResource(R.drawable.buttonstyle1);
                        //    penaltytv7.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes7.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv7.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore7.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore7.setTextColor(Color.parseColor("#000000"));
                            counter7 = false;
                            putts7.setEnabled(false);
                            strokes7.setEnabled(false);
                         //   penalty7.setEnabled(false);
                            savescore7.setText("Edit");
                            submitscore = true;
                            holeselected++;


                            App_Common.getInstance(getActivity()).setHolescore7(detailscore7);


                            //  new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        holeselected--;
                        putts7.setEnabled(true);
                        strokes7.setEnabled(true);
                     //   penalty7.setEnabled(true);
                        counter7 = true;

                        putts7.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv7.setBackgroundResource(R.drawable.buttonstyle);
                     //   penalty7.setBackgroundResource(R.drawable.buttonstyle);
                      //  penaltytv7.setBackgroundResource(R.drawable.buttonstyle);
                        strokes7.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv7.setBackgroundResource(R.drawable.buttonstyle);
                        savescore7.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore7.setText("SAVE SCORE");
                        savescore7.setTextColor(Color.parseColor("#000000"));

                        App_Common.getInstance(getActivity()).setHolescore7("");
                    }
                }
            }
        });
        savescore8.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs8()) {


                    if (counter8 == true) {

                      /*  if (penalty8.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty8.getText().toString());
                        }
*/

                        int strokevalue = Integer.parseInt(strokes8.getText().toString());
//                         penaltyvalue = Integer.parseInt(penalty8.getText().toString());
                        int puttsvalue = Integer.parseInt(putts8.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore8 = "hole-8" + "," + "putts-" + putts8.getText().toString() + "," + "strock-" + strokes8.getText().toString() + "," + "penalty-" +"" + "," + "par-" + "3";
                            //detailscore8 = detailscore;
                            putts8.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv8.setBackgroundResource(R.drawable.buttonstyle1);
                        ///    penalty8.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penaltytv8.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes8.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv8.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore8.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            holeselected++;
                            counter8 = false;
                            putts8.setEnabled(false);
                            strokes8.setEnabled(false);
                        //    penalty8.setEnabled(false);
                            savescore8.setText("Edit");
                            savescore8.setTextColor(Color.parseColor("#000000"));
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore8(detailscore8);


                            //   new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        holeselected--;
                        counter8 = true;
                        putts8.setEnabled(true);
                        strokes8.setEnabled(true);
                    //    penalty8.setEnabled(true);
                        putts8.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv8.setBackgroundResource(R.drawable.buttonstyle);
                    //    penalty8.setBackgroundResource(R.drawable.buttonstyle);
                     //   penaltytv8.setBackgroundResource(R.drawable.buttonstyle);
                        strokes8.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv8.setBackgroundResource(R.drawable.buttonstyle);
                        savescore8.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore8.setText("SAVE SCORE");
                        savescore8.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore8("");
                    }
                }
            }
        });
        savescore9.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs9()) {

                    if (counter9 == true)

                    {


                       /* if (penalty9.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty9.getText().toString());
                        }*/


                        int strokevalue = Integer.parseInt(strokes9.getText().toString());
                        //  int penaltyvalue = Integer.parseInt(penalty9.getText().toString());
                        int puttsvalue = Integer.parseInt(putts9.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore9 = "hole-9" + "," + "putts-" + putts9.getText().toString() + "," + "strock-" + strokes9.getText().toString() + "," + "penalty-" +"" + "," + "par-" + "4";
                            //detailscore9 = detailscore;
                            putts9.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv9.setBackgroundResource(R.drawable.buttonstyle1);
                           // penalty9.setBackgroundResource(R.drawable.buttonstyle1);
                           // penaltytv9.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes9.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv9.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore9.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore9.setTextColor(Color.parseColor("#000000"));
                            savescore9.setText("Edit");
                            counter9 = false;
                            putts9.setEnabled(false);
                            strokes9.setEnabled(false);
                           // penalty9.setEnabled(false);
                            holeselected++;
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore9(detailscore9);


                            // new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        counter9 = true;
                        holeselected--;
                        putts9.setEnabled(true);
                        strokes9.setEnabled(true);
                    //    penalty9.setEnabled(true);
                        putts9.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv9.setBackgroundResource(R.drawable.buttonstyle);
                     //   penalty9.setBackgroundResource(R.drawable.buttonstyle);
                      //  penaltytv9.setBackgroundResource(R.drawable.buttonstyle);
                        strokes9.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv9.setBackgroundResource(R.drawable.buttonstyle);
                        savescore9.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore9.setText("SAVE SCORE");
                        savescore9.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore9("");

                    }
                }
            }
        });


        savescore10.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs10()) {

                    if (counter10 == true)

                    {

                        /*if (penalty10.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty10.getText().toString());
                        }*/


                        int strokevalue = Integer.parseInt(strokes10.getText().toString());
                        //  int penaltyvalue = Integer.parseInt(penalty10.getText().toString());
                        int puttsvalue = Integer.parseInt(putts10.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore10 = "hole-10" + "," + "putts-" + putts10.getText().toString() + "," + "strock-" + strokes10.getText().toString() + "," + "penalty-" + ""+ "," + "par-" + "4";
                            //detailscore10 = detailscore;
                            putts10.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv10.setBackgroundResource(R.drawable.buttonstyle1);
                       //     penalty10.setBackgroundResource(R.drawable.buttonstyle1);
                        //    penaltytv10.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes10.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv10.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore10.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore10.setTextColor(Color.parseColor("#000000"));
                            savescore10.setText("Edit");
                            counter10 = false;
                            putts10.setEnabled(false);
                            strokes10.setEnabled(false);
                      //      penalty10.setEnabled(false);
                            holeselected++;
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore10(detailscore10);


                            //  new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        counter10 = true;
                        holeselected--;
                        putts10.setEnabled(true);
                        strokes10.setEnabled(true);
                    //    penalty10.setEnabled(true);
                        putts10.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv10.setBackgroundResource(R.drawable.buttonstyle);
                   //     penalty10.setBackgroundResource(R.drawable.buttonstyle);
                   //     penaltytv10.setBackgroundResource(R.drawable.buttonstyle);
                        strokes10.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv10.setBackgroundResource(R.drawable.buttonstyle);
                        savescore10.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore10.setText("SAVE SCORE");
                        savescore10.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore10("");
                    }
                }
            }
        });
        savescore11.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs11()) {

                    if (counter11 == true)

                    {

                     /*   if (penalty11.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty11.getText().toString());
                        }
*/

                        int strokevalue = Integer.parseInt(strokes11.getText().toString());
                        //  int penaltyvalue = Integer.parseInt(penalty11.getText().toString());
                        int puttsvalue = Integer.parseInt(putts11.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore11 = "hole-11" + "," + "putts-" + putts11.getText().toString() + "," + "strock-" + strokes11.getText().toString() + "," + "penalty-" +"" + "," + "par-" + "3";
                            //detailscore11 = detailscore;
                            putts11.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv11.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penalty11.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penaltytv11.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes11.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv11.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore11.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore11.setTextColor(Color.parseColor("#000000"));
                            savescore11.setText("Edit");
                            counter11 = false;
                            putts11.setEnabled(false);
                            strokes11.setEnabled(false);
                         //   penalty11.setEnabled(false);
                            holeselected++;
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore11(detailscore11);


                            //  new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        counter11 = true;
                        holeselected--;
                        putts11.setEnabled(true);
                        strokes11.setEnabled(true);
                      //  penalty11.setEnabled(true);
                        putts11.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv11.setBackgroundResource(R.drawable.buttonstyle);
                   //     penalty11.setBackgroundResource(R.drawable.buttonstyle);
                   //     penaltytv11.setBackgroundResource(R.drawable.buttonstyle);
                        strokes11.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv11.setBackgroundResource(R.drawable.buttonstyle);
                        savescore11.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore11.setText("SAVE SCORE");
                        savescore11.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore11("");
                    }
                }
            }
        });


        savescore12.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs12()) {

                    if (counter12 == true)

                    {

                       /* if (penalty12.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty12.getText().toString());
                        }*/


                        int strokevalue = Integer.parseInt(strokes12.getText().toString());
                        //  int penaltyvalue = Integer.parseInt(penalty12.getText().toString());
                        int puttsvalue = Integer.parseInt(putts12.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore12 = "hole-12" + "," + "putts-" + putts12.getText().toString() + "," + "strock-" + strokes12.getText().toString() + "," + "penalty-" +"" + "," + "par-" + "3";
                            //detailscore12 = detailscore;
                            putts12.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv12.setBackgroundResource(R.drawable.buttonstyle1);
                          //  penalty12.setBackgroundResource(R.drawable.buttonstyle1);
                          //  penaltytv12.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes12.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv12.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore12.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore12.setTextColor(Color.parseColor("#000000"));
                            savescore12.setText("Edit");
                            counter12 = false;
                            putts12.setEnabled(false);
                            strokes12.setEnabled(false);
                          //  penalty12.setEnabled(false);
                            holeselected++;
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore12(detailscore12);


                            // new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        counter12 = true;
                        holeselected--;
                        putts12.setEnabled(true);
                        strokes12.setEnabled(true);
                     //   penalty12.setEnabled(true);
                        putts12.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv12.setBackgroundResource(R.drawable.buttonstyle);
                     //   penalty12.setBackgroundResource(R.drawable.buttonstyle);
                     //   penaltytv12.setBackgroundResource(R.drawable.buttonstyle);
                        strokes12.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv12.setBackgroundResource(R.drawable.buttonstyle);
                        savescore12.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore12.setText("SAVE SCORE");
                        savescore12.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore12("");
                    }
                }
            }
        });

        savescore13.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs13()) {

                    if (counter13 == true)

                    {

                       /* if (penalty13.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty13.getText().toString());
                        }*/


                        int strokevalue = Integer.parseInt(strokes13.getText().toString());
                        // int penaltyvalue = Integer.parseInt(penalty13.getText().toString());
                        int puttsvalue = Integer.parseInt(putts13.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore13 = "hole-13" + "," + "putts-" + putts13.getText().toString() + "," + "strock-" + strokes13.getText().toString() + "," + "penalty-" +""+ "," + "par-" + "5";
                            // detailscore13 = detailscore;
                            putts13.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv13.setBackgroundResource(R.drawable.buttonstyle1);
                          //  penalty13.setBackgroundResource(R.drawable.buttonstyle1);
                          //  penaltytv13.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes13.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv13.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore13.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore13.setTextColor(Color.parseColor("#000000"));
                            savescore13.setText("Edit");
                            counter13 = false;
                            putts13.setEnabled(false);
                            strokes13.setEnabled(false);
                       //     penalty13.setEnabled(false);
                            holeselected++;
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore13(detailscore13);


                            // new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        counter13 = true;
                        holeselected--;
                        putts13.setEnabled(true);
                        strokes13.setEnabled(true);
                      //  penalty13.setEnabled(true);
                        putts13.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv13.setBackgroundResource(R.drawable.buttonstyle);
                   //     penalty13.setBackgroundResource(R.drawable.buttonstyle);
                    //    penaltytv13.setBackgroundResource(R.drawable.buttonstyle);
                        strokes13.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv13.setBackgroundResource(R.drawable.buttonstyle);
                        savescore13.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore13.setText("SAVE SCORE");
                        savescore13.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore13("");
                    }
                }
            }
        });

        savescore14.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs14()) {

                    if (counter14 == true)

                    {
                       /* if (penalty14.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty14.getText().toString());
                        }*/


                        int strokevalue = Integer.parseInt(strokes14.getText().toString());
                        // int penaltyvalue = Integer.parseInt(penalty14.getText().toString());
                        int puttsvalue = Integer.parseInt(putts14.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore14 = "hole-14" + "," + "putts-" + putts14.getText().toString() + "," + "strock-" + strokes14.getText().toString() + "," + "penalty-" + ""+ "," + "par-" + "4";
                            // detailscore14 = detailscore;
                            putts14.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv14.setBackgroundResource(R.drawable.buttonstyle1);
                          //  penalty14.setBackgroundResource(R.drawable.buttonstyle1);
                          //  penaltytv14.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes14.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv14.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore14.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore14.setTextColor(Color.parseColor("#000000"));
                            savescore14.setText("Edit");
                            counter14 = false;
                            putts14.setEnabled(false);
                            strokes14.setEnabled(false);
                         //   penalty14.setEnabled(false);
                            holeselected++;
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore14(detailscore14);


                            // new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        counter14 = true;
                        holeselected--;
                        putts14.setEnabled(true);
                        strokes14.setEnabled(true);
                      //  penalty14.setEnabled(true);
                        putts14.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv14.setBackgroundResource(R.drawable.buttonstyle);
                     //   penalty14.setBackgroundResource(R.drawable.buttonstyle);
                     //   penaltytv14.setBackgroundResource(R.drawable.buttonstyle);
                        strokes14.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv14.setBackgroundResource(R.drawable.buttonstyle);
                        savescore14.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore14.setText("SAVE SCORE");
                        savescore14.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore14("");
                    }
                }
            }
        });

        savescore15.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs15()) {

                    if (counter15 == true)

                    {

                       /* if (penalty15.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty15.getText().toString());
                        }*/


                        int strokevalue = Integer.parseInt(strokes15.getText().toString());
                        //int penaltyvalue=Integer.parseInt(penalty15.getText().toString());
                        int puttsvalue = Integer.parseInt(putts15.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore15 = "hole-15" + "," + "putts-" + putts15.getText().toString() + "," + "strock-" + strokes15.getText().toString() + "," + "penalty-" + ""+ "," + "par-" + "3";
                            // detailscore15 = detailscore;
                            putts15.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv15.setBackgroundResource(R.drawable.buttonstyle1);
                          //  penalty15.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penaltytv15.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes15.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv15.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore15.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore15.setTextColor(Color.parseColor("#000000"));
                            savescore15.setText("Edit");
                            counter15 = false;
                            putts15.setEnabled(false);
                            strokes15.setEnabled(false);
                       //     penalty15.setEnabled(false);
                            holeselected++;
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore15(detailscore15);


                            //  new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }

                    } else {
                        counter15 = true;
                        holeselected--;
                        putts15.setEnabled(true);
                        strokes15.setEnabled(true);
                     //   penalty15.setEnabled(true);
                        putts15.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv15.setBackgroundResource(R.drawable.buttonstyle);
                      //  penalty15.setBackgroundResource(R.drawable.buttonstyle);
                     //   penaltytv15.setBackgroundResource(R.drawable.buttonstyle);
                        strokes15.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv15.setBackgroundResource(R.drawable.buttonstyle);
                        savescore15.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore15.setText("SAVE SCORE");
                        savescore15.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore15("");
                    }
                }
            }
        });
        savescore16.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs16()) {

                    if (counter16 == true)

                    {
/*

                        if (penalty16.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty16.getText().toString());
                        }
*/


                        int strokevalue = Integer.parseInt(strokes16.getText().toString());
                        //  int penaltyvalue = Integer.parseInt(penalty16.getText().toString());
                        int puttsvalue = Integer.parseInt(putts16.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore16 = "hole-16" + "," + "putts-" + putts16.getText().toString() + "," + "strock-" + strokes16.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "4";
                            //detailscore16 = detailscore;
                            putts16.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv16.setBackgroundResource(R.drawable.buttonstyle1);
                           // penalty16.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penaltytv16.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes16.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv16.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore16.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore16.setTextColor(Color.parseColor("#000000"));
                            savescore16.setText("Edit");
                            counter16 = false;
                            putts16.setEnabled(false);
                            strokes16.setEnabled(false);
                       //     penalty16.setEnabled(false);
                            holeselected++;
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore16(detailscore16);


                            //  new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        counter16 = true;
                        holeselected--;
                        putts16.setEnabled(true);
                        strokes16.setEnabled(true);
                     //   penalty16.setEnabled(true);
                        putts16.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv16.setBackgroundResource(R.drawable.buttonstyle);
                       // penalty16.setBackgroundResource(R.drawable.buttonstyle);
                       // penaltytv16.setBackgroundResource(R.drawable.buttonstyle);
                        strokes16.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv16.setBackgroundResource(R.drawable.buttonstyle);
                        savescore16.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore16.setText("SAVE SCORE");
                        savescore16.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore16("");
                    }
                }
            }
        });

        savescore17.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs17()) {

                    if (counter17 == true)

                    {

                       /* if (penalty17.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty17.getText().toString());
                        }
*/

                        int strokevalue = Integer.parseInt(strokes17.getText().toString());
                        //     int penaltyvalue = Integer.parseInt(penalty17.getText().toString());
                        int puttsvalue = Integer.parseInt(putts17.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {


                            detailscore17 = "hole-17" + "," + "putts-" + putts17.getText().toString() + "," + "strock-" + strokes17.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "3";
                            // detailscore17 = detailscore;
                            putts17.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv17.setBackgroundResource(R.drawable.buttonstyle1);
                           // penalty17.setBackgroundResource(R.drawable.buttonstyle1);
                          //  penaltytv17.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes17.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv17.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore17.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore17.setTextColor(Color.parseColor("#000000"));


                            savescore17.setText("Edit");
                            counter17 = false;
                            putts17.setEnabled(false);
                            strokes17.setEnabled(false);
                         //   penalty17.setEnabled(false);
                            holeselected++;
                            submitscore = true;
                            App_Common.getInstance(getActivity()).setHolescore17(detailscore17);
                            //  new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        counter17 = true;
                        holeselected--;
                        putts17.setEnabled(true);
                        strokes17.setEnabled(true);
                      //  penalty17.setEnabled(true);
                        putts17.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv17.setBackgroundResource(R.drawable.buttonstyle);
                      //  penalty17.setBackgroundResource(R.drawable.buttonstyle);
                      //  penaltytv17.setBackgroundResource(R.drawable.buttonstyle);
                        strokes17.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv17.setBackgroundResource(R.drawable.buttonstyle);
                        savescore17.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore17.setText("SAVE SCORE");
                        savescore17.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore17("");
                    }
                }
            }
        });


        savescore18.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (chkInputs18()) {

                    if (counter18 == true)

                    {


                       /* if (penalty18.getText().toString().length() == 0) {
                            penaltyvalue = 0;
                        } else {
                            penaltyvalue = Integer.parseInt(penalty18.getText().toString());
                        }*/


                        int strokevalue = Integer.parseInt(strokes18.getText().toString());
                        //  int penaltyvalue=Integer.parseInt(penalty18.getText().toString());
                        int puttsvalue = Integer.parseInt(putts18.getText().toString());

                        if (strokevalue > penaltyvalue + puttsvalue)

                        {
                            detailscore18 = "hole-18" + "," + "putts-" + putts18.getText().toString() + "," + "strock-" + strokes18.getText().toString() + "," + "penalty-" + "" + "," + "par-" + "4";
                            //detailscore18 = detailscore;
                            putts18.setBackgroundResource(R.drawable.buttonstyle1);
                            puttstv18.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penalty18.setBackgroundResource(R.drawable.buttonstyle1);
                         //   penaltytv18.setBackgroundResource(R.drawable.buttonstyle1);
                            strokes18.setBackgroundResource(R.drawable.buttonstyle1);
                            strokestv18.setBackgroundResource(R.drawable.buttonstyle1);
                            savescore18.setBackgroundColor(Color.parseColor("#D8D8D8"));
                            savescore18.setTextColor(Color.parseColor("#000000"));
                            savescore18.setText("Edit");
                            counter18 = false;
                            putts18.setEnabled(false);
                            strokes18.setEnabled(false);
                         //   penalty18.setEnabled(false);
                            holeselected++;
                            submitscore = true;


                            App_Common.getInstance(getActivity()).setHolescore18(detailscore18);
                            //new Addholescore().execute();
                        } else {
                            Toast.makeText(getActivity(), "Invalid entry of score", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        counter18 = true;
                        holeselected--;
                        putts18.setEnabled(true);
                        strokes18.setEnabled(true);
                       // penalty18.setEnabled(true);
                        putts18.setBackgroundResource(R.drawable.buttonstyle);
                        puttstv18.setBackgroundResource(R.drawable.buttonstyle);
                       // penalty18.setBackgroundResource(R.drawable.buttonstyle);
                       // penaltytv18.setBackgroundResource(R.drawable.buttonstyle);
                        strokes18.setBackgroundResource(R.drawable.buttonstyle);
                        strokestv18.setBackgroundResource(R.drawable.buttonstyle);
                        savescore18.setBackgroundColor(Color.parseColor("#33CC33"));
                        savescore18.setText("SAVE SCORE");
                        savescore18.setTextColor(Color.parseColor("#000000"));
                        App_Common.getInstance(getActivity()).setHolescore18("");
                    }
                }
            }
        });

        submitscorecard = (Button) view.findViewById(R.id.submitscorecard);
        submitscorecard.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (isNetworkConnected()) {
                    if (submitscore == true) {

                        statussubmitscore = true;

                        totaldeatilscore = detailscore1 + "|" + detailscore2 + "|" + detailscore3 + "|" + detailscore4 + "|" + detailscore5 +
                                "|" + detailscore6 + "|" + detailscore7 + "|" + detailscore8 + "|" + detailscore9 + "|" + detailscore10 + "|" + detailscore11 + "|" + detailscore12 + "|" + detailscore13 + "|" + detailscore14 +
                                "|" + detailscore15 + "|" + detailscore16 + "|" + detailscore17 + "|" + detailscore18;
                        //App_Common.getInstance(getActivity()).setTotalDetailScore(totaldeatilscore);
                        totalclick = true;

//-------------------------------------------new code-------------------------------------------------------------------

                        puttts1 = putts1.getText().toString();
                        puttts2 = putts2.getText().toString();
                        puttts3 = putts3.getText().toString();
                        puttts4 = putts4.getText().toString();
                        puttts5 = putts5.getText().toString();
                        puttts6 = putts6.getText().toString();
                        puttts7 = putts7.getText().toString();
                        puttts8 = putts8.getText().toString();
                        puttts9 = putts9.getText().toString();
                        puttts10 = putts10.getText().toString();
                        puttts11 = putts11.getText().toString();
                        puttts12 = putts12.getText().toString();
                        puttts13 = putts13.getText().toString();
                        puttts14 = putts14.getText().toString();
                        puttts15 = putts15.getText().toString();
                        puttts16 = putts16.getText().toString();
                        puttts17 = putts17.getText().toString();
                        puttts18 = putts18.getText().toString();


                        strokess1 = strokes1.getText().toString();
                        strokess2 = strokes2.getText().toString();
                        strokess3 = strokes3.getText().toString();
                        strokess4 = strokes4.getText().toString();
                        strokess5 = strokes5.getText().toString();
                        strokess6 = strokes6.getText().toString();
                        strokess7 = strokes7.getText().toString();
                        strokess8 = strokes8.getText().toString();
                        strokess9 = strokes9.getText().toString();
                        strokess10 = strokes10.getText().toString();
                        strokess11 = strokes11.getText().toString();
                        strokess12 = strokes12.getText().toString();
                        strokess13 = strokes13.getText().toString();
                        strokess14 = strokes14.getText().toString();
                        strokess15 = strokes15.getText().toString();
                        strokess16 = strokes16.getText().toString();
                        strokess17 = strokes17.getText().toString();
                        strokess18 = strokes18.getText().toString();

                        try {
                            totalnumberofputts = Integer.parseInt((puttts1 + puttts2 + puttts3 + puttts4 + puttts5 + puttts6 + puttts7 + puttts8 + puttts9 +
                                    puttts10 + puttts11 + puttts12 + puttts13 + puttts14 + puttts15 + puttts16 + puttts17 + puttts18));
                        } catch (NumberFormatException ee) {

                        }
                        App_Common.getInstance(getActivity()).setTotalPuts(Long.toString(totalnumberofputts));
                        try {

                            totalnumberofstroke = Integer.parseInt(strokess1 + strokess2 + strokess3 + strokess4 + strokess5 + strokess6 + strokess7 + strokess8 +
                                    strokess9 + strokess10 + strokess11 + strokess12 + strokess13 + strokess14 + strokess15 + strokess16 + strokess17 + strokess18);
                        } catch (NumberFormatException ee) {

                        }

                        // App_Common.getInstance(getActivity()).setTotalStrokes(totalnumberofstrokes);
//---------------------------------------------------------------------------------------------------------------------------

                        new Addholescore().execute();

                        cleardata();

                    } else {
                        Toast.makeText(getActivity(), "Please enter the score", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please check internet connection", Toast.LENGTH_LONG).show();
                }

            }

        });

        startnewround = (Button) view.findViewById(R.id.newroundstart);
        startnewround.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                cleardata();

            }
        });
        if (!_areLecturesLoaded) {
            timeslection();
            //F new Getholescore().execute();
        }

        Log.i("Value of ", Boolean.toString(counter7));


        return view;
    }


    public void timeslection() {
        SimpleDateFormat input = new SimpleDateFormat("hh:mm a");
        Date dt;
        if (App_Common.getInstance(getActivity()).getTimeselected() == null) {
            //Toast.makeText(getActivity(), "Please select the time", Toast.LENGTH_LONG).show();
        } else {

            String timeslected = App_Common.getInstance(getActivity()).getTimeselected();
            Log.i("timeslected", timeslected);

            stime = timeslected;


        }
    }


    boolean chkInputs1() {

        if (lisEditTexts1.isEmpty()) {
            lisEditTexts1.add(putts1);
            lisEditTexts1.add(strokes1);
        }

        for (EditText editText : lisEditTexts1) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }


        }
        return true;
    }

    public static Submitscore newInstance(String text) {

        Submitscore f = new Submitscore();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    public class Addholescore extends AsyncTask<String, Void, Boolean> {

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


               /* totaldeatilscore = detailscore1 + "|" + detailscore2 + "|" + detailscore3 + "|" + detailscore4 + "|" + detailscore5 + "|" + detailscore6 + "|" + detailscore7 + "|" + detailscore8 + "|" + detailscore9+"|"+detailscore10 + "|" + detailscore11 + "|" + detailscore12 + "|" + detailscore13 + "|" + detailscore14 + "|" + detailscore15 + "|" + detailscore16 + "|" + detailscore17 + "|" + detailscore18;
                App_Common.getInstance(getActivity()).setTotalDetailScore(totaldeatilscore);*/
                String totalDetailScores = totaldeatilscore;


                jsonObject.accumulate("userId", App_Common.getInstance(getActivity()).getUserID());
                if (totalclick == true) {
                    jsonObject.accumulate("detailScore", totalDetailScores);
                    jsonObject.accumulate("scoreDate", strDate/*App_Common.getInstance(getActivity()).getDateselected()*/);
                    try {
                        jsonObject.accumulate("stime", stime);
                    } catch (Exception e) {

                    }

                    jsonObject.accumulate("status", Boolean.toString(statussubmitscore));
                } else {
                    jsonObject.accumulate("detailScore", totalDetailScores);
                    jsonObject.accumulate("scoreDate", strDate/*App_Common.getInstance(getActivity()).getDateselected()*/);
                    jsonObject.accumulate("holes", hole);
                    try {
                        jsonObject.accumulate("stime", stime);
                    } catch (Exception e) {

                    }

                    jsonObject.accumulate("status", Boolean.toString(statussubmitscore));
                }


                //  jsonObject.accumulate("scoreDate", /*strDate*/"abc");
                Log.i("Detailscore", totalDetailScores);

                Log.i("Input", jsonObject.toString());

                String response = WebService.POST(App_Common.WebServiceUrl + "addHolesScore", jsonObject.toString());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("status");
                    if (status.contains("Error")) {
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
                Intent i = new Intent(getActivity(), Submitscorecard2.class);
                i.putExtra("time", stime);
                startActivity(i);

/*                stime="";
                strDate="";
                detailscore = "";
                detailscore1 = "";
                detailscore2 = "";
                detailscore3 = "";
                detailscore4 = "";
                detailscore5 = "";
                detailscore6 = "";
                detailscore7 = "";
                detailscore8 = "";
                detailscore9 = "";
                detailscore10 = "";
                detailscore11 = "";
                detailscore12 = "";
                detailscore13 = "";
                detailscore14 = "";
                detailscore15 = "";
                detailscore16 = "";
                detailscore17 = "";
                detailscore18 = "";
                totaldeatilscore=null;*/
            } else {

            }
        }
    }

    public void cleardata() {
        putts1.setBackgroundResource(R.drawable.buttonstyle);
        puttstv1.setBackgroundResource(R.drawable.buttonstyle);
      //  penalty1.setBackgroundResource(R.drawable.buttonstyle);
      //  penaltytv1.setBackgroundResource(R.drawable.buttonstyle);
        strokes1.setBackgroundResource(R.drawable.buttonstyle);
        strokestv1.setBackgroundResource(R.drawable.buttonstyle);
        savescore1.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore1.setText("SAVE SCORE");

        savescore1.setTextColor(Color.parseColor("#000000"));
        putts1.setText("");
        strokes1.setText("");
     //   penalty1.setText("");
        detailscore1 = null;


        putts2.setBackgroundResource(R.drawable.buttonstyle);
        puttstv2.setBackgroundResource(R.drawable.buttonstyle);
      //  penalty2.setBackgroundResource(R.drawable.buttonstyle);
     //   penaltytv2.setBackgroundResource(R.drawable.buttonstyle);
        strokes2.setBackgroundResource(R.drawable.buttonstyle);
        strokestv2.setBackgroundResource(R.drawable.buttonstyle);
        savescore2.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore2.setText("SAVE SCORE");

        savescore2.setTextColor(Color.parseColor("#000000"));
        putts2.setText("");
        strokes2.setText("");
     //   penalty2.setText("");
        detailscore2 = null;

        putts3.setBackgroundResource(R.drawable.buttonstyle);
        puttstv3.setBackgroundResource(R.drawable.buttonstyle);
     //   penalty3.setBackgroundResource(R.drawable.buttonstyle);
     //   penaltytv3.setBackgroundResource(R.drawable.buttonstyle);
        strokes3.setBackgroundResource(R.drawable.buttonstyle);
        strokestv3.setBackgroundResource(R.drawable.buttonstyle);
        savescore3.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore3.setText("SAVE SCORE");

        savescore3.setTextColor(Color.parseColor("#000000"));
        putts3.setText("");
        strokes3.setText("");
      //  penalty3.setText("");
        detailscore3 = null;

        putts4.setBackgroundResource(R.drawable.buttonstyle);
        puttstv4.setBackgroundResource(R.drawable.buttonstyle);
      //  penalty4.setBackgroundResource(R.drawable.buttonstyle);
      //  penaltytv4.setBackgroundResource(R.drawable.buttonstyle);
        strokes4.setBackgroundResource(R.drawable.buttonstyle);
        strokestv4.setBackgroundResource(R.drawable.buttonstyle);
        savescore4.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore4.setText("SAVE SCORE");

        savescore4.setTextColor(Color.parseColor("#000000"));
        putts4.setText("");
        strokes4.setText("");
     //   penalty4.setText("");
        detailscore4 = null;

        putts5.setBackgroundResource(R.drawable.buttonstyle);
        puttstv5.setBackgroundResource(R.drawable.buttonstyle);
      //  penalty5.setBackgroundResource(R.drawable.buttonstyle);
     //   penaltytv5.setBackgroundResource(R.drawable.buttonstyle);
        strokes5.setBackgroundResource(R.drawable.buttonstyle);
        strokestv5.setBackgroundResource(R.drawable.buttonstyle);
        savescore5.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore5.setText("SAVE SCORE");

        savescore5.setTextColor(Color.parseColor("#000000"));
        putts5.setText("");
        strokes5.setText("");
    //    penalty5.setText("");
        detailscore5 = null;

        putts6.setBackgroundResource(R.drawable.buttonstyle);
        puttstv6.setBackgroundResource(R.drawable.buttonstyle);
    //    penalty6.setBackgroundResource(R.drawable.buttonstyle);
    //    penaltytv6.setBackgroundResource(R.drawable.buttonstyle);
        strokes6.setBackgroundResource(R.drawable.buttonstyle);
        strokestv6.setBackgroundResource(R.drawable.buttonstyle);
        savescore6.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore6.setText("SAVE SCORE");
        detailscore6 = null;
        savescore6.setTextColor(Color.parseColor("#000000"));
        putts6.setText("");
        strokes6.setText("");
      //  penalty6.setText("");

        putts7.setBackgroundResource(R.drawable.buttonstyle);
        puttstv7.setBackgroundResource(R.drawable.buttonstyle);
    //    penalty7.setBackgroundResource(R.drawable.buttonstyle);
    //    penaltytv7.setBackgroundResource(R.drawable.buttonstyle);
        strokes7.setBackgroundResource(R.drawable.buttonstyle);
        strokestv7.setBackgroundResource(R.drawable.buttonstyle);
        savescore7.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore7.setText("SAVE SCORE");

        savescore7.setTextColor(Color.parseColor("#000000"));
        putts7.setText("");
        strokes7.setText("");
     //   penalty7.setText("");
        detailscore7 = null;

        putts8.setBackgroundResource(R.drawable.buttonstyle);
        puttstv8.setBackgroundResource(R.drawable.buttonstyle);
    //    penalty8.setBackgroundResource(R.drawable.buttonstyle);
    //    penaltytv8.setBackgroundResource(R.drawable.buttonstyle);
        strokes8.setBackgroundResource(R.drawable.buttonstyle);
        strokestv8.setBackgroundResource(R.drawable.buttonstyle);
        savescore8.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore8.setText("SAVE SCORE");

        savescore8.setTextColor(Color.parseColor("#000000"));
        putts8.setText("");
        strokes8.setText("");
     //   penalty8.setText("");
        detailscore8 = null;

        putts9.setBackgroundResource(R.drawable.buttonstyle);
        puttstv9.setBackgroundResource(R.drawable.buttonstyle);
     //   penalty9.setBackgroundResource(R.drawable.buttonstyle);
     //   penaltytv9.setBackgroundResource(R.drawable.buttonstyle);
        strokes9.setBackgroundResource(R.drawable.buttonstyle);
        strokestv9.setBackgroundResource(R.drawable.buttonstyle);
        savescore9.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore9.setText("SAVE SCORE");

        savescore9.setTextColor(Color.parseColor("#000000"));
        putts9.setText("");
        strokes9.setText("");
     //   penalty9.setText("");
        detailscore9 = null;
        putts10.setBackgroundResource(R.drawable.buttonstyle);
        puttstv10.setBackgroundResource(R.drawable.buttonstyle);
    //    penalty10.setBackgroundResource(R.drawable.buttonstyle);
     //   penaltytv10.setBackgroundResource(R.drawable.buttonstyle);
        strokes10.setBackgroundResource(R.drawable.buttonstyle);
        strokestv10.setBackgroundResource(R.drawable.buttonstyle);
        savescore10.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore10.setText("SAVE SCORE");

        savescore10.setTextColor(Color.parseColor("#000000"));
        putts10.setText("");
        strokes10.setText("");
      //  penalty10.setText("");
        detailscore10 = null;

        putts11.setBackgroundResource(R.drawable.buttonstyle);
        puttstv11.setBackgroundResource(R.drawable.buttonstyle);
     //   penalty11.setBackgroundResource(R.drawable.buttonstyle);
     //   penaltytv11.setBackgroundResource(R.drawable.buttonstyle);
        strokes11.setBackgroundResource(R.drawable.buttonstyle);
        strokestv11.setBackgroundResource(R.drawable.buttonstyle);
        savescore11.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore11.setText("SAVE SCORE");

        savescore11.setTextColor(Color.parseColor("#000000"));
        putts11.setText("");
        strokes11.setText("");
       // penalty11.setText("");
        detailscore11 = null;
        putts12.setBackgroundResource(R.drawable.buttonstyle);
        puttstv12.setBackgroundResource(R.drawable.buttonstyle);
       // penalty12.setBackgroundResource(R.drawable.buttonstyle);
       // penaltytv12.setBackgroundResource(R.drawable.buttonstyle);
        strokes12.setBackgroundResource(R.drawable.buttonstyle);
        strokestv12.setBackgroundResource(R.drawable.buttonstyle);
        savescore12.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore12.setText("SAVE SCORE");

        savescore12.setTextColor(Color.parseColor("#000000"));
        putts12.setText("");
        strokes12.setText("");
      //  penalty12.setText("");
        detailscore12 = null;
        putts13.setBackgroundResource(R.drawable.buttonstyle);
        puttstv13.setBackgroundResource(R.drawable.buttonstyle);
       // penalty13.setBackgroundResource(R.drawable.buttonstyle);
       // penaltytv13.setBackgroundResource(R.drawable.buttonstyle);
        strokes13.setBackgroundResource(R.drawable.buttonstyle);
        strokestv13.setBackgroundResource(R.drawable.buttonstyle);
        savescore13.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore13.setText("SAVE SCORE");

        savescore13.setTextColor(Color.parseColor("#000000"));
        putts13.setText("");
        strokes13.setText("");
     //   penalty13.setText("");
        detailscore13 = null;
        putts14.setBackgroundResource(R.drawable.buttonstyle);
        puttstv14.setBackgroundResource(R.drawable.buttonstyle);
       // penalty14.setBackgroundResource(R.drawable.buttonstyle);
       // penaltytv14.setBackgroundResource(R.drawable.buttonstyle);
        strokes14.setBackgroundResource(R.drawable.buttonstyle);
        strokestv14.setBackgroundResource(R.drawable.buttonstyle);
        savescore14.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore14.setText("SAVE SCORE");

        savescore14.setTextColor(Color.parseColor("#000000"));
        putts14.setText("");
        strokes14.setText("");
      //  penalty14.setText("");
        detailscore14 = null;

        putts15.setBackgroundResource(R.drawable.buttonstyle);
        puttstv15.setBackgroundResource(R.drawable.buttonstyle);
       // penalty15.setBackgroundResource(R.drawable.buttonstyle);
       // penaltytv15.setBackgroundResource(R.drawable.buttonstyle);
        strokes15.setBackgroundResource(R.drawable.buttonstyle);
        strokestv15.setBackgroundResource(R.drawable.buttonstyle);
        savescore15.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore15.setText("SAVE SCORE");

        savescore15.setTextColor(Color.parseColor("#000000"));
        putts15.setText("");
        strokes15.setText("");
    //    penalty15.setText("");
        detailscore15 = null;

        putts16.setBackgroundResource(R.drawable.buttonstyle);
        puttstv16.setBackgroundResource(R.drawable.buttonstyle);
      //  penalty16.setBackgroundResource(R.drawable.buttonstyle);
      //  penaltytv16.setBackgroundResource(R.drawable.buttonstyle);
        strokes16.setBackgroundResource(R.drawable.buttonstyle);
        strokestv16.setBackgroundResource(R.drawable.buttonstyle);
        savescore16.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore16.setText("SAVE SCORE");

        savescore16.setTextColor(Color.parseColor("#000000"));
        putts16.setText("");
        strokes16.setText("");
      //  penalty16.setText("");
        detailscore16 = null;

        putts17.setBackgroundResource(R.drawable.buttonstyle);
        puttstv17.setBackgroundResource(R.drawable.buttonstyle);
      //  penalty17.setBackgroundResource(R.drawable.buttonstyle);
      //  penaltytv17.setBackgroundResource(R.drawable.buttonstyle);
        strokes17.setBackgroundResource(R.drawable.buttonstyle);
        strokestv17.setBackgroundResource(R.drawable.buttonstyle);
        savescore17.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore17.setText("SAVE SCORE");

        savescore17.setTextColor(Color.parseColor("#000000"));
        putts17.setText("");
        strokes17.setText("");
      //  penalty17.setText("");
        detailscore17 = null;
        startnewround.setBackgroundColor(Color.parseColor("#33CC33"));

        putts18.setBackgroundResource(R.drawable.buttonstyle);
        puttstv18.setBackgroundResource(R.drawable.buttonstyle);
      //  penalty18.setBackgroundResource(R.drawable.buttonstyle);
       // penaltytv18.setBackgroundResource(R.drawable.buttonstyle);
        strokes18.setBackgroundResource(R.drawable.buttonstyle);
        strokestv18.setBackgroundResource(R.drawable.buttonstyle);
        savescore18.setBackgroundColor(Color.parseColor("#33CC33"));
        savescore18.setText("SAVE SCORE");

        savescore18.setTextColor(Color.parseColor("#000000"));
        putts18.setText("");
        strokes18.setText("");
      //  penalty18.setText("");
        detailscore18 = null;
        putts1.setEnabled(true);
        strokes1.setEnabled(true);
     //   penalty1.setEnabled(true);

        putts2.setEnabled(true);
        strokes2.setEnabled(true);
   //     penalty2.setEnabled(true);


        putts3.setEnabled(true);
        strokes3.setEnabled(true);
      //  penalty3.setEnabled(true);

        putts4.setEnabled(true);
        strokes4.setEnabled(true);
     //   penalty4.setEnabled(true);

        putts5.setEnabled(true);
        strokes5.setEnabled(true);
     //   penalty5.setEnabled(true);

        putts6.setEnabled(true);
        strokes6.setEnabled(true);
    //    penalty6.setEnabled(true);

        putts7.setEnabled(true);
        strokes7.setEnabled(true);
      //  penalty7.setEnabled(true);

        putts8.setEnabled(true);
        strokes8.setEnabled(true);
     //   penalty8.setEnabled(true);

        putts9.setEnabled(true);
        strokes9.setEnabled(true);
     //   penalty9.setEnabled(true);

        putts10.setEnabled(true);
        strokes10.setEnabled(true);
     //   penalty10.setEnabled(true);


        putts11.setEnabled(true);
        strokes11.setEnabled(true);
      //  penalty11.setEnabled(true);

        putts12.setEnabled(true);
        strokes12.setEnabled(true);
      //  penalty12.setEnabled(true);

        putts13.setEnabled(true);
        strokes13.setEnabled(true);
    //    penalty13.setEnabled(true);

        putts14.setEnabled(true);
        strokes14.setEnabled(true);
     //   penalty14.setEnabled(true);


        putts15.setEnabled(true);
        strokes15.setEnabled(true);
     //   penalty15.setEnabled(true);


        putts16.setEnabled(true);
        strokes16.setEnabled(true);
     //   penalty16.setEnabled(true);

        putts17.setEnabled(true);
        strokes17.setEnabled(true);
     //   penalty17.setEnabled(true);

        putts18.setEnabled(true);
        strokes18.setEnabled(true);
    //    penalty18.setEnabled(true);
        counter1 = true;
        counter2 = true;
        counter3 = true;
        counter4 = true;
        counter5 = true;
        counter6 = true;
        counter7 = true;
        counter8 = true;
        counter9 = true;

        counter10 = true;
        counter11 = true;
        counter12 = true;
        counter13 = true;
        counter14 = true;
        counter15 = true;
        counter16 = true;
        counter17 = true;
        counter18 = true;
        submitscore = false;
    }

    boolean chkInputs2() {

        if (lisEditTexts2.isEmpty()) {
            lisEditTexts2.add(putts2);
            lisEditTexts2.add(strokes2);


        }

        for (EditText editText : lisEditTexts2) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs3() {

        if (lisEditTexts3.isEmpty()) {
            lisEditTexts3.add(putts3);
            lisEditTexts3.add(strokes3);


        }

        for (EditText editText : lisEditTexts3) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs4() {

        if (lisEditTexts4.isEmpty()) {
            lisEditTexts4.add(putts4);
            lisEditTexts4.add(strokes4);


        }

        for (EditText editText : lisEditTexts4) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs5() {

        if (lisEditTexts5.isEmpty()) {
            lisEditTexts5.add(putts5);
            lisEditTexts5.add(strokes5);


        }

        for (EditText editText : lisEditTexts5) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs6() {

        if (lisEditTexts6.isEmpty()) {
            lisEditTexts6.add(putts6);
            lisEditTexts6.add(strokes6);


        }

        for (EditText editText : lisEditTexts6) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs7() {

        if (lisEditTexts7.isEmpty()) {
            lisEditTexts7.add(putts7);
            lisEditTexts7.add(strokes7);


        }

        for (EditText editText : lisEditTexts7) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs8() {

        if (lisEditTexts8.isEmpty()) {
            lisEditTexts8.add(putts8);
            lisEditTexts8.add(strokes8);


        }

        for (EditText editText : lisEditTexts8) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs9() {

        if (lisEditTexts9.isEmpty()) {
            lisEditTexts9.add(putts9);
            lisEditTexts9.add(strokes9);


        }

        for (EditText editText : lisEditTexts9) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs10() {

        if (lisEditTexts10.isEmpty()) {
            lisEditTexts10.add(putts10);
            lisEditTexts10.add(strokes10);


        }

        for (EditText editText : lisEditTexts10) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs11() {

        if (lisEditTexts11.isEmpty()) {
            lisEditTexts11.add(putts11);
            lisEditTexts11.add(strokes11);


        }

        for (EditText editText : lisEditTexts11) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs12() {

        if (lisEditTexts12.isEmpty()) {
            lisEditTexts12.add(putts12);
            lisEditTexts12.add(strokes12);


        }

        for (EditText editText : lisEditTexts12) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs13() {

        if (lisEditTexts13.isEmpty()) {
            lisEditTexts13.add(putts13);
            lisEditTexts13.add(strokes13);


        }

        for (EditText editText : lisEditTexts13) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs14() {

        if (lisEditTexts14.isEmpty()) {
            lisEditTexts14.add(putts14);
            lisEditTexts14.add(strokes14);


        }

        for (EditText editText : lisEditTexts14) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs15() {

        if (lisEditTexts15.isEmpty()) {
            lisEditTexts15.add(putts15);
            lisEditTexts15.add(strokes15);


        }

        for (EditText editText : lisEditTexts15) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs16() {

        if (lisEditTexts16.isEmpty()) {
            lisEditTexts16.add(putts16);
            lisEditTexts16.add(strokes16);


        }

        for (EditText editText : lisEditTexts16) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs17() {

        if (lisEditTexts17.isEmpty()) {
            lisEditTexts17.add(putts17);
            lisEditTexts17.add(strokes17);


        }

        for (EditText editText : lisEditTexts17) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    boolean chkInputs18() {

        if (lisEditTexts18.isEmpty()) {
            lisEditTexts18.add(putts18);
            lisEditTexts18.add(strokes18);


        }

        for (EditText editText : lisEditTexts18) {

            if (editText.getText().toString().length() == 0) {
                editText.setBackgroundResource(R.drawable.buttonstyle3);
                return false;
            }

        }
        return true;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) (getActivity().getSystemService(Context.CONNECTIVITY_SERVICE));
        return cm.getActiveNetworkInfo() != null;
    }

    /*public class Getholescore extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            // ringProgressDialog = ProgressDialog.show(getActivity(), null, "Processing ... ", true);
            //  ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();


                String response = WebService.GET(App_Common.WebServiceUrl + "getHolesScoreByDate" + "/" + App_Common.getInstance(getActivity()).getUserID() + "/" + App_Common.getInstance(getActivity()).getDateselected());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);
                JSONArray jsonarray = new JSONArray(response);
                for (int k = 0; k < jsonarray.length(); k++) {
                    JSONObject jsonobject1 = jsonarray.getJSONObject(k);

                    String status = jsonobject1.getString("status");
                    if (status.contains("False")) {


                        String time = jsonobject1.getString("stime");
                        if (time.matches(stime)) {
                            JSONArray j1 = jsonobject1.getJSONArray("detailScore");
                            for (int j = 0; j < j1.length(); j++) {
                                JSONObject jsonobject2 = j1.getJSONObject(j);
                                Log.i("Par ", jsonobject2.getString("Par"));
                                Log.i("Hole no ", jsonobject2.getString("holeNo"));
                                Log.i("Penalty ", jsonobject2.getString("penality"));
                                holeno = jsonobject2.getString("holeNo");
                                if (holeno.equals("1")) {
                                    newcounter1 = true;
                                    puttts1 = jsonobject2.getString("putts");
                                    strokess1 = jsonobject2.getString("strock");
                                    penaltys1 = jsonobject2.getString("penality");

                                }
                                if (holeno.equals("2")) {
                                    newcounter2 = true;
                                    puttts2 = jsonobject2.getString("putts");
                                    strokess2 = jsonobject2.getString("strock");
                                    penaltys2 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("3")) {
                                    newcounter3 = true;
                                    puttts3 = jsonobject2.getString("putts");
                                    strokess3 = jsonobject2.getString("strock");
                                    penaltys3 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("4")) {
                                    newcounter4 = true;
                                    puttts4 = jsonobject2.getString("putts");
                                    strokess4 = jsonobject2.getString("strock");
                                    penaltys4 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("5")) {
                                    newcounter5 = true;
                                    puttts5 = jsonobject2.getString("putts");
                                    strokess5 = jsonobject2.getString("strock");
                                    penaltys5 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("6")) {
                                    newcounter6 = true;
                                    puttts6 = jsonobject2.getString("putts");
                                    strokess6 = jsonobject2.getString("strock");
                                    penaltys6 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("7")) {
                                    newcounter7 = true;
                                    puttts7 = jsonobject2.getString("putts");
                                    strokess7 = jsonobject2.getString("strock");
                                    penaltys7 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("8")) {
                                    newcounter8 = true;
                                    puttts8 = jsonobject2.getString("putts");
                                    strokess8 = jsonobject2.getString("strock");
                                    penaltys8 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("9")) {
                                    newcounter9 = true;
                                    puttts9 = jsonobject2.getString("putts");
                                    strokess9 = jsonobject2.getString("strock");
                                    penaltys9 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("10")) {
                                    newcounter10 = true;
                                    puttts10 = jsonobject2.getString("putts");
                                    strokess10 = jsonobject2.getString("strock");
                                    penaltys10 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("11")) {
                                    newcounter11 = true;
                                    puttts11 = jsonobject2.getString("putts");
                                    strokess11 = jsonobject2.getString("strock");
                                    penaltys11 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("12")) {
                                    newcounter12 = true;
                                    puttts12 = jsonobject2.getString("putts");
                                    strokess12 = jsonobject2.getString("strock");
                                    penaltys12 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("13")) {
                                    newcounter13 = true;
                                    puttts13 = jsonobject2.getString("putts");
                                    strokess13 = jsonobject2.getString("strock");
                                    penaltys13 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("14")) {
                                    newcounter14 = true;
                                    puttts14 = jsonobject2.getString("putts");
                                    strokess14 = jsonobject2.getString("strock");
                                    penaltys14 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("15")) {
                                    newcounter15 = true;
                                    puttts15 = jsonobject2.getString("putts");
                                    strokess15 = jsonobject2.getString("strock");
                                    penaltys15 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("16")) {
                                    newcounter16 = true;
                                    puttts16 = jsonobject2.getString("putts");
                                    strokess16 = jsonobject2.getString("strock");
                                    penaltys16 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("17")) {
                                    newcounter17 = true;
                                    puttts17 = jsonobject2.getString("putts");
                                    strokess17 = jsonobject2.getString("strock");
                                    penaltys17 = jsonobject2.getString("penality");
                                }
                                if (holeno.equals("18")) {
                                    newcounter18 = true;
                                    puttts18 = jsonobject2.getString("putts");
                                    strokess18 = jsonobject2.getString("strock");
                                    penaltys18 = jsonobject2.getString("penality");
                                }


                            }

                            Log.i("Holes ", jsonobject1.getString("holes"));
                        }
                    }

                }


                return true;


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            //  ringProgressDialog.dismiss();
            if (result) {
                if (newcounter1 == true) {

                    putts1.setText(puttts1);
                    strokes1.setText(strokess1);
                    penalty1.setText(penaltys1);
                    putts1.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv1.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty1.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv1.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes1.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv1.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore1.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore1.setText("Edit");
                    savescore1.setTextColor(Color.parseColor("#000000"));
                    putts1.setEnabled(false);
                    strokes1.setEnabled(false);
                    penalty1.setEnabled(false);
                    counter1 = false;
                }
                if (newcounter2 == true) {

                    putts2.setText(puttts2);
                    strokes2.setText(strokess2);
                    penalty2.setText(penaltys2);
                    putts2.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv2.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty2.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv2.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes2.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv2.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore2.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore2.setText("Edit");
                    savescore2.setTextColor(Color.parseColor("#000000"));
                    putts2.setEnabled(false);
                    strokes2.setEnabled(false);
                    penalty2.setEnabled(false);
                    counter2 = false;
                }
                if (newcounter3 == true) {

                    putts3.setText(puttts3);
                    strokes3.setText(strokess3);
                    penalty3.setText(penaltys3);
                    putts3.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv3.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty3.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv3.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes3.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv3.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore3.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore3.setText("Edit");
                    savescore3.setTextColor(Color.parseColor("#000000"));
                    putts3.setEnabled(false);
                    strokes3.setEnabled(false);
                    penalty3.setEnabled(false);
                    counter3 = false;
                }
                if (newcounter4 == true) {

                    putts4.setText(puttts4);
                    strokes4.setText(strokess4);
                    penalty4.setText(penaltys4);
                    putts4.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv4.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty4.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv4.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes4.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv4.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore4.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore4.setText("Edit");
                    savescore4.setTextColor(Color.parseColor("#000000"));
                    putts4.setEnabled(false);
                    strokes4.setEnabled(false);
                    penalty4.setEnabled(false);
                    counter4 = false;
                }
                if (newcounter5 == true) {

                    putts5.setText(puttts5);
                    strokes5.setText(strokess5);
                    penalty5.setText(penaltys5);
                    putts5.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv5.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty5.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv5.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes5.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv5.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore5.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore5.setText("Edit");
                    savescore5.setTextColor(Color.parseColor("#000000"));
                    putts5.setEnabled(false);
                    strokes5.setEnabled(false);
                    penalty5.setEnabled(false);
                    counter5 = false;
                }
                if (newcounter6 == true) {

                    putts6.setText(puttts6);
                    strokes6.setText(strokess6);
                    penalty6.setText(penaltys6);
                    putts6.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv6.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty6.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv6.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes6.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv6.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore6.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore6.setText("Edit");
                    savescore6.setTextColor(Color.parseColor("#000000"));
                    putts6.setEnabled(false);
                    strokes6.setEnabled(false);
                    penalty6.setEnabled(false);
                    counter6 = false;
                }
                if (newcounter7 == true) {

                    putts7.setText(puttts7);
                    strokes7.setText(strokess7);
                    penalty7.setText(penaltys7);
                    putts7.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv7.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty7.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv7.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes7.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv7.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore7.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore7.setText("Edit");
                    savescore7.setTextColor(Color.parseColor("#000000"));
                    putts7.setEnabled(false);
                    strokes7.setEnabled(false);
                    penalty7.setEnabled(false);
                    counter7 = false;
                }
                if (newcounter8 == true) {

                    putts8.setText(puttts8);
                    strokes8.setText(strokess8);
                    penalty8.setText(penaltys8);
                    putts8.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv8.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty8.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv8.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes8.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv8.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore8.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore8.setText("Edit");
                    savescore8.setTextColor(Color.parseColor("#000000"));
                    putts8.setEnabled(false);
                    strokes8.setEnabled(false);
                    penalty8.setEnabled(false);
                    counter8 = false;
                }
                if (newcounter9 == true) {

                    putts9.setText(puttts9);
                    strokes9.setText(strokess9);
                    penalty9.setText(penaltys9);
                    putts9.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv9.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty9.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv9.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes9.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv9.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore9.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore9.setText("Edit");
                    savescore9.setTextColor(Color.parseColor("#000000"));
                    putts9.setEnabled(false);
                    strokes9.setEnabled(false);
                    penalty9.setEnabled(false);
                    counter9 = false;
                }
                if (newcounter10 == true) {

                    putts10.setText(puttts10);
                    strokes10.setText(strokess10);
                    penalty10.setText(penaltys10);
                    putts10.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv10.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty10.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv10.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes10.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv10.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore10.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore10.setText("Edit");
                    savescore10.setTextColor(Color.parseColor("#000000"));
                    putts10.setEnabled(false);
                    strokes10.setEnabled(false);
                    penalty10.setEnabled(false);
                    counter10 = false;
                }
                if (newcounter11 == true) {

                    putts11.setText(puttts11);
                    strokes11.setText(strokess11);
                    penalty11.setText(penaltys11);
                    putts11.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv11.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty11.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv11.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes11.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv11.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore11.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore11.setText("Edit");
                    savescore11.setTextColor(Color.parseColor("#000000"));
                    putts11.setEnabled(false);
                    strokes11.setEnabled(false);
                    penalty11.setEnabled(false);
                    counter11 = false;
                }
                if (newcounter12 == true) {

                    putts12.setText(puttts12);
                    strokes12.setText(strokess12);
                    penalty12.setText(penaltys12);
                    putts12.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv12.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty12.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv12.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes12.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv12.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore12.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore12.setText("Edit");
                    savescore12.setTextColor(Color.parseColor("#000000"));
                    putts12.setEnabled(false);
                    strokes12.setEnabled(false);
                    penalty12.setEnabled(false);
                    counter12 = false;
                }

                if (newcounter13 == true) {

                    putts13.setText(puttts13);
                    strokes13.setText(strokess13);
                    penalty13.setText(penaltys13);
                    putts13.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv13.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty13.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv13.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes13.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv13.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore13.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore13.setText("Edit");
                    savescore13.setTextColor(Color.parseColor("#000000"));
                    putts13.setEnabled(false);
                    strokes13.setEnabled(false);
                    penalty13.setEnabled(false);
                    counter13 = false;
                }
                if (newcounter14 == true) {

                    putts14.setText(puttts14);
                    strokes14.setText(strokess14);
                    penalty14.setText(penaltys14);
                    putts14.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv14.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty14.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv14.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes14.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv14.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore14.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore14.setText("Edit");
                    savescore14.setTextColor(Color.parseColor("#000000"));
                    putts14.setEnabled(false);
                    strokes14.setEnabled(false);
                    penalty14.setEnabled(false);
                    counter14 = false;
                }
                if (newcounter15 == true) {

                    putts15.setText(puttts15);
                    strokes15.setText(strokess15);
                    penalty15.setText(penaltys15);
                    putts15.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv15.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty15.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv15.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes15.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv15.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore15.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore15.setText("Edit");
                    savescore15.setTextColor(Color.parseColor("#000000"));
                    putts15.setEnabled(false);
                    strokes15.setEnabled(false);
                    penalty15.setEnabled(false);
                    counter15 = false;
                }
                if (newcounter16 == true) {

                    putts16.setText(puttts16);
                    strokes16.setText(strokess16);
                    penalty16.setText(penaltys16);
                    putts16.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv16.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty16.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv16.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes16.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv16.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore16.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore16.setText("Edit");
                    savescore16.setTextColor(Color.parseColor("#000000"));
                    putts16.setEnabled(false);
                    strokes16.setEnabled(false);
                    penalty16.setEnabled(false);
                    counter16 = false;
                }
                if (newcounter17 == true) {

                    putts17.setText(puttts17);
                    strokes17.setText(strokess17);
                    penalty17.setText(penaltys17);
                    putts17.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv17.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty17.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv17.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes17.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv17.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore17.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore17.setText("Edit");
                    savescore17.setTextColor(Color.parseColor("#000000"));
                    putts17.setEnabled(false);
                    strokes17.setEnabled(false);
                    penalty17.setEnabled(false);
                    counter17 = false;
                }
                if (newcounter18 == true) {

                    putts18.setText(puttts18);
                    strokes18.setText(strokess18);
                    penalty18.setText(penaltys18);
                    putts18.setBackgroundResource(R.drawable.buttonstyle1);
                    puttstv18.setBackgroundResource(R.drawable.buttonstyle1);
                    penalty18.setBackgroundResource(R.drawable.buttonstyle1);
                    penaltytv18.setBackgroundResource(R.drawable.buttonstyle1);
                    strokes18.setBackgroundResource(R.drawable.buttonstyle1);
                    strokestv18.setBackgroundResource(R.drawable.buttonstyle1);
                    savescore18.setBackgroundColor(Color.parseColor("#D8D8D8"));
                    savescore18.setText("Edit");
                    savescore18.setTextColor(Color.parseColor("#000000"));
                    putts18.setEnabled(false);
                    strokes18.setEnabled(false);
                    penalty18.setEnabled(false);
                    counter18 = false;
                }
            } else {

            }
        }
    }*/


}
