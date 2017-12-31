package com.KarmaLakeLand1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;
import com.paytm.pgsdk.PaytmMerchant;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import Helper.App_Common;
import Utility.WebService;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Addonsbooking extends FragmentActivity {
    int caddie18=0;
    Button continuebooking;
    Button carthole9;
    Button carthole18;
    Button caddiehole9;
    Button caddiehole18;

//    Context mContext;

    TextView cartprice;
    TextView caddiefee;
    TextView greenfee;
    TextView totalcaddiefee;
    TextView totalcartfee;
    TextView total;
    static int cartpricevalue = 0;
    static int caddiepricevalue = 0;
    int totalGreenfee = 0;
    int key = 0;
    LinearLayout check;
    LinearLayout check1;
    LinearLayout check2;
    LinearLayout check3;
    LinearLayout check4;
//    Ratecarddata r1 = new Ratecarddata();
    String bindParameter;
    protected ProgressDialog ringProgressDialog;

    LinearLayout couponlayout;
    TextView coupontext;

    ImageButton tv_header_title;
    int totalcaddiefees;
    int totalcartfees;
    static int totalcalculated;
    ImageView spinner1;
    ImageView spinner2;
    int amount;

    //layouts
    LinearLayout couponLayout;
    LinearLayout footerlayout;
    LinearLayout continuebookinglayout;
    LinearLayout namcardlayout;
    LinearLayout totalfeelayout;
    LinearLayout cartfeelayout;
    LinearLayout caddiefeelayout;
    LinearLayout totalamountlayout;
    LinearLayout greenfeelayout;
    LinearLayout sliding;
    String bookingid;
    boolean caddiefeeslected = false;
    boolean cartfeeselected = false;
    int key1 = 0;
    int totalcoupon;
    int carthole;
    int caddiehole;
    EditText couponcode;
    List<EditText> lisEditTexts;

    boolean hole18 = false;
    int cartfee;


    Button checksavings;
    static int couponamount = 0;

    RelativeLayout spin1;
    RelativeLayout spin2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addson);

        total = (TextView) findViewById(R.id.total);
        if (EventTournaments.eventtournament) {
            amount = EventTournaments.amountofeventtournament;
        } else {
            if (!Bookingdriverange.BDRtime) {
                if (!BookElectionFrgament.bookelectiontime) {
                } else {
                    amount = Addonsbooking.totalcalculated - Addonsbooking.couponamount;
                }
            } else {
                amount = Reviewbookingactivity.totalbucketcalculated - Reviewbookingactivity.couponamount;
            }
        }
        total.setText("Rs. " + String.valueOf(amount));


        //layouts]
        couponLayout = (LinearLayout) findViewById(R.id.couponCodeayout);

