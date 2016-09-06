package com.example.user.myfatnessbully;

import android.app.Application;

/**
 * Created by user on 05/09/2016.
 */
public class MainApplication extends Application {

    SqlHandler DB;

    @Override
    public void onCreate(){
        super.onCreate();
        DB= new SqlHandler(this);
    }
}
