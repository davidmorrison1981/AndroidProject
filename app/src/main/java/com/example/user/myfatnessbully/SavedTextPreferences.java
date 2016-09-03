package com.example.user.myfatnessbully;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 03/09/2016.
 */

public class SavedTextPreferences {

        private static final String PREF_SAVEDTEXT ="username";

        public static void setStoredText(Context context, String text){
            SharedPreferences sharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(context);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(PREF_SAVEDTEXT,text);
            editor.apply();

        }

        public static String getStoredText(Context context){
            SharedPreferences sharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(context);

            String text = sharedPreferences.getString(PREF_SAVEDTEXT,null);
            return text;
        }

    }

