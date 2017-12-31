package com.KarmaLakeLand1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {

	private  Activity activity;
//	String setDatatoView;
	List<Completedlist> cl;
	private static LayoutInflater inflater=null;

	public CustomListAdapter(Activity a, ArrayList<Completedlist> d) {

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
			vi = inflater.inflate(R.layout.listview_item, null);

		LinearLayout r1=(LinearLayout)vi.findViewById(R.id.ll);
		TextView time=(TextView) vi.findViewById(R.id.time);

		TextView players=(TextView)vi.findViewById(R.id.players);

		TextView hole = (TextView) vi.findViewById(R.id.hole);
		TextView date=(TextView)vi.findViewById(R.id.date);
		if(cl.get(position).getSession().contains("BDR"))
		{
			time.setText(timeconversion1(cl.get(position).getTime()));
			//holeicon.setBackgroundResource(R.drawable.buket_image);
			hole.setText("Balls -"+cl.get(position).getBucket());
			players.setText("Players -"+cl.get(position).getPlayers());
			date.setText(cl.get(position).getDate());
		}
		else
		{
			time.setText(timeconversion1(cl.get(position).getTime()));
			//holeicon.setBackgroundResource(R.drawable.flag);
			hole.setText("Hole -"+cl.get(position).getHole());
			players.setText("Players -"+cl.get(position).getPlayers());
			date.setText(cl.get(position).getDate());

		}

		//String setDatatoView = cl.get(position).getTime()+"  "+cl.get(position).getHole()+" hole "+"   Players-"+cl.get(position).getPlayers()+"   "+cl.get(position).getDate();

		// hole.setText(setDatatoView);
		r1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(activity,Bookingdetail.class);
				i.putExtra("HOLE", cl.get(position).getHole());
				i.putExtra("bookStatus", cl.get(position).getBookStatus());
				i.putExtra("PLAYERS", cl.get(position).getPlayers());
				i.putExtra("AMOUNT",cl.get(position).getAmount());
				i.putExtra("DATE",cl.get(position).getDate());
				i.putExtra("TIME",cl.get(position).getTime());
				i.putExtra("Bucket",cl.get(position).getBucket());
				i.putExtra("ADDSON",cl.get(position).getAddOn());
				//Log.i("PaymentStatus",cl.get(position).getPaymentStatus());
				i.putExtra("PaymentStatus",cl.get(position).getPaymentStatus());
				i.putExtra("BookingID",cl.get(position).getBookingid());
				i.putExtra("Session",cl.get(position).getSession());
				(activity).startActivity(i);
			}
		});

		return vi;

	}


	public String timeconversion1(String input)
	{

		//Date/time pattern of input date
		DateFormat df = new SimpleDateFormat("HH:mm");
		//Date/time pattern of desired output date
		DateFormat outputformat = new SimpleDateFormat("hh:mm a");
		Date date = null;
		String output = null;
		try{
			//Conversion of input String to date
			date= df.parse(input);
			//old date format to new date format
			output = outputformat.format(date);
			System.out.println(output);
		}catch(ParseException pe){
			pe.printStackTrace();
		}
		return output;
	}


}


