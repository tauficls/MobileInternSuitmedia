package com.taufic.eventapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.taufic.eventapps.Adapter.ListEventAdapter;
import com.taufic.eventapps.Item.EventItem;

import java.util.ArrayList;

import static com.taufic.eventapps.R.layout.listview_event;

public class Event extends AppCompatActivity {

    private ListEventAdapter listEventAdapter;
    private ArrayList<EventItem> list_events;
    private EventItem items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        list_events = new ArrayList<>();

        /* Action Bar */
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbarlayout);
        TextView title = (TextView) findViewById(R.id.mytitle);
        title.setText("Event");
        getSupportActionBar().setDisplayShowTitleEnabled(true);

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

        for(int i = 0; i < 4; i++) {
            items = new EventItem();
            items.setNama(namaEvent[i]);
            items.setTanggal(tanggalEvent[i]);
            items.setImage(pics[i]);
            list_events.add(items);
        }
        ListView listView = (ListView) findViewById(R.id.list_event);

        listEventAdapter = new ListEventAdapter(this, listview_event, list_events);

        listView.setAdapter(listEventAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                String item = list_events.get(position).getNama();
                i.putExtra("event", item);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}
