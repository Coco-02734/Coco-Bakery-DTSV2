package com.nicofrnds02734.cocobakery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nicofrnds02734.cocobakery.Adapter.AdapterProduk;
import com.nicofrnds02734.cocobakery.Adapter.SliderAdapter;
import com.nicofrnds02734.cocobakery.Database.DataHalperProduk;
import com.nicofrnds02734.cocobakery.Model.DataModelProduk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataHalperProduk db;

    ListView tv_list;
    ImageView notif;
    AdapterProduk adapter;
    FloatingActionButton fab;
    List<DataModelProduk> itemList = new ArrayList<>();
    public static final String KEY_ID = "id";
    public static final String NAMA = "nama";
    public static final String HARGA = "harga";
    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataHalperProduk(this);

        tv_list = findViewById(R.id.tv_list);
        notif = findViewById(R.id.notif);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdminActivity.class));
            }
        });

        tv_list = findViewById(R.id.tv_list);
        adapter = new AdapterProduk(MainActivity.this, itemList);
        tv_list.setAdapter(adapter);
        ma = this;
        tampilData();
        //Minta Ijin Lokasi
        IjinLokasiAktif();
    }

    private void IjinLokasiAktif() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
        }
    }

    private void tampilData() {
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