package com.example.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
import java.util.List;

public class EmployeeDataAdapter extends BaseAdapter {

    private EmployeeDataActivity employeeDataActivity;
    private List<Employee> details;

    public EmployeeDataAdapter(EmployeeDataActivity employeeDataActivity, List<Employee> details){

        this.employeeDataActivity=employeeDataActivity;
        this.details=details;
    }



    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Employee getItem(int position) {
        return details.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(employeeDataActivity).inflate(R.layout.employee_textview, parent, false);
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
