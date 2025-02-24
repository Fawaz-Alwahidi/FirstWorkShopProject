package com.example.firstworkshopproject.RoomDataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseId;
    private String courseName;
    private int nofStudents;

    public Course(String courseName, int nofStudents) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.nofStudents = nofStudents;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNofStudents() {
        return nofStudents;
    }

    public void setNofStudents(int nofStudents) {
        this.nofStudents = nofStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", nofStudents=" + nofStudents +
                '}';
    }
}

