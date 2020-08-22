package com.sample.samplejavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sample.samplejavaapp.about.AboutUsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeDatabase();
    }

    private void initializeDatabase() {
        // Run a dummy query to trigger the db to populate
        AppDatabase.getDatabase(this).employeeDao().getAll();
    }

    public void loadAboutUs(View view) {
        startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
    }
}