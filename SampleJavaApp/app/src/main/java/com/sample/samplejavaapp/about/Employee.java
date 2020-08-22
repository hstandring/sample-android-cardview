package com.sample.samplejavaapp.about;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {

    @PrimaryKey
    public int employeeId;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "bio")
    public String bio;

    public Employee(int employeeId, String firstName, String lastName, String title, String bio) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.bio = bio;
    }
}
