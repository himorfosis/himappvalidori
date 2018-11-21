package com.himorfosis.validori;

public class ProdukClassData {

    //    TextView namaproduk, kadaluarsa, beratbersih, komposisi, diproduksi, sertifikasi, anjuran;
    private String id;
    private String namaproduk;
    private String kadaluarsa;
    private String beratbersih;
    private String komposisi;
    private String diproduksi;
    private String sertifikasi;
    private String anjuran;
    private Integer gambar;


    ProdukClassData (String id, String namaproduk, String kadaluarsa, Integer gambar, String beratbersih,
                     String komposisi, String diproduksi, String sertifikasi, String anjuran) {

        super();
        this.id = id;
        this.namaproduk = namaproduk;
        this.kadaluarsa = kadaluarsa;
        this.gambar = gambar;
        this.beratbersih = beratbersih;
        this.komposisi = komposisi;
        this.diproduksi = diproduksi;
        this.sertifikasi = sertifikasi;
        this.anjuran = anjuran;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getGambar() {
        return gambar;
    }

    public void setGambar(Integer gambar) {
        this.gambar = gambar;
    }
}
