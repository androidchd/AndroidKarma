package com.KarmaLakeLand1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Submitscorecardadapter1 extends BaseAdapter {

    private Activity activity;
//    Context mContext;
    String tournamentid;
//    ArrayList<Integer> itemsimg = new ArrayList<Integer>();


    List<Scorecardgetterandsetter> cl;
    // private static LayoutInflater inflater = null;

    public Submitscorecardadapter1(Activity a, ArrayList<Scorecardgetterandsetter> d) {

        // TODO Auto-generated constructor stub
        cl = d;
        activity = a;
        //inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cl.size();
    }


    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return cl.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
//        itemsimg.add(R.drawable.clander_icon,R.drawable.arrow_icon);
        ImageView iv_arrow, iv_date;
        LinearLayout l1, noscorecard;
        TextView date, time;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.submitscorecardlist1, parent, false);
            date = (TextView) convertView.findViewById(R.id.scoreDate);
            time = (TextView) convertView.findViewById(R.id.time);
            iv_arrow = (ImageView) convertView.findViewById(R.id.iv_arrow);
            iv_date = (ImageView) convertView.findViewById(R.id.dateselection);
            noscorecard = (LinearLayout) convertView.findViewById(R.id.ll_no_scorcard);

            time.setText(cl.get(position).getTime());
            l1 = (LinearLayout) convertView.findViewById(R.id.linear1);
            convertView.setTag(iv_arrow);
            convertView.setTag(iv_date);
            convertView.setTag(l1);
            convertView.setTag(time);
            convertView.setTag(date);
            convertView.setTag(noscorecard);


            String substring = cl.get(position).getDate();
            String[] name = substring.split(" ");
//            String datescore = name[0];
            date.setText(name[0]);

            if (substring == null || substring.equals("")) {
                l1.setVisibility(View.GONE);
                noscorecard.setVisibility(View.VISIBLE);
            } else {
                l1.setVisibility(View.VISIBLE);
                noscorecard.setVisibility(View.GONE);
            }

            l1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent i = new Intent(activity, Scorecardtableview.class);
                    i.putExtra("Hole", cl.get(position).getHoleNo());
                    i.putExtra("Parvalue", cl.get(position).getParValue());
                    i.putExtra("Score", cl.get(position).getScore());
                    i.putIntegerArrayListExtra("HOLES", cl.get(position).getHoles());
                    i.putIntegerArrayListExtra("PAR", cl.get(position).getParvalue());
                    i.putIntegerArrayListExtra("SCORE", cl.get(position).getScores());

                    (activity).startActivity(i);
                }
            });
        }
        return convertView;

    }


}

