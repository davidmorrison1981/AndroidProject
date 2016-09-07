package com.example.user.myfatnessbully;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by user on 04/09/2016.
 */
public class DiarySummary extends AppCompatActivity {

//    static TextView mDateEdit;
//
//    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            // Use the current date as the default date in the picker
//            final Calendar c = Calendar.getInstance();
//            int year = c.get(Calendar.YEAR);
//            int month = c.get(Calendar.MONTH);
//            int day = c.get(Calendar.DAY_OF_MONTH);
//
//            // Create a new instance of DatePickerDialog and return it
//            return new DatePickerDialog(getActivity(), this, year, month, day);
//        }
//
//        @Override
//        public void onDateSet(DatePicker datePicker, int year, int month, int day){
//            mDateEdit.setText(day + "/" + (month + 1) + "/" + year);
//
//        }
//        public void showDatePickerDialog(View v) {
//            DialogFragment newFragment = new DatePickerFragment();
//            newFragment.show(this.getFragmentManager(), "datePicker");
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_main);

//        final Calendar c = Calendar.getInstance();
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
////        mDateEdit.setText(day + "/" + (month + 1) + "/" + year);

        final SqlHandler DB = ((MainApplication)getApplication()).DB;



        ListView listView1 = (ListView) findViewById(R.id.breakfast);
        ListView listView2 = (ListView) findViewById(R.id.lunch);
        ListView listView3 = (ListView) findViewById(R.id.supper);

        ArrayList<DiaryEntry> entries = DB.getAllEntries();

        ArrayAdapter<DiaryEntry> adapter = new ArrayAdapter<DiaryEntry>(this,
                android.R.layout.simple_list_item_1, entries);

        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter);
        listView3.setAdapter(adapter);


    }
}
