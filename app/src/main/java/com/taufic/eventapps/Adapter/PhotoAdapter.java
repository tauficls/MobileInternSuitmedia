package com.taufic.eventapps.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.taufic.eventapps.R;

import java.util.ArrayList;

/**
 * Created by taufic on 4/5/2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Integer> mDataSet;

    public PhotoAdapter(Context context, ArrayList<Integer> list){
        mContext = context;
        mDataSet = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v){
            super(v);
            // Get the widget reference from the custom layout
            mCardView = (CardView) v.findViewById(R.id.card_view);
            mImageView = (ImageView) v.findViewById(R.id.EventImage);
        }
    }

    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_view,parent,false);
        ViewHolder vh = new ViewHolder(v);

        // Return the ViewHolder
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        final int photo = mDataSet.get(position);

        // Set the ImageView
        holder.mImageView.setImageResource(photo);


        // Set a click listener for CardView
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize a new Intent
                Intent intent = new Intent("BROADCAST_PHOTO");
                intent.putExtra("PHOTOS",photo);

                // Broadcast the selected photos value
                LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
            }
        });
    }
    @Override
    public int getItemCount(){
        // Count the items
        return mDataSet.size();
    }

}
