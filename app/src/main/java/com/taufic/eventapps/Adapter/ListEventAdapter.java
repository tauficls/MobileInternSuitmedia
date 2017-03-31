package com.taufic.eventapps.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.taufic.eventapps.Item.EventItem;
import com.taufic.eventapps.R;

import java.util.ArrayList;

/**
 * Created by taufic on 3/30/2017.
 * Adapter for event
 */

public class ListEventAdapter extends ArrayAdapter<EventItem> {
    ArrayList<EventItem> eventItems;
    Context context;
    int resources;

    public ListEventAdapter(Context context, int resources, ArrayList<EventItem> eventItems) {
        super(context, resources, eventItems);
        this.context = context;
        this.resources = resources;
        this.eventItems = eventItems;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view ==  null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.listview_event, null);
        }
        EventItem i = eventItems.get(position);
        if (i != null) {
            TextView namaEvent = (TextView) view.findViewById(R.id.namaEvent);
            TextView tanggalEvent = (TextView) view.findViewById(R.id.tanggalEvent);
            ImageView imageEvent= (ImageView) view.findViewById(R.id.imageEvent);
            namaEvent.setText(i.getNama());
            tanggalEvent.setText(i.getTanggal());
            imageEvent.setImageResource(i.getImage());
        }
        return view;
    }
}
