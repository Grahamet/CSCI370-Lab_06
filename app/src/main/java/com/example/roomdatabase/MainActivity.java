package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.Entity.Person;
import com.example.roomdatabase.asyncs.AddPersonAsync;
import com.example.roomdatabase.asyncs.GetAllPersonAsync;
import com.example.roomdatabase.database.LabDatabase;

public class MainActivity extends AppCompatActivity {

    private Button nItem;
    private Button lItem;
    private EditText edit;
    private LabDatabase labDB;
    private String DATABASE_NAME = "DemoPerson";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nItem = findViewById(R.id.new_item);
        lItem = findViewById(R.id.list_itemss);
        edit = findViewById(R.id.insert_item);
        String name = edit.getText().toString();

        labDB = Room.databaseBuilder(this,LabDatabase.class, DATABASE_NAME).build();

        nItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AddPersonAsync addPersonAsync = new AddPersonAsync(labDB);

                Person person = new Person();
                person.setName(edit.getText().toString());
                addPersonAsync.execute(person);

                edit.setText("");
                //Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
            }
        });

        lItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final GetAllPersonAsync getAllPersonAsync = new GetAllPersonAsync(labDB, getApplicationContext());
                getAllPersonAsync.execute();
               // Toast.makeText(getApplicationContext(),"List",Toast.LENGTH_SHORT).show();
            }
        });



    }
}