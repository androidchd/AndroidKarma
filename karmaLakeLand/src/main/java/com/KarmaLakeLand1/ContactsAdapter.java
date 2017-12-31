package com.KarmaLakeLand1;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ContactsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Phonelist> contacts = null;

    public ContactsAdapter(Context context, ArrayList<Phonelist> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = null;
        View gridView;
        try {

            if (convertView != null) {
                gridView = new View(context);
                gridView = inflater.inflate(R.layout.contact, null);
                TextView textName = (TextView) gridView.findViewById(R.id.name);
                textName.setText(contacts.get(position).getName());

                TextView textMobile = (TextView) gridView.findViewById(R.id.mobile);
                textMobile.setText(contacts.get(position).getPhonenumber());

            } else {

                 convertView =null;
            }


        } catch (NullPointerException e) {

        }
        return convertView;
    }

    @Override
    public int getCount() {


        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
