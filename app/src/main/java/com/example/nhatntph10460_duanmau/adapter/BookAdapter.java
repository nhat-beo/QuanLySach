package com.example.nhatntph10460_duanmau.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.nhatntph10460_duanmau.R;
import com.example.nhatntph10460_duanmau.model.InforBook;
import com.example.nhatntph10460_duanmau.ui.FixBookActivity;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    Context context;
    List<InforBook> listBook;
    ImageView btnEdit;
    public BookAdapter(Context context, List<InforBook> listBook) {
        this.context = context;
        this.listBook = listBook;
    }

    @Override
    public int getCount() {
        return listBook.size();
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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_row, parent, false);
        TextView txtIdBook = convertView.findViewById(R.id.txtIdBook);
        TextView txtNameBook = convertView.findViewById(R.id.txtNameBook);
        TextView txtType = convertView.findViewById(R.id.txtType);
        TextView txtAuthor = convertView.findViewById(R.id.txtAuthor);
        TextView txtAmount = convertView.findViewById(R.id.txtAmount);
        TextView txtImportPrice = convertView.findViewById(R.id.txtImportPrice);
        TextView txtPrice = convertView.findViewById(R.id.txtPrice);
        TextView txtDate = convertView.findViewById(R.id.txtDate);
        InforBook inforBook = listBook.get(position);
        txtIdBook.setText("Mã sách: " + inforBook.idBook);
        txtNameBook.setText("Tên sách: " + inforBook.nameBook);
        txtType.setText("Thể loại: " + inforBook.type);
        txtAuthor.setText("Tác giả: " + inforBook.author);
        txtAmount.setText("Số lượng: " + inforBook.amount);
        txtImportPrice.setText("Gía nhập: " + inforBook.importPrice);
        txtPrice.setText("Gía bán: " + inforBook.price);
        txtDate.setText("Ngày bán: " +  inforBook.date);
        return convertView;
    }
}
