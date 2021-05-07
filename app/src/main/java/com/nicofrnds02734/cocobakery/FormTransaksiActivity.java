package com.nicofrnds02734.cocobakery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nicofrnds02734.cocobakery.Database.DataHalperTransaksi;
import com.nicofrnds02734.cocobakery.Model.ModelTransaksi;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class FormTransaksiActivity extends AppCompatActivity implements LocationListener {
    ActionBar actionBar;
    TextView notrans, namamenu, jumlah, hargasatuan, totalharga, harga,
            status;
    ImageView gmbrmenu, gmbralamat;
    DataHalperTransaksi db;
    EditText catatan, nama, alamats;
    String id, tnamabarang, tharga;
    Button btn_konfirbayar;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_transaksi);
        notrans = findViewById(R.id.notrans);
        alamats = findViewById(R.id.alamat);
        catatan = findViewById(R.id.catatan);
        gmbralamat = findViewById(R.id.gmbralamat);
        hargasatuan = findViewById(R.id.totalharga);
        btn_konfirbayar = findViewById(R.id.btn_konfirbayar);
        namamenu = findViewById(R.id.namamenu);
        nama = findViewById(R.id.nama);
        totalharga = findViewById(R.id.totalharga);
        gmbrmenu = findViewById(R.id.gmbrmenu);
        gmbralamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormTransaksiActivity.this, LokasiSekarangActivity.class));
            }
        });
         id = getIntent().getStringExtra("id");
         tnamabarang = getIntent().getStringExtra("nama");
         tharga = getIntent().getStringExtra("harga");
         notrans.setText("WM-000" + id);
        namamenu.setText(tnamabarang);
        hargasatuan.setText(tharga);
        //visibile selesai
        grantpermission();
        cekLokasiAdaTidak();
        getLocation();
        db = new DataHalperTransaksi(this);

        btn_konfirbayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bayarlah();
            }
        });
    }

    private void bayarlah() {
        String cats = catatan.getText().toString();
        String namapemesan = nama.getText().toString();
        String alamatq = alamats.getText().toString();
        db.TambahData(new ModelTransaksi(null, namapemesan, tnamabarang, tharga, alamatq, cats));
        Toast.makeText(FormTransaksiActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(FormTransaksiActivity.this, TransaksiActivity.class));
    }

    private void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 50,(LocationListener) this);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    private void cekLokasiAdaTidak() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gpsenabled = false;
        boolean networkEnabled = false;

        try {
            gpsenabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            networkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (!gpsenabled && !networkEnabled){
            new AlertDialog.Builder(FormTransaksiActivity.this)
                    .setTitle("Nyalakan GPS Servis")
                    .setCancelable(false)
                    .setPositiveButton("Nyalakan", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    }).setNegativeButton("Batal", null)
                    .show();
        }
    }

    private void grantpermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
            getLocation();
        }
    }
    //lokasinya
    @Override
    public void onLocationChanged(Location location) {
        try {
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> alamat = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

//            lokasiuser.setText(alamat.get(0).getSubAdminArea());
            alamats.setText(alamat.get(0).getAddressLine(0));

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Lokasi Error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}