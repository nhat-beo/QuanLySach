package com.example.nhatntph10460_duanmau.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhatntph10460_duanmau.adapter.UserAdapter;
import com.example.nhatntph10460_duanmau.model.InforUser;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

public class UserDao {
    //Các câu lệnh truy vấn với bảng User
    private MySQLite mySQLite;

    public UserDao(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public void deleteUser(String id) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        sqLiteDatabase.delete("User", "id=?", new String[]{id});
    }

    public long insertUser(InforUser user) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user.username);
        contentValues.put("password", user.password);
        contentValues.put("email", user.email);

        return sqLiteDatabase.insert("User", null, contentValues);
    }

    public List<InforUser> getallUser() {
        List<InforUser> inforUserList = new ArrayList<>();

        String truyVan = "select * from " + MySQLite.TABLE_USER;
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String username = cursor.getString(cursor.getColumnIndex("username"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
                String email = cursor.getString(cursor.getColumnIndex("email"));

                InforUser inforUser = new InforUser();
                inforUser.username = username;
                inforUser.password = password;
                inforUser.email = email;

                inforUserList.add(inforUser);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return inforUserList;
    }

    public int updateUser(InforUser user) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", user.password);
        contentValues.put("email", user.email);

        return sqLiteDatabase.update("User", contentValues, "username=?", new String[]{String.valueOf(user.username)});
    }

    //Check exists
    public boolean checkExistsUser(InforUser user) {
        //Kiểm tra user đã tồn tại hay chưa
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        String checkUser = "select * from " + MySQLite.TABLE_USER + " where " + MySQLite.COL_USERNAME + "=" + user.username;
        Cursor cursor = sqLiteDatabase.rawQuery(checkUser, null);
        sqLiteDatabase.close();
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
