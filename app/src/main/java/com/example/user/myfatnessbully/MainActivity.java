package com.example.user.myfatnessbully;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mSaveUsername;
    EditText mUsername;
    TextView mSavedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUsername = (EditText) findViewById(R.id.username);
        mSaveUsername = (Button) findViewById(R.id.saveUsername);
        mSavedText = (TextView) findViewById(R.id.saved_text);
        mSavedText.setVisibility(View.INVISIBLE);

        final String savedText = SavedTextPreferences.getStoredText(this);
        if (savedText != null && !savedText.isEmpty()) {
            mSaveUsername.setVisibility(View.VISIBLE);
            mUsername.setVisibility(View.VISIBLE);
            mSavedText.setText(savedText);
            mSavedText.setVisibility(View.INVISIBLE);
        }

        mSaveUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToSave = mUsername.getText().toString();
                mSaveUsername.setVisibility(View.INVISIBLE);
                mUsername.setVisibility(View.INVISIBLE);
                mSavedText.setVisibility(View.VISIBLE);
                mSavedText.setText(textToSave);
                Context context = v.getContext();
                SavedTextPreferences.setStoredText(context, savedText);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId() == R.id.summary) {
                Intent intent = new Intent(MainActivity.this, DiarySummary.class);
//                intent.putExtra("answer", answer);
                startActivity(intent);
                return true;
            }
//
//            case R.id.goals:
////                goals();
//                return true;
//
//            case R.id.diary_main:
////                diary();
//                return true;
//
//            case R.id.edit_diary:
////                editDiaty();
//                return true;

//             default:
                return super.onOptionsItemSelected(item);

    }
}
