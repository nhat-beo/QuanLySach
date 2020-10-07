package com.example.nhatntph10460_duanmau.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MySQLite extends SQLiteOpenHelper {
    public MySQLite(@Nullable Context context) {
        super(context, "PhuongNam.db", null, 1);
    }

    //Bảng User
    public static final String TABLE_USER = "User";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    public static final String COL_EMAIL = "email";

    //Bảng Sách
    public static final String TABLE_BOOK = "Book";
    public static final String COL_IDBOOK = "idBook";
    public static final String COL_NAMEBOOK = "NameBook";
    public static final String COL_TYPE = "type";
    public static final String COL_AUTHOR = "author";
    public static final String COL_AMOUNTBOOK = "amountBook";
    public static final String COL_IMPORTPRICE = "improtPrice";
    public static final String COL_PRICE = "price";
    public static final String COL_DATEADD = "dateAdd";

    //Bảng Thể loại
    public static final String TABLE_TYPE = "Type";
    public static final String COL_IDTYPE = "idType";
    public static final String COL_NAMETYPE = "nameType";
    public static final String COL_AMOUNTTYPE = "amountType";

    //Bảng Hóa đơn
    public static final String TABLE_BILL = "Bill";
    public static final String COL_IDBILL = "idBill";
    public static final String COL_NAMEBILL = "nameBill";
    public static final String COL_PRICEBILL = "priceBill";
    public static final String COL_DATEOFSALE = "dateOfSale";

    //Bảng Hóa đơn chi tiết
    public static final String TABLE_BILLDETAIL = "BillDetail";
    public static final String COL_IDILLDETAIL = "idBillDetail";
    public static final String COL_IDBOOKDETAIL = "idBookDetail";
    public static final String COL_NAMEBOOKDETAIL = "nameBookDetail";
    public static final String COL_TYPEBOOKDETAIL = "typeBookDetail";
    public static final String COL_PRICEDETAIL = "priceDetail";
    public static final String COL_AMOUNTBOOKDETAIL = "amountBookDetail";
    public static final String COL_EMPLOYEEDETAIL = "employeeDetail";
    public static final String COL_DATEOFSALEDETAIL = "dateOfSaleDetail";

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tạo bảng User
        final String CREATE_USER = "create table " + TABLE_USER
                + " (" + COL_USERNAME + " text primary key, "
                + COL_PASSWORD + " text, "
                + COL_EMAIL + " text)";
        db.execSQL(CREATE_USER);

        //Tạo bảng Sách
        final String CREAT_BOOK = "create table " + TABLE_BOOK
                + " (" + COL_IDBOOK + " int primary key autoincrement, "
                + COL_NAMEBOOK + " text, "
                + COL_TYPE + " text, "
                + COL_AUTHOR + " text, "
                + COL_AMOUNTBOOK + " int, "
                + COL_IMPORTPRICE + " double, "
                + COL_PRICE + " double, "
                + COL_DATEADD + " text)";
        db.execSQL(CREAT_BOOK);

        //Tạo bảng thể loại
        final String CREATE_TYPE = "create table " + TABLE_TYPE
                + " (" + COL_IDTYPE + " int primary key autoincrement, "
                + COL_NAMETYPE + " text, "
                + COL_AMOUNTTYPE + " int)";
        db.execSQL(CREATE_TYPE);

        //Tạo bảng Hóa đơn
        final String CREATE_BILL = "create table " + TABLE_BILL
                + " (" + COL_IDBILL + " int primary key autoincrement, "
                + COL_NAMEBILL + " text, "
                + COL_PRICEBILL + " double, "
                + COL_DATEOFSALE + " text)";
        db.execSQL(CREATE_BILL);

        //Tạo bảng Hóa đơn chi tiết
        final String CREATE_BILL_DETAIL = "create table " + TABLE_BILLDETAIL
                + " (" + COL_IDILLDETAIL + " int primary key autoincrement, "
                + COL_IDBOOKDETAIL + " int, "
                + COL_NAMEBOOKDETAIL + " text, "
                + COL_TYPEBOOKDETAIL + " text, "
                + COL_PRICEDETAIL + " double, "
                + COL_AMOUNTBOOKDETAIL + " text, "
                + COL_EMPLOYEEDETAIL + " text, "
                + COL_DATEOFSALEDETAIL + " text)";
        db.execSQL(CREATE_BILL_DETAIL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_USER);
        db.execSQL("drop table if exists " + TABLE_BOOK);
        db.execSQL("drop table if exists " + TABLE_TYPE);
        db.execSQL("drop table if exists " + TABLE_BILL);
        db.execSQL("drop table if exists " + TABLE_BILLDETAIL);
        onCreate(db);
    }
}
