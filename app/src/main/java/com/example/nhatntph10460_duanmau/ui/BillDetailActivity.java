package com.example.nhatntph10460_duanmau.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nhatntph10460_duanmau.R;

public class BillDetailActivity extends AppCompatActivity {
    ImageView btnFixBill, btnDeleteBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
        btnFixBill = findViewById(R.id.ic_edit_bill);
        btnDeleteBill = findViewById(R.id.ic_delete_bill);

        btnFixBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BillDetailActivity.this, FixBillActivity.class));
                Toast.makeText(getApplicationContext(), "Chuyển màn hình", Toast.LENGTH_SHORT).show();
            }
        });

        btnDeleteBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Xóa dữ liệu thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}