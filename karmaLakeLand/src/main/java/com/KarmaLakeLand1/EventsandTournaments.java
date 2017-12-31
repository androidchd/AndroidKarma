package com.KarmaLakeLand1;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import Helper.App_Common;
import Utility.WebService;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class EventsandTournaments extends Fragment {
	ArrayList<Eventsandtournamentsgettersetter> imageslist;
	Eventsandtournamentsgettersetter evg;
	ListView itemsostouranements;
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
			 // Inflate the layout for this fragment
	View view= inflater.inflate(R.layout.eventsandtournaments, container, false);
	new Eventtournamentapi().execute();
	imageslist= new ArrayList<Eventsandtournamentsgettersetter>();
	itemsostouranements= (ListView)view.findViewById(R.id.itemsostouranements);

	return view;
	}
	public static EventsandTournaments newInstance(String text) {

		EventsandTournaments f = new EventsandTournaments();
	        Bundle b = new Bundle();
	        b.putString("msg", text);

	        f.setArguments(b);

	        return f;
	    }
	public class Eventtournamentapi extends AsyncTask<String, Void, Boolean> {

		protected ProgressDialog ringProgressDialog;
		


		@Override
		protected void onPreExecute()
		{
			ringProgressDialog = ProgressDialog.show(getActivity(), null, "Processing ... ", true);
			ringProgressDialog.setCancelable(false);
			super.onPreExecute();
		}

		@Override
		protected Boolean doInBackground(String... params)
		{
			
			try {
				
				
				JSONObject jsonObject = new JSONObject();
				
				
				
				
				
				

				Log.i("Input",jsonObject.toString());

				String response = WebService.GET(App_Common.WebServiceUrl+ "getAllTournamentDetail");
			
				Log.i(App_Common.TAG, response);
				Log.e("RESPONSE", response);

				if (response == null || response.equals("")) {
					return false;
				} 
	               
				else{
				JSONArray jsonresponse= new JSONArray(response);
				for(int i=0;i<jsonresponse.length();i++)
				{
					Eventsandtournamentsgettersetter evg= new Eventsandtournamentsgettersetter();
					
					JSONObject json= jsonresponse.getJSONObject(i);
					evg.setTournamentFee(json.getString("tournamentFee"));
					json.getString("tournamentHoles");
					evg.setTournamentID(json.getString("tournamentId"));
					String value=json.getString("tournamentId");
					Log.e("TournamentID",value);
					evg.setImage(json.getString("tournamentImgUrl"));
					json.getString("tournamentName");
					json.getString("tournamentStatus");
					json.getString("tournamentTax");
					json.getString("tournamentTime");
					imageslist.add(evg);
					
					
				}
				
			}
				
		}
			


			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			ringProgressDialog.dismiss();
			if (result)
			{
				
				Customadapter c= new Customadapter(getActivity(), imageslist);
				itemsostouranements.setAdapter(c); 
				
				
				
				
		 }
			else
			{
				
			}
		}
		
	}
}
