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
import com.example.nhatntph10460_duanmau.adapter.TypeAdapter;
import com.example.nhatntph10460_duanmau.model.InforBill;
import com.example.nhatntph10460_duanmau.model.InforType;

import java.util.ArrayList;
import java.util.List;

public class TypeManagementActivity extends AppCompatActivity {
    ListView listView;
    List<InforType> inforTypeList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_management);
        Toolbar toolbar = findViewById(R.id.toolbar_type);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView icAdd = findViewById(R.id.ic_add_type);
        icAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TypeManagementActivity.this, AddTypeActivity.class));
            }
        });

        listView = findViewById(R.id.lvType);
        for (int i = 0; i < 50; i++) {
            InforType inforType = new InforType();
            inforType.idType = i + 1;
            inforType.nameType = "Truyện tranh ";
            inforType.amountTpye = 150;
            inforTypeList.add(inforType);
        }
        TypeAdapter typeAdapter = new TypeAdapter(this, inforTypeList);
        listView.setAdapter(typeAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TypeManagementActivity.this);
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
                        startActivity(new Intent(TypeManagementActivity.this, FixTypeActivity.class));
                        Toast.makeText(getApplicationContext(), "Chuyển màn hình", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
                return false;
            }
        });
    }
}