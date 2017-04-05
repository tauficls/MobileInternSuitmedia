package com.taufic.eventapps;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.taufic.eventapps.Adapter.ListEventAdapter;
import com.taufic.eventapps.Item.EventItem;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.taufic.eventapps.R.layout.listview_event;

public class EventOne extends Fragment {

    private ListEventAdapter listEventAdapter;
    private ArrayList<EventItem> list_events;
    private EventItem items;


    View eventOne;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        eventOne = inflater.inflate(R.layout.event_one, container, false);
        list_events = new ArrayList<>();

        /* Initialize dummy data */

        String[] namaEvent = {
                "abc events",
                "def events",
                "ghi events",
                "jkl events"
        };
        String[] tanggalEvent = {
                "27 April 2017",
                "28 Mei 2017",
                "29 Juni 2017",
                "30 Juli 2017"
        };
        int[] pics = {
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher
        };

        String[] description = {
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been ",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been ",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
        };

        int[] longitude = {
                120,121,123,124
        };

        int[] latitude = {
                5,6,7,8
        };


        for(int i = 0; i < 4; i++) {
            items = new EventItem();
            items.setNama(namaEvent[i]);
            items.setTanggal(tanggalEvent[i]);
            items.setImage(pics[i]);
            items.setDescription(description[i]);
            items.setLatitude(latitude[i]);
            items.setLongitude(longitude[i]);
            list_events.add(items);
        }
        ListView listView = (ListView) eventOne.findViewById(R.id.list_event);

        listEventAdapter = new ListEventAdapter(getActivity(), listview_event, list_events);

        listView.setAdapter(listEventAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                String item = list_events.get(position).getNama();
                i.putExtra("event", item);
                getActivity().setResult(RESULT_OK, i);
                getActivity().finish();
            }
        });
        Fragment fr = new Fragment();
        Bundle bundle = new Bundle();
        bundle.putIntArray("Photos", pics);
        fr.setArguments(bundle);

        return eventOne;
    }

}
