package com.KarmaLakeLand1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/*import java.util.MissingFormatArgumentException;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;*/
import Helper.App_Common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class Bookingconfirmation extends Activity {
    @SuppressWarnings("static-access")
    private static final int PICK_CONTACT = 0;
    Button notifyplayers;
    Button SKIP;
    TextView players;
    TextView time;
    TextView date;
    TextView bookingid;
    String bindParameter;
    Intent extras;
    static ArrayList<Phonelist> contact;
    ImageButton tv_header_title;
    String bookingID;
    String TO;
    String adminmail;
    String adminPwd;
    String mailSubject;
    String message;
    LinearLayout v1;
    String mPath;
    String strMobile, strUserName, strPassword, strSenderId, strMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookingconfirmation);
        extras = getIntent();
        bookingid = (TextView) findViewById(R.id.bookingid);

        v1 = (LinearLayout) findViewById(R.id.ll_booking_shot);
        bookingid.setText(extras.getStringExtra("Bookingid"));
        bookingID = extras.getStringExtra("Bookingid");
        TO = App_Common.getInstance(Bookingconfirmation.this).getUserEmailId();

        Date now = new Date();

        takeScreenshot();
        new MobileRegistration().execute();
        // mPath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyImage/");
        String screenShorts = "bookingScreen" + now + ".png";
        String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
        //screenpics = now +".jpeg";
        File filepath = new File(mPath, audioConcatPath);


        App_Common.getInstance(Bookingconfirmation.this).setHolescore1("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore2("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore3("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore4("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore5("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore6("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore7("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore8("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore9("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore10("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore11("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore12("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore13("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore14("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore15("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore16("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore17("");
        App_Common.getInstance(Bookingconfirmation.this).setHolescore18("");

        tv_header_title = (ImageButton) findViewById(R.id.favriot);
        tv_header_title.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        players = (TextView) findViewById(R.id.players);
        time = (TextView) findViewById(R.id.time);
        date = (TextView) findViewById(R.id.date);
        bookingid = (TextView) findViewById(R.id.bookingid);
        bookingid.setText(extras.getStringExtra("Bookingid"));

        if (BookElectionFrgament.bookelectiontime == true) {
            players.setText(String.valueOf(BookElectionFrgament.playerselected));
            time.setText(timeconversion1(BookElectionFrgament.timeselected));
            App_Common.getInstance(getApplicationContext()).setTimeselected(BookElectionFrgament.timeselected);
            date.setText(BookElectionFrgament.formattedDate);
        }
        if (Bookingdriverange.BDRtime == true) {
            players.setText(String.valueOf(Bookingdriverange.playerselected));
            time.setText(timeconversion1(Bookingdriverange.timeselected));
            App_Common.getInstance(getApplicationContext()).setTimeselected(Bookingdriverange.timeselected);
            date.setText(Bookingdriverange.formattedDate);
        }
        notifyplayers = (Button) findViewById(R.id.notifyplayers);
        notifyplayers.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Intent i = new Intent(Bookingconfirmation.this, Notification.class);
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);

                Intent intent1 = new Intent(Bookingconfirmation.this, SendMessagesActivity.class);
                startActivity(intent1);

                Intent intent2 = new Intent(Bookingconfirmation.this, SMS1.class);
                startActivity(intent2);


            }
        });


        SKIP = (Button) findViewById(R.id.SKIP);
        SKIP.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Bookingconfirmation.this, BookingSelection.class);

                BookElectionFrgament.timeselectedtime = false;
                BookElectionFrgament.memeberupdate = false;
                //	BookElectionFrgament.timeselectedtime=false;

                Bookingdriverange.timed = false;

                Bookingdriverange.memeberupdate = false;

                BookElectionFrgament.dateselected = false;
                Bookingdriverange.dateselected = false;
                EventTournaments.eventtournament = false;
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
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
                        String id = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
                        String hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                        if (hasPhone.equalsIgnoreCase("1")) {
                            Cursor phones = getContentResolver().query(
                                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                                    null, null);
                            phones.moveToFirst();
                            String cNumber = phones.getString(phones.getColumnIndex("data1"));
                            String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));


                            try {
                                SmsManager smsManager = SmsManager.getDefault();

                                smsManager.sendTextMessage(cNumber, null, "HELLO", null, null);

                            } catch (Exception ex) {

                            }

                        }


                        // TODO Whatever you want to do with the selected contact name.
                    }
                }
                break;
        }
    }


    public String timeconversion1(String input) {

        //Date/time pattern of input date
        DateFormat df = new SimpleDateFormat("HH:mm");
        //Date/time pattern of desired output date
        DateFormat outputformat = new SimpleDateFormat("hh:mm a");
        Date date = null;
        String output = null;
        try {
            //Conversion of input String to date
            date = df.parse(input);
            //old date format to new date format
            output = outputformat.format(date);
            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return output;
    }


    private void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("dd-MM-yyyy_hh:mm:ss", now);

        try {

            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            saveBitmap(bitmap);
            v1.setDrawingCacheEnabled(false);


        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void saveBitmap(Bitmap bitmap) {
        Date now = new Date();
        String screenShorts = "bookingScreen" + now + ".png";
        mPath = String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Karma Screenshots");


        String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);

        // make this as directory

        File dir = new File(mPath);
        if (!dir.exists())
            dir.mkdirs();
        File file = new File(mPath, screenShorts);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }


    public class MobileRegistration extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {

            strMobile = App_Common.getInstance(Bookingconfirmation.this).getUserNumber();
            if (BookElectionFrgament.BTTtime == true) {
                String time = BookElectionFrgament.timeselected.toString();
                String FORMATTEDtIME = time.replace(':', '.');
                String Date = BookElectionFrgament.formattedDate;
                String holes = String.valueOf(BookElectionFrgament.hole);
                strMessage = "Hey!%20The%20tee%20time%20booking%20is%20confirmed%20as%20follows%20-%20Booking%20ID%20-%20"+bookingID + "%20Date%20-%20" + Date +"%20Time%20-%20" + FORMATTEDtIME + "%20No.%20of%20Holes%20-%20"+ holes + ".%20See%20you%20at%20Karma%20Lakelands!";

            } else if (Bookingdriverange.BDRTime == true) {
                String timeDrive = Bookingdriverange.timeselected;
                // timeDrive.replace(':','.');
                String FORMATTEDtIME2 = timeDrive.replace(':', '.');
                String Date = Bookingdriverange.formattedDate;
                String buckets = String.valueOf(Bookingdriverange.bucketselected);
                strMessage = "Hey!%20The%20driving%20range%20booking%20is%20confirmed%20as%20follows%20-%20Booking%20ID%20-%20"+bookingID + "%20Date%20-%20" + Date + "%20Time%20-%20" + FORMATTEDtIME2 + "%20Balls%20-%20" + buckets + ".%20See%20you%20at%20Karma%20Lakelands!";
                // strMessage = "Hey!%20The%20Drive%20range%20booking%20is%20confirmed%20as%20–%20%Booking%20id:%20"+bookingID+"%20Booking%20Date:%20"+Bookingdriverange.formattedDate+"%20%20Timing:%20"+Bookingdriverange.timeselected+"%20%20Hole%20number:%20"+Bookingdriverange.bucketselected;

            }
            ringProgressDialog = ProgressDialog.show(Bookingconfirmation.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            bindParameter = "/" + strMobile + "/" + strMessage;
            String sendOTPRequest = bindParameter;
            String url;
            //    RequestQueue requestQueue;
            {
                try {


                    url = WebService.GET(App_Common.WebServiceUrl + "SendOTP" + sendOTPRequest);
                    //   ghgfh' oString response = WebService.POST(App_Common.WebServiceUrl+"userRegistration/",jsonObject.toString());

                    Log.i(App_Common.TAG, url);
                    Log.e("RESPONSE", url);

                    if (url == null || url.equals("")) {

                        //Toast.makeText(activity, "failed", Toast.LENGTH_SHORT).show();

                        // return false;
                    } else {
                        JSONObject jsonresponse = new JSONObject(url);
                        String status = jsonresponse.getString("status");
                        message = jsonresponse.getString("message");
                        return true;

                    }


                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return false;
                }
            }
            return Boolean.valueOf(url);
        }


        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                ringProgressDialog.dismiss();

            } else {
                ringProgressDialog.dismiss();
                Toast.makeText(Bookingconfirmation.this, "failed", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
