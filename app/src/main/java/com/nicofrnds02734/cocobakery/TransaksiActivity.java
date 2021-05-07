package com.nicofrnds02734.cocobakery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.nicofrnds02734.cocobakery.Adapter.AdapterProduk;
import com.nicofrnds02734.cocobakery.Adapter.AdapterTransaksi;
import com.nicofrnds02734.cocobakery.Database.DataHalperProduk;
import com.nicofrnds02734.cocobakery.Database.DataHalperTransaksi;
import com.nicofrnds02734.cocobakery.Model.DataModelProduk;
import com.nicofrnds02734.cocobakery.Model.ModelTransaksi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransaksiActivity extends AppCompatActivity {
    DataHalperTransaksi db;
    ListView tv_list;
    AdapterTransaksi adapter;
    List<ModelTransaksi> itemList = new ArrayList<>();
    public static final String KEY_ID = "id";
    public static final String NAMA = "nama";
    public static final String NAMABARANG = "namabarang";
    public static final String HARGA = "harga";
    public static final String ALAMAT = "alamat";
    public static final String CATATAN = "catatan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
        db = new DataHalperTransaksi(this);
        tv_list = findViewById(R.id.listdata);
        adapter = new AdapterTransaksi(TransaksiActivity.this, itemList);
        tv_list.setAdapter(adapter);
        tampilData();
    }

    private void tampilData() {
        ArrayList<HashMap<String, String>> row = db.getData();
        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(KEY_ID);
            String nama = row.get(i).get(NAMA);
            String namabarang = row.get(i).get(NAMABARANG);
            String harga = row.get(i).get(HARGA);
            String alamat = row.get(i).get(ALAMAT);
            String catatan = row.get(i).get(CATATAN);
            ModelTransaksi data = new ModelTransaksi();
            data.setId(id);
            data.setNama(nama);
            data.setNamabarang(namabarang);
            data.setHarga(harga);
            data.setAlamat(alamat);
            data.setCatatan(catatan);
            itemList.add(data);
        }
        adapter.notifyDataSetChanged();
    }
}