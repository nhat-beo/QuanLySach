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
import com.example.nhatntph10460_duanmau.adapter.BillAdapter;
import com.example.nhatntph10460_duanmau.model.InforBill;

import java.util.ArrayList;
import java.util.List;

public class BillManagementActivity extends AppCompatActivity {
    ListView listView;
    List<InforBill> inforBillList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_management);
        Toolbar toolbar = findViewById(R.id.toolbar_bill);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView icAdd = findViewById(R.id.ic_add_bill);
        icAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BillManagementActivity.this, AddBillActivity.class));
            }
        });

        listView = findViewById(R.id.lvBill);
        for (int i = 0; i < 50; i++) {
            InforBill inforBill = new InforBill();
            inforBill.idBill = i + 1;
            inforBill.nameBill = "PH-Truyện " + (i + 1);
            inforBill.price = 28000;
            inforBill.date = "30/09/2020";
            inforBillList.add(inforBill);
        }
        BillAdapter billAdapter = new BillAdapter(this, inforBillList);
        listView.setAdapter(billAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BillManagementActivity.this);
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
                        startActivity(new Intent(BillManagementActivity.this, FixBillActivity.class));
                        Toast.makeText(getApplicationContext(), "Chuyển màn hình", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(BillManagementActivity.this, BillDetailActivity.class));
            }
        });
    }
}