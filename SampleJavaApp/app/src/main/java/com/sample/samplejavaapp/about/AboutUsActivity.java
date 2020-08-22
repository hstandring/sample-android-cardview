package com.sample.samplejavaapp.about;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sample.samplejavaapp.AppDatabase;
import com.sample.samplejavaapp.R;

import java.util.List;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        initializeView();
    }

    private void initializeView(){
        RecyclerView rv = findViewById(R.id.employee_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        List<Employee> employeeList = AppDatabase.getDatabase(this).employeeDao().getAll();
        EmployeeAdapter adapter = new EmployeeAdapter(employeeList);
        rv.setAdapter(adapter);
    }
}