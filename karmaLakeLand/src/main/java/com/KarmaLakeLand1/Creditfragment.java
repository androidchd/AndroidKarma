package com.KarmaLakeLand1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;

import com.paytm.pgsdk.PaytmMerchant;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import Helper.App_Common;
import Utility.WebService;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Creditfragment extends Fragment
{
	ProgressDialog ringProgressDialog;
	Button pay;
	TextView totalefee;
	static int amount;
	String bookingid;
	static String paychecksum;
	static String verfication;
@Override
   public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup,
		Bundle savedInstanceState) {

	View rootView = inflater.inflate(R.layout.creditfragment, parentViewGroup, false);
	pay=(Button)rootView.findViewById(R.id.paysecurely);
	totalefee=(TextView)rootView.findViewById(R.id.totalefee);
	
	if(EventTournaments.eventtournament==true)
	{
		amount=EventTournaments.amountofeventtournament;
	}
	
	else if(Bookingdriverange.BDRtime==true)
	{	
	amount=Reviewbookingactivity.totalbucketcalculated-Reviewbookingactivity.couponamount;	
	}
	else if(BookElectionFrgament.bookelectiontime==true)
	{
	 amount=Addonsbooking.totalcalculated-Addonsbooking.couponamount;
	}
	totalefee.setText("Rs. "+String.valueOf(amount));
	pay.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(EventTournaments.eventtournament==true)
			{
				new Addtournamnet().execute();
			}
			else
				
			{
			new Bookingelection().execute();
			}	    
			
			onStartTransaction(v);
				
		 new Bookingelection().execute();
			
		}
	});
	return rootView;
}


public class Bookingelection extends AsyncTask<String, Void, Boolean> {

	protected ProgressDialog ringProgressDialog;
	


	@Override
	protected void onPreExecute()
	{
		ringProgressDialog = ProgressDialog.show(getActivity(), null , "Processing ... ", true);
		ringProgressDialog.setCancelable(false);
		super.onPreExecute();
	}

