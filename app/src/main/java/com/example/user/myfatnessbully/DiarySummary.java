package com.example.user.myfatnessbully;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 04/09/2016.
 */
public class DiarySummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Diary Summary:", "OnCreate started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_main);

        final SqlHandler db = ((MainApplication)getApplication()).DB;

        ListView listView1 = (ListView) findViewById(R.id.breakfast);

        ArrayList<DiaryEntry> entries = db.getAllEntries();

        ArrayAdapter<DiaryEntry> adapter = new ArrayAdapter<DiaryEntry>(this,
                android.R.layout.simple_list_item_1, entries);

        listView1.setAdapter(adapter);

    }
}
