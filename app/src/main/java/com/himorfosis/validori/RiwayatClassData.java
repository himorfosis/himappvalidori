package com.himorfosis.validori;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by him on 7/17/2018.
 */

public class RiwayatClassData {

    private Integer id;
    private String namaproduk;
    private String kadaluarsa;
    private String beratbersih;
    private String komposisi;
    private String diproduksi;
    private String sertifikasi;
    private String anjuran;
    private String waktu;
    private String validasi;

    RiwayatClassData (Integer id, String namaproduk, String kadaluarsa, String beratbersih,
                      String komposisi, String diproduksi, String sertifikasi, String anjuran, String waktu, String validasi) {

        super();
        this.id = id;
        this.namaproduk = namaproduk;
        this.kadaluarsa = kadaluarsa;
        this.beratbersih = beratbersih;
        this.komposisi = komposisi;
        this.diproduksi = diproduksi;
        this.sertifikasi = sertifikasi;
        this.anjuran = anjuran;
        this.waktu = waktu;
        this.validasi = validasi;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaproduk() {
        return namaproduk;
    }

    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }

    public String getKadaluarsa() {
        return kadaluarsa;
    }

    public void setKadaluarsa(String kadaluarsa) {
        this.kadaluarsa = kadaluarsa;
    }

    public String getBeratbersih() {
        return beratbersih;
    }

    public void setBeratbersih(String beratbersih) {
        this.beratbersih = beratbersih;
    }

    public String getKomposisi() {
        return komposisi;
    }

    public void setKomposisi(String komposisi) {
        this.komposisi = komposisi;
    }

    public String getDiproduksi() {
        return diproduksi;
    }

    public void setDiproduksi(String diproduksi) {
        this.diproduksi = diproduksi;
    }

    public String getSertifikasi() {
        return sertifikasi;
    }

    public void setSertifikasi(String sertifikasi) {
        this.sertifikasi = sertifikasi;
    }

    public String getAnjuran() {
        return anjuran;
    }

    public void setAnjuran(String anjuran) {
        this.anjuran = anjuran;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getValidasi() {
        return validasi;
    }

    public void setValidasi(String validasi) {
        this.validasi = validasi;
    }

//    private Integer id_produk;
//    private String kode;
//    private String waktu;
//    private String validasi;
//    private String nama;
//
//    public RiwayatClassData(Integer id_produk, String kode, String nama, String waktu,  String validasi) {
//
//        this.id_produk = id_produk;
//        this.kode = kode;
//        this.nama = nama;
//        this.validasi = validasi;
//        this.waktu = waktu;
//
//    }
//
//    public Integer getId_produk() {
//        return id_produk;
//    }
//
//    public String getKode() {
//        return kode;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public String getWaktu() {
//        return waktu = waktu;
//    }
//
//    public String getValidasi() {
//        return validasi;
//    }


}
