package com.KarmaLakeLand1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageButton;

public class PrivacyPolicy extends Activity{

	ImageButton favriot;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.privacypolicy);
		
		
	
		WebView webView = (WebView)findViewById(R.id.webviewterms);
		webView.loadUrl("file:///android_asset/Privacy.html");
		
		
		
		
		
	    favriot=(ImageButton)findViewById(R.id.favriot);
	    favriot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();	
			}
		});
	}
	
	
}
