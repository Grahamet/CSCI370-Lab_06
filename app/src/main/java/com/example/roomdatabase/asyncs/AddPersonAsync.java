package com.example.roomdatabase.asyncs;

import android.os.AsyncTask;

import com.example.roomdatabase.Entity.Person;
import com.example.roomdatabase.database.LabDatabase;

public class AddPersonAsync extends AsyncTask<Person, Void,Void> {

    private LabDatabase database;

    public AddPersonAsync(LabDatabase database) {
        this.database = database;
    }

    @Override
    protected Void doInBackground(Person... people) {

        database.personDao().insertPerson(people[0]);
        return null;
    }
}
