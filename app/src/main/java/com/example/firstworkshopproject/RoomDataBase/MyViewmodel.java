package com.example.firstworkshopproject.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewmodel extends AndroidViewModel {

    private final AppRepository repository;
    private final LiveData<List<Student>> allStudents;
    private final LiveData<List<Course>> allCourses;

    public MyViewmodel(Application application) {
        super(application);
        repository = new AppRepository(application);
        allStudents = repository.getAllStudents();
        allCourses = repository.getAllCourses();
    }

    // Insert student
    public void insertStudent(Student student) {
        repository.insertStudent(student);
    }

    // Insert course
    public void insertCourse(Course course) {
        repository.insertCourse(course);
    }

    // Get all students
    public LiveData<List<Student>> getAllStudents() {
        return allStudents;
    }

    // Get all courses
    public LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }
}
