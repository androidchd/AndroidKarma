package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.KarmaLakeLand1.R;


public class DrawerItemCustomAdapter extends ArrayAdapter<Objectdraweritem> {
	 
    Context mContext;
    int layoutResourceId;
    Objectdraweritem data[] = null;
 
    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, Objectdraweritem[] data) {
 
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 
        View listItem = convertView;
 
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);
        
 
        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);
        
        Objectdraweritem folder = data[position];
 
        
        imageViewIcon.setImageResource(folder.icon);

        textViewName.setText(folder.name);
        
        return listItem;
    }
 
}




