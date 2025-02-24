package com.example.firstworkshopproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstworkshopproject.RoomDataBase.Course;
import com.example.firstworkshopproject.RoomDataBase.Student;
import com.example.onlinecoursese__learningapp.databinding.ActivityMainBinding;

import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button cameraButton, insertCourseButton, insertStudentButton;
    private EditText courseNameEditText, studentNameEditText;
    private RecyclerView courseRecyclerView, studentRecyclerView;
    private CourseAdapter courseAdapter;
    private StudentAdapter studentAdapter;
    private Bitmap capturedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cameraButton = binding.addImage;
        insertCourseButton = binding.addCourseButton;
        insertStudentButton = binding.addStudentButton;
        courseNameEditText = binding.courseNameEditText;
        studentNameEditText = binding.studentNameEditText;
        courseRecyclerView = binding.recyclerViewCourses;
        studentRecyclerView = binding.recyclerViewStudents;

        courseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        courseAdapter = new CourseAdapter();
        studentAdapter = new StudentAdapter();
        courseRecyclerView.setAdapter(courseAdapter);
        studentRecyclerView.setAdapter(studentAdapter);

        // Camera Button to capture image
        cameraButton.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 100);
        });

        // Insert Course
        insertCourseButton.setOnClickListener(v -> {
            String courseName = courseNameEditText.getText().toString();
            courseAdapter.addCourse(new Course(courseName, 0)); // Just adding course name, no students
            loadCourses();
        });

        // Insert Student
        insertStudentButton.setOnClickListener(v -> {
            String studentName = studentNameEditText.getText().toString();
            studentAdapter.addStudent(new Student(studentName)); // Just adding student name
            loadStudents();
        });
    }

    // Load Courses into RecyclerView
    private void loadCourses() {
        List<Course> courses = courseAdapter.getCourses();
        courseAdapter.setCourses(courses);
    }

    // Load Students into RecyclerView
    private void loadStudents() {
        List<Student> students = studentAdapter.getStudents();
        studentAdapter.setStudents(students);
    }
}
