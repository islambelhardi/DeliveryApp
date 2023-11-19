package com.example.deliveryapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.deliveryapplication.data.Country;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {
    Activity activity;
    int itemResourceId;
    List<Country> items;
    private List<Country> countriesList;
    private LayoutInflater inflater;

    /*public CountryAdapter(Activity activity, int itemResourceId, @NonNull List<Country> items) {
        super(activity, itemResourceId, items);
        this.activity=activity;
        this.itemResourceId=itemResourceId;
        this.items=items;
    }*/
    public CountryAdapter(Context context, List<Country> countriesList) {
        super(context, 0, countriesList);
        this.countriesList = countriesList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_country, parent, false);
        }

        Country currentCountry = countriesList.get(position);

        ImageView flagImageView = convertView.findViewById(R.id.flag);
        TextView countryNameTextView = convertView.findViewById(R.id.name);

        flagImageView.setImageResource(currentCountry.flagResourceId);
        countryNameTextView.setText(currentCountry.name);

        return convertView;
    }
 /*   @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (convertView==null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(itemResourceId,parent,false);
        }
        TextView nameTV = (TextView) view.findViewById(R.id.name);
        ImageView flagIV = (ImageView) view.findViewById(R.id.flag);
        nameTV.setText(items.get(position).name);
        flagIV.setImageResource(items.get(position).flagResourceId);

        return view;
    }*/
}