//        lisEditTexts = new ArrayList<EditText>();

        couponlayout = (LinearLayout) findViewById(R.id.couponlayout);
        coupontext = (TextView) findViewById(R.id.coupontext);
        sliding = (LinearLayout) findViewById(R.id.sliding);
        couponcode = (EditText) findViewById(R.id.couponcode);
        checksavings = (Button) findViewById(R.id.checksavings);
        spin1 = (RelativeLayout) findViewById(R.id.spin1);
        spin2 = (RelativeLayout) findViewById(R.id.spin2);
        footerlayout = (LinearLayout) findViewById(R.id.footerlayout);
        continuebookinglayout = (LinearLayout) findViewById(R.id.continuebookinglayout);
        namcardlayout = (LinearLayout) findViewById(R.id.namcardlayout);
        totalfeelayout = (LinearLayout) findViewById(R.id.totalfeelayout);
        cartfeelayout = (LinearLayout) findViewById(R.id.cartfeelayout);
        caddiefeelayout = (LinearLayout) findViewById(R.id.caddiefeelayout);
        totalamountlayout = (LinearLayout) findViewById(R.id.totalamountlayout);
        greenfeelayout = (LinearLayout) findViewById(R.id.greenfeelayout);

        try {
            caddiehole = Integer.parseInt(BookElectionFrgament.Caddiehole9);
        } catch (NumberFormatException ignored) {

        }
        try {
            carthole = Integer.parseInt(BookElectionFrgament.Carthole9);
        } catch (NumberFormatException ignored) {

        }


        carthole9 = (Button) findViewById(R.id.carthole9);

        carthole18 = (Button) findViewById(R.id.carthole18);
        carthole9.setText("Rs." + BookElectionFrgament.Carthole9 + " (9 Hole)");
        carthole9.setTextSize(10);
        carthole18.setText("Rs." + BookElectionFrgament.Carthole18 + "(18 Hole)");
        carthole18.setTextSize(10);
        spinner1 = (ImageView) findViewById(R.id.spinner1);
        spinner2 = (ImageView) findViewById(R.id.spinner2);
        caddiehole9 = (Button) findViewById(R.id.caddiehole9);
        caddiehole9.setText("Rs." + BookElectionFrgament.Caddiehole9 + " (9 Hole)");
        caddiehole9.setTextSize(10);
        caddiehole18 = (Button) findViewById(R.id.caddiehole18);
        caddiehole18.setText("Rs." + BookElectionFrgament.Caddiehole18 + " (18 Hole)");
        caddiehole18.setTextSize(10);
        cartprice = (TextView) findViewById(R.id.cartprice);
        caddiefee = (TextView) findViewById(R.id.caddiefee);
        greenfee = (TextView) findViewById(R.id.greenfee);
        totalcaddiefee = (TextView) findViewById(R.id.totalcaddiefee);
        totalcartfee = (TextView) findViewById(R.id.totalcartfee);

        greenfee.setText("Rs. " + String.valueOf(Reviewbooking.totalcalculated));
        tv_header_title = (ImageButton) findViewById(R.id.favriot);
        tv_header_title.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        checksavings.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (chkInputs()) {

                    new Couponcode().execute();
                } else {

                }
            }
        });

        spin1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                if (key == 0) {
                    key = 1;
                    cartfeeselected = true;
                    sliding.setVisibility(View.VISIBLE);
                    footerlayout.setVisibility(View.GONE);
                    continuebookinglayout.setVisibility(View.GONE);
                    namcardlayout.setVisibility(View.GONE);
                    totalfeelayout.setVisibility(View.GONE);
                    cartfeelayout.setVisibility(View.GONE);
                    caddiefeelayout.setVisibility(View.GONE);
                    totalamountlayout.setVisibility(View.GONE);
                    greenfeelayout.setVisibility(View.GONE);
                    couponLayout.setVisibility(View.GONE);

                } else if (key == 1) {
                    key = 0;
                    cartfeeselected = false;
                    sliding.setVisibility(View.GONE);
                    footerlayout.setVisibility(View.VISIBLE);
                    continuebookinglayout.setVisibility(View.VISIBLE);
                    namcardlayout.setVisibility(View.VISIBLE);
                    totalfeelayout.setVisibility(View.VISIBLE);
                    cartfeelayout.setVisibility(View.VISIBLE);
                    caddiefeelayout.setVisibility(View.VISIBLE);
                    totalamountlayout.setVisibility(View.VISIBLE);
                    greenfeelayout.setVisibility(View.VISIBLE);
                    couponLayout.setVisibility(View.VISIBLE);

                    //  btn.setBackgroundResource(R.drawable.collapse);
                }

            }
        });
        spin2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (key1 == 0) {
                    key1 = 1;
                    caddiefeeslected = true;
                    sliding.setVisibility(View.VISIBLE);
                    footerlayout.setVisibility(View.GONE);
                    continuebookinglayout.setVisibility(View.GONE);
                    namcardlayout.setVisibility(View.GONE);
                    totalfeelayout.setVisibility(View.GONE);
                    cartfeelayout.setVisibility(View.GONE);
                    caddiefeelayout.setVisibility(View.GONE);
                    totalamountlayout.setVisibility(View.GONE);
                    greenfeelayout.setVisibility(View.GONE);
                    couponLayout.setVisibility(View.GONE);

                } else if (key1 == 1) {
                    key1 = 0;
                    caddiefeeslected = false;
                    sliding.setVisibility(View.GONE);
                    footerlayout.setVisibility(View.VISIBLE);
                    continuebookinglayout.setVisibility(View.VISIBLE);
                    namcardlayout.setVisibility(View.VISIBLE);
                    totalfeelayout.setVisibility(View.VISIBLE);
                    cartfeelayout.setVisibility(View.VISIBLE);
                    caddiefeelayout.setVisibility(View.VISIBLE);
                    totalamountlayout.setVisibility(View.VISIBLE);
                    greenfeelayout.setVisibility(View.VISIBLE);
                    couponLayout.setVisibility(View.VISIBLE);

                    //  btn.setBackgroundResource(R.drawable.collapse);
                }


            }
        });
        check = (LinearLayout) findViewById(R.id.check_btt_0);
        check.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caddiefeeslected) {
                    if (hole18) {
                        caddiepricevalue = 0;
                        caddiefee.setText("0");
                        try {
                        } catch (NumberFormatException ignored) {

                        }
                        totalcaddiefees = 0;

                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                        caddiepricevalue = 0;
                        caddiefee.setText("0");
                        totalcaddiefees = 0;
                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }

                }
                if (cartfeeselected) {
                    if (!hole18) {
                        cartpricevalue = 0;
                        cartprice.setText("0");
                        totalcartfees = 0;

                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                        try {

                        } catch (NumberFormatException ignored) {

                        }
                        cartpricevalue = 0;
                        cartprice.setText("0");
                        totalcartfees = 0;

                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }
                }

                sliding.setVisibility(View.GONE);

                footerlayout.setVisibility(View.VISIBLE);
                continuebookinglayout.setVisibility(View.VISIBLE);
                namcardlayout.setVisibility(View.VISIBLE);
                totalfeelayout.setVisibility(View.VISIBLE);
                cartfeelayout.setVisibility(View.VISIBLE);
                caddiefeelayout.setVisibility(View.VISIBLE);
                totalamountlayout.setVisibility(View.VISIBLE);
                greenfeelayout.setVisibility(View.VISIBLE);
                couponLayout.setVisibility(View.VISIBLE);

                caddiefeeslected = false;
                cartfeeselected = false;


            }
        });

        check1 = (LinearLayout) findViewById(R.id.check1);
        check1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?


                if (caddiefeeslected) {
                    if (!hole18) {
                        caddiepricevalue = 1;
                        caddiefee.setText("1");
                        totalcaddiefees = caddiepricevalue * caddiehole;

                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                        int caddie18 = 0;
                        try {
                            caddie18 = Integer.parseInt(BookElectionFrgament.Caddiehole18);
                        } catch (NumberFormatException ignored) {

                        }
                        caddiepricevalue = 1;
                        caddiefee.setText("1");
                        totalcaddiefees = caddiepricevalue * caddie18;

                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }

                }
                if (cartfeeselected) {
                    if (hole18) {
                        int caart18 = 0;
                        try {
                            caart18 = Integer.parseInt(BookElectionFrgament.Carthole18);
                        } catch (NumberFormatException ignored) {

                        }
                        cartpricevalue = 1;
                        cartprice.setText("1");
                        totalcartfees = cartpricevalue * caart18;

                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                        cartpricevalue = 1;
                        cartprice.setText("1");
                        totalcartfees = cartpricevalue * carthole;

                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }
                }

                sliding.setVisibility(View.GONE);

                footerlayout.setVisibility(View.VISIBLE);
                continuebookinglayout.setVisibility(View.VISIBLE);
                namcardlayout.setVisibility(View.VISIBLE);
                totalfeelayout.setVisibility(View.VISIBLE);
                cartfeelayout.setVisibility(View.VISIBLE);
                caddiefeelayout.setVisibility(View.VISIBLE);
                totalamountlayout.setVisibility(View.VISIBLE);
                greenfeelayout.setVisibility(View.VISIBLE);
                couponLayout.setVisibility(View.VISIBLE);

                caddiefeeslected = false;
                cartfeeselected = false;


            }
        });


        //popofballs.setText(selectedcheck);
        check2 = (LinearLayout) findViewById(R.id.check2);

        check2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sliding.setVisibility(View.GONE);
                if (caddiefeeslected) {
                    if (!hole18) {
                        caddiefee.setText("2");
                        caddiepricevalue = 2;
                        totalcaddiefees = caddiepricevalue * caddiehole;
                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                        int caddie18 = 0;
                        try {
                            caddie18 = Integer.parseInt(BookElectionFrgament.Caddiehole18);
                        } catch (NumberFormatException ignored) {

                        }
                        caddiefee.setText("2");
                        caddiepricevalue = 2;
                        totalcaddiefees = caddiepricevalue * caddie18;
                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }
                }
                if (cartfeeselected) {
                    if (!hole18) {
                        cartprice.setText("2");
                        cartpricevalue = 2;
                        totalcartfees = cartpricevalue * carthole;

                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                        int caart18 = 0;
                        try {
                            caart18 = Integer.parseInt(BookElectionFrgament.Carthole18);
                        } catch (NumberFormatException ignored) {

                        }
                        cartprice.setText("2");
                        cartpricevalue = 2;
                        totalcartfees = cartpricevalue * caart18;
                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }
                }
                footerlayout.setVisibility(View.VISIBLE);
                continuebookinglayout.setVisibility(View.VISIBLE);
                namcardlayout.setVisibility(View.VISIBLE);
                totalfeelayout.setVisibility(View.VISIBLE);
                cartfeelayout.setVisibility(View.VISIBLE);
                caddiefeelayout.setVisibility(View.VISIBLE);
                totalamountlayout.setVisibility(View.VISIBLE);
                greenfeelayout.setVisibility(View.VISIBLE);
                caddiefeeslected = false;
                cartfeeselected = false;
                couponLayout.setVisibility(View.VISIBLE);

            }
        });
        check3 = (LinearLayout) findViewById(R.id.check3);
        check3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sliding.setVisibility(View.GONE);
                if (caddiefeeslected) {
                    if (!hole18) {
                        caddiefee.setText("3");
                        caddiepricevalue = 3;
                        totalcaddiefees = caddiepricevalue * caddiehole;
                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                        int caddie18 = 0;
                        try {
                            caddie18 = Integer.parseInt(BookElectionFrgament.Caddiehole18);
                        } catch (NumberFormatException ignored) {

                        }
                        caddiefee.setText("3");
                        caddiepricevalue = 3;
                        totalcaddiefees = caddiepricevalue * caddie18;
                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }
                }
                if (!cartfeeselected) {
                } else {
                    if (hole18) {
                        int caart18 = 0;
                        try {
                            caart18 = Integer.parseInt(BookElectionFrgament.Carthole18);
                        } catch (NumberFormatException ignored) {

                        }
                        cartprice.setText("3");
                        cartpricevalue = 3;
                        totalcartfees = cartpricevalue * caart18;

                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcartfees + totalcaddiefees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                        cartprice.setText("3");
                        cartpricevalue = 3;
                        totalcartfees = cartpricevalue * carthole;

                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcartfees + totalcaddiefees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }
                }

                footerlayout.setVisibility(View.VISIBLE);
                continuebookinglayout.setVisibility(View.VISIBLE);
                namcardlayout.setVisibility(View.VISIBLE);
                totalfeelayout.setVisibility(View.VISIBLE);
                cartfeelayout.setVisibility(View.VISIBLE);
                caddiefeelayout.setVisibility(View.VISIBLE);
                totalamountlayout.setVisibility(View.VISIBLE);
                greenfeelayout.setVisibility(View.VISIBLE);
                //    sliding.setVisibility(View.VISIBLE);
                caddiefeeslected = false;
                cartfeeselected = false;
                couponLayout.setVisibility(View.VISIBLE);
            }
        });
        check4 = (LinearLayout) findViewById(R.id.check4);
        check4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sliding.setVisibility(View.GONE);
                if (caddiefeeslected) {
                    if (!hole18) {
                        caddiefee.setText("4");
                        caddiepricevalue = 4;
                        totalcaddiefees = caddiepricevalue * caddiehole;

                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                         caddie18=0;
                        try {
                            caddie18 = Integer.parseInt(BookElectionFrgament.Caddiehole18);
                        } catch (NumberFormatException ignored) {

                        }
                        caddiefee.setText("4");
                        caddiepricevalue = 4;
                        totalcaddiefees = caddiepricevalue * caddiehole;

                        totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                        totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }
                }
                if (!cartfeeselected) {
                } else {
                    if (hole18) {
                        int caart18 = 0;
                        try {
                            caart18 = Integer.parseInt(BookElectionFrgament.Carthole18);
                        } catch (NumberFormatException ignored) {

                        }
                        cartprice.setText("4");
                        cartpricevalue = 4;
                        totalcartfees = cartpricevalue * caart18;

                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + cartfee + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    } else {
                        cartprice.setText("4");
                        cartpricevalue = 4;
                        totalcartfees = cartpricevalue * carthole;

                        totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                        totalcalculated = (Reviewbooking.totalcalculated) + cartfee + totalcartfees;
                        total.setText("Rs. " + String.valueOf(totalcalculated));
                    }
                }
                //check4.setChecked(false);
                footerlayout.setVisibility(View.VISIBLE);
                continuebookinglayout.setVisibility(View.VISIBLE);
                namcardlayout.setVisibility(View.VISIBLE);
                totalfeelayout.setVisibility(View.VISIBLE);
                cartfeelayout.setVisibility(View.VISIBLE);
                caddiefeelayout.setVisibility(View.VISIBLE);
                totalamountlayout.setVisibility(View.VISIBLE);
                greenfeelayout.setVisibility(View.VISIBLE);
                caddiefeeslected = false;
                cartfeeselected = false;
                couponLayout.setVisibility(View.VISIBLE);
            }
        });

        continuebooking = (Button) findViewById(R.id.addscontinuebooking);

        continuebooking.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                ringProgressDialog = ProgressDialog.show(Addonsbooking.this, null, "Processing ... ", true);
                ringProgressDialog.setCancelable(false);
                EventTournaments.eventtournament = false;
                onStartTransaction(v);
            }

                 /* Intent i = new Intent(Addonsbooking.this, MakePayment.class);

                  startActivity(i);*/


        });

        carthole9.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                hole18 = false;
                // TODO Auto-generated method stub
                carthole9.setBackgroundColor(Color.parseColor("#3061e5"));
                carthole9.setTextColor(Color.parseColor("#FFFFFF"));
                carthole18.setBackgroundResource(R.drawable.buttonstyle);
                carthole18.setTextColor(Color.parseColor("#000000"));

                carthole = Integer.parseInt(BookElectionFrgament.Carthole9);

                totalcartfees = cartpricevalue * carthole;

                totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                System.out.println("Cardfees value" + Integer.toString(totalcaddiefees));
                totalcalculated = (Reviewbooking.totalcalculated) + (totalcartfees) + (totalcaddiefees);
                total.setText("Rs. " + String.valueOf(totalcalculated));
            }
        });
        carthole18.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                hole18 = true;

                // TODO Auto-generated method stub
                carthole18.setBackgroundColor(Color.parseColor("#3061e5"));
                carthole18.setTextColor(Color.parseColor("#FFFFFF"));
                carthole9.setBackgroundResource(R.drawable.buttonstyle);
                carthole9.setTextColor(Color.parseColor("#000000"));
                try {
                    carthole = Integer.parseInt(BookElectionFrgament.Carthole18);
                } catch (NumberFormatException ignored) {

                }
                totalcartfees = cartpricevalue * carthole;

                totalcartfee.setText("Rs. " + Integer.toString(totalcartfees));
                System.out.println("Totalcaddiefess" + Integer.toString(totalcaddiefees));
                System.out.println("Totalcartfees" + Integer.toString(totalcartfees));
                int minitotal = totalcaddiefees + totalcartfees;
                System.out.println("Minitotal" + Integer.toString(minitotal));
                int greenfee = Reviewbooking.totalcalculated;
                System.out.println("Greenfee" + Integer.toString(greenfee));
                totalcalculated = (greenfee + minitotal);
                System.out.println("Totalcalculated" + Integer.toString(totalcalculated));
                System.out.println("Minitotal" + Integer.toString(minitotal));
                total.setText("Rs. " + String.valueOf(totalcalculated));
            }
        });
        caddiehole9.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                hole18 = false;

                // TODO Auto-generated method stub
                caddiehole9.setBackgroundColor(Color.parseColor("#3061e5"));
                caddiehole9.setTextColor(Color.parseColor("#FFFFFF"));
                caddiehole18.setBackgroundResource(R.drawable.buttonstyle);
                caddiehole18.setTextColor(Color.parseColor("#000000"));

                caddiehole = Integer.parseInt(BookElectionFrgament.Caddiehole9);
                totalcaddiefees = caddiepricevalue * caddiehole;

                totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                total.setText("Rs. " + String.valueOf(totalcalculated));
            }
        });
        caddiehole18.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                hole18 = true;

                // TODO Auto-generated method stub
                caddiehole18.setBackgroundColor(Color.parseColor("#3061e5"));
                caddiehole18.setTextColor(Color.parseColor("#FFFFFF"));


                caddiehole9.setBackgroundResource(R.drawable.buttonstyle);
                caddiehole9.setTextColor(Color.parseColor("#000000"));
                try {
                    caddiehole = Integer.parseInt(BookElectionFrgament.Caddiehole18);
                } catch (NumberFormatException ignored) {

                }
                totalcaddiefees = caddiepricevalue * caddiehole;

                totalcaddiefee.setText("Rs. " + Integer.toString(totalcaddiefees));
                totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                total.setText("Rs. " + String.valueOf(totalcalculated));

            }
        });

        if (BookElectionFrgament.hole == 18) {
            totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
            total.setText(String.valueOf("Rs. " + totalcalculated));
        } else {
            totalcalculated = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
            total.setText(String.valueOf("Rs. " + totalcalculated));
        }
    }

