package com.taufic.eventapps.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.taufic.eventapps.Item.GuestItem;
import com.taufic.eventapps.R;

import java.util.ArrayList;

/**
 * Created by taufic on 3/31/2017.
 * Adapter for Guest
 */

public class ListGuestAdapter extends ArrayAdapter<GuestItem> {
    ArrayList<GuestItem> guestItems;
    Context context;
    int resources;

    public ListGuestAdapter(Context context, int resources, ArrayList<GuestItem> guestItems) {
        super(context, resources, guestItems);
        this.context = context;
        this.resources = resources;
        this.guestItems = guestItems;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view ==  null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.
                    LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.listview_guest, null);
        }
        GuestItem i = guestItems.get(position);
        if (i != null) {
            TextView namaGuest = (TextView) view.findViewById(R.id.nameGuest    );
            TextView birthdate = (TextView) view.findViewById(R.id.birthdate);

            namaGuest.setText(i.getName());
            birthdate.setText(i.getDateBirth());
        }
        return view;
    }
}
