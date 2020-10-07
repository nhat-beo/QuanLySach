package com.example.nhatntph10460_duanmau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nhatntph10460_duanmau.R;
import com.example.nhatntph10460_duanmau.model.InforUser;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    Context context;
    List<InforUser> listUser;

    public UserAdapter(Context context, List<InforUser> listUser) {
        this.context = context;
        this.listUser = listUser;
    }

    @Override
    public int getCount() {
        return listUser.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        TextView txtID = convertView.findViewById(R.id.txtID);
        TextView txtUser = convertView.findViewById(R.id.txtUser);
        TextView txtPass = convertView.findViewById(R.id.txtPass);
        InforUser inforUser = listUser.get(position);
        txtID.setText("ID: " + inforUser.id);
        txtUser.setText("Username: " + inforUser.username);
        txtPass.setText("Password: " + inforUser.password);
        return convertView;
    }
}
