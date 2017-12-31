package com.KarmaLakeLand1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Scorecardadapter extends BaseAdapter {

    private  Activity activity;
    String tournamentid;
    String holenumber;
    List<Scorecardgettersetter2> cl;
    private static LayoutInflater inflater=null;

     public Scorecardadapter(Activity a, ArrayList<Scorecardgettersetter2> d) {
       
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
    		vi = inflater.inflate(R.layout.scorecardadapter, null);
    	 
    	  TextView holeno=(TextView)vi.findViewById(R.id.holeno);
    	  TextView parvvalue= (TextView)vi.findViewById(R.id.parvvalue);
    	  TextView score=(TextView)vi.findViewById(R.id.score);
    	  holenumber=cl.get(position).getHoles();
    	  
    	  
    	  
    	  
    	  holeno.setText(holenumber);
    	  parvvalue.setText(cl.get(position).getPar());
    	  score.setText(cl.get(position).getScore());
    	  
    	  
    	  
    	  
    	  
    	  
    	  /*TextView blackholedistance=(TextView)vi.findViewById(R.id.blackvalue);
    	  TextView redholedistance=(TextView)vi.findViewById(R.id.redvalue);
    	  TextView whiteholedistance=(TextView)vi.findViewById(R.id.whitevalue);
    	  TextView blueholedistance=(TextView)vi.findViewById(R.id.bluevalue);*/
    	
    	 /* if(holenumber.matches("1")||holenumber.matches("10"))
    	  {
    		  blackholedistance.setText("390");
    		  blueholedistance.setText("371");
    		  whiteholedistance.setText("359");
    		  redholedistance.setText("323");
    	  }
    	  if(holenumber.matches("2")|| holenumber.matches("11"))
    	  {
    		  blackholedistance.setText("152");
    		  blueholedistance.setText("141");
    		  whiteholedistance.setText("129");
    		  redholedistance.setText("104");
    	  }
    	  if(holenumber.matches("3")||holenumber.matches("12"))
    	  {
    		  blackholedistance.setText("183");
    		  blueholedistance.setText("165");
    		  whiteholedistance.setText("150");
    		  redholedistance.setText("124");
    		  
    	  }
    	  if(holenumber.matches("4")||holenumber.matches("13"))
    	  {
    		  blackholedistance.setText("519");
    		  blueholedistance.setText("496");
    		  whiteholedistance.setText("478");
    		  redholedistance.setText("440");
    	  }
    	  if(holenumber.matches("5")||holenumber.matches("14"))
    	  {
    		  blackholedistance.setText("390");
    		  blueholedistance.setText("371");
    		  whiteholedistance.setText("359");
    		  redholedistance.setText("323");
    	  }
    	  if(holenumber.matches("6")||holenumber.matches("15"))
    	  {
    		  blackholedistance.setText("207");
    		  blueholedistance.setText("170");
    		  whiteholedistance.setText("149");
    		  redholedistance.setText("117");
    	  }
    	  if(holenumber.matches("7")||holenumber.matches("16"))
    	  {
    		  blackholedistance.setText("410");
    		  blueholedistance.setText("391");
    		  whiteholedistance.setText("375");
    		  redholedistance.setText("333");
    	  }
    	  if(holenumber.matches("8")||holenumber.matches("17"))
    	  {
    		  blackholedistance.setText("223");
    		  blueholedistance.setText("216");
    		  whiteholedistance.setText("180");
    		  redholedistance.setText("162");
    	  }
    	  if(holenumber.matches("9")||holenumber.matches("18"))
    	  {
    		  blackholedistance.setText("390");
    		  blueholedistance.setText("361");
    		  whiteholedistance.setText("314");
    		  redholedistance.setText("283");
    	  }*/
        return vi;

    }


	

	
}
