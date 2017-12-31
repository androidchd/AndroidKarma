package com.KarmaLakeLand1;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class TimeSelectionActivity  extends FragmentActivity{
	ImageButton favriot;
	TextView timeslot;
	FragmentManager fragmentManager = getFragmentManager();
	TextView tv_header_title;   
	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timeslot);
		favriot=(ImageButton)findViewById(R.id.favriot);
		favriot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		tv_header_title=(TextView)findViewById(R.id.tv_header_title);
		String value = getIntent().getExtras().getString("bucketno");
		if(value.contains("Bookingdriverange"))
		{	
			tv_header_title.setText("Book Driving Time");
		}
		TimeselectionFragment timeselectionfragment= new TimeselectionFragment();
		fragmentTransaction.add(R.id.timeslotframe, timeselectionfragment);
	    fragmentTransaction.commit();
		timeslot=(TextView)findViewById(R.id.timeslot);
		
		
		    
	}
}