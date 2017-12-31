package com.KarmaLakeLand1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import Helper.App_Common;
import Utility.*;

/**
 * Created by Android Developer on 3/7/2017.
 */
public class ToadyBookingFragment extends Fragment {
    static ArrayList<Completedlist> todayBooking;
    Date d;
    Date date1;
    ListView booking_detail_list;
    String paymentStatus;
    String date;
    String time;
    String bookingStatus;
    static boolean todaybooking =false;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.todaybooking, container, false);
    todayBooking = new ArrayList<Completedlist>();
    booking_detail_list = (ListView) view.findViewById(R.id.todayList);
    d = new Date();
        new Allbookingapi().execute();


    return view;
}


    public static ToadyBookingFragment newInstance(String text) {

        ToadyBookingFragment f = new ToadyBookingFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
    public class Allbookingapi extends AsyncTask<String, Void, Boolean> {

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

                String response = Utility.WebService.GET(App_Common.WebServiceUrl + "getAllBookingDetailByUserId/" + App_Common.getInstance(getActivity()).getUserID());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONArray jsonarray = new JSONArray(response);

                    if (jsonarray.length() > 0) {
                        for (int i = 0; i < jsonarray.length(); i++) {
                            Completedlist completelist = new Completedlist();


                            bookingStatus = jsonarray.getJSONObject(i).getString("bookStatus");
                            paymentStatus = jsonarray.getJSONObject(i).getString("paymentStatus");
                            //completelist.setPaymentStatus(paymentStatus);
                             // completelist.setBookStatus(bookingStatus);
                            completelist.setPlayers(jsonarray.getJSONObject(i).getString("player"));
                            completelist.setTime(jsonarray.getJSONObject(i).getString("time"));
                            completelist.setDate(jsonarray.getJSONObject(i).getString("date"));

                            completelist.setHole(jsonarray.getJSONObject(i).getString("hole"));
                            completelist.setAddOn(jsonarray.getJSONObject(i).getString("addOn"));
                            completelist.setSession(jsonarray.getJSONObject(i).getString("session"));
                            completelist.setBucket(jsonarray.getJSONObject(i).getString("bucket"));
                            completelist.setAmount(jsonarray.getJSONObject(i).getString("amount"));
                            completelist.setBookingid(jsonarray.getJSONObject(i).getString("bookId"));


                            jsonarray.getJSONObject(i).getString("bucket");
                            date = jsonarray.getJSONObject(i).getString("date");
                            time = jsonarray.getJSONObject(i).getString("time");

                            try {
                                SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
                                System.out.println("Webservice date" + date);
                                System.out.println("Today date" + d);
                                date1 = format.parse(date);

                                Calendar c = Calendar.getInstance();
                                int hours = c.get(Calendar.HOUR);
                                int mins = c.get(Calendar.MINUTE);
                                String timer = (hours + ":" + mins);

                                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                                Date EndTime = dateFormat.parse(time);
                                Date CurrentTime = dateFormat.parse(dateFormat.format(new Date()));

                                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                                Date date2 = new Date();
                               String datestr = sdf.format(date2);

                                Date date3 = sdf.parse(datestr);

                                if ((bookingStatus.contains("success")) && (paymentStatus.contains("Pending"))) {
                                    if (date3.equals(date1)) {
                                        completelist.setPaymentStatus("success");
                                        completelist.setBookStatus("Cancel");
                                        todayBooking.add(completelist);
                                    } else {

                                    }
                                } else {

                                }

                            } catch (ParseException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    } else {

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

                for (int i = 0; i < todayBooking.size(); i++) {
                    System.out.print(todayBooking.get(i));
                }
                CustomListAdapter c1 = new CustomListAdapter(getActivity(), todayBooking);
                booking_detail_list.setAdapter(c1);
            } else {

            }
        }

    }
}
