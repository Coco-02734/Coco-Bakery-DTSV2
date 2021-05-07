package com.nicofrnds02734.cocobakery.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nicofrnds02734.cocobakery.FormTransaksiActivity;
import com.nicofrnds02734.cocobakery.Model.DataModelProduk;
import com.nicofrnds02734.cocobakery.R;

import java.util.List;

public class AdapterProduk extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<DataModelProduk> daftar;

    public AdapterProduk(Activity activity, List<DataModelProduk> items){
        this.activity = activity;
        this.daftar = items;
    }
    @Override
    public int getCount() {
        return daftar.size();
    }

    @Override
    public Object getItem(int position) {
        return daftar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item, parent, false);

        TextView nama, harga;
        RelativeLayout rev;

        nama = view.findViewById(R.id.tvNama);
        harga = view.findViewById(R.id.tvHarga);
        rev = view.findViewById(R.id.rev);
        DataModelProduk tampil = daftar.get(position);
        nama.setText(tampil.nama);
        harga.setText(tampil.harga);
        rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, FormTransaksiActivity.class);
                intent.putExtra("id",tampil.id);
                intent.putExtra("nama",tampil.nama);
                intent.putExtra("harga",tampil.harga);
                activity.startActivity(intent);
            }
        });
        return view;
    }
}
