package com.example.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class EmployeeGridAdapter extends BaseAdapter {



    private EmployeeGridActivity EmpGridActivity;

    private List<Employee> emp_details;


    public EmployeeGridAdapter(EmployeeGridActivity EmpGridActivity, List<Employee> emp_details){
        this.EmpGridActivity=EmpGridActivity;
        this.emp_details=emp_details;
    }


    @Override
    public int getCount() {
        return emp_details.size();
    }

    @Override
    public Employee getItem(int i) {
        return emp_details.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(EmpGridActivity).inflate(R.layout.emp_gridview_textview,parent, false);
        }
        TextView Employee_name = convertView.findViewById(R.id.Employee_name);

        Employee employee = getItem(position);

        Employee_name.setText(employee.getEmployeename());


        TextView Employee_id = convertView.findViewById(R.id.Employee_id);

        Employee_id.setText(String.valueOf(employee.getEmployeeID()));


        ImageView image_view = convertView.findViewById(R.id.image);

        image_view.setImageResource(employee.getEmp_profile());

        return convertView;
    }
}

