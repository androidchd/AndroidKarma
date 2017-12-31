
package com.KarmaLakeLand1;

//import java.sql.Time;

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
import Utility.WebService;

public class Upcomingfragment extends Fragment {
    ListView booking_detail_list;
    static ArrayList<Completedlist> upcoming;
    String paymentStatus;
    String date;
    String time;
    String bookingStatus;
    Date d;
    Date date1;
//    Time time1;
//    Date strDate;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.upcomingfragment, container, false);
        upcoming = new ArrayList<Completedlist>();
        booking_detail_list = (ListView) view.findViewById(R.id.upcominglist);
        d = new Date();
        new Allbookingapi().execute();


        return view;
    }

    public static Upcomingfragment newInstance(String text) {

        Upcomingfragment f = new Upcomingfragment();
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

                String response = WebService.GET(App_Common.WebServiceUrl + "getAllBookingDetailByUserId/" + App_Common.getInstance(getActivity()).getUserID());

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
                            // completelist.setPaymentStatus(paymentStatus);
                            //  completelist.setBookStatus(bookingStatus);
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
                                Log.d("timer", "timer" + timer);
                                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                                Date EndTime = dateFormat.parse(time);
                                Log.d("EndTime", "EndTime" + EndTime);
                                Date CurrentTime = dateFormat.parse(dateFormat.format(new Date()));
                                Log.d("CurrentTime", "CurrentTime" + CurrentTime);
                                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                                Date date = new Date();
                                sdf.format(date);

                                if ((bookingStatus.contains("success")) && (paymentStatus.contains("Pending"))) {
                                    if (date1.after(date)) {
                                        completelist.setPaymentStatus("Pending");
                                        completelist.setBookStatus("success");
                                        upcoming.add(completelist);

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

                for (int i = 0; i < upcoming.size(); i++) {
                    System.out.print(upcoming.get(i));
                }
                CustomListAdapter c1 = new CustomListAdapter(getActivity(), upcoming);

                booking_detail_list.setAdapter(c1);
            } else {

            }
        }

    }
}


/*
package com.karmalakeland;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;

import com.karmalakeland.R;

import Helper.App_Common;
import Utility.WebService;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class Upcomingfragment extends Fragment {
	ListView booking_detail_list;
	static ArrayList<Completedlist>upcoming;
	String paymentStatus;
	String date;
	Date d;
	Date date1;
	String bookStatus;
	@Override
	public View onCreateView(LayoutInflater inflater,
		ViewGroup container, Bundle savedInstanceState) {
			 // Inflate the layout for this fragment
	View view= inflater.inflate(R.layout.upcomingfragment, container, false);
	upcoming= new ArrayList<Completedlist>();
	booking_detail_list=(ListView)view.findViewById(R.id.upcominglist);
	d = new Date();
    new Allbookingapi().execute();
	return view;
	}
	public static Upcomingfragment newInstance(String text) {

		Upcomingfragment f = new Upcomingfragment();
	        Bundle b = new Bundle();
	        b.putString("msg", text);

	        f.setArguments(b);

	        return f;
	    }
	public class Allbookingapi extends AsyncTask<String, Void, Boolean> {

		protected ProgressDialog ringProgressDialog;



		@Override
		protected void onPreExecute()
		{
			ringProgressDialog = ProgressDialog.show(getActivity(), null, "Processing ... ", true);
			ringProgressDialog.setCancelable(false);
			super.onPreExecute();
		}

		@Override
		protected Boolean doInBackground(String... params)
		{
			try {

				String response = WebService.GET(App_Common.WebServiceUrl+ "getAllBookingDetailByUserId/"+App_Common.getInstance(getActivity()).getUserID());

				Log.i(App_Common.TAG, response);
				Log.e("RESPONSE", response);

				if (response == null || response.equals("")) {
					return false;
				}

				else{
				     JSONArray jsonarray= new JSONArray(response);
					*/
/*if(jsonarray.length()>0) {*//*

						for (int i = 0; i < jsonarray.length(); i++) {

							Completedlist completelist = new Completedlist();
							bookStatus = jsonarray.getJSONObject(i).getString("bookStatus");

							paymentStatus = jsonarray.getJSONObject(i).getString("paymentStatus");
							completelist.setPaymentStatus(paymentStatus);
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
							bookStatus = jsonarray.getJSONObject(i).getString("bookStatus");
							date = jsonarray.getJSONObject(i).getString("date");

							try {
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
								System.out.println("Webservice date" + date);
								System.out.println("Today date" + d);
								date1 = format.parse(date);
//---------------------------------new code --------------------------
							*/
/* if(bookStatus=="Cancel"||bookStatus.equals("")) {
                                 return false;
							 }*//*

								//-----------------------------------------------------------
				    		*/
/* else if(date1.after(d)&&(paymentStatus.contains("Pending")))
                             {
					    		 upcoming.add(completelist);
					    		
                              }
				    		 else if(date1.equals(d)&&(paymentStatus.contains("Pending")))
					    	 {
					    		 upcoming.add(completelist);

					    	 }*//*


								if (bookStatus.contains("Cancel")) {
									//upcoming.remove(completelist);
								} else if (bookStatus.contains("success")) {
									upcoming.add(completelist);

								} else if (paymentStatus.contains("Pending")) {

									Log.i("Paymentstatus", paymentStatus);

									upcoming.add(completelist);
								}


							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

				     }
           }
			catch (Exception e) {
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

					for(int i = 0; i < upcoming.size(); i++)
					{
						System.out.print(upcoming.get(i));
					}

					CustomListAdapter c1 = new CustomListAdapter(getActivity(),upcoming);

					booking_detail_list.setAdapter(c1);
				}
				else
				{

				}
		}
		}

	private void setAdapter() {


	}
}


*/
