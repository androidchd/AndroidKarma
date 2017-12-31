package com.KarmaLakeLand1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewContactAdapter extends BaseAdapter {

    Activity activity;

    List<Contactsgettersetter> cl;
    private static LayoutInflater inflater = null;

    public NewContactAdapter(Activity a, ArrayList<Contactsgettersetter> d) {

        // TODO Auto-generated constructor stub
        cl = d;
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
            vi = inflater.inflate(R.layout.contactsadapter, null);
        TextView name = (TextView) vi.findViewById(R.id.tv_name);

        name.setText(cl.get(position).getName());
        TextView number = (TextView) vi.findViewById(R.id.tv_details);
        number.setText(cl.get(position).getNumber());
        ImageView cross = (ImageView) vi.findViewById(R.id.cross);
        cross.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                cl.remove(position);
                notifyDataSetChanged();

            }
        });

        return vi;

    }


}


	
