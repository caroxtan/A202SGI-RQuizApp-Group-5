package com.example.rquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SubjectAdapter extends ArrayAdapter<SubjectName> {

    //Initialise variables
    private Context mContext;
    private int mResource;

    //Constructor
    public SubjectAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SubjectName> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Inflate layout
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        //Convert view
        convertView = layoutInflater.inflate(mResource, parent, false);

        //Covert view by finding id
        ImageView imageView = convertView.findViewById(R.id.image);

        TextView subjectName = convertView.findViewById(R.id.subjectName);

        TextView textDes = convertView.findViewById(R.id.textDes);

        //Set image resource by getting item position
        imageView.setImageResource(getItem(position).getImage());

        //Set text by getting item position
        subjectName.setText(getItem(position).getSubject());

        textDes.setText(getItem(position).getDescription());


        return convertView;
    }
}
