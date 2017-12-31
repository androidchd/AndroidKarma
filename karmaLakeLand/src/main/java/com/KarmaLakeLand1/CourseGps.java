package com.KarmaLakeLand1;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.model.LatLng;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import Adapter.DatabaseHandler;
import Helper.App_Common;
import Helper.Colourgps;
import Helper.CourseGpsdata;
import Utility.WebService;

public abstract class CourseGps extends Fragment {
//    private static final int REQUEST_LOCATION = 0;

//    boolean statusOfGPS;
//    protected LocationManager locationManager;
    //    Location location;

    GPSTracker gps;
    double latitude;
    double longitude;

    LatLng dest;
    LatLng origin;
    Button distance;
    CourseGpsdata gpsdata;
    Colourgps colorgps;
    Button click;
    TextView nexthole;
    TextView golftext;
    TextView redyard;
    TextView blueyard;
    TextView whiteyard;
    TextView blackyard;
    Double golflatitude;
    Double golflongitude;
    DatabaseHandler db;

    ImageView previousholeicon;
    ImageView nextholeicon;

    List<CourseGpsdata> contacts;
    TextView knowthedistance;

//    HashMap<String, Colourgps> h1 = new HashMap<String, Colourgps>();
    int hit = 1;
    TextView previous;
    ImageView golfid;
    ArrayList<Colourgps> colorgpsES = new ArrayList<Colourgps>();
    ArrayList<CourseGpsdata> gpsdatas = new ArrayList<CourseGpsdata>();

