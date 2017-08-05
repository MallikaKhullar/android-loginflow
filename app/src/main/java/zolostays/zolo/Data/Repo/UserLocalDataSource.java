package zolostays.zolo.Data.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by mallikapriyakhullar on 02/08/17.
 */

@Singleton
public class UserLocalDataSource implements UserDataSource {

    private SQLiteHandler mDbHelper;

    @Inject
    public UserLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
        mDbHelper = new SQLiteHandler(context);
    }

    @Override
    public UserObject getUserWithEmail(@NonNull String email) {
        return getUser(email);
    }

    @Override
    public void getUserWithEmail(@NonNull String givenEmail, @NonNull GetUserCallback callback) {
        UserObject userObject = getUser(givenEmail);
        if (userObject != null) callback.onUserFound(userObject);
        else callback.onDataNotAvailable();
    }

    private UserObject getUser(String givenEmail){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = { SQLiteHandler.USER_COL_EMAIL, SQLiteHandler.USER_COL_PASS};

        String selection = SQLiteHandler.USER_COL_EMAIL + " LIKE ?";
        String[] selectionArgs = { givenEmail.trim() };

        Cursor c = db.query(
                SQLiteHandler.USER_TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        UserObject userObject = null;

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            String email = c.getString(c.getColumnIndexOrThrow(SQLiteHandler.USER_COL_EMAIL));
            String pass =
                    c.getString(c.getColumnIndexOrThrow(SQLiteHandler.USER_COL_PASS));
            userObject = new UserObject(email,pass);
        }
        if (c != null) c.close();
        db.close();

        return userObject;
    }

    @Override
    public long createUser(@NonNull UserObject user) {
        checkNotNull(user);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHandler.USER_COL_NAME, user.getName());
        contentValues.put(SQLiteHandler.USER_COL_EMAIL, user.getEmail());
        contentValues.put(SQLiteHandler.USER_COL_PHONE, user.getPhone());
        contentValues.put(SQLiteHandler.USER_COL_PASS, user.getPass());
        long success = db.insert(SQLiteHandler.USER_TABLE_NAME, null, contentValues);
        db.close();
        return success;
    }



    @Override
    public void updateUserDetails(@NonNull String email, @NonNull String pass) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SQLiteHandler.USER_COL_PASS, pass);

        String selection = SQLiteHandler.USER_COL_EMAIL + " LIKE ?";
        String[] selectionArgs = {email};

        db.update(SQLiteHandler.USER_TABLE_NAME, values, selection, selectionArgs);
        db.close();
    }

    @Override
    public void updateUserDetails(@NonNull Long id, @NonNull String email, @NonNull String name, @NonNull String phone) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SQLiteHandler.USER_COL_EMAIL, email);
        values.put(SQLiteHandler.USER_COL_NAME, name);
        values.put(SQLiteHandler.USER_COL_PHONE, phone);

        String selection = SQLiteHandler.USER_COL_ID + "=" + id;

        db.update(SQLiteHandler.USER_TABLE_NAME, values, selection, null);
        db.close();
    }
}

