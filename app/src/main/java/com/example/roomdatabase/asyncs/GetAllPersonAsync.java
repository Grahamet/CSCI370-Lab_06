package com.example.roomdatabase.asyncs;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.roomdatabase.Entity.Person;
import com.example.roomdatabase.PersonsActivity;
import com.example.roomdatabase.database.LabDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GetAllPersonAsync extends AsyncTask<Void, Void, List<Person>> {

    private LabDatabase database;
    private ArrayList<Person> personArrayList;
    private Context context;

    public GetAllPersonAsync(LabDatabase labDatabase, Context context) {
        this.database = labDatabase;
        this.context = context;
    }

    @Override
    protected List<Person> doInBackground(Void... voids) {
        ArrayList<String> personNames = new ArrayList<>();

        personArrayList = (ArrayList) database.personDao().getAllPersons();
        for(int i=0; i <personArrayList.size(); i ++){
            personNames.add(personArrayList.get(i).getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
        return null;
    }
}
