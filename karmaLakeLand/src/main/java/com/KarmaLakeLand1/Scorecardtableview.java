package com.KarmaLakeLand1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Scorecardtableview extends FragmentActivity {
    String holenumber;
    String parvalue;
    String scorenumber;
    ImageView linkedin;
    Intent extras;
    Uri uri;
    int sumofStroke = 0;
    int sumofPAR = 0;
//    int sumPar, sumScore;
    ImageView googleicon;
    ImageView facebookicon;
    ImageView twittericon;
//    String filePath;
//    File imageFile;
//    Boolean screenshot = false;
    ImageButton favriot;
    Button scorecardshare;
    ListView l2;
    ArrayList<Integer> holes;
    ArrayList<Integer> pars;
    ArrayList<Integer> score;
    public static ArrayList<Scorecardgettersetter2> scorecardlist;
    Scorecardgettersetter2 st;
    LinearLayout v1;
    String mPath,audioConcatPath;
    TextView tvGross;
    private static final int REQUEST_CODE = 0x11;
//    Activity mcontext;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submitscorecardlist);
        scorecardlist = new ArrayList<Scorecardgettersetter2>();
        v1 = (LinearLayout) findViewById(R.id.linearl1);

        tvGross = (TextView) findViewById(R.id.tvGrossScore);

        l2 = (ListView) findViewById(R.id.l2);
        extras = getIntent();
        holes = new ArrayList<Integer>();
        pars = new ArrayList<Integer>();
        score = new ArrayList<Integer>();
        holenumber = extras.getStringExtra("Hole");
        holes = extras.getIntegerArrayListExtra("HOLES");
        pars = extras.getIntegerArrayListExtra("PAR");
        score = extras.getIntegerArrayListExtra("SCORE");
        parvalue = extras.getStringExtra("Parvalue");
        scorenumber = extras.getStringExtra("Score");

        // totalGross()
        // ----------permission
        permissionsFunction();

        for (int i = 0; i < score.size(); i++) {
            st = new Scorecardgettersetter2();
            st.setScore(String.valueOf(score.get(i)));
            st.setPar(String.valueOf(pars.get(i)));
            st.setHoles(String.valueOf(holes.get(i)));
            scorecardlist.add(st);
        }
        for (int m = 0; m < pars.size(); m++) {
            sumofPAR += pars.get(m);
            System.out.println("PUTS" + pars.get(m).toString());

        }
        for (int m = 0; m < score.size(); m++) {
            sumofStroke += score.get(m);
            System.out.println("STROKES" + score.get(m).toString());
        }
        grossScore();


        Scorecardadapter a1 = new Scorecardadapter(Scorecardtableview.this, scorecardlist);
        l2.setAdapter(a1);


        favriot = (ImageButton) findViewById(R.id.favriot);
        favriot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });


        linkedin = (ImageView) findViewById(R.id.linkedin);
        googleicon = (ImageView) findViewById(R.id.google_ic);
        twittericon = (ImageView) findViewById(R.id.twitter_ic);
        facebookicon = (ImageView) findViewById(R.id.facebook_ic);
        scorecardshare = (Button) findViewById(R.id.sharescorecard);
        scorecardshare.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                Date now = new Date();

                takeScreenshot();

                // mPath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyImage/");
                String screenShorts = "Image_" + now + ".png";
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

                takeScreenshot();
                Date now = new Date();
                String screenShorts = "Image_" + now + ".png";
                String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
                //screenpics = now +".jpeg";
                File filepath = new File(mPath, audioConcatPath);
                whatsapp(filepath);

            }
        });
        facebookicon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                takeScreenshot();
                Date now = new Date();
                String screenShorts = "Image_" + now + ".png";
                String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
                //screenpics = now +".jpeg";
                File filepath = new File(mPath, audioConcatPath);
                //whatsapp(filepath);
                facebook(filepath);
            }
        });
        twittericon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                takeScreenshot();
                Date now = new Date();
                String screenShorts = "Image_" + now + ".png";
                String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
                File filepath = new File(mPath, audioConcatPath);
                twitter(filepath);

            }
        });

        googleicon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                takeScreenshot();
                Date now = new Date();
                String screenShorts = "Image_" + now + ".png";
                String audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);
                File filepath = new File(mPath, audioConcatPath);
                shareImage(filepath);

            }
        });

    }

   // @TargetApi(Build.VERSION_CODES.M)
    public void permissionsFunction() {
        String[] permissions = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        ActivityCompat.requestPermissions(this,permissions, REQUEST_CODE);
    }

    private void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("MM-dd-yyyy", now);

        try {

            v1.setDrawingCacheEnabled(true);

            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            saveBitmap(bitmap);
            v1.setDrawingCacheEnabled(false);


        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    private void shareImage(File file) {
        Uri uri = Uri.fromFile(file);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");

        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hey! Check out my score at Karma Lakelands!");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey! Check out my score at Karma Lakelands!");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        try {
            startActivity(Intent.createChooser(intent, "Share Screenshot"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No App Available", Toast.LENGTH_SHORT).show();
        }
    }


    public void twitter(File file) {
        String msg = "Hey! Check out my score at Karma Lakelands!";
        String tweetUrl = String.format(
                "https://twitter.com/intent/tweet?text=%s&url=%s", msg, "");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));
        Boolean twitterAppFound = false;
        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(
                intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith(
                    "com.twitter")) {
                intent.setPackage(info.activityInfo.packageName);
                twitterAppFound = true;
                intent.setType("image/jpeg");

                Uri uri = Uri.fromFile(file);
                intent.setDataAndType(uri, "image/jpeg");

                intent.putExtra(Intent.EXTRA_STREAM, uri);
                intent.putExtra(Intent.EXTRA_TEXT, " ScoreCard ");
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
                intent.setType("image/jpeg");

                Uri uri = Uri.fromFile(file);
                intent.setDataAndType(uri, "image/jpeg");
                intent.putExtra(Intent.EXTRA_TEXT, " ScoreCard ");
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

//    public void googleic() {
//        String msg = "Hey! Check out my score at Karma Lakelands!";
//        String urlToShare = msg;
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(android.content.Intent.EXTRA_TEXT, urlToShare);
//
//        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(
//                intent, 0);
//        for (ResolveInfo info : matches) {
//            if (info.activityInfo.packageName.toLowerCase().startsWith(
//                    "com.google.android.apps.plus")) {
//                intent.setPackage(info.activityInfo.packageName);
//
//            }
//        }
//        intent.setType("image/jpeg");
//
//        Uri uri = Uri.fromFile(imageFile);
//        intent.setDataAndType(uri, "image/jpeg");
//
//        intent.putExtra(Intent.EXTRA_STREAM, uri);
//        intent.putExtra(Intent.EXTRA_TEXT, " ScoreCard ");
//        startActivity(intent);
//    }

//    public void sendGmail(File file) {
//        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//        emailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
//        emailIntent.setType("image/png");
//        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{" "});
//        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "SCORECARD");
//        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
//        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
//        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
//
//
//        try {
//            startActivity(emailIntent);
//        } catch (ActivityNotFoundException ex) {
//            // handle error
//        }
//
//
//    }


    public void saveBitmap(Bitmap bitmap) {
        Date now = new Date();
        String screenShorts = "Image_" + now + ".png";
        mPath = String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Karma Screenshots");


         audioConcatPath = screenShorts.substring(screenShorts.lastIndexOf("/") + 1);

        // make this as directory

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


                //  waIntent.setType("image/jpeg");
                try {
                    uri = Uri.fromFile(file);
                } catch (NullPointerException e) {

                }
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

    public void grossScore() {

        if (sumofStroke == sumofPAR) {

            tvGross.setText("Gross Score = 0");
        } else if (sumofStroke > sumofPAR) {
            try {
                int totalgrossScore = sumofStroke - sumofPAR;

                tvGross.setText("Gross Score = " + "+" + totalgrossScore);
            } catch (NullPointerException ee) {

            } catch (RuntimeException ee) {

            }
        } else if (sumofStroke < sumofPAR) {
            try {
                int totalgrossScore = sumofStroke - sumofPAR;
                tvGross.setText("Gross Score = " + totalgrossScore);

            } catch (NullPointerException ee) {

            } catch (RuntimeException ee) {

            }
        }

    }
}