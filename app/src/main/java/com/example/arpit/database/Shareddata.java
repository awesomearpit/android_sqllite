package com.example.arpit.database;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Arpit on 05-Feb-18.
 */

public class Shareddata {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int mode=0;
    Context context;
    String Filename="ajfile";
    //to take the boolean variable name
    String data="data";
    //to create constructor for ajfile

    public Shareddata(Context context) {
        this.context = context;
        //to create shared prefrences file
        sharedPreferences=context.getSharedPreferences(Filename, mode);

        //to apply the curd operation of ajfile
        editor=sharedPreferences.edit();
    }

    //for the second time user
    public void secondtime()
    {
        // to change the boolean value as true
        editor.putBoolean(data, true);
        //to save the operation
        editor.commit();
    }

    //for first time user
    public void firsttime()
    {
        if(!this.defaultboolean())
        {
            Intent login=new Intent(context, LoginActivity.class);
            login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(login);
        }
    }

    private boolean defaultboolean() {
        return sharedPreferences.getBoolean(data, false);
    }
}
