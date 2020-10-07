package com.example.nhatntph10460_duanmau.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nhatntph10460_duanmau.R;
import com.example.nhatntph10460_duanmau.adapter.BookAdapter;
import com.example.nhatntph10460_duanmau.model.InforBook;

import java.util.ArrayList;
import java.util.List;

public class BookManagementActivity extends AppCompatActivity {
    ListView listView;
    List<InforBook> inforBooksList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_management);
        Toolbar toolbar = findViewById(R.id.toolbar_book);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView icAdd = findViewById(R.id.ic_add_book);
        icAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookManagementActivity.this, AddBookActivity.class));
            }
        });

        listView = findViewById(R.id.lvBook);
        for (int i = 0; i < 50; i++) {
            InforBook inforBook = new InforBook();
            inforBook.idBook = i + 1;
            inforBook.nameBook = "Doraemon";
            inforBook.type = "Truyện tranh";
            inforBook.author = "Fujiko F";
            inforBook.amount = 150;
            inforBook.importPrice = 10000;
            inforBook.price = 16000;
            inforBook.date = "30/09/2020";
            inforBooksList.add(inforBook);
        }
        BookAdapter bookAdapter = new BookAdapter(this, inforBooksList);
        listView.setAdapter(bookAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BookManagementActivity.this);
                builder.setMessage("Bạn muốn Sửa/Xóa?");
                builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setPositiveButton("Sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(BookManagementActivity.this, FixBookActivity.class));
                        Toast.makeText(getApplicationContext(), "Chuyển màn hình", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
                return false;
            }
        });
    }
}