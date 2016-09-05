package com.example.user.myfatnessbully;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 05/09/2016.
 */
public class SqlHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "foodDiary";

    // Contacts table name
    private static final String TABLE_ENTRIES = "foodEntry";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FOOD = "food_type";
    private static final String KEY_CALORIES = "calories";
    private static final String KEY_DATE = "date";

    public SqlHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ENTRIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FOOD + " TEXT," +
                KEY_CALORIES + "INT," + KEY_DATE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENTRIES);

        // Create tables again
        onCreate(db);
    }

        // Adding new row entry
    public void addFoodEntry(FoodEntry foodEntry){
    }

    // Getting single contact
    public FoodEntry getFoodEntry(int id) {
    }

    // Getting All Contacts
    public List<FoodEntry> getAllFoodEntries() {
    }

    // Getting food entries Count
    public int getFoodEntriesCount() {
    }

    // Updating single contact
    public int updateFoodEntry(foodEntry contact) {
    }

    // Deleting single contact
    public void deleteContact(Contact contact) {

    }
}



