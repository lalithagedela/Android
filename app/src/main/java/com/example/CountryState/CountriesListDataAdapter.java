package com.example.CountryState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class CountriesListDataAdapter extends BaseAdapter {

    private CountriesListDataActivity countrylistDataActivity;
    private   List<Country> countries;

    public CountriesListDataAdapter(CountriesListDataActivity countrylistDataActivity, List<Country> countries) {
        this.countrylistDataActivity = countrylistDataActivity;
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Country getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(countrylistDataActivity).inflate(R.layout.countries_textview, parent, false);
        }
        TextView countryText = convertView.findViewById(R.id.textview);
        countryText.setText(((Country) getItem(position)).countryName);
        return convertView;
    }
}