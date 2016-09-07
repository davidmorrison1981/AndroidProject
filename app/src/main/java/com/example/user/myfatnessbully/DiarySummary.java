package com.example.user.myfatnessbully;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by user on 04/09/2016.
 */
public class DiarySummary extends AppCompatActivity {
    Button mAddToDiaryButton1;
    Button mAddToDiaryButton2;
    Button mAddToDiaryButton3;
    Button mPickDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_main);


        mAddToDiaryButton1 = (Button) findViewById(R.id.breakfastAdd);
        mAddToDiaryButton2 = (Button) findViewById(R.id.lunchAdd);
        mAddToDiaryButton3 = (Button) findViewById(R.id.supperAdd);
        mPickDate = (Button) findViewById(R.id.pickDate);

        final SqlHandler DB = ((MainApplication)getApplication()).DB;

        mAddToDiaryButton1.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View view) {
              Intent intent = new Intent(DiarySummary.this, EditDiary.class);
              startActivity(intent);
          }
        });

        mAddToDiaryButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiarySummary.this, EditDiary.class);
                startActivity(intent);
            }
        });

        mAddToDiaryButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiarySummary.this, EditDiary.class);
                startActivity(intent);
            }
        });

        mPickDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(view);
            }
        });


        ListView listView1 = (ListView) findViewById(R.id.breakfast);
        ListView listView2 = (ListView) findViewById(R.id.lunch);
        ListView listView3 = (ListView) findViewById(R.id.supper);

        ArrayList<DiaryEntry> breakfast_entries = DB.getBreakfastEntries();
        ArrayList<DiaryEntry> lunch_entries = DB.getLunchEntries();
        ArrayList<DiaryEntry> supper_entries = DB.getSupperEntries();

        ArrayAdapter<DiaryEntry> adapter_breakfast = new ArrayAdapter<DiaryEntry>(this,
                android.R.layout.simple_list_item_1, breakfast_entries);

        ArrayAdapter<DiaryEntry> adapter_lunch = new ArrayAdapter<DiaryEntry>(this,
                android.R.layout.simple_list_item_1, lunch_entries);

        ArrayAdapter<DiaryEntry> adapter_supper = new ArrayAdapter<DiaryEntry>(this,
                android.R.layout.simple_list_item_1, supper_entries);

        listView1.setAdapter(adapter_breakfast);
        listView2.setAdapter(adapter_lunch);
        listView3.setAdapter(adapter_supper);


    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new EditDiary.DatePickerFragment();
        newFragment.show(this.getFragmentManager(), "datePicker");
    }


}
