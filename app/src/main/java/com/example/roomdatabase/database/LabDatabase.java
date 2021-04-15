package com.example.roomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.Dao.PersonDao;
import com.example.roomdatabase.Entity.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}
