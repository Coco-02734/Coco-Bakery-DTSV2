package com.nicofrnds02734.cocobakery.Model;

public class DataModelProduk {
    public String id;
    public String nama;
    public String harga;

    public DataModelProduk(String id, String nama, String harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }
    public DataModelProduk(){

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

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
