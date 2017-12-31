package com.KarmaLakeLand1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

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

public class CompletedFragment extends Fragment {
	ArrayList<Completedlist> completedBooking;
	
	ListView booking_detail_list;


    @Override
	public View onCreateView(LayoutInflater inflater,
		ViewGroup container, Bundle savedInstanceState) {
			 // Inflate the layout for this fragment
	View view= inflater.inflate(R.layout.completedfragment, container, false);


	completedBooking= new ArrayList<Completedlist>();

	booking_detail_list=(ListView)view.findViewById(R.id.completedlist);
	
	new Allbookingapi().execute();
	
	return view;
	}
	
	 public static CompletedFragment newInstance(String text) {

		 CompletedFragment f = new CompletedFragment();
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
					
					JSONObject jsonObject = new JSONObject();





					Log.i("Input",jsonObject.toString());

					String response = WebService.GET(App_Common.WebServiceUrl+ "getAllBookingDetailByUserId/"+App_Common.getInstance(getActivity()).getUserID());

					Log.i(App_Common.TAG, response);
					Log.e("RESPONSE", response);

					if (response == null || response.equals("")) {
						return false;
					} 
		               
					else{
					     JSONArray jsonarray= new JSONArray(response);
					  
					     for(int i=0;i<jsonarray.length();i++)
					     {





					    String date=jsonarray.getJSONObject(i).getString("date"); 
					    	 
					 boolean b =dateupdate(date);	 
					    	 if(b==true)
					    	 { 
					    	 
					    	 Completedlist completelist= new Completedlist();


					    	String paymentStatus=jsonarray.getJSONObject(i).getString("paymentStatus");

					    //	 completelist.setPaymentStatus(paymentStatus);
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
					    
					    	 if(paymentStatus.contains("success")) {
								 completelist.setPaymentStatus("success");
								 completelist.setBookStatus("Cancel");
					    		Log.i("Paymentstatus", paymentStatus); 
					    		 completedBooking.add(completelist); 
					    	 }
					    	 
					    	 }
					    	 
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
				if (result)
				{
					CustomListAdapter c1 = new CustomListAdapter(getActivity(),completedBooking);
					
					booking_detail_list.setAdapter(c1);	
	           }
				else
				{
					
				}
			}

		}

	public boolean dateupdate(String date)
	{
		try{

     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     Calendar c = Calendar.getInstance();


     String str1 = date;
     Date date1 = formatter.parse(str1);

     String str2 = formatter.format(c.getTime());
     Date date2 = formatter.parse(str2);

     if (date1.compareTo(date2)<0)
      {
         System.out.println("date2 is Greater than my date1");
         return true;
      }
     else
     {
    	 return false;
     }

    }catch (ParseException e1){
        e1.printStackTrace();
        return false;
    }






	}

}
