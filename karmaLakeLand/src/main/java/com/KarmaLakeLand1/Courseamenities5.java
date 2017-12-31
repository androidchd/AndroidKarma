package com.KarmaLakeLand1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageButton;

public class Courseamenities5 extends FragmentActivity{
	ImageButton tv_header_title;
//	TextView description1;
//	TextView description2;
//	TextView description3;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.courseamenities9);
		WebView webView = (WebView)findViewById(R.id.webview1);
		webView.loadUrl("file:///android_asset/test5.html");
		 tv_header_title=(ImageButton)findViewById(R.id.favriot);
			tv_header_title.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				finish();	
				}

				
			});

	
}
	}
