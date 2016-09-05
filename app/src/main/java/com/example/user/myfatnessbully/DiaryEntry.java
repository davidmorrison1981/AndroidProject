package com.example.user.myfatnessbully;

import java.util.Date;

/**
 * Created by user on 05/09/2016.
 */
public class DiaryEntry {
    //private variables
    int id;
    String food_type;
    int calories;
    String date;

    // Empty constructor
    public DiaryEntry(){

    }
    // constructor
    public DiaryEntry(int id, String food_type, int calories, String date ){
        this.id = id;
        this.calories = calories;
        this.date = date;
    }

//    // constructor
//    public DiaryEntry(String food_type, String date){
//        this. = name;
////        this._phone_number = _phone_number;
//    }
    // getting ID
    public int getID(){
        return this.id;
    }

    // setting id
    public void setID(int id){
        this.id = id;
    }

    // getting food type
    public String getFoodType(){
        return this.food_type;
    }

    // setting name
    public void setFoodType(String food_type){
        this.food_type = food_type;
    }

    // getting calories
    public int calories(){
        return this.calories;
    }

    // setting calories
    public void setCalories(int calories){
        this.calories = calories;
    }
    // getting date
    public String getDate(){
        return this.date;
    }

    // setting date
    public void setDate(String date){
        this.date = date;
    }
}


