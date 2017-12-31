package com.KarmaLakeLand1;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class Customadapter extends BaseAdapter {

    private  Activity activity;
    String tournamentid;
    String tournamentfee;
    String image;
    ImageView img;
   
    List<Eventsandtournamentsgettersetter> cl;
    private static LayoutInflater inflater=null;
//    ProgressDialog pDialog;
    Bitmap bitmap;
    public Customadapter(Activity a, ArrayList<Eventsandtournamentsgettersetter> d) {
       
        // TODO Auto-generated constructor stub
    	cl=d;
        activity = a;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
    }
    @Override
	public int getCount() {
		// TODO Auto-generated method stub
		return cl.size();
	}


	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


    public View getView(final int position, View view, ViewGroup parent) {
    	View vi = view;
    	if (view == null)
    		vi = inflater.inflate(R.layout.listviewitemsofeventsandtournaments, null);
    	//img= new ImageView(activity);
    	//Button Registerhere= new Button(activity);
    	
        int loader=0;
        
        
       img = (ImageView) vi.findViewById(R.id.eventsandtourn);
       
      
       Button Registerhere= (Button)vi.findViewById(R.id.Registerhere);
       tournamentfee=cl.get(position).getTournamentFee();
       tournamentid =cl.get(position).getTournamentID();
      
       Registerhere.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent =new Intent(activity,EventTournaments.class);
			Bundle b = new Bundle();

            tournamentfee=cl.get(position).getTournamentFee();
			b.putString("tournamentFee",tournamentfee);
			tournamentid =cl.get(position).getTournamentID();
		    b.putString("tournamentID",tournamentid);
		    intent.putExtras(b);
			(activity).startActivity(intent);
		}
	});
       Imageloader imgLoader = new Imageloader(activity);
       String setDatatoView = cl.get(position).getImage();
       String image_url = "http://golfapp.webfreak.in/tournamentImages/"+setDatatoView;
   //    http://golf.parthinfosystems.com/tournamentImages/Tournament-241020150844.jpg
      
  //     new LoadImage().execute(image_url);
       
     imgLoader.DisplayImage(image_url, loader, img);  
        
     return vi;

    }
	
    
}
	

	
