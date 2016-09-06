package com.example.user.myfatnessbully;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
// * Created by user on 04/09/2016.
// */
public class EditDiary extends AppCompatActivity {

    static TextView mDateEdit;
    Button mSubmitToDiaryButton;
    EditText mFoodInput;
    EditText mCalorieInput;
    String savedFood;
    String savedCalories;


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

        mSubmitToDiaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               savedFood = mFoodInput.getText();
               savedCalories = mCalorieInput.getText();


            }
        });
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(this.getFragmentManager(), "datePicker");
    }







}


