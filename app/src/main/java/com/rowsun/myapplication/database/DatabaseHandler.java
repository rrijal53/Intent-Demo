package com.rowsun.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;

import com.rowsun.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "broadway";
    public static final String TABLE_USER = "USER";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FULLNAME = "fullname";
    private static final String COLUMN_USERNAME = "userName";
    private static final String COLUMN_PASSWORD = "password";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE USER " +
                "(id integer PRIMARY KEY AUTOINCREMENT," +
                "fullname text," +
                "userName text," +
                "password text" +
                ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(sqLiteDatabase);
    }

    public long insertUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FULLNAME, u.getFullname());
        values.put(COLUMN_USERNAME, u.getUserName());
        values.put(COLUMN_PASSWORD, u.getPassword());
        long i = db.insert(TABLE_USER, null, values);
        Log.d("TAG", "Inserted " + i);
        db.close();
        return i;
    }

    public void updateUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FULLNAME, u.getFullname());
        values.put(COLUMN_USERNAME, u.getUserName());
        values.put(COLUMN_PASSWORD, u.getPassword());
//        String[] where = {u.getId() + ""};

        long i = db.update(TABLE_USER, values, "id = ?", new String[]{u.getId() + ""});
        Log.d("TAG", "UPDATED  " + i);
        db.close();
    }

    public void deleteUser(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long i = db.delete(TABLE_USER, "id = ?", new String[]{id});
        Log.d("TAG", "DELETED  " + i);
        db.close();
    }

    public List<User> getUserList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> list = new ArrayList<>();
        Cursor c = db.query(TABLE_USER, null, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String name= c.getString(1);
                String userNmae= c.getString(2);
                String password= c.getString(3);

                User u = new User(id,name,userNmae,password);
                list.add(u);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        Log.d("TAG", "LIST  " + list.size());

        return list;
    }


}
