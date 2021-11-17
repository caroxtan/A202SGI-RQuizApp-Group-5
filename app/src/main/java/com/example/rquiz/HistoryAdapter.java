package com.example.rquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HistoryAdapter extends ArrayAdapter<HistoryList> {

    //Initialise variables
    private ArrayList<HistoryList> historyList;
    private int mViewResourceId;
    private LayoutInflater mInflater;

    //Inflates XML file into list view
    public HistoryAdapter(Context context, int textViewResourceId, ArrayList<HistoryList> historyList) {
        super(context, textViewResourceId, historyList);
        this.historyList = historyList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //Convert view
        convertView = mInflater.inflate(mViewResourceId, null);

        //Get position in history list
        HistoryList mHistoryList = historyList.get(position);

        //If list is not empty
        if (mHistoryList != null) {
            //Get subject name and score
            TextView mSubName = (TextView) convertView.findViewById(R.id.subName);
            TextView mTvScore = (TextView) convertView.findViewById(R.id.tvScore);
            if (mSubName != null) {
                //Set subject name
                mSubName.setText(mHistoryList.getSubName());
            }
            if (mTvScore != null) {
                //Set score
                mTvScore.setText((mHistoryList.getScore()));
            }
        }

        return convertView;
    }
}
