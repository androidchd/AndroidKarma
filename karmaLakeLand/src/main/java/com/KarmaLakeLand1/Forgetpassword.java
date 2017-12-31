package com.KarmaLakeLand1;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import Helper.App_Common;
import Utility.WebService;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Forgetpassword  extends Activity{
	EditText emailID;
	Button Forgetpassword;
	List<EditText> lisEditTexts;
	ImageView tv_header_title;
	String emailId;
	String emailIdResult;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgetpasswrod);
		lisEditTexts = new ArrayList<EditText>();
      emailID=(EditText)findViewById(R.id.emailID);
      
    
      
      tv_header_title=(ImageView)findViewById(R.id.favriot);
		tv_header_title.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();	
			}
		});
      Forgetpassword=(Button)findViewById(R.id.Forgetpassword);
      Forgetpassword.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(chkInputs())
			{
				emailId= emailID.getText().toString().trim();
				emailIdResult =emailId.toString().replace(" ","");
			new Forgegtpaswd().execute();
			}
			else
			{
				Toast.makeText(getApplicationContext(),"Please enter the inputs", Toast.LENGTH_LONG).show();
			}
			
		}
	});
      
      
      
	}
	
	
	public class Forgegtpaswd extends AsyncTask<String, Void, Boolean> {

		protected ProgressDialog ringProgressDialog;
		


		@Override
		protected void onPreExecute()
		{
			ringProgressDialog = ProgressDialog.show(Forgetpassword.this, null, "Processing ... ", true);
			ringProgressDialog.setCancelable(false);
			super.onPreExecute();
		}

		@Override
		protected Boolean doInBackground(String... params)
		{
			String newEmail= emailId;
			try {
				/*
				JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("emailId",emailID.getText().toString());
				Log.i("Emailid", jsonObject.toString());*/
                
                
                String response = WebService.GET(App_Common.WebServiceUrl+ "getForgotPassword/"+newEmail);

				Log.i(App_Common.TAG, response);
				Log.e("RESPONSE", response);

				if (response == null || response.equals("")) {
					return false;
				} else 
				{
					JSONObject jsonresponse= new JSONObject(response);
					String status=jsonresponse.getString("status");
					
					if(status.contains("Success"))
					{

					return true;
				
					}else {
						return false;
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
				Toast.makeText(Forgetpassword.this, "Your Password has been sent to your Registered Mail ID. Don't forget to check spam. ", Toast.LENGTH_SHORT).show();
				Intent i =new Intent(Forgetpassword.this,SignIn.class);
				startActivity(i);
	        }
			else {
				buildAlertMessage();
			}
    }
	}
	public void buildAlertMessage() {
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("EmailID not valid")
				.setCancelable(false)
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {
								
								dialog.dismiss();
							
							}
						});
		final AlertDialog alert = builder.create();
		alert.show();
		
	}
	
	boolean chkInputs() {

		if (lisEditTexts.isEmpty())
		{
			lisEditTexts.add(emailID);
			
		
		}

		for (EditText editText : lisEditTexts) 
		{

			if (editText.getText().toString().length() == 0) 
			{
				editText.setError("Please Provide Valid Input.");
				return false;
			}

		}
		return true;
	}
	
}