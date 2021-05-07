package com.nicofrnds02734.cocobakery.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nicofrnds02734.cocobakery.Model.DataModelProduk;
import com.nicofrnds02734.cocobakery.Model.ModelTransaksi;
import com.nicofrnds02734.cocobakery.R;

import java.util.List;

public class AdapterTransaksi extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ModelTransaksi> daftar;
    public AdapterTransaksi(Activity activity, List<ModelTransaksi> items){
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
        view = inflater.inflate(R.layout.list_transaksi, parent, false);

        TextView tvNama, tvHarga, tvBarang, tvAlamat;

        tvNama = view.findViewById(R.id.tvNama);
        tvHarga = view.findViewById(R.id.tvHarga);
        tvBarang = view.findViewById(R.id.tvBarang);
        tvAlamat = view.findViewById(R.id.tvAlamat);

        ModelTransaksi tampil = daftar.get(position);
        tvNama.setText(tampil.nama);
        tvHarga.setText(tampil.harga);
        tvBarang.setText(tampil.namabarang);
        tvAlamat.setText(tampil.alamat);
        return view;
    }
}
