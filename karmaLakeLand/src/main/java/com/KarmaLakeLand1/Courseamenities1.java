package com.KarmaLakeLand1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageButton;

public class Courseamenities1 extends FragmentActivity{
	ImageButton tv_header_title;
//	TextView description1;
//	TextView description2;
//	TextView description3;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.courseamenities1);
		WebView webView = (WebView)findViewById(R.id.webview1);
		webView.loadUrl("file:///android_asset/test.html");
		 tv_header_title=(ImageButton)findViewById(R.id.favriot);
			tv_header_title.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				finish();	
				}

				
			});
		 /*description1=(TextView)findViewById(R.id.description1);
		 description2=(TextView)findViewById(R.id.description2);
		 description3=(TextView)findViewById(R.id.description3);
		 
		 description1.setText("Introducing Karma Lakelands, where nature and luxury come together to give you all that you desire. Here you shall find\nLuxurius modern and contemporary villas with spacious front and back lawns.\nA sustainable biosphere, abundant in flora and wildlife.\n An international standard, professionally managed golf course");
		 description2.setText("A fully equipped club-house, Klub Karma, with ultra-moderm facilities.\nKarma Day Care, an initiative for under privileged childeren.\nEco-responsible initiatives like bee farming, water harvesting,non-smoking golf course, no-horn campus, organic Kitchen\ngardening, solar heaters and recycling .");
		 description3.setText("What's more, karma lakelands is situated in close proximity to some of the most renowned school in the country like Pathways International,GD Geonka and Starex International, and multi-specialty hospital like Rockland with 350 beds, located just 2 kms away at a 5 minute drive, in addition to Max, Artemis, Apollo, Shriram, Park, Paras in New Gurgaon.Karma Lakelands, NH 8, Sector 80, Gurgaon, Haryana,\n +91 11 40644456, +91 9312808620 \n team@karmalakelands.com | www.karmalakelands.com ");
		
}*/
	
	}}