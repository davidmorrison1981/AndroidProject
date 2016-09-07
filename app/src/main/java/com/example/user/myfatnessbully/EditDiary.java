package com.example.user.myfatnessbully;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
// * Created by user on 04/09/2016.
// */
public class EditDiary extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    static TextView mDateEdit;
    Button mSubmitToDiaryButton;
    EditText mFoodInput;
    EditText mCalorieInput;
    Spinner mCategory;

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day){
            mDateEdit.setText(day + "/" + (month + 1) + "/" + year);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_edit);
        mDateEdit = (TextView) findViewById(R.id.saved_date);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        mDateEdit.setText(day + "/" + (month + 1) + "/" + year);

        mSubmitToDiaryButton = (Button) findViewById(R.id.submitToDiary);
        mFoodInput = (EditText) findViewById(R.id.foodType);
        mCalorieInput = (EditText) findViewById(R.id.calories);
        mCategory = (Spinner) findViewById(R.id.category);


        mSubmitToDiaryButton.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               final SqlHandler DB =((MainApplication)getApplication()).DB;

//              Retrieved from the onCreate method
                String foodType = mFoodInput.getText().toString();
                Integer calories = Integer.parseInt(mCalorieInput.getText().toString());
                String date = mDateEdit.getText().toString();
                String category = mCategory.getSelectedItem().toString();

                DiaryEntry entry = new DiaryEntry(foodType, calories, date, category);

                DB.addToDiary(entry);
                Toast.makeText(getApplicationContext(), "Saved To Diary", Toast.LENGTH_LONG).show();
                }
            });


        // Spinner click listener
        mCategory.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Breakfast");
        categories.add("Lunch");
        categories.add("Supper");
//                categories.add("Snacks");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        mCategory.setAdapter(dataAdapter);
}

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // On selecting a spinner item
            String item = parent.getItemAtPosition(position).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }

        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(this.getFragmentManager(), "datePicker");
    }
}


