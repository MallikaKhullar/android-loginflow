package zolostays.zolo.Data;


import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by mallikapriyakhullar on 02/08/17.
 */


public class SQLiteHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "zolo-assg.db";

    //USER TABLE
    public static final String USER_TABLE_NAME = "users";
    public static final String USER_COL_ID = "id";
    public static final String USER_COL_NAME = "usr_name";
    public static final String USER_COL_EMAIL = "usr_email";
    public static final String USER_COL_PASS = "usr_pass";
    public static final String USER_COL_PHONE = "usr_phone";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS "
            + USER_TABLE_NAME + "("
            + USER_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USER_COL_NAME + " VARCHAR(20), "
            + USER_COL_EMAIL + " VARCHAR(50), "
            + USER_COL_PHONE + " VARCHAR(50), "
            + USER_COL_PASS + " VARCHAR(50)) ";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // not implementing this @ v1 right now
    }
}