	@Override
	protected Boolean doInBackground(String... params)
	{
		try {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("userId", App_Common.getInstance(getActivity()).getUserID());
			 if(BookElectionFrgament.bookelectiontime==true)
			 {
		    jsonObject.accumulate("cart",String.valueOf(Addonsbooking.cartpricevalue));
		    jsonObject.accumulate("canddi",String.valueOf(Addonsbooking.caddiepricevalue));
		    jsonObject.accumulate("member",String.valueOf(BookElectionFrgament.memberplayer));
		    jsonObject.accumulate("nonmember",String.valueOf(BookElectionFrgament.nonmemberplayer));
			jsonObject.accumulate("hole", String.valueOf(BookElectionFrgament.hole));
			jsonObject.accumulate("date", String.valueOf(BookElectionFrgament.formattedDate));
			jsonObject.accumulate("time", BookElectionFrgament.timeselected);
			jsonObject.accumulate("session", "BTT");
			jsonObject.accumulate("bucket","0");
			jsonObject.accumulate("player",String.valueOf(BookElectionFrgament.playerselected));
			App_Common.getInstance(getActivity()).setDate(BookElectionFrgament.formattedDate);
			 
			 }
			 else if(Bookingdriverange.BDRtime==true)
			 {
            jsonObject.accumulate("member",String.valueOf(Bookingdriverange.memberplayer));
            jsonObject.accumulate("nonmember",String.valueOf(Bookingdriverange.nonmemberplayer));
			jsonObject.accumulate("hole","0");
			jsonObject.accumulate("date",String.valueOf(Bookingdriverange.formattedDate));
			jsonObject.accumulate("time", Bookingdriverange.timeselected);
			jsonObject.accumulate("session","BDR");
			jsonObject.accumulate("bucket",Bookingdriverange.bucketselected);
			jsonObject.accumulate("player",String.valueOf(Bookingdriverange.playerselected));
			App_Common.getInstance(getActivity()).setDate(Bookingdriverange.formattedDate);
			 }
			 
			 
			 
			 
			//jsonObject.accumulate("addOn"," ");
			jsonObject.accumulate("amount",String.valueOf(Addonsbooking.totalcalculated));
			jsonObject.accumulate("paymentMode","POC");
			jsonObject.accumulate("sessionType",Integer.toString(TimeselectionFragment.sessiontype));
			
			

			Log.i("Input",jsonObject.toString());

			String response = WebService.POST(App_Common.WebServiceUrl+ "golfBooking",jsonObject.toString());

			
			Log.e("RESPONSE", response);

			if (response == null || response.equals("")) {
				return false;
			} 
               
			else{
			JSONObject jsonresponse= new JSONObject(response);
		String status=jsonresponse.getString("bookStatus");
		if(status.contains("Error"))
		{
			return false;
		}
		else
		{
		bookingid=jsonresponse.getString("bookId");		
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
		if (result)
		{
			
			Intent i =new Intent(getActivity(),Bookingconfirmation.class);
			
			i.putExtra("Bookingid", bookingid);
			
			startActivity(i);
						
       }
		else
		{
				
		}
	}     
} 

public class Addtournamnet extends AsyncTask<String, Void, Boolean> {

	protected ProgressDialog ringProgressDialog;
	


	@Override
	protected void onPreExecute()
	{
		ringProgressDialog = ProgressDialog.show(getActivity(), null , "Processing ... ", true);
		ringProgressDialog.setCancelable(false);
		super.onPreExecute();
	}

	@Override
	protected Boolean doInBackground(String... params)
	{
		try {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("userId", App_Common.getInstance(getActivity()).getUserID());
            jsonObject.accumulate("tournamentId",EventTournaments.tournamentid);
			jsonObject.accumulate("players",EventTournaments.playerselcted ) ;
			//jsonObject.accumulate("addon"," " ) ;
			jsonObject.accumulate("amount",amount);
			jsonObject.accumulate("paymentMode","POC");
		    jsonObject.accumulate("playerdetail",EventTournaments.playerdetail);
			

			Log.i("Input",jsonObject.toString());

			String response = WebService.POST(App_Common.WebServiceUrl+ "addTournamentDetail",jsonObject.toString());

			
			Log.e("RESPONSE", response);

			if (response == null || response.equals("")) {
				return false;
			} 
               
			else{
			JSONObject jsonresponse= new JSONObject(response);
		String status=jsonresponse.getString("bookStatus");
		if(status.contains("Error"))
		{
			return false;
		}
		else
		{
			bookingid=jsonresponse.getString("bookId");	
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
		if (result)
		{
			
			Intent i =new Intent(getActivity(),Bookingconfirmation1.class);
			
			i.putExtra("Bookingid", bookingid);
			startActivity(i);
						
       }
		else
		{
				
		}
	}     
} 


public void onStartTransaction(View view) {
	
	
	PaytmPGService Service = PaytmPGService.getStagingService();
	Map<String, String> paramMap = new HashMap<String, String>();

	// these are mandatory parameters
	 Random randomGenerator = new Random();
	   int  randomInt = randomGenerator.nextInt(1000);
      
	   paramMap.put("ORDER_ID", String.valueOf(randomInt));
	
	paramMap.put("REQUEST_TYPE", "DEFAULT");
	paramMap.put("MID", "Appcen73346246512349");
	paramMap.put("CUST_ID", App_Common.getInstance(getActivity()).getUserName()+String.valueOf(randomInt));
	paramMap.put("CHANNEL_ID", "WAP");
	paramMap.put("INDUSTRY_TYPE_ID", "Retail");
	paramMap.put("WEBSITE", "Appcenwap");
	paramMap.put("TXN_AMOUNT", Integer.toString(amount));
	paramMap.put("THEME", "merchant");
	paramMap.put("EMAIL", App_Common.getInstance(getActivity()).getUserEmailId());
	paramMap.put("MOBILE_NO",App_Common.getInstance(getActivity()).getUserNumber());

    
	

	
	
	PaytmOrder Order = new PaytmOrder(paramMap);

	
    
	PaytmMerchant Merchant = new PaytmMerchant(
			
			
			"http://golf.parthinfosystems.com/GenerateChecksum.aspx",
			"http://golf.parthinfosystems.com/VerifyChecksum.aspx");


	Service.initialize(Order, Merchant, null);
	
	
	
	Service.startPaymentTransaction(getActivity(), true, true,
			new PaytmPaymentTransactionCallback() {
				@Override
				public void someUIErrorOccurred(String inErrorMessage) {
					// Some UI Error Occurred in Payment Gateway Activity.
					// // This may be due to initialization of views in
					// Payment Gateway Activity or may be due to //
					// initialization of webview. // Error Message details
					// the error occurred.
				}

				@Override
				public void onTransactionSuccess(Bundle inResponse) {
					// After successful transaction this method gets called.
					// // Response bundle contains the merchant response
					// parameters.
					Log.d("LOG", "Payment Transaction is successful " + inResponse);
					Toast.makeText(getActivity(), "Payment Transaction is successful ", Toast.LENGTH_LONG).show();
				
					if(EventTournaments.eventtournament==true)
					{
						new Addtournamnet().execute();
					}
					else
						
					{
					new Bookingelection().execute();
					}	    
				
				}

				@Override
				public void onTransactionFailure(String inErrorMessage,
						Bundle inResponse) {
					// This method gets called if transaction failed. //
					// Here in this case transaction is completed, but with
					// a failure. // Error Message describes the reason for
					// failure. // Response bundle contains the merchant
					// response parameters.
					Log.d("LOG", "Payment Transaction Failed " + inErrorMessage);
					Toast.makeText(getActivity(), "Payment Transaction Failed ", Toast.LENGTH_LONG).show();
				}

				@Override
				public void networkNotAvailable() { // If network is not
													// available, then this
													// method gets called.
				}

				@Override
				public void clientAuthenticationFailed(String inErrorMessage) {
					// This method gets called if client authentication
					// failed. // Failure may be due to following reasons //
					// 1. Server error or downtime. // 2. Server unable to
					// generate checksum or checksum response is not in
					// proper format. // 3. Server failed to authenticate
					// that client. That is value of payt_STATUS is 2. //
					// Error Message describes the reason for failure.
				}

				@Override
				public void onErrorLoadingWebPage(int iniErrorCode,
						String inErrorMessage, String inFailingUrl) {

				}

				// had to be added: NOTE
				@Override
				public void onBackPressedCancelTransaction() {
					// TODO Auto-generated method stub
				}
				
			});
}
}
