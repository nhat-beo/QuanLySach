package com.example.nhatntph10460_duanmau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nhatntph10460_duanmau.R;
import com.example.nhatntph10460_duanmau.model.InforBill;
import com.example.nhatntph10460_duanmau.model.InforBook;
import com.example.nhatntph10460_duanmau.model.InforUser;

import java.util.List;

public class BillAdapter extends BaseAdapter {
    Context context;
    List<InforBill> listBill;

    public BillAdapter(Context context, List<InforBill> listBill) {
        this.context = context;
        this.listBill = listBill;
    }

    @Override
    public int getCount() {
        return listBill.size();
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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_row, parent, false);
        TextView txtIdBill = convertView.findViewById(R.id.txtIdBill);
        TextView txtNameBill = convertView.findViewById(R.id.txtNameBill);
        TextView txtPriceBill = convertView.findViewById(R.id.txtPriceBill);
        TextView txtDateBill = convertView.findViewById(R.id.txtDateBill);
        InforBill inforBill = listBill.get(position);
        txtIdBill.setText("ID: " + inforBill.idBill);
        txtNameBill.setText("Username: " + inforBill.nameBill);
        txtPriceBill.setText("Password: " + inforBill.price);
        txtDateBill.setText("Ngày bán: " + inforBill.date);
        return convertView;
    }
}
