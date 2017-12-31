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

public class Submitscorecardadapter extends BaseAdapter {

    private Activity activity;
    String tournamentid;
    int sumMin,sumCost;
    public static ArrayList<Scorecardgetterandsetter> arrayList = new ArrayList<Scorecardgetterandsetter>();
    List<Scorecardgetterandsetter> cl;
    private static LayoutInflater inflater = null;

    public Submitscorecardadapter(Activity a, ArrayList<Scorecardgetterandsetter> d) {

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


    public View getView(int position, View view, ViewGroup parent) {
        View vi = view;
        if (view == null)
            vi = inflater.inflate(R.layout.submitscorecardlist, null);
        TextView date = (TextView) vi.findViewById(R.id.date);
        TextView holeno = (TextView) vi.findViewById(R.id.holeno);
        TextView parvvalue = (TextView) vi.findViewById(R.id.parvvalue);
        TextView GrossScore =(TextView)vi.findViewById(R.id.tvGrossScore);

        TextView score = (TextView) vi.findViewById(R.id.score);
        System.out.println("adapter hole" + cl.get(position).getHoleNo());
        holeno.setText(cl.get(position).getHoleNo());
        parvvalue.setText(cl.get(position).getParValue());
        score.setText(cl.get(position).getScore());
        date.setText("DATE -" + cl.get(position).getDate());
        return vi;

    }



}
