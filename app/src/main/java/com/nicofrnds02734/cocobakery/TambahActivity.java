package com.nicofrnds02734.cocobakery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nicofrnds02734.cocobakery.Database.DataHalperProduk;
import com.nicofrnds02734.cocobakery.Model.DataModelProduk;

public class TambahActivity extends AppCompatActivity {
    EditText nama_produk, harga;
    Button btn_tambah;
    DataHalperProduk db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        nama_produk = findViewById(R.id.nama_produk);
        harga = findViewById(R.id.harga);
        btn_tambah = findViewById(R.id.btn_tambah);



        db = new DataHalperProduk(this);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String nama = nama_produk.getText().toString();
        String hargas = harga.getText().toString();
               db.TambahData(new DataModelProduk(null, nama, hargas));
               Toast.makeText(TambahActivity.this, "Data Kue "+ nama+" Disimpan", Toast.LENGTH_SHORT).show();
               ProdukActivity.pa.tampilData();
               finish();
                Toast.makeText(TambahActivity.this, nama + " " + hargas, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