    boolean _areLecturesLoaded = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !_areLecturesLoaded) {
            new Bookingdrive().execute();
            _areLecturesLoaded = true;
        } else {
            _areLecturesLoaded = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.coursegps, container, false);

        golfid = (ImageView) view.findViewById(R.id.golfid);
        db = new DatabaseHandler(getActivity());

        gps = new GPSTracker(getActivity());

        nextholeicon = (ImageView) view.findViewById(R.id.nextholeicon);
        previousholeicon = (ImageView) view.findViewById(R.id.previousholeicon);

        golftext = (TextView) view.findViewById(R.id.golftext);
        redyard = (TextView) view.findViewById(R.id.redyard);
        blueyard = (TextView) view.findViewById(R.id.blueyard);
        whiteyard = (TextView) view.findViewById(R.id.whiteyard);
        blackyard = (TextView) view.findViewById(R.id.blackyard);
        knowthedistance = (TextView) view.findViewById(R.id.knowthedistance);
        knowthedistance.setLines(3);

        previous = (TextView) view.findViewById(R.id.previous);

        previous.setVisibility(View.GONE);
        previousholeicon.setVisibility(View.GONE);

        previousholeicon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                hit--;
                if (hit == 0) {

                    previous.setVisibility(View.GONE);
                    previousholeicon.setVisibility(View.GONE);

                }
                if (hit == 1) {

                    previous.setVisibility(View.GONE);
                    previousholeicon.setVisibility(View.GONE);
                    golfid.setImageResource(R.drawable.golf);
                    //golfid.setImageResource(R.drawable.fazio_course_map);
                    golftext.setText("Hole No. " + contacts.get(0).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(0).holeNo + "</big>" + "</b>";

                    //spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString.length(), 0);

                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //  knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    blackyard.setText(contacts.get(3).getTeename());
                    blueyard.setText(contacts.get(1).getTeename());
                    whiteyard.setText(contacts.get(2).getTeename());
                    redyard.setText(contacts.get(0).getTeename());

                    distance.setText("");

                }
                if (hit == 2) {
                    golfid.setImageResource(R.drawable.fazio_course_map);
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    golftext.setText("Hole No. " + contacts.get(4).holeNo + " (Par-3)");
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(4).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(7).getTeename());
                    blueyard.setText(contacts.get(5).getTeename());
                    whiteyard.setText(contacts.get(6).getTeename());
                    redyard.setText(contacts.get(4).getTeename());

                    distance.setText("");

                }
                if (hit == 3) {

                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);

                    String str = "<b>" + "<big>" + "Hole" + contacts.get(8).holeNo + "</big>" + "</b>";
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    //golfid.setImageResource(R.drawable.fazio_course_map);
                    golfid.setImageResource(R.drawable.golf);
                    golftext.setText("Hole No. " + contacts.get(8).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(11).getTeename());
                    blueyard.setText(contacts.get(9).getTeename());
                    whiteyard.setText(contacts.get(10).getTeename());
                    redyard.setText(contacts.get(8).getTeename());

                    distance.setText("");

                }
                if (hit == 4) {
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);

                    golfid.setImageResource(R.drawable.fazio_course_map);
                    golftext.setText("Hole No. " + contacts.get(12).holeNo + " (Par-5)");

                    String str = "<b>" + "<big>" + "Hole" + contacts.get(12).holeNo + "</big>" + "</b>";
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(15).getTeename());
                    blueyard.setText(contacts.get(13).getTeename());
                    whiteyard.setText(contacts.get(14).getTeename());
                    redyard.setText(contacts.get(12).getTeename());
                    distance.setText("");

                }
                if (hit == 5) {
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    //golfid.setImageResource(R.drawable.fazio_course_map);

                    String str = "<b>" + "<big>" + "Hole" + contacts.get(16).holeNo + "</big>" + "</b>";
                    //	knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    golftext.setText("Hole No. " + contacts.get(16).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(19).getTeename());
                    blueyard.setText(contacts.get(17).getTeename());
                    whiteyard.setText(contacts.get(18).getTeename());
                    redyard.setText(contacts.get(16).getTeename());

                    distance.setText("");

                }
                if (hit == 6) {

                    String str = "<b>" + "<big>" + "Hole" + contacts.get(20).holeNo + "</big>" + "</b>";
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");

                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.fazio_course_map);
                    golftext.setText("Hole No. " + contacts.get(20).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(23).getTeename());
                    blueyard.setText(contacts.get(21).getTeename());
                    whiteyard.setText(contacts.get(22).getTeename());
                    redyard.setText(contacts.get(20).getTeename());

                    distance.setText("");

                }
                if (hit == 7) {

                    String str = "<b>" + "<big>" + "Hole" + contacts.get(24).holeNo + "</big>" + "</b>";
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    //golfid.setImageResource(R.drawable.fazio_course_map);
                    golfid.setImageResource(R.drawable.golf);
                    golftext.setText("Hole No. " + contacts.get(24).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(27).getTeename());
                    blueyard.setText(contacts.get(25).getTeename());
                    whiteyard.setText(contacts.get(26).getTeename());
                    redyard.setText(contacts.get(24).getTeename());
                    distance.setText("");

                }
                if (hit == 8) {

                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.fazio_course_map);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(28).holeNo + "</big>" + "</b>";
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);

                    golftext.setText("Hole No. " + contacts.get(28).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(31).getTeename());
                    blueyard.setText(contacts.get(29).getTeename());
                    whiteyard.setText(contacts.get(30).getTeename());
                    redyard.setText(contacts.get(28).getTeename());

                    distance.setText("");

                }
                if (hit == 9) {

                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(32).holeNo + "</big>" + "</b>";
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    golftext.setText("Hole No. " + contacts.get(32).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(35).getTeename());
                    blueyard.setText(contacts.get(33).getTeename());
                    whiteyard.setText(contacts.get(34).getTeename());
                    redyard.setText(contacts.get(32).getTeename());
                    distance.setText("");
                }
            }
        });
        previous.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                hit--;
                if (hit == 0) {
                    previous.setVisibility(View.INVISIBLE);
                    previousholeicon.setVisibility(View.INVISIBLE);
                }
                if (hit == 1) {

                    previous.setVisibility(View.GONE);
                    previousholeicon.setVisibility(View.GONE);

                    golfid.setImageResource(R.drawable.golf);

                    golftext.setText("Hole No. " + contacts.get(0).holeNo + " (Par-4)");

                    String str = "<b>" + "<big>" + "Hole" + contacts.get(0).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setTextColor(Color.parseColor("#3061e5"));

                    blackyard.setText(contacts.get(3).getTeename());
                    blueyard.setText(contacts.get(1).getTeename());
                    whiteyard.setText(contacts.get(2).getTeename());
                    redyard.setText(contacts.get(0).getTeename());

                    distance.setText("");
                }
                if (hit == 2) {
                    golfid.setImageResource(R.drawable.fazio_course_map);

                    golftext.setText("Hole No. " + contacts.get(4).holeNo + " (Par-3)");

                    String str = "<b>" + "<big>" + "Hole" + contacts.get(4).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(7).getTeename());
                    blueyard.setText(contacts.get(5).getTeename());
                    whiteyard.setText(contacts.get(6).getTeename());
                    redyard.setText(contacts.get(4).getTeename());
                    distance.setText("");

                }
                if (hit == 3) {
                    golfid.setImageResource(R.drawable.golf);

                    golftext.setText("Hole No. " + contacts.get(8).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(11).getTeename());
                    blueyard.setText(contacts.get(9).getTeename());
                    whiteyard.setText(contacts.get(10).getTeename());
                    redyard.setText(contacts.get(8).getTeename());
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(8).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    distance.setText("");

                }
                if (hit == 4) {
                    golfid.setImageResource(R.drawable.fazio_course_map);

                    golftext.setText("Hole No. " + contacts.get(12).holeNo + " (Par-5)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(15).getTeename());
                    blueyard.setText(contacts.get(13).getTeename());
                    whiteyard.setText(contacts.get(14).getTeename());
                    redyard.setText(contacts.get(12).getTeename());
                    distance.setText("");
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(12).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                }
                if (hit == 5) {
                    golfid.setImageResource(R.drawable.golf);

                    golftext.setText("Hole No. " + contacts.get(16).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(19).getTeename());
                    blueyard.setText(contacts.get(17).getTeename());
                    whiteyard.setText(contacts.get(18).getTeename());
                    redyard.setText(contacts.get(16).getTeename());

                    distance.setText("");
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(16).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");

                }
                if (hit == 6) {
                    golfid.setImageResource(R.drawable.fazio_course_map);

                    golftext.setText("Hole No. " + contacts.get(20).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(23).getTeename());
                    blueyard.setText(contacts.get(21).getTeename());
                    whiteyard.setText(contacts.get(22).getTeename());
                    redyard.setText(contacts.get(20).getTeename());
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(20).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    distance.setText("");

                }
                if (hit == 7) {
                    golfid.setImageResource(R.drawable.golf);

                    golftext.setText("Hole No. " + contacts.get(24).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(27).getTeename());
                    blueyard.setText(contacts.get(25).getTeename());
                    whiteyard.setText(contacts.get(26).getTeename());
                    redyard.setText(contacts.get(24).getTeename());
                    distance.setText("");

                    String str = "<b>" + "<big>" + "Hole" + contacts.get(24).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");

                }
                if (hit == 8) {
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);

                    golfid.setImageResource(R.drawable.fazio_course_map);

                    golftext.setText("Hole No. " + contacts.get(28).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(31).getTeename());
                    blueyard.setText(contacts.get(29).getTeename());
                    whiteyard.setText(contacts.get(30).getTeename());
                    redyard.setText(contacts.get(28).getTeename());
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(28).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    distance.setText("");

                }
                if (hit == 9) {

                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(32).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(32).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(35).getTeename());
                    blueyard.setText(contacts.get(33).getTeename());
                    whiteyard.setText(contacts.get(34).getTeename());
                    redyard.setText(contacts.get(32).getTeename());
                    distance.setText("");
                }

                System.out.println("Clicked");
            }
        });
        nextholeicon = (ImageView) view.findViewById(R.id.nextholeicon);
        nextholeicon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                hit++;
                if (hit == 0) {
                    previous.setVisibility(View.GONE);
                    previousholeicon.setVisibility(View.GONE);

                }

                if (hit == 1)

                {
                    previous.setVisibility(View.GONE);
                    previousholeicon.setVisibility(View.GONE);

                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);

                    golfid.setImageResource(R.drawable.golf);
                    golftext.setText("Hole No. " + contacts.get(0).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(0).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    blackyard.setText(contacts.get(3).getTeename());
                    blueyard.setText(contacts.get(1).getTeename());
                    whiteyard.setText(contacts.get(2).getTeename());
                    redyard.setText(contacts.get(0).getTeename());

                    distance.setText("");

                }
                if (hit == 2) {
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);

                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);

                    golfid.setImageResource(R.drawable.fazio_course_map);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(4).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(4).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(7).getTeename());
                    blueyard.setText(contacts.get(5).getTeename());
                    whiteyard.setText(contacts.get(6).getTeename());
                    redyard.setText(contacts.get(4).getTeename());
                    distance.setText("");


                }
                if (hit == 3) {

                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(8).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(8).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(11).getTeename());
                    blueyard.setText(contacts.get(9).getTeename());
                    whiteyard.setText(contacts.get(10).getTeename());
                    redyard.setText(contacts.get(8).getTeename());
                    distance.setText("");

                }

                if (hit == 4) {
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.fazio_course_map);
                    golftext.setText("Hole No. " + contacts.get(12).holeNo + " (Par-5)");
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(12).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(15).getTeename());
                    blueyard.setText(contacts.get(13).getTeename());
                    whiteyard.setText(contacts.get(14).getTeename());
                    redyard.setText(contacts.get(12).getTeename());

                    distance.setText("");
                }

                if (hit == 5) {
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(16).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(16).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(19).getTeename());
                    blueyard.setText(contacts.get(17).getTeename());
                    whiteyard.setText(contacts.get(18).getTeename());
                    redyard.setText(contacts.get(16).getTeename());
                    distance.setText("");
                }

                if (hit == 6) {

                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.fazio_course_map);
                    golftext.setText("Hole No. " + contacts.get(20).holeNo + " (Par-3)");
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(20).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(23).getTeename());
                    blueyard.setText(contacts.get(21).getTeename());
                    whiteyard.setText(contacts.get(22).getTeename());
                    redyard.setText(contacts.get(20).getTeename());
                    distance.setText("");

                }
                if (hit == 7) {
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(24).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(24).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(27).getTeename());
                    blueyard.setText(contacts.get(25).getTeename());
                    whiteyard.setText(contacts.get(26).getTeename());
                    redyard.setText(contacts.get(24).getTeename());

                    distance.setText("");
                }

                if (hit == 8) {
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.fazio_course_map);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(28).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(28).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(31).getTeename());
                    blueyard.setText(contacts.get(29).getTeename());
                    whiteyard.setText(contacts.get(30).getTeename());
                    redyard.setText(contacts.get(28).getTeename());
                    distance.setText("");

                }

                if (hit == 9) {
                    nexthole.setVisibility(View.INVISIBLE);
                    nextholeicon.setVisibility(View.INVISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    golftext.setText("Hole No. " + contacts.get(32).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(35).getTeename());
                    blueyard.setText(contacts.get(33).getTeename());
                    whiteyard.setText(contacts.get(34).getTeename());
                    redyard.setText(contacts.get(32).getTeename());
                    distance.setText("");
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(32).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                }
                if (hit == 10) {
                    nexthole.setVisibility(View.INVISIBLE);
                    nextholeicon.setVisibility(View.INVISIBLE);
                }
            }
        });
        nexthole = (TextView) view.findViewById(R.id.nexthole);
        nexthole.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                hit++;
                if (hit == 0) {

                }
                if (hit == 1)

                {
                    previous.setVisibility(View.GONE);
                    previousholeicon.setVisibility(View.GONE);
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(0).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(0).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(3).getTeename());
                    blueyard.setText(contacts.get(1).getTeename());
                    whiteyard.setText(contacts.get(2).getTeename());
                    redyard.setText(contacts.get(0).getTeename());

                    distance.setText("");

                }
                if (hit == 2) {
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.fazio_course_map);
                    golftext.setText("Hole No. " + contacts.get(4).holeNo + " (Par-3)");
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(4).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(7).getTeename());
                    blueyard.setText(contacts.get(5).getTeename());
                    whiteyard.setText(contacts.get(6).getTeename());
                    redyard.setText(contacts.get(4).getTeename());
                    distance.setText("");

                }
                if (hit == 3) {
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(8).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(8).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(11).getTeename());
                    blueyard.setText(contacts.get(9).getTeename());
                    whiteyard.setText(contacts.get(10).getTeename());
                    redyard.setText(contacts.get(8).getTeename());
                    distance.setText("");

                }
                if (hit == 4) {
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.fazio_course_map);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(12).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(12).holeNo + " (Par-5)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(15).getTeename());
                    blueyard.setText(contacts.get(13).getTeename());
                    whiteyard.setText(contacts.get(14).getTeename());
                    redyard.setText(contacts.get(12).getTeename());

                    distance.setText("");
                }
                if (hit == 5) {

                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(16).holeNo + "</big>" + "</b>";
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(16).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(19).getTeename());
                    blueyard.setText(contacts.get(17).getTeename());
                    whiteyard.setText(contacts.get(18).getTeename());
                    redyard.setText(contacts.get(16).getTeename());
                    distance.setText("");

                }
                if (hit == 6) {
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);

                    golfid.setImageResource(R.drawable.fazio_course_map);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(20).holeNo + "</big>" + "</b>";
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    golftext.setText("Hole No. " + contacts.get(20).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(23).getTeename());
                    blueyard.setText(contacts.get(21).getTeename());
                    whiteyard.setText(contacts.get(22).getTeename());
                    redyard.setText(contacts.get(20).getTeename());
                    distance.setText("");

                }
                if (hit == 7) {
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(24).holeNo + "</big>" + "</b>";
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    //knowthedistance.setText("To know the distance to the \npin"+contacts.get(24).holeNo +"from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(24).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(27).getTeename());
                    blueyard.setText(contacts.get(25).getTeename());
                    whiteyard.setText(contacts.get(26).getTeename());
                    redyard.setText(contacts.get(24).getTeename());

                    distance.setText("");

                }

                if (hit == 8) {
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    nexthole.setVisibility(View.VISIBLE);
                    nextholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.fazio_course_map);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(28).holeNo + "</big>" + "</b>";
                    //knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");

                    golftext.setText("Hole No. " + contacts.get(28).holeNo + " (Par-3)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(31).getTeename());
                    blueyard.setText(contacts.get(29).getTeename());
                    whiteyard.setText(contacts.get(30).getTeename());
                    redyard.setText(contacts.get(28).getTeename());
                    distance.setText("");

                }

                if (hit == 9) {
                    nexthole.setVisibility(View.INVISIBLE);
                    nextholeicon.setVisibility(View.INVISIBLE);
                    previous.setVisibility(View.VISIBLE);
                    previousholeicon.setVisibility(View.VISIBLE);
                    golfid.setImageResource(R.drawable.golf);
                    String str = "<b>" + "<big>" + "Hole" + contacts.get(32).holeNo + "</big>" + "</b>";
                    //	knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");
                    knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                    golftext.setText("Hole No. " + contacts.get(32).holeNo + " (Par-4)");
                    golftext.setTextColor(Color.parseColor("#3061e5"));
                    blackyard.setText(contacts.get(35).getTeename());
                    blueyard.setText(contacts.get(33).getTeename());
                    whiteyard.setText(contacts.get(34).getTeename());
                    redyard.setText(contacts.get(32).getTeename());
                    distance.setText("");
                }
                if (hit == 10) {
                    nexthole.setVisibility(View.INVISIBLE);
                    nextholeicon.setVisibility(View.INVISIBLE);
                }
                System.out.println("Clicked");
            }
        });
        distance = (Button) view.findViewById(R.id.distance);
        click = (Button) view.findViewById(R.id.clickhere);

        click.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                gps = new GPSTracker(getActivity());

                if (gps.canGetLocation()) {

                    latitude = gps.getLatitude();
                    longitude = gps.getLongitude();

                    Log.d("latitude   ", "latitude    " + latitude);
                    Log.d("longitude   ", "longitude  " + longitude);

                    origin = new LatLng(latitude, longitude);

                    if (hit == 0) {
                        gps = new GPSTracker(getActivity());
                        golflatitude = Double.parseDouble(contacts.get(0).getLatitude());

                        golflongitude = Double.parseDouble(contacts.get(0).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));

                        // \n is for new line

                    }

                    if (hit == 1) {

                        golflatitude = Double.parseDouble(contacts.get(0).getLatitude());
                        golflongitude = Double.parseDouble(contacts.get(0).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));

                    }
                    if (hit == 2) {

                        golflatitude = Double.parseDouble(contacts.get(4).getLatitude());
                        golflongitude = Double.parseDouble(contacts.get(4).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));

                    }
                    if (hit == 3) {

                        golflatitude = Double.parseDouble(contacts.get(8).getLatitude());
                        golflongitude = Double.parseDouble(contacts.get(8).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));
                    }

                    if (hit == 4) {
                        golflatitude = Double.parseDouble(contacts.get(12).getLatitude());
                        golflongitude = Double.parseDouble(contacts.get(12).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));
                    }
                    if (hit == 5) {
                        golflatitude = Double.parseDouble(contacts.get(16).getLatitude());
                        golflongitude = Double.parseDouble(contacts.get(16).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));
                    }
                    if (hit == 6) {
                        golflatitude = Double.parseDouble(contacts.get(20).getLatitude());
                        golflongitude = Double.parseDouble(contacts.get(20).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));
                    }
                    if (hit == 7) {
                        golflatitude = Double.parseDouble(contacts.get(24).getLatitude());
                        golflongitude = Double.parseDouble(contacts.get(24).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));
                    }
                    if (hit == 8) {
                        golflatitude = Double.parseDouble(contacts.get(28).getLatitude());
                        golflongitude = Double.parseDouble(contacts.get(28).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));
                    }
                    if (hit == 9) {
                        golflatitude = Double.parseDouble(contacts.get(32).getLatitude());
                        golflongitude = Double.parseDouble(contacts.get(32).getLongitude());
                        dest = new LatLng(golflatitude, golflongitude);
                        distance.setText(Double.toString(getDistance(dest, origin)));
                    }
                } else {
                    gps.showSettingsAlert();
                }
            }

        });

        if (!_areLecturesLoaded) {

            new Bookingdrive().execute();
        }
        return view;
    }

