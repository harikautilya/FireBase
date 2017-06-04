package com.example.kautilya.firebase.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by mahe on 4/8/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    Context context;
    ArrayList<String> actors;



    public static String name="MainData";

    //Creating a table to store number of people in the backend
    private String table1="Actors";
    private String table1_col1="ID";
    private String table1_col2="NAME";


    public DBHelper(Context context) {
        super(context, name, null, 0);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE "+table1+" ( "
                 + table1_col1+" text,"
                 + table1_col2 +" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+table1+" IF EXISTS");
        this.onCreate(db);
    }

    public ArrayList<String> getActors()
    {
        
    }
}
