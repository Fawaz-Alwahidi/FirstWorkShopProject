package com.example.firstworkshopproject.RoomDataBase;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = Course.class, parentColumns = "courseId", childColumns = "courseId"),
        indices = {@Index("courseId")})  // Adding index for courseId
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String department;
    private Bitmap photo;
    private Date dateOfBirth;
    private int courseId;

    public Student(String name, String department, Bitmap photo, Date dateOfBirth, int courseId) {
        this.name = name;
        this.department = department;
        this.photo = photo;
        this.dateOfBirth = dateOfBirth;
        this.courseId = courseId;
    }

    public Student(String studentName) {
        this.name = name ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", photo=" + photo +
                ", dateOfBirth=" + dateOfBirth +
                ", courseId=" + courseId +
                '}';
    }
}
