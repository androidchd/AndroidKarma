

package com.KarmaLakeLand1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Helper.App_Common;
import Utility.WebService;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Submitscorecard2 extends FragmentActivity {
    private static final int REQUEST_CODE = 0x11;
    int totalScore, totalPar;
    String stime;
    ImageView linkedin;
    ImageView google_ic;
    ImageView facebook_ic;
    ImageView twitter_ic;
    String filePath = null;
    ArrayList<Integer> STROKES;
    ArrayList<Integer> PUTS;
    ArrayList<Integer> PAR;
    int eaglecount = 0;
    int birdiescount = 0;
    int bogeycount = 0;
    int doublebogeycount = 0;
    int parcount = 0;
    Button sharescorecard;
    int sumofholes = 0;
    int sumofStroke = 0;
    int sumofPUTS = 0;
    int sumofPAR = 0;

    TextView totalnumberofputs;
    static File imageFile;
    String strDate;
    TextView Stroke;
    TextView grossCard;
    TextView eagle;
    TextView birdies;
    TextView par;
    TextView bogey;
    TextView doublebogey;
    ImageButton back_icon;
    TextView scorecardhighlights;
    boolean screenshot = false;
    Button skip;
    Intent i;
    TextView congratulations;
    ImageButton favriot;
    View rootView;
    Bitmap bm;
    String mPath = null;
    LinearLayout tlScreenshots;
    int get_score;
    int get_par;
    int get_putts;
    TextView tvGrossScore;
    Activity mcontext;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submitscorecard2);
        tvGrossScore = (TextView) findViewById(R.id.tv_grossScore);

        i = getIntent();
        stime = i.getStringExtra("time");
        rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        tlScreenshots = (LinearLayout) findViewById(R.id.ll_screen_short);
        permissionsFuction();
        App_Common.getInstance(Submitscorecard2.this).setHolescore1("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore2("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore3("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore4("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore5("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore6("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore7("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore8("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore9("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore10("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore11("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore12("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore13("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore14("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore15("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore16("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore17("");
        App_Common.getInstance(Submitscorecard2.this).setHolescore18("");


        favriot = (ImageButton) findViewById(R.id.favriot);
        favriot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                /*totalnumberofputs.setText((""));

                Stroke.setText("");
                par.setText((""));
                eagle.setText((""));
                birdies.setText((""));
                bogey.setText((""));
                doublebogey.setText((""));
                tvGrossScore.setText("");
                STROKES.clear();
                PAR.clear();
                PUTS.clear();
                finish();
                sumofPAR = 0;
                sumofStroke = 0;
                sumofholes = 0;
                sumofPUTS = 0;*/

            }
        });


        congratulations = (TextView) findViewById(R.id.congratulations);
        /*SpannableStringBuilder sb = new SpannableStringBuilder("Congratulations!");


        // create a bold StyleSpan to be used on the SpannableStringBuilder
        StyleSpan b = new StyleSpan(android.graphics.Typeface.NORMAL); // Span to make text bold

        // set only the name part of the SpannableStringBuilder to be bold --> 16, 16 + name.length()
        sb.setSpan(b, 14, 14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        SpannableStringBuilder sb1 = new SpannableStringBuilder("Your scorecard has been submitted successfully.");
        StyleSpan cd = new StyleSpan(android.graphics.Typeface.NORMAL); // Span to make text bold

        // set only the name part of the SpannableStringBuilder to be bold --> 16, 16 + name.length()
        sb1.setSpan(cd, 14, 14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        String str = "<b>"+"Congratulations! Your scorecard has been submitted successfully."+"</b>";*/
        //   mBox.setText();
        //  congratulations.setText(Html.fromHtml(str));

        skip = (Button) findViewById(R.id.skip);
        skip.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intentSkip = new Intent(Submitscorecard2.this, BookingSelection.class);
                startActivity(intentSkip);
                finish();
            }
        });
        //grossCard = (TextView) findViewById(R.id.gross_score);

        Stroke = (TextView) findViewById(R.id.score);
        scorecardhighlights = (TextView) findViewById(R.id.scorecardhighlights);

        totalnumberofputs = (TextView) findViewById(R.id.totalnumberofputs);
        eagle = (TextView) findViewById(R.id.eagle);
        birdies = (TextView) findViewById(R.id.birdies);
        par = (TextView) findViewById(R.id.par);
        bogey = (TextView) findViewById(R.id.bogey);

        doublebogey = (TextView) findViewById(R.id.doublebogey);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        strDate = sdf.format(c.getTime());
        new Getholescore().execute();
        //grossScore();
        STROKES = new ArrayList<Integer>();
        PUTS = new ArrayList<Integer>();
        PAR = new ArrayList<Integer>();

        sharescorecard = (Button) findViewById(R.id.sharescorecard);
        linkedin = (ImageView) findViewById(R.id.whats_app);
        facebook_ic = (ImageView) findViewById(R.id.facebook_ic);
        twitter_ic = (ImageView) findViewById(R.id.twitter_ic);


        google_ic = (ImageView) findViewById(R.id.google_ic);
        sharescorecard.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Date now = new Date();

                takeScreenshot();

                // mPath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyImage/");
                String screenShorts = "ScoreDetail_" + now + ".png";
                String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
                //screenpics = now +".jpeg";
                File filepath = new File(mPath, audioConcatPath);


                shareImage(filepath);

            }
        });
        linkedin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Date now = new Date();

                takeScreenshot();

                // mPath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyImage/");
                String screenShorts = "ScoreDetail_" + now + ".png";
                String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
                //screenpics = now +".jpeg";
                File filepath = new File(mPath, audioConcatPath);
                whatsapp(filepath);
            }
        });
        facebook_ic.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Date now = new Date();

                takeScreenshot();

                // mPath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyImage/");
                String screenShorts = "ScoreDetail_" + now + ".png";
                String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
                //screenpics = now +".jpeg";
                File filepath = new File(mPath, audioConcatPath);
                facebook(filepath);
            }
        });
        google_ic.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Date now = new Date();

                takeScreenshot();

                // mPath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyImage/");
                String screenShorts = "ScoreDetail_" + now + ".png";
                String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
                //screenpics = now +".jpeg";
                File filepath = new File(mPath, audioConcatPath);
                shareImage(filepath);
                //sendGmail();
            }
        });
        twitter_ic.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Date now = new Date();

                takeScreenshot();

                // mPath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyImage/");
                String screenShorts = "ScoreDetail_" + now + ".png";
                String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
                //screenpics = now +".jpeg";
                File filepath = new File(mPath, audioConcatPath);
                twitter(filepath);
            }
        });


    }
   // @TargetApi(Build.VERSION_CODES.M)
    public void permissionsFuction(){
        String[] permissions = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        ActivityCompat.requestPermissions(this,permissions, REQUEST_CODE);
    }

    private void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("MM-dd-yyyy_hh:mm:ss", now);

        try {
            tlScreenshots.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(tlScreenshots.getDrawingCache());
            saveBitmap(bitmap);
            tlScreenshots.setDrawingCacheEnabled(false);


        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void saveBitmap(Bitmap bitmap) {
        Date now = new Date();
        String screenShorts = "ScoreDetail_" + now + ".png";
        mPath = String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Karma Screenshots");
        String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
        // dirPath.mkdirs(); // make this as directory
        File dir = new File(mPath);
        if (!dir.exists())
            dir.mkdirs();
        File file = new File(mPath, screenShorts);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }

    private void shareImage(File file) {
        Uri uri = Uri.fromFile(file);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");

        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My score at Karma Lakelands!");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey ! Check out my score at Karma Lakelands!");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        try {
            startActivity(Intent.createChooser(intent, "Share Screenshot"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No App Available", Toast.LENGTH_SHORT).show();
        }
    }

    public class Getholescore extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(Submitscorecard2.this, null, "Submitting your scorecard ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();


                String response = WebService.GET(App_Common.WebServiceUrl + "getHolesScoreByDate" + "/" + App_Common.getInstance(Submitscorecard2.this).getUserID());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);
                JSONArray jsonarray = new JSONArray(response);
                for (int k = 0; k < jsonarray.length(); k++) {
                    JSONObject jsonobject1 = jsonarray.getJSONObject(k);
                    String time = jsonobject1.getString("stime");
                    /*if(time.matches(stime))
                    {	*/
                    JSONArray j1 = jsonobject1.getJSONArray("detailScore");
                    for (int j = 0; j < j1.length(); j++) {
                        try {

                            JSONObject jsonobject2 = j1.getJSONObject(j);
                       /* Log.i("Par ", jsonobject2.getString("Par"));
                        Log.i("Hole no ", jsonobject2.getString("holeNo"));
                        Log.i("Penalty ", jsonobject2.getString("penality"));*/
                            PUTS.add(jsonobject2.getInt("putts"));
                            get_putts = jsonobject2.getInt("putts");
                            get_score = jsonobject2.getInt("strock");
                            // totalScore = get_score++;
                            STROKES.add(jsonobject2.getInt("strock"));
                            PAR.add(jsonobject2.getInt("Par"));
                            get_par = jsonobject2.getInt("Par");
                            // totalPar = get_par++;
                            sumofholes++;

                            if (get_score == get_par) {
                                parcount++;
                            }

                            // int bogey = get_score + 1;
                            if (get_par < get_score) {
                                int bogey = get_score - get_par;
                                if (bogey == 1) {
                                    bogeycount++;
                                } else if (bogey == 2) {
                                    doublebogeycount++;
                                } else {

                                }
                            }

                            if (get_par > get_score) {
                                int birdies = get_par - get_score;
                                if (birdies == 1) {
                                    birdiescount++;
                                } else if (birdies == 2) {
                                    eaglecount++;
                                }

                            }

                        } catch (NullPointerException ee) {

                        }
                        Log.i("Holes ", jsonobject1.getString("holes"));
                    }
                }
                    /*}*/

                for (int m = 0; m < PUTS.size(); m++) {

                    sumofPUTS += PUTS.get(m);
                    System.out.println("PUTS" + PUTS.get(m).toString());

                }
                for (int m = 0; m < STROKES.size(); m++) {
                    sumofStroke += STROKES.get(m);
                    System.out.println("STROKES" + STROKES.get(m).toString());
                }
                for (int m = 0; m < PAR.size(); m++) {
                    sumofPAR += PAR.get(m);
                    System.out.println("STROKES" + STROKES.get(m).toString());
                }


                return true;


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
                scorecardhighlights.setText("Scorecard Highlights " + "(" + sumofholes + " Holes Played)");
                totalnumberofputs.setText(Integer.toString(sumofPUTS));
                Stroke.setText(Integer.toString(sumofStroke));
                par.setText(Integer.toString(parcount));
                eagle.setText(Integer.toString(eaglecount));
                birdies.setText(Integer.toString(birdiescount));
                bogey.setText(Integer.toString(bogeycount));
                doublebogey.setText(Integer.toString(doublebogeycount));
                grossScore();


                App_Common.getInstance(Submitscorecard2.this).setDate("");
            } else {
                //
            }
        }
    }

    public void sendGmail() {


        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        emailIntent.setType("application/image");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{" "});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My score at Karma Lakelands!");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey! Check out my score at Karma Lakelands!");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(imageFile));
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));


        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException ex) {
            // handle error
        }
    }


    public static void store(Bitmap bm, String fileName) {
        final String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Screenshots";
        File dir = new File(dirPath);
        if (!dir.exists())
            dir.mkdirs();
        try {
            imageFile = new File(dirPath, fileName);
            FileOutputStream fOut = new FileOutputStream(imageFile);
            bm.compress(Bitmap.CompressFormat.PNG, 85, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openScreenshot(File imageFile) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(imageFile);
        intent.setDataAndType(uri, "image*//*");
        startActivity(intent);
    }

    public void twitter(File file) {
        String msg = "Hey! Check out my score at Karma Lakelands!";
        String tweetUrl = String.format(
                "https://twitter.com/intent/tweet?text=%s&url=%s", msg, "");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));
        //	Uri uri = Uri.parse();

        Boolean twitterAppFound = false;
        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(
                intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith(
                    "com.twitter")) {
                intent.setPackage(info.activityInfo.packageName);
                twitterAppFound = true;
                intent.setType("image/png");

                Uri uri = Uri.fromFile(file);
                intent.setDataAndType(uri, "image/*");

                intent.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(intent);
            } else if (!twitterAppFound) {
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri
                        .parse("market://details?id=com.twitter.android"));
                startActivity(intent);
            }
        }

    }

    public void facebook(File file) {
        String msg = "Hey! Check out my score at Karma Lakelands!";
        String urlToShare = msg;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, urlToShare);
        boolean facebookAppFound = false;
        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(
                intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith(
                    "com.facebook.katana")) {
                intent.setPackage(info.activityInfo.packageName);
                facebookAppFound = true;
                intent.setType("image/png");

                Uri uri = Uri.fromFile(file);
                intent.setDataAndType(uri, "image/*");

                intent.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(intent);
            }
        }
        if (!facebookAppFound) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.facebook.katana"));
            startActivity(intent);
        }


    }

    public void googleic() {
        String msg = "ScoreCard";
        String urlToShare = msg;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, urlToShare);

        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(
                intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith(
                    "com.google.android.apps.plus")) {
                intent.setPackage(info.activityInfo.packageName);

            }
        }
        intent.setType("image/png");

        Uri uri = Uri.fromFile(imageFile);
        intent.setDataAndType(uri, "image/*");

        intent.putExtra(Intent.EXTRA_STREAM, uri);

        startActivity(intent);
    }

    public void linkedin() {
        String msg = "";

        String tweetUrl = String.format(
                "https://twitter.com/intent/tweet?text=%s&url=%s", msg, "");


        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));
        intent.setType("text/plain");

        Boolean linkedinApp = false;
        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(
                intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith(
                    "com.linkedin.android")) {
                intent.setPackage(info.activityInfo.packageName);
                linkedinApp = true;
                intent.setType("image/png");


                intent.setType("image/png");

                Uri uri = Uri.fromFile(imageFile);
                intent.setDataAndType(uri, "image/*");

                intent.putExtra(Intent.EXTRA_STREAM, uri);

                startActivity(intent);

            } else if (!linkedinApp) {
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri
                        .parse("https://play.google.com/store/apps/details?id=com.linkedin.android&hl=en"));
                startActivity(intent);
            }

        }

    }

    public void whatsapp(File file) {
        Intent waIntent = new Intent(Intent.ACTION_SEND);
        waIntent.setType("text/plain");
        String text = "Hey! Check out my score at Karma Lakelands!";
        boolean watsappAppFound = false;
        if (waIntent != null) {
            List<ResolveInfo> matches = getPackageManager()
                    .queryIntentActivities(waIntent, 0);
            for (ResolveInfo info : matches) {
                if (info.activityInfo.packageName.toLowerCase().contains(
                        "com.whatsapp")) {
                    watsappAppFound = true;
                }
            }
            if (watsappAppFound) {
                waIntent.setPackage("com.whatsapp");

                waIntent.setType("image/png");


                waIntent.setType("image/png");

                Uri uri = Uri.fromFile(file);
                waIntent.setDataAndType(uri, "image/*");

                waIntent.putExtra(Intent.EXTRA_STREAM, uri);


                waIntent.putExtra(Intent.EXTRA_TEXT, text);
            } else {
                waIntent = new Intent(Intent.ACTION_VIEW);
                waIntent.setData(Uri.parse("market://details?id=com.whatsapp"));
            }
            startActivity(waIntent);
        }
    }


    @Override
    public void onBackPressed() {
        totalnumberofputs.setText((""));
        Stroke.setText("");
        par.setText((""));
        eagle.setText((""));
        birdies.setText((""));
        bogey.setText((""));
        doublebogey.setText((""));
        tvGrossScore.setText("");
        STROKES.clear();
        PAR.clear();
        PUTS.clear();
        sumofPAR = 0;
        sumofStroke = 0;
        sumofholes = 0;
        sumofPUTS = 0;
        finish();


        //  BookElectionFrgament.dateselected=false;


    }

    public void grossScore() {

        if (sumofStroke == sumofPAR) {

            tvGrossScore.setText("0");
        } else if (sumofStroke > sumofPAR) {
            try {
                int totalgrossScore = sumofStroke - sumofPAR;

                tvGrossScore.setText("+" + totalgrossScore);
            } catch (NullPointerException ee) {

            } catch (RuntimeException ee) {

            }
        } else if (sumofStroke < sumofPAR) {
            try {
                int totalgrossScore = sumofStroke - sumofPAR;
                tvGrossScore.setText("" + totalgrossScore);

            } catch (NullPointerException ee) {

            } catch (RuntimeException ee) {

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                takeScreenshot();
            } else {
                Toast.makeText(getApplicationContext(), "PERMISSION_DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


