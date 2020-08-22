
package com.sample.samplejavaapp.about;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.samplejavaapp.R;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView employeeTitle;
        TextView employeeName;
        TextView employeeBio;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.employee_cv);
            employeeTitle = itemView.findViewById(R.id.employee_title);
            employeeName = itemView.findViewById(R.id.employee_name);
            employeeBio = itemView.findViewById(R.id.employee_bio);
        }
    }

    List<Employee> employees;

    EmployeeAdapter(List<Employee> employees){
        this.employees = employees;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.about_us_cardview, viewGroup, false);
        EmployeeViewHolder pvh = new EmployeeViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder employeeViewHolder, int i) {
        employeeViewHolder.employeeTitle.setText(employees.get(i).title);
        employeeViewHolder.employeeName.setText(employees.get(i).firstName + " " + employees.get(i).lastName);
        employeeViewHolder.employeeBio.setText(employees.get(i).bio);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
