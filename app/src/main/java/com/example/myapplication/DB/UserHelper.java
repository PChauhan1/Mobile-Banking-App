package com.example.myapplication.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.myapplication.DB.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        //Insert the SQl statement
        db.execSQL("insert into " + TABLE_NAME+" values(5643,'Tanu Chauhan','tanu@gamil.com','6754','98675483',10000)");
        db.execSQL("insert into " + TABLE_NAME+" values(4633,'Poornima','poornima@gamil.com','1354','765846333',9000)");
        db.execSQL("insert into " + TABLE_NAME+" values(7624,'Rupa Chauhan','rupa@gamil.com','6754','98675483',8700)");
        db.execSQL("insert into " + TABLE_NAME+" values(5643,'Nitin Rajput','nitinj@gamil.com','3452','876954673',7400)");
        db.execSQL("insert into " + TABLE_NAME+" values(8965,'Kush Jain','jain@gamil.com','1258','765839024',5400)");
        db.execSQL("insert into " + TABLE_NAME+" values(2167,'Sanjeev Pawar','Pawar@gamil.com','1264','768594375',5200)");
        db.execSQL("insert into " + TABLE_NAME+" values(2674,'Happy','Happy@gamil.com','54632','756749375',3300)");
        db.execSQL("insert into " + TABLE_NAME+" values(3456,'Sharry','sharry@gamil.com','1544','6758456327',4300)");
        db.execSQL("insert into " + TABLE_NAME+" values(8752,'Tommy','Tommy@gamil.com','7621','675905463',5900)");
        db.execSQL("insert into " + TABLE_NAME+" values(5632,'Kristi','kristi@gamil.com','7869','8769679435',4600)");
        db.execSQL("insert into " + TABLE_NAME+" values(7890,'Joe','joe@gamil.com','9765','786653455',6340)");
        db.execSQL("insert into " + TABLE_NAME+" values(5641,'Leo','Leo@gamil.com','1453','768930546',1500)");

    }

        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}