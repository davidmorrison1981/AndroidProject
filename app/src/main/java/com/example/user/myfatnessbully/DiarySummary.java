package com.example.user.myfatnessbully;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by user on 04/09/2016.
 */
public class DiarySummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Diary Summary:", "OnCreate started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_main);
    }
}