//    private boolean isNetworkConnected() {
//        ConnectivityManager cm = (ConnectivityManager) (mContext.getSystemService(Context.CONNECTIVITY_SERVICE));
//        return cm.getActiveNetworkInfo() != null;
//    }

    private class Couponcode extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;

        @Override
        protected void onPreExecute() {
            bindParameter = couponcode.getText().toString();
            ringProgressDialog = ProgressDialog.show(Addonsbooking.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String url = bindParameter;

            try {

//                JSONObject jsonObject = new JSONObject();

                String response = WebService.GET(App_Common.WebServiceUrl + "getCoupon/" + url);
                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("cstatus");

                    if (status.contains("True")) {

                        couponamount = Integer.parseInt(jsonresponse.getString("cAmount"));


                        return true;

                    } else {
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
            couponlayout.setVisibility(View.VISIBLE);
            if (result) {

                try {
                    TextView couponDiscount = (TextView) findViewById(R.id.total_discount);
                    if (Reviewbooking.totalgreenfeecalculted >= couponamount) {
                        couponDiscount.setText("Rs. " + "-" + couponamount);
                        coupontext.setText("Congratulations! Rs." + Integer.toString(couponamount) + "/- discount has been applied to your booking account");
                        totalGreenfee = Reviewbooking.totalgreenfeecalculted - couponamount;
                    } else if (Reviewbooking.totalgreenfeecalculted < couponamount) {
                        if (Reviewbooking.totalgreenfeecalculted == 0) {
                            coupontext.setText("Sorry! Your Green fee already 0. Coupon code applied on Green fee only ");
                            totalGreenfee = 0;
                        } else if (Reviewbooking.totalgreenfeecalculted < couponamount) {
                            coupontext.setText("Congratulations! Rs." + Integer.toString(couponamount) + "/- discount has been applied to your booking account");
                            totalGreenfee = 0;
                        }


                    }
                    totalcoupon = totalGreenfee + (Reviewbooking.totaltaccalculation) + totalcaddiefees + totalcartfees;

                    //  totalcoupon = (Reviewbooking.totalcalculated) + totalcaddiefees + totalcartfees;
                    totalcalculated = totalcoupon;

                    total.setText("Rs. " + String.valueOf(totalcalculated));

                    couponcode.setText("");
                } catch (NullPointerException ignored) {

                }
                //Toast.makeText(getApplicationContext(), "Congratulations you have get an coupon amount of "+Integer.toString(couponamount),Toast.LENGTH_LONG).show();
            } else {
                coupontext.setText("Oops! The coupon code entered is either invalid or has expired.");
                couponcode.setText("");
                //	Toast.makeText(getApplicationContext(), "Invalid coupon code",Toast.LENGTH_LONG).show();
            }
        }
    }

    boolean chkInputs() {

        if (lisEditTexts.isEmpty()) {
            lisEditTexts.add(couponcode);

        }

        for (EditText editText : lisEditTexts) {

            if (editText.getText().toString().length() == 0) {
                editText.setError("Please enter the coupon code.");
                return false;
            }

        }
        return true;
    }

    public void onStartTransaction(View view) {
        String url = "https://secure.paytm.in/oltp-web/processTransaction";
        String emial = App_Common.getInstance(Addonsbooking.this).getUserEmailId();
        String mobile = App_Common.getInstance(Addonsbooking.this).getUserNumber();
        int total = totalcalculated;
        PaytmPGService Service = PaytmPGService.getProductionService();
        //Service = PaytmPGService.getStagingService();
        //Service = PaytmPGService.getProductionService();

        Map<String, String> paramMap = new HashMap<>();

        // these are mandatory parameters
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000000);

        paramMap.put("REQUEST_TYPE", "DEFAULT");
        paramMap.put("MID", "Appcen82465872859698");
        paramMap.put("ORDER_ID", String.valueOf(randomInt));
        paramMap.put("CUST_ID", App_Common.getInstance(Addonsbooking.this).getUserID()+String.valueOf(randomInt));
        paramMap.put("TXN_AMOUNT", Integer.toString(total));
        paramMap.put("CHANNEL_ID", "WAP");
        paramMap.put("INDUSTRY_TYPE_ID", "Retail92");
        paramMap.put("WEBSITE", "AppcenWAP");
        paramMap.put("THEME", "merchant");
        paramMap.put("EMAIL", emial);
        paramMap.put("MOBILE_NO", mobile);
        paramMap.put("CALLBACK_URL", url);


        PaytmOrder Order = new PaytmOrder(paramMap);

        PaytmMerchant Merchant = new PaytmMerchant("http://50.62.134.38:9191/GenerateChecksum.aspx", "http://50.62.134.38:9191/VerifyChecksum.aspx");


        Service.initialize(Order, Merchant, null);
        ringProgressDialog.dismiss();
        Service.startPaymentTransaction(Addonsbooking.this, true, true,
                new PaytmPaymentTransactionCallback() {

                    @Override
                    public void someUIErrorOccurred(String inErrorMessage) {

                        Toast.makeText(Addonsbooking.this, "Payment Transaction is unsuccessful ", Toast.LENGTH_LONG).show();
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
                        Log.d("LOG", "Congratulations! Your booking is confirmed " + inResponse);
                        //   Toast.makeText(Addonsbooking.this, "Congratulations! Your booking is confirmed", Toast.LENGTH_LONG).show();

                        if (!EventTournaments.eventtournament) {
                            new Bookingelection().execute();
                            //new Addtournamnet().execute();
                        } else {
                            new Addtournamnet().execute();
                            // new Bookingelection().execute();
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
                        Toast.makeText(Addonsbooking.this, "Payment Transaction Failed Please Re-try", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void networkNotAvailable() {
                        // If network is not
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

    private class Bookingelection extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(Addonsbooking.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                JSONObject jsonObject = new JSONObject();


                jsonObject.accumulate("userId", App_Common.getInstance(Addonsbooking.this).getUserID());
                if (!BookElectionFrgament.bookelectiontime) {
                    if (Bookingdriverange.BDRtime) {

                        jsonObject.accumulate("hole", "0");
                        jsonObject.accumulate("date", String.valueOf(Bookingdriverange.formattedDate));
                        jsonObject.accumulate("time", Bookingdriverange.timeselected);
                        jsonObject.accumulate("session", "BDR");
                        jsonObject.accumulate("bucket", Bookingdriverange.bucketselected);
                        jsonObject.accumulate("player", String.valueOf(Bookingdriverange.playerselected));
                        App_Common.getInstance(Addonsbooking.this).setDate(Bookingdriverange.formattedDate);
                        jsonObject.accumulate("member", String.valueOf(Bookingdriverange.memberplayer));
                        jsonObject.accumulate("nonmember", String.valueOf(Bookingdriverange.nonmemberplayer));

                    }
                } else {

                    jsonObject.accumulate("hole", String.valueOf(BookElectionFrgament.hole));
                    jsonObject.accumulate("date", String.valueOf(BookElectionFrgament.formattedDate));
                    jsonObject.accumulate("time", BookElectionFrgament.timeselected);
                    jsonObject.accumulate("session", "BTT");
                    jsonObject.accumulate("bucket", "0");
                    App_Common.getInstance(Addonsbooking.this).setDate(BookElectionFrgament.formattedDate);
                    jsonObject.accumulate("player", String.valueOf(BookElectionFrgament.playerselected));

                    jsonObject.accumulate("cart", String.valueOf(cartpricevalue));
                    jsonObject.accumulate("canddi", String.valueOf(caddiepricevalue));
                    jsonObject.accumulate("member", String.valueOf(BookElectionFrgament.memberplayer));
                    jsonObject.accumulate("nonmember", String.valueOf(BookElectionFrgament.nonmemberplayer));
                }
                jsonObject.accumulate("addOn", " ");
                jsonObject.accumulate("amount", String.valueOf(Addonsbooking.totalcalculated));
                jsonObject.accumulate("paymentMode", "netbanking");
                jsonObject.accumulate("sessionType", Integer.toString(TimeselectionFragment.sessiontype));

               /* jsonObject.accumulate("addoncart", String.valueOf(cartpricevalue));
                jsonObject.accumulate("addoncadi", String.valueOf(caddiepricevalue));
                jsonObject.accumulate("member", String.valueOf(BookElectionFrgament.memberplayer));
                jsonObject.accumulate("nonmember", String.valueOf(BookElectionFrgament.nonmemberplayer));*/
                Log.i("Input", jsonObject.toString());

                String response = WebService.POST(App_Common.WebServiceUrl + "golfBooking", jsonObject.toString());


                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("bookStatus");
                    if (status.contains("Error")) {
                        return false;
                    } else {
                        bookingid = jsonresponse.getString("bookId");
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
            if (result) {

                Intent i = new Intent(Addonsbooking.this, Bookingconfirmation.class);
                i.putExtra("Bookingid", bookingid);


                startActivity(i);

            } else {

            }
        }
    }

    private class Addtournamnet extends AsyncTask<String, Void, Boolean> {

        protected ProgressDialog ringProgressDialog;
        String userId = App_Common.getInstance(Addonsbooking.this).getUserID();


        @Override
        protected void onPreExecute() {
            ringProgressDialog = ProgressDialog.show(Addonsbooking.this, null, "Processing ... ", true);
            ringProgressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String userid = userId;
            try {

                JSONObject jsonObject = new JSONObject();

                jsonObject.accumulate("userId", userid);
                jsonObject.accumulate("tournamentId", EventTournaments.tournamentid);
                jsonObject.accumulate("players", EventTournaments.playerselcted);
                jsonObject.accumulate("addon", "");
                jsonObject.accumulate("amount", 200 * EventTournaments.playerselcted);
                jsonObject.accumulate("paymentMode", "netbanking");

                jsonObject.accumulate("playerdetail", EventTournaments.playerdetail);


                Log.i("Input", jsonObject.toString());

                String response = WebService.POST(App_Common.WebServiceUrl + "addTournamentDetail", jsonObject.toString());


                Log.e("RESPONSE", response);

                if (response == null || response.equals("")) {
                    return false;
                } else {
                    JSONObject jsonresponse = new JSONObject(response);
                    String status = jsonresponse.getString("bookStatus");
                    if (status.contains("Error")) {
                        return false;
                    } else {
                        bookingid = jsonresponse.getString("bookId");
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
            if (result) {

                Intent i = new Intent(Addonsbooking.this, Bookingconfirmation1.class);

                i.putExtra("Bookingid", bookingid);
                startActivity(i);

            } else {

            }
        }
    }

}



