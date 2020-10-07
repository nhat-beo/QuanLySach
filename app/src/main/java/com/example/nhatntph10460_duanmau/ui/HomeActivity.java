package com.example.nhatntph10460_duanmau.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.nhatntph10460_duanmau.R;

public class HomeActivity extends AppCompatActivity {
    CardView cardBill, cardType, cardUser, cardBook, cardStatis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cardBook = findViewById(R.id.cardBook);
        cardBill = findViewById(R.id.cardBill);
        cardType = findViewById(R.id.cardType);
        cardStatis = findViewById(R.id.cardStatis);
        cardUser = findViewById(R.id.cardUser);

        cardBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BookManagementActivity.class));
            }
        });

        cardBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BillManagementActivity.class));
            }
        });

        cardType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TypeManagementActivity.class));
            }
        });

        cardStatis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, StatisticalActivity.class));
            }
        });

        cardUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, UserManagementActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.quanLySach:
                startActivity(new Intent(HomeActivity.this, BookManagementActivity.class));
                break;

            case R.id.quanLyTheLoai:
                startActivity(new Intent(HomeActivity.this, TypeManagementActivity.class));
                break;

            case R.id.quanLyHoaDon:
                startActivity(new Intent(HomeActivity.this, BillManagementActivity.class));
                break;

            case R.id.quanLyNguoiDung:
                startActivity(new Intent(HomeActivity.this, UserManagementActivity.class));
                break;

            case R.id.thongKe:
                startActivity(new Intent(HomeActivity.this, StatisticalActivity.class));
                break;

            case R.id.dangXuat:
                startActivity(new Intent(HomeActivity.this, SignInActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}