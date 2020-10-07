package com.example.nhatntph10460_duanmau.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhatntph10460_duanmau.model.InforType;
import com.example.nhatntph10460_duanmau.model.InforUser;

import java.util.ArrayList;
import java.util.List;

public class TypeDao {
    //Các câu lệnh truy vấn với bảng Dao
    private MySQLite mySQLite;

    public TypeDao(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public void deleteType(String idType) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        sqLiteDatabase.delete("Type", "idType=?", new String[]{idType});
    }

    public long insertType(InforType type) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idType", type.idType);
        contentValues.put("nameType", type.nameType);
        contentValues.put("amountTpe", type.amountTpye);

        return sqLiteDatabase.insert("Type", null, contentValues);
    }

    public List<InforType> getAllType() {
        List<InforType> inforTypeList = new ArrayList<>();

        String truyVan = "select * from " + MySQLite.TABLE_TYPE;
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                int idType = cursor.getInt(cursor.getColumnIndex("id"));
                String nameType = cursor.getString(cursor.getColumnIndex("nameType"));
                int amountType = cursor.getInt(cursor.getColumnIndex("amountTpye"));

                InforType inforType = new InforType();
                inforType.idType = idType;
                inforType.nameType = nameType;
                inforType.amountTpye = amountType;

                inforTypeList.add(inforType);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return inforTypeList;
    }

    public int updateType(InforType type) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameType", type.nameType);
        contentValues.put("amountTpye", type.amountTpye);

        return sqLiteDatabase.update("Type", contentValues, "idType=?", new String[]{String.valueOf(type.idType)});
    }

    //Check exists
    public boolean checkExistsType(InforType type) {
        //Kiểm tra type đã tồn tại hay chưa
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        String checkType = "select * from " + MySQLite.TABLE_TYPE + " where " + MySQLite.COL_IDTYPE + "=" + type.idType;
        Cursor cursor = sqLiteDatabase.rawQuery(checkType, null);
        sqLiteDatabase.close();
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
