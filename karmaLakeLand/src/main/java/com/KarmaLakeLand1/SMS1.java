package com.KarmaLakeLand1;

import java.util.ArrayList;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;

import Helper.App_Common;

public class SMS1 extends Activity {
    Button addcontacts;
    ImageButton favriot;
    Context context;
    Button smsButton;
//    SMS1 sms1;
    ArrayList<Contactsgettersetter> c1;
//    StringBuilder str = new StringBuilder();
    ListView phonelist;
    final public static int SEND_SMS = 101;
    public static final int PICK_CONTACT = 1;
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
            (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f);
//    Activity activityP;
//    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms1);
        c1 = new ArrayList<Contactsgettersetter>();
        phonelist = (ListView) findViewById(R.id.phonelist);
        addcontacts = (Button) findViewById(R.id.addcontacts);
        smsButton = (Button) findViewById(R.id.smssent);
        favriot = (ImageButton) findViewById(R.id.favriot);
        favriot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        addcontacts.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);

                startActivityForResult(intent, PICK_CONTACT);

            }
        });
        smsButton.setOnClickListener(
                new OnClickListener() {

            @Override
            public void onClick(View v) {
              
                if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)||(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)) {
                    int checkCallPhonePermission = ContextCompat.checkSelfPermission(SMS1.this,Manifest.permission.SEND_SMS);
                    if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(SMS1.this,new String[]{Manifest.permission.SEND_SMS}, SEND_SMS);
                        return;
                    } else {
                        for (int i = 0; i < c1.size(); i++) {
                            sendSMSMessage(c1.get(i).getNumber());
                            Intent intent1 = new Intent(SMS1.this, BookingSelection.class);
                            startActivity(intent1);
                        }

                    }
                } else {
                    for (int i = 0; i < c1.size(); i++) {
                        sendSMSMessage(c1.get(i).getNumber());
                        Intent intent1 = new Intent(SMS1.this, BookingSelection.class);
                        startActivity(intent1);
                    }

                }

            }
        });

    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        switch (reqCode) {
            case (PICK_CONTACT):
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c = getContentResolver().query(contactData, null, null, null, null);

                    if (c.moveToFirst()) {
                        String name = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String number = c.getString(c.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
//String number=c.getColumnName(c.getColumnIndex((ContactsContract.CommonDataKinds.Phone.NUMBER)));


                        adddata(name, number);


                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }

    public void adddata(final String name, final String number) {
        Contactsgettersetter contacts = new Contactsgettersetter();

        contacts.setName(name);
        contacts.setNumber(number);
        c1.add(contacts);
        NewContactAdapter contactadapter = new NewContactAdapter(SMS1.this, c1);
        phonelist.setAdapter(contactadapter);


    }

    protected void sendSMSMessage(String phonnumber) {
        // Log.i("Send SMS", phonnumber);

//        String UserName = App_Common.getInstance(SMS1.this).getUserName();
        String message = null;
        if (BookElectionFrgament.BTTtime == true) {
            message = "Hey! The tee time booking is confirmed as follows  Date -" + BookElectionFrgament.formattedDate + "\n, Time - " + BookElectionFrgament.timeselected + "\n, No. of Holes - " + BookElectionFrgament.hole + "\nSee you at Karma Lakelands! ";
        } else if (Bookingdriverange.BDRTime == true) {
            message = "Hey! The driving range booking is confirmed as follows  Date -" + Bookingdriverange.formattedDate + "\n, Time - " + Bookingdriverange.timeselected + "\n, Balls - " + Bookingdriverange.bucketselected + "\nSee you at Karma Lakelands! ";

        }

        try {
            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(phonnumber, null, message, null, null);

            //  Customdialog messagedialog= new Customdialog(SMS1.this);
            //  messagedialog.show();

            Toast.makeText(getApplicationContext(), "Your message has been sent successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case SEND_SMS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    for (int i = 0; i < c1.size(); i++) {
                        sendSMSMessage(c1.get(i).getNumber());
                        Intent intent1 = new Intent(SMS1.this, BookingSelection.class);
                        startActivity(intent1);
                    }
                } else {

                    Toast.makeText(SMS1.this, "SEND_SMS Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public class Customdialog extends Dialog implements android.view.View.OnClickListener {

//member
        public Activity c;

        final Dialog d = new Dialog(getContext());
        public Button OK;
        public Button Cancel;

        public Customdialog(Activity a) {
            super(a);
            // TODO Auto-generated constructor stub
            this.c = a;

        }
        // TODO Auto-generated constructor stub


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.messagesendpopup);
            //	d= new Dialog(getContext());

            OK = (Button) findViewById(R.id.ok);
            OK.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.ok:
                    dismiss();
                    // c.finishActivity(1);
                    Intent i = new Intent(SMS1.this, BookingSelection.class);

                    //Intent i = new Intent(Bookingconfirmation1.this,BookingSelection.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);


                    break;

            }

        }
    }
}
