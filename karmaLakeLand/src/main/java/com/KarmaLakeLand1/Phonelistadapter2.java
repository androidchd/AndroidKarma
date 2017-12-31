package com.KarmaLakeLand1;

import java.util.ArrayList;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;



public class Phonelistadapter2  extends BaseAdapter implements Filterable{
	Context ctx;
	LayoutInflater lInflater;
	ArrayList<Contacts> arraylist;
	ArrayList<Contacts> objects;
	static String nameselected;
	String newname;
	
	static ArrayList<String> sb= new ArrayList<String>();
	String selected;

	Phonelistadapter2(Context context, ArrayList<Contacts> products) {
		ctx = context;
		objects = products;
		
		
		this.arraylist = new ArrayList<Contacts>();
		this.arraylist.addAll(products);
		lInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return objects.size();
	}

	@Override
	public Object getItem(int position) {
		return objects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = lInflater.inflate(R.layout.lv_layout1, parent, false);
		}

	final Contacts p = getProduct(position);
          
		((TextView) view.findViewById(R.id.tv_name)).setText(p.name);
		((TextView) view.findViewById(R.id.tv_details)).setText(p.phone);
		//((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.image);

	final CheckBox cbBuy = (CheckBox) view.findViewById(R.id.checkBox1);
		cbBuy.setTag(position);
		
	    
		cbBuy.setChecked(p.checkbox);
		cbBuy.setOnCheckedChangeListener(myCheckChangList);
		cbBuy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 if(cbBuy.isChecked())
				 {
					 
					
					
				
					
						//SMS.autoCompleteTextView.setText(p.getName());
					
					
					
					
					
					
					
					
					
				 }
				 if(cbBuy.isChecked()==false)
				 {
					 
					//sb.remove(p.getName());
					
					
					
					
					/*Tests.inputSearch..appen(nameselected);
					 
				Tests.numberselected.setText(" ");*/
				 }
				 
				 
				 
				// Tests.numberselected.setText(sb.toString());
			
			
			}
			
		});
		
		return view;
	}

	Contacts getProduct(int position) {
		
		return ((Contacts) getItem(position));
	}

	ArrayList<Contacts> getBox() {
		ArrayList<Contacts> box = new ArrayList<Contacts>();
		for (Contacts p : objects) {
			if (p.checkbox)
				
				box.add(p);
			
			
			
		}
		return box;
	}

	OnCheckedChangeListener myCheckChangList = new OnCheckedChangeListener() {
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			getProduct((Integer) buttonView.getTag()).checkbox = isChecked;
			
			
		}
	};
	
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		objects.clear();
		if (charText.length() == 0) {
			objects.addAll(arraylist);
		} else {
			for (Contacts wp : arraylist) {
				if (wp.getName().toLowerCase(Locale.getDefault())
						.contains(charText)) {
					
					
					objects.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}
}








