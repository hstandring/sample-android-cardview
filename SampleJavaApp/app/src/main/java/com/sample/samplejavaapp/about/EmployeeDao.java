package com.sample.samplejavaapp.about;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT * from employee")
    List<Employee> getAll();

    @Insert
    void insert(Employee employee);

    @Query("DELETE FROM employee")
    void deleteAll();
}
