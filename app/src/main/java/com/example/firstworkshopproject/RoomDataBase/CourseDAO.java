package com.example.firstworkshopproject.RoomDataBase;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDAO {

    @Insert
    void insertCourse(Course course);

    @Update
    void updateCourse(Course course);

    @Delete
    void deleteCourse(Course course);

    @Query("SELECT * FROM Course")
    LiveData<List<Course>> getAllCourses();

    @Query("SELECT * FROM Course WHERE courseId = :courseId")
    LiveData<List<Course>> getAllCoursesByCourseId(int courseId);
}
