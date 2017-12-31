package com.KarmaLakeLand1;

//import org.lucasr.twowayview.TwoWayView;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import Adapter.DrawerItemCustomAdapter;
import Adapter.Objectdraweritem;
import Helper.App_Common;
import Helper.Prefs;
import de.hdodenhof.circleimageview.CircleImageView;

public class BookingSelection extends FragmentActivity /*implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks*/ {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    boolean chkDrawerLayout = true;
    Context context;
    Boolean gmailStatus = false;
    SharedPreferences prefrence;
    String userName, userMail;
    SharedPreferences.Editor editor;
    private int randomInt = 0;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    CircleImageView profileImage;
    TextView username;
    Context mContext;
    TextView mobilenumber;
    public static SignIn signIn;
    // nav drawer title
    AlertDialog.Builder builder;
    private String strBase64;
    SD_Directory sd_directory = new SD_Directory(mContext);
    String cameraImage = "profile";
    // used to store app title

    // slide menu items
    String token;
    View view;
    SlidingTabLayout mSlidingTabLayout;

    //TwoWayView lvTest;

    ImageButton menuicon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmain);

        token = App_Common.getInstance(BookingSelection.this).getUserToken();
        App_Common.getInstance(getApplicationContext()).setLoginStatus(true);

        prefrence = getSharedPreferences(Prefs.Prefrence, MODE_PRIVATE);
        editor = prefrence.edit();
        mobilenumber = (TextView) findViewById(R.id.ruserNo);
        gmailStatus = prefrence.getBoolean(Prefs.GmailLOGIN, Boolean.parseBoolean(null));
        userName = prefrence.getString(Prefs.userName, null);
        userMail = prefrence.getString(Prefs.userMail, null);
        // facebook = prefrence.getBoolean(Prefs.FACEBOOKLOGIN, Boolean.parseBoolean(null));

        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.nav_drawer_items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        menuicon = (ImageButton) findViewById(R.id.menuicon);
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.listviewheader, mDrawerList, false);
        profileImage = (CircleImageView) header.findViewById(R.id.profile_image);
        //  profileImage.setImageBitmap(sd_directory.getBitmap(cameraImage));
        ((TextView) header.findViewById(R.id.rusername)).setText(App_Common.getInstance(BookingSelection.this).getUserName());
        ((TextView) header.findViewById(R.id.ruserNo)).setText(App_Common.getInstance(BookingSelection.this).getUserNumber());

      /*  SpannableStringBuilder sb = new SpannableStringBuilder("Congratulations!");

        StyleSpan b = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold

        sb.setSpan(b, 16, 16 , Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        SpannableStringBuilder sb1 = new SpannableStringBuilder("Your scorecard has been submitted successfully.");
        StyleSpan cd = new StyleSpan(android.graphics.Typeface.NORMAL); // Span to make text bold

        // set only the name part of the SpannableStringBuilder to be bold --> 16, 16 + name.length()
        sb1.setSpan(cd, 14, 14 , Spannable.SPAN_INCLUSIVE_INCLUSIVE);*/


        //   mBox.setText();

        Objectdraweritem[] drawerItem = new Objectdraweritem[9];

        drawerItem[0] = new Objectdraweritem(R.drawable.home_icon, "Home");
        drawerItem[1] = new Objectdraweritem(R.drawable.profile, "Profile");
        drawerItem[2] = new Objectdraweritem(R.drawable.booking_icon, "Booking Details");
        // drawerItem[3] = new Objectdraweritem(R.drawable.score_icon, "Invite & Earn");
        drawerItem[3] = new Objectdraweritem(R.drawable.invite_icon, "Scorecards");
        drawerItem[4] = new Objectdraweritem(R.drawable.rule_regulation, "Rules & Regulations");
        // drawerItem[5] = new Objectdraweritem(R.drawable.offer_icon, "Notifications");
        drawerItem[5] = new Objectdraweritem(R.drawable.call_support, "Support");
        //drawerItem[8] = new Objectdraweritem(R.drawable.report_icon, "Report Issues");
        drawerItem[6] = new Objectdraweritem(R.drawable.trems_and_condition, "Terms of Use");
        drawerItem[7] = new Objectdraweritem(R.drawable.trems_and_condition, "Privacy Policy");
        drawerItem[8] = new Objectdraweritem(R.drawable.logout_icon, "Log Out");
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_itemrow1, drawerItem);
        mDrawerList.addHeaderView(header, null, false);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        menuicon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (chkDrawerLayout) {
                    mDrawerLayout.openDrawer(mDrawerList);
                } else {
                    mDrawerLayout.closeDrawers();
                }

            }
        });

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        pager.setOffscreenPageLimit(1);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.pager_tab_strip);

        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.pressed_color));

        mSlidingTabLayout.setDistributeEvenly(true);

        mSlidingTabLayout.setViewPager(pager);

        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.pressed_color);    //define any color in xml resources and set it here, I have used white
            }

        });

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return BookElectionFrgament.newInstance(" ");
                case 1:
                    return Bookingdriverange.newInstance(" ");
                case 2:
                    return Submitscore.newInstance(" ");
                case 3:
                    return CourseGps.newInstance("");
                /*case 4:
                    return EventsandTournaments.newInstance("");*/
                case 4:
                    return Courseamenities.newInstance(" ");
                case 5:
                    return Contactus.newInstance(" ");
                default:
                    return BookElectionFrgament.newInstance(" ");
            }
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Book Tee Time";
                case 1:
                    return "Book Driving Range";
                case 2:
                    return "Submit Scorecard";
                case 3:
                    return " Course GPS ";
             /*   case 4:
                    return " Events and Tournaments ";*/
                case 4:
                    return "Course Amenities";
                case 5:
                    return "Contact Us";
                default:
                    return " ";

            }
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Intent i;

        switch (position) {

            case 1:
                i = new Intent(BookingSelection.this, BookingSelection.class);
                BookElectionFrgament.newInstance(" ");

                BookElectionFrgament.dateselected = false;
                Bookingdriverange.dateselected = false;
                mDrawerLayout.closeDrawers();
                startActivity(i);
                overridePendingTransition(R.anim.reverse_right_to_left, R.anim.reverse_left_to_right);
                break;
            case 2:
                i = new Intent(BookingSelection.this, Editprofile.class);
                startActivity(i);
                mDrawerLayout.closeDrawers();
                break;
            case 3:
                i = new Intent(BookingSelection.this, Allbooking.class);
                startActivity(i);

                mDrawerLayout.closeDrawers();
                break;
            /*case 4:
                i = new Intent(BookingSelection.this, Invitefriends.class);
                startActivity(i);
                mDrawerLayout.closeDrawers();
                break;*/

            case 4:
                i = new Intent(BookingSelection.this, SubmitScorecard.class);

                startActivity(i);
                mDrawerLayout.closeDrawers();
                break;
            case 5:

                mDrawerLayout.closeDrawers();

                ListingAlart();
                builder.setCancelable(false);

                //  Customdialog cdd = new Customdialog(BookingSelection.this);
                //cdd.show();


                break;

           /* case 6:
                mDrawerLayout.closeDrawers();

                i = new Intent(BookingSelection.this, OffersandDeals.class);

                startActivity(i);


                break;*/


            case 6:
                SupportDialog cancelbookingdialog = new SupportDialog(BookingSelection.this);
                cancelbookingdialog.show();
                // cancelbookingdialog.setCancelable(false);
                break;
           /* case 9:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri
                        .fromParts("mailto", "appcentra@gmail.com",
                                null));
                emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                emailIntent.putExtra(Intent.EXTRA_EMAIL,
                        "test@gmail.com");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        "Report Golf Issue");
                startActivity(emailIntent);

                mDrawerLayout.closeDrawers();
                break;*/
            case 7:

                mDrawerLayout.closeDrawers();
                Intent intent = new Intent(getApplicationContext(), TermsandConditions.class);

                startActivity(intent);
                break;
            case 8:

                mDrawerLayout.closeDrawers();
                Intent intent1 = new Intent(getApplicationContext(), PrivacyPolicy.class);

                startActivity(intent1);
                break;


            case 9:
                if (isNetworkConnected()) {


                    App_Common.getInstance(BookingSelection.this).setLoginStatus(false);
                    App_Common.getInstance(BookingSelection.this).setMemberShipId(null);
                    App_Common.getInstance(BookingSelection.this).setUserToken(null);

                    //App_Common.getInstance(BookingSelection.this).setUserEmailId("");

                    App_Common.getInstance(BookingSelection.this).setUserName(null);
                    App_Common.getInstance(BookingSelection.this).setUserID(null);
                    App_Common.getInstance(BookingSelection.this).setUserNumber(null);
                    App_Common.getInstance(BookingSelection.this).setUserEmailId(null);
                    App_Common.getInstance(BookingSelection.this).setUserPwd(null);
                    App_Common.getInstance(BookingSelection.this).setLoginS(false);
                    App_Common.getInstance(BookingSelection.this).setTimeselected(null);
                    App_Common.getInstance(BookingSelection.this).setDate(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore1(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore2(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore3(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore4(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore5(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore6(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore7(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore8(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore9(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore10(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore11(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore12(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore13(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore14(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore15(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore16(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore17(null);
                    App_Common.getInstance(BookingSelection.this).setHolescore18(null);
                    Toast.makeText(getApplicationContext(), "You have been successfully logged out!", Toast.LENGTH_LONG).show();
                    mDrawerLayout.closeDrawers();
                    intent = new Intent(getApplicationContext(), SignIn.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    break;

                } else {
                    Toast.makeText(this, "Check you Internet Connection", Toast.LENGTH_LONG).show();
                }
        }
    }


    public void onDrawerClosed(View view) {
        chkDrawerLayout = true;

    }

    /**
     * Called when a drawer has settled in a completely open state.
     */
    public void onDrawerOpened(View drawerView) {
        chkDrawerLayout = false;

    }


  /*  @Override
    public void onBackPressed() {
        super.onBackPressed();
        //  BookElectionFrgament.dateselected=false;
        BookElectionFrgament.timeselectedtime = false;
        Bookingdriverange.timed = false;

        Log.i("hdgcfsdgc", "helllo");
        finish();

    }
*/

    /**
     * Called just before the activity is destroyed.
     */

    public class Customdialog extends Dialog implements
            android.view.View.OnClickListener {

//member


        public Activity c;

        final Dialog d = new Dialog(getContext());
        public Button OK;

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
            setContentView(R.layout.rulesandregulationspopup);
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
                    break;
            }
        }

    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public void ListingAlart() {
        String strOne = "<b>" + "<small>" + "1." + "</small>" + "</b>" + "<small>" + " All players must sign in at Registration Desk at the Pro Shop." + "</small>";
        String strTwo = "<b>" + "<small>" + "2." + "</small>" + "</b>" + "<small>" + " Only golf shoes or smooth sole shoes are allowed on the course." + "</small>";
        String strThree = "<b>" + "<small>" + "3." + "</small>" + "</b>" + "<small>" + " Proper golf attire is to be worn during play." + "</small>";
        String strFour = "<b>" + "<small>" + "4." + "</small>" + "</b>" + "<small>" + " Please repair all foot marks, rake sand bunkers and fill divots." + "</small>";
        String strFive = "<b>" + "<small>" + "5." + "</small>" + "</b>" + "<small>" + " Golf carts to be driven on cart paths only." + "</small>";
        String strSix = "<b>" + "<small>" + "6." + "</small>" + "</b>" + "<small>" + " Outside food and beverages are prohibited." + "</small>";
        String strSeven = "<b>" + "<small>" + "7." + "</small>" + "</b>" + "<small>" + " Karma Lakelands is zero tolerance to litter & a completely no horn zone. Even broken tees left behind on the tees are litter. " + "</small>";
        String strEight = "<b>" + "<small>" + "8." + "</small>" + "</b>" + "<small>" + " Please smoke in the designated areas only.(Klub Karma back garden & the 6th tee kiosk)." + "</small>";
        String strNine = "<b>" + "<small>" + "9." + "</small>" + "</b>" + "<small>" + " Violators may be asked to leave the course immediately without a refund." + "</small>";


        CharSequence strFirst = Html.fromHtml(strOne);

        CharSequence strSecond = Html.fromHtml(strTwo);

        CharSequence strThird = Html.fromHtml(strThree);

        CharSequence strFourth = Html.fromHtml(strFour);

        CharSequence strFifth = Html.fromHtml(strFive);

        CharSequence strSixth = Html.fromHtml(strSix);
        CharSequence strSeventh = Html.fromHtml(strSeven);

        CharSequence strEighth = Html.fromHtml(strEight);

        CharSequence strNinth = Html.fromHtml(strNine);


        final CharSequence[] items = {strFirst, strSecond, strThird, strFourth, strFifth, strSixth, strSeventh, strEighth, strNinth};
        builder = new AlertDialog.Builder(BookingSelection.this);
        builder.setCancelable(false);

        builder.setTitle("Rules & Regulations");
        builder.setCancelable(false);
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                builder.setCancelable(false);
            }

        });
        builder.show();
    }

    public void SaveImage(Intent data) {

        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        profileImage.setImageBitmap(thumbnail);
        sd_directory.putBitmap(thumbnail, cameraImage);
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "Profile.jpg");
        try {
            file.createNewFile();
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(file);
        mediaScanIntent.setData(contentUri);
        getApplicationContext().sendBroadcast(mediaScanIntent);
    }

    private void onSelectFromGalleryResult(Intent data) {
        Uri selectedImageUri = data.getData();
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = managedQuery(selectedImageUri, projection, null, null,
                null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        String selectedImagePath = cursor.getString(column_index);
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);

        final int REQUIRED_SIZE = 200;
        int scale = 1;
        while (options.outWidth / scale / 2 >= REQUIRED_SIZE
                && options.outHeight / scale / 2 >= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        try {
            InputStream inputStream = getBaseContext().getContentResolver().openInputStream(selectedImageUri);
            Bitmap bm = BitmapFactory.decodeStream(inputStream);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] byteArray = stream.toByteArray();

            profileImage.setImageBitmap(bm);


            bm.compress(Bitmap.CompressFormat.PNG, 90, stream);

            strBase64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
            sd_directory.putBitmap(bm, cameraImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA) {

                // onCaptureImageResult(data);
                SaveImage(data);
            }

        }
    }

    public class SupportDialog extends Dialog implements android.view.View.OnClickListener {


        boolean cancelbooking = false;
        public Activity c;
        final Dialog d = new Dialog(getContext());
        public LinearLayout Phone;
        public LinearLayout Email;

        public SupportDialog(Activity a) {
            super(a);
            // TODO Auto-generated constructor stub
            this.c = a;

        }
        // TODO Auto-generated constructor stub


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.issues_dialog);
            //	d= new Dialog(getContext());


            Phone = (LinearLayout) findViewById(R.id.btn_phone);
            Phone.setOnClickListener(this);
            Email = (LinearLayout) findViewById(R.id.btn_email);
            Email.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.btn_phone:
                    String mobileNumber = "+919830658700";
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mobileNumber));
                    callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                    mDrawerLayout.closeDrawers();

                    dismiss();

                    break;
                case R.id.btn_email:
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri
                            .fromParts("mailto", "karma.apphelpdesk@gmail.com", null));
                    emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL,
                            "test@gmail.com");
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                            "Report Golf Issue");
                    startActivity(emailIntent);

                    mDrawerLayout.closeDrawers();
                    dismiss();

                    break;

            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v("permission", "Permission: " + permissions[0] + "was " + grantResults[0]);
            //resume tasks needing this permission
        }
    }

    @Override
    public void onBackPressed() {
        BookElectionFrgament.timeselectedtime = false;
        Bookingdriverange.timed = false;
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStackImmediate();

        } else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Are you sure you want to exit?");

            builder1.setCancelable(false);

            builder1.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {
                            try {

                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                // intent.addCategory("android.intent.category.LAUNCHER");
                                intent.addCategory(Intent.CATEGORY_HOME);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                            } catch (SecurityException ee) {

                            }
                        }
                    });

            builder1.setNegativeButton(
                    "Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
            //super.onBackPressed();
        }

    }


}
