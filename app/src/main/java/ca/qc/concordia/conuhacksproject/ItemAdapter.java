package ca.qc.concordia.conuhacksproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    String [] workshops;
    String [] dates;
    String [] descriptions;

    public ItemAdapter(Context c, String[] w, String[] da, String[] de){
        workshops = w;
        dates = da;
        descriptions = de;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return workshops.length;
    }

    @Override
    public Object getItem(int i) {
        return workshops[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        /*
        if(view == null){
            LayoutInflater lInflater = (LayoutInflater) Context.getSystemService(
                    Activity.LAYOUT_INFLATER_SERVICE);

            view = lInflater.inflate(R.layout.my_listview_detail, null);
        }
        */

        View v = mInflater.inflate(R.layout.my_listview_detail, null);

        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);
        TextView dateTextView = (TextView) v.findViewById(R.id.dateTextView);

        String name = workshops[i];
        String desc = descriptions[i];
        String date = dates[i];

        nameTextView.setText(name);
        descriptionTextView.setText(desc);
        dateTextView.setText(date);

        return v;
    }
}
