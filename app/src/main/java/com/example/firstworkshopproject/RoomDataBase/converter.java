package com.example.firstworkshopproject.RoomDataBase;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;
import java.util.Date;

public class converter {

    // Convert Date to Long (Timestamp)
    @TypeConverter
    public Long toLong(Date date) {
        return date == null ? null : date.getTime();
    }

    // Convert Long (Timestamp) to Date
    @TypeConverter
    public Date toDate(Long date) {
        return date == null ? null : new Date(date);
    }

    // Convert Bitmap to byte array
    @TypeConverter
    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        if (bitmap == null) return null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);  // Adjust quality if needed
        return stream.toByteArray();
    }

    // Convert byte array to Bitmap
    @TypeConverter
    public static Bitmap getByteAsBitmap(byte[] bytes) {
        return bytes == null ? null : BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    // Convert Course ID to Course
    @TypeConverter
    public static Course fromCourseIdToCourse(int courseId) {
        // You can modify this to fetch the actual course from the database if needed
        return new Course("Default Name", 0); // Placeholder
    }

    // Convert Course to Course ID
    @TypeConverter
    public static int fromCourseToCourseId(Course course) {
        return course != null ? course.getCourseId() : -1;  // Return courseId or a default value
    }

    // Convert Student ID to Student
    @TypeConverter
    public static Student fromStudentIdToStudent(int studentId) {
        // Modify this to fetch the actual student from the database if needed
        return new Student("Default Name", "Department", null, null, studentId);  // Placeholder
    }

    // Convert Student to Student ID
    @TypeConverter
    public static int fromStudentToStudentId(Student student) {
        return student != null ? student.getId() : -1;  // Return student ID or default value
    }
}
