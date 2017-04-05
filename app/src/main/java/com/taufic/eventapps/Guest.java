package com.taufic.eventapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.taufic.eventapps.Adapter.ListGuestAdapter;
import com.taufic.eventapps.Item.GuestItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Guest extends AppCompatActivity {

    private ArrayList<GuestItem> list_guest;
    private GuestItem items;
    private ListGuestAdapter listGuestAdapter;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        /* ActionBar */
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbarlayout);
        TextView title = (TextView) findViewById(R.id.mytitle);
        title.setText("Guest");
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        list_guest = new ArrayList<>();

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.activity_guest);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchData();
            }
        });

        //Take JSON Array from url and parse them into text
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://dry-sierra-6832.herokuapp.com/api/people";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.
                Listener<String>() {

            @Override
            public void onResponse(String response) {
                JSONArray responseArray;
                try {
                    responseArray = new JSONArray(response);
                    if (responseArray.length() > 0) {
                        for(int i = 0; i < responseArray.length(); i++) {
                            items = new GuestItem();
                            JSONObject temp = (JSONObject) responseArray.get(i);
                            items.setId(temp.get("id").toString());
                            items.setName(temp.get("name").toString());
                            items.setDateBirth(temp.get("birthdate").toString());
                            list_guest.add(items);
                        }
                        listGuestAdapter = new ListGuestAdapter(getApplicationContext(),
                                R.layout.listview_guest, list_guest);
                        GridView gridView = (GridView) findViewById(R.id.grid_guest);
                        gridView.setAdapter(listGuestAdapter);
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent i = new Intent();
                                String item = list_guest.get(position).getName();
                                i.putExtra("guest", item);
                                String sDate = list_guest.get(position).getDateBirth();
                                i.putExtra("date", sDate);
                                setResult(RESULT_OK, i);
                                finish();
                            }
                        });
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        queue.add(stringRequest);


    }

    public void fetchData() {
        list_guest = new ArrayList<>();
        //Take JSON Array from url and parse them into text
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://dry-sierra-6832.herokuapp.com/api/people";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.
                Listener<String>() {

            @Override
            public void onResponse(String response) {
                JSONArray responseArray;
                try {
                    responseArray = new JSONArray(response);
                    if (responseArray.length() > 0) {
                        for(int i = 0; i < responseArray.length(); i++) {
                            items = new GuestItem();
                            JSONObject temp = (JSONObject) responseArray.get(i);
                            items.setId(temp.get("id").toString());
                            items.setName(temp.get("name").toString());
                            items.setDateBirth(temp.get("birthdate").toString());
                            list_guest.add(items);
                        }
                        listGuestAdapter = new ListGuestAdapter(getApplicationContext(),
                                R.layout.listview_guest, list_guest);
                        GridView gridView = (GridView) findViewById(R.id.grid_guest);
                        gridView.setAdapter(listGuestAdapter);
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent i = new Intent();
                                String item = list_guest.get(position).getName();
                                i.putExtra("guest", item);
                                String sDate = list_guest.get(position).getDateBirth();
                                i.putExtra("date", sDate);
                                setResult(RESULT_OK, i);
                                finish();
                            }
                        });
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        swipeContainer.setRefreshing(false);
        queue.add(stringRequest);
    }
}
