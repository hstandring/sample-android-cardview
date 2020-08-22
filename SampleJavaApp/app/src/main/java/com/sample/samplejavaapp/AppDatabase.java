package com.sample.samplejavaapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.sample.samplejavaapp.about.Employee;
import com.sample.samplejavaapp.about.EmployeeDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Employee.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // We use this to load the database with an initial set of data on startup
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            databaseWriteExecutor.execute(() -> {
                // Clear the database
                EmployeeDao employeeDao = INSTANCE.employeeDao();
                employeeDao.deleteAll();

                // load the employees
                List<Employee> employees = generateEmployeeList();
                for (Employee emp : employees) {
                    employeeDao.insert(emp);
                }
            });
        }
    };

    private static List<Employee> generateEmployeeList() {

        List<Employee> employees = new ArrayList<>(3);
        employees.add(new Employee(1, "Bob", "Smith", "Dean", "This is Bob's bio."));
        employees.add(new Employee(2, "Judy", "White", "Professor", "This is Judy's bio."));
        employees.add(new Employee(3, "John", "Brown", "Professor", "This is John's bio."));
        return employees;
    }
}
