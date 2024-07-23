package com.example.mvvm.view;



import static com.example.mvvm.constants.MYSHAREDPREF;
import static com.example.mvvm.constants.SAVED_PROFILE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvvm.model.UserProfileModel;
import com.google.gson.Gson;

public class SharedPref {

    private static SharedPref instance;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(MYSHAREDPREF, Context.MODE_PRIVATE);

    }

    public static synchronized SharedPref getInstance(Context context) {

        if (instance == null) {
            instance = new SharedPref(context.getApplicationContext());
        }

        return instance;
    }



    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void saveUserProfile(UserProfileModel userProfile) {
        Gson gson = new Gson();
        editor = sharedPreferences.edit();
        String userProfileJson = gson.toJson(userProfile);
        editor.putString(SAVED_PROFILE, userProfileJson);
        editor.apply();
    }

}