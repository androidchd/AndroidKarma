package com.KarmaLakeLand1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/*
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;*/

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class WebService {

	public static String POST(String url, String stringEntity) {


	{

		InputStream inputStream = null;
		String result = "";


		try {  

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			StringEntity se = new StringEntity(stringEntity);
			httpPost.setEntity(se);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			HttpResponse httpResponse = httpclient.execute(httpPost);
			inputStream = httpResponse.getEntity().getContent();

			// 10. convert inputstream to string
			if (inputStream != null)
			{
				result = convertInputStreamToString(inputStream);
				inputStream.close();
				httpPost.abort();

			}

			else
			{
				result = null;// "Did not work!";
				httpPost.abort();
			}
		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
			result = null;
		}
		// 11. return result



		return result;
	}}

	public static String GET(String url) 
	{

		InputStream inputStream = null;
		String result = "";


		try {  

			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			Log.i("URL", ""+url);


			httpget.setHeader("Accept", "application/json");
			httpget.setHeader("Content-type", "application/json");

			HttpResponse httpResponse = httpclient.execute(httpget);
			inputStream = httpResponse.getEntity().getContent();

			// 10. convert inputstream to string
			if (inputStream != null)
			{
				result = convertInputStreamToString(inputStream);
				inputStream.close();
				httpget.abort();

			}

			else
			{
				result = null;// "Did not work!";
				httpget.abort();
			}
		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
			result = null;
		}
		// 11. return result



		return result;
	}

	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;
	}


	}



