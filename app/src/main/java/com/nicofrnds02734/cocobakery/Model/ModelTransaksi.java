package com.nicofrnds02734.cocobakery.Model;

public class ModelTransaksi {
    public String id;
    public String nama;
    public String namabarang;
    public String harga;
    public String alamat;
    public String catatan;

    public ModelTransaksi(String id, String nama, String namabarang, String harga, String alamat, String catatan) {
        this.id = id;
        this.nama = nama;
        this.namabarang = namabarang;
        this.harga = harga;
        this.alamat = alamat;
        this.catatan = catatan;
    }

    public ModelTransaksi() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
