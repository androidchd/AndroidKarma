package com.KarmaLakeLand1;

import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Helper.App_Common;
import Utility.WebService;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ResolveInfo;
//import android.graphics.Bitmap;
//import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.Button;
import android.widget.ImageButton;
//import android.widget.ImageView;
import android.widget.ListView;

public class SubmitScorecard extends FragmentActivity {
    ArrayList<Scorecardgetterandsetter> scorecardlist;

    ListView itemsofscorecard;
//    Button scorecardshare;
//    ImageView linkedin;
//    ImageView googleicon;
//    ImageView facebookicon;
//    ImageView twittericon;
//    String filePath;
    File imageFile;
//    Boolean screenshot = false;
    ImageButton favriot;
//    int sumofStroke = 0;
//    int sumofPAR = 0;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //Call your share() here.
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submitscorecard);
       // takeScreenshot();
        favriot = (ImageButton) findViewById(R.id.favriot);

        favriot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });


        App_Common.getInstance(SubmitScorecard.this).setHolescore1("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore2("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore3("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore4("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore5("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore6("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore7("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore8("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore9("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore10("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore11("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore12("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore13("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore14("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore15("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore16("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore17("");
        App_Common.getInstance(SubmitScorecard.this).setHolescore18("");




        scorecardlist = new ArrayList<Scorecardgetterandsetter>();
        itemsofscorecard = (ListView) findViewById(R.id.itemsofscorecard);
        new Getholescore().execute();


    }


    public class Getholescore extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(SubmitScorecard.this, null, "Retrieving your scorecards", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

//                JSONObject jsonObject = new JSONObject();

                //userId, detailScore, scoreDate,holes


                String response = WebService.GET(App_Common.WebServiceUrl + "getHolesScore" + "/" + App_Common.getInstance(SubmitScorecard.this).getUserID());

                Log.i(App_Common.TAG, response);
                Log.e("RESPONSE", response);
                JSONArray jsonarray = new JSONArray(response);
                for (int k = 0; k < jsonarray.length(); k++) {
                    Scorecardgetterandsetter st = new Scorecardgetterandsetter();
                    ArrayList<Integer> holes = new ArrayList<Integer>();
                    ArrayList<Integer> pars = new ArrayList<Integer>();
                    ArrayList<Integer> strock = new ArrayList<Integer>();
                    JSONObject jsonobject1 = jsonarray.getJSONObject(k);
                    JSONArray j1 = jsonobject1.getJSONArray("detailScore");
                    for (int j = 0; j < j1.length(); j++) {
                        try{
                        JSONObject jsonobject2 = j1.getJSONObject(j);
                        st.setHoleNo(jsonobject2.getString("holeNo"));
                        holes.add(jsonobject2.getInt("holeNo"));
                        st.setParValue(jsonobject2.getString("Par"));

                        pars.add(jsonobject2.getInt("Par"));
                        strock.add(jsonobject2.getInt("strock"));
                        Log.i("Par ", jsonobject2.getString("Par"));
                        Log.i("Hole no ", jsonobject2.getString("holeNo"));
                        Log.i("Penalty ", jsonobject2.getString("penality"));
                        Log.i("Putts ", jsonobject2.getString("putts"));
                        Log.i("Strock ", jsonobject2.getString("strock"));
                        st.setHoles(holes);
                        st.setParvalue(pars);
                        st.setScores(strock);
                        st.setScore(jsonobject2.getString("strock"));
                    }catch (NullPointerException ee){

                        }
                    }
                    Log.i("Holes ", jsonobject1.getString("holes"));
                    st.setDate(jsonobject1.getString("scoreDate"));
                    st.setTime(jsonobject1.getString("stime"));
                    scorecardlist.add(st);
                }


                if (response == null || response.equals("")) {
                    return false;
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

                Submitscorecardadapter1 a1 = new Submitscorecardadapter1(SubmitScorecard.this, scorecardlist);
                itemsofscorecard.setAdapter(a1);

            } else {

            }
        }
    }

//    private void takeScreenshot() {
//        Date now = new Date();
//        android.text.format.DateFormat.format("dd-MM-yyyy_hh:mm:ss", now);
//
//        try {
//            // image naming and path  to include sd card  appending name you choose for file
//            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";
//
//            // create bitmap screen capture
//            View v1 = getWindow().getDecorView().getRootView();
//            v1.setDrawingCacheEnabled(true);
//            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
//            saveBitmap(bitmap);
//            v1.setDrawingCacheEnabled(false);
//
//            imageFile = new File(mPath);
//
//            FileOutputStream outputStream = new FileOutputStream(imageFile);
//            int quality = 100;
//            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
//            outputStream.flush();
//            outputStream.close();
//
//            // openScreenshot(imageFile);
//        } catch (Throwable e) {
//            // Several error may come out with file handling or OOM
//            e.printStackTrace();
//        }
//    }

//    private void openScreenshot(File imageFile) {
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        Uri uri = Uri.fromFile(imageFile);
//        intent.setDataAndType(uri, "image ");
//        startActivity(intent);
//    }

//    public void twitter() {
//        String msg = "Scorecard";
//        String tweetUrl = String.format(
//                "https://twitter.com/intent/tweet?text=%s&url=%s", msg, "");
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));
//        //	Uri uri = Uri.parse();
//
//        Boolean twitterAppFound = false;
//        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(
//                intent, 0);
//        for (ResolveInfo info : matches) {
//            if (info.activityInfo.packageName.toLowerCase().startsWith(
//                    "com.twitter")) {
//                intent.setPackage(info.activityInfo.packageName);
//                twitterAppFound = true;
//                intent.setType("image/png");
//
//                Uri uri = Uri.fromFile(imageFile);
//                intent.setDataAndType(uri, "image ");
//
//                        intent.putExtra(Intent.EXTRA_STREAM, uri);
//                startActivity(intent);
//            } else if (!twitterAppFound) {
//                intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri
//                        .parse("market://details?id=com.twitter.android"));
//                startActivity(intent);
//            }
//        }
//
//    }

    public void facebook() {
        String msg = "";
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

                Uri uri = Uri.fromFile(imageFile);
                intent.setDataAndType(uri, "image ");

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
//        String msg = "";
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
//        intent.setType("image/png");
//
//        Uri uri = Uri.fromFile(imageFile);
//        intent.setDataAndType(uri, "image ");
//
//                intent.putExtra(Intent.EXTRA_STREAM, uri);
//
//        startActivity(intent);
//    }


//    public void linkedin() {
//        String msg = "";
//
//        String tweetUrl = String.format(
//                "https://twitter.com/intent/tweet?text=%s&url=%s", msg, "");
//
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));
//        intent.setType("text/plain");
//
//        Boolean linkedinApp = false;
//        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(
//                intent, 0);
//        for (ResolveInfo info : matches) {
//            if (info.activityInfo.packageName.toLowerCase().startsWith(
//                    "com.linkedin.android")) {
//                intent.setPackage(info.activityInfo.packageName);
//                linkedinApp = true;
//                intent.setType("image/png");
//
//
//                intent.setType("image/png");
//
//                Uri uri = Uri.fromFile(imageFile);
//                intent.setDataAndType(uri, "image ");
//
//                        intent.putExtra(Intent.EXTRA_STREAM, uri);
//
//                startActivity(intent);
//
//            } else if (!linkedinApp) {
//                intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.linkedin.android&hl=en"));
//                startActivity(intent);
//            }
//
//        }
//
//    }


//    public void saveBitmap(Bitmap bitmap) {
//        filePath = Environment.getRootDirectory()
//                + File.separator + "Pictures/screenshot.png";
//        File imagePath = new File(filePath);
//        FileOutputStream fos;
//        try {
//            fos = new FileOutputStream(imagePath);
//            bitmap.compress(CompressFormat.PNG, 100, fos);
//            fos.flush();
//            fos.close();
//
//        } catch (FileNotFoundException e) {
//            Log.e("GREC", e.getMessage(), e);
//        } catch (IOException e) {
//            Log.e("GREC", e.getMessage(), e);
//        }
//    }
    }
