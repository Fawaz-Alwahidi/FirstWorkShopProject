package com.example.firstworkshopproject.RoomDataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.Executor;

@Database(entities = {Student.class, Course.class}, version = 1, exportSchema = false)
@TypeConverters(converter.class)  // Adding this to enable converters for the relationships
public abstract class MyDatabse extends RoomDatabase {

    public static Executor databaseWriteExecutor;

    public abstract StudentDAO studentDao();
    public abstract CourseDAO courseDao();

    private static volatile MyDatabse INSTANCE;

    public static MyDatabse getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDatabse.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyDatabse.class, "my_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
