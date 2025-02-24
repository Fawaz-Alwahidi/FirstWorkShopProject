package com.example.firstworkshopproject.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {

    private final StudentDAO studentDao;
    private final CourseDAO courseDao;
    private final LiveData<List<Student>> allStudents;
    private final LiveData<List<Course>> allCourses;

    public AppRepository(Application application) {
        MyDatabse db = MyDatabse.getDatabase(application);
        studentDao = db.studentDao();
        courseDao = db.courseDao();
        allStudents = studentDao.getAllStudents();
        allCourses = courseDao.getAllCourses();
    }

    // Insert course
    void insertCourse(Course course) {
        MyDatabse.databaseWriteExecutor.execute(() -> {
            courseDao.insertCourse(course);
        });
    }

    // Insert student
    void insertStudent(Student student) {
        MyDatabse.databaseWriteExecutor.execute(() -> {
            studentDao.insertStudent(student);
        });
    }

    // Get all courses
    LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }

    // Get all students
    LiveData<List<Student>> getAllStudents() {
        return allStudents;
    }
}

