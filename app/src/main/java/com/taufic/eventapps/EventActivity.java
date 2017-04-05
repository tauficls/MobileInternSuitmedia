package com.taufic.eventapps;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by taufic on 4/5/2017.
 */

public class EventActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText searchbox;
    private boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        /* Action Bar */
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setCustomView(R.layout.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView title = (TextView) findViewById(R.id.mytitle);
        title.setText("MESSAGE FROM CODI");

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        EventOne eventOne = new EventOne();
        fragmentTransaction.replace(R.id.fragment_place, eventOne);
        fragmentTransaction.commit();
        status = true;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mSearchAction = menu.findItem(R.id.action_search);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.back:
                finish();
                return true;
            case R.id.plus:
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();

                if(!status) {
                    EventOne eventOne = new EventOne();
                    TextView textView = (TextView) findViewById(R.id.mytitle);
                    textView.setTextColor(Color.parseColor("#009688"));
                    fragmentTransaction.replace(R.id.fragment_place, eventOne);
                    fragmentTransaction.commit();
                    status = true;
                } else {
                    EventTwo eventTwo = new EventTwo();
                    TextView textView = (TextView) findViewById(R.id.mytitle);
                    textView.setTextColor(Color.parseColor("#827717"));

                    fragmentTransaction.replace(R.id.fragment_place, eventTwo);
                    fragmentTransaction.commit();
                    status = false;
                }
                return true;
            case R.id.action_search:
                handleMenuSearch();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* Search handler */
    protected void handleMenuSearch(){
        ActionBar action = getSupportActionBar();

        if(isSearchOpened){

            action.setDisplayShowCustomEnabled(false);

            //hides the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(searchbox.getWindowToken(), 0);

            //add the search icon in the action bar
            mSearchAction.setIcon(R.drawable.ic_search);

            isSearchOpened = false;
        } else {

            action.setDisplayShowCustomEnabled(true);
            action.setCustomView(R.layout.search_bar);
            action.setDisplayShowTitleEnabled(false);

            searchbox = (EditText)action.getCustomView().findViewById(R.id.edtSearch);

            searchbox.requestFocus();

            //open the keyboard focused in the searchbox
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(searchbox, InputMethodManager.SHOW_IMPLICIT);

            //add the close icon
            mSearchAction.setIcon(R.drawable.ic_exit_search);
            isSearchOpened = true;
        }
    }

    @Override
    public void onBackPressed() {
        if(isSearchOpened) {
            handleMenuSearch();
            return;
        }
        super.onBackPressed();
    }

    public void back(View view) {
        finish();
    }

}
