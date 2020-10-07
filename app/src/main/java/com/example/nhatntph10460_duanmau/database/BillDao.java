package com.example.nhatntph10460_duanmau.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhatntph10460_duanmau.model.InforBill;
import com.example.nhatntph10460_duanmau.model.InforType;

import java.util.ArrayList;
import java.util.List;

public class BillDao {
    //Các câu lệnh truy vấn với bảng Dao
    private MySQLite mySQLite;

    public BillDao(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public void deleteBill(String idBill) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        sqLiteDatabase.delete("Type", "idBill=?", new String[]{idBill});
    }

    public long insertBill(InforBill bill) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idBill", bill.idBill);
        contentValues.put("idBook", bill.idBook);
        contentValues.put("nameBook", bill.nameBook);
        contentValues.put("type", bill.type);
        contentValues.put("employ", bill.employee);
        contentValues.put("amountBook", bill.amountBook);
        contentValues.put("price", bill.price);
        contentValues.put("dateOfSale", bill.date);

        return sqLiteDatabase.insert("Bill", null, contentValues);
    }

    public List<InforBill> getAllBill() {
        List<InforBill> inforBillList = new ArrayList<>();

        String truyVan = "select * from " + MySQLite.TABLE_BILL;
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                int idBill = cursor.getInt(cursor.getColumnIndex("idBill"));
                int idBook = cursor.getInt(cursor.getColumnIndex("idBook"));
                String nameBook = cursor.getString(cursor.getColumnIndex("nameBook"));
                String type = cursor.getString(cursor.getColumnIndex("type"));
                String employee = cursor.getString(cursor.getColumnIndex("employee"));
                int amountBook = cursor.getInt(cursor.getColumnIndex("amountBook"));
                Double price = cursor.getDouble(cursor.getColumnIndex("price"));
                String date = cursor.getString(cursor.getColumnIndex("date"));

                InforBill inforBill = new InforBill();
                inforBill.idBill = idBill;
                inforBill.idBook = idBook;
                inforBill.nameBook = nameBook;
                inforBill.type = type;
                inforBill.employee = employee;
                inforBill.amountBook = amountBook;
                inforBill.price = price;
                inforBill.date = date;

                inforBillList.add(inforBill);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return inforBillList;
    }

    public int updateBill(InforBill bill) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idBook", bill.idBook);
        contentValues.put("nameBook", bill.nameBook);
        contentValues.put("type", bill.type);
        contentValues.put("employ", bill.employee);
        contentValues.put("amountBook", bill.amountBook);
        contentValues.put("price", bill.price);
        contentValues.put("dateOfSale", bill.date);

        return sqLiteDatabase.update("Bill", contentValues, "idBill=?", new String[]{String.valueOf(bill.idBill)});
    }

    //Check exists
    public boolean checkExistsBill(InforBill bill) {
        //Kiểm tra type đã tồn tại hay chưa
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        String checkBill = "select * from " + MySQLite.TABLE_BILL + " where " + MySQLite.COL_IDBILL + "=" + bill.idBill;
        Cursor cursor = sqLiteDatabase.rawQuery(checkBill, null);
        sqLiteDatabase.close();
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
