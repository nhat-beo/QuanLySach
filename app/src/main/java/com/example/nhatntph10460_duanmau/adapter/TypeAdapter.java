package com.example.nhatntph10460_duanmau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nhatntph10460_duanmau.R;
import com.example.nhatntph10460_duanmau.model.InforType;

import java.util.List;

public class TypeAdapter extends BaseAdapter {
    Context context;
    List<InforType> listType;

    public TypeAdapter(Context context, List<InforType> listType) {
        this.context = context;
        this.listType = listType;
    }

    @Override
    public int getCount() {
        return listType.size();
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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_row, parent, false);
        TextView txtIdType = convertView.findViewById(R.id.txtIdType);
        TextView txtNameType = convertView.findViewById(R.id.txtNameType);
        TextView txtAmountType = convertView.findViewById(R.id.txtAmountType);
        InforType inforType = listType.get(position);
        txtIdType.setText("Mã thể loại: " + inforType.idType);
        txtNameType.setText("Tên thể loại: " + inforType.nameType);
        txtAmountType.setText("Số lượng: " + inforType.amountTpye);
        return convertView;
    }
}