//    private void getSystemService(String locationService) {
//
//    }

    public static CourseGps newInstance(String text) {

        CourseGps f = new CourseGps() {

        };
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

    public class Bookingdrive extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


//        GPSTracker gps = new GPSTracker(getActivity());
//        double longitude = gps.getLongitude();
//        double latitude = gps.getLatitude();

        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(getActivity(), null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);

//            showSettingsAlert();
//            permission();

            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {

            try {

                JSONObject jsonObject = new JSONObject();

                Log.i("Input", jsonObject.toString());

                String response = WebService.GET(App_Common.WebServiceUrl + "getAllHolesDetail");

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONArray jsonresponse = new JSONArray(response);

                    JSONObject json = new JSONObject();
                    for (int k = 0; k < jsonresponse.length(); k++) {
                        gpsdata = new CourseGpsdata();

                        json = jsonresponse.getJSONObject(k);
                        gpsdata.setLatitude(json.getString("endPointLattitude"));
                        gpsdata.setHoleNo(json.getString("holeNo"));
                        json.getString("imageUrl");
                        gpsdata.setLongitude(json.getString("endPointLongitude"));

                        JSONArray jsonarray1 = json.getJSONArray("holesTeeYards");

                        for (int l = 0; l < jsonarray1.length(); l++) {
                            colorgps = new Colourgps();
                            JSONObject json1 = jsonarray1.getJSONObject(l);
                            gpsdata.setTeename(json1.getString("tee"));

                            gpsdata.setYards(json1.getString("yards"));
                            colorgps.setTeename(json1.getString("tee"));

                            colorgps.setYards(json1.getString("yards"));

                            colorgpsES.add(colorgps);
                            db.addContact(gpsdata);
                        }

                        gpsdatas.add(gpsdata);
                    }
                    db.close();
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
//                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {

            ringProgressDialog.dismiss();
//            showdata();
            if (result) {
                contacts = db.getAllContacts();

                String str = "<b>" + "<big>" + "Hole" + contacts.get(0).holeNo + "</big>" + "</b>";

                //spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString.length(), 0);

                knowthedistance.setText("To know the distance to\n the pin( " + Html.fromHtml(str) + " )from your current \nlocation");
                // knowthedistance.setText("To know the distance to the \npin( "+Html.fromHtml(str)+" )from your current \nlocation");

                for (CourseGpsdata cn : contacts) {

                    String log = cn.getHoleNo() + "  " + cn.getLatitude() + " " +
                            cn.getLongitude() + " " + cn.getTeename() + " " + cn.getYards();
                    // Writing Contacts to log
                    // blackyard.setText(cn.getHoleNo(1));

                    Log.d("Name: ", log

                    );
                }

                golftext.setText("Hole No. " + contacts.get(0).holeNo + " (Par-4)");
                golftext.setTextColor(Color.parseColor("#3061e5"));

                blackyard.setText(contacts.get(3).getTeename());
                blueyard.setText(contacts.get(1).getTeename());
                whiteyard.setText(contacts.get(2).getTeename());
                redyard.setText(contacts.get(0).getTeename());

            } else {

            }
        }
    }

    public double getDistance(LatLng LatLng1, LatLng LatLng2) {

        double distance;
        Location locationA = new Location("A");
        locationA.setLatitude(LatLng1.latitude);
        locationA.setLongitude(LatLng1.longitude);
        Location locationB = new Location("B");
        locationB.setLatitude(LatLng2.latitude);
        locationB.setLongitude(LatLng2.longitude);
        distance = locationA.distanceTo(locationB);
        return distance;
    }

//    public void permission() {
//        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(getActivity(),
//                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,
//                    android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
//        } else {
//            Log.e("DB", "PERMISSION GRANTED");
//        }
//    }


//    public void showdata() {
//        gps = new GPSTracker(getActivity());
//        if (gps.canGetLocation()) {
//
//            latitude = gps.getLatitude();
//            longitude = gps.getLongitude();
//
//            Log.d("latitude   ", "latitude    " + latitude);
//            Log.d("longitude   ", "longitude  " + longitude);
//
//            origin = new LatLng(latitude, longitude);
//
//            if (hit == 0) {
//                gps = new GPSTracker(getActivity());
//                golflatitude = Double.parseDouble(contacts.get(0).getLatitude());
//
//                golflongitude = Double.parseDouble(contacts.get(0).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//
//                // \n is for new line
//
//            }
//
//            if (hit == 1) {
//
//                golflatitude = Double.parseDouble(contacts.get(0).getLatitude());
//                golflongitude = Double.parseDouble(contacts.get(0).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//
//            }
//            if (hit == 2) {
//
//                golflatitude = Double.parseDouble(contacts.get(4).getLatitude());
//                golflongitude = Double.parseDouble(contacts.get(4).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//
//            }
//            if (hit == 3) {
//
//                golflatitude = Double.parseDouble(contacts.get(8).getLatitude());
//                golflongitude = Double.parseDouble(contacts.get(8).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//            }
//
//            if (hit == 4) {
//                golflatitude = Double.parseDouble(contacts.get(12).getLatitude());
//                golflongitude = Double.parseDouble(contacts.get(12).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//            }
//            if (hit == 5) {
//                golflatitude = Double.parseDouble(contacts.get(16).getLatitude());
//                golflongitude = Double.parseDouble(contacts.get(16).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//            }
//            if (hit == 6) {
//                golflatitude = Double.parseDouble(contacts.get(20).getLatitude());
//                golflongitude = Double.parseDouble(contacts.get(20).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//            }
//            if (hit == 7) {
//                golflatitude = Double.parseDouble(contacts.get(24).getLatitude());
//                golflongitude = Double.parseDouble(contacts.get(24).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//            }
//            if (hit == 8) {
//                golflatitude = Double.parseDouble(contacts.get(28).getLatitude());
//                golflongitude = Double.parseDouble(contacts.get(28).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//            }
//            if (hit == 9) {
//                golflatitude = Double.parseDouble(contacts.get(32).getLatitude());
//                golflongitude = Double.parseDouble(contacts.get(32).getLongitude());
//                dest = new LatLng(golflatitude, golflongitude);
//                distance.setText(Double.toString(getDistance(dest, origin)));
//            }
//        } else {
//            gps.showSettingsAlert();
//        }
//    }

//    public void showSettingsAlert() {
//
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
//        // Setting Dialog Title
//        alertDialog.setTitle("GPS Settings");
//        // Setting Dialog Message
//        alertDialog.setMessage("GPS is not active. Do you want to open?");
//        // On pressing Settings button
//        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                getActivity().startActivity(intent);
//            }
//        });
//        // on pressing cancel button
//        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//        // Showing Alert Message
//        alertDialog.show();
//    }

}

