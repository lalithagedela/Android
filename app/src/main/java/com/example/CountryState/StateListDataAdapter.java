package com.example.CountryState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class StateListDataAdapter extends BaseAdapter {

    private StateListDataActivity StatelistDataActivity;
    private  List<String> states;

    public StateListDataAdapter(StateListDataActivity StatelistDataActivity, List<String> states) {
        this.StatelistDataActivity = StatelistDataActivity;
        this.states = states;
    }

    @Override
    public int getCount() {
        return states.size();
    }

    @Override
    public String getItem(int position)
    {
        return states.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(StatelistDataActivity).inflate(R.layout.states_textview, parent, false);
        }
        TextView stateList = convertView.findViewById(R.id.textview);
        stateList.setText(getItem(position));
        return convertView;
    }
}
