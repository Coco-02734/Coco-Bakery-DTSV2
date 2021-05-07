package com.nicofrnds02734.cocobakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nicofrnds02734.cocobakery.Adapter.AdapterProduk;
import com.nicofrnds02734.cocobakery.Database.DataHalperProduk;
import com.nicofrnds02734.cocobakery.Model.DataModelProduk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProdukActivity extends AppCompatActivity {
    AdapterProduk adapter;
    DataHalperProduk db;
    FloatingActionButton fab;
    ListView tv_list;
    List<DataModelProduk> itemList = new ArrayList<>();
    public static final String KEY_ID = "id";
    public static final String NAMA = "nama";
    public static final String HARGA = "harga";
    public static ProdukActivity pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);

        db = new DataHalperProduk(this);
        tv_list = findViewById(R.id.tv_list);
        fab = findViewById(R.id.tambah);
        adapter = new AdapterProduk(ProdukActivity.this, itemList);
        tv_list.setAdapter(adapter);
        tampilData();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProdukActivity.this, TambahActivity.class));
                itemList.clear();
            }
        });

        pa = this;
    }

    public void tampilData() {
        ArrayList<HashMap<String, String>> row = db.getData();
        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(KEY_ID);
            String nama = row.get(i).get(NAMA);
            String harga = row.get(i).get(HARGA);
            DataModelProduk data = new DataModelProduk();
            data.setId(id);
            data.setNama(nama);
            data.setHarga(harga);
            itemList.add(data);
        }
        adapter.notifyDataSetChanged();
    }
}