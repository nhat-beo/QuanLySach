package com.example.nhatntph10460_duanmau.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nhatntph10460_duanmau.R;
import com.example.nhatntph10460_duanmau.adapter.UserAdapter;
import com.example.nhatntph10460_duanmau.model.InforUser;

import java.util.ArrayList;
import java.util.List;

public class UserManagementActivity extends AppCompatActivity {
    ListView listView;
    List<InforUser> inforUsersList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);

        listView = findViewById(R.id.lvUser);
        for (int i = 0; i < 50; i++) {
            InforUser inforUser = new InforUser();
            inforUser.username = "nhatbeo" + (i + 1);
            inforUser.password = "khongcopass";
            inforUsersList.add(inforUser);
        }
        UserAdapter userAdapter = new UserAdapter(this, inforUsersList);
        listView.setAdapter(userAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserManagementActivity.this);
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
                        startActivity(new Intent(UserManagementActivity.this, UserFixActivity.class));
                        Toast.makeText(getApplicationContext(), "Chuyển màn hình", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
                return false;
            }
        });
    }
}