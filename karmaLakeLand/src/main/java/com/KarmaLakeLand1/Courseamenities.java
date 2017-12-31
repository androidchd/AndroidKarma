package com.KarmaLakeLand1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Courseamenities extends Fragment {
	ImageView clab1;
	ImageView clab2;
	ImageView clab3;
	ImageView clab4;
	ImageView clab5;

	@Override
	public View onCreateView(LayoutInflater inflater,
		ViewGroup container, Bundle savedInstanceState) {
			 // Inflate the layout for this fragment
	View view= inflater.inflate(R.layout.courseamenities, container, false);

	clab1=(ImageView)view.findViewById(R.id.clab1);
	clab1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		  Intent i = new Intent(getActivity(),Courseamenities1.class);
		  startActivity(i);
		}
	});
	clab2=(ImageView)view.findViewById(R.id.clab2);
    clab2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getActivity(),Courseamenities2.class);
			  startActivity(i);
		}
	});
	clab3=(ImageView)view.findViewById(R.id.clab3);
    clab3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getActivity(),Courseamenities3.class);
			  startActivity(i);
		}
	});
    clab4=(ImageView)view.findViewById(R.id.clab4);
    clab4.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getActivity(),Courseamenities4.class);
			  startActivity(i);
		}
	});
    clab5=(ImageView)view.findViewById(R.id.clab5);
    clab5.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getActivity(),Courseamenities5.class);
			  startActivity(i);
		}
	});
	return view;
	}
	
	public static Courseamenities newInstance(String text) {

		Courseamenities f = new Courseamenities();
	        Bundle b = new Bundle();
	        b.putString("msg", text);

	        f.setArguments(b);

	        return f;

}}
