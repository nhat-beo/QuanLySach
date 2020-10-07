package com.example.nhatntph10460_duanmau.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhatntph10460_duanmau.model.InforBook;
import com.example.nhatntph10460_duanmau.model.InforUser;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    //Các câu lệnh truy vấn với bảng Book
    private MySQLite mySQLite;

    public BookDao(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public void deleteBook(String idBook) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        sqLiteDatabase.delete("Book", "idBook=?", new String[]{idBook});
    }

    public long insertBook(InforBook book) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idBook", book.idBook);
        contentValues.put("nameBook", book.nameBook);
        contentValues.put("type", book.type);
        contentValues.put("author", book.author);
        contentValues.put("amount", book.amount);
        contentValues.put("importPrice", book.importPrice);
        contentValues.put("price", book.price);
        contentValues.put("dateAdd", book.date);

        return sqLiteDatabase.insert("User", null, contentValues);
    }

    public List<InforBook> getallBook() {
        List<InforBook> inforBookList = new ArrayList<>();

        String truyVan = "select * from " + MySQLite.TABLE_BOOK;
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(truyVan, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                int idBook = cursor.getInt(cursor.getColumnIndex("idBook"));
                String nameBook = cursor.getString(cursor.getColumnIndex("nameBook"));
                String type = cursor.getString(cursor.getColumnIndex("type"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int amount = cursor.getInt(cursor.getColumnIndex("amount"));
                double importPrice = cursor.getDouble(cursor.getColumnIndex("importPrice"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                String dateAdd = cursor.getString(cursor.getColumnIndex("dateAdd"));

                InforBook inforBook = new InforBook();
                inforBook.idBook = idBook;
                inforBook.nameBook = nameBook;
                inforBook.type = type;
                inforBook.author = author;
                inforBook.amount = amount;
                inforBook.importPrice = importPrice;
                inforBook.price = price;
                inforBook.date = dateAdd;

                inforBookList.add(inforBook);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return inforBookList;
    }

    public int updateBook(InforBook book) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameBook", book.nameBook);
        contentValues.put("type", book.type);
        contentValues.put("author", book.author);
        contentValues.put("amount", book.amount);
        contentValues.put("importPrice", book.importPrice);
        contentValues.put("price", book.price);
        contentValues.put("dateAdd", book.date);

        return sqLiteDatabase.update("Book", contentValues, "idBook=?", new String[]{String.valueOf(book.idBook)});
    }
}
