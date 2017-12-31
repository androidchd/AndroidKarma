package com.KarmaLakeLand1;

import Helper.App_Common;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Bookingconfirmation1 extends FragmentActivity{
	private static final int PICK_CONTACT = 0;
	Button notifyplayers;
	Button SKIP;
	TextView players;
	TextView time;
	TextView date;
	Intent extras;

//	static ArrayList<Phonelist> contact;

	ImageButton tv_header_title;
	TextView tv_header_title_TV;
	TextView  bookingid;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookingconfirmation);
		extras=getIntent();
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore1("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore2("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore3("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore4("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore5("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore6("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore7("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore8("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore9("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore10("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore11("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore12("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore13("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore14("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore15("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore16("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore17("");
		App_Common.getInstance(Bookingconfirmation1.this).setHolescore18("");

		tv_header_title_TV=(TextView)findViewById(R.id.tv_header_title);
		bookingid=(TextView)findViewById(R.id.bookingid);
		bookingid.setText(extras.getStringExtra("Bookingid"));
		tv_header_title=(ImageButton)findViewById(R.id.favriot);
		tv_header_title.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();	
			}
		});
		players=(TextView)findViewById(R.id.players);
		players.setText(String.valueOf(EventTournaments.playerselcted));
		time=(TextView)findViewById(R.id.time);
		date=(TextView)findViewById(R.id.date);
		
		
		
       notifyplayers=(Button)findViewById(R.id.notifyplayers);
       notifyplayers.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			
           Intent intent = new Intent(Bookingconfirmation1.this,SMS1.class);
			
			startActivity(intent);
			
			
		}
	});
       
       
       
      SKIP=(Button)findViewById(R.id.SKIP);
       SKIP.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EventTournaments.eventtournament=false;
			
			Intent i = new Intent(Bookingconfirmation1.this,BookingSelection.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(i);
		}
	});
	}
	@Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
      super.onActivityResult(reqCode, resultCode, data);

      switch (reqCode) {
        case (PICK_CONTACT) :
          if (resultCode == Activity.RESULT_OK) {
            Uri contactData = data.getData();
            Cursor c =  getContentResolver().query(contactData, null, null, null, null);

            if (c.moveToFirst()) {
            	 String id =c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
            	 String hasPhone =c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                 if (hasPhone.equalsIgnoreCase("1")) {
                Cursor phones = getContentResolver().query( 
                             ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, 
                             ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ id, 
                             null, null);
                   phones.moveToFirst();
                  String  cNumber = phones.getString(phones.getColumnIndex("data1"));
//                  String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                  
                  
                  
                  try {      
              	    SmsManager smsManager = SmsManager.getDefault();
              	    
              	    smsManager.sendTextMessage(cNumber, null, "HELLO", null, null);    
              	   
              	     } catch (Exception ignored) {
              	   
              	     } 
                  
                 }
             
            
              
              
              
              
              
          
              // TODO Whatever you want to do with the selected contact name.
            }
          }
          break;
      }
    }
	
//	public String timeconversion1(String input) {
//
//		//Date/time pattern of input date
//		DateFormat df = new SimpleDateFormat("HH:mm");
//		//Date/time pattern of desired output date
//		DateFormat outputformat = new SimpleDateFormat("hh:mm a");
//		Date date;
//		String output = null;
//		try{
//			//Conversion of input String to date
//			date= df.parse(input);
//			//old date format to new date format
//			output = outputformat.format(date);
//			System.out.println(output);
//		}catch(ParseException pe){
//			pe.printStackTrace();
//		}
//		return output;
//	}
}
