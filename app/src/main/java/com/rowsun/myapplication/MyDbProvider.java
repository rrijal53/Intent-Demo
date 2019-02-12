package com.rowsun.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.rowsun.myapplication.database.DatabaseHandler;

public class MyDbProvider extends ContentProvider {
    DatabaseHandler db;
    public static final String CONTENT_URI = "content://com.rowsun.myapplication/users";

    @Override
    public boolean onCreate() {
         db = new DatabaseHandler(getContext());
        return db != null;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return db.getReadableDatabase().query(DatabaseHandler.TABLE_USER,null, null, null, null, null, null );
    }


    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd.rowsun.users";

    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
    long id =    db.getWritableDatabase().insert(DatabaseHandler.TABLE_USER,null, contentValues);
        return Uri.parse(CONTENT_URI + "/" + id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {

        return 0;
    }
}
