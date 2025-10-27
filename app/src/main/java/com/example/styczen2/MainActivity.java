package com.example.styczen2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNote;
    private Button buttonAdd;
    private ListView listViewNotes;
    private ArrayList<String> notesList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNote = findViewById(R.id.editTextNote);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewNotes = findViewById(R.id.listViewNotes);


        notesList = new ArrayList<>();
        notesList.add("Zakupy: chleb, masło, ser");
        notesList.add("Do zrobienia: obiad, umyć podłogi");
        notesList.add("weekend: kino, spacer z psem");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        listViewNotes.setAdapter(adapter);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newNote = editTextNote.getText().toString().trim();
                if (!newNote.isEmpty()) {
                    notesList.add(newNote);
                    adapter.notifyDataSetChanged();
                    editTextNote.setText("");
                }
            }
        });
    }
}