package com.nicofrnds02734.cocobakery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nicofrnds02734.cocobakery.Adapter.AdapterTransaksi;
import com.nicofrnds02734.cocobakery.Adapter.SliderAdapter;
import com.nicofrnds02734.cocobakery.Database.DataHalperTransaksi;
import com.nicofrnds02734.cocobakery.Model.ModelTransaksi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    ListView tv_list;
    CardView transaksi, produk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        produk = findViewById(R.id.produk);
        transaksi = findViewById(R.id.transaksi);

        produk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProdukActivity.class));
                overridePendingTransition(0,0);
            }
        });
        transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TransaksiActivity.class));
                overridePendingTransition(0,0);
            }
        });
    }
}