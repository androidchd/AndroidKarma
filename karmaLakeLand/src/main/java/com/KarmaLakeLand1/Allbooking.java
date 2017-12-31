package com.KarmaLakeLand1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TreeSet;
import java.util.Vector;
import Helper.App_Common;

public class Allbooking extends FragmentActivity {
    ImageButton tv_header_title;
    SlidingTabLayout mSlidingTabLayout;

    Date d;
    String date;
    String paymentStatus;
    Vector<Completedlist> upcoming;
    TreeSet<Completedlist> completedBooking;

//    TreeSet<Completedlist> allbooking;

    ImageView favriot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allbooking);

        d = new Date();

        favriot = (ImageButton) findViewById(R.id.favriot);
        favriot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        ViewPager pager = (ViewPager) findViewById(R.id.viewPagerallbooking);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.pager_tab_strip);

        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.pressed_color));
        mSlidingTabLayout.setDistributeEvenly(true);

        mSlidingTabLayout.setViewPager(pager);
        mSlidingTabLayout.createDefaultTabView(Allbooking.this);

        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.pressed_color);    //define any color in xml resources and set it here, I have used white
            }

        });
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        private MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {

            switch (pos) {
                case 0:
                    new Allbookingapi().execute();
                    return CompletedFragment.newInstance("");
                case 1:
                    new Allbookingapi().execute();
                    return Upcomingfragment.newInstance(" ");
                case 2:
                    return ToadyBookingFragment.newInstance(" ");
                case 3:
                    return CancelledFragment.newInstance(" ");
                default:
                    return CompletedFragment.newInstance("");
            }
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {

                case 0:
                    return " Completed ";
                case 1:
                    return " Upcoming ";
                case 2:
                    return " Today's";
                case 3:
                    return "Cancelled";
                default:
                    return " Completed ";

            }
        }
    }

    private class Allbookingapi extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(Allbooking.this, null, "Retrieving your booking details... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();


                Log.i("Input", jsonObject.toString());

                String response = WebService.GET(App_Common.WebServiceUrl + "getAllBookingDetailByUserId/" + App_Common.getInstance(getApplicationContext()).getUserID());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONArray jsonarray = new JSONArray(response);

                    for (int i = 0; i < jsonarray.length(); i++) {
                        Completedlist completelist = new Completedlist();


                        paymentStatus = jsonarray.getJSONObject(i).getString("paymentStatus");


                        Date date1 = null;
                        completelist.setPlayers(jsonarray.getJSONObject(i).getString("player"));
                        completelist.setTime(jsonarray.getJSONObject(i).getString("time"));
                        completelist.setDate(jsonarray.getJSONObject(i).getString("date"));
                        completelist.setHole(jsonarray.getJSONObject(i).getString("hole"));
                        completelist.setAddOn(jsonarray.getJSONObject(i).getString("addOn"));
                        completelist.setAmount(jsonarray.getJSONObject(i).getString("amount"));
                        jsonarray.getJSONObject(i).getString("bucket");
                        date = jsonarray.getJSONObject(i).getString("date");


                        if (paymentStatus.contains("Pending")) {
                            assert false;
                            if ((!date1.after(d) || (!paymentStatus.contains("Pending")))) {
                            } else {
                                upcoming.add(completelist);

                            }
                        }

                        try {
                            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyy", Locale.ENGLISH);
                            System.out.println("Webservice date" + date);
                            date1 = format.parse(date);
                            System.out.println(date1);
                        } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }


                        for (int k = 0; k < upcoming.size(); k++) {
                            System.out.println("Upcoming is " + upcoming.get(k));
                        }
                        if (paymentStatus.contains("success")) {

                            completedBooking.add(completelist);
                        }

                        // allbooking.add(completelist);


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

            } else {

            }
        }
    }


}