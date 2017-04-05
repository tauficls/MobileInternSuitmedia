package com.taufic.eventapps;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by taufic on 4/5/2017.
 */

public class EventTwo extends Fragment{

    private View eventTwo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        eventTwo = inflater.inflate(R.layout.mapview, container, false);
        Bundle bundle = this.getArguments();
        if(bundle != null) {
            int[] pics = bundle.getIntArray("Photos");
        }


        return eventTwo;
    }
}
