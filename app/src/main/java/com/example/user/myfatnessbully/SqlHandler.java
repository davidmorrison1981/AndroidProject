package com.example.user.myfatnessbully;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 05/09/2016.
 */
public class SqlHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "foodDiary";

    // Table name
    private static final String TABLE_ENTRIES = "foodEntry";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FOOD = "food_type";
    private static final String KEY_CALORIES = "calories";
    private static final String KEY_DATE = "date";
    private static final String KEY_CATEGORY = "category";

    public SqlHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase DB) {
        String CREATE_DIARY_TABLE = " CREATE TABLE " + TABLE_ENTRIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_FOOD + " TEXT, " +
                KEY_CALORIES + " INTEGER, " + KEY_DATE + " TEXT, " + KEY_CATEGORY + " TEXT "+ ")";
        DB.execSQL(CREATE_DIARY_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        // Drop older table if existed
        DB.execSQL(" DROP TABLE IF EXISTS " + TABLE_ENTRIES);

        // Create tables again
        onCreate(DB);
    }

    public void addToDiary(DiaryEntry diaryEntry) {
            SQLiteDatabase DB = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(KEY_FOOD, diaryEntry.getFoodType()); // Food Type
            values.put(KEY_CALORIES, diaryEntry.getCalories()); // Calories
            values.put(KEY_DATE, diaryEntry.getDate()); // Date
            values.put(KEY_CATEGORY, diaryEntry.getCategory()); // Category

            // Inserting Row
            DB.insert(TABLE_ENTRIES, "null", values);
            DB.close(); // Closing database connection

    }

    // Getting single row
    public DiaryEntry getDiaryEntry(int id) {
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = DB.query(TABLE_ENTRIES, new String[]{KEY_ID,
                        KEY_FOOD, KEY_CALORIES, KEY_DATE, KEY_CATEGORY}, KEY_ID + "=? ",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DiaryEntry diaryEntry = new DiaryEntry(
                cursor.getString(0),
                Integer.parseInt(cursor.getString(1)),
                cursor.getString(2),
                cursor.getString(3)
        );

        // return row
        return diaryEntry;
    }
    // Getting All Entries
    public ArrayList<DiaryEntry> getAllEntries() {
        ArrayList<DiaryEntry> entriesList = new ArrayList<DiaryEntry>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ENTRIES;

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DiaryEntry diaryEntry = new DiaryEntry();
                diaryEntry.setID(Integer.parseInt(cursor.getString(0)));
                diaryEntry.setFoodType(cursor.getString(1));
                diaryEntry.setCalories(cursor.getInt(2));
                diaryEntry.setDate(cursor.getString(3));
                diaryEntry.setCategory(cursor.getString(4));
                // Adding contact to list
                entriesList.add(diaryEntry);
            } while (cursor.moveToNext());
        }

        // return contact list
        return entriesList;
    }

    // Getting Breakfast
    public ArrayList<DiaryEntry> getAllEntries() {
        ArrayList<DiaryEntry> entriesList = new ArrayList<DiaryEntry>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ENTRIES;

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DiaryEntry diaryEntry = new DiaryEntry();
                diaryEntry.setID(Integer.parseInt(cursor.getString(0)));
                diaryEntry.setFoodType(cursor.getString(1));
                diaryEntry.setCalories(cursor.getInt(2));
                diaryEntry.setDate(cursor.getString(3));
                diaryEntry.setCategory(cursor.getString(4));
                // Adding contact to list
                entriesList.add(diaryEntry);
            } while (cursor.moveToNext());
        }

        // return contact list
        return entriesList;
    }

    // Getting entries Count
    public int getEntriesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ENTRIES;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single contact
    public int updateDiaryEntry(DiaryEntry diaryEntry) {
        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOOD, diaryEntry.getFoodType()); // Food Type
        values.put(KEY_CALORIES, diaryEntry.getCalories()); // Calories
        values.put(KEY_DATE, diaryEntry.getDate()); // Date
        values.put(KEY_CATEGORY, diaryEntry.getCategory()); // Category

        // updating row
        return DB.update(TABLE_ENTRIES, values, KEY_ID + " = ?",
                new String[]{String.valueOf(diaryEntry.getID())});
    }

    // Deleting single  row
    public void deleteDiaryEntry(DiaryEntry diaryEntry) {
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.delete(TABLE_ENTRIES, KEY_ID + " = ?",
                new String[]{String.valueOf(diaryEntry.getID())});
        DB.close();
    }

}